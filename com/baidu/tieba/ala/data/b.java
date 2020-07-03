package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public h fDt;
    public a fDu;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.fDt = new h();
            this.fDt.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.fDu = new a();
            this.fDu.parserJson(optJSONObject2);
        }
    }

    public boolean bwr() {
        return this.fDt != null && this.fDt.status == 5;
    }

    public boolean bws() {
        return this.fDt != null && this.fDt.status == 4;
    }

    public boolean isValid() {
        return this.fDt != null && (this.fDt.status == 2 || this.fDt.status == 3);
    }

    public boolean bwt() {
        return (this.fDt == null || this.fDu == null || this.fDt.status != 2) ? false : true;
    }

    public boolean bwu() {
        return this.fDu != null && this.fDu.fDv == 1;
    }

    public long bwv() {
        if (this.fDu != null) {
            return this.fDu.fDw;
        }
        return 0L;
    }

    public boolean bww() {
        return this.fDu != null && ((this.fDu.fDx && !this.fDu.aRB) || (this.fDu.fDy && !this.fDu.fDz));
    }

    public boolean bwx() {
        return this.fDu != null && (this.fDu.fDx || this.fDu.fDy);
    }

    public boolean bwy() {
        return (this.fDu == null || !this.fDu.fDx || this.fDu.aRB) ? false : true;
    }

    public boolean bwz() {
        return (this.fDu == null || !this.fDu.fDy || this.fDu.fDz) ? false : true;
    }

    public int ds(long j) {
        return 100 - ((int) (((j * 1.0d) / 180.0d) * 100.0d));
    }

    public String[] dt(long j) {
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
        public boolean aRB;
        public boolean fDA;
        public String fDB;
        public boolean fDC;
        public int fDv;
        public long fDw;
        public boolean fDx;
        public boolean fDy;
        public boolean fDz;

        public void parserJson(JSONObject jSONObject) {
            this.fDx = jSONObject.optInt("need_follow") == 1;
            this.fDy = jSONObject.optInt("need_send_gift") == 1;
            this.aRB = jSONObject.optInt("follow") == 1;
            this.fDz = jSONObject.optInt("send_gift") == 1;
            this.fDA = jSONObject.optInt("need_follow_sender") == 1;
            this.fDB = jSONObject.optString("sender_user_id");
            this.fDC = jSONObject.optInt("follow_sender") == 1;
            this.fDv = jSONObject.optInt("loot_result");
            this.fDw = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
