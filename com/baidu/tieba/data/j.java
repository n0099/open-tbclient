package com.baidu.tieba.data;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    private static final Pattern i = Pattern.compile("(tieba.baidu.com/p/){1}\\d+");
    private static final Pattern j = Pattern.compile("(tieba.baidu.com/f\\?kz=){1}\\d+");
    private int c;
    private int d;
    private int a = 0;
    private String b = null;
    private String f = null;
    private String g = null;
    private SpannableStringBuilder h = null;
    private boolean e = false;

    public static boolean a(int i2, int i3) {
        return i2 == 0 && i3 != 3;
    }

    public static boolean b(int i2, int i3) {
        return (i2 != 0 || i3 == 3 || i3 == 2) ? false : true;
    }

    public void a(int i2) {
        this.a = i2;
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public void a(SpannableStringBuilder spannableStringBuilder) {
        this.h = spannableStringBuilder;
    }

    public SpannableStringBuilder c() {
        return this.h;
    }

    public SpannableStringBuilder a(SpannableString spannableString) {
        if (this.h == null) {
            this.h = new SpannableStringBuilder();
        }
        this.h.append((CharSequence) spannableString);
        return this.h;
    }

    public SpannableString a(Context context) {
        String str;
        switch (this.a) {
            case 0:
                return new SpannableString(this.b);
            case 1:
                if (!this.b.endsWith(" ")) {
                    this.b += " ";
                }
                SpannableString spannableString = new SpannableString(this.b);
                spannableString.setSpan(new l(this, context), 0, this.b.length() - 1, 33);
                return spannableString;
            case 2:
                SpannableString spannableString2 = new SpannableString(this.b + " ");
                com.baidu.adp.widget.ImageView.e k = TiebaApplication.h().k(this.b);
                if (k != null) {
                    BitmapDrawable g = k.g();
                    g.setBounds(0, 0, k.a(), k.b());
                    spannableString2.setSpan(new ImageSpan(g, 1), 0, this.b.length(), 33);
                    return spannableString2;
                }
                return spannableString2;
            case 3:
            default:
                return null;
            case 4:
                if (!this.b.endsWith(" ")) {
                    this.b += " ";
                }
                SpannableString spannableString3 = new SpannableString(this.b);
                spannableString3.setSpan(new m(this, context), 0, this.b.length() - 1, 33);
                return spannableString3;
            case 5:
                if (!this.b.endsWith(" ")) {
                    this.b += " ";
                }
                String string = context.getString(R.string.video);
                SpannableString spannableString4 = new SpannableString(string + this.b);
                spannableString4.setSpan(new k(this, context), string.length(), str.length() - 1, 33);
                return spannableString4;
        }
    }

    public SpannableString a(Context context, int i2, int i3) {
        int b;
        if (this.a != 2) {
            return null;
        }
        SpannableString spannableString = new SpannableString(this.b + " ");
        com.baidu.adp.widget.ImageView.e k = TiebaApplication.h().k(this.b);
        if (k != null) {
            BitmapDrawable g = k.g();
            if (i2 - i3 > 0) {
                b = k.b() + ((i2 - i3) >> 1);
            } else {
                b = k.b();
            }
            g.setBounds(0, 0, k.a(), b);
            spannableString.setSpan(new ImageSpan(g, 1), 0, this.b.length(), 33);
        }
        return spannableString;
    }

    public String d() {
        return this.f;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("type", 0);
                if (this.a == 3) {
                    this.f = jSONObject.optString("src");
                    this.b = jSONObject.optString("bsize");
                    this.g = jSONObject.optString("cdn_src", null);
                    try {
                        String[] split = this.b.split(",");
                        if (split.length > 1) {
                            this.c = Integer.valueOf(split[0]).intValue();
                            this.d = Integer.valueOf(split[1]).intValue();
                        }
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
                    if (this.a == 2 && TbFaceManager.a().b(this.b) == 0) {
                        this.a = 0;
                        this.b = "[" + jSONObject.optString("c") + "]";
                    }
                }
                if (this.a != 0) {
                    this.b = this.b.replaceAll("\n", "");
                    this.f = this.f.replaceAll("\n", "");
                }
            } catch (Exception e2) {
                com.baidu.tieba.util.be.b("ContentData", "parserJson", "error = " + e2.getMessage());
            }
        }
    }
}
