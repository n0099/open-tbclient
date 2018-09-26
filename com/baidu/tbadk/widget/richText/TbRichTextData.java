package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo aAY;
    private SpannableStringBuilder biI;
    private TbRichTextImageInfo biJ;
    private ArrayList<b> biK;
    private TbRichTextTextInfo biL;
    private TbRichTextEmotionInfo biM;
    private f biN;
    private TbRichTextLinkImageInfo biO;
    private TbRichTextLinkButtonInfo biP;
    private TbRichTextMemeInfo biQ;
    private int biR;
    private boolean biS;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.biI = null;
        this.biJ = null;
        this.biK = null;
        this.aAY = null;
        this.biL = null;
        this.biS = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.biI = null;
        this.biJ = null;
        this.biK = null;
        this.aAY = null;
        this.biL = null;
        this.biS = false;
        this.mType = i;
        this.biL = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> OU() {
        if (this.biK == null) {
            this.biK = new ArrayList<>();
        }
        return this.biK;
    }

    public void T(int i, int i2) {
        if (this.biK != null) {
            Iterator<b> it = this.biK.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.biI == null) {
                this.biI = new SpannableStringBuilder("");
            }
            this.biI.append(charSequence);
            this.biL.charLength = this.biI.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.biI = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo OV() {
        if (this.mType != 8) {
            return null;
        }
        return this.biJ;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.biJ = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder OW() {
        return this.biI;
    }

    public TbRichTextVoiceInfo OX() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aAY;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.aAY = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.biI != null) {
                return this.biI.toString();
            }
        } else if (this.mType == 8) {
            if (this.biJ != null) {
                return this.biJ.Pk();
            }
        } else if (this.mType == 17 && this.biM != null) {
            return this.biM.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo OY() {
        if (this.mType != 1) {
            return null;
        }
        return this.biL;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.biN = fVar;
        }
    }

    public f OZ() {
        if (this.mType != 32) {
            return null;
        }
        return this.biN;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.biM = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.biQ = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo Pa() {
        return this.biM;
    }

    public TbRichTextMemeInfo Pb() {
        return this.biQ;
    }

    public int Pc() {
        return this.biR;
    }

    public void gk(int i) {
        this.biR = i;
    }

    public TbRichTextLinkImageInfo Pd() {
        if (this.mType != 1280) {
            return null;
        }
        return this.biO;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.biO = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo Pe() {
        return this.biP;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.biP = tbRichTextLinkButtonInfo;
    }

    public void cA(boolean z) {
        this.biS = z;
    }

    public boolean Pf() {
        return this.biS;
    }
}
