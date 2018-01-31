package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder bIX;
    private TbRichTextImageInfo bIY;
    private ArrayList<b> bIZ;
    private TbRichTextTextInfo bJa;
    private TbRichTextEmotionInfo bJb;
    private f bJc;
    private TbRichTextLinkImageInfo bJd;
    private TbRichTextLinkButtonInfo bJe;
    private TbRichTextMemeInfo bJf;
    private int bJg;
    private boolean bJh;
    private TbRichTextVoiceInfo bcv;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.bIX = null;
        this.bIY = null;
        this.bIZ = null;
        this.bcv = null;
        this.bJa = null;
        this.bJh = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.bIX = null;
        this.bIY = null;
        this.bIZ = null;
        this.bcv = null;
        this.bJa = null;
        this.bJh = false;
        this.mType = i;
        this.bJa = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> QI() {
        if (this.bIZ == null) {
            this.bIZ = new ArrayList<>();
        }
        return this.bIZ;
    }

    public void aT(int i, int i2) {
        if (this.bIZ != null) {
            Iterator<b> it = this.bIZ.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.bIX == null) {
                this.bIX = new SpannableStringBuilder("");
            }
            this.bIX.append(charSequence);
            this.bJa.charLength = this.bIX.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.bIX = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo QJ() {
        if (this.mType != 8) {
            return null;
        }
        return this.bIY;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.bIY = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder QK() {
        return this.bIX;
    }

    public TbRichTextVoiceInfo QL() {
        if (this.mType == 512 || this.mType == 768) {
            return this.bcv;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.bcv = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.bIX != null) {
                return this.bIX.toString();
            }
        } else if (this.mType == 8) {
            if (this.bIY != null) {
                return this.bIY.QX();
            }
        } else if (this.mType == 17 && this.bJb != null) {
            return this.bJb.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo QM() {
        if (this.mType != 1) {
            return null;
        }
        return this.bJa;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.bJc = fVar;
        }
    }

    public f QN() {
        if (this.mType != 32) {
            return null;
        }
        return this.bJc;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.bJb = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.bJf = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo QO() {
        return this.bJb;
    }

    public TbRichTextMemeInfo QP() {
        return this.bJf;
    }

    public int QQ() {
        return this.bJg;
    }

    public void iX(int i) {
        this.bJg = i;
    }

    public TbRichTextLinkImageInfo QR() {
        if (this.mType != 1280) {
            return null;
        }
        return this.bJd;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.bJd = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo QS() {
        return this.bJe;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.bJe = tbRichTextLinkButtonInfo;
    }

    public void cJ(boolean z) {
        this.bJh = z;
    }

    public boolean QT() {
        return this.bJh;
    }
}
