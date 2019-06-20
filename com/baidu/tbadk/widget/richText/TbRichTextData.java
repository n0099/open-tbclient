package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder cKN;
    private TbRichTextImageInfo cKO;
    private ArrayList<b> cKP;
    private TbRichTextTextInfo cKQ;
    private TbRichTextEmotionInfo cKR;
    private f cKS;
    private TbRichTextLinkImageInfo cKT;
    private TbRichTextLinkButtonInfo cKU;
    private TbRichTextMemeInfo cKV;
    private int cKW;
    private boolean cKX;
    private TbRichTextVoiceInfo cbj;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.cKN = null;
        this.cKO = null;
        this.cKP = null;
        this.cbj = null;
        this.cKQ = null;
        this.cKX = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.cKN = null;
        this.cKO = null;
        this.cKP = null;
        this.cbj = null;
        this.cKQ = null;
        this.cKX = false;
        this.mType = i;
        this.cKQ = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> axF() {
        if (this.cKP == null) {
            this.cKP = new ArrayList<>();
        }
        return this.cKP;
    }

    public void at(int i, int i2) {
        if (this.cKP != null) {
            Iterator<b> it = this.cKP.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.cKN == null) {
                this.cKN = new SpannableStringBuilder("");
            }
            this.cKN.append(charSequence);
            this.cKQ.charLength = this.cKN.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.cKN = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo axG() {
        if (this.mType != 8) {
            return null;
        }
        return this.cKO;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.cKO = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder axH() {
        return this.cKN;
    }

    public TbRichTextVoiceInfo axI() {
        if (this.mType == 512 || this.mType == 768) {
            return this.cbj;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.cbj = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.cKN != null) {
                return this.cKN.toString();
            }
        } else if (this.mType == 8) {
            if (this.cKO != null) {
                return this.cKO.axU();
            }
        } else if (this.mType == 17 && this.cKR != null) {
            return this.cKR.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo axJ() {
        if (this.mType != 1) {
            return null;
        }
        return this.cKQ;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.cKS = fVar;
        }
    }

    public f axK() {
        if (this.mType != 32) {
            return null;
        }
        return this.cKS;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.cKR = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.cKV = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo axL() {
        return this.cKR;
    }

    public TbRichTextMemeInfo axM() {
        return this.cKV;
    }

    public int axN() {
        return this.cKW;
    }

    public void ly(int i) {
        this.cKW = i;
    }

    public TbRichTextLinkImageInfo axO() {
        if (this.mType != 1280) {
            return null;
        }
        return this.cKT;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.cKT = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo axP() {
        return this.cKU;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.cKU = tbRichTextLinkButtonInfo;
    }

    public void fR(boolean z) {
        this.cKX = z;
    }

    public boolean axQ() {
        return this.cKX;
    }
}
