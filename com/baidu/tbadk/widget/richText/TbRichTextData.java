package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo eRt;
    private SpannableStringBuilder fCB;
    private TbRichTextImageInfo fCC;
    private ArrayList<d> fCD;
    private TbRichTextTextInfo fCE;
    private TbRichTextEmotionInfo fCF;
    private j fCG;
    private TbRichTextLinkImageInfo fCH;
    private TbRichTextLinkButtonInfo fCI;
    private TbRichTextMemeInfo fCJ;
    private int fCK;
    private boolean fCL;
    private TbRichTextEvaluateItemInfo fCM;
    private int iconType;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.fCB = null;
        this.fCC = null;
        this.fCD = null;
        this.eRt = null;
        this.fCE = null;
        this.fCL = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.fCB = null;
        this.fCC = null;
        this.fCD = null;
        this.eRt = null;
        this.fCE = null;
        this.fCL = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
        this.mType = i;
        this.fCE = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<d> bDo() {
        if (this.fCD == null) {
            this.fCD = new ArrayList<>();
        }
        return this.fCD;
    }

    public void bt(int i, int i2) {
        if (this.fCD != null) {
            Iterator<d> it = this.fCD.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void o(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.fCB == null) {
                this.fCB = new SpannableStringBuilder("");
            }
            this.fCB.append(charSequence);
            this.fCE.charLength = this.fCB.length();
        }
    }

    public void p(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.fCB == null) {
                this.fCB = new SpannableStringBuilder("");
            }
            this.fCB.replace(0, 0, charSequence);
            this.fCE.charLength = this.fCB.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.fCB = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo bDp() {
        if (this.mType != 8) {
            return null;
        }
        return this.fCC;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.fCC = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder bDq() {
        return this.fCB;
    }

    public TbRichTextVoiceInfo bDr() {
        if (this.mType == 512 || this.mType == 768) {
            return this.eRt;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.eRt = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.fCB != null) {
                return this.fCB.toString();
            }
        } else if (this.mType == 8) {
            if (this.fCC != null) {
                return this.fCC.bDF();
            }
        } else if (this.mType == 17 && this.fCF != null) {
            return this.fCF.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo bDs() {
        if (this.mType != 1) {
            return null;
        }
        return this.fCE;
    }

    public void a(j jVar) {
        if (this.mType == 32) {
            this.fCG = jVar;
        }
    }

    public j bDt() {
        if (this.mType != 32) {
            return null;
        }
        return this.fCG;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.fCF = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.fCJ = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo bDu() {
        return this.fCF;
    }

    public TbRichTextMemeInfo bDv() {
        return this.fCJ;
    }

    public int bDw() {
        return this.fCK;
    }

    public void sp(int i) {
        this.fCK = i;
    }

    public TbRichTextLinkImageInfo bDx() {
        if (this.mType != 1280) {
            return null;
        }
        return this.fCH;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.fCH = tbRichTextLinkImageInfo;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.fCI = tbRichTextLinkButtonInfo;
    }

    public void a(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        if (this.mType == 1281) {
            this.fCM = tbRichTextEvaluateItemInfo;
        }
    }

    public TbRichTextEvaluateItemInfo bDy() {
        return this.fCM;
    }

    public void kL(boolean z) {
        this.fCL = z;
    }

    public boolean bDz() {
        return this.fCL;
    }

    public int getIconType() {
        return this.iconType;
    }
}
