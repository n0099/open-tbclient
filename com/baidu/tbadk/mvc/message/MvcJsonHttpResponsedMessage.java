package com.baidu.tbadk.mvc.message;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.b.b.e.d.l;
import d.b.b.e.j.a.e;
import d.b.h0.g0.b.d;
import d.b.h0.g0.b.h;
import d.b.h0.r.r.a;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MvcJsonHttpResponsedMessage<D extends h> extends MvcHttpResponsedMessage<D> {
    public MvcJsonHttpResponsedMessage(int i) {
        super(i);
    }

    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (getOrginalMessage() instanceof MvcHttpMessage) {
            Object createData = createData(((MvcHttpMessage) getOrginalMessage()).getResponseDataClass());
            if (createData instanceof h) {
                D d2 = (D) createData;
                this.data = d2;
                d2.initByJson(jSONObject);
            }
        }
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage
    public void logStatInBackground(int i, e eVar) {
        super.logStatInBackground(i, eVar);
        TiebaStatic.netJson(eVar, getError(), getErrorString());
    }

    public JSONObject parseServerResponsedData(String str) {
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
                    setErrorString(TbadkCoreApplication.getInst().getApp().getString(R.string.error_unkown_try_again));
                } else if (getError() != 0) {
                    setErrorString(errorData.getError_msg());
                }
                return jSONObject2;
            } catch (Exception e2) {
                e = e2;
                jSONObject = jSONObject2;
                BdLog.e(e.getMessage());
                setErrorString(TbadkCoreApplication.getInst().getApp().getString(R.string.error_unkown_try_again));
                return jSONObject;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        l<String> h2;
        super.afterDispatchInBackGround(i, (int) bArr);
        if (getError() == 0 && (getOrginalMessage() instanceof MvcHttpMessage) && bArr != null) {
            MvcHttpMessage mvcHttpMessage = (MvcHttpMessage) getOrginalMessage();
            if (mvcHttpMessage.isNeedCache() && (mvcHttpMessage.getRequestData() instanceof d)) {
                d dVar = (d) mvcHttpMessage.getRequestData();
                String cacheKey = dVar.getCacheKey();
                String q = dVar.q();
                String currentAccount = dVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(q) || bArr == null) {
                    return;
                }
                if (dVar.r()) {
                    l<byte[]> e2 = a.f().e(q, currentAccount);
                    if (e2 == null) {
                        return;
                    }
                    e2.g(cacheKey, bArr);
                } else if (!(mvcHttpMessage.getRequestData() instanceof d.b.h0.g0.b.e) || (h2 = a.f().h(q, currentAccount)) == null) {
                } else {
                    try {
                        h2.g(cacheKey, new String(bArr, "UTF-8"));
                    } catch (UnsupportedEncodingException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public final void decodeInBackGround(int i, byte[] bArr) throws Exception {
        String parseToString = parseToString(bArr);
        decodeLogicInBackGround(i, !TextUtils.isEmpty(parseToString) ? parseServerResponsedData(parseToString) : null);
    }
}
