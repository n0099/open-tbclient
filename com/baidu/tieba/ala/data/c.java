package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public i gjR;
    public a gjS;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.gjR = new i();
            this.gjR.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.gjS = new a();
            this.gjS.parserJson(optJSONObject2);
        }
    }

    public boolean bMF() {
        return this.gjR != null && this.gjR.status == 5;
    }

    public boolean bMG() {
        return this.gjR != null && this.gjR.status == 4;
    }

    public boolean isValid() {
        return this.gjR != null && (this.gjR.status == 2 || this.gjR.status == 3);
    }

    public boolean bMH() {
        return (this.gjR == null || this.gjS == null || this.gjR.status != 2) ? false : true;
    }

    public boolean bMI() {
        return this.gjS != null && this.gjS.gjT == 1;
    }

    public long bMJ() {
        if (this.gjS != null) {
            return this.gjS.gjU;
        }
        return 0L;
    }

    public boolean bMK() {
        return this.gjS != null && ((this.gjS.gjV && !this.gjS.isFollowed) || (this.gjS.gjW && !this.gjS.gjX));
    }

    public boolean bML() {
        return this.gjS != null && (this.gjS.gjV || this.gjS.gjW);
    }

    public boolean bMM() {
        return (this.gjS == null || !this.gjS.gjV || this.gjS.isFollowed) ? false : true;
    }

    public boolean bMN() {
        return (this.gjS == null || !this.gjS.gjW || this.gjS.gjX) ? false : true;
    }

    public int ec(long j) {
        return 100 - ((int) (((j * 1.0d) / 180.0d) * 100.0d));
    }

    public String[] ed(long j) {
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
        public int gjT;
        public long gjU;
        public boolean gjV;
        public boolean gjW;
        public boolean gjX;
        public boolean gjY;
        public String gjZ;
        public boolean gka;
        public boolean isFollowed;

        public void parserJson(JSONObject jSONObject) {
            this.gjV = jSONObject.optInt("need_follow") == 1;
            this.gjW = jSONObject.optInt("need_send_gift") == 1;
            this.isFollowed = jSONObject.optInt("follow") == 1;
            this.gjX = jSONObject.optInt("send_gift") == 1;
            this.gjY = jSONObject.optInt("need_follow_sender") == 1;
            this.gjZ = jSONObject.optString("sender_user_id");
            this.gka = jSONObject.optInt("follow_sender") == 1;
            this.gjT = jSONObject.optInt("loot_result");
            this.gjU = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
