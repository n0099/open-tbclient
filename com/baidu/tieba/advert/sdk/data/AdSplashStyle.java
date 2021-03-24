package com.baidu.tieba.advert.sdk.data;

import android.text.TextUtils;
import androidx.core.app.NotificationCompatJellybean;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.coremedia.iso.boxes.FreeSpaceBox;
import d.b.b.e.m.b;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AdSplashStyle {

    /* renamed from: a  reason: collision with root package name */
    public int f14641a;

    /* renamed from: b  reason: collision with root package name */
    public int f14642b;

    /* renamed from: c  reason: collision with root package name */
    public String f14643c = TbadkCoreApplication.getInst().getString(R.string.advert_label);

    /* renamed from: d  reason: collision with root package name */
    public a f14644d;

    /* renamed from: e  reason: collision with root package name */
    public a f14645e;

    /* renamed from: f  reason: collision with root package name */
    public a f14646f;

    /* renamed from: g  reason: collision with root package name */
    public a f14647g;

    /* renamed from: h  reason: collision with root package name */
    public a f14648h;
    public a i;
    public a j;
    public a k;
    public a l;
    public a m;

    /* loaded from: classes4.dex */
    public enum SplashElement {
        LOGO,
        SKIP,
        LABEL,
        VOICE,
        WIFI_TIP
    }

    public boolean a() {
        return this.f14641a == 1;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            d(jSONObject);
            this.f14641a = jSONObject.optInt("logo_type", 0);
            this.f14642b = jSONObject.optInt("duration", 0);
            JSONObject optJSONObject = jSONObject.optJSONObject("style");
            this.f14644d = e(optJSONObject, "logo");
            this.f14645e = e(optJSONObject, FreeSpaceBox.TYPE);
            this.f14646f = e(optJSONObject, NotificationCompatJellybean.KEY_LABEL);
            this.f14647g = e(optJSONObject, "voice");
            this.f14648h = e(optJSONObject, "wifi_tip");
            this.i = e(optJSONObject, "logo_f");
            this.j = e(optJSONObject, "skip_f");
            this.k = e(optJSONObject, "label_f");
            this.l = e(optJSONObject, "voice_f");
            this.m = e(optJSONObject, "wifi_tip_f");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c(String str) {
        if (str == null) {
            return;
        }
        try {
            b(new JSONObject(str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.has("label_name")) {
                String optString = jSONObject.optString("label_name", "");
                this.f14643c = optString;
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                this.f14643c = this.f14643c.substring(0, Math.min(2, this.f14643c.length()));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public a e(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new a(jSONObject.optJSONObject(str));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f14649a;

        /* renamed from: b  reason: collision with root package name */
        public String f14650b;

        /* renamed from: c  reason: collision with root package name */
        public int[] f14651c;

        /* renamed from: d  reason: collision with root package name */
        public int f14652d;

        /* renamed from: e  reason: collision with root package name */
        public int f14653e;

        /* renamed from: f  reason: collision with root package name */
        public int f14654f;

        /* renamed from: g  reason: collision with root package name */
        public int f14655g;

        public a(int i, String str) {
            this.f14649a = i;
            this.f14650b = str;
            c();
        }

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            try {
                this.f14649a = jSONObject.optInt("l_gravity", -1);
                this.f14650b = jSONObject.optString("margin", "");
                c();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public void b(int i, String str) {
            this.f14649a = i;
            this.f14650b = str;
            c();
        }

        public void c() {
            String[] split;
            String str = this.f14650b;
            if (str == null || (split = str.split("_")) == null || split.length != 4) {
                return;
            }
            this.f14652d = b.d(split[0], 0);
            this.f14654f = b.d(split[1], 0);
            this.f14653e = b.d(split[2], 0);
            int d2 = b.d(split[3], 0);
            this.f14655g = d2;
            this.f14651c = r2;
            int[] iArr = {this.f14652d, this.f14654f, this.f14653e, d2};
        }

        public a(JSONObject jSONObject) {
            a(jSONObject);
        }
    }
}
