package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.ArrayList;
import org.json.JSONObject;
import protobuf.Im;
/* loaded from: classes.dex */
public final class i {
    private int a = 0;
    private b b = null;
    private g c = null;
    private t d = null;
    private e e = null;

    public final int a() {
        return this.a;
    }

    public final g b() {
        if (this.a == 8) {
            return this.c;
        }
        return null;
    }

    public final t c() {
        if (this.a == 512 || this.a == 768) {
            return this.d;
        }
        return null;
    }

    public final e d() {
        if (this.a == 17) {
            return this.e;
        }
        return null;
    }

    private static CharSequence b(Context context, ArrayList<f> arrayList) {
        i iVar = new i();
        b bVar = new b("video_icon", " ");
        iVar.a = 4;
        iVar.b = bVar;
        iVar.c = null;
        iVar.d = null;
        iVar.e = null;
        return iVar.a(context, arrayList);
    }

    public final String e() {
        if (this.a != 32 || this.b == null) {
            return null;
        }
        return this.b.a();
    }

    private static SpannableString a(Context context, int i, String str, String str2) {
        if (str == null) {
            return null;
        }
        if (!str.endsWith(" ")) {
            str = String.valueOf(str) + " ";
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new h(context, i, str2), 0, str.length() - 1, 33);
        return spannableString;
    }

    public final CharSequence a(Context context, ArrayList<f> arrayList) {
        String a;
        String a2;
        int b;
        switch (this.a) {
            case 1:
                if (this.a != 1 || this.b == null) {
                    return null;
                }
                return new SpannableString(this.b.a());
            case 2:
                if (this.a != 2 || this.b == null) {
                    return null;
                }
                return a(context, this.a, this.b.a(), this.b.b());
            case 4:
                if (this.a != 4 || this.b == null || this.b.a() == null || this.b.b() == null || (b = TbFaceManager.a().b((a2 = this.b.a()))) == 0) {
                    return null;
                }
                String str = "#(" + TbFaceManager.a().d(a2) + ")";
                SpannableString spannableString = new SpannableString(String.valueOf(str) + " ");
                f fVar = new f(context, b);
                if (arrayList != null) {
                    arrayList.add(fVar);
                }
                com.baidu.tbadk.imageManager.c c = TbFaceManager.a().c(a2);
                if (c != null) {
                    fVar.setBounds(new Rect(0, 0, c.a(), c.b()));
                } else {
                    fVar.setBounds(new Rect(0, 0, 0, 0));
                }
                spannableString.setSpan(new ImageSpan(fVar, 0), 0, str.length(), 33);
                return spannableString;
            case 8:
            case Im.GroupInfo.CREATETIME_FIELD_NUMBER /* 17 */:
            default:
                return null;
            case 16:
                if (this.a != 16 || this.b == null) {
                    return null;
                }
                return a(context, this.a, this.b.a(), this.b.b());
            case 32:
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                if (this.a != 32 || this.b == null) {
                    return spannableStringBuilder;
                }
                spannableStringBuilder.append((CharSequence) "视频：");
                CharSequence b2 = b(context, arrayList);
                if (b2 != null) {
                    spannableStringBuilder.append(b2);
                }
                SpannableString a3 = a(context, this.a, this.b.a(), this.b.a());
                if (a3 != null) {
                    spannableStringBuilder.append((CharSequence) a3);
                    return spannableStringBuilder;
                }
                return spannableStringBuilder;
            case 128:
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                if (this.a != 128 || this.b == null) {
                    return spannableStringBuilder2;
                }
                CharSequence b3 = b(context, arrayList);
                if (b3 != null) {
                    spannableStringBuilder2.append(b3);
                }
                SpannableString a4 = a(context, this.a, this.b.b(), this.b.b());
                if (a4 != null) {
                    spannableStringBuilder2.append((CharSequence) a4);
                    return spannableStringBuilder2;
                }
                return spannableStringBuilder2;
            case 256:
                if (this.a != 256 || this.b == null || (a = this.b.a()) == null) {
                    return null;
                }
                String str2 = !a.endsWith(" ") ? String.valueOf(a) + " " : a;
                SpannableString spannableString2 = new SpannableString(str2);
                h hVar = new h(context, this.a, str2);
                hVar.a(this.b.b());
                spannableString2.setSpan(hVar, 0, str2.length() - 1, 33);
                return spannableString2;
        }
    }

    public final void a(JSONObject jSONObject) {
        int i;
        int i2 = 0;
        try {
            switch (jSONObject.optInt("type", 0)) {
                case 0:
                    i = 1;
                    break;
                case 1:
                    i = 2;
                    break;
                case 2:
                    i = 4;
                    break;
                case 3:
                    i = 8;
                    break;
                case 4:
                    i = 16;
                    break;
                case 5:
                    i = 32;
                    break;
                case 6:
                    i = 64;
                    break;
                case 7:
                default:
                    i = 0;
                    break;
                case 8:
                    i = 128;
                    break;
                case 9:
                    i = 256;
                    break;
                case 10:
                    i = 512;
                    break;
                case 11:
                    i = 17;
                    break;
            }
            this.a = i;
            if (this.a == 8) {
                this.c = new g(jSONObject);
            } else if (this.a == 512) {
                this.d = new t(jSONObject);
            } else if (this.a == 16) {
                this.b = new b(jSONObject.optString("text"), jSONObject.optString("uid"));
            } else if (this.a == 17) {
                this.e = new e();
                this.e.c = String.format("#(%s)", jSONObject.optString("c"));
                this.e.b = jSONObject.optString("dynamic");
                this.e.a = jSONObject.optString("static");
                this.e.d = this.a;
                this.e.f = jSONObject.optInt("width", 200);
                this.e.g = jSONObject.optInt("height", 200);
                this.e.h = jSONObject.optString("packet_name", "");
                this.e.i = jSONObject.optString("icon");
                String[] split = this.e.b.split("/");
                for (String str : split) {
                    i2++;
                    if (str.equals("faceshop")) {
                        String str2 = split[i2].split("_")[0];
                        com.baidu.adp.lib.util.f.e("TbRichTextView", "onClick", str2);
                        this.e.e = str2;
                    }
                }
                String str22 = split[i2].split("_")[0];
                com.baidu.adp.lib.util.f.e("TbRichTextView", "onClick", str22);
                this.e.e = str22;
            } else {
                this.b = new b(jSONObject);
                if (this.a == 4) {
                    String str3 = "[" + jSONObject.optString("c") + "]";
                    if (TbFaceManager.a().b(this.b.a()) <= 0) {
                        this.a = 1;
                        this.b.a(str3);
                    } else {
                        this.b.b(str3);
                    }
                } else if (this.a == 256) {
                    this.b.b(jSONObject.optString("phonetype"));
                }
            }
            if (this.a != 1 && this.b != null) {
                this.b.c();
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(e.getMessage());
        }
    }
}
