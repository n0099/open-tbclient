package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public h ezT;
    public a ezU;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.ezT = new h();
            this.ezT.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.ezU = new a();
            this.ezU.parserJson(optJSONObject2);
        }
    }

    public boolean beo() {
        return this.ezT != null && this.ezT.status == 5;
    }

    public boolean bep() {
        return this.ezT != null && this.ezT.status == 4;
    }

    public boolean isValid() {
        return this.ezT != null && (this.ezT.status == 2 || this.ezT.status == 3);
    }

    public boolean beq() {
        return (this.ezT == null || this.ezU == null || this.ezT.status != 2) ? false : true;
    }

    public boolean ber() {
        return this.ezU != null && this.ezU.ezV == 1;
    }

    public long bes() {
        if (this.ezU != null) {
            return this.ezU.ezW;
        }
        return 0L;
    }

    public boolean bet() {
        return this.ezU != null && ((this.ezU.ezX && !this.ezU.aqx) || (this.ezU.ezY && !this.ezU.ezZ));
    }

    public boolean beu() {
        return this.ezU != null && (this.ezU.ezX || this.ezU.ezY);
    }

    public boolean bev() {
        return (this.ezU == null || !this.ezU.ezX || this.ezU.aqx) ? false : true;
    }

    public boolean bew() {
        return (this.ezU == null || !this.ezU.ezY || this.ezU.ezZ) ? false : true;
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
        public boolean aqx;
        public boolean eAa;
        public String eAb;
        public boolean eAc;
        public int ezV;
        public long ezW;
        public boolean ezX;
        public boolean ezY;
        public boolean ezZ;

        public void parserJson(JSONObject jSONObject) {
            this.ezX = jSONObject.optInt("need_follow") == 1;
            this.ezY = jSONObject.optInt("need_send_gift") == 1;
            this.aqx = jSONObject.optInt("follow") == 1;
            this.ezZ = jSONObject.optInt("send_gift") == 1;
            this.eAa = jSONObject.optInt("need_follow_sender") == 1;
            this.eAb = jSONObject.optString("sender_user_id");
            this.eAc = jSONObject.optInt("follow_sender") == 1;
            this.ezV = jSONObject.optInt("loot_result");
            this.ezW = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
