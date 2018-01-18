package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder bIP;
    private TbRichTextImageInfo bIQ;
    private ArrayList<b> bIR;
    private TbRichTextTextInfo bIS;
    private TbRichTextEmotionInfo bIT;
    private f bIU;
    private TbRichTextLinkImageInfo bIV;
    private TbRichTextLinkButtonInfo bIW;
    private TbRichTextMemeInfo bIX;
    private int bIY;
    private boolean bIZ;
    private TbRichTextVoiceInfo bcn;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.bIP = null;
        this.bIQ = null;
        this.bIR = null;
        this.bcn = null;
        this.bIS = null;
        this.bIZ = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.bIP = null;
        this.bIQ = null;
        this.bIR = null;
        this.bcn = null;
        this.bIS = null;
        this.bIZ = false;
        this.mType = i;
        this.bIS = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> QG() {
        if (this.bIR == null) {
            this.bIR = new ArrayList<>();
        }
        return this.bIR;
    }

    public void aT(int i, int i2) {
        if (this.bIR != null) {
            Iterator<b> it = this.bIR.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.bIP == null) {
                this.bIP = new SpannableStringBuilder("");
            }
            this.bIP.append(charSequence);
            this.bIS.charLength = this.bIP.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.bIP = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo QH() {
        if (this.mType != 8) {
            return null;
        }
        return this.bIQ;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.bIQ = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder QI() {
        return this.bIP;
    }

    public TbRichTextVoiceInfo QJ() {
        if (this.mType == 512 || this.mType == 768) {
            return this.bcn;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.bcn = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.bIP != null) {
                return this.bIP.toString();
            }
        } else if (this.mType == 8) {
            if (this.bIQ != null) {
                return this.bIQ.QV();
            }
        } else if (this.mType == 17 && this.bIT != null) {
            return this.bIT.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo QK() {
        if (this.mType != 1) {
            return null;
        }
        return this.bIS;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.bIU = fVar;
        }
    }

    public f QL() {
        if (this.mType != 32) {
            return null;
        }
        return this.bIU;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.bIT = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.bIX = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo QM() {
        return this.bIT;
    }

    public TbRichTextMemeInfo QN() {
        return this.bIX;
    }

    public int QO() {
        return this.bIY;
    }

    public void iX(int i) {
        this.bIY = i;
    }

    public TbRichTextLinkImageInfo QP() {
        if (this.mType != 1280) {
            return null;
        }
        return this.bIV;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.bIV = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo QQ() {
        return this.bIW;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.bIW = tbRichTextLinkButtonInfo;
    }

    public void cI(boolean z) {
        this.bIZ = z;
    }

    public boolean QR() {
        return this.bIZ;
    }
}
