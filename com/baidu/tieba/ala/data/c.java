package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public i fXy;
    public a fXz;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.fXy = new i();
            this.fXy.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.fXz = new a();
            this.fXz.parserJson(optJSONObject2);
        }
    }

    public boolean bJV() {
        return this.fXy != null && this.fXy.status == 5;
    }

    public boolean bJW() {
        return this.fXy != null && this.fXy.status == 4;
    }

    public boolean isValid() {
        return this.fXy != null && (this.fXy.status == 2 || this.fXy.status == 3);
    }

    public boolean bJX() {
        return (this.fXy == null || this.fXz == null || this.fXy.status != 2) ? false : true;
    }

    public boolean bJY() {
        return this.fXz != null && this.fXz.fXA == 1;
    }

    public long bJZ() {
        if (this.fXz != null) {
            return this.fXz.fXB;
        }
        return 0L;
    }

    public boolean bKa() {
        return this.fXz != null && ((this.fXz.fXC && !this.fXz.isFollowed) || (this.fXz.fXD && !this.fXz.fXE));
    }

    public boolean bKb() {
        return this.fXz != null && (this.fXz.fXC || this.fXz.fXD);
    }

    public boolean bKc() {
        return (this.fXz == null || !this.fXz.fXC || this.fXz.isFollowed) ? false : true;
    }

    public boolean bKd() {
        return (this.fXz == null || !this.fXz.fXD || this.fXz.fXE) ? false : true;
    }

    public int dT(long j) {
        return 100 - ((int) (((j * 1.0d) / 180.0d) * 100.0d));
    }

    public String[] dU(long j) {
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
        public int fXA;
        public long fXB;
        public boolean fXC;
        public boolean fXD;
        public boolean fXE;
        public boolean fXF;
        public String fXG;
        public boolean fXH;
        public boolean isFollowed;

        public void parserJson(JSONObject jSONObject) {
            this.fXC = jSONObject.optInt("need_follow") == 1;
            this.fXD = jSONObject.optInt("need_send_gift") == 1;
            this.isFollowed = jSONObject.optInt("follow") == 1;
            this.fXE = jSONObject.optInt("send_gift") == 1;
            this.fXF = jSONObject.optInt("need_follow_sender") == 1;
            this.fXG = jSONObject.optString("sender_user_id");
            this.fXH = jSONObject.optInt("follow_sender") == 1;
            this.fXA = jSONObject.optInt("loot_result");
            this.fXB = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
