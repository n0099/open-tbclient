package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo bTp;
    private SpannableStringBuilder cCD;
    private TbRichTextImageInfo cCE;
    private ArrayList<b> cCF;
    private TbRichTextTextInfo cCG;
    private TbRichTextEmotionInfo cCH;
    private f cCI;
    private TbRichTextLinkImageInfo cCJ;
    private TbRichTextLinkButtonInfo cCK;
    private TbRichTextMemeInfo cCL;
    private int cCM;
    private boolean cCN;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.cCD = null;
        this.cCE = null;
        this.cCF = null;
        this.bTp = null;
        this.cCG = null;
        this.cCN = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.cCD = null;
        this.cCE = null;
        this.cCF = null;
        this.bTp = null;
        this.cCG = null;
        this.cCN = false;
        this.mType = i;
        this.cCG = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> asz() {
        if (this.cCF == null) {
            this.cCF = new ArrayList<>();
        }
        return this.cCF;
    }

    public void at(int i, int i2) {
        if (this.cCF != null) {
            Iterator<b> it = this.cCF.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.cCD == null) {
                this.cCD = new SpannableStringBuilder("");
            }
            this.cCD.append(charSequence);
            this.cCG.charLength = this.cCD.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.cCD = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo asA() {
        if (this.mType != 8) {
            return null;
        }
        return this.cCE;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.cCE = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder asB() {
        return this.cCD;
    }

    public TbRichTextVoiceInfo asC() {
        if (this.mType == 512 || this.mType == 768) {
            return this.bTp;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.bTp = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.cCD != null) {
                return this.cCD.toString();
            }
        } else if (this.mType == 8) {
            if (this.cCE != null) {
                return this.cCE.asO();
            }
        } else if (this.mType == 17 && this.cCH != null) {
            return this.cCH.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo asD() {
        if (this.mType != 1) {
            return null;
        }
        return this.cCG;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.cCI = fVar;
        }
    }

    public f asE() {
        if (this.mType != 32) {
            return null;
        }
        return this.cCI;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.cCH = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.cCL = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo asF() {
        return this.cCH;
    }

    public TbRichTextMemeInfo asG() {
        return this.cCL;
    }

    public int asH() {
        return this.cCM;
    }

    public void kJ(int i) {
        this.cCM = i;
    }

    public TbRichTextLinkImageInfo asI() {
        if (this.mType != 1280) {
            return null;
        }
        return this.cCJ;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.cCJ = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo asJ() {
        return this.cCK;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.cCK = tbRichTextLinkButtonInfo;
    }

    public void fu(boolean z) {
        this.cCN = z;
    }

    public boolean asK() {
        return this.cCN;
    }
}
