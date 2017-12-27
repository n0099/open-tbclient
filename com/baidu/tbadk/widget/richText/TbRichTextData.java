package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder bIH;
    private TbRichTextImageInfo bII;
    private ArrayList<b> bIJ;
    private TbRichTextTextInfo bIK;
    private TbRichTextEmotionInfo bIL;
    private f bIM;
    private TbRichTextLinkImageInfo bIN;
    private TbRichTextLinkButtonInfo bIO;
    private TbRichTextMemeInfo bIP;
    private int bIQ;
    private boolean bIR;
    private TbRichTextVoiceInfo bcn;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.bIH = null;
        this.bII = null;
        this.bIJ = null;
        this.bcn = null;
        this.bIK = null;
        this.bIR = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.bIH = null;
        this.bII = null;
        this.bIJ = null;
        this.bcn = null;
        this.bIK = null;
        this.bIR = false;
        this.mType = i;
        this.bIK = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> QS() {
        if (this.bIJ == null) {
            this.bIJ = new ArrayList<>();
        }
        return this.bIJ;
    }

    public void aT(int i, int i2) {
        if (this.bIJ != null) {
            Iterator<b> it = this.bIJ.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.bIH == null) {
                this.bIH = new SpannableStringBuilder("");
            }
            this.bIH.append(charSequence);
            this.bIK.charLength = this.bIH.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.bIH = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo QT() {
        if (this.mType != 8) {
            return null;
        }
        return this.bII;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.bII = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder QU() {
        return this.bIH;
    }

    public void c(SpannableStringBuilder spannableStringBuilder) {
        if (this.bIH != null) {
            this.bIH.clear();
            this.bIH.append((CharSequence) spannableStringBuilder);
        }
    }

    public TbRichTextVoiceInfo QV() {
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
            if (this.bIH != null) {
                return this.bIH.toString();
            }
        } else if (this.mType == 8) {
            if (this.bII != null) {
                return this.bII.Rh();
            }
        } else if (this.mType == 17 && this.bIL != null) {
            return this.bIL.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo QW() {
        if (this.mType != 1) {
            return null;
        }
        return this.bIK;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.bIM = fVar;
        }
    }

    public f QX() {
        if (this.mType != 32) {
            return null;
        }
        return this.bIM;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.bIL = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.bIP = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo QY() {
        return this.bIL;
    }

    public TbRichTextMemeInfo QZ() {
        return this.bIP;
    }

    public int Ra() {
        return this.bIQ;
    }

    public void jb(int i) {
        this.bIQ = i;
    }

    public TbRichTextLinkImageInfo Rb() {
        if (this.mType != 1280) {
            return null;
        }
        return this.bIN;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.bIN = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo Rc() {
        return this.bIO;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.bIO = tbRichTextLinkButtonInfo;
    }

    public void cK(boolean z) {
        this.bIR = z;
    }

    public boolean Rd() {
        return this.bIR;
    }
}
