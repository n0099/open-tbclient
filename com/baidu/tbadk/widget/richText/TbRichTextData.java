package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder fWS;
    private TbRichTextImageInfo fWT;
    private ArrayList<d> fWU;
    private TbRichTextTextInfo fWV;
    private TbRichTextEmotionInfo fWW;
    private i fWX;
    private TbRichTextLinkImageInfo fWY;
    private TbRichTextLinkButtonInfo fWZ;
    private TbRichTextMemeInfo fXa;
    private int fXb;
    private boolean fXc;
    private TbRichTextVoiceInfo fld;
    private int iconType;
    private TbRichTextEvaluateItemInfo mEvaluateItemInfo;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.fWS = null;
        this.fWT = null;
        this.fWU = null;
        this.fld = null;
        this.fWV = null;
        this.fXc = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.fWS = null;
        this.fWT = null;
        this.fWU = null;
        this.fld = null;
        this.fWV = null;
        this.fXc = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
        this.mType = i;
        this.fWV = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<d> bHE() {
        if (this.fWU == null) {
            this.fWU = new ArrayList<>();
        }
        return this.fWU;
    }

    public void bq(int i, int i2) {
        if (this.fWU != null) {
            Iterator<d> it = this.fWU.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void p(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.fWS == null) {
                this.fWS = new SpannableStringBuilder("");
            }
            this.fWS.append(charSequence);
            this.fWV.charLength = this.fWS.length();
        }
    }

    public void q(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.fWS == null) {
                this.fWS = new SpannableStringBuilder("");
            }
            this.fWS.replace(0, 0, charSequence);
            this.fWV.charLength = this.fWS.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.fWS = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo bHF() {
        if (this.mType != 8) {
            return null;
        }
        return this.fWT;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.fWT = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder bHG() {
        return this.fWS;
    }

    public TbRichTextVoiceInfo bHH() {
        if (this.mType == 512 || this.mType == 768) {
            return this.fld;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.fld = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.fWS != null) {
                return this.fWS.toString();
            }
        } else if (this.mType == 8) {
            if (this.fWT != null) {
                return this.fWT.bHS();
            }
        } else if (this.mType == 17 && this.fWW != null) {
            return this.fWW.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo bHI() {
        if (this.mType != 1) {
            return null;
        }
        return this.fWV;
    }

    public void a(i iVar) {
        if (this.mType == 32) {
            this.fWX = iVar;
        }
    }

    public i bHJ() {
        if (this.mType != 32) {
            return null;
        }
        return this.fWX;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.fWW = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.fXa = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo bHK() {
        return this.fWW;
    }

    public TbRichTextMemeInfo bHL() {
        return this.fXa;
    }

    public int bHM() {
        return this.fXb;
    }

    public void sk(int i) {
        this.fXb = i;
    }

    public TbRichTextLinkImageInfo bHN() {
        if (this.mType != 1280) {
            return null;
        }
        return this.fWY;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.fWY = tbRichTextLinkImageInfo;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.fWZ = tbRichTextLinkButtonInfo;
    }

    public void a(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        if (this.mType == 1281) {
            this.mEvaluateItemInfo = tbRichTextEvaluateItemInfo;
        }
    }

    public TbRichTextEvaluateItemInfo getEvaluateItemInfo() {
        return this.mEvaluateItemInfo;
    }

    public void lL(boolean z) {
        this.fXc = z;
    }

    public boolean bHO() {
        return this.fXc;
    }

    public int getIconType() {
        return this.iconType;
    }
}
