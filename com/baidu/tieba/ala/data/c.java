package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public i gzJ;
    public a gzK;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.gzJ = new i();
            this.gzJ.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.gzK = new a();
            this.gzK.parserJson(optJSONObject2);
        }
    }

    public boolean bRF() {
        return this.gzJ != null && this.gzJ.status == 5;
    }

    public boolean bRG() {
        return this.gzJ != null && this.gzJ.status == 4;
    }

    public boolean isValid() {
        return this.gzJ != null && (this.gzJ.status == 2 || this.gzJ.status == 3);
    }

    public boolean bRH() {
        return (this.gzJ == null || this.gzK == null || this.gzJ.status != 2) ? false : true;
    }

    public boolean bRI() {
        return this.gzK != null && this.gzK.gzL == 1;
    }

    public long bRJ() {
        if (this.gzK != null) {
            return this.gzK.gzM;
        }
        return 0L;
    }

    public boolean bRK() {
        return this.gzK != null && ((this.gzK.gzN && !this.gzK.isFollowed) || (this.gzK.gzO && !this.gzK.gzP));
    }

    public boolean bRL() {
        return this.gzK != null && (this.gzK.gzN || this.gzK.gzO);
    }

    public boolean bRM() {
        return (this.gzK == null || !this.gzK.gzN || this.gzK.isFollowed) ? false : true;
    }

    public boolean bRN() {
        return (this.gzK == null || !this.gzK.gzO || this.gzK.gzP) ? false : true;
    }

    public int eA(long j) {
        return 100 - ((int) (((j * 1.0d) / 180.0d) * 100.0d));
    }

    public String[] eB(long j) {
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
        public int gzL;
        public long gzM;
        public boolean gzN;
        public boolean gzO;
        public boolean gzP;
        public boolean gzQ;
        public String gzR;
        public boolean gzS;
        public boolean isFollowed;

        public void parserJson(JSONObject jSONObject) {
            this.gzN = jSONObject.optInt("need_follow") == 1;
            this.gzO = jSONObject.optInt("need_send_gift") == 1;
            this.isFollowed = jSONObject.optInt("follow") == 1;
            this.gzP = jSONObject.optInt("send_gift") == 1;
            this.gzQ = jSONObject.optInt("need_follow_sender") == 1;
            this.gzR = jSONObject.optString("sender_user_id");
            this.gzS = jSONObject.optInt("follow_sender") == 1;
            this.gzL = jSONObject.optInt("loot_result");
            this.gzM = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
