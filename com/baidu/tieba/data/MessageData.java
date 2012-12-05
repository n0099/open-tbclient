package com.baidu.tieba.data;

import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MessageData {
    private long replyme = 0;
    private long atme = 0;
    private long fans = 0;

    public void setReplyme(long replyme) {
        this.replyme = replyme;
    }

    public long getReplyme() {
        return this.replyme;
    }

    public void setAtme(long atme) {
        this.atme = atme;
    }

    public long getAtme() {
        return this.atme;
    }

    public void setFans(long fans) {
        this.fans = fans;
    }

    public long getFans() {
        return this.fans;
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            JSONObject obj = json.optJSONObject("message");
            parserJson(obj);
        } catch (Exception ex) {
            TiebaLog.e("MessageData", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.replyme = json.optLong("replyme", 0L);
                this.atme = json.optLong("atme", 0L);
                this.fans = json.optLong(Config.BROADCAST_FANS_NUM, 0L);
            } catch (Exception ex) {
                TiebaLog.e("MessageData", "parserJson", "error = " + ex.getMessage());
            }
        }
    }
}
