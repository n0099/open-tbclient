package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo bTn;
    private SpannableStringBuilder cCB;
    private TbRichTextImageInfo cCC;
    private ArrayList<b> cCD;
    private TbRichTextTextInfo cCE;
    private TbRichTextEmotionInfo cCF;
    private f cCG;
    private TbRichTextLinkImageInfo cCH;
    private TbRichTextLinkButtonInfo cCI;
    private TbRichTextMemeInfo cCJ;
    private int cCK;
    private boolean cCL;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.cCB = null;
        this.cCC = null;
        this.cCD = null;
        this.bTn = null;
        this.cCE = null;
        this.cCL = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.cCB = null;
        this.cCC = null;
        this.cCD = null;
        this.bTn = null;
        this.cCE = null;
        this.cCL = false;
        this.mType = i;
        this.cCE = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> asC() {
        if (this.cCD == null) {
            this.cCD = new ArrayList<>();
        }
        return this.cCD;
    }

    public void at(int i, int i2) {
        if (this.cCD != null) {
            Iterator<b> it = this.cCD.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.cCB == null) {
                this.cCB = new SpannableStringBuilder("");
            }
            this.cCB.append(charSequence);
            this.cCE.charLength = this.cCB.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.cCB = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo asD() {
        if (this.mType != 8) {
            return null;
        }
        return this.cCC;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.cCC = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder asE() {
        return this.cCB;
    }

    public TbRichTextVoiceInfo asF() {
        if (this.mType == 512 || this.mType == 768) {
            return this.bTn;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.bTn = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.cCB != null) {
                return this.cCB.toString();
            }
        } else if (this.mType == 8) {
            if (this.cCC != null) {
                return this.cCC.asR();
            }
        } else if (this.mType == 17 && this.cCF != null) {
            return this.cCF.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo asG() {
        if (this.mType != 1) {
            return null;
        }
        return this.cCE;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.cCG = fVar;
        }
    }

    public f asH() {
        if (this.mType != 32) {
            return null;
        }
        return this.cCG;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.cCF = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.cCJ = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo asI() {
        return this.cCF;
    }

    public TbRichTextMemeInfo asJ() {
        return this.cCJ;
    }

    public int asK() {
        return this.cCK;
    }

    public void kK(int i) {
        this.cCK = i;
    }

    public TbRichTextLinkImageInfo asL() {
        if (this.mType != 1280) {
            return null;
        }
        return this.cCH;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.cCH = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo asM() {
        return this.cCI;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.cCI = tbRichTextLinkButtonInfo;
    }

    public void fu(boolean z) {
        this.cCL = z;
    }

    public boolean asN() {
        return this.cCL;
    }
}
