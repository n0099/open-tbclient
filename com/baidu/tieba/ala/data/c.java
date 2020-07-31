package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public i fIO;
    public a fIP;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.fIO = new i();
            this.fIO.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.fIP = new a();
            this.fIP.parserJson(optJSONObject2);
        }
    }

    public boolean bzI() {
        return this.fIO != null && this.fIO.status == 5;
    }

    public boolean bzJ() {
        return this.fIO != null && this.fIO.status == 4;
    }

    public boolean isValid() {
        return this.fIO != null && (this.fIO.status == 2 || this.fIO.status == 3);
    }

    public boolean bzK() {
        return (this.fIO == null || this.fIP == null || this.fIO.status != 2) ? false : true;
    }

    public boolean bzL() {
        return this.fIP != null && this.fIP.fIQ == 1;
    }

    public long bzM() {
        if (this.fIP != null) {
            return this.fIP.fIR;
        }
        return 0L;
    }

    public boolean bzN() {
        return this.fIP != null && ((this.fIP.fIS && !this.fIP.aSU) || (this.fIP.fIT && !this.fIP.fIU));
    }

    public boolean bzO() {
        return this.fIP != null && (this.fIP.fIS || this.fIP.fIT);
    }

    public boolean bzP() {
        return (this.fIP == null || !this.fIP.fIS || this.fIP.aSU) ? false : true;
    }

    public boolean bzQ() {
        return (this.fIP == null || !this.fIP.fIT || this.fIP.fIU) ? false : true;
    }

    public int dG(long j) {
        return 100 - ((int) (((j * 1.0d) / 180.0d) * 100.0d));
    }

    public String[] dH(long j) {
        String[] strArr = new String[2];
        if (j <= 60) {
            if (j < 0) {
                j = 0;
            }
            strArr[0] = null;
            if (j < 10) {
                strArr[1] = "0" + j;
            } else {
                strArr[1] = String.valueOf(j);
            }
            return strArr;
        }
        int i = (int) (j / 60);
        int i2 = (int) (j % 60);
        if (i < 10) {
            strArr[0] = "0" + i;
        } else {
            strArr[0] = String.valueOf(i);
        }
        if (i2 < 10) {
            strArr[1] = "0" + i2;
        } else {
            strArr[1] = String.valueOf(i2);
        }
        return strArr;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public boolean aSU;
        public int fIQ;
        public long fIR;
        public boolean fIS;
        public boolean fIT;
        public boolean fIU;
        public boolean fIV;
        public String fIW;
        public boolean fIX;

        public void parserJson(JSONObject jSONObject) {
            this.fIS = jSONObject.optInt("need_follow") == 1;
            this.fIT = jSONObject.optInt("need_send_gift") == 1;
            this.aSU = jSONObject.optInt("follow") == 1;
            this.fIU = jSONObject.optInt("send_gift") == 1;
            this.fIV = jSONObject.optInt("need_follow_sender") == 1;
            this.fIW = jSONObject.optString("sender_user_id");
            this.fIX = jSONObject.optInt("follow_sender") == 1;
            this.fIQ = jSONObject.optInt("loot_result");
            this.fIR = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
