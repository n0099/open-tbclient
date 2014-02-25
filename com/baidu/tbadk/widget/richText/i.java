package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    private int a = 0;
    private b b = null;
    private g c = null;
    private t d = null;
    private e e = null;

    public int a() {
        return this.a;
    }

    public void a(int i, b bVar, g gVar, t tVar, e eVar) {
        this.a = i;
        this.b = bVar;
        this.c = gVar;
        this.d = tVar;
        this.e = eVar;
    }

    public g b() {
        if (this.a == 8) {
            return this.c;
        }
        return null;
    }

    public t c() {
        if (this.a == 512 || this.a == 768) {
            return this.d;
        }
        return null;
    }

    public e d() {
        if (this.a == 17) {
            return this.e;
        }
        return null;
    }

    public SpannableString e() {
        if (this.a != 1 || this.b == null) {
            return null;
        }
        return new SpannableString(this.b.a());
    }

    public CharSequence a(Context context, ArrayList<f> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.a == 32 && this.b != null) {
            spannableStringBuilder.append((CharSequence) "视频：");
            CharSequence d = d(context, arrayList);
            if (d != null) {
                spannableStringBuilder.append(d);
            }
            SpannableString a = a(context, this.a, this.b.a(), this.b.a());
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    public CharSequence b(Context context, ArrayList<f> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.a == 128 && this.b != null) {
            CharSequence d = d(context, arrayList);
            if (d != null) {
                spannableStringBuilder.append(d);
            }
            SpannableString a = a(context, this.a, this.b.b(), this.b.b());
            if (a != null) {
                spannableStringBuilder.append((CharSequence) a);
            }
        }
        return spannableStringBuilder;
    }

    private CharSequence d(Context context, ArrayList<f> arrayList) {
        i iVar = new i();
        iVar.a(4, new b("video_icon", " "), null, null, null);
        return iVar.c(context, arrayList);
    }

    public String f() {
        if (this.a != 32 || this.b == null) {
            return null;
        }
        return this.b.a();
    }

    public SpannableString a(Context context) {
        if (this.a != 2 || this.b == null) {
            return null;
        }
        return a(context, this.a, this.b.a(), this.b.b());
    }

    public SpannableString b(Context context) {
        if (this.a != 256 || this.b == null) {
            return null;
        }
        String a = this.b.a();
        if (a == null) {
            return null;
        }
        if (!a.endsWith(" ")) {
            a = String.valueOf(a) + " ";
        }
        SpannableString spannableString = new SpannableString(a);
        h hVar = new h(context, this.a, a);
        hVar.a(this.b.b());
        spannableString.setSpan(hVar, 0, a.length() - 1, 33);
        return spannableString;
    }

    public SpannableString c(Context context) {
        if (this.a != 16 || this.b == null) {
            return null;
        }
        return a(context, this.a, this.b.a(), this.b.b());
    }

    private SpannableString e(Context context, ArrayList<f> arrayList) {
        SpannableString spannableString = null;
        if (this.a == 4 && this.b != null && this.b.a() != null && this.b.b() != null) {
            String a = this.b.a();
            String b = this.b.b();
            int b2 = TbFaceManager.a().b(a);
            if (b2 != 0) {
                spannableString = new SpannableString(String.valueOf(b) + " ");
                f fVar = new f(context, b2);
                if (arrayList != null) {
                    arrayList.add(fVar);
                }
                com.baidu.tbadk.imageManager.c c = TbFaceManager.a().c(a);
                if (c != null) {
                    fVar.setBounds(new Rect(0, 0, c.a(), c.b()));
                } else {
                    fVar.setBounds(new Rect(0, 0, 0, 0));
                }
                spannableString.setSpan(new ImageSpan(fVar, 0), 0, b.length(), 33);
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
        spannableString.setSpan(new h(context, i, str2), 0, str.length() - 1, 33);
        return spannableString;
    }

    public CharSequence c(Context context, ArrayList<f> arrayList) {
        switch (this.a) {
            case 1:
                return e();
            case 2:
                return a(context);
            case 4:
                return e(context, arrayList);
            case 8:
            case 17:
            default:
                return null;
            case 16:
                return c(context);
            case 32:
                return a(context, arrayList);
            case 128:
                return b(context, arrayList);
            case 256:
                return b(context);
        }
    }

    public void a(JSONObject jSONObject) {
        int i = 0;
        try {
            this.a = a(jSONObject.optInt("type", 0));
            if (this.a == 8) {
                this.c = new g(jSONObject);
            } else if (this.a == 512) {
                this.d = new t(jSONObject);
            } else if (this.a == 16) {
                this.b = new b(jSONObject.optString("text"), jSONObject.optString(SapiAccountManager.SESSION_UID));
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
                    i++;
                    if (str.equals("faceshop")) {
                        break;
                    }
                }
                String str2 = split[i].split("_")[0];
                com.baidu.adp.lib.util.f.e("TbRichTextView", "onClick", str2);
                this.e.e = str2;
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
                return 128;
            case 9:
                return 256;
            case 10:
                return 512;
            case 11:
                return 17;
        }
    }
}
