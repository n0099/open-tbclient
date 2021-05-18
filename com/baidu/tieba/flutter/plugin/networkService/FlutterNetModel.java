package com.baidu.tieba.flutter.plugin.networkService;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.httpNet.HttpNetContext;
import com.baidu.tieba.flutter.plugin.networkService.NetworkServicePlugin;
import d.a.c.e.m.b;
import d.a.c.e.m.e;
import d.a.c.e.p.l;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class FlutterNetModel implements NetworkServicePlugin.NetModel {
    public static final int TIMOUT_MIN = 10;
    public NetResponseCallback httpCallback;
    public String identifier;
    public String mHttpUrl;
    public HashMap<String, Object> mParamMap;
    public Runnable timeoutRunnable;
    public boolean isNetOk = true;
    public int timeout = -1;
    public boolean isLoading = false;
    public NetAsyncTask task = null;
    public boolean isChunk = false;
    public long startRequestTime = 0;

    /* loaded from: classes4.dex */
    public static class NetAsyncTask extends BdAsyncTask<Object, String, String> {
        public FlutterNetModel flutterNetModel;
        public HttpNetContext httpNetContext;
        public NetWork mNetWork = null;
        public boolean isCancle = false;
        public long queneTime = 0;

        public NetAsyncTask(FlutterNetModel flutterNetModel) {
            this.flutterNetModel = flutterNetModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Object... objArr) {
            String postNetData;
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
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
                hashMap.put("state", this.httpNetContext.getStat().stat.f38964h);
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

    /* loaded from: classes4.dex */
    public interface NetResponseCallback {
        void onHttpResponseMessage(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i2, String str, String str2, String str3);
    }

    public FlutterNetModel(String str) {
        this.identifier = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyHttpCallback(int i2, String str) {
        NetResponseCallback netResponseCallback = this.httpCallback;
        if (netResponseCallback != null) {
            netResponseCallback.onHttpResponseMessage(null, null, i2, str, null, this.identifier);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetAsyncTask() {
        this.task = null;
    }

    @Override // com.baidu.tieba.flutter.plugin.networkService.NetworkServicePlugin.NetModel
    public boolean cancelLoadData() {
        NetAsyncTask netAsyncTask;
        if (this.isLoading && (netAsyncTask = this.task) != null) {
            netAsyncTask.cancel();
        }
        this.isLoading = false;
        return true;
    }

    public String getHttpUrl() {
        return this.mHttpUrl;
    }

    public boolean getIsChunk() {
        return this.isChunk;
    }

    public HashMap<String, Object> getParamMap() {
        return this.mParamMap;
    }

    public long getStartRequestTime() {
        return this.startRequestTime;
    }

    public Runnable getTimeoutRunnable() {
        if (this.timeoutRunnable == null) {
            this.timeoutRunnable = new Runnable() { // from class: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModel.2
                @Override // java.lang.Runnable
                public void run() {
                    FlutterNetModel.this.notifyHttpCallback(-1, OneKeyLoginResult.ONE_KEY_LOGIN_MSG_CONNECTION_TIMEOUT);
                }
            };
        }
        return this.timeoutRunnable;
    }

    public boolean loadData() {
        if (this.httpCallback == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.isNetOk = l.D();
        if (this.timeout >= 10) {
            e.a().postDelayed(getTimeoutRunnable(), this.timeout * 1000);
        }
        if (!this.isNetOk) {
            e.a().post(new Runnable() { // from class: com.baidu.tieba.flutter.plugin.networkService.FlutterNetModel.1
                @Override // java.lang.Runnable
                public void run() {
                    FlutterNetModel.this.notifyHttpCallback(-1, "网络不可用");
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

    public void setHttpCallback(NetResponseCallback netResponseCallback) {
        this.httpCallback = netResponseCallback;
    }

    public void setHttpUrl(String str) {
        this.mHttpUrl = str;
    }

    public void setIsChunk(boolean z) {
        this.isChunk = z;
    }

    public void setParams(HashMap<String, Object> hashMap) {
        this.mParamMap = hashMap;
    }

    public void setStartRequestTime(long j) {
        this.startRequestTime = j;
    }
}
