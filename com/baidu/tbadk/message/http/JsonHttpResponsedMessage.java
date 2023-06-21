package com.baidu.tbadk.message.http;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BdAlertData;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.R;
import com.baidu.tieba.yf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class JsonHttpResponsedMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, jSONObject) == null) {
        }
    }

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

    private void parseDialogData(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, this, str) == null) && str != null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("alert");
                new BdAlertData();
                if (optJSONObject != null) {
                    showDialog((BdAlertData) DataExt.toEntity(optJSONObject.toString(), BdAlertData.class));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void parseErrorData(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, str) == null) && str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                setError(errorData.getError_code());
                if (getError() == -1) {
                    setErrorString(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0695));
                } else {
                    setErrorString(errorData.getError_msg());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                setError(-1);
                setErrorString(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0695));
            }
        }
    }

    private void parseToastData(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, str) == null) && str != null) {
            try {
                BdToastData bdToastData = new BdToastData();
                bdToastData.parserJson(str);
                showToast(bdToastData);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public JSONObject parseServerResponsedData(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            JSONObject jSONObject2 = null;
            if (str == null) {
                return null;
            }
            try {
                jSONObject = new JSONObject(str);
            } catch (Exception e) {
                e = e;
            }
            try {
                parseErrorData(str);
                parseToastData(str);
                parseDialogData(str);
                return jSONObject;
            } catch (Exception e2) {
                e = e2;
                jSONObject2 = jSONObject;
                BdLog.e(e.getMessage());
                return jSONObject2;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage
    public void logStatInBackground(int i, yf yfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, yfVar) == null) {
            super.logStatInBackground(i, yfVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public final void decodeInBackGround(int i, byte[] bArr) throws Exception {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            String parseToString = parseToString(bArr);
            if (!TextUtils.isEmpty(parseToString)) {
                jSONObject = parseServerResponsedData(parseToString);
            } else {
                jSONObject = null;
            }
            decodeLogicInBackGround(i, jSONObject);
        }
    }
}
