package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder bLc;
    private TbRichTextImageInfo bLd;
    private ArrayList<b> bLe;
    private TbRichTextTextInfo bLf;
    private TbRichTextEmotionInfo bLg;
    private f bLh;
    private TbRichTextLinkImageInfo bLi;
    private TbRichTextLinkButtonInfo bLj;
    private TbRichTextMemeInfo bLk;
    private int bLl;
    private boolean bLm;
    private TbRichTextVoiceInfo bel;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.bLc = null;
        this.bLd = null;
        this.bLe = null;
        this.bel = null;
        this.bLf = null;
        this.bLm = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.bLc = null;
        this.bLd = null;
        this.bLe = null;
        this.bel = null;
        this.bLf = null;
        this.bLm = false;
        this.mType = i;
        this.bLf = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> Rn() {
        if (this.bLe == null) {
            this.bLe = new ArrayList<>();
        }
        return this.bLe;
    }

    public void aT(int i, int i2) {
        if (this.bLe != null) {
            Iterator<b> it = this.bLe.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.bLc == null) {
                this.bLc = new SpannableStringBuilder("");
            }
            this.bLc.append(charSequence);
            this.bLf.charLength = this.bLc.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.bLc = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo Ro() {
        if (this.mType != 8) {
            return null;
        }
        return this.bLd;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.bLd = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder Rp() {
        return this.bLc;
    }

    public TbRichTextVoiceInfo Rq() {
        if (this.mType == 512 || this.mType == 768) {
            return this.bel;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.bel = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.bLc != null) {
                return this.bLc.toString();
            }
        } else if (this.mType == 8) {
            if (this.bLd != null) {
                return this.bLd.RC();
            }
        } else if (this.mType == 17 && this.bLg != null) {
            return this.bLg.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo Rr() {
        if (this.mType != 1) {
            return null;
        }
        return this.bLf;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.bLh = fVar;
        }
    }

    public f Rs() {
        if (this.mType != 32) {
            return null;
        }
        return this.bLh;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.bLg = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.bLk = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo Rt() {
        return this.bLg;
    }

    public TbRichTextMemeInfo Ru() {
        return this.bLk;
    }

    public int Rv() {
        return this.bLl;
    }

    public void iU(int i) {
        this.bLl = i;
    }

    public TbRichTextLinkImageInfo Rw() {
        if (this.mType != 1280) {
            return null;
        }
        return this.bLi;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.bLi = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo Rx() {
        return this.bLj;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.bLj = tbRichTextLinkButtonInfo;
    }

    public void cN(boolean z) {
        this.bLm = z;
    }

    public boolean Ry() {
        return this.bLm;
    }
}
