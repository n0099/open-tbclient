package com.baidu.tieba.data;

import com.baidu.tieba.util.TiebaLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PullMessageData {
    private long messageID = 0;
    private String link = null;
    private String content = null;

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e("MssageData", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                JSONArray data = json.getJSONArray("data");
                for (int i = 0; i < data.length(); i++) {
                    if (data.getJSONObject(i) != null) {
                        JSONObject temp = data.getJSONObject(i);
                        if (this.messageID < temp.getLong("message_id")) {
                            this.messageID = temp.getLong("message_id");
                            this.link = temp.getString("link");
                            this.content = temp.getString("content");
                        }
                    }
                }
            } catch (Exception ex) {
                TiebaLog.e("MssageData", "parserJson", "error = " + ex.getMessage());
            }
        }
    }

    public long getMessageID() {
        return this.messageID;
    }

    public String getLink() {
        return this.link;
    }

    public String getContent() {
        return this.content;
    }
}
