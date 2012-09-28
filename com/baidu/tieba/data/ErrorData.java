package com.baidu.tieba.data;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ErrorData {
    private int error_code = -1;
    private String error_msg = null;
    private String error_data = null;

    public int getError_code() {
        return this.error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError_msg() {
        return this.error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public String getError_data() {
        return this.error_data;
    }

    public void setError_data(String error_data) {
        this.error_data = error_data;
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "parserJson", ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.error_code = json.optInt("error_code", 0);
                this.error_msg = json.optString(PushConstants.EXTRA_ERROR_CODE);
                this.error_data = json.optString("error_data");
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "parserJson", ex.getMessage());
            }
        }
    }

    public void logPrint() {
        TiebaLog.v(getClass().getName(), "logPrint", "error_code = " + String.valueOf(this.error_code));
        TiebaLog.v(getClass().getName(), "logPrint", "error_msg = " + this.error_msg);
        TiebaLog.v(getClass().getName(), "logPrint", "error_data = " + this.error_data);
    }
}
