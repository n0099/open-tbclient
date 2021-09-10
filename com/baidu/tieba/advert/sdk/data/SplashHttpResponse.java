package com.baidu.tieba.advert.sdk.data;

import android.text.TextUtils;
import c.a.e.e.p.j;
import c.a.r0.t.a.f.b;
import c.a.r0.t.a.j.a;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class SplashHttpResponse extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdInfo adInfo;
    public int errno;
    public String mResultMessage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashHttpResponse(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
            b b2 = b.b(a.d());
            if (!this.adInfo.shouldDownloadVideo()) {
                AdInfo adInfo = this.adInfo;
                adInfo.videoLocalPath = b2.f24886d;
                a.g(adInfo);
            } else if (j.z() && j.H()) {
                c.a.r0.t.a.i.a searchTask = searchTask(this.adInfo.adVideoUrl);
                if (searchTask == null || searchTask.getStatus() == BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
                    a.g(this.adInfo);
                    c.a.r0.t.a.i.a aVar = new c.a.r0.t.a.i.a();
                    aVar.c(this.adInfo);
                    aVar.setKey(this.adInfo.adVideoUrl);
                    aVar.execute(new Void[0]);
                }
            } else {
                a.g(this.adInfo);
            }
        }
    }

    private c.a.r0.t.a.i.a searchTask(String str) {
        InterceptResult invokeL;
        BdAsyncTask<?, ?, ?> searchTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (searchTask = BdAsyncTask.searchTask(str)) == null || !(searchTask instanceof c.a.r0.t.a.i.a)) {
                return null;
            }
            try {
                return (c.a.r0.t.a.i.a) searchTask;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return (c.a.r0.t.a.i.a) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.decodeLogicInBackGround(i2, jSONObject);
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
        a.g(adInfo2);
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
