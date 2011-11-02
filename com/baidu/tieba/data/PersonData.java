package com.baidu.tieba.data;

import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PersonData {
    private UserData user = new UserData();
    private AntiData anti = new AntiData();

    public void parserJson(String str) {
        try {
            JSONObject json = new JSONObject(str);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e("PersonData", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                JSONObject data = json.optJSONObject("user");
                this.user.parserJson(data);
                JSONObject data2 = json.optJSONObject("anti");
                this.anti.parserJson(data2);
            } catch (Exception ex) {
                TiebaLog.e("PersonData", "parserJson", "error = " + ex.getMessage());
            }
        }
    }
}
