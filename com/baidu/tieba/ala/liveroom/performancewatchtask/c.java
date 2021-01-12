package com.baidu.tieba.ala.liveroom.performancewatchtask;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    public int hIm;
    public String hIn;
    public int hIo;
    public String hIp;
    public int hIq;
    public int hIr;
    public String hIs;
    public int hIt;
    public String hIu;
    public int hIv;
    public int hIw;
    public String msg;
    public int status;
    public String taskId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            this.msg = jSONObject.optString("msg");
            this.taskId = jSONObject.optString("task_id");
            this.hIw = jSONObject.optInt("ticket_num");
            JSONObject optJSONObject = jSONObject.optJSONObject("type1");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("type2");
            if (optJSONObject != null) {
                this.hIm = optJSONObject.optInt("isok");
                this.hIn = optJSONObject.optString("content");
                this.hIo = optJSONObject.optInt("type");
                this.hIp = optJSONObject.optString("h5url");
                this.hIq = optJSONObject.optInt("len_time");
            }
            if (optJSONObject2 != null) {
                this.hIr = optJSONObject2.optInt("isok");
                this.hIs = optJSONObject2.optString("content");
                this.hIt = optJSONObject2.optInt("type");
                this.hIu = optJSONObject2.optString("h5url");
                this.hIv = optJSONObject2.optInt("len_time");
            }
        }
    }

    public boolean isSuccess() {
        return this.status == 0 && "success".equals(this.msg);
    }
}
