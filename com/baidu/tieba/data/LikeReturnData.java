package com.baidu.tieba.data;

import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class LikeReturnData {
    private int error_code = 0;
    private String error_msg = null;
    private LikeForumData info = new LikeForumData();

    public int getErrorCode() {
        return this.error_code;
    }

    public String getErrorMsg() {
        return this.error_msg;
    }

    public LikeForumData getLikeReturnData() {
        return this.info;
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e("LikeReturnData", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.error_msg = json.optString("error_msg");
                this.error_code = json.optInt("error_code", 0);
                this.info.parserJson(json.optJSONObject(LoginActivity.INFO));
            } catch (Exception ex) {
                TiebaLog.e("LikeReturnData", "parserJson", "error = " + ex.getMessage());
            }
        }
    }

    public void logPrint() {
        TiebaLog.v("LikeForumData", "logPrint", "error_msg = " + this.error_msg);
        TiebaLog.v("LikeForumData", "logPrint", "error_code = " + this.error_code);
    }
}
