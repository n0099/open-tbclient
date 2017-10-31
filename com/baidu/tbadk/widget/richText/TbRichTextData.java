package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder aRI;
    private TbRichTextImageInfo aRJ;
    private ArrayList<b> aRK;
    private TbRichTextTextInfo aRL;
    private TbRichTextEmotionInfo aRM;
    private f aRN;
    private TbRichTextLinkImageInfo aRO;
    private TbRichTextLinkButtonInfo aRP;
    private TbRichTextMemeInfo aRQ;
    private int aRR;
    private boolean aRS;
    private TbRichTextVoiceInfo aob;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.aRI = null;
        this.aRJ = null;
        this.aRK = null;
        this.aob = null;
        this.aRL = null;
        this.aRS = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.aRI = null;
        this.aRJ = null;
        this.aRK = null;
        this.aob = null;
        this.aRL = null;
        this.aRS = false;
        this.mType = i;
        this.aRL = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> IN() {
        if (this.aRK == null) {
            this.aRK = new ArrayList<>();
        }
        return this.aRK;
    }

    public void S(int i, int i2) {
        if (this.aRK != null) {
            Iterator<b> it = this.aRK.iterator();
            while (it.hasNext()) {
                b next = it.next();
                Rect bounds = next.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    next.U(0, i2);
                }
            }
        }
    }

    public void T(int i, int i2) {
        if (this.aRK != null) {
            Iterator<b> it = this.aRK.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aRI == null) {
                this.aRI = new SpannableStringBuilder("");
            }
            this.aRI.append(charSequence);
            this.aRL.charLength = this.aRI.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aRI = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo IO() {
        if (this.mType != 8) {
            return null;
        }
        return this.aRJ;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.aRJ = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder IP() {
        return this.aRI;
    }

    public void c(SpannableStringBuilder spannableStringBuilder) {
        if (this.aRI != null) {
            this.aRI.clear();
            this.aRI.append((CharSequence) spannableStringBuilder);
        }
    }

    public TbRichTextVoiceInfo IQ() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aob;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.aob = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aRI != null) {
                return this.aRI.toString();
            }
        } else if (this.mType == 8) {
            if (this.aRJ != null) {
                return this.aRJ.Jc();
            }
        } else if (this.mType == 17 && this.aRM != null) {
            return this.aRM.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo IR() {
        if (this.mType != 1) {
            return null;
        }
        return this.aRL;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.aRN = fVar;
        }
    }

    public f IS() {
        if (this.mType != 32) {
            return null;
        }
        return this.aRN;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.aRM = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.aRQ = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo IT() {
        return this.aRM;
    }

    public TbRichTextMemeInfo IU() {
        return this.aRQ;
    }

    public int IV() {
        return this.aRR;
    }

    public void fV(int i) {
        this.aRR = i;
    }

    public TbRichTextLinkImageInfo IW() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aRO;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.aRO = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo IX() {
        return this.aRP;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.aRP = tbRichTextLinkButtonInfo;
    }

    public void cc(boolean z) {
        this.aRS = z;
    }

    public boolean IY() {
        return this.aRS;
    }
}
