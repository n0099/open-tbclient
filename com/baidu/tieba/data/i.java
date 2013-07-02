package com.baidu.tieba.data;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
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
        String str2;
        switch (this.a) {
            case 0:
                return new SpannableString(this.b);
            case 1:
                if (!this.b.endsWith(" ")) {
                    this.b = String.valueOf(this.b) + " ";
                }
                SpannableString spannableString = new SpannableString(this.b);
                spannableString.setSpan(new k(this, context), 0, this.b.length() - 1, 33);
                return spannableString;
            case 2:
                SpannableString spannableString2 = new SpannableString(String.valueOf(this.b) + " ");
                com.baidu.adp.widget.a.b h2 = TiebaApplication.f().h(this.b);
                if (h2 != null) {
                    BitmapDrawable h3 = h2.h();
                    h3.setBounds(0, 0, h2.a(), h2.b());
                    spannableString2.setSpan(new ImageSpan(h3, 1), 0, this.b.length(), 33);
                    return spannableString2;
                }
                return spannableString2;
            case 3:
            default:
                return null;
            case 4:
                if (this.b.length() >= 2) {
                    if (!this.b.endsWith(" ")) {
                        this.b = String.valueOf(this.b) + " ";
                    }
                    String trim = this.b.substring(1, this.b.length()).trim();
                    com.mofamulu.tieba.ch.av b = com.mofamulu.tieba.ch.as.b(trim);
                    if (b == null || com.mofamulu.tieba.ch.bf.a(b.b())) {
                        str = this.b;
                    } else {
                        str = "@" + trim + "[" + b.b() + "] ";
                    }
                    l lVar = new l(this, context, trim);
                    SpannableString spannableString3 = new SpannableString(str);
                    spannableString3.setSpan(lVar, 0, str.length() - 1, 33);
                    if (b != null && b.c() != 0) {
                        spannableString3.setSpan(new ForegroundColorSpan(b.c()), 0, str.length() - 1, 33);
                    }
                    return spannableString3;
                }
                return null;
            case 5:
                if (!this.b.endsWith(" ")) {
                    this.b = String.valueOf(this.b) + " ";
                }
                String string = context.getString(R.string.video);
                SpannableString spannableString4 = new SpannableString(String.valueOf(string) + this.b);
                spannableString4.setSpan(new j(this, context), string.length(), str2.length() - 1, 33);
                return spannableString4;
        }
    }

    public SpannableString a(Context context, int i2, int i3) {
        int b;
        if (this.a != 2) {
            return null;
        }
        SpannableString spannableString = new SpannableString(String.valueOf(this.b) + " ");
        com.baidu.adp.widget.a.b h2 = TiebaApplication.f().h(this.b);
        if (h2 != null) {
            BitmapDrawable h3 = h2.h();
            if (i2 - i3 > 0) {
                b = h2.b() + ((i2 - i3) >> 1);
            } else {
                b = h2.b();
            }
            h3.setBounds(0, 0, h2.a(), b);
            spannableString.setSpan(new ImageSpan(h3, 1), 0, this.b.length(), 33);
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
                com.baidu.tieba.util.z.b("ContentData", "parserJson", "error = " + e2.getMessage());
            }
        }
    }
}
