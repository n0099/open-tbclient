package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public h ezj;
    public a ezk;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.ezj = new h();
            this.ezj.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.ezk = new a();
            this.ezk.parserJson(optJSONObject2);
        }
    }

    public boolean beg() {
        return this.ezj != null && this.ezj.status == 5;
    }

    public boolean beh() {
        return this.ezj != null && this.ezj.status == 4;
    }

    public boolean isValid() {
        return this.ezj != null && (this.ezj.status == 2 || this.ezj.status == 3);
    }

    public boolean bei() {
        return (this.ezj == null || this.ezk == null || this.ezj.status != 2) ? false : true;
    }

    public boolean bej() {
        return this.ezk != null && this.ezk.ezl == 1;
    }

    public long bek() {
        if (this.ezk != null) {
            return this.ezk.ezm;
        }
        return 0L;
    }

    public boolean bel() {
        return this.ezk != null && ((this.ezk.ezn && !this.ezk.aqm) || (this.ezk.ezo && !this.ezk.ezp));
    }

    public boolean bem() {
        return this.ezk != null && (this.ezk.ezn || this.ezk.ezo);
    }

    public boolean ben() {
        return (this.ezk == null || !this.ezk.ezn || this.ezk.aqm) ? false : true;
    }

    public boolean beo() {
        return (this.ezk == null || !this.ezk.ezo || this.ezk.ezp) ? false : true;
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
        public int ezl;
        public long ezm;
        public boolean ezn;
        public boolean ezo;
        public boolean ezp;
        public boolean ezq;
        public String ezr;
        public boolean ezs;

        public void parserJson(JSONObject jSONObject) {
            this.ezn = jSONObject.optInt("need_follow") == 1;
            this.ezo = jSONObject.optInt("need_send_gift") == 1;
            this.aqm = jSONObject.optInt("follow") == 1;
            this.ezp = jSONObject.optInt("send_gift") == 1;
            this.ezq = jSONObject.optInt("need_follow_sender") == 1;
            this.ezr = jSONObject.optString("sender_user_id");
            this.ezs = jSONObject.optInt("follow_sender") == 1;
            this.ezl = jSONObject.optInt("loot_result");
            this.ezm = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
