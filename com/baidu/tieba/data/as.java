package com.baidu.tieba.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bg;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class as implements com.baidu.tieba.util.an {
    private String e;
    private ArrayList<as> j;
    private com.baidu.tbadk.widget.richText.a k = null;

    /* renamed from: a  reason: collision with root package name */
    private String f1173a = null;
    private String b = null;
    private int c = 0;
    private long d = 0;
    private UserData f = new UserData();
    private ArrayList<j> g = new ArrayList<>();
    private ArrayList<j> h = new ArrayList<>();
    private int i = 0;

    public as() {
        this.j = null;
        this.j = new ArrayList<>();
    }

    public ArrayList<as> a() {
        return this.j;
    }

    public void b() {
        this.i++;
    }

    public void c() {
        this.i--;
    }

    public String d() {
        return this.f1173a;
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

    public void a(Context context, boolean z) {
        SpannableString spannableString;
        String str;
        String str2 = null;
        if (context != null && this.k != null && this.k.a() != null) {
            String str3 = z ? " [host]" : "";
            if (this.f != null) {
                spannableString = new SpannableString(this.f.getName_show() + str3 + "：");
                str = this.f.getName();
                str2 = this.f.getId();
            } else {
                spannableString = new SpannableString(str3 + "：");
                str = null;
            }
            int length = spannableString.length();
            at atVar = new at(this, context, str, str2);
            if (z) {
                int b = UtilHelper.b(context, 12.0f);
                Bitmap a2 = com.baidu.tieba.util.m.a((int) R.drawable.icon_floorhost);
                int width = (a2.getWidth() * b) / a2.getHeight();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(a2);
                bitmapDrawable.setBounds(0, 0, width, b);
                ImageSpan imageSpan = new ImageSpan(bitmapDrawable, 1);
                if (this.f != null) {
                    spannableString.setSpan(imageSpan, this.f.getName_show().length() + 1, str3.length() + this.f.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(imageSpan, 0, str3.length(), 17);
                }
            }
            spannableString.setSpan(atVar, 0, length, 18);
            ArrayList<com.baidu.tbadk.widget.richText.c> a3 = this.k.a();
            if (a3 != null && a3.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar = a3.get(0);
                if (cVar.d() != null) {
                    cVar.d().insert(0, (CharSequence) spannableString);
                    return;
                }
                com.baidu.tbadk.widget.richText.c cVar2 = new com.baidu.tbadk.widget.richText.c(768);
                cVar2.a(spannableString);
                int i = 0;
                while (true) {
                    if (i >= a3.size()) {
                        break;
                    } else if (a3.get(i).a() != 512) {
                        i++;
                    } else {
                        cVar2.a(a3.get(i).e());
                        a3.remove(i);
                        break;
                    }
                }
                a3.add(0, cVar2);
            }
        }
    }

    public void a(ArrayList<j> arrayList) {
        this.g = arrayList;
    }

    public ArrayList<j> i() {
        return this.h;
    }

    public int j() {
        return this.i;
    }

    public void a(Context context) {
        int a2;
        int i;
        int i2;
        if (this.g != null) {
            int i3 = -1;
            int size = this.h.size();
            if (size > 0) {
                try {
                    i3 = this.h.get(size - 1).a();
                } catch (Exception e) {
                    bg.b("PostData", "uniteContentExcepFace", "error = " + e.getMessage());
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.g.size()) {
                j jVar = this.g.get(i4);
                if (j.b(i5, jVar.a())) {
                    this.h.get(size - 1).a(jVar.a(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (jVar.a() == 3 || jVar.a() == 2) {
                        this.h.add(jVar);
                        a2 = jVar.a();
                    } else {
                        j jVar2 = new j();
                        jVar2.a(0);
                        jVar2.a(jVar.a(context));
                        this.h.add(jVar2);
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

    public void b(Context context) {
        int i;
        int i2;
        int i3;
        if (this.g != null) {
            int i4 = -1;
            int size = this.h.size();
            if (size > 0) {
                try {
                    i4 = this.h.get(size - 1).a();
                } catch (Exception e) {
                    bg.b("PostData", "uniteContent", "error = " + e.getMessage());
                    return;
                }
            }
            int i5 = 0;
            int i6 = i4;
            while (i5 < this.g.size()) {
                j jVar = this.g.get(i5);
                if (j.a(i6, jVar.a())) {
                    this.h.get(size - 1).a(jVar.a(context));
                    i3 = size;
                    i2 = i6;
                } else {
                    if (jVar.a() == 3) {
                        this.h.add(jVar);
                        i = 3;
                    } else {
                        j jVar2 = new j();
                        jVar2.a(0);
                        jVar2.a(jVar.a(context));
                        this.h.add(jVar2);
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

    public void c(Context context) {
        String d;
        try {
            if (this.k != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.k.toString());
                if (clipboardManager.getText() != null) {
                    bg.e(getClass().getName(), "clip_text", clipboardManager.getText().toString());
                    return;
                }
                return;
            }
            if (this.h == null || this.h.size() == 0) {
                a(context);
            }
            ArrayList<j> arrayList = this.h;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<j> it = arrayList.iterator();
                while (it.hasNext()) {
                    j next = it.next();
                    if (next.a() == 0) {
                        if (next.c() != null) {
                            sb.append((CharSequence) next.c());
                        }
                    } else if (next.a() == 3) {
                        if (next.d() != null) {
                            sb.append(context.getString(R.string.pic));
                        }
                    } else if (next.a() == 2 && (d = TbFaceManager.a().d(next.b())) != null) {
                        sb.append("[");
                        sb.append(d);
                        sb.append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                if (clipboardManager2.getText() != null) {
                    bg.e("PbActivity", "clip_text", clipboardManager2.getText().toString());
                }
            }
        } catch (NullPointerException e) {
            bg.b("PostData", "setClipString", e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        a(jSONObject, (Context) null);
    }

    public void a(JSONObject jSONObject, Context context) {
        if (jSONObject != null) {
            try {
                this.f1173a = jSONObject.optString(LocaleUtil.INDONESIAN);
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
                            j jVar = new j();
                            jVar.a(optJSONArray.optJSONObject(i));
                            this.g.add(jVar);
                        }
                    }
                } else {
                    this.k = TbRichTextView.a(context, optJSONArray, true);
                }
                if (this.i > 0) {
                    JSONArray optJSONArray2 = jSONObject.optJSONObject("sub_post_list").optJSONArray("sub_post_list");
                    for (int i2 = 0; i2 < optJSONArray2.length() && i2 < 2; i2++) {
                        as asVar = new as();
                        asVar.a(optJSONArray2.getJSONObject(i2), context);
                        this.j.add(asVar);
                    }
                }
            } catch (Exception e) {
                bg.b("PostData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.util.an
    public LinkedList<String> getImageUrl() {
        if (this.k == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList<com.baidu.tbadk.widget.richText.c> a2 = this.k.a();
        if (a2 != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = a2.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next.a() == 8) {
                    linkedList.add(next.c().f());
                }
            }
            return linkedList;
        }
        return null;
    }

    public String k() {
        ArrayList<com.baidu.tbadk.widget.richText.c> a2;
        if (this.k == null || (a2 = this.k.a()) == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = a2.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.a() == 1) {
                stringBuffer.append(next.d().toString());
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.tieba.util.an
    public LinkedList<String> getPhotoUrl() {
        if (this.f == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(this.f.getPortrait());
        if (this.j != null) {
            Iterator<as> it = this.j.iterator();
            while (it.hasNext()) {
                linkedList.addAll(it.next().getPhotoUrl());
            }
        }
        return linkedList;
    }

    @Override // com.baidu.tieba.util.an
    public LinkedList<String> getForumPhotoUrl() {
        return null;
    }
}
