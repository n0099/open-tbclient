package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder bKS;
    private TbRichTextImageInfo bKT;
    private ArrayList<b> bKU;
    private TbRichTextTextInfo bKV;
    private TbRichTextEmotionInfo bKW;
    private f bKX;
    private TbRichTextLinkImageInfo bKY;
    private TbRichTextLinkButtonInfo bKZ;
    private TbRichTextMemeInfo bLa;
    private int bLb;
    private boolean bLc;
    private TbRichTextVoiceInfo bec;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.bKS = null;
        this.bKT = null;
        this.bKU = null;
        this.bec = null;
        this.bKV = null;
        this.bLc = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.bKS = null;
        this.bKT = null;
        this.bKU = null;
        this.bec = null;
        this.bKV = null;
        this.bLc = false;
        this.mType = i;
        this.bKV = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> Rn() {
        if (this.bKU == null) {
            this.bKU = new ArrayList<>();
        }
        return this.bKU;
    }

    public void aT(int i, int i2) {
        if (this.bKU != null) {
            Iterator<b> it = this.bKU.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.bKS == null) {
                this.bKS = new SpannableStringBuilder("");
            }
            this.bKS.append(charSequence);
            this.bKV.charLength = this.bKS.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.bKS = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo Ro() {
        if (this.mType != 8) {
            return null;
        }
        return this.bKT;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.bKT = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder Rp() {
        return this.bKS;
    }

    public TbRichTextVoiceInfo Rq() {
        if (this.mType == 512 || this.mType == 768) {
            return this.bec;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.bec = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.bKS != null) {
                return this.bKS.toString();
            }
        } else if (this.mType == 8) {
            if (this.bKT != null) {
                return this.bKT.RC();
            }
        } else if (this.mType == 17 && this.bKW != null) {
            return this.bKW.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo Rr() {
        if (this.mType != 1) {
            return null;
        }
        return this.bKV;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.bKX = fVar;
        }
    }

    public f Rs() {
        if (this.mType != 32) {
            return null;
        }
        return this.bKX;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.bKW = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.bLa = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo Rt() {
        return this.bKW;
    }

    public TbRichTextMemeInfo Ru() {
        return this.bLa;
    }

    public int Rv() {
        return this.bLb;
    }

    public void iU(int i) {
        this.bLb = i;
    }

    public TbRichTextLinkImageInfo Rw() {
        if (this.mType != 1280) {
            return null;
        }
        return this.bKY;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.bKY = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo Rx() {
        return this.bKZ;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.bKZ = tbRichTextLinkButtonInfo;
    }

    public void cN(boolean z) {
        this.bLc = z;
    }

    public boolean Ry() {
        return this.bLc;
    }
}
