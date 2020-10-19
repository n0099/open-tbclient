package com.baidu.tieba.ala.liveroom.performancewatchtask;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public int gZR;
    public String gZS;
    public int gZT;
    public String gZU;
    public int gZV;
    public int gZW;
    public String gZX;
    public int gZY;
    public String gZZ;
    public int haa;
    public int hab;
    public String msg;
    public int status;
    public String taskId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            this.msg = jSONObject.optString("msg");
            this.taskId = jSONObject.optString("task_id");
            this.hab = jSONObject.optInt("ticket_num");
            JSONObject optJSONObject = jSONObject.optJSONObject("type1");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("type2");
            if (optJSONObject != null) {
                this.gZR = optJSONObject.optInt("isok");
                this.gZS = optJSONObject.optString("content");
                this.gZT = optJSONObject.optInt("type");
                this.gZU = optJSONObject.optString("h5url");
                this.gZV = optJSONObject.optInt("len_time");
            }
            if (optJSONObject2 != null) {
                this.gZW = optJSONObject2.optInt("isok");
                this.gZX = optJSONObject2.optString("content");
                this.gZY = optJSONObject2.optInt("type");
                this.gZZ = optJSONObject2.optString("h5url");
                this.haa = optJSONObject2.optInt("len_time");
            }
        }
    }

    public boolean isSuccess() {
        return this.status == 0 && "success".equals(this.msg);
    }
}
