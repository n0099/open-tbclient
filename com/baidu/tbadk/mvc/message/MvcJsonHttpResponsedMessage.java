package com.baidu.tbadk.mvc.message;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.network.http.f;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.b.e;
import com.baidu.tbadk.mvc.b.j;
import com.baidu.tieba.r;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MvcJsonHttpResponsedMessage<D extends j> extends MvcHttpResponsedMessage<D> {
    public MvcJsonHttpResponsedMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public final void decodeInBackGround(int i, byte[] bArr) throws Exception {
        JSONObject jSONObject = null;
        String parseToString = parseToString(bArr);
        if (!TextUtils.isEmpty(parseToString)) {
            jSONObject = parseServerResponsedData(parseToString);
        }
        decodeLogicInBackGround(i, jSONObject);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage
    public void logStatInBackground(int i, f fVar) {
        super.logStatInBackground(i, fVar);
        TiebaStatic.netJson(fVar, getError(), getErrorString());
    }

    protected JSONObject parseServerResponsedData(String str) {
        JSONObject jSONObject;
        Exception e;
        if (str == null) {
            return null;
        }
        try {
            ErrorData errorData = new ErrorData();
            jSONObject = new JSONObject(str);
            try {
                errorData.parserJson(str);
                setError(errorData.getError_code());
                if (getError() == -1) {
                    setErrorString(TbadkCoreApplication.m9getInst().getApp().getString(r.j.error_unkown_try_again));
                } else if (getError() != 0) {
                    setErrorString(errorData.getError_msg());
                }
                return jSONObject;
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                setErrorString(TbadkCoreApplication.m9getInst().getApp().getString(r.j.error_unkown_try_again));
                return jSONObject;
            }
        } catch (Exception e3) {
            jSONObject = null;
            e = e3;
        }
    }

    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (getOrginalMessage() instanceof MvcHttpMessage) {
            Object createData = createData(((MvcHttpMessage) getOrginalMessage()).getResponseDataClass());
            if (createData instanceof j) {
                this.data = (D) createData;
                this.data.i(jSONObject);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        o<String> N;
        super.afterDispatchInBackGround(i, (int) bArr);
        if (getError() == 0 && (getOrginalMessage() instanceof MvcHttpMessage) && bArr != null) {
            MvcHttpMessage mvcHttpMessage = (MvcHttpMessage) getOrginalMessage();
            if (mvcHttpMessage.isNeedCache() && (mvcHttpMessage.getRequestData() instanceof e)) {
                e eVar = (e) mvcHttpMessage.getRequestData();
                String cacheKey = eVar.getCacheKey();
                String EN = eVar.EN();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey != null && !TextUtils.isEmpty(EN) && bArr != null) {
                    if (eVar.EO()) {
                        o<byte[]> M = a.tm().M(EN, currentAccount);
                        if (M != null) {
                            M.k(cacheKey, bArr);
                        }
                    } else if ((mvcHttpMessage.getRequestData() instanceof com.baidu.tbadk.mvc.b.f) && (N = a.tm().N(EN, currentAccount)) != null) {
                        try {
                            N.k(cacheKey, new String(bArr, "UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
