package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder fPI;
    private TbRichTextImageInfo fPJ;
    private ArrayList<d> fPK;
    private TbRichTextTextInfo fPL;
    private TbRichTextEmotionInfo fPM;
    private i fPN;
    private TbRichTextLinkImageInfo fPO;
    private TbRichTextLinkButtonInfo fPP;
    private TbRichTextMemeInfo fPQ;
    private int fPR;
    private boolean fPS;
    private TbRichTextVoiceInfo fdM;
    private int iconType;
    private TbRichTextEvaluateItemInfo mEvaluateItemInfo;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.fPI = null;
        this.fPJ = null;
        this.fPK = null;
        this.fdM = null;
        this.fPL = null;
        this.fPS = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.fPI = null;
        this.fPJ = null;
        this.fPK = null;
        this.fdM = null;
        this.fPL = null;
        this.fPS = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
        this.mType = i;
        this.fPL = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<d> bIH() {
        if (this.fPK == null) {
            this.fPK = new ArrayList<>();
        }
        return this.fPK;
    }

    public void bv(int i, int i2) {
        if (this.fPK != null) {
            Iterator<d> it = this.fPK.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void q(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.fPI == null) {
                this.fPI = new SpannableStringBuilder("");
            }
            this.fPI.append(charSequence);
            this.fPL.charLength = this.fPI.length();
        }
    }

    public void r(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.fPI == null) {
                this.fPI = new SpannableStringBuilder("");
            }
            this.fPI.replace(0, 0, charSequence);
            this.fPL.charLength = this.fPI.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.fPI = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo bII() {
        if (this.mType != 8) {
            return null;
        }
        return this.fPJ;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.fPJ = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder bIJ() {
        return this.fPI;
    }

    public TbRichTextVoiceInfo bIK() {
        if (this.mType == 512 || this.mType == 768) {
            return this.fdM;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.fdM = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.fPI != null) {
                return this.fPI.toString();
            }
        } else if (this.mType == 8) {
            if (this.fPJ != null) {
                return this.fPJ.bIX();
            }
        } else if (this.mType == 17 && this.fPM != null) {
            return this.fPM.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo bIL() {
        if (this.mType != 1) {
            return null;
        }
        return this.fPL;
    }

    public void a(i iVar) {
        if (this.mType == 32) {
            this.fPN = iVar;
        }
    }

    public i bIM() {
        if (this.mType != 32) {
            return null;
        }
        return this.fPN;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.fPM = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.fPQ = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo bIN() {
        return this.fPM;
    }

    public TbRichTextMemeInfo bIO() {
        return this.fPQ;
    }

    public int bIP() {
        return this.fPR;
    }

    public void tA(int i) {
        this.fPR = i;
    }

    public TbRichTextLinkImageInfo bIQ() {
        if (this.mType != 1280) {
            return null;
        }
        return this.fPO;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.fPO = tbRichTextLinkImageInfo;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.fPP = tbRichTextLinkButtonInfo;
    }

    public void a(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        if (this.mType == 1281) {
            this.mEvaluateItemInfo = tbRichTextEvaluateItemInfo;
        }
    }

    public TbRichTextEvaluateItemInfo getEvaluateItemInfo() {
        return this.mEvaluateItemInfo;
    }

    public void lp(boolean z) {
        this.fPS = z;
    }

    public boolean bIR() {
        return this.fPS;
    }

    public int getIconType() {
        return this.iconType;
    }
}
