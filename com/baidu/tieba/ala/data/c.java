package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    public i gPu;
    public a gPv;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.gPu = new i();
            this.gPu.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.gPv = new a();
            this.gPv.parserJson(optJSONObject2);
        }
    }

    public boolean bTw() {
        return this.gPu != null && this.gPu.status == 5;
    }

    public boolean bTx() {
        return this.gPu != null && this.gPu.status == 4;
    }

    public boolean isValid() {
        return this.gPu != null && (this.gPu.status == 2 || this.gPu.status == 3);
    }

    public boolean bTy() {
        return (this.gPu == null || this.gPv == null || this.gPu.status != 2) ? false : true;
    }

    public boolean bTz() {
        return this.gPv != null && this.gPv.gPw == 1;
    }

    public long bTA() {
        if (this.gPv != null) {
            return this.gPv.gPx;
        }
        return 0L;
    }

    public boolean bTB() {
        return this.gPv != null && ((this.gPv.gPy && !this.gPv.isFollowed) || (this.gPv.gPz && !this.gPv.gPA));
    }

    public boolean bTC() {
        return this.gPv != null && (this.gPv.gPy || this.gPv.gPz);
    }

    public boolean bTD() {
        return (this.gPv == null || !this.gPv.gPy || this.gPv.isFollowed) ? false : true;
    }

    public boolean bTE() {
        return (this.gPv == null || !this.gPv.gPz || this.gPv.gPA) ? false : true;
    }

    public int fe(long j) {
        return 100 - ((int) (((j * 1.0d) / 180.0d) * 100.0d));
    }

    public String[] ff(long j) {
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

    /* loaded from: classes10.dex */
    public static class a {
        public boolean gPA;
        public boolean gPB;
        public String gPC;
        public boolean gPD;
        public int gPw;
        public long gPx;
        public boolean gPy;
        public boolean gPz;
        public boolean isFollowed;

        public void parserJson(JSONObject jSONObject) {
            this.gPy = jSONObject.optInt("need_follow") == 1;
            this.gPz = jSONObject.optInt("need_send_gift") == 1;
            this.isFollowed = jSONObject.optInt("follow") == 1;
            this.gPA = jSONObject.optInt("send_gift") == 1;
            this.gPB = jSONObject.optInt("need_follow_sender") == 1;
            this.gPC = jSONObject.optString("sender_user_id");
            this.gPD = jSONObject.optInt("follow_sender") == 1;
            this.gPw = jSONObject.optInt("loot_result");
            this.gPx = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
