package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    public i gSd;
    public a gSe;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.gSd = new i();
            this.gSd.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.gSe = new a();
            this.gSe.parserJson(optJSONObject2);
        }
    }

    public boolean bUb() {
        return this.gSd != null && this.gSd.status == 5;
    }

    public boolean bUc() {
        return this.gSd != null && this.gSd.status == 4;
    }

    public boolean isValid() {
        return this.gSd != null && (this.gSd.status == 2 || this.gSd.status == 3);
    }

    public boolean bUd() {
        return (this.gSd == null || this.gSe == null || this.gSd.status != 2) ? false : true;
    }

    public boolean bUe() {
        return this.gSe != null && this.gSe.gSf == 1;
    }

    public long bUf() {
        if (this.gSe != null) {
            return this.gSe.gSg;
        }
        return 0L;
    }

    public boolean bUg() {
        return this.gSe != null && ((this.gSe.gSh && !this.gSe.isFollowed) || (this.gSe.gSi && !this.gSe.gSj));
    }

    public boolean bUh() {
        return this.gSe != null && (this.gSe.gSh || this.gSe.gSi);
    }

    public boolean bUi() {
        return (this.gSe == null || !this.gSe.gSh || this.gSe.isFollowed) ? false : true;
    }

    public boolean bUj() {
        return (this.gSe == null || !this.gSe.gSi || this.gSe.gSj) ? false : true;
    }

    public int fk(long j) {
        return 100 - ((int) (((j * 1.0d) / 180.0d) * 100.0d));
    }

    public String[] fl(long j) {
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
        public int gSf;
        public long gSg;
        public boolean gSh;
        public boolean gSi;
        public boolean gSj;
        public boolean gSk;
        public String gSl;
        public boolean gSm;
        public boolean isFollowed;

        public void parserJson(JSONObject jSONObject) {
            this.gSh = jSONObject.optInt("need_follow") == 1;
            this.gSi = jSONObject.optInt("need_send_gift") == 1;
            this.isFollowed = jSONObject.optInt("follow") == 1;
            this.gSj = jSONObject.optInt("send_gift") == 1;
            this.gSk = jSONObject.optInt("need_follow_sender") == 1;
            this.gSl = jSONObject.optString("sender_user_id");
            this.gSm = jSONObject.optInt("follow_sender") == 1;
            this.gSf = jSONObject.optInt("loot_result");
            this.gSg = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
