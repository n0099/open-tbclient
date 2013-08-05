package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.baidu.zeus.bouncycastle.DERTags;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private int f811a = 0;
    private b b = null;
    private e c = null;

    public int a() {
        return this.f811a;
    }

    public void a(int i, b bVar, e eVar) {
        this.f811a = i;
        this.b = bVar;
        this.c = eVar;
    }

    public e b() {
        if (this.f811a == 8) {
            return this.c;
        }
        return null;
    }

    public SpannableString c() {
        if (this.f811a != 1 || this.b == null) {
            return null;
        }
        return new SpannableString(this.b.a());
    }

    public CharSequence a(Context context, ArrayList arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.f811a == 32 && this.b != null) {
            spannableStringBuilder.append((CharSequence) "视频：");
            CharSequence d = d(context, arrayList);
            if (d != null) {
                spannableStringBuilder.append(d);
            }
            SpannableString a2 = a(context, this.f811a, this.b.a(), this.b.a());
            if (a2 != null) {
                spannableStringBuilder.append((CharSequence) a2);
            }
        }
        return spannableStringBuilder;
    }

    public CharSequence b(Context context, ArrayList arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.f811a == 128 && this.b != null) {
            CharSequence d = d(context, arrayList);
            if (d != null) {
                spannableStringBuilder.append(d);
            }
            SpannableString a2 = a(context, this.f811a, this.b.b(), this.b.b());
            if (a2 != null) {
                spannableStringBuilder.append((CharSequence) a2);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence d(Context context, ArrayList arrayList) {
        g gVar = new g();
        gVar.a(4, new b("video_icon", " "), null);
        return gVar.c(context, arrayList);
    }

    public String d() {
        if (this.f811a != 32 || this.b == null) {
            return null;
        }
        return this.b.a();
    }

    public SpannableString a(Context context) {
        if (this.f811a != 2 || this.b == null) {
            return null;
        }
        return a(context, this.f811a, this.b.a(), this.b.b());
    }

    public SpannableString b(Context context) {
        if (this.f811a != 256 || this.b == null) {
            return null;
        }
        String a2 = this.b.a();
        if (a2 == null) {
            return null;
        }
        if (!a2.endsWith(" ")) {
            a2 = String.valueOf(a2) + " ";
        }
        SpannableString spannableString = new SpannableString(a2);
        f fVar = new f(context, this.f811a, a2);
        fVar.a(this.b.b());
        spannableString.setSpan(fVar, 0, a2.length() - 1, 33);
        return spannableString;
    }

    public SpannableString c(Context context) {
        if (this.f811a != 16 || this.b == null) {
            return null;
        }
        return a(context, this.f811a, this.b.a(), this.b.b());
    }

    private SpannableString e(Context context, ArrayList arrayList) {
        SpannableString spannableString = null;
        if (this.f811a == 4 && this.b != null && this.b.a() != null && this.b.b() != null) {
            String a2 = this.b.a();
            String b = this.b.b();
            int b2 = com.baidu.tbadk.a.a.a().b(a2);
            if (b2 != 0) {
                spannableString = new SpannableString(String.valueOf(b) + " ");
                d dVar = new d(context, b2);
                if (arrayList != null) {
                    arrayList.add(dVar);
                }
                com.baidu.tbadk.a.c c = com.baidu.tbadk.a.a.a().c(a2);
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

    private SpannableString a(Context context, int i, String str, String str2) {
        if (str == null) {
            return null;
        }
        if (!str.endsWith(" ")) {
            str = String.valueOf(str) + " ";
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new f(context, i, str2), 0, str.length() - 1, 33);
        return spannableString;
    }

    public CharSequence c(Context context, ArrayList arrayList) {
        switch (this.f811a) {
            case 1:
                return c();
            case 2:
                return a(context);
            case 4:
                return e(context, arrayList);
            case 8:
            default:
                return null;
            case 16:
                return c(context);
            case 32:
                return a(context, arrayList);
            case DERTags.TAGGED /* 128 */:
                return b(context, arrayList);
            case 256:
                return b(context);
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            this.f811a = a(jSONObject.optInt("type", 0));
            if (this.f811a == 8) {
                this.c = new e(jSONObject);
            } else if (this.f811a == 16) {
                this.b = new b(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else {
                this.b = new b(jSONObject);
                if (this.f811a == 4) {
                    String str = "[" + jSONObject.optString("c") + "]";
                    if (com.baidu.tbadk.a.a.a().b(this.b.a()) <= 0) {
                        this.f811a = 1;
                        this.b.a(str);
                    } else {
                        this.b.b(str);
                    }
                } else if (this.f811a == 256) {
                    this.b.b(jSONObject.optString("phonetype"));
                }
            }
            if (this.f811a != 1 && this.b != null) {
                this.b.c();
            }
        } catch (Exception e) {
            com.baidu.adp.lib.e.d.a(e.getMessage());
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
            case 9:
                return 256;
        }
    }
}
