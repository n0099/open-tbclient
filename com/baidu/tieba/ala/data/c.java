package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public i gtV;
    public a gtW;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("red_packet_info");
        if (optJSONObject != null) {
            this.gtV = new i();
            this.gtV.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("user_cond");
        if (optJSONObject2 != null) {
            this.gtW = new a();
            this.gtW.parserJson(optJSONObject2);
        }
    }

    public boolean bPf() {
        return this.gtV != null && this.gtV.status == 5;
    }

    public boolean bPg() {
        return this.gtV != null && this.gtV.status == 4;
    }

    public boolean isValid() {
        return this.gtV != null && (this.gtV.status == 2 || this.gtV.status == 3);
    }

    public boolean bPh() {
        return (this.gtV == null || this.gtW == null || this.gtV.status != 2) ? false : true;
    }

    public boolean bPi() {
        return this.gtW != null && this.gtW.gtX == 1;
    }

    public long bPj() {
        if (this.gtW != null) {
            return this.gtW.gtY;
        }
        return 0L;
    }

    public boolean bPk() {
        return this.gtW != null && ((this.gtW.gtZ && !this.gtW.isFollowed) || (this.gtW.gua && !this.gtW.gub));
    }

    public boolean bPl() {
        return this.gtW != null && (this.gtW.gtZ || this.gtW.gua);
    }

    public boolean bPm() {
        return (this.gtW == null || !this.gtW.gtZ || this.gtW.isFollowed) ? false : true;
    }

    public boolean bPn() {
        return (this.gtW == null || !this.gtW.gua || this.gtW.gub) ? false : true;
    }

    public int ee(long j) {
        return 100 - ((int) (((j * 1.0d) / 180.0d) * 100.0d));
    }

    public String[] ef(long j) {
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
        public int gtX;
        public long gtY;
        public boolean gtZ;
        public boolean gua;
        public boolean gub;
        public boolean guc;
        public String gud;
        public boolean gue;
        public boolean isFollowed;

        public void parserJson(JSONObject jSONObject) {
            this.gtZ = jSONObject.optInt("need_follow") == 1;
            this.gua = jSONObject.optInt("need_send_gift") == 1;
            this.isFollowed = jSONObject.optInt("follow") == 1;
            this.gub = jSONObject.optInt("send_gift") == 1;
            this.guc = jSONObject.optInt("need_follow_sender") == 1;
            this.gud = jSONObject.optString("sender_user_id");
            this.gue = jSONObject.optInt("follow_sender") == 1;
            this.gtX = jSONObject.optInt("loot_result");
            this.gtY = jSONObject.optLong(LogConfig.LOG_AMOUNT);
        }
    }
}
