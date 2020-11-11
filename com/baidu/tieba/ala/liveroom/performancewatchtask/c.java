package com.baidu.tieba.ala.liveroom.performancewatchtask;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public int hrF;
    public String hrG;
    public int hrH;
    public String hrI;
    public int hrJ;
    public int hrK;
    public String hrL;
    public int hrM;
    public String hrN;
    public int hrO;
    public int hrP;
    public String msg;
    public int status;
    public String taskId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            this.msg = jSONObject.optString("msg");
            this.taskId = jSONObject.optString("task_id");
            this.hrP = jSONObject.optInt("ticket_num");
            JSONObject optJSONObject = jSONObject.optJSONObject("type1");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("type2");
            if (optJSONObject != null) {
                this.hrF = optJSONObject.optInt("isok");
                this.hrG = optJSONObject.optString("content");
                this.hrH = optJSONObject.optInt("type");
                this.hrI = optJSONObject.optString("h5url");
                this.hrJ = optJSONObject.optInt("len_time");
            }
            if (optJSONObject2 != null) {
                this.hrK = optJSONObject2.optInt("isok");
                this.hrL = optJSONObject2.optString("content");
                this.hrM = optJSONObject2.optInt("type");
                this.hrN = optJSONObject2.optString("h5url");
                this.hrO = optJSONObject2.optInt("len_time");
            }
        }
    }

    public boolean isSuccess() {
        return this.status == 0 && "success".equals(this.msg);
    }
}
