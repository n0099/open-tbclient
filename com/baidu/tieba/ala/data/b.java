package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public h fes;
    public a fet;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.fes = new h();
            this.fes.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.fet = new a();
            this.fet.parserJson(optJSONObject2);
        }
    }

    public boolean bnC() {
        return this.fes != null && this.fes.status == 5;
    }

    public boolean bnD() {
        return this.fes != null && this.fes.status == 4;
    }

    public boolean isValid() {
        return this.fes != null && (this.fes.status == 2 || this.fes.status == 3);
    }

    public boolean bnE() {
        return (this.fes == null || this.fet == null || this.fes.status != 2) ? false : true;
    }

    public boolean bnF() {
        return this.fet != null && this.fet.feu == 1;
    }

    public long bnG() {
        if (this.fet != null) {
            return this.fet.fev;
        }
        return 0L;
    }

    public boolean bnH() {
        return this.fet != null && ((this.fet.few && !this.fet.aJm) || (this.fet.fex && !this.fet.fey));
    }

    public boolean bnI() {
        return this.fet != null && (this.fet.few || this.fet.fex);
    }

    public boolean bnJ() {
        return (this.fet == null || !this.fet.few || this.fet.aJm) ? false : true;
    }

    public boolean bnK() {
        return (this.fet == null || !this.fet.fex || this.fet.fey) ? false : true;
    }

    public int dn(long j) {
        return 100 - ((int) (((j * 1.0d) / 180.0d) * 100.0d));
    }

    /* renamed from: do  reason: not valid java name */
    public String[] m32do(long j) {
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
        public boolean aJm;
        public String feA;
        public boolean feB;
        public int feu;
        public long fev;
        public boolean few;
        public boolean fex;
        public boolean fey;
        public boolean fez;

        public void parserJson(JSONObject jSONObject) {
            this.few = jSONObject.optInt("need_follow") == 1;
            this.fex = jSONObject.optInt("need_send_gift") == 1;
            this.aJm = jSONObject.optInt("follow") == 1;
            this.fey = jSONObject.optInt("send_gift") == 1;
            this.fez = jSONObject.optInt("need_follow_sender") == 1;
            this.feA = jSONObject.optString("sender_user_id");
            this.feB = jSONObject.optInt("follow_sender") == 1;
            this.feu = jSONObject.optInt("loot_result");
            this.fev = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
