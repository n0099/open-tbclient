package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder cKM;
    private TbRichTextImageInfo cKN;
    private ArrayList<b> cKO;
    private TbRichTextTextInfo cKP;
    private TbRichTextEmotionInfo cKQ;
    private f cKR;
    private TbRichTextLinkImageInfo cKS;
    private TbRichTextLinkButtonInfo cKT;
    private TbRichTextMemeInfo cKU;
    private int cKV;
    private boolean cKW;
    private TbRichTextVoiceInfo cbi;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.cKM = null;
        this.cKN = null;
        this.cKO = null;
        this.cbi = null;
        this.cKP = null;
        this.cKW = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.cKM = null;
        this.cKN = null;
        this.cKO = null;
        this.cbi = null;
        this.cKP = null;
        this.cKW = false;
        this.mType = i;
        this.cKP = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> axE() {
        if (this.cKO == null) {
            this.cKO = new ArrayList<>();
        }
        return this.cKO;
    }

    public void at(int i, int i2) {
        if (this.cKO != null) {
            Iterator<b> it = this.cKO.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.cKM == null) {
                this.cKM = new SpannableStringBuilder("");
            }
            this.cKM.append(charSequence);
            this.cKP.charLength = this.cKM.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.cKM = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo axF() {
        if (this.mType != 8) {
            return null;
        }
        return this.cKN;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.cKN = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder axG() {
        return this.cKM;
    }

    public TbRichTextVoiceInfo axH() {
        if (this.mType == 512 || this.mType == 768) {
            return this.cbi;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.cbi = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.cKM != null) {
                return this.cKM.toString();
            }
        } else if (this.mType == 8) {
            if (this.cKN != null) {
                return this.cKN.axT();
            }
        } else if (this.mType == 17 && this.cKQ != null) {
            return this.cKQ.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo axI() {
        if (this.mType != 1) {
            return null;
        }
        return this.cKP;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.cKR = fVar;
        }
    }

    public f axJ() {
        if (this.mType != 32) {
            return null;
        }
        return this.cKR;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.cKQ = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.cKU = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo axK() {
        return this.cKQ;
    }

    public TbRichTextMemeInfo axL() {
        return this.cKU;
    }

    public int axM() {
        return this.cKV;
    }

    public void ly(int i) {
        this.cKV = i;
    }

    public TbRichTextLinkImageInfo axN() {
        if (this.mType != 1280) {
            return null;
        }
        return this.cKS;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.cKS = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo axO() {
        return this.cKT;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.cKT = tbRichTextLinkButtonInfo;
    }

    public void fR(boolean z) {
        this.cKW = z;
    }

    public boolean axP() {
        return this.cKW;
    }
}
