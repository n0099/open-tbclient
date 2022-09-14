package com.baidu.tieba.advert.sdk.data;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.dq5;
import com.baidu.tieba.sq5;
import com.baidu.tieba.wq5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SplashHttpResponse extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdInfo adInfo;
    public int errno;
    public String mResultMessage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashHttpResponse(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.errno = -1;
    }

    private void dealVideoAd() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && FileHelper.checkSD()) {
            dq5 b = dq5.b(wq5.f());
            if (!this.adInfo.shouldDownloadVideo()) {
                AdInfo adInfo = this.adInfo;
                adInfo.videoLocalPath = b.d;
                wq5.i(adInfo);
            } else if (BdNetTypeUtil.isNetWorkAvailable() && BdNetTypeUtil.isWifiNet()) {
                sq5 searchTask = searchTask(this.adInfo.adVideoUrl);
                if (searchTask == null || searchTask.getStatus() == BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
                    wq5.i(this.adInfo);
                    sq5 sq5Var = new sq5();
                    sq5Var.c(this.adInfo);
                    sq5Var.setKey(this.adInfo.adVideoUrl);
                    sq5Var.execute(new Void[0]);
                }
            } else {
                wq5.i(this.adInfo);
            }
        }
    }

    private sq5 searchTask(String str) {
        InterceptResult invokeL;
        BdAsyncTask<?, ?, ?> searchTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (searchTask = BdAsyncTask.searchTask(str)) == null || !(searchTask instanceof sq5)) {
                return null;
            }
            try {
                return (sq5) searchTask;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (sq5) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.decodeLogicInBackGround(i, jSONObject);
        this.errno = jSONObject.optInt("errno");
        this.mResultMessage = jSONObject.toString();
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error >= 0 && jSONObject != null) {
            AdInfo adInfo = new AdInfo();
            this.adInfo = adInfo;
            adInfo.parseFromJson(jSONObject);
        }
        if (this.adInfo.isVideoUrlValide()) {
            dealVideoAd();
            return;
        }
        AdInfo adInfo2 = this.adInfo;
        adInfo2.videoLocalPath = "";
        wq5.i(adInfo2);
    }

    public int getErrno() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.errno : invokeV.intValue;
    }

    public String getResultMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mResultMessage : (String) invokeV.objValue;
    }
}
