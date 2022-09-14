package com.baidu.tieba.deletethread;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DeleteThreadHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> failItems;
    public int retType;
    public ArrayList<String> successItems;
    public String text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeleteThreadHttpResponseMessage() {
        super(CmdConfigHttp.CMD_NEG_DELETE_THREAD);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public int getRetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.retType : invokeV.intValue;
    }

    public ArrayList<String> getSuccessItems() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.successItems : (ArrayList) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.text : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            String parseToString = parseToString(bArr);
            if (TextUtils.isEmpty(parseToString)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(parseToString);
            setError(jSONObject.optInt("error_code", -1));
            setErrorString(jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG));
            JSONObject optJSONObject = jSONObject.optJSONObject("info");
            if (optJSONObject != null) {
                this.retType = optJSONObject.optInt("ret_type");
                this.text = optJSONObject.optString("text");
                JSONArray optJSONArray = optJSONObject.optJSONArray("del_fail");
                this.failItems = new ArrayList<>();
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        this.failItems.add(optJSONArray.optString(i2));
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("del_success");
                this.successItems = new ArrayList<>();
                if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                    return;
                }
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    this.successItems.add(optJSONArray2.optString(i3));
                }
            }
        }
    }
}
