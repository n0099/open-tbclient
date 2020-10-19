package com.baidu.tieba.ala.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class StartPkResponseMessage extends JsonHttpResponsedMessage {
    private int aIW;
    private ArrayList<String> hgA;
    private int hgz;
    private long logId;
    private long pkID;

    public StartPkResponseMessage(int i) {
        super(i);
        this.hgz = -1;
        this.hgA = new ArrayList<>();
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hgz = optJSONObject.optInt("match_status");
            this.pkID = optJSONObject.optLong("pk_id");
            this.aIW = optJSONObject.optInt("pk_start_interval");
            JSONArray optJSONArray = optJSONObject.optJSONArray("portrait_list");
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < optJSONArray.length()) {
                    this.hgA.add(((JSONObject) optJSONArray.get(i3)).optString("portrait"));
                    i2 = i3 + 1;
                } else {
                    this.logId = jSONObject.optLong("logid");
                    return;
                }
            }
        }
    }

    public int cda() {
        return this.hgz;
    }

    public long ccY() {
        return this.pkID;
    }

    public int getInterval() {
        return this.aIW;
    }

    public ArrayList<String> cdb() {
        return this.hgA;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.logId;
    }
}
