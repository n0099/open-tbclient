package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public i fUj;
    public a fUk;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.fUj = new i();
            this.fUj.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.fUk = new a();
            this.fUk.parserJson(optJSONObject2);
        }
    }

    public boolean bIM() {
        return this.fUj != null && this.fUj.status == 5;
    }

    public boolean bIN() {
        return this.fUj != null && this.fUj.status == 4;
    }

    public boolean isValid() {
        return this.fUj != null && (this.fUj.status == 2 || this.fUj.status == 3);
    }

    public boolean bIO() {
        return (this.fUj == null || this.fUk == null || this.fUj.status != 2) ? false : true;
    }

    public boolean bIP() {
        return this.fUk != null && this.fUk.fUl == 1;
    }

    public long bIQ() {
        if (this.fUk != null) {
            return this.fUk.fUm;
        }
        return 0L;
    }

    public boolean bIR() {
        return this.fUk != null && ((this.fUk.fUn && !this.fUk.aYk) || (this.fUk.fUo && !this.fUk.fUp));
    }

    public boolean bIS() {
        return this.fUk != null && (this.fUk.fUn || this.fUk.fUo);
    }

    public boolean bIT() {
        return (this.fUk == null || !this.fUk.fUn || this.fUk.aYk) ? false : true;
    }

    public boolean bIU() {
        return (this.fUk == null || !this.fUk.fUo || this.fUk.fUp) ? false : true;
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
        public boolean aYk;
        public int fUl;
        public long fUm;
        public boolean fUn;
        public boolean fUo;
        public boolean fUp;
        public boolean fUq;
        public String fUr;
        public boolean fUs;

        public void parserJson(JSONObject jSONObject) {
            this.fUn = jSONObject.optInt("need_follow") == 1;
            this.fUo = jSONObject.optInt("need_send_gift") == 1;
            this.aYk = jSONObject.optInt("follow") == 1;
            this.fUp = jSONObject.optInt("send_gift") == 1;
            this.fUq = jSONObject.optInt("need_follow_sender") == 1;
            this.fUr = jSONObject.optString("sender_user_id");
            this.fUs = jSONObject.optInt("follow_sender") == 1;
            this.fUl = jSONObject.optInt("loot_result");
            this.fUm = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
