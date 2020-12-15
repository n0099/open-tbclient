package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public i gIo;
    public a gIp;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.gIo = new i();
            this.gIo.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.gIp = new a();
            this.gIp.parserJson(optJSONObject2);
        }
    }

    public boolean bUJ() {
        return this.gIo != null && this.gIo.status == 5;
    }

    public boolean bUK() {
        return this.gIo != null && this.gIo.status == 4;
    }

    public boolean isValid() {
        return this.gIo != null && (this.gIo.status == 2 || this.gIo.status == 3);
    }

    public boolean bUL() {
        return (this.gIo == null || this.gIp == null || this.gIo.status != 2) ? false : true;
    }

    public boolean bUM() {
        return this.gIp != null && this.gIp.gIq == 1;
    }

    public long bUN() {
        if (this.gIp != null) {
            return this.gIp.gIr;
        }
        return 0L;
    }

    public boolean bUO() {
        return this.gIp != null && ((this.gIp.gIs && !this.gIp.isFollowed) || (this.gIp.gIt && !this.gIp.gIu));
    }

    public boolean bUP() {
        return this.gIp != null && (this.gIp.gIs || this.gIp.gIt);
    }

    public boolean bUQ() {
        return (this.gIp == null || !this.gIp.gIs || this.gIp.isFollowed) ? false : true;
    }

    public boolean bUR() {
        return (this.gIp == null || !this.gIp.gIt || this.gIp.gIu) ? false : true;
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
        public int gIq;
        public long gIr;
        public boolean gIs;
        public boolean gIt;
        public boolean gIu;
        public boolean gIv;
        public String gIw;
        public boolean gIx;
        public boolean isFollowed;

        public void parserJson(JSONObject jSONObject) {
            this.gIs = jSONObject.optInt("need_follow") == 1;
            this.gIt = jSONObject.optInt("need_send_gift") == 1;
            this.isFollowed = jSONObject.optInt("follow") == 1;
            this.gIu = jSONObject.optInt("send_gift") == 1;
            this.gIv = jSONObject.optInt("need_follow_sender") == 1;
            this.gIw = jSONObject.optString("sender_user_id");
            this.gIx = jSONObject.optInt("follow_sender") == 1;
            this.gIq = jSONObject.optInt("loot_result");
            this.gIr = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
