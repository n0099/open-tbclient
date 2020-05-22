package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public h frX;
    public a frY;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.frX = new h();
            this.frX.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.frY = new a();
            this.frY.parserJson(optJSONObject2);
        }
    }

    public boolean btu() {
        return this.frX != null && this.frX.status == 5;
    }

    public boolean btv() {
        return this.frX != null && this.frX.status == 4;
    }

    public boolean isValid() {
        return this.frX != null && (this.frX.status == 2 || this.frX.status == 3);
    }

    public boolean btw() {
        return (this.frX == null || this.frY == null || this.frX.status != 2) ? false : true;
    }

    public boolean btx() {
        return this.frY != null && this.frY.frZ == 1;
    }

    public long bty() {
        if (this.frY != null) {
            return this.frY.fsa;
        }
        return 0L;
    }

    public boolean btz() {
        return this.frY != null && ((this.frY.fsb && !this.frY.aOV) || (this.frY.fsc && !this.frY.fsd));
    }

    public boolean btA() {
        return this.frY != null && (this.frY.fsb || this.frY.fsc);
    }

    public boolean btB() {
        return (this.frY == null || !this.frY.fsb || this.frY.aOV) ? false : true;
    }

    public boolean btC() {
        return (this.frY == null || !this.frY.fsc || this.frY.fsd) ? false : true;
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
        public int frZ;
        public long fsa;
        public boolean fsb;
        public boolean fsc;
        public boolean fsd;
        public boolean fse;
        public String fsf;
        public boolean fsg;

        public void parserJson(JSONObject jSONObject) {
            this.fsb = jSONObject.optInt("need_follow") == 1;
            this.fsc = jSONObject.optInt("need_send_gift") == 1;
            this.aOV = jSONObject.optInt("follow") == 1;
            this.fsd = jSONObject.optInt("send_gift") == 1;
            this.fse = jSONObject.optInt("need_follow_sender") == 1;
            this.fsf = jSONObject.optString("sender_user_id");
            this.fsg = jSONObject.optInt("follow_sender") == 1;
            this.frZ = jSONObject.optInt("loot_result");
            this.fsa = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
