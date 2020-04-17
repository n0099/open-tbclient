package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public h fen;
    public a feo;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.fen = new h();
            this.fen.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.feo = new a();
            this.feo.parserJson(optJSONObject2);
        }
    }

    public boolean bnE() {
        return this.fen != null && this.fen.status == 5;
    }

    public boolean bnF() {
        return this.fen != null && this.fen.status == 4;
    }

    public boolean isValid() {
        return this.fen != null && (this.fen.status == 2 || this.fen.status == 3);
    }

    public boolean bnG() {
        return (this.fen == null || this.feo == null || this.fen.status != 2) ? false : true;
    }

    public boolean bnH() {
        return this.feo != null && this.feo.fep == 1;
    }

    public long bnI() {
        if (this.feo != null) {
            return this.feo.feq;
        }
        return 0L;
    }

    public boolean bnJ() {
        return this.feo != null && ((this.feo.fer && !this.feo.aJg) || (this.feo.fes && !this.feo.fet));
    }

    public boolean bnK() {
        return this.feo != null && (this.feo.fer || this.feo.fes);
    }

    public boolean bnL() {
        return (this.feo == null || !this.feo.fer || this.feo.aJg) ? false : true;
    }

    public boolean bnM() {
        return (this.feo == null || !this.feo.fes || this.feo.fet) ? false : true;
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
        public boolean aJg;
        public int fep;
        public long feq;
        public boolean fer;
        public boolean fes;
        public boolean fet;
        public boolean feu;
        public String fev;
        public boolean few;

        public void parserJson(JSONObject jSONObject) {
            this.fer = jSONObject.optInt("need_follow") == 1;
            this.fes = jSONObject.optInt("need_send_gift") == 1;
            this.aJg = jSONObject.optInt("follow") == 1;
            this.fet = jSONObject.optInt("send_gift") == 1;
            this.feu = jSONObject.optInt("need_follow_sender") == 1;
            this.fev = jSONObject.optString("sender_user_id");
            this.few = jSONObject.optInt("follow_sender") == 1;
            this.fep = jSONObject.optInt("loot_result");
            this.feq = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
