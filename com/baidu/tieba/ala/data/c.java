package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public i gIm;
    public a gIn;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.gIm = new i();
            this.gIm.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.gIn = new a();
            this.gIn.parserJson(optJSONObject2);
        }
    }

    public boolean bUI() {
        return this.gIm != null && this.gIm.status == 5;
    }

    public boolean bUJ() {
        return this.gIm != null && this.gIm.status == 4;
    }

    public boolean isValid() {
        return this.gIm != null && (this.gIm.status == 2 || this.gIm.status == 3);
    }

    public boolean bUK() {
        return (this.gIm == null || this.gIn == null || this.gIm.status != 2) ? false : true;
    }

    public boolean bUL() {
        return this.gIn != null && this.gIn.gIo == 1;
    }

    public long bUM() {
        if (this.gIn != null) {
            return this.gIn.gIp;
        }
        return 0L;
    }

    public boolean bUN() {
        return this.gIn != null && ((this.gIn.gIq && !this.gIn.isFollowed) || (this.gIn.gIr && !this.gIn.gIs));
    }

    public boolean bUO() {
        return this.gIn != null && (this.gIn.gIq || this.gIn.gIr);
    }

    public boolean bUP() {
        return (this.gIn == null || !this.gIn.gIq || this.gIn.isFollowed) ? false : true;
    }

    public boolean bUQ() {
        return (this.gIn == null || !this.gIn.gIr || this.gIn.gIs) ? false : true;
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

    /* loaded from: classes4.dex */
    public static class a {
        public int gIo;
        public long gIp;
        public boolean gIq;
        public boolean gIr;
        public boolean gIs;
        public boolean gIt;
        public String gIu;
        public boolean gIv;
        public boolean isFollowed;

        public void parserJson(JSONObject jSONObject) {
            this.gIq = jSONObject.optInt("need_follow") == 1;
            this.gIr = jSONObject.optInt("need_send_gift") == 1;
            this.isFollowed = jSONObject.optInt("follow") == 1;
            this.gIs = jSONObject.optInt("send_gift") == 1;
            this.gIt = jSONObject.optInt("need_follow_sender") == 1;
            this.gIu = jSONObject.optString("sender_user_id");
            this.gIv = jSONObject.optInt("follow_sender") == 1;
            this.gIo = jSONObject.optInt("loot_result");
            this.gIp = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
