package com.baidu.tbadk.message.http;

import android.text.TextUtils;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.l;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class JsonHttpResponsedMessage extends TbHttpResponsedMessage {
    public JsonHttpResponsedMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public final void a(int i, byte[] bArr) {
        JSONObject jSONObject;
        int indexOf;
        a(bArr);
        String a = a();
        String str = "utf-8";
        if (a != null && (indexOf = a.indexOf("charset")) != -1) {
            int indexOf2 = a.indexOf(32, indexOf);
            str = indexOf2 == -1 ? a.substring(indexOf + 8) : a.substring(indexOf + 8, indexOf2);
        }
        String str2 = new String(bArr, str);
        if (TextUtils.isEmpty(str2)) {
            jSONObject = null;
        } else {
            jSONObject = f(str2);
        }
        a(jSONObject);
    }

    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage
    public final void a(int i, e eVar) {
        super.a(i, eVar);
        TiebaStatic.b(eVar);
    }

    private JSONObject f(String str) {
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
                a(errorData.getError_code());
                if (e() == -1) {
                    e(TbadkApplication.j().b().getString(l.error_unkown_try_again));
                } else if (e() != 0) {
                    e(errorData.getError_msg());
                }
                return jSONObject;
            } catch (Exception e2) {
                e = e2;
                f.b("NetWork", "parseServerCode", "error = " + e.getMessage());
                e(TbadkApplication.j().b().getString(l.error_unkown_try_again));
                return jSONObject;
            }
        } catch (Exception e3) {
            jSONObject = null;
            e = e3;
        }
    }
}
