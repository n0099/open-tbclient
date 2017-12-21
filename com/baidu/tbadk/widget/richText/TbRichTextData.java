package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder aUU;
    private TbRichTextImageInfo aUV;
    private ArrayList<b> aUW;
    private TbRichTextTextInfo aUX;
    private TbRichTextEmotionInfo aUY;
    private f aUZ;
    private TbRichTextLinkImageInfo aVa;
    private TbRichTextLinkButtonInfo aVb;
    private TbRichTextMemeInfo aVc;
    private int aVd;
    private boolean aVe;
    private TbRichTextVoiceInfo aop;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.aUU = null;
        this.aUV = null;
        this.aUW = null;
        this.aop = null;
        this.aUX = null;
        this.aVe = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.aUU = null;
        this.aUV = null;
        this.aUW = null;
        this.aop = null;
        this.aUX = null;
        this.aVe = false;
        this.mType = i;
        this.aUX = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> Jw() {
        if (this.aUW == null) {
            this.aUW = new ArrayList<>();
        }
        return this.aUW;
    }

    public void U(int i, int i2) {
        if (this.aUW != null) {
            Iterator<b> it = this.aUW.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aUU == null) {
                this.aUU = new SpannableStringBuilder("");
            }
            this.aUU.append(charSequence);
            this.aUX.charLength = this.aUU.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aUU = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo Jx() {
        if (this.mType != 8) {
            return null;
        }
        return this.aUV;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.aUV = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder Jy() {
        return this.aUU;
    }

    public void c(SpannableStringBuilder spannableStringBuilder) {
        if (this.aUU != null) {
            this.aUU.clear();
            this.aUU.append((CharSequence) spannableStringBuilder);
        }
    }

    public TbRichTextVoiceInfo Jz() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aop;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.aop = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aUU != null) {
                return this.aUU.toString();
            }
        } else if (this.mType == 8) {
            if (this.aUV != null) {
                return this.aUV.JL();
            }
        } else if (this.mType == 17 && this.aUY != null) {
            return this.aUY.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo JA() {
        if (this.mType != 1) {
            return null;
        }
        return this.aUX;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.aUZ = fVar;
        }
    }

    public f JB() {
        if (this.mType != 32) {
            return null;
        }
        return this.aUZ;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.aUY = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.aVc = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo JC() {
        return this.aUY;
    }

    public TbRichTextMemeInfo JD() {
        return this.aVc;
    }

    public int JE() {
        return this.aVd;
    }

    public void gc(int i) {
        this.aVd = i;
    }

    public TbRichTextLinkImageInfo JF() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aVa;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.aVa = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo JG() {
        return this.aVb;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.aVb = tbRichTextLinkButtonInfo;
    }

    public void ch(boolean z) {
        this.aVe = z;
    }

    public boolean JH() {
        return this.aVe;
    }
}
