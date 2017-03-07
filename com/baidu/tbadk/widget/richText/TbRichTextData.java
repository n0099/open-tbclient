package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextLinkImageInfo aMA;
    private TbRichTextLinkButtonInfo aMB;
    private TbRichTextGraffitiInfo aMC;
    private int aMD;
    private boolean aME;
    private SpannableStringBuilder aMt;
    private TbRichTextImageInfo aMu;
    private ArrayList<a> aMv;
    private TbRichTextVoiceInfo aMw;
    private TbRichTextTextInfo aMx;
    private TbRichTextEmotionInfo aMy;
    private e aMz;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.aMt = null;
        this.aMu = null;
        this.aMv = null;
        this.aMw = null;
        this.aMx = null;
        this.aME = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.aMt = null;
        this.aMu = null;
        this.aMv = null;
        this.aMw = null;
        this.aMx = null;
        this.aME = false;
        this.mType = i;
        this.aMx = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<a> HU() {
        if (this.aMv == null) {
            this.aMv = new ArrayList<>();
        }
        return this.aMv;
    }

    public void P(int i, int i2) {
        if (this.aMv != null) {
            Iterator<a> it = this.aMv.iterator();
            while (it.hasNext()) {
                a next = it.next();
                Rect bounds = next.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    next.R(0, i2);
                }
            }
        }
    }

    public void Q(int i, int i2) {
        if (this.aMv != null) {
            Iterator<a> it = this.aMv.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aMt == null) {
                this.aMt = new SpannableStringBuilder("");
            }
            this.aMt.append(charSequence);
            this.aMx.charLength = this.aMt.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aMt = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo HV() {
        if (this.mType != 8) {
            return null;
        }
        return this.aMu;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.aMu = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder HW() {
        return this.aMt;
    }

    public void b(SpannableStringBuilder spannableStringBuilder) {
        if (this.aMt != null) {
            this.aMt.clear();
            this.aMt.append((CharSequence) spannableStringBuilder);
        }
    }

    public TbRichTextVoiceInfo HX() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aMw;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.aMw = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aMt != null) {
                return this.aMt.toString();
            }
        } else if (this.mType == 8) {
            if (this.aMu != null) {
                return this.aMu.Ij();
            }
        } else if (this.mType == 17 && this.aMy != null) {
            return this.aMy.mGifInfo.mSharpText;
        }
        return "";
    }

    /* loaded from: classes.dex */
    public class TbRichTextTextInfo extends OrmObject {
        public boolean needRecompute;
        public int charLength = 0;
        public int viewWidth = 0;
        public int viewHeight = 0;

        public TbRichTextTextInfo() {
        }
    }

    public TbRichTextTextInfo HY() {
        if (this.mType != 1) {
            return null;
        }
        return this.aMx;
    }

    public void a(e eVar) {
        if (this.mType == 32) {
            this.aMz = eVar;
        }
    }

    public e HZ() {
        if (this.mType != 32) {
            return null;
        }
        return this.aMz;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.aMy = tbRichTextEmotionInfo;
        }
    }

    public TbRichTextEmotionInfo Ia() {
        return this.aMy;
    }

    public int Ib() {
        return this.aMD;
    }

    public void fq(int i) {
        this.aMD = i;
    }

    public TbRichTextLinkImageInfo Ic() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aMA;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.aMA = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo Id() {
        return this.aMB;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.aMB = tbRichTextLinkButtonInfo;
    }

    public TbRichTextGraffitiInfo Ie() {
        return this.aMC;
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo) {
        if (this.mType == 1536) {
            this.aMC = tbRichTextGraffitiInfo;
        }
    }

    public void ca(boolean z) {
        this.aME = z;
    }

    public boolean If() {
        return this.aME;
    }
}
