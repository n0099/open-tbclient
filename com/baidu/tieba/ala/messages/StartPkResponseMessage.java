package com.baidu.tieba.ala.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class StartPkResponseMessage extends JsonHttpResponsedMessage {
    private int hTN;
    private ArrayList<String> hTO;
    private int interval;
    private long logId;
    private long pkID;

    public StartPkResponseMessage(int i) {
        super(i);
        this.hTN = -1;
        this.hTO = new ArrayList<>();
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hTN = optJSONObject.optInt("match_status");
            this.pkID = optJSONObject.optLong("pk_id");
            this.interval = optJSONObject.optInt("pk_start_interval");
            JSONArray optJSONArray = optJSONObject.optJSONArray("portrait_list");
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < optJSONArray.length()) {
                    this.hTO.add(((JSONObject) optJSONArray.get(i3)).optString("portrait"));
                    i2 = i3 + 1;
                } else {
                    this.logId = jSONObject.optLong("logid");
                    return;
                }
            }
        }
    }

    public int cmb() {
        return this.hTN;
    }

    public long clZ() {
        return this.pkID;
    }

    public int getInterval() {
        return this.interval;
    }

    public ArrayList<String> cmc() {
        return this.hTO;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.logId;
    }
}
