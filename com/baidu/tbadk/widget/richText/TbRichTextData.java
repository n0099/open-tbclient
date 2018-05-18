package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder aVI;
    private TbRichTextImageInfo aVJ;
    private ArrayList<b> aVK;
    private TbRichTextTextInfo aVL;
    private TbRichTextEmotionInfo aVM;
    private f aVN;
    private TbRichTextLinkImageInfo aVO;
    private TbRichTextLinkButtonInfo aVP;
    private TbRichTextMemeInfo aVQ;
    private int aVR;
    private boolean aVS;
    private TbRichTextVoiceInfo apt;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.aVI = null;
        this.aVJ = null;
        this.aVK = null;
        this.apt = null;
        this.aVL = null;
        this.aVS = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.aVI = null;
        this.aVJ = null;
        this.aVK = null;
        this.apt = null;
        this.aVL = null;
        this.aVS = false;
        this.mType = i;
        this.aVL = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> JM() {
        if (this.aVK == null) {
            this.aVK = new ArrayList<>();
        }
        return this.aVK;
    }

    public void P(int i, int i2) {
        if (this.aVK != null) {
            Iterator<b> it = this.aVK.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aVI == null) {
                this.aVI = new SpannableStringBuilder("");
            }
            this.aVI.append(charSequence);
            this.aVL.charLength = this.aVI.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aVI = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo JN() {
        if (this.mType != 8) {
            return null;
        }
        return this.aVJ;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.aVJ = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder JO() {
        return this.aVI;
    }

    public TbRichTextVoiceInfo JP() {
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
            if (this.aVI != null) {
                return this.aVI.toString();
            }
        } else if (this.mType == 8) {
            if (this.aVJ != null) {
                return this.aVJ.Ka();
            }
        } else if (this.mType == 17 && this.aVM != null) {
            return this.aVM.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo JQ() {
        if (this.mType != 1) {
            return null;
        }
        return this.aVL;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.aVN = fVar;
        }
    }

    public f JR() {
        if (this.mType != 32) {
            return null;
        }
        return this.aVN;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.aVM = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.aVQ = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo JS() {
        return this.aVM;
    }

    public TbRichTextMemeInfo JT() {
        return this.aVQ;
    }

    public int JU() {
        return this.aVR;
    }

    public void fV(int i) {
        this.aVR = i;
    }

    public TbRichTextLinkImageInfo JV() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aVO;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.aVO = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo JW() {
        return this.aVP;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.aVP = tbRichTextLinkButtonInfo;
    }

    public void cf(boolean z) {
        this.aVS = z;
    }

    public boolean JX() {
        return this.aVS;
    }
}
