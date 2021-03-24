package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import d.b.b.f.a.b;
import d.b.h0.b1.m.d;
import d.b.h0.b1.m.i;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class TbRichTextData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public int f14288e;

    /* renamed from: f  reason: collision with root package name */
    public SpannableStringBuilder f14289f;

    /* renamed from: g  reason: collision with root package name */
    public TbRichTextImageInfo f14290g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<d> f14291h;
    public TbRichTextVoiceInfo i;
    public TbRichTextTextInfo j;
    public TbRichTextEmotionInfo k;
    public i l;
    public TbRichTextLinkImageInfo m;
    public TbRichTextMemeInfo n;
    public int o;
    public boolean p;
    public int q;
    public TbRichTextEvaluateItemInfo r;

    /* loaded from: classes3.dex */
    public class TbRichTextTextInfo extends OrmObject {
        public boolean needRecompute;
        public int charLength = 0;
        public int viewWidth = 0;
        public int viewHeight = 0;

        public TbRichTextTextInfo(TbRichTextData tbRichTextData) {
        }
    }

    public TbRichTextData() {
        this.f14288e = 0;
        this.f14289f = null;
        this.f14290g = null;
        this.f14291h = null;
        this.i = null;
        this.j = null;
        this.p = false;
        this.q = b.f42151a;
    }

    public SpannableStringBuilder A() {
        return this.f14289f;
    }

    public int B() {
        return this.o;
    }

    public TbRichTextTextInfo C() {
        if (this.f14288e != 1) {
            return null;
        }
        return this.j;
    }

    public i D() {
        if (this.f14288e != 32) {
            return null;
        }
        return this.l;
    }

    public TbRichTextVoiceInfo E() {
        int i = this.f14288e;
        if (i == 512 || i == 768) {
            return this.i;
        }
        return null;
    }

    public boolean F() {
        return this.p;
    }

    public void G(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.f14288e != 17) {
            return;
        }
        this.k = tbRichTextEmotionInfo;
    }

    public void H(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        if (this.f14288e != 1281) {
            return;
        }
        this.r = tbRichTextEvaluateItemInfo;
    }

    public void I(int i, int i2) {
        ArrayList<d> arrayList = this.f14291h;
        if (arrayList != null) {
            Iterator<d> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void J(boolean z) {
        this.p = z;
    }

    public void K(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.f14288e != 8) {
            return;
        }
        this.f14290g = tbRichTextImageInfo;
    }

    public void L(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
    }

    public void M(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.m = tbRichTextLinkImageInfo;
    }

    public void N(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.f14288e != 20) {
            return;
        }
        this.n = tbRichTextMemeInfo;
    }

    public void O(int i) {
        this.o = i;
    }

    public void P(i iVar) {
        if (this.f14288e != 32) {
            return;
        }
        this.l = iVar;
    }

    public void Q(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        int i = this.f14288e;
        if (i == 512 || i == 768) {
            this.i = tbRichTextVoiceInfo;
        }
    }

    public void R(CharSequence charSequence) {
        int i = this.f14288e;
        if ((i == 1 || i == 768) && charSequence != null) {
            if (this.f14289f == null) {
                this.f14289f = new SpannableStringBuilder("");
            }
            this.f14289f.replace(0, 0, charSequence);
            this.j.charLength = this.f14289f.length();
        }
    }

    public int getType() {
        return this.f14288e;
    }

    public void s(CharSequence charSequence) {
        int i = this.f14288e;
        if ((i == 1 || i == 768) && charSequence != null) {
            if (this.f14289f == null) {
                this.f14289f = new SpannableStringBuilder("");
            }
            this.f14289f.append(charSequence);
            this.j.charLength = this.f14289f.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.f14288e != 32 || str == null) {
            return;
        }
        this.f14289f = new SpannableStringBuilder(str);
    }

    public ArrayList<d> t() {
        if (this.f14291h == null) {
            this.f14291h = new ArrayList<>();
        }
        return this.f14291h;
    }

    public String toString() {
        TbRichTextEmotionInfo tbRichTextEmotionInfo;
        int i = this.f14288e;
        if (i == 1) {
            SpannableStringBuilder spannableStringBuilder = this.f14289f;
            return spannableStringBuilder != null ? spannableStringBuilder.toString() : "";
        } else if (i != 8) {
            return (i != 17 || (tbRichTextEmotionInfo = this.k) == null) ? "" : tbRichTextEmotionInfo.mGifInfo.mSharpText;
        } else {
            TbRichTextImageInfo tbRichTextImageInfo = this.f14290g;
            return tbRichTextImageInfo != null ? tbRichTextImageInfo.u() : "";
        }
    }

    public TbRichTextEmotionInfo u() {
        return this.k;
    }

    public TbRichTextEvaluateItemInfo v() {
        return this.r;
    }

    public int w() {
        return this.q;
    }

    public TbRichTextImageInfo x() {
        if (this.f14288e != 8) {
            return null;
        }
        return this.f14290g;
    }

    public TbRichTextLinkImageInfo y() {
        if (this.f14288e != 1280) {
            return null;
        }
        return this.m;
    }

    public TbRichTextMemeInfo z() {
        return this.n;
    }

    public TbRichTextData(int i) {
        this.f14288e = 0;
        this.f14289f = null;
        this.f14290g = null;
        this.f14291h = null;
        this.i = null;
        this.j = null;
        this.p = false;
        this.q = b.f42151a;
        this.f14288e = i;
        this.j = new TbRichTextTextInfo(this);
    }
}
