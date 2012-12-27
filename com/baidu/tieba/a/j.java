package com.baidu.tieba.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    private int c;
    private int d;
    private int a = 0;
    private String b = null;
    private String e = null;
    private SpannableStringBuilder f = null;

    public static boolean a(int i, int i2) {
        return i == 0 && i2 != 3;
    }

    public static boolean b(int i, int i2) {
        return (i != 0 || i2 == 3 || i2 == 2) ? false : true;
    }

    public static boolean c(int i, int i2) {
        return (i != 0 || i2 == 3 || i2 == 2 || i2 == 5) ? false : true;
    }

    public int a() {
        return this.a;
    }

    public SpannableString a(Context context) {
        String str;
        switch (this.a) {
            case 0:
                return new SpannableString(this.b);
            case 1:
                if (!this.b.endsWith(" ")) {
                    this.b = String.valueOf(this.b) + " ";
                }
                SpannableString spannableString = new SpannableString(this.b);
                spannableString.setSpan(new l(this, context), 0, this.b.length() - 1, 33);
                return spannableString;
            case 2:
                SpannableString spannableString2 = new SpannableString(String.valueOf(this.b) + " ");
                Bitmap e = TiebaApplication.a().e(this.b);
                if (e != null) {
                    com.baidu.tieba.view.af afVar = new com.baidu.tieba.view.af(e);
                    afVar.setBounds(0, 0, e.getWidth(), e.getHeight());
                    spannableString2.setSpan(new ImageSpan(afVar, 1), 0, this.b.length(), 33);
                    return spannableString2;
                }
                return spannableString2;
            case 3:
            default:
                return null;
            case 4:
                if (!this.b.endsWith(" ")) {
                    this.b = String.valueOf(this.b) + " ";
                }
                SpannableString spannableString3 = new SpannableString(this.b);
                spannableString3.setSpan(new m(this, context), 0, this.b.length() - 1, 33);
                return spannableString3;
            case 5:
                if (!this.b.endsWith(" ")) {
                    this.b = String.valueOf(this.b) + " ";
                }
                String string = context.getString(R.string.video);
                SpannableString spannableString4 = new SpannableString(String.valueOf(string) + this.b);
                spannableString4.setSpan(new k(this, context), string.length(), str.length() - 1, 33);
                return spannableString4;
        }
    }

    public SpannableString a(Context context, int i, int i2) {
        if (this.a == 2) {
            SpannableString spannableString = new SpannableString(String.valueOf(this.b) + " ");
            Bitmap e = TiebaApplication.a().e(this.b);
            if (e != null) {
                com.baidu.tieba.view.af afVar = new com.baidu.tieba.view.af(e);
                afVar.setBounds(0, 0, e.getWidth(), i - i2 > 0 ? e.getHeight() + ((i - i2) >> 1) : e.getHeight());
                spannableString.setSpan(new ImageSpan(afVar, 1), 0, this.b.length(), 33);
            }
            return spannableString;
        }
        return null;
    }

    public SpannableStringBuilder a(SpannableString spannableString) {
        if (this.f == null) {
            this.f = new SpannableStringBuilder();
        }
        this.f.append((CharSequence) spannableString);
        return this.f;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(SpannableStringBuilder spannableStringBuilder) {
        this.f = spannableStringBuilder;
    }

    public void a(String str) {
        this.e = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.a = jSONObject.optInt("type", 0);
            if (this.a == 3) {
                this.e = jSONObject.optString("src");
                this.b = jSONObject.optString("bsize");
                try {
                    String[] split = this.b.split(",");
                    this.c = Integer.valueOf(split[0]).intValue();
                    this.d = Integer.valueOf(split[1]).intValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (this.c <= 0) {
                    this.c = 1;
                }
                if (this.d <= 0) {
                    this.d = 1;
                }
            } else if (this.a == 4) {
                this.b = jSONObject.optString("text");
                this.e = jSONObject.optString("uid");
            } else {
                this.b = jSONObject.optString("text");
                this.e = jSONObject.optString("link");
            }
            if (this.a != 0) {
                this.b = this.b.replaceAll("\n", "");
                this.e = this.e.replaceAll("\n", "");
            }
        } catch (Exception e2) {
            com.baidu.tieba.c.ae.b("ContentData", "parserJson", "error = " + e2.getMessage());
        }
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public String d() {
        return this.b;
    }

    public SpannableStringBuilder e() {
        return this.f;
    }

    public String f() {
        return this.e;
    }
}
