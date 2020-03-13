package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public h ezx;
    public a ezy;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.ezx = new h();
            this.ezx.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.ezy = new a();
            this.ezy.parserJson(optJSONObject2);
        }
    }

    public boolean bej() {
        return this.ezx != null && this.ezx.status == 5;
    }

    public boolean bek() {
        return this.ezx != null && this.ezx.status == 4;
    }

    public boolean isValid() {
        return this.ezx != null && (this.ezx.status == 2 || this.ezx.status == 3);
    }

    public boolean bel() {
        return (this.ezx == null || this.ezy == null || this.ezx.status != 2) ? false : true;
    }

    public boolean bem() {
        return this.ezy != null && this.ezy.ezz == 1;
    }

    public long ben() {
        if (this.ezy != null) {
            return this.ezy.ezA;
        }
        return 0L;
    }

    public boolean beo() {
        return this.ezy != null && ((this.ezy.ezB && !this.ezy.aqn) || (this.ezy.ezC && !this.ezy.ezD));
    }

    public boolean bep() {
        return this.ezy != null && (this.ezy.ezB || this.ezy.ezC);
    }

    public boolean beq() {
        return (this.ezy == null || !this.ezy.ezB || this.ezy.aqn) ? false : true;
    }

    public boolean ber() {
        return (this.ezy == null || !this.ezy.ezC || this.ezy.ezD) ? false : true;
    }

    public int cF(long j) {
        return 100 - ((int) (((j * 1.0d) / 180.0d) * 100.0d));
    }

    public String[] cG(long j) {
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

    /* loaded from: classes3.dex */
    public static class a {
        public boolean aqn;
        public long ezA;
        public boolean ezB;
        public boolean ezC;
        public boolean ezD;
        public boolean ezE;
        public String ezF;
        public boolean ezG;
        public int ezz;

        public void parserJson(JSONObject jSONObject) {
            this.ezB = jSONObject.optInt("need_follow") == 1;
            this.ezC = jSONObject.optInt("need_send_gift") == 1;
            this.aqn = jSONObject.optInt("follow") == 1;
            this.ezD = jSONObject.optInt("send_gift") == 1;
            this.ezE = jSONObject.optInt("need_follow_sender") == 1;
            this.ezF = jSONObject.optString("sender_user_id");
            this.ezG = jSONObject.optInt("follow_sender") == 1;
            this.ezz = jSONObject.optInt("loot_result");
            this.ezA = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
