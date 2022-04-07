package com.baidu.tbadk.message.http;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.of;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class JsonHttpResponsedMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonHttpResponsedMessage(int i) {
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

    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, jSONObject) == null) {
        }
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage
    public void logStatInBackground(int i, of ofVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, ofVar) == null) {
            super.logStatInBackground(i, ofVar);
            TiebaStatic.netJson(ofVar, getError(), getErrorString());
        }
    }

    public JSONObject parseServerResponsedData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, str)) != null) {
            return (JSONObject) invokeL.objValue;
        }
        JSONObject jSONObject = null;
        if (str == null) {
            return null;
        }
        try {
            ErrorData errorData = new ErrorData();
            JSONObject jSONObject2 = new JSONObject(str);
            try {
                errorData.parserJson(str);
                setError(errorData.getError_code());
                if (getError() == -1) {
                    setErrorString(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f059f));
                } else {
                    setErrorString(errorData.getError_msg());
                }
                return jSONObject2;
            } catch (Exception e) {
                e = e;
                jSONObject = jSONObject2;
                BdLog.e(e.getMessage());
                setError(-1);
                setErrorString(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f059f));
                return jSONObject;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public final void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            String parseToString = parseToString(bArr);
            decodeLogicInBackGround(i, !TextUtils.isEmpty(parseToString) ? parseServerResponsedData(parseToString) : null);
        }
    }
}
