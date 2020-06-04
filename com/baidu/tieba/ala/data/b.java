package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public h fsi;
    public a fsj;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.fsi = new h();
            this.fsi.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.fsj = new a();
            this.fsj.parserJson(optJSONObject2);
        }
    }

    public boolean btw() {
        return this.fsi != null && this.fsi.status == 5;
    }

    public boolean btx() {
        return this.fsi != null && this.fsi.status == 4;
    }

    public boolean isValid() {
        return this.fsi != null && (this.fsi.status == 2 || this.fsi.status == 3);
    }

    public boolean bty() {
        return (this.fsi == null || this.fsj == null || this.fsi.status != 2) ? false : true;
    }

    public boolean btz() {
        return this.fsj != null && this.fsj.fsk == 1;
    }

    public long btA() {
        if (this.fsj != null) {
            return this.fsj.fsl;
        }
        return 0L;
    }

    public boolean btB() {
        return this.fsj != null && ((this.fsj.fsm && !this.fsj.aOV) || (this.fsj.fsn && !this.fsj.fso));
    }

    public boolean btC() {
        return this.fsj != null && (this.fsj.fsm || this.fsj.fsn);
    }

    public boolean btD() {
        return (this.fsj == null || !this.fsj.fsm || this.fsj.aOV) ? false : true;
    }

    public boolean btE() {
        return (this.fsj == null || !this.fsj.fsn || this.fsj.fso) ? false : true;
    }

    public int dp(long j) {
        return 100 - ((int) (((j * 1.0d) / 180.0d) * 100.0d));
    }

    public String[] dq(long j) {
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
        public boolean aOV;
        public int fsk;
        public long fsl;
        public boolean fsm;
        public boolean fsn;
        public boolean fso;
        public boolean fsp;
        public String fsq;
        public boolean fsr;

        public void parserJson(JSONObject jSONObject) {
            this.fsm = jSONObject.optInt("need_follow") == 1;
            this.fsn = jSONObject.optInt("need_send_gift") == 1;
            this.aOV = jSONObject.optInt("follow") == 1;
            this.fso = jSONObject.optInt("send_gift") == 1;
            this.fsp = jSONObject.optInt("need_follow_sender") == 1;
            this.fsq = jSONObject.optString("sender_user_id");
            this.fsr = jSONObject.optInt("follow_sender") == 1;
            this.fsk = jSONObject.optInt("loot_result");
            this.fsl = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
