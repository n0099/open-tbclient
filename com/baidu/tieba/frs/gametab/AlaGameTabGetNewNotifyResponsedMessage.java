package com.baidu.tieba.frs.gametab;

import b.a.r0.x0.h2.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class AlaGameTabGetNewNotifyResponsedMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<a> mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaGameTabGetNewNotifyResponsedMessage() {
        super(1021074);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
            super.decodeLogicInBackGround(i2, jSONObject);
            if (hasError() || jSONObject == null) {
                return;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            int length = jSONArray.length();
            this.mData = new ArrayList(length);
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                if (jSONObject2 != null) {
                    this.mData.add(new a(jSONObject2.optInt("tab_id"), jSONObject2.optInt("has_new")));
                }
            }
        }
    }

    public List<a> getNewNotifyData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mData : (List) invokeV.objValue;
    }
}
