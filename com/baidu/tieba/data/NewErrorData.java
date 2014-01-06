package com.baidu.tieba.data;

import com.baidu.tieba.util.bo;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NewErrorData implements Serializable {
    private static final long serialVersionUID = -4089110102533296066L;
    public int errno = -1;
    public String errmsg = null;
    public String usermsg = null;

    public int getErrorNumber() {
        return this.errno;
    }

    public String getErrorMsg() {
        return this.errmsg;
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str).optJSONObject("error"));
            } catch (Exception e) {
                bo.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.errno = jSONObject.optInt("errno");
                this.errmsg = jSONObject.optString("usermsg");
            } catch (Exception e) {
                bo.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
