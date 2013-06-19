package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.android.common.util.HanziToPinyin;
import com.baidu.zeus.bouncycastle.DERTags;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private int a = 0;
    private b b = null;
    private e c = null;

    public int a() {
        return this.a;
    }

    public e b() {
        if (this.a == 8) {
            return this.c;
        }
        return null;
    }

    public SpannableString c() {
        if (this.a != 1 || this.b == null) {
            return null;
        }
        return new SpannableString(this.b.a());
    }

    public SpannableString a(Context context) {
        if (this.a != 32 || this.b == null) {
            return null;
        }
        return a(context, this.a, "视频：", this.b.a(), this.b.a());
    }

    public SpannableString b(Context context) {
        if (this.a != 128 || this.b == null) {
            return null;
        }
        return a(context, this.a, null, this.b.b(), this.b.b());
    }

    public String d() {
        if (this.a != 32 || this.b == null) {
            return null;
        }
        return this.b.a();
    }

    public SpannableString c(Context context) {
        if (this.a != 2 || this.b == null) {
            return null;
        }
        return a(context, this.a, null, this.b.a(), this.b.b());
    }

    public SpannableString d(Context context) {
        if (this.a != 16 || this.b == null) {
            return null;
        }
        return a(context, this.a, null, this.b.a(), this.b.b());
    }

    public SpannableString a(Context context, ArrayList arrayList) {
        SpannableString spannableString = null;
        if (this.a == 4 && this.b != null && this.b.a() != null && this.b.b() != null) {
            String a = this.b.a();
            String b = this.b.b();
            spannableString = new SpannableString(String.valueOf(b) + HanziToPinyin.Token.SEPARATOR);
            int b2 = com.baidu.tbadk.a.a.a().b(a);
            if (b2 != 0) {
                d dVar = new d(context, b2);
                if (arrayList != null) {
                    arrayList.add(dVar);
                }
                com.baidu.tbadk.a.c c = com.baidu.tbadk.a.a.a().c(a);
                if (c != null) {
                    dVar.setBounds(new Rect(0, 0, c.a(), c.b()));
                } else {
                    dVar.setBounds(new Rect(0, 0, 0, 0));
                }
                spannableString.setSpan(new ImageSpan(dVar, 0), 0, b.length(), 33);
            }
        }
        return spannableString;
    }

    private SpannableString a(Context context, int i, String str, String str2, String str3) {
        int i2;
        if (str2 == null) {
            return null;
        }
        String str4 = !str2.endsWith(HanziToPinyin.Token.SEPARATOR) ? String.valueOf(str2) + HanziToPinyin.Token.SEPARATOR : str2;
        if (str != null) {
            str4 = String.valueOf(str) + str4;
            i2 = str.length();
        } else {
            i2 = 0;
        }
        SpannableString spannableString = new SpannableString(str4);
        spannableString.setSpan(new f(context, i, str3), i2, str4.length() - 1, 33);
        return spannableString;
    }

    public SpannableString e(Context context) {
        switch (this.a) {
            case 1:
                return c();
            case 2:
                return c(context);
            case 4:
                return a(context, null);
            case 8:
            default:
                return null;
            case 16:
                return d(context);
            case 32:
                return a(context);
            case DERTags.TAGGED /* 128 */:
                return b(context);
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            this.a = a(jSONObject.optInt("type", 0));
            if (this.a == 8) {
                this.c = new e(jSONObject);
            } else if (this.a == 16) {
                this.b = new b(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else {
                this.b = new b(jSONObject);
                if (this.a == 4) {
                    String str = "[" + jSONObject.optString("c") + "]";
                    if (com.baidu.tbadk.a.a.a().b(this.b.a()) <= 0) {
                        this.a = 1;
                        this.b.a(str);
                    } else {
                        this.b.b(str);
                    }
                }
            }
            if (this.a != 1 && this.b != null) {
                this.b.c();
            }
        } catch (Exception e) {
            com.baidu.adp.lib.e.b.a(e.getMessage());
        }
    }

    private int a(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
            default:
                return 0;
            case 8:
                return DERTags.TAGGED;
        }
    }
}
