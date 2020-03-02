package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public h ezk;
    public a ezl;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.ezk = new h();
            this.ezk.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.ezl = new a();
            this.ezl.parserJson(optJSONObject2);
        }
    }

    public boolean bei() {
        return this.ezk != null && this.ezk.status == 5;
    }

    public boolean bej() {
        return this.ezk != null && this.ezk.status == 4;
    }

    public boolean isValid() {
        return this.ezk != null && (this.ezk.status == 2 || this.ezk.status == 3);
    }

    public boolean bek() {
        return (this.ezk == null || this.ezl == null || this.ezk.status != 2) ? false : true;
    }

    public boolean bel() {
        return this.ezl != null && this.ezl.ezm == 1;
    }

    public long bem() {
        if (this.ezl != null) {
            return this.ezl.ezn;
        }
        return 0L;
    }

    public boolean ben() {
        return this.ezl != null && ((this.ezl.ezo && !this.ezl.aqm) || (this.ezl.ezp && !this.ezl.ezq));
    }

    public boolean beo() {
        return this.ezl != null && (this.ezl.ezo || this.ezl.ezp);
    }

    public boolean bep() {
        return (this.ezl == null || !this.ezl.ezo || this.ezl.aqm) ? false : true;
    }

    public boolean beq() {
        return (this.ezl == null || !this.ezl.ezp || this.ezl.ezq) ? false : true;
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
        public boolean aqm;
        public int ezm;
        public long ezn;
        public boolean ezo;
        public boolean ezp;
        public boolean ezq;
        public boolean ezr;
        public String ezs;
        public boolean ezt;

        public void parserJson(JSONObject jSONObject) {
            this.ezo = jSONObject.optInt("need_follow") == 1;
            this.ezp = jSONObject.optInt("need_send_gift") == 1;
            this.aqm = jSONObject.optInt("follow") == 1;
            this.ezq = jSONObject.optInt("send_gift") == 1;
            this.ezr = jSONObject.optInt("need_follow_sender") == 1;
            this.ezs = jSONObject.optString("sender_user_id");
            this.ezt = jSONObject.optInt("follow_sender") == 1;
            this.ezm = jSONObject.optInt("loot_result");
            this.ezn = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
