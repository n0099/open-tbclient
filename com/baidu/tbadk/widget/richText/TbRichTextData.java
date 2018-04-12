package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder aVH;
    private TbRichTextImageInfo aVI;
    private ArrayList<b> aVJ;
    private TbRichTextTextInfo aVK;
    private TbRichTextEmotionInfo aVL;
    private f aVM;
    private TbRichTextLinkImageInfo aVN;
    private TbRichTextLinkButtonInfo aVO;
    private TbRichTextMemeInfo aVP;
    private int aVQ;
    private boolean aVR;
    private TbRichTextVoiceInfo apt;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.aVH = null;
        this.aVI = null;
        this.aVJ = null;
        this.apt = null;
        this.aVK = null;
        this.aVR = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.aVH = null;
        this.aVI = null;
        this.aVJ = null;
        this.apt = null;
        this.aVK = null;
        this.aVR = false;
        this.mType = i;
        this.aVK = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> JO() {
        if (this.aVJ == null) {
            this.aVJ = new ArrayList<>();
        }
        return this.aVJ;
    }

    public void P(int i, int i2) {
        if (this.aVJ != null) {
            Iterator<b> it = this.aVJ.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aVH == null) {
                this.aVH = new SpannableStringBuilder("");
            }
            this.aVH.append(charSequence);
            this.aVK.charLength = this.aVH.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aVH = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo JP() {
        if (this.mType != 8) {
            return null;
        }
        return this.aVI;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.aVI = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder JQ() {
        return this.aVH;
    }

    public TbRichTextVoiceInfo JR() {
        if (this.mType == 512 || this.mType == 768) {
            return this.apt;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.apt = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aVH != null) {
                return this.aVH.toString();
            }
        } else if (this.mType == 8) {
            if (this.aVI != null) {
                return this.aVI.Kc();
            }
        } else if (this.mType == 17 && this.aVL != null) {
            return this.aVL.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo JS() {
        if (this.mType != 1) {
            return null;
        }
        return this.aVK;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.aVM = fVar;
        }
    }

    public f JT() {
        if (this.mType != 32) {
            return null;
        }
        return this.aVM;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.aVL = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.aVP = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo JU() {
        return this.aVL;
    }

    public TbRichTextMemeInfo JV() {
        return this.aVP;
    }

    public int JW() {
        return this.aVQ;
    }

    public void fV(int i) {
        this.aVQ = i;
    }

    public TbRichTextLinkImageInfo JX() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aVN;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.aVN = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo JY() {
        return this.aVO;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.aVO = tbRichTextLinkButtonInfo;
    }

    public void cf(boolean z) {
        this.aVR = z;
    }

    public boolean JZ() {
        return this.aVR;
    }
}
