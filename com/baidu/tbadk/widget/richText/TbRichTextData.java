package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextMemeInfo fYA;
    private int fYB;
    private boolean fYC;
    private SpannableStringBuilder fYs;
    private TbRichTextImageInfo fYt;
    private ArrayList<d> fYu;
    private TbRichTextTextInfo fYv;
    private TbRichTextEmotionInfo fYw;
    private i fYx;
    private TbRichTextLinkImageInfo fYy;
    private TbRichTextLinkButtonInfo fYz;
    private TbRichTextVoiceInfo fmD;
    private int iconType;
    private TbRichTextEvaluateItemInfo mEvaluateItemInfo;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.fYs = null;
        this.fYt = null;
        this.fYu = null;
        this.fmD = null;
        this.fYv = null;
        this.fYC = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.fYs = null;
        this.fYt = null;
        this.fYu = null;
        this.fmD = null;
        this.fYv = null;
        this.fYC = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
        this.mType = i;
        this.fYv = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<d> bHI() {
        if (this.fYu == null) {
            this.fYu = new ArrayList<>();
        }
        return this.fYu;
    }

    public void bq(int i, int i2) {
        if (this.fYu != null) {
            Iterator<d> it = this.fYu.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void p(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.fYs == null) {
                this.fYs = new SpannableStringBuilder("");
            }
            this.fYs.append(charSequence);
            this.fYv.charLength = this.fYs.length();
        }
    }

    public void q(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.fYs == null) {
                this.fYs = new SpannableStringBuilder("");
            }
            this.fYs.replace(0, 0, charSequence);
            this.fYv.charLength = this.fYs.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.fYs = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo bHJ() {
        if (this.mType != 8) {
            return null;
        }
        return this.fYt;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.fYt = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder bHK() {
        return this.fYs;
    }

    public TbRichTextVoiceInfo bHL() {
        if (this.mType == 512 || this.mType == 768) {
            return this.fmD;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.fmD = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.fYs != null) {
                return this.fYs.toString();
            }
        } else if (this.mType == 8) {
            if (this.fYt != null) {
                return this.fYt.bHW();
            }
        } else if (this.mType == 17 && this.fYw != null) {
            return this.fYw.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo bHM() {
        if (this.mType != 1) {
            return null;
        }
        return this.fYv;
    }

    public void a(i iVar) {
        if (this.mType == 32) {
            this.fYx = iVar;
        }
    }

    public i bHN() {
        if (this.mType != 32) {
            return null;
        }
        return this.fYx;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.fYw = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.fYA = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo bHO() {
        return this.fYw;
    }

    public TbRichTextMemeInfo bHP() {
        return this.fYA;
    }

    public int bHQ() {
        return this.fYB;
    }

    public void sm(int i) {
        this.fYB = i;
    }

    public TbRichTextLinkImageInfo bHR() {
        if (this.mType != 1280) {
            return null;
        }
        return this.fYy;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.fYy = tbRichTextLinkImageInfo;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.fYz = tbRichTextLinkButtonInfo;
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
        this.fYC = z;
    }

    public boolean bHS() {
        return this.fYC;
    }

    public int getIconType() {
        return this.iconType;
    }
}
