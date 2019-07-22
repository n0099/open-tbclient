package com.baidu.tbadk.mvc.message;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.d.a;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.b.f;
import com.baidu.tbadk.mvc.b.j;
import com.baidu.tieba.R;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MvcJsonHttpResponsedMessage<D extends j> extends MvcHttpResponsedMessage<D> {
    public MvcJsonHttpResponsedMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public final void decodeInBackGround(int i, byte[] bArr) throws Exception {
        JSONObject jSONObject = null;
        String parseToString = parseToString(bArr);
        if (!TextUtils.isEmpty(parseToString)) {
            jSONObject = parseServerResponsedData(parseToString);
        }
        decodeLogicInBackGround(i, jSONObject);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage
    public void logStatInBackground(int i, e eVar) {
        super.logStatInBackground(i, eVar);
        TiebaStatic.netJson(eVar, getError(), getErrorString());
    }

    protected JSONObject parseServerResponsedData(String str) {
        JSONObject jSONObject;
        Exception e;
        ErrorData errorData;
        if (str == null) {
            return null;
        }
        try {
            errorData = new ErrorData();
            jSONObject = new JSONObject(str);
        } catch (Exception e2) {
            jSONObject = null;
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
            BdLog.e(e.getMessage());
            setErrorString(TbadkCoreApplication.getInst().getApp().getString(R.string.error_unkown_try_again));
            return jSONObject;
        }
    }

    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (getOrginalMessage() instanceof MvcHttpMessage) {
            Object createData = createData(((MvcHttpMessage) getOrginalMessage()).getResponseDataClass());
            if (createData instanceof j) {
                this.data = (D) createData;
                this.data.initByJson(jSONObject);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        l<String> bE;
        super.afterDispatchInBackGround(i, (int) bArr);
        if (getError() == 0 && (getOrginalMessage() instanceof MvcHttpMessage) && bArr != null) {
            MvcHttpMessage mvcHttpMessage = (MvcHttpMessage) getOrginalMessage();
            if (mvcHttpMessage.isNeedCache() && (mvcHttpMessage.getRequestData() instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) mvcHttpMessage.getRequestData();
                String cacheKey = eVar.getCacheKey();
                String aud = eVar.aud();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey != null && !TextUtils.isEmpty(aud) && bArr != null) {
                    if (eVar.aue()) {
                        l<byte[]> bD = a.agF().bD(aud, currentAccount);
                        if (bD != null) {
                            bD.f(cacheKey, bArr);
                        }
                    } else if ((mvcHttpMessage.getRequestData() instanceof f) && (bE = a.agF().bE(aud, currentAccount)) != null) {
                        try {
                            bE.f(cacheKey, new String(bArr, HTTP.UTF_8));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
