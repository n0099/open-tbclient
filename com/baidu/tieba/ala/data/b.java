package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public h euX;
    public a euY;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.euX = new h();
            this.euX.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.euY = new a();
            this.euY.parserJson(optJSONObject2);
        }
    }

    public boolean bbR() {
        return this.euX != null && this.euX.status == 5;
    }

    public boolean bbS() {
        return this.euX != null && this.euX.status == 4;
    }

    public boolean isValid() {
        return this.euX != null && (this.euX.status == 2 || this.euX.status == 3);
    }

    public boolean bbT() {
        return (this.euX == null || this.euY == null || this.euX.status != 2) ? false : true;
    }

    public boolean bbU() {
        return this.euY != null && this.euY.euZ == 1;
    }

    public long bbV() {
        if (this.euY != null) {
            return this.euY.eva;
        }
        return 0L;
    }

    public boolean bbW() {
        return this.euY != null && ((this.euY.evb && !this.euY.evd) || (this.euY.evc && !this.euY.eve));
    }

    public boolean bbX() {
        return this.euY != null && (this.euY.evb || this.euY.evc);
    }

    public boolean bbY() {
        return (this.euY == null || !this.euY.evb || this.euY.evd) ? false : true;
    }

    public boolean bbZ() {
        return (this.euY == null || !this.euY.evc || this.euY.eve) ? false : true;
    }

    public int cC(long j) {
        return 100 - ((int) (((j * 1.0d) / 180.0d) * 100.0d));
    }

    public String[] cD(long j) {
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

    /* loaded from: classes2.dex */
    public static class a {
        public int euZ;
        public long eva;
        public boolean evb;
        public boolean evc;
        public boolean evd;
        public boolean eve;
        public boolean evf;
        public String evg;
        public boolean evh;

        public void parserJson(JSONObject jSONObject) {
            this.evb = jSONObject.optInt("need_follow") == 1;
            this.evc = jSONObject.optInt("need_send_gift") == 1;
            this.evd = jSONObject.optInt("follow") == 1;
            this.eve = jSONObject.optInt("send_gift") == 1;
            this.evf = jSONObject.optInt("need_follow_sender") == 1;
            this.evg = jSONObject.optString("sender_user_id");
            this.evh = jSONObject.optInt("follow_sender") == 1;
            this.euZ = jSONObject.optInt("loot_result");
            this.eva = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
