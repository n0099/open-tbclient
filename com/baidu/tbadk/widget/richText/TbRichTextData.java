package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private e aRA;
    private TbRichTextLinkImageInfo aRB;
    private TbRichTextLinkButtonInfo aRC;
    private TbRichTextMemeInfo aRD;
    private int aRE;
    private boolean aRF;
    private SpannableStringBuilder aRv;
    private TbRichTextImageInfo aRw;
    private ArrayList<a> aRx;
    private TbRichTextTextInfo aRy;
    private TbRichTextEmotionInfo aRz;
    private TbRichTextVoiceInfo anS;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.aRv = null;
        this.aRw = null;
        this.aRx = null;
        this.anS = null;
        this.aRy = null;
        this.aRF = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.aRv = null;
        this.aRw = null;
        this.aRx = null;
        this.anS = null;
        this.aRy = null;
        this.aRF = false;
        this.mType = i;
        this.aRy = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<a> II() {
        if (this.aRx == null) {
            this.aRx = new ArrayList<>();
        }
        return this.aRx;
    }

    public void S(int i, int i2) {
        if (this.aRx != null) {
            Iterator<a> it = this.aRx.iterator();
            while (it.hasNext()) {
                a next = it.next();
                Rect bounds = next.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    next.U(0, i2);
                }
            }
        }
    }

    public void T(int i, int i2) {
        if (this.aRx != null) {
            Iterator<a> it = this.aRx.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aRv == null) {
                this.aRv = new SpannableStringBuilder("");
            }
            this.aRv.append(charSequence);
            this.aRy.charLength = this.aRv.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aRv = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo IJ() {
        if (this.mType != 8) {
            return null;
        }
        return this.aRw;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.aRw = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder IK() {
        return this.aRv;
    }

    public void c(SpannableStringBuilder spannableStringBuilder) {
        if (this.aRv != null) {
            this.aRv.clear();
            this.aRv.append((CharSequence) spannableStringBuilder);
        }
    }

    public TbRichTextVoiceInfo IL() {
        if (this.mType == 512 || this.mType == 768) {
            return this.anS;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.anS = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aRv != null) {
                return this.aRv.toString();
            }
        } else if (this.mType == 8) {
            if (this.aRw != null) {
                return this.aRw.IX();
            }
        } else if (this.mType == 17 && this.aRz != null) {
            return this.aRz.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo IM() {
        if (this.mType != 1) {
            return null;
        }
        return this.aRy;
    }

    public void a(e eVar) {
        if (this.mType == 32) {
            this.aRA = eVar;
        }
    }

    public e IN() {
        if (this.mType != 32) {
            return null;
        }
        return this.aRA;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.aRz = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.aRD = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo IO() {
        return this.aRz;
    }

    public TbRichTextMemeInfo IP() {
        return this.aRD;
    }

    public int IQ() {
        return this.aRE;
    }

    public void fN(int i) {
        this.aRE = i;
    }

    public TbRichTextLinkImageInfo IR() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aRB;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.aRB = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo IS() {
        return this.aRC;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.aRC = tbRichTextLinkButtonInfo;
    }

    public void ch(boolean z) {
        this.aRF = z;
    }

    public boolean IT() {
        return this.aRF;
    }
}
