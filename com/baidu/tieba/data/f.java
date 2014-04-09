package com.baidu.tieba.data;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class f {
    private static final Pattern j = Pattern.compile("(tieba.baidu.com/p/){1}\\d+");
    private static final Pattern k = Pattern.compile("(tieba.baidu.com/f\\?kz=){1}\\d+");
    private String c;
    private int d;
    private int e;
    private int a = 0;
    private String b = null;
    private String g = null;
    private String h = null;
    private SpannableStringBuilder i = null;
    private boolean f = false;

    public static boolean a(int i, int i2) {
        return i == 0 && i2 != 3;
    }

    public static boolean b(int i, int i2) {
        return (i != 0 || i2 == 3 || i2 == 2) ? false : true;
    }

    public final void a(int i) {
        this.a = i;
    }

    public final int a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final void a(SpannableStringBuilder spannableStringBuilder) {
        this.i = spannableStringBuilder;
    }

    public final SpannableStringBuilder d() {
        return this.i;
    }

    public final SpannableStringBuilder a(SpannableString spannableString) {
        if (this.i == null) {
            this.i = new SpannableStringBuilder();
        }
        this.i.append((CharSequence) spannableString);
        return this.i;
    }

    public final SpannableString a(Context context) {
        String str;
        switch (this.a) {
            case 0:
                return new SpannableString(this.b);
            case 1:
                if (!this.b.endsWith(" ")) {
                    this.b = String.valueOf(this.b) + " ";
                }
                SpannableString spannableString = new SpannableString(this.b);
                spannableString.setSpan(new h(this, context), 0, this.b.length() - 1, 33);
                return spannableString;
            case 2:
                SpannableString spannableString2 = new SpannableString(String.valueOf(this.b) + " ");
                com.baidu.adp.widget.ImageView.b g = com.baidu.tieba.p.c().g(this.b);
                if (g != null) {
                    BitmapDrawable i = g.i();
                    i.setBounds(0, 0, g.c(), g.d());
                    spannableString2.setSpan(new ImageSpan(i, 1), 0, this.b.length(), 33);
                    return spannableString2;
                }
                return spannableString2;
            case 3:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            default:
                return null;
            case 4:
                if (!this.b.endsWith(" ")) {
                    this.b = String.valueOf(this.b) + " ";
                }
                SpannableString spannableString3 = new SpannableString(this.b);
                spannableString3.setSpan(new i(this, context), 0, this.b.length() - 1, 33);
                return spannableString3;
            case 5:
                if (!this.b.endsWith(" ")) {
                    this.b = String.valueOf(this.b) + " ";
                }
                String string = context.getString(com.baidu.tieba.a.k.video);
                SpannableString spannableString4 = new SpannableString(String.valueOf(string) + this.b);
                spannableString4.setSpan(new g(this, context), string.length(), str.length() - 1, 33);
                return spannableString4;
        }
    }

    public final SpannableString c(int i, int i2) {
        int d;
        if (this.a != 2) {
            return null;
        }
        SpannableString spannableString = new SpannableString(String.valueOf(this.b) + " ");
        com.baidu.adp.widget.ImageView.b g = com.baidu.tieba.p.c().g(this.b);
        if (g != null) {
            BitmapDrawable i3 = g.i();
            if (i - i2 > 0) {
                d = g.d() + ((i - i2) >> 1);
            } else {
                d = g.d();
            }
            i3.setBounds(0, 0, g.c(), d);
            spannableString.setSpan(new ImageSpan(i3, 1), 0, this.b.length(), 33);
        }
        return spannableString;
    }

    public final String e() {
        return this.g;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("type", 0);
                if (this.a == 3) {
                    this.g = jSONObject.optString("src");
                    this.b = jSONObject.optString("bsize");
                    this.h = jSONObject.optString("cdn_src", null);
                    try {
                        String[] split = this.b.split(",");
                        if (split.length > 1) {
                            this.d = Integer.valueOf(split[0]).intValue();
                            this.e = Integer.valueOf(split[1]).intValue();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (this.d <= 0) {
                        this.d = 1;
                    }
                    if (this.e <= 0) {
                        this.e = 1;
                    }
                    if (this.g != null && this.g.indexOf(".baidu.com") != -1) {
                        this.f = true;
                    }
                } else if (this.a == 4) {
                    this.b = jSONObject.optString("text");
                    this.g = jSONObject.optString("uid");
                } else if (this.a == 11) {
                    this.c = jSONObject.optString("c");
                } else {
                    this.b = jSONObject.optString("text");
                    this.g = jSONObject.optString("link");
                    if (this.a == 2 && TbFaceManager.a().b(this.b) == 0) {
                        this.a = 0;
                        this.b = "[" + jSONObject.optString("c") + "]";
                    }
                }
                if (this.a != 0) {
                    this.b = this.b.replaceAll(IOUtils.LINE_SEPARATOR_UNIX, "");
                    this.g = this.g.replaceAll(IOUtils.LINE_SEPARATOR_UNIX, "");
                }
            } catch (Exception e2) {
                com.baidu.adp.lib.util.f.b("ContentData", "parserJson", "error = " + e2.getMessage());
            }
        }
    }
}
