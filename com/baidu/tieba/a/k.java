package com.baidu.tieba.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.baidu.android.common.util.HanziToPinyin;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    private static final Pattern h = Pattern.compile("(tieba.baidu.com/p/){1}\\d+");
    private static final Pattern i = Pattern.compile("(tieba.baidu.com/f\\?kz=){1}\\d+");
    private int c;
    private int d;
    private int a = 0;
    private String b = null;
    private String f = null;
    private SpannableStringBuilder g = null;
    private boolean e = false;

    public static boolean a(int i2, int i3) {
        return i2 == 0 && i3 != 3;
    }

    public static boolean b(int i2, int i3) {
        return (i2 != 0 || i3 == 3 || i3 == 2) ? false : true;
    }

    public static boolean c(int i2, int i3) {
        return (i2 != 0 || i3 == 3 || i3 == 2 || i3 == 5) ? false : true;
    }

    public void a(int i2) {
        this.a = i2;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public void a(String str) {
        this.b = str;
    }

    public String d() {
        return this.b;
    }

    public void b(String str) {
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
        switch (this.a) {
            case 0:
                return new SpannableString(this.b);
            case 1:
                if (!this.b.endsWith(HanziToPinyin.Token.SEPARATOR)) {
                    this.b = String.valueOf(this.b) + HanziToPinyin.Token.SEPARATOR;
                }
                SpannableString spannableString = new SpannableString(this.b);
                spannableString.setSpan(new m(this, context), 0, this.b.length() - 1, 33);
                return spannableString;
            case 2:
                SpannableString spannableString2 = new SpannableString(String.valueOf(this.b) + HanziToPinyin.Token.SEPARATOR);
                Bitmap e = TiebaApplication.d().e(this.b);
                if (e != null) {
                    com.baidu.tieba.view.ak akVar = new com.baidu.tieba.view.ak(e);
                    akVar.setBounds(0, 0, e.getWidth(), e.getHeight());
                    spannableString2.setSpan(new ImageSpan(akVar, 1), 0, this.b.length(), 33);
                    return spannableString2;
                }
                return spannableString2;
            case 3:
            default:
                return null;
            case 4:
                if (!this.b.endsWith(HanziToPinyin.Token.SEPARATOR)) {
                    this.b = String.valueOf(this.b) + HanziToPinyin.Token.SEPARATOR;
                }
                SpannableString spannableString3 = new SpannableString(this.b);
                spannableString3.setSpan(new n(this, context), 0, this.b.length() - 1, 33);
                return spannableString3;
            case 5:
                if (!this.b.endsWith(HanziToPinyin.Token.SEPARATOR)) {
                    this.b = String.valueOf(this.b) + HanziToPinyin.Token.SEPARATOR;
                }
                String string = context.getString(R.string.video);
                SpannableString spannableString4 = new SpannableString(String.valueOf(string) + this.b);
                spannableString4.setSpan(new l(this, context), string.length(), str.length() - 1, 33);
                return spannableString4;
        }
    }

    public SpannableString a(Context context, int i2, int i3) {
        int height;
        if (this.a != 2) {
            return null;
        }
        SpannableString spannableString = new SpannableString(String.valueOf(this.b) + HanziToPinyin.Token.SEPARATOR);
        Bitmap e = TiebaApplication.d().e(this.b);
        if (e != null) {
            com.baidu.tieba.view.ak akVar = new com.baidu.tieba.view.ak(e);
            if (i2 - i3 > 0) {
                height = e.getHeight() + ((i2 - i3) >> 1);
            } else {
                height = e.getHeight();
            }
            akVar.setBounds(0, 0, e.getWidth(), height);
            spannableString.setSpan(new ImageSpan(akVar, 1), 0, this.b.length(), 33);
        }
        return spannableString;
    }

    public String f() {
        return this.f;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("type", 0);
                if (this.a == 3) {
                    this.f = jSONObject.optString("src");
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
                    if (this.f != null && this.f.indexOf(".baidu.com") != -1) {
                        this.e = true;
                    }
                } else if (this.a == 4) {
                    this.b = jSONObject.optString("text");
                    this.f = jSONObject.optString("uid");
                } else {
                    this.b = jSONObject.optString("text");
                    this.f = jSONObject.optString("link");
                    if (this.a == 2 && com.baidu.tbadk.a.a.a().b(this.b) == 0) {
                        this.a = 0;
                        this.b = "[" + jSONObject.optString("c") + "]";
                    }
                }
                if (this.a != 0) {
                    this.b = this.b.replaceAll("\n", "");
                    this.f = this.f.replaceAll("\n", "");
                }
            } catch (Exception e2) {
                com.baidu.tieba.d.ae.b("ContentData", "parserJson", "error = " + e2.getMessage());
            }
        }
    }

    public boolean g() {
        return this.e;
    }
}
