package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder bKP;
    private TbRichTextImageInfo bKQ;
    private ArrayList<b> bKR;
    private TbRichTextTextInfo bKS;
    private TbRichTextEmotionInfo bKT;
    private f bKU;
    private TbRichTextLinkImageInfo bKV;
    private TbRichTextLinkButtonInfo bKW;
    private TbRichTextMemeInfo bKX;
    private int bKY;
    private boolean bKZ;
    private TbRichTextVoiceInfo bdZ;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.bKP = null;
        this.bKQ = null;
        this.bKR = null;
        this.bdZ = null;
        this.bKS = null;
        this.bKZ = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.bKP = null;
        this.bKQ = null;
        this.bKR = null;
        this.bdZ = null;
        this.bKS = null;
        this.bKZ = false;
        this.mType = i;
        this.bKS = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> Rm() {
        if (this.bKR == null) {
            this.bKR = new ArrayList<>();
        }
        return this.bKR;
    }

    public void aT(int i, int i2) {
        if (this.bKR != null) {
            Iterator<b> it = this.bKR.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.bKP == null) {
                this.bKP = new SpannableStringBuilder("");
            }
            this.bKP.append(charSequence);
            this.bKS.charLength = this.bKP.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.bKP = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo Rn() {
        if (this.mType != 8) {
            return null;
        }
        return this.bKQ;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.bKQ = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder Ro() {
        return this.bKP;
    }

    public TbRichTextVoiceInfo Rp() {
        if (this.mType == 512 || this.mType == 768) {
            return this.bdZ;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.bdZ = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.bKP != null) {
                return this.bKP.toString();
            }
        } else if (this.mType == 8) {
            if (this.bKQ != null) {
                return this.bKQ.RB();
            }
        } else if (this.mType == 17 && this.bKT != null) {
            return this.bKT.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo Rq() {
        if (this.mType != 1) {
            return null;
        }
        return this.bKS;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.bKU = fVar;
        }
    }

    public f Rr() {
        if (this.mType != 32) {
            return null;
        }
        return this.bKU;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.bKT = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.bKX = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo Rs() {
        return this.bKT;
    }

    public TbRichTextMemeInfo Rt() {
        return this.bKX;
    }

    public int Ru() {
        return this.bKY;
    }

    public void iU(int i) {
        this.bKY = i;
    }

    public TbRichTextLinkImageInfo Rv() {
        if (this.mType != 1280) {
            return null;
        }
        return this.bKV;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.bKV = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo Rw() {
        return this.bKW;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.bKW = tbRichTextLinkButtonInfo;
    }

    public void cN(boolean z) {
        this.bKZ = z;
    }

    public boolean Rx() {
        return this.bKZ;
    }
}
