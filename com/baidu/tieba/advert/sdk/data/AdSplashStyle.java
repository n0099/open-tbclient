package com.baidu.tieba.advert.sdk.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.coremedia.iso.boxes.FreeSpaceBox;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AdSplashStyle {
    public int duration;
    public int gmo;
    public a gmp;
    public a gmq;
    public a gmr;
    public a gms;
    public a gmt;
    public a gmu;
    public a gmv;
    public a gmw;
    public a gmx;
    public a gmy;
    public String labelName = TbadkCoreApplication.getInst().getString(R.string.advert_label);

    /* loaded from: classes7.dex */
    public enum SplashElement {
        LOGO,
        SKIP,
        LABEL,
        VOICE,
        WIFI_TIP
    }

    /* loaded from: classes7.dex */
    public static class a {
        public int ZA;
        public int ZB;
        public int fxm;
        public int[] gmA;
        public int gmB;
        public String gmz;
        public int gravity;

        public a(int i, String str) {
            this.gravity = i;
            this.gmz = str;
            bME();
        }

        public void aQ(int i, String str) {
            this.gravity = i;
            this.gmz = str;
            bME();
        }

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    this.gravity = jSONObject.optInt("l_gravity", -1);
                    this.gmz = jSONObject.optString("margin", "");
                    bME();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void bME() {
            String[] split;
            if (this.gmz != null && (split = this.gmz.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) != null && split.length == 4) {
                this.gmB = com.baidu.adp.lib.f.b.toInt(split[0], 0);
                this.ZA = com.baidu.adp.lib.f.b.toInt(split[1], 0);
                this.fxm = com.baidu.adp.lib.f.b.toInt(split[2], 0);
                this.ZB = com.baidu.adp.lib.f.b.toInt(split[3], 0);
                this.gmA = new int[4];
                this.gmA[0] = this.gmB;
                this.gmA[1] = this.ZA;
                this.gmA[2] = this.fxm;
                this.gmA[3] = this.ZB;
            }
        }
    }

    public boolean bMD() {
        return this.gmo == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                dC(jSONObject);
                this.gmo = jSONObject.optInt("logo_type", 0);
                this.duration = jSONObject.optInt("duration", 0);
                JSONObject optJSONObject = jSONObject.optJSONObject("style");
                this.gmp = z(optJSONObject, "logo");
                this.gmq = z(optJSONObject, FreeSpaceBox.TYPE);
                this.gmr = z(optJSONObject, "label");
                this.gms = z(optJSONObject, "voice");
                this.gmt = z(optJSONObject, "wifi_tip");
                this.gmu = z(optJSONObject, "logo_f");
                this.gmv = z(optJSONObject, "skip_f");
                this.gmw = z(optJSONObject, "label_f");
                this.gmx = z(optJSONObject, "voice_f");
                this.gmy = z(optJSONObject, "wifi_tip_f");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void dC(JSONObject jSONObject) {
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
