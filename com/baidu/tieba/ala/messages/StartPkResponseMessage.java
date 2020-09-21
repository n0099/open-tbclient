package com.baidu.tieba.ala.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class StartPkResponseMessage extends JsonHttpResponsedMessage {
    private int aFS;
    private int gRC;
    private ArrayList<String> gRD;
    private long logId;
    private long pkID;

    public StartPkResponseMessage(int i) {
        super(i);
        this.gRC = -1;
        this.gRD = new ArrayList<>();
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gRC = optJSONObject.optInt("match_status");
            this.pkID = optJSONObject.optLong("pk_id");
            this.aFS = optJSONObject.optInt("pk_start_interval");
            JSONArray optJSONArray = optJSONObject.optJSONArray("portrait_list");
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < optJSONArray.length()) {
                    this.gRD.add(((JSONObject) optJSONArray.get(i3)).optString("portrait"));
                    i2 = i3 + 1;
                } else {
                    this.logId = jSONObject.optLong("logid");
                    return;
                }
            }
        }
    }

    public int bZC() {
        return this.gRC;
    }

    public long bZA() {
        return this.pkID;
    }

    public int getInterval() {
        return this.aFS;
    }

    public ArrayList<String> bZD() {
        return this.gRD;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.logId;
    }
}
