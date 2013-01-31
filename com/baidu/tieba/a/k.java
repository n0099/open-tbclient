package com.baidu.tieba.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    Pattern a;
    private int d;
    private int e;
    private int b = 0;
    private String c = null;
    private String f = null;
    private SpannableStringBuilder g = null;

    public static boolean a(int i, int i2) {
        return i == 0 && i2 != 3;
    }

    public static boolean b(int i, int i2) {
        return (i != 0 || i2 == 3 || i2 == 2) ? false : true;
    }

    public static boolean c(int i, int i2) {
        return (i != 0 || i2 == 3 || i2 == 2 || i2 == 5) ? false : true;
    }

    public k() {
        this.a = null;
        this.a = Pattern.compile("(tieba.baidu.com/p/){1}\\d+");
    }

    public void a(int i) {
        this.b = i;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    public String d() {
        return this.c;
    }

    public void a(String str) {
        this.f = str;
    }

    public void a(SpannableStringBuilder spannableStringBuilder) {
        this.g = spannableStringBuilder;
    }

    public SpannableStringBuilder e() {
        return this.g;
    }

    public SpannableStringBuilder a(SpannableString spannableString) {
        if (this.g == null) {
            this.g = new SpannableStringBuilder();
        }
        this.g.append((CharSequence) spannableString);
        return this.g;
    }

    public SpannableString a(Context context) {
        String str;
        switch (this.b) {
            case 0:
                return new SpannableString(this.c);
            case 1:
                if (!this.c.endsWith(" ")) {
                    this.c = String.valueOf(this.c) + " ";
                }
                SpannableString spannableString = new SpannableString(this.c);
                spannableString.setSpan(new m(this, context), 0, this.c.length() - 1, 33);
                return spannableString;
            case 2:
                SpannableString spannableString2 = new SpannableString(String.valueOf(this.c) + " ");
                Bitmap e = TiebaApplication.b().e(this.c);
                if (e != null) {
                    com.baidu.tieba.view.af afVar = new com.baidu.tieba.view.af(e);
                    afVar.setBounds(0, 0, e.getWidth(), e.getHeight());
                    spannableString2.setSpan(new ImageSpan(afVar, 1), 0, this.c.length(), 33);
                    return spannableString2;
                }
                return spannableString2;
            case 3:
            default:
                return null;
            case 4:
                if (!this.c.endsWith(" ")) {
                    this.c = String.valueOf(this.c) + " ";
                }
                SpannableString spannableString3 = new SpannableString(this.c);
                spannableString3.setSpan(new n(this, context), 0, this.c.length() - 1, 33);
                return spannableString3;
            case 5:
                if (!this.c.endsWith(" ")) {
                    this.c = String.valueOf(this.c) + " ";
                }
                String string = context.getString(R.string.video);
                SpannableString spannableString4 = new SpannableString(String.valueOf(string) + this.c);
                spannableString4.setSpan(new l(this, context), string.length(), str.length() - 1, 33);
                return spannableString4;
        }
    }

    public SpannableString a(Context context, int i, int i2) {
        int height;
        if (this.b != 2) {
            return null;
        }
        SpannableString spannableString = new SpannableString(String.valueOf(this.c) + " ");
        Bitmap e = TiebaApplication.b().e(this.c);
        if (e != null) {
            com.baidu.tieba.view.af afVar = new com.baidu.tieba.view.af(e);
            if (i - i2 > 0) {
                height = e.getHeight() + ((i - i2) >> 1);
            } else {
                height = e.getHeight();
            }
            afVar.setBounds(0, 0, e.getWidth(), height);
            spannableString.setSpan(new ImageSpan(afVar, 1), 0, this.c.length(), 33);
        }
        return spannableString;
    }

    public String f() {
        return this.f;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.b = jSONObject.optInt("type", 0);
                if (this.b == 3) {
                    this.f = jSONObject.optString("src");
                    this.c = jSONObject.optString("bsize");
                    try {
                        String[] split = this.c.split(",");
                        this.d = Integer.valueOf(split[0]).intValue();
                        this.e = Integer.valueOf(split[1]).intValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (this.d <= 0) {
                        this.d = 1;
                    }
                    if (this.e <= 0) {
                        this.e = 1;
                    }
                } else if (this.b == 4) {
                    this.c = jSONObject.optString("text");
                    this.f = jSONObject.optString("uid");
                } else {
                    this.c = jSONObject.optString("text");
                    this.f = jSONObject.optString("link");
                }
                if (this.b != 0) {
                    this.c = this.c.replaceAll("\n", "");
                    this.f = this.f.replaceAll("\n", "");
                }
            } catch (Exception e2) {
                com.baidu.tieba.c.af.b("ContentData", "parserJson", "error = " + e2.getMessage());
            }
        }
    }
}
