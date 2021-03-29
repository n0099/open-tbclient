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
    public int f14642a;

    /* renamed from: b  reason: collision with root package name */
    public int f14643b;

    /* renamed from: c  reason: collision with root package name */
    public String f14644c = TbadkCoreApplication.getInst().getString(R.string.advert_label);

    /* renamed from: d  reason: collision with root package name */
    public a f14645d;

    /* renamed from: e  reason: collision with root package name */
    public a f14646e;

    /* renamed from: f  reason: collision with root package name */
    public a f14647f;

    /* renamed from: g  reason: collision with root package name */
    public a f14648g;

    /* renamed from: h  reason: collision with root package name */
    public a f14649h;
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
        return this.f14642a == 1;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            d(jSONObject);
            this.f14642a = jSONObject.optInt("logo_type", 0);
            this.f14643b = jSONObject.optInt("duration", 0);
            JSONObject optJSONObject = jSONObject.optJSONObject("style");
            this.f14645d = e(optJSONObject, "logo");
            this.f14646e = e(optJSONObject, FreeSpaceBox.TYPE);
            this.f14647f = e(optJSONObject, NotificationCompatJellybean.KEY_LABEL);
            this.f14648g = e(optJSONObject, "voice");
            this.f14649h = e(optJSONObject, "wifi_tip");
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
                this.f14644c = optString;
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                this.f14644c = this.f14644c.substring(0, Math.min(2, this.f14644c.length()));
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
        public int f14650a;

        /* renamed from: b  reason: collision with root package name */
        public String f14651b;

        /* renamed from: c  reason: collision with root package name */
        public int[] f14652c;

        /* renamed from: d  reason: collision with root package name */
        public int f14653d;

        /* renamed from: e  reason: collision with root package name */
        public int f14654e;

        /* renamed from: f  reason: collision with root package name */
        public int f14655f;

        /* renamed from: g  reason: collision with root package name */
        public int f14656g;

        public a(int i, String str) {
            this.f14650a = i;
            this.f14651b = str;
            c();
        }

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            try {
                this.f14650a = jSONObject.optInt("l_gravity", -1);
                this.f14651b = jSONObject.optString("margin", "");
                c();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public void b(int i, String str) {
            this.f14650a = i;
            this.f14651b = str;
            c();
        }

        public void c() {
            String[] split;
            String str = this.f14651b;
            if (str == null || (split = str.split("_")) == null || split.length != 4) {
                return;
            }
            this.f14653d = b.d(split[0], 0);
            this.f14655f = b.d(split[1], 0);
            this.f14654e = b.d(split[2], 0);
            int d2 = b.d(split[3], 0);
            this.f14656g = d2;
            this.f14652c = r2;
            int[] iArr = {this.f14653d, this.f14655f, this.f14654e, d2};
        }

        public a(JSONObject jSONObject) {
            a(jSONObject);
        }
    }
}
