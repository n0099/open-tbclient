package com.baidu.tbadk.mvc.message;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.R;
import com.baidu.tieba.al5;
import com.baidu.tieba.bl5;
import com.baidu.tieba.el5;
import com.baidu.tieba.kf;
import com.baidu.tieba.me;
import com.baidu.tieba.t05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MvcJsonHttpResponsedMessage<D extends el5> extends MvcHttpResponsedMessage<D> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MvcJsonHttpResponsedMessage(int i) {
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

    private void parseErrorData(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, this, str) == null) && str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                setError(errorData.getError_code());
                if (getError() == -1) {
                    setErrorString(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f05f9));
                } else if (getError() != 0) {
                    setErrorString(errorData.getError_msg());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                setErrorString(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f05f9));
            }
        }
    }

    private void parseToastData(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, str) == null) && str != null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
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

    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, jSONObject) == null) && (getOrginalMessage() instanceof MvcHttpMessage)) {
            Object createData = createData(((MvcHttpMessage) getOrginalMessage()).getResponseDataClass());
            if (createData instanceof el5) {
                D d = (D) createData;
                this.data = d;
                d.initByJson(jSONObject);
            }
        }
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage
    public void logStatInBackground(int i, kf kfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, kfVar) == null) {
            super.logStatInBackground(i, kfVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            super.afterDispatchInBackGround(i, (int) bArr);
            if (getError() == 0 && (getOrginalMessage() instanceof MvcHttpMessage) && bArr != null) {
                MvcHttpMessage mvcHttpMessage = (MvcHttpMessage) getOrginalMessage();
                if (mvcHttpMessage.isNeedCache() && (mvcHttpMessage.getRequestData() instanceof al5)) {
                    al5 al5Var = (al5) mvcHttpMessage.getRequestData();
                    String cacheKey = al5Var.getCacheKey();
                    String U = al5Var.U();
                    if (al5Var.isNeedUid()) {
                        str = TbadkCoreApplication.getCurrentAccount();
                    } else {
                        str = null;
                    }
                    if (cacheKey != null && !TextUtils.isEmpty(U) && bArr != null) {
                        if (al5Var.F()) {
                            t05.d();
                            me<byte[]> c = t05.c(U, str);
                            if (c == null) {
                                return;
                            }
                            c.g(cacheKey, bArr);
                        } else if (mvcHttpMessage.getRequestData() instanceof bl5) {
                            t05.d();
                            me<String> f = t05.f(U, str);
                            if (f == null) {
                                return;
                            }
                            try {
                                f.g(cacheKey, new String(bArr, "UTF-8"));
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public final void decodeInBackGround(int i, byte[] bArr) throws Exception {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, bArr) == null) {
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
