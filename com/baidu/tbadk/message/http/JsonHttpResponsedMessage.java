package com.baidu.tbadk.message.http;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.b.c.e.j.a.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class JsonHttpResponsedMessage extends TbHttpResponsedMessage {
    public JsonHttpResponsedMessage(int i) {
        super(i);
    }

    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage
    public void logStatInBackground(int i, e eVar) {
        super.logStatInBackground(i, eVar);
        TiebaStatic.netJson(eVar, getError(), getErrorString());
    }

    public JSONObject parseServerResponsedData(String str) {
        ErrorData errorData;
        JSONObject jSONObject;
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
                } else {
                    setErrorString(errorData.getError_msg());
                }
                return jSONObject;
            } catch (Exception e3) {
                e = e3;
                jSONObject2 = jSONObject;
                BdLog.e(e.getMessage());
                setError(-1);
                setErrorString(TbadkCoreApplication.getInst().getApp().getString(R.string.error_unkown_try_again));
                return jSONObject2;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public final void decodeInBackGround(int i, byte[] bArr) throws Exception {
        String parseToString = parseToString(bArr);
        decodeLogicInBackGround(i, !TextUtils.isEmpty(parseToString) ? parseServerResponsedData(parseToString) : null);
    }
}
