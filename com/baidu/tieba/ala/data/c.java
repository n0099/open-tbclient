package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    public i gSr;
    public a gSs;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.gSr = new i();
            this.gSr.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.gSs = new a();
            this.gSs.parserJson(optJSONObject2);
        }
    }

    public boolean bUi() {
        return this.gSr != null && this.gSr.status == 5;
    }

    public boolean bUj() {
        return this.gSr != null && this.gSr.status == 4;
    }

    public boolean isValid() {
        return this.gSr != null && (this.gSr.status == 2 || this.gSr.status == 3);
    }

    public boolean bUk() {
        return (this.gSr == null || this.gSs == null || this.gSr.status != 2) ? false : true;
    }

    public boolean bUl() {
        return this.gSs != null && this.gSs.gSt == 1;
    }

    public long bUm() {
        if (this.gSs != null) {
            return this.gSs.gSu;
        }
        return 0L;
    }

    public boolean bUn() {
        return this.gSs != null && ((this.gSs.gSv && !this.gSs.isFollowed) || (this.gSs.gSw && !this.gSs.gSx));
    }

    public boolean bUo() {
        return this.gSs != null && (this.gSs.gSv || this.gSs.gSw);
    }

    public boolean bUp() {
        return (this.gSs == null || !this.gSs.gSv || this.gSs.isFollowed) ? false : true;
    }

    public boolean bUq() {
        return (this.gSs == null || !this.gSs.gSw || this.gSs.gSx) ? false : true;
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
        public boolean gSA;
        public int gSt;
        public long gSu;
        public boolean gSv;
        public boolean gSw;
        public boolean gSx;
        public boolean gSy;
        public String gSz;
        public boolean isFollowed;

        public void parserJson(JSONObject jSONObject) {
            this.gSv = jSONObject.optInt("need_follow") == 1;
            this.gSw = jSONObject.optInt("need_send_gift") == 1;
            this.isFollowed = jSONObject.optInt("follow") == 1;
            this.gSx = jSONObject.optInt("send_gift") == 1;
            this.gSy = jSONObject.optInt("need_follow_sender") == 1;
            this.gSz = jSONObject.optString("sender_user_id");
            this.gSA = jSONObject.optInt("follow_sender") == 1;
            this.gSt = jSONObject.optInt("loot_result");
            this.gSu = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
