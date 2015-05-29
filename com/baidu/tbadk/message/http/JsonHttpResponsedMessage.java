package com.baidu.tbadk.message.http;

import android.text.TextUtils;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class JsonHttpResponsedMessage extends TbHttpResponsedMessage {
    public JsonHttpResponsedMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public final void decodeInBackGround(int i, byte[] bArr) {
        JSONObject jSONObject = null;
        String parseToString = parseToString(bArr);
        if (!TextUtils.isEmpty(parseToString)) {
            jSONObject = parseServerResponsedData(parseToString);
        }
        decodeLogicInBackGround(i, jSONObject);
    }

    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage
    public void logStatInBackground(int i, e eVar) {
        super.logStatInBackground(i, eVar);
        TiebaStatic.netJson(eVar, getError(), getErrorString());
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
                    setErrorString(TbadkCoreApplication.m411getInst().getApp().getString(t.error_unkown_try_again));
                } else if (getError() != 0) {
                    setErrorString(errorData.getError_msg());
                }
                return jSONObject;
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                setErrorString(TbadkCoreApplication.m411getInst().getApp().getString(t.error_unkown_try_again));
                return jSONObject;
            }
        } catch (Exception e3) {
            jSONObject = null;
            e = e3;
        }
    }
}
