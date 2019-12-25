package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public h etM;
    public a etN;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.etM = new h();
            this.etM.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.etN = new a();
            this.etN.parserJson(optJSONObject2);
        }
    }

    public boolean bbw() {
        return this.etM != null && this.etM.status == 5;
    }

    public boolean bbx() {
        return this.etM != null && this.etM.status == 4;
    }

    public boolean isValid() {
        return this.etM != null && (this.etM.status == 2 || this.etM.status == 3);
    }

    public boolean bby() {
        return (this.etM == null || this.etN == null || this.etM.status != 2) ? false : true;
    }

    public boolean bbz() {
        return this.etN != null && this.etN.etO == 1;
    }

    public long bbA() {
        if (this.etN != null) {
            return this.etN.etP;
        }
        return 0L;
    }

    public boolean bbB() {
        return this.etN != null && ((this.etN.etQ && !this.etN.etS) || (this.etN.etR && !this.etN.etT));
    }

    public boolean bbC() {
        return this.etN != null && (this.etN.etQ || this.etN.etR);
    }

    public boolean bbD() {
        return (this.etN == null || !this.etN.etQ || this.etN.etS) ? false : true;
    }

    public boolean bbE() {
        return (this.etN == null || !this.etN.etR || this.etN.etT) ? false : true;
    }

    public int cx(long j) {
        return 100 - ((int) (((j * 1.0d) / 180.0d) * 100.0d));
    }

    public String[] cy(long j) {
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
        public int etO;
        public long etP;
        public boolean etQ;
        public boolean etR;
        public boolean etS;
        public boolean etT;
        public boolean etU;
        public String etV;
        public boolean etW;

        public void parserJson(JSONObject jSONObject) {
            this.etQ = jSONObject.optInt("need_follow") == 1;
            this.etR = jSONObject.optInt("need_send_gift") == 1;
            this.etS = jSONObject.optInt("follow") == 1;
            this.etT = jSONObject.optInt("send_gift") == 1;
            this.etU = jSONObject.optInt("need_follow_sender") == 1;
            this.etV = jSONObject.optString("sender_user_id");
            this.etW = jSONObject.optInt("follow_sender") == 1;
            this.etO = jSONObject.optInt("loot_result");
            this.etP = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
