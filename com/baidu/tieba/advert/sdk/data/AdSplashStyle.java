package com.baidu.tieba.advert.sdk.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.coremedia.iso.boxes.FreeSpaceBox;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class AdSplashStyle {
    public int duration;
    public int gkK;
    public a gkL;
    public a gkM;
    public a gkN;
    public a gkO;
    public a gkP;
    public a gkQ;
    public a gkR;
    public a gkS;
    public a gkT;
    public a gkU;
    public String labelName = TbadkCoreApplication.getInst().getString(R.string.advert_label);

    /* loaded from: classes8.dex */
    public enum SplashElement {
        LOGO,
        SKIP,
        LABEL,
        VOICE,
        WIFI_TIP
    }

    /* loaded from: classes8.dex */
    public static class a {
        public int Yh;
        public int Yi;
        public int fvN;
        public String gkV;
        public int[] gkW;
        public int gkX;
        public int gravity;

        public a(int i, String str) {
            this.gravity = i;
            this.gkV = str;
            bMB();
        }

        public void aQ(int i, String str) {
            this.gravity = i;
            this.gkV = str;
            bMB();
        }

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    this.gravity = jSONObject.optInt("l_gravity", -1);
                    this.gkV = jSONObject.optString("margin", "");
                    bMB();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void bMB() {
            String[] split;
            if (this.gkV != null && (split = this.gkV.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) != null && split.length == 4) {
                this.gkX = com.baidu.adp.lib.f.b.toInt(split[0], 0);
                this.Yh = com.baidu.adp.lib.f.b.toInt(split[1], 0);
                this.fvN = com.baidu.adp.lib.f.b.toInt(split[2], 0);
                this.Yi = com.baidu.adp.lib.f.b.toInt(split[3], 0);
                this.gkW = new int[4];
                this.gkW[0] = this.gkX;
                this.gkW[1] = this.Yh;
                this.gkW[2] = this.fvN;
                this.gkW[3] = this.Yi;
            }
        }
    }

    public boolean bMA() {
        return this.gkK == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                dA(jSONObject);
                this.gkK = jSONObject.optInt("logo_type", 0);
                this.duration = jSONObject.optInt("duration", 0);
                JSONObject optJSONObject = jSONObject.optJSONObject("style");
                this.gkL = z(optJSONObject, "logo");
                this.gkM = z(optJSONObject, FreeSpaceBox.TYPE);
                this.gkN = z(optJSONObject, "label");
                this.gkO = z(optJSONObject, "voice");
                this.gkP = z(optJSONObject, "wifi_tip");
                this.gkQ = z(optJSONObject, "logo_f");
                this.gkR = z(optJSONObject, "skip_f");
                this.gkS = z(optJSONObject, "label_f");
                this.gkT = z(optJSONObject, "voice_f");
                this.gkU = z(optJSONObject, "wifi_tip_f");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void dA(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("label_name")) {
                    this.labelName = jSONObject.optString("label_name", "");
                    if (!TextUtils.isEmpty(this.labelName)) {
                        this.labelName = this.labelName.substring(0, Math.min(2, this.labelName.length()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void parseJsonStr(String str) {
        if (str != null) {
            try {
                parseJson(new JSONObject(str));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public a z(JSONObject jSONObject, String str) {
        a aVar;
        if (jSONObject == null) {
            return null;
        }
        try {
            aVar = new a(jSONObject.optJSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
            aVar = null;
        }
        return aVar;
    }
}
