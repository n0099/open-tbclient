package com.baidu.tieba.data;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.SpannableString;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aw {
    private String e;
    private ArrayList j;
    private com.baidu.tbadk.widget.richText.a k = null;

    /* renamed from: a  reason: collision with root package name */
    private String f985a = null;
    private String b = null;
    private int c = 0;
    private long d = 0;
    private UserData f = new UserData();
    private ArrayList g = new ArrayList();
    private ArrayList h = new ArrayList();
    private int i = 0;

    public aw() {
        this.j = null;
        this.j = new ArrayList();
    }

    public ArrayList a() {
        return this.j;
    }

    public void b() {
        this.i++;
    }

    public void c() {
        this.i--;
    }

    public String d() {
        return this.f985a;
    }

    public int e() {
        return this.c;
    }

    public long f() {
        return this.d;
    }

    public UserData g() {
        return this.f;
    }

    public com.baidu.tbadk.widget.richText.a h() {
        return this.k;
    }

    public void a(Context context) {
        SpannableString spannableString;
        String str;
        String str2 = null;
        if (context != null && this.k != null && this.k.a() != null) {
            if (this.f != null) {
                spannableString = new SpannableString(String.valueOf(this.f.getName_show()) + "：");
                str = this.f.getName();
                str2 = this.f.getId();
            } else {
                spannableString = new SpannableString("：");
                str = null;
            }
            spannableString.setSpan(new ax(this, context, str, str2), 0, spannableString.length(), 18);
            ArrayList a2 = this.k.a();
            if (a2 != null && a2.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar = (com.baidu.tbadk.widget.richText.c) a2.get(0);
                if (cVar.d() != null) {
                    cVar.d().insert(0, (CharSequence) spannableString);
                }
            }
        }
    }

    public void a(ArrayList arrayList) {
        this.g = arrayList;
    }

    public ArrayList i() {
        return this.h;
    }

    public int j() {
        return this.i;
    }

    public void b(Context context) {
        int a2;
        int i;
        int i2;
        if (this.g != null) {
            int i3 = -1;
            int size = this.h.size();
            if (size > 0) {
                try {
                    i3 = ((i) this.h.get(size - 1)).a();
                } catch (Exception e) {
                    com.baidu.tieba.util.aj.b("PostData", "uniteContentExcepFace", "error = " + e.getMessage());
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.g.size()) {
                i iVar = (i) this.g.get(i4);
                if (i.b(i5, iVar.a())) {
                    ((i) this.h.get(size - 1)).a(iVar.a(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (iVar.a() == 3 || iVar.a() == 2) {
                        this.h.add(iVar);
                        a2 = iVar.a();
                    } else {
                        i iVar2 = new i();
                        iVar2.a(0);
                        iVar2.a(iVar.a(context));
                        this.h.add(iVar2);
                        a2 = 0;
                    }
                    i = a2;
                    i2 = size + 1;
                }
                i4++;
                i5 = i;
                size = i2;
            }
        }
    }

    public void c(Context context) {
        int i;
        int i2;
        int i3;
        if (this.g != null) {
            int i4 = -1;
            int size = this.h.size();
            if (size > 0) {
                try {
                    i4 = ((i) this.h.get(size - 1)).a();
                } catch (Exception e) {
                    com.baidu.tieba.util.aj.b("PostData", "uniteContent", "error = " + e.getMessage());
                    return;
                }
            }
            int i5 = 0;
            int i6 = i4;
            while (i5 < this.g.size()) {
                i iVar = (i) this.g.get(i5);
                if (i.a(i6, iVar.a())) {
                    ((i) this.h.get(size - 1)).a(iVar.a(context));
                    i3 = size;
                    i2 = i6;
                } else {
                    if (iVar.a() == 3) {
                        this.h.add(iVar);
                        i = 3;
                    } else {
                        i iVar2 = new i();
                        iVar2.a(0);
                        iVar2.a(iVar.a(context));
                        this.h.add(iVar2);
                        i = 0;
                    }
                    i2 = i;
                    i3 = size + 1;
                }
                i5++;
                i6 = i2;
                size = i3;
            }
        }
    }

    public void d(Context context) {
        String d;
        try {
            if (this.k != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.k.toString());
                if (clipboardManager.getText() != null) {
                    com.baidu.tieba.util.aj.e(getClass().getName(), "clip_text", clipboardManager.getText().toString());
                    return;
                }
                return;
            }
            if (this.h == null || this.h.size() == 0) {
                b(context);
            }
            ArrayList arrayList = this.h;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    i iVar = (i) it.next();
                    if (iVar.a() == 0) {
                        if (iVar.c() != null) {
                            sb.append((CharSequence) iVar.c());
                        }
                    } else if (iVar.a() == 3) {
                        if (iVar.d() != null) {
                            sb.append(context.getString(R.string.pic));
                        }
                    } else if (iVar.a() == 2 && (d = com.baidu.tbadk.a.a.a().d(iVar.b())) != null) {
                        sb.append("[");
                        sb.append(d);
                        sb.append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                if (clipboardManager2.getText() != null) {
                    com.baidu.tieba.util.aj.e("PbActivity", "clip_text", clipboardManager2.getText().toString());
                }
            }
        } catch (NullPointerException e) {
            com.baidu.tieba.util.aj.b("PostData", "setClipString", e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        a(jSONObject, null);
    }

    public void a(JSONObject jSONObject, Context context) {
        if (jSONObject != null) {
            try {
                this.f985a = jSONObject.optString(LocaleUtil.INDONESIAN);
                this.b = jSONObject.optString("title");
                this.c = jSONObject.optInt("floor", 0);
                this.d = jSONObject.optLong("time", 0L) * 1000;
                this.e = jSONObject.optString("time_ex");
                this.f.parserJson(jSONObject.optJSONObject("author"));
                JSONArray optJSONArray = jSONObject.optJSONArray("content");
                this.i = jSONObject.optInt("sub_post_number");
                if (context == null) {
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            i iVar = new i();
                            iVar.a(optJSONArray.optJSONObject(i));
                            this.g.add(iVar);
                        }
                    }
                } else {
                    this.k = TbRichTextView.a(context, optJSONArray, true);
                }
                if (this.i > 0) {
                    JSONArray optJSONArray2 = jSONObject.optJSONObject("sub_post_list").optJSONArray("sub_post_list");
                    for (int i2 = 0; i2 < optJSONArray2.length() && i2 < 2; i2++) {
                        aw awVar = new aw();
                        awVar.a(optJSONArray2.getJSONObject(i2), context);
                        this.j.add(awVar);
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b("PostData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
