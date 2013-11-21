package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.zeus.bouncycastle.DERTags;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private int f989a = 0;
    private b b = null;
    private f c = null;
    private p d = null;

    public int a() {
        return this.f989a;
    }

    public void a(int i, b bVar, f fVar, p pVar) {
        this.f989a = i;
        this.b = bVar;
        this.c = fVar;
        this.d = pVar;
    }

    public f b() {
        if (this.f989a == 8) {
            return this.c;
        }
        return null;
    }

    public p c() {
        if (this.f989a == 512 || this.f989a == 768) {
            return this.d;
        }
        return null;
    }

    public SpannableString d() {
        if (this.f989a != 1 || this.b == null) {
            return null;
        }
        return new SpannableString(this.b.a());
    }

    public CharSequence a(Context context, ArrayList<e> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.f989a == 32 && this.b != null) {
            spannableStringBuilder.append((CharSequence) "视频：");
            CharSequence d = d(context, arrayList);
            if (d != null) {
                spannableStringBuilder.append(d);
            }
            SpannableString a2 = a(context, this.f989a, this.b.a(), this.b.a());
            if (a2 != null) {
                spannableStringBuilder.append((CharSequence) a2);
            }
        }
        return spannableStringBuilder;
    }

    public CharSequence b(Context context, ArrayList<e> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.f989a == 128 && this.b != null) {
            CharSequence d = d(context, arrayList);
            if (d != null) {
                spannableStringBuilder.append(d);
            }
            SpannableString a2 = a(context, this.f989a, this.b.b(), this.b.b());
            if (a2 != null) {
                spannableStringBuilder.append((CharSequence) a2);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence d(Context context, ArrayList<e> arrayList) {
        h hVar = new h();
        hVar.a(4, new b("video_icon", " "), (f) null, (p) null);
        return hVar.c(context, arrayList);
    }

    public String e() {
        if (this.f989a != 32 || this.b == null) {
            return null;
        }
        return this.b.a();
    }

    public SpannableString a(Context context) {
        if (this.f989a != 2 || this.b == null) {
            return null;
        }
        return a(context, this.f989a, this.b.a(), this.b.b());
    }

    public SpannableString b(Context context) {
        if (this.f989a != 256 || this.b == null) {
            return null;
        }
        String a2 = this.b.a();
        if (a2 == null) {
            return null;
        }
        if (!a2.endsWith(" ")) {
            a2 = a2 + " ";
        }
        SpannableString spannableString = new SpannableString(a2);
        g gVar = new g(context, this.f989a, a2);
        gVar.a(this.b.b());
        spannableString.setSpan(gVar, 0, a2.length() - 1, 33);
        return spannableString;
    }

    public SpannableString c(Context context) {
        if (this.f989a != 16 || this.b == null) {
            return null;
        }
        return a(context, this.f989a, this.b.a(), this.b.b());
    }

    private SpannableString e(Context context, ArrayList<e> arrayList) {
        SpannableString spannableString = null;
        if (this.f989a == 4 && this.b != null && this.b.a() != null && this.b.b() != null) {
            String a2 = this.b.a();
            String b = this.b.b();
            int b2 = TbFaceManager.a().b(a2);
            if (b2 != 0) {
                spannableString = new SpannableString(b + " ");
                e eVar = new e(context, b2);
                if (arrayList != null) {
                    arrayList.add(eVar);
                }
                com.baidu.tbadk.imageManager.b c = TbFaceManager.a().c(a2);
                if (c != null) {
                    eVar.setBounds(new Rect(0, 0, c.a(), c.b()));
                } else {
                    eVar.setBounds(new Rect(0, 0, 0, 0));
                }
                spannableString.setSpan(new ImageSpan(eVar, 0), 0, b.length(), 33);
            }
        }
        return spannableString;
    }

    private SpannableString a(Context context, int i, String str, String str2) {
        if (str == null) {
            return null;
        }
        if (!str.endsWith(" ")) {
            str = str + " ";
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new g(context, i, str2), 0, str.length() - 1, 33);
        return spannableString;
    }

    public CharSequence c(Context context, ArrayList<e> arrayList) {
        switch (this.f989a) {
            case 1:
                return d();
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
            this.f989a = a(jSONObject.optInt("type", 0));
            if (this.f989a == 8) {
                this.c = new f(jSONObject);
            } else if (this.f989a == 512) {
                this.d = new p(jSONObject);
            } else if (this.f989a == 16) {
                this.b = new b(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else {
                this.b = new b(jSONObject);
                if (this.f989a == 4) {
                    String str = "[" + jSONObject.optString("c") + "]";
                    if (TbFaceManager.a().b(this.b.a()) <= 0) {
                        this.f989a = 1;
                        this.b.a(str);
                    } else {
                        this.b.b(str);
                    }
                } else if (this.f989a == 256) {
                    this.b.b(jSONObject.optString("phonetype"));
                }
            }
            if (this.f989a != 1 && this.b != null) {
                this.b.c();
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.d.a(e.getMessage());
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
            case 10:
                return ImageManager.DEFAULT_MAX_CACHEABLE_SIZE;
        }
    }
}
