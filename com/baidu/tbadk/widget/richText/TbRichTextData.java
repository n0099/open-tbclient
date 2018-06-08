package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo axA;
    private SpannableStringBuilder bdM;
    private TbRichTextImageInfo bdN;
    private ArrayList<b> bdO;
    private TbRichTextTextInfo bdP;
    private TbRichTextEmotionInfo bdQ;
    private f bdR;
    private TbRichTextLinkImageInfo bdS;
    private TbRichTextLinkButtonInfo bdT;
    private TbRichTextMemeInfo bdU;
    private int bdV;
    private boolean bdW;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.bdM = null;
        this.bdN = null;
        this.bdO = null;
        this.axA = null;
        this.bdP = null;
        this.bdW = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.bdM = null;
        this.bdN = null;
        this.bdO = null;
        this.axA = null;
        this.bdP = null;
        this.bdW = false;
        this.mType = i;
        this.bdP = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> Nl() {
        if (this.bdO == null) {
            this.bdO = new ArrayList<>();
        }
        return this.bdO;
    }

    public void Q(int i, int i2) {
        if (this.bdO != null) {
            Iterator<b> it = this.bdO.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.bdM == null) {
                this.bdM = new SpannableStringBuilder("");
            }
            this.bdM.append(charSequence);
            this.bdP.charLength = this.bdM.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.bdM = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo Nm() {
        if (this.mType != 8) {
            return null;
        }
        return this.bdN;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.bdN = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder Nn() {
        return this.bdM;
    }

    public TbRichTextVoiceInfo No() {
        if (this.mType == 512 || this.mType == 768) {
            return this.axA;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.axA = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.bdM != null) {
                return this.bdM.toString();
            }
        } else if (this.mType == 8) {
            if (this.bdN != null) {
                return this.bdN.Nz();
            }
        } else if (this.mType == 17 && this.bdQ != null) {
            return this.bdQ.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo Np() {
        if (this.mType != 1) {
            return null;
        }
        return this.bdP;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.bdR = fVar;
        }
    }

    public f Nq() {
        if (this.mType != 32) {
            return null;
        }
        return this.bdR;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.bdQ = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.bdU = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo Nr() {
        return this.bdQ;
    }

    public TbRichTextMemeInfo Ns() {
        return this.bdU;
    }

    public int Nt() {
        return this.bdV;
    }

    public void fW(int i) {
        this.bdV = i;
    }

    public TbRichTextLinkImageInfo Nu() {
        if (this.mType != 1280) {
            return null;
        }
        return this.bdS;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.bdS = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo Nv() {
        return this.bdT;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.bdT = tbRichTextLinkButtonInfo;
    }

    public void ck(boolean z) {
        this.bdW = z;
    }

    public boolean Nw() {
        return this.bdW;
    }
}
