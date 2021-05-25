package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import d.a.c.f.a.b;
import d.a.m0.b1.m.d;
import d.a.m0.b1.m.i;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class TbRichTextData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public int f13252e;

    /* renamed from: f  reason: collision with root package name */
    public SpannableStringBuilder f13253f;

    /* renamed from: g  reason: collision with root package name */
    public TbRichTextImageInfo f13254g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<d> f13255h;

    /* renamed from: i  reason: collision with root package name */
    public TbRichTextVoiceInfo f13256i;
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
        this.f13252e = 0;
        this.f13253f = null;
        this.f13254g = null;
        this.f13255h = null;
        this.f13256i = null;
        this.j = null;
        this.p = false;
        this.q = b.f39015a;
    }

    public SpannableStringBuilder A() {
        return this.f13253f;
    }

    public int B() {
        return this.o;
    }

    public TbRichTextTextInfo C() {
        if (this.f13252e != 1) {
            return null;
        }
        return this.j;
    }

    public i D() {
        if (this.f13252e != 32) {
            return null;
        }
        return this.l;
    }

    public TbRichTextVoiceInfo E() {
        int i2 = this.f13252e;
        if (i2 == 512 || i2 == 768) {
            return this.f13256i;
        }
        return null;
    }

    public boolean F() {
        return this.p;
    }

    public void G(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.f13252e != 17) {
            return;
        }
        this.k = tbRichTextEmotionInfo;
    }

    public void H(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        if (this.f13252e != 1281) {
            return;
        }
        this.r = tbRichTextEvaluateItemInfo;
    }

    public void I(int i2, int i3) {
        ArrayList<d> arrayList = this.f13255h;
        if (arrayList != null) {
            Iterator<d> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i2, i3);
            }
        }
    }

    public void J(boolean z) {
        this.p = z;
    }

    public void K(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.f13252e != 8) {
            return;
        }
        this.f13254g = tbRichTextImageInfo;
    }

    public void L(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
    }

    public void M(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.m = tbRichTextLinkImageInfo;
    }

    public void N(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.f13252e != 20) {
            return;
        }
        this.n = tbRichTextMemeInfo;
    }

    public void O(int i2) {
        this.o = i2;
    }

    public void P(i iVar) {
        if (this.f13252e != 32) {
            return;
        }
        this.l = iVar;
    }

    public void Q(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        int i2 = this.f13252e;
        if (i2 == 512 || i2 == 768) {
            this.f13256i = tbRichTextVoiceInfo;
        }
    }

    public void R(CharSequence charSequence) {
        int i2 = this.f13252e;
        if ((i2 == 1 || i2 == 768) && charSequence != null) {
            if (this.f13253f == null) {
                this.f13253f = new SpannableStringBuilder("");
            }
            this.f13253f.replace(0, 0, charSequence);
            this.j.charLength = this.f13253f.length();
        }
    }

    public int getType() {
        return this.f13252e;
    }

    public void s(CharSequence charSequence) {
        int i2 = this.f13252e;
        if ((i2 == 1 || i2 == 768) && charSequence != null) {
            if (this.f13253f == null) {
                this.f13253f = new SpannableStringBuilder("");
            }
            this.f13253f.append(charSequence);
            this.j.charLength = this.f13253f.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.f13252e != 32 || str == null) {
            return;
        }
        this.f13253f = new SpannableStringBuilder(str);
    }

    public ArrayList<d> t() {
        if (this.f13255h == null) {
            this.f13255h = new ArrayList<>();
        }
        return this.f13255h;
    }

    public String toString() {
        TbRichTextEmotionInfo tbRichTextEmotionInfo;
        int i2 = this.f13252e;
        if (i2 == 1) {
            SpannableStringBuilder spannableStringBuilder = this.f13253f;
            return spannableStringBuilder != null ? spannableStringBuilder.toString() : "";
        } else if (i2 != 8) {
            return (i2 != 17 || (tbRichTextEmotionInfo = this.k) == null) ? "" : tbRichTextEmotionInfo.mGifInfo.mSharpText;
        } else {
            TbRichTextImageInfo tbRichTextImageInfo = this.f13254g;
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
        if (this.f13252e != 8) {
            return null;
        }
        return this.f13254g;
    }

    public TbRichTextLinkImageInfo y() {
        if (this.f13252e != 1280) {
            return null;
        }
        return this.m;
    }

    public TbRichTextMemeInfo z() {
        return this.n;
    }

    public TbRichTextData(int i2) {
        this.f13252e = 0;
        this.f13253f = null;
        this.f13254g = null;
        this.f13255h = null;
        this.f13256i = null;
        this.j = null;
        this.p = false;
        this.q = b.f39015a;
        this.f13252e = i2;
        this.j = new TbRichTextTextInfo(this);
    }
}
