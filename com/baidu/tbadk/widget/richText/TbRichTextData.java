package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo aFF;
    private SpannableStringBuilder bmN;
    private TbRichTextImageInfo bmO;
    private ArrayList<b> bmP;
    private TbRichTextTextInfo bmQ;
    private TbRichTextEmotionInfo bmR;
    private f bmS;
    private TbRichTextLinkImageInfo bmT;
    private TbRichTextLinkButtonInfo bmU;
    private TbRichTextMemeInfo bmV;
    private int bmW;
    private boolean bmX;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.bmN = null;
        this.bmO = null;
        this.bmP = null;
        this.aFF = null;
        this.bmQ = null;
        this.bmX = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.bmN = null;
        this.bmO = null;
        this.bmP = null;
        this.aFF = null;
        this.bmQ = null;
        this.bmX = false;
        this.mType = i;
        this.bmQ = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> QP() {
        if (this.bmP == null) {
            this.bmP = new ArrayList<>();
        }
        return this.bmP;
    }

    public void T(int i, int i2) {
        if (this.bmP != null) {
            Iterator<b> it = this.bmP.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.bmN == null) {
                this.bmN = new SpannableStringBuilder("");
            }
            this.bmN.append(charSequence);
            this.bmQ.charLength = this.bmN.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.bmN = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo QQ() {
        if (this.mType != 8) {
            return null;
        }
        return this.bmO;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.bmO = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder QR() {
        return this.bmN;
    }

    public TbRichTextVoiceInfo QS() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aFF;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.aFF = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.bmN != null) {
                return this.bmN.toString();
            }
        } else if (this.mType == 8) {
            if (this.bmO != null) {
                return this.bmO.Rf();
            }
        } else if (this.mType == 17 && this.bmR != null) {
            return this.bmR.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo QT() {
        if (this.mType != 1) {
            return null;
        }
        return this.bmQ;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.bmS = fVar;
        }
    }

    public f QU() {
        if (this.mType != 32) {
            return null;
        }
        return this.bmS;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.bmR = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.bmV = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo QV() {
        return this.bmR;
    }

    public TbRichTextMemeInfo QW() {
        return this.bmV;
    }

    public int QX() {
        return this.bmW;
    }

    public void gs(int i) {
        this.bmW = i;
    }

    public TbRichTextLinkImageInfo QY() {
        if (this.mType != 1280) {
            return null;
        }
        return this.bmT;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.bmT = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo QZ() {
        return this.bmU;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.bmU = tbRichTextLinkButtonInfo;
    }

    public void cJ(boolean z) {
        this.bmX = z;
    }

    public boolean Ra() {
        return this.bmX;
    }
}
