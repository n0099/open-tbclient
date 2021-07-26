package com.baidu.tbadk.trackConfig;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.d0.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TrackConfigResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isOpenTrack;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrackConfigResponseMessage(int i2) {
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
        this.isOpenTrack = false;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) && jSONObject != null && isSuccess()) {
            try {
                int i3 = jSONObject.getInt("is_open_track");
                boolean z = true;
                if (i3 != 1) {
                    z = false;
                }
                this.isOpenTrack = z;
                b.j().t("key_is_open_track", this.isOpenTrack);
                TbSingleton.getInstance().setIsOpenTrack(this.isOpenTrack);
            } catch (JSONException e2) {
                BdLog.e("open track parese exception " + e2.toString());
            }
        }
    }

    public boolean getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.isOpenTrack : invokeV.booleanValue;
    }
}
