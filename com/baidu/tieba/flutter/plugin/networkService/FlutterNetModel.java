package com.baidu.tieba.flutter.plugin.networkService;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.httpNet.HttpNetContext;
import com.baidu.tieba.flutter.plugin.networkService.NetworkServicePlugin;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.m.b;
import d.a.c.e.m.e;
import d.a.c.e.p.l;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class FlutterNetModel implements NetworkServicePlugin.NetModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TIMOUT_MIN = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public NetResponseCallback httpCallback;
    public String identifier;
    public boolean isChunk;
    public boolean isLoading;
    public boolean isNetOk;
    public String mHttpUrl;
    public HashMap<String, Object> mParamMap;
    public long startRequestTime;
    public NetAsyncTask task;
    public int timeout;
    public Runnable timeoutRunnable;

    /* loaded from: classes4.dex */
    public static class NetAsyncTask extends BdAsyncTask<Object, String, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FlutterNetModel flutterNetModel;
        public HttpNetContext httpNetContext;
        public boolean isCancle;
        public NetWork mNetWork;
        public long queneTime;

        public NetAsyncTask(FlutterNetModel flutterNetModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flutterNetModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mNetWork = null;
            this.isCancle = false;
            this.queneTime = 0L;
            this.flutterNetModel = flutterNetModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.isCancle = true;
                super.cancel(true);
                NetWork netWork = this.mNetWork;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                if (this.flutterNetModel.httpCallback != null) {
                    this.flutterNetModel.httpCallback.onHttpResponseMessage(null, null, -1, "cancle", "", this.flutterNetModel.identifier);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Object... objArr) {
            InterceptResult invokeL;
            String postNetData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objArr)) == null) {
                this.queneTime = System.currentTimeMillis() - this.flutterNetModel.getStartRequestTime();
                this.flutterNetModel.isLoading = true;
                this.mNetWork = new NetWork(this.flutterNetModel.getHttpUrl());
                HashMap<String, Object> paramMap = this.flutterNetModel.getParamMap();
                if (paramMap != null && !paramMap.isEmpty()) {
                    for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                        this.mNetWork.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                    }
                }
                if (this.flutterNetModel.getIsChunk() && paramMap != null) {
                    this.mNetWork.addPostData("debugfile", (byte[]) paramMap.get("debugfile"));
                    postNetData = this.mNetWork.postMultiNetData();
                } else {
                    postNetData = this.mNetWork.postNetData();
                }
                this.httpNetContext = this.mNetWork.getNetContext();
                publishProgress(postNetData);
                return postNetData;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, strArr) == null) {
                super.onProgressUpdate((Object[]) strArr);
                if (strArr == null || strArr.length <= 0) {
                    return;
                }
                this.flutterNetModel.isLoading = false;
                if (this.flutterNetModel.timeoutRunnable != null) {
                    e.a().removeCallbacks(this.flutterNetModel.timeoutRunnable);
                }
                HttpNetContext httpNetContext = this.httpNetContext;
                if (httpNetContext != null && httpNetContext.getResponse() != null && !this.isCancle && this.flutterNetModel.httpCallback != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("server", this.flutterNetModel.getHttpUrl());
                    hashMap.put(RetrieveTaskManager.KEY, this.flutterNetModel.getHttpUrl());
                    hashMap.put("state", this.httpNetContext.getStat().stat.f41209h);
                    if (this.httpNetContext.getPerformance() != null && this.flutterNetModel.getStartRequestTime() > 0 && this.httpNetContext.getPerformance().containsKey("startTime")) {
                        long f2 = b.f(this.httpNetContext.getPerformance().get("startTime"), 0L) - this.flutterNetModel.getStartRequestTime();
                        if (f2 > 0) {
                            this.httpNetContext.getPerformance().put("taskWaitTime", String.valueOf(f2));
                        }
                        if (this.queneTime < 20000) {
                            this.httpNetContext.getPerformance().put("queneTime", String.valueOf(this.queneTime));
                        }
                    }
                    this.flutterNetModel.httpCallback.onHttpResponseMessage(hashMap, this.httpNetContext.getPerformance(), this.httpNetContext.getResponse().mServerErrorCode, this.httpNetContext.getResponse().mErrorString, strArr[0], this.flutterNetModel.identifier);
                }
                this.flutterNetModel.resetAsyncTask();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface NetResponseCallback {
        void onHttpResponseMessage(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i2, String str, String str2, String str3);
    }

    public FlutterNetModel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isNetOk = true;
        this.timeout = -1;
        this.isLoading = false;
        this.task = null;
        this.isChunk = false;
        this.startRequestTime = 0L;
        this.identifier = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyHttpCallback(int i2, String str) {
        NetResponseCallback netResponseCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65543, this, i2, str) == null) || (netResponseCallback = this.httpCallback) == null) {
            return;
        }
        netResponseCallback.onHttpResponseMessage(null, null, i2, str, null, this.identifier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetAsyncTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.task = null;
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.networkService.NetworkServicePlugin.NetModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        NetAsyncTask netAsyncTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.isLoading && (netAsyncTask = this.task) != null) {
                netAsyncTask.cancel();
            }
            this.isLoading = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    public String getHttpUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mHttpUrl : (String) invokeV.objValue;
    }

    public boolean getIsChunk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.isChunk : invokeV.booleanValue;
    }

    public HashMap<String, Object> getParamMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mParamMap : (HashMap) invokeV.objValue;
    }

    public long getStartRequestTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.startRequestTime : invokeV.longValue;
    }

    public Runnable getTimeoutRunnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.timeoutRunnable == null) {
                this.timeoutRunnable = new Runnable(this) { // from class: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModel.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FlutterNetModel this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.notifyHttpCallback(-1, OneKeyLoginResult.ONE_KEY_LOGIN_MSG_CONNECTION_TIMEOUT);
                        }
                    }
                };
            }
            return this.timeoutRunnable;
        }
        return (Runnable) invokeV.objValue;
    }

    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.httpCallback == null && TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("NetModel must have callback");
            }
            this.isNetOk = l.D();
            if (this.timeout >= 10) {
                e.a().postDelayed(getTimeoutRunnable(), this.timeout * 1000);
            }
            if (!this.isNetOk) {
                e.a().post(new Runnable(this) { // from class: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModel.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FlutterNetModel this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.notifyHttpCallback(-1, "网络不可用");
                        }
                    }
                });
                return false;
            } else if (this.task == null) {
                NetAsyncTask netAsyncTask = new NetAsyncTask(this);
                this.task = netAsyncTask;
                netAsyncTask.execute(new Object[0]);
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void setHttpCallback(NetResponseCallback netResponseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, netResponseCallback) == null) {
            this.httpCallback = netResponseCallback;
        }
    }

    public void setHttpUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.mHttpUrl = str;
        }
    }

    public void setIsChunk(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.isChunk = z;
        }
    }

    public void setParams(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, hashMap) == null) {
            this.mParamMap = hashMap;
        }
    }

    public void setStartRequestTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.startRequestTime = j;
        }
    }
}
