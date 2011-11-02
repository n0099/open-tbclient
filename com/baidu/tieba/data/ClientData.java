package com.baidu.tieba.data;

import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ClientData {
    private String client_id = null;

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_id() {
        return this.client_id;
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
                this.client_id = json.optString("client_id");
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "parserJson", ex.getMessage());
            }
        }
    }
}
