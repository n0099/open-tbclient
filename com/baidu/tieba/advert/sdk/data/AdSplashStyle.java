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
    public a gkA;
    public a gkB;
    public a gkC;
    public a gkD;
    public a gkE;
    public a gkF;
    public a gkG;
    public int gkw;
    public a gkx;
    public a gky;
    public a gkz;
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
        public String gkH;
        public int[] gkI;
        public int gkJ;
        public int gravity;

        public a(int i, String str) {
            this.gravity = i;
            this.gkH = str;
            bMu();
        }

        public void aQ(int i, String str) {
            this.gravity = i;
            this.gkH = str;
            bMu();
        }

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    this.gravity = jSONObject.optInt("l_gravity", -1);
                    this.gkH = jSONObject.optString("margin", "");
                    bMu();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void bMu() {
            String[] split;
            if (this.gkH != null && (split = this.gkH.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) != null && split.length == 4) {
                this.gkJ = com.baidu.adp.lib.f.b.toInt(split[0], 0);
                this.Yh = com.baidu.adp.lib.f.b.toInt(split[1], 0);
                this.fvN = com.baidu.adp.lib.f.b.toInt(split[2], 0);
                this.Yi = com.baidu.adp.lib.f.b.toInt(split[3], 0);
                this.gkI = new int[4];
                this.gkI[0] = this.gkJ;
                this.gkI[1] = this.Yh;
                this.gkI[2] = this.fvN;
                this.gkI[3] = this.Yi;
            }
        }
    }

    public boolean bMt() {
        return this.gkw == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                dA(jSONObject);
                this.gkw = jSONObject.optInt("logo_type", 0);
                this.duration = jSONObject.optInt("duration", 0);
                JSONObject optJSONObject = jSONObject.optJSONObject("style");
                this.gkx = z(optJSONObject, "logo");
                this.gky = z(optJSONObject, FreeSpaceBox.TYPE);
                this.gkz = z(optJSONObject, "label");
                this.gkA = z(optJSONObject, "voice");
                this.gkB = z(optJSONObject, "wifi_tip");
                this.gkC = z(optJSONObject, "logo_f");
                this.gkD = z(optJSONObject, "skip_f");
                this.gkE = z(optJSONObject, "label_f");
                this.gkF = z(optJSONObject, "voice_f");
                this.gkG = z(optJSONObject, "wifi_tip_f");
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
