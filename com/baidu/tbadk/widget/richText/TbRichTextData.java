package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo bTq;
    private SpannableStringBuilder cCE;
    private TbRichTextImageInfo cCF;
    private ArrayList<b> cCG;
    private TbRichTextTextInfo cCH;
    private TbRichTextEmotionInfo cCI;
    private f cCJ;
    private TbRichTextLinkImageInfo cCK;
    private TbRichTextLinkButtonInfo cCL;
    private TbRichTextMemeInfo cCM;
    private int cCN;
    private boolean cCO;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.cCE = null;
        this.cCF = null;
        this.cCG = null;
        this.bTq = null;
        this.cCH = null;
        this.cCO = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.cCE = null;
        this.cCF = null;
        this.cCG = null;
        this.bTq = null;
        this.cCH = null;
        this.cCO = false;
        this.mType = i;
        this.cCH = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> asz() {
        if (this.cCG == null) {
            this.cCG = new ArrayList<>();
        }
        return this.cCG;
    }

    public void at(int i, int i2) {
        if (this.cCG != null) {
            Iterator<b> it = this.cCG.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.cCE == null) {
                this.cCE = new SpannableStringBuilder("");
            }
            this.cCE.append(charSequence);
            this.cCH.charLength = this.cCE.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.cCE = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo asA() {
        if (this.mType != 8) {
            return null;
        }
        return this.cCF;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.cCF = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder asB() {
        return this.cCE;
    }

    public TbRichTextVoiceInfo asC() {
        if (this.mType == 512 || this.mType == 768) {
            return this.bTq;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.bTq = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.cCE != null) {
                return this.cCE.toString();
            }
        } else if (this.mType == 8) {
            if (this.cCF != null) {
                return this.cCF.asO();
            }
        } else if (this.mType == 17 && this.cCI != null) {
            return this.cCI.mGifInfo.mSharpText;
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
        return this.cCH;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.cCJ = fVar;
        }
    }

    public f asE() {
        if (this.mType != 32) {
            return null;
        }
        return this.cCJ;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.cCI = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.cCM = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo asF() {
        return this.cCI;
    }

    public TbRichTextMemeInfo asG() {
        return this.cCM;
    }

    public int asH() {
        return this.cCN;
    }

    public void kJ(int i) {
        this.cCN = i;
    }

    public TbRichTextLinkImageInfo asI() {
        if (this.mType != 1280) {
            return null;
        }
        return this.cCK;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.cCK = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo asJ() {
        return this.cCL;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.cCL = tbRichTextLinkButtonInfo;
    }

    public void fu(boolean z) {
        this.cCO = z;
    }

    public boolean asK() {
        return this.cCO;
    }
}
