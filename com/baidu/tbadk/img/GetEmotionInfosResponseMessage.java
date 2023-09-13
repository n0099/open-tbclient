package com.baidu.tbadk.img;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.bn5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetEmotionInfosResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<bn5> mEmotionList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetEmotionInfosResponseMessage(int i) {
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
    }

    private void parseEmotionImages(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, this, jSONArray) != null) || jSONArray == null) {
            return;
        }
        this.mEmotionList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                this.mEmotionList.add(bn5.a(jSONArray.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0 && jSONObject != null) {
                parseEmotionImages(jSONObject.optJSONArray(SocialConstants.PARAM_IMAGE));
            }
        }
    }

    public List<bn5> getEmotionList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mEmotionList;
        }
        return (List) invokeV.objValue;
    }
}
