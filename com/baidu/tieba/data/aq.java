package com.baidu.tieba.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bs;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aq extends com.baidu.tieba.util.au {
    private String e;
    private ArrayList<aq> j;
    private com.baidu.tbadk.widget.richText.a k = null;
    private String a = null;
    private String b = null;
    private int c = 0;
    private long d = 0;
    private UserData f = new UserData();
    private ArrayList<k> g = new ArrayList<>();
    private ArrayList<k> h = new ArrayList<>();
    private int i = 0;

    public aq() {
        this.j = null;
        this.j = new ArrayList<>();
    }

    public ArrayList<aq> a() {
        return this.j;
    }

    public void b() {
        this.i++;
    }

    public void c() {
        this.i--;
    }

    public String d() {
        return this.a;
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

    public void a(Context context, boolean z, com.baidu.tieba.util.i iVar) {
        String str;
        SpannableString spannableString;
        String str2;
        Bitmap h;
        if (context != null && this.k != null && this.k.a() != null) {
            LinkedList<IconData> tShowInfo = g().getTShowInfo();
            String str3 = z ? " [host]" : "";
            int b = BdUtilHelper.b(context, 15.0f);
            ArrayList arrayList = new ArrayList();
            if (tShowInfo != null && iVar != null) {
                Iterator<IconData> it = tShowInfo.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ImageView.b b2 = iVar.b(it.next().getIcon(), true, new ar(this));
                    if (b2 != null && (h = b2.h()) != null) {
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(h);
                        bitmapDrawable.setBounds(0, 0, TiebaApplication.g().b().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.small_icon_width), TiebaApplication.g().b().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.small_icon_height));
                        arrayList.add(new com.baidu.adp.widget.w(bitmapDrawable, 1));
                    }
                }
            }
            String str4 = "";
            for (int i = 0; i < arrayList.size(); i++) {
                str4 = String.valueOf(str4) + i;
            }
            if (str4.length() > 0) {
                str4 = String.valueOf(str4) + " ";
            }
            if (this.f == null) {
                str = null;
                spannableString = new SpannableString(String.valueOf(str4) + str3 + "：");
                str2 = null;
            } else {
                spannableString = new SpannableString(String.valueOf(str4) + this.f.getName_show() + str3 + "：");
                str = this.f.getUserName();
                str2 = this.f.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            int length = spannableString.length();
            as asVar = new as(this, context, str, str2);
            if (z) {
                Bitmap a = com.baidu.tieba.util.n.a((int) R.drawable.icon_floorhost);
                int width = (a.getWidth() * b) / a.getHeight();
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(a);
                bitmapDrawable2.setBounds(0, 0, width, b);
                ImageSpan imageSpan = new ImageSpan(bitmapDrawable2, 1);
                if (this.f != null) {
                    spannableString.setSpan(imageSpan, str4.length() + this.f.getName_show().length() + 1, str3.length() + str4.length() + this.f.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(imageSpan, str4.length(), str3.length() + str4.length(), 17);
                }
            }
            spannableString.setSpan(asVar, 0, length, 18);
            ArrayList<com.baidu.tbadk.widget.richText.c> a2 = this.k.a();
            if (a2 != null && a2.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar = a2.get(0);
                if (cVar.d() != null) {
                    cVar.d().insert(0, (CharSequence) spannableString);
                    return;
                }
                com.baidu.tbadk.widget.richText.c cVar2 = new com.baidu.tbadk.widget.richText.c(768);
                cVar2.a(spannableString);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < a2.size()) {
                        if (a2.get(i4).a() != 512) {
                            i3 = i4 + 1;
                        } else {
                            cVar2.a(a2.get(i4).e());
                            a2.remove(i4);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                a2.add(0, cVar2);
            }
        }
    }

    public void a(ArrayList<k> arrayList) {
        this.g = arrayList;
    }

    public ArrayList<k> i() {
        return this.h;
    }

    public int j() {
        return this.i;
    }

    public void a(Context context) {
        int a;
        int i;
        int i2;
        if (this.g != null) {
            int i3 = -1;
            int size = this.h.size();
            if (size > 0) {
                try {
                    i3 = this.h.get(size - 1).a();
                } catch (Exception e) {
                    com.baidu.adp.lib.util.f.b("PostData", "uniteContentExcepFace", "error = " + e.getMessage());
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.g.size()) {
                k kVar = this.g.get(i4);
                if (k.b(i5, kVar.a())) {
                    this.h.get(size - 1).a(kVar.a(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.a() == 3 || kVar.a() == 2 || kVar.a() == 11) {
                        this.h.add(kVar);
                        a = kVar.a();
                    } else {
                        k kVar2 = new k();
                        kVar2.a(0);
                        kVar2.a(kVar.a(context));
                        this.h.add(kVar2);
                        a = 0;
                    }
                    i = a;
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
                    com.baidu.adp.lib.util.f.b("PostData", "uniteContent", "error = " + e.getMessage());
                    return;
                }
            }
            int i5 = 0;
            int i6 = i4;
            while (i5 < this.g.size()) {
                k kVar = this.g.get(i5);
                if (k.a(i6, kVar.a())) {
                    this.h.get(size - 1).a(kVar.a(context));
                    i3 = size;
                    i2 = i6;
                } else {
                    if (kVar.a() == 3) {
                        this.h.add(kVar);
                        i = 3;
                    } else if (kVar.a() == 11) {
                        this.h.add(kVar);
                        i = 11;
                    } else {
                        k kVar2 = new k();
                        kVar2.a(0);
                        kVar2.a(kVar.a(context));
                        this.h.add(kVar2);
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
        try {
            if (this.k != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.k.toString());
                if (clipboardManager.getText() != null) {
                    com.baidu.adp.lib.util.f.e(getClass().getName(), "clip_text", clipboardManager.getText().toString());
                    return;
                }
                return;
            }
            if (this.h == null || this.h.size() == 0) {
                a(context);
            }
            ArrayList<k> arrayList = this.h;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.a() == 0) {
                        if (next.d() != null) {
                            sb.append((CharSequence) next.d());
                        }
                    } else if (next.a() == 3) {
                        if (next.e() != null) {
                            sb.append(context.getString(R.string.pic));
                        }
                    } else if (next.a() == 2) {
                        String d = TbFaceManager.a().d(next.b());
                        if (d != null) {
                            sb.append("[");
                            sb.append(d);
                            sb.append("]");
                        }
                    } else if (next.a() == 11 && !bs.c(next.c())) {
                        sb.append("[").append(next.c()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                if (clipboardManager2.getText() != null) {
                    com.baidu.adp.lib.util.f.e("PbActivity", "clip_text", clipboardManager2.getText().toString());
                }
            }
        } catch (NullPointerException e) {
            com.baidu.adp.lib.util.f.b("PostData", "setClipString", e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        a(jSONObject, null);
    }

    public void a(JSONObject jSONObject, Context context) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("id");
                this.b = jSONObject.optString("title");
                this.c = jSONObject.optInt("floor", 0);
                this.d = jSONObject.optLong("time", 0L) * 1000;
                this.e = jSONObject.optString("time_ex");
                this.f.parserJson(jSONObject.optJSONObject("author"));
                JSONArray optJSONArray = jSONObject.optJSONArray(PushConstants.EXTRA_CONTENT);
                this.i = jSONObject.optInt("sub_post_number");
                if (context == null) {
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            k kVar = new k();
                            kVar.a(optJSONArray.optJSONObject(i));
                            this.g.add(kVar);
                        }
                    }
                } else {
                    this.k = TbRichTextView.a(context, optJSONArray, true);
                }
                if (this.i > 0) {
                    JSONArray optJSONArray2 = jSONObject.optJSONObject("sub_post_list").optJSONArray("sub_post_list");
                    for (int i2 = 0; i2 < optJSONArray2.length() && i2 < 2; i2++) {
                        aq aqVar = new aq();
                        aqVar.a(optJSONArray2.getJSONObject(i2), context);
                        this.j.add(aqVar);
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("PostData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.util.au, com.baidu.tieba.util.aw
    public boolean isSupportImageSize() {
        return true;
    }

    @Override // com.baidu.tieba.util.au, com.baidu.tieba.util.aw
    public LinkedList<String> getImageUrl() {
        ArrayList<com.baidu.tbadk.widget.richText.c> a;
        if (this.k == null || (a = this.k.a()) == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = a.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.a() == 8) {
                linkedList.add(next.c().f());
            }
        }
        return linkedList;
    }

    @Override // com.baidu.tieba.util.au, com.baidu.tieba.util.aw
    public LinkedList<com.baidu.tieba.util.av> getImagesWithEmotions() {
        ArrayList<com.baidu.tbadk.widget.richText.c> a;
        if (this.k == null || (a = this.k.a()) == null) {
            return null;
        }
        LinkedList<com.baidu.tieba.util.av> linkedList = new LinkedList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = a.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.a() == 8) {
                com.baidu.tieba.util.av avVar = new com.baidu.tieba.util.av();
                avVar.b = next.c().c();
                avVar.c = next.c().b();
                avVar.a = next.c().f();
                linkedList.add(avVar);
            } else if (next.g() != null) {
                com.baidu.tieba.util.av avVar2 = new com.baidu.tieba.util.av();
                avVar2.b = next.g().f;
                avVar2.c = next.g().g;
                avVar2.d = next.g();
                linkedList.add(avVar2);
            }
        }
        return linkedList;
    }

    public String k() {
        ArrayList<com.baidu.tbadk.widget.richText.c> a;
        String str;
        if (this.k == null || (a = this.k.a()) == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = a.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.a() == 1) {
                stringBuffer.append(next.d().toString());
            } else if (next.a() == 17 && (str = next.g().c) != null && str.startsWith("#(") && str.endsWith(")")) {
                stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.tieba.util.au, com.baidu.tieba.util.aw
    public LinkedList<String> getPhotoUrl() {
        if (this.f == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(this.f.getPortrait());
        if (this.j != null) {
            Iterator<aq> it = this.j.iterator();
            while (it.hasNext()) {
                linkedList.addAll(it.next().getPhotoUrl());
            }
        }
        return linkedList;
    }
}
