package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    public i gUa;
    public a gUb;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.gUa = new i();
            this.gUa.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.gUb = new a();
            this.gUb.parserJson(optJSONObject2);
        }
    }

    public boolean bXn() {
        return this.gUa != null && this.gUa.status == 5;
    }

    public boolean bXo() {
        return this.gUa != null && this.gUa.status == 4;
    }

    public boolean isValid() {
        return this.gUa != null && (this.gUa.status == 2 || this.gUa.status == 3);
    }

    public boolean bXp() {
        return (this.gUa == null || this.gUb == null || this.gUa.status != 2) ? false : true;
    }

    public boolean bXq() {
        return this.gUb != null && this.gUb.gUc == 1;
    }

    public long bXr() {
        if (this.gUb != null) {
            return this.gUb.gUd;
        }
        return 0L;
    }

    public boolean bXs() {
        return this.gUb != null && ((this.gUb.gUe && !this.gUb.isFollowed) || (this.gUb.gUf && !this.gUb.gUg));
    }

    public boolean bXt() {
        return this.gUb != null && (this.gUb.gUe || this.gUb.gUf);
    }

    public boolean bXu() {
        return (this.gUb == null || !this.gUb.gUe || this.gUb.isFollowed) ? false : true;
    }

    public boolean bXv() {
        return (this.gUb == null || !this.gUb.gUf || this.gUb.gUg) ? false : true;
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

    /* loaded from: classes11.dex */
    public static class a {
        public int gUc;
        public long gUd;
        public boolean gUe;
        public boolean gUf;
        public boolean gUg;
        public boolean gUh;
        public String gUi;
        public boolean gUj;
        public boolean isFollowed;

        public void parserJson(JSONObject jSONObject) {
            this.gUe = jSONObject.optInt("need_follow") == 1;
            this.gUf = jSONObject.optInt("need_send_gift") == 1;
            this.isFollowed = jSONObject.optInt("follow") == 1;
            this.gUg = jSONObject.optInt("send_gift") == 1;
            this.gUh = jSONObject.optInt("need_follow_sender") == 1;
            this.gUi = jSONObject.optString("sender_user_id");
            this.gUj = jSONObject.optInt("follow_sender") == 1;
            this.gUc = jSONObject.optInt("loot_result");
            this.gUd = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
