package com.baidu.tbadk.trackConfig;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.b55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TrackConfigResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isOpenTrack;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrackConfigResponseMessage(int i) {
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
        this.isOpenTrack = false;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            if (jSONObject != null && isSuccess()) {
                try {
                    boolean z = true;
                    if (jSONObject.getInt("is_open_track") != 1) {
                        z = false;
                    }
                    this.isOpenTrack = z;
                    b55.m().w("key_is_open_track", this.isOpenTrack);
                    TbSingleton.getInstance().setIsOpenTrack(this.isOpenTrack);
                } catch (JSONException e) {
                    BdLog.e("open track parese exception " + e.toString());
                }
            }
            if (UbsABTestHelper.isAddBaidIdCookie() && isSuccess() && TbSingleton.getInstance().getBaiduIdForAnti() == null) {
                List<String> header = getHeader("Set-Cookie");
                if (ListUtils.isEmpty(header)) {
                    return;
                }
                for (String str : header) {
                    if (!StringUtils.isNull(str) && str.contains("BAIDUID=")) {
                        for (String str2 : str.split(ParamableElem.DIVIDE_PARAM)) {
                            if (!StringUtils.isNull(str2) && str2.contains("BAIDUID=")) {
                                TbSingleton.getInstance().setBaiduIdForAnti(str2.trim().substring(8));
                                return;
                            }
                        }
                        continue;
                    }
                }
            }
        }
    }

    public boolean getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.isOpenTrack;
        }
        return invokeV.booleanValue;
    }
}
