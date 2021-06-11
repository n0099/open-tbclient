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
    public int f13317e;

    /* renamed from: f  reason: collision with root package name */
    public SpannableStringBuilder f13318f;

    /* renamed from: g  reason: collision with root package name */
    public TbRichTextImageInfo f13319g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<d> f13320h;

    /* renamed from: i  reason: collision with root package name */
    public TbRichTextVoiceInfo f13321i;
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
        this.f13317e = 0;
        this.f13318f = null;
        this.f13319g = null;
        this.f13320h = null;
        this.f13321i = null;
        this.j = null;
        this.p = false;
        this.q = b.f42668a;
    }

    public int A() {
        return this.q;
    }

    public TbRichTextImageInfo B() {
        if (this.f13317e != 8) {
            return null;
        }
        return this.f13319g;
    }

    public TbRichTextLinkImageInfo C() {
        if (this.f13317e != 1280) {
            return null;
        }
        return this.m;
    }

    public TbRichTextMemeInfo D() {
        return this.n;
    }

    public SpannableStringBuilder E() {
        return this.f13318f;
    }

    public int F() {
        return this.o;
    }

    public TbRichTextTextInfo G() {
        if (this.f13317e != 1) {
            return null;
        }
        return this.j;
    }

    public i H() {
        if (this.f13317e != 32) {
            return null;
        }
        return this.l;
    }

    public TbRichTextVoiceInfo I() {
        int i2 = this.f13317e;
        if (i2 == 512 || i2 == 768) {
            return this.f13321i;
        }
        return null;
    }

    public boolean J() {
        return this.p;
    }

    public void K(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.f13317e != 17) {
            return;
        }
        this.k = tbRichTextEmotionInfo;
    }

    public void L(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        if (this.f13317e != 1281) {
            return;
        }
        this.r = tbRichTextEvaluateItemInfo;
    }

    public void M(int i2, int i3) {
        ArrayList<d> arrayList = this.f13320h;
        if (arrayList != null) {
            Iterator<d> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i2, i3);
            }
        }
    }

    public void N(boolean z) {
        this.p = z;
    }

    public void O(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.f13317e != 8) {
            return;
        }
        this.f13319g = tbRichTextImageInfo;
    }

    public void P(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
    }

    public void Q(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.m = tbRichTextLinkImageInfo;
    }

    public void R(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.f13317e != 20) {
            return;
        }
        this.n = tbRichTextMemeInfo;
    }

    public void S(int i2) {
        this.o = i2;
    }

    public void T(i iVar) {
        if (this.f13317e != 32) {
            return;
        }
        this.l = iVar;
    }

    public void U(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        int i2 = this.f13317e;
        if (i2 == 512 || i2 == 768) {
            this.f13321i = tbRichTextVoiceInfo;
        }
    }

    public void V(CharSequence charSequence) {
        int i2 = this.f13317e;
        if ((i2 == 1 || i2 == 768) && charSequence != null) {
            if (this.f13318f == null) {
                this.f13318f = new SpannableStringBuilder("");
            }
            this.f13318f.replace(0, 0, charSequence);
            this.j.charLength = this.f13318f.length();
        }
    }

    public int getType() {
        return this.f13317e;
    }

    public void setVideoUrl(String str) {
        if (this.f13317e != 32 || str == null) {
            return;
        }
        this.f13318f = new SpannableStringBuilder(str);
    }

    public String toString() {
        TbRichTextEmotionInfo tbRichTextEmotionInfo;
        int i2 = this.f13317e;
        if (i2 == 1) {
            SpannableStringBuilder spannableStringBuilder = this.f13318f;
            return spannableStringBuilder != null ? spannableStringBuilder.toString() : "";
        } else if (i2 != 8) {
            return (i2 != 17 || (tbRichTextEmotionInfo = this.k) == null) ? "" : tbRichTextEmotionInfo.mGifInfo.mSharpText;
        } else {
            TbRichTextImageInfo tbRichTextImageInfo = this.f13319g;
            return tbRichTextImageInfo != null ? tbRichTextImageInfo.y() : "";
        }
    }

    public void w(CharSequence charSequence) {
        int i2 = this.f13317e;
        if ((i2 == 1 || i2 == 768) && charSequence != null) {
            if (this.f13318f == null) {
                this.f13318f = new SpannableStringBuilder("");
            }
            this.f13318f.append(charSequence);
            this.j.charLength = this.f13318f.length();
        }
    }

    public ArrayList<d> x() {
        if (this.f13320h == null) {
            this.f13320h = new ArrayList<>();
        }
        return this.f13320h;
    }

    public TbRichTextEmotionInfo y() {
        return this.k;
    }

    public TbRichTextEvaluateItemInfo z() {
        return this.r;
    }

    public TbRichTextData(int i2) {
        this.f13317e = 0;
        this.f13318f = null;
        this.f13319g = null;
        this.f13320h = null;
        this.f13321i = null;
        this.j = null;
        this.p = false;
        this.q = b.f42668a;
        this.f13317e = i2;
        this.j = new TbRichTextTextInfo(this);
    }
}
