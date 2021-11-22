package com.baidu.tbadk.mvc.message;

import android.text.TextUtils;
import b.a.e.f.d.l;
import b.a.e.f.j.a.e;
import b.a.q0.k0.b.d;
import b.a.q0.k0.b.h;
import b.a.q0.s.r.a;
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
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class MvcJsonHttpResponsedMessage<D extends h> extends MvcHttpResponsedMessage<D> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MvcJsonHttpResponsedMessage(int i2) {
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
    }

    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i2, jSONObject) == null) && (getOrginalMessage() instanceof MvcHttpMessage)) {
            Object createData = createData(((MvcHttpMessage) getOrginalMessage()).getResponseDataClass());
            if (createData instanceof h) {
                D d2 = (D) createData;
                this.data = d2;
                d2.initByJson(jSONObject);
            }
        }
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage
    public void logStatInBackground(int i2, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, eVar) == null) {
            super.logStatInBackground(i2, eVar);
            TiebaStatic.netJson(eVar, getError(), getErrorString());
        }
    }

    public JSONObject parseServerResponsedData(String str) {
        InterceptResult invokeL;
        ErrorData errorData;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            JSONObject jSONObject2 = null;
            if (str != null) {
                try {
                    errorData = new ErrorData();
                    jSONObject = new JSONObject(str);
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    errorData.parserJson(str);
                    setError(errorData.getError_code());
                    if (getError() == -1) {
                        setErrorString(TbadkCoreApplication.getInst().getApp().getString(R.string.error_unkown_try_again));
                    } else if (getError() != 0) {
                        setErrorString(errorData.getError_msg());
                    }
                    return jSONObject;
                } catch (Exception e3) {
                    e = e3;
                    jSONObject2 = jSONObject;
                    BdLog.e(e.getMessage());
                    setErrorString(TbadkCoreApplication.getInst().getApp().getString(R.string.error_unkown_try_again));
                    return jSONObject2;
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            super.afterDispatchInBackGround(i2, (int) bArr);
            if (getError() == 0 && (getOrginalMessage() instanceof MvcHttpMessage) && bArr != null) {
                MvcHttpMessage mvcHttpMessage = (MvcHttpMessage) getOrginalMessage();
                if (mvcHttpMessage.isNeedCache() && (mvcHttpMessage.getRequestData() instanceof d)) {
                    d dVar = (d) mvcHttpMessage.getRequestData();
                    String cacheKey = dVar.getCacheKey();
                    String v = dVar.v();
                    String currentAccount = dVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                    if (cacheKey == null || TextUtils.isEmpty(v) || bArr == null) {
                        return;
                    }
                    if (dVar.l()) {
                        a.f();
                        l<byte[]> e2 = a.e(v, currentAccount);
                        if (e2 == null) {
                            return;
                        }
                        e2.g(cacheKey, bArr);
                    } else if (mvcHttpMessage.getRequestData() instanceof b.a.q0.k0.b.e) {
                        a.f();
                        l<String> h2 = a.h(v, currentAccount);
                        if (h2 == null) {
                            return;
                        }
                        try {
                            h2.g(cacheKey, new String(bArr, "UTF-8"));
                        } catch (UnsupportedEncodingException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public final void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, bArr) == null) {
            String parseToString = parseToString(bArr);
            decodeLogicInBackGround(i2, !TextUtils.isEmpty(parseToString) ? parseServerResponsedData(parseToString) : null);
        }
    }
}
