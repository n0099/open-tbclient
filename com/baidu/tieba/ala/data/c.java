package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public i gzq;
    public a gzr;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.gzq = new i();
            this.gzq.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.gzr = new a();
            this.gzr.parserJson(optJSONObject2);
        }
    }

    public boolean bQY() {
        return this.gzq != null && this.gzq.status == 5;
    }

    public boolean bQZ() {
        return this.gzq != null && this.gzq.status == 4;
    }

    public boolean isValid() {
        return this.gzq != null && (this.gzq.status == 2 || this.gzq.status == 3);
    }

    public boolean bRa() {
        return (this.gzq == null || this.gzr == null || this.gzq.status != 2) ? false : true;
    }

    public boolean bRb() {
        return this.gzr != null && this.gzr.gzs == 1;
    }

    public long bRc() {
        if (this.gzr != null) {
            return this.gzr.gzt;
        }
        return 0L;
    }

    public boolean bRd() {
        return this.gzr != null && ((this.gzr.gzu && !this.gzr.isFollowed) || (this.gzr.gzv && !this.gzr.gzw));
    }

    public boolean bRe() {
        return this.gzr != null && (this.gzr.gzu || this.gzr.gzv);
    }

    public boolean bRf() {
        return (this.gzr == null || !this.gzr.gzu || this.gzr.isFollowed) ? false : true;
    }

    public boolean bRg() {
        return (this.gzr == null || !this.gzr.gzv || this.gzr.gzw) ? false : true;
    }

    public int eA(long j) {
        return 100 - ((int) (((j * 1.0d) / 180.0d) * 100.0d));
    }

    public String[] eB(long j) {
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

    /* loaded from: classes4.dex */
    public static class a {
        public int gzs;
        public long gzt;
        public boolean gzu;
        public boolean gzv;
        public boolean gzw;
        public boolean gzx;
        public String gzy;
        public boolean gzz;
        public boolean isFollowed;

        public void parserJson(JSONObject jSONObject) {
            this.gzu = jSONObject.optInt("need_follow") == 1;
            this.gzv = jSONObject.optInt("need_send_gift") == 1;
            this.isFollowed = jSONObject.optInt("follow") == 1;
            this.gzw = jSONObject.optInt("send_gift") == 1;
            this.gzx = jSONObject.optInt("need_follow_sender") == 1;
            this.gzy = jSONObject.optString("sender_user_id");
            this.gzz = jSONObject.optInt("follow_sender") == 1;
            this.gzs = jSONObject.optInt("loot_result");
            this.gzt = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
