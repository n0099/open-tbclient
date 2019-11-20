package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder cVF;
    private TbRichTextImageInfo cVG;
    private ArrayList<b> cVH;
    private TbRichTextTextInfo cVI;
    private TbRichTextEmotionInfo cVJ;
    private f cVK;
    private TbRichTextLinkImageInfo cVL;
    private TbRichTextLinkButtonInfo cVM;
    private TbRichTextMemeInfo cVN;
    private int cVO;
    private boolean cVP;
    private TbRichTextVoiceInfo cqI;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.cVF = null;
        this.cVG = null;
        this.cVH = null;
        this.cqI = null;
        this.cVI = null;
        this.cVP = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.cVF = null;
        this.cVG = null;
        this.cVH = null;
        this.cqI = null;
        this.cVI = null;
        this.cVP = false;
        this.mType = i;
        this.cVI = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> azm() {
        if (this.cVH == null) {
            this.cVH = new ArrayList<>();
        }
        return this.cVH;
    }

    public void aw(int i, int i2) {
        if (this.cVH != null) {
            Iterator<b> it = this.cVH.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void i(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.cVF == null) {
                this.cVF = new SpannableStringBuilder("");
            }
            this.cVF.append(charSequence);
            this.cVI.charLength = this.cVF.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.cVF = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo azn() {
        if (this.mType != 8) {
            return null;
        }
        return this.cVG;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.cVG = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder azo() {
        return this.cVF;
    }

    public TbRichTextVoiceInfo azp() {
        if (this.mType == 512 || this.mType == 768) {
            return this.cqI;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.cqI = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.cVF != null) {
                return this.cVF.toString();
            }
        } else if (this.mType == 8) {
            if (this.cVG != null) {
                return this.cVG.azB();
            }
        } else if (this.mType == 17 && this.cVJ != null) {
            return this.cVJ.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo azq() {
        if (this.mType != 1) {
            return null;
        }
        return this.cVI;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.cVK = fVar;
        }
    }

    public f azr() {
        if (this.mType != 32) {
            return null;
        }
        return this.cVK;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.cVJ = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.cVN = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo azs() {
        return this.cVJ;
    }

    public TbRichTextMemeInfo azt() {
        return this.cVN;
    }

    public int azu() {
        return this.cVO;
    }

    public void kN(int i) {
        this.cVO = i;
    }

    public TbRichTextLinkImageInfo azv() {
        if (this.mType != 1280) {
            return null;
        }
        return this.cVL;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.cVL = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo azw() {
        return this.cVM;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.cVM = tbRichTextLinkButtonInfo;
    }

    public void fN(boolean z) {
        this.cVP = z;
    }

    public boolean azx() {
        return this.cVP;
    }
}
