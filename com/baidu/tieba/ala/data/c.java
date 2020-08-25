package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public i fUf;
    public a fUg;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.fUf = new i();
            this.fUf.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.fUg = new a();
            this.fUg.parserJson(optJSONObject2);
        }
    }

    public boolean bIL() {
        return this.fUf != null && this.fUf.status == 5;
    }

    public boolean bIM() {
        return this.fUf != null && this.fUf.status == 4;
    }

    public boolean isValid() {
        return this.fUf != null && (this.fUf.status == 2 || this.fUf.status == 3);
    }

    public boolean bIN() {
        return (this.fUf == null || this.fUg == null || this.fUf.status != 2) ? false : true;
    }

    public boolean bIO() {
        return this.fUg != null && this.fUg.fUh == 1;
    }

    public long bIP() {
        if (this.fUg != null) {
            return this.fUg.fUi;
        }
        return 0L;
    }

    public boolean bIQ() {
        return this.fUg != null && ((this.fUg.fUj && !this.fUg.aYi) || (this.fUg.fUk && !this.fUg.fUl));
    }

    public boolean bIR() {
        return this.fUg != null && (this.fUg.fUj || this.fUg.fUk);
    }

    public boolean bIS() {
        return (this.fUg == null || !this.fUg.fUj || this.fUg.aYi) ? false : true;
    }

    public boolean bIT() {
        return (this.fUg == null || !this.fUg.fUk || this.fUg.fUl) ? false : true;
    }

    public int dR(long j) {
        return 100 - ((int) (((j * 1.0d) / 180.0d) * 100.0d));
    }

    public String[] dS(long j) {
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

    /* loaded from: classes7.dex */
    public static class a {
        public boolean aYi;
        public int fUh;
        public long fUi;
        public boolean fUj;
        public boolean fUk;
        public boolean fUl;
        public boolean fUm;
        public String fUn;
        public boolean fUo;

        public void parserJson(JSONObject jSONObject) {
            this.fUj = jSONObject.optInt("need_follow") == 1;
            this.fUk = jSONObject.optInt("need_send_gift") == 1;
            this.aYi = jSONObject.optInt("follow") == 1;
            this.fUl = jSONObject.optInt("send_gift") == 1;
            this.fUm = jSONObject.optInt("need_follow_sender") == 1;
            this.fUn = jSONObject.optString("sender_user_id");
            this.fUo = jSONObject.optInt("follow_sender") == 1;
            this.fUh = jSONObject.optInt("loot_result");
            this.fUi = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
