package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextEmotionInfo aQA;
    private e aQB;
    private TbRichTextLinkImageInfo aQC;
    private TbRichTextLinkButtonInfo aQD;
    private TbRichTextGraffitiInfo aQE;
    private TbRichTextMemeInfo aQF;
    private int aQG;
    private boolean aQH;
    private SpannableStringBuilder aQw;
    private TbRichTextImageInfo aQx;
    private ArrayList<a> aQy;
    private TbRichTextTextInfo aQz;
    private TbRichTextVoiceInfo aoN;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.aQw = null;
        this.aQx = null;
        this.aQy = null;
        this.aoN = null;
        this.aQz = null;
        this.aQH = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.aQw = null;
        this.aQx = null;
        this.aQy = null;
        this.aoN = null;
        this.aQz = null;
        this.aQH = false;
        this.mType = i;
        this.aQz = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<a> IA() {
        if (this.aQy == null) {
            this.aQy = new ArrayList<>();
        }
        return this.aQy;
    }

    public void O(int i, int i2) {
        if (this.aQy != null) {
            Iterator<a> it = this.aQy.iterator();
            while (it.hasNext()) {
                a next = it.next();
                Rect bounds = next.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    next.Q(0, i2);
                }
            }
        }
    }

    public void P(int i, int i2) {
        if (this.aQy != null) {
            Iterator<a> it = this.aQy.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aQw == null) {
                this.aQw = new SpannableStringBuilder("");
            }
            this.aQw.append(charSequence);
            this.aQz.charLength = this.aQw.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aQw = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo IB() {
        if (this.mType != 8) {
            return null;
        }
        return this.aQx;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.aQx = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder IC() {
        return this.aQw;
    }

    public void c(SpannableStringBuilder spannableStringBuilder) {
        if (this.aQw != null) {
            this.aQw.clear();
            this.aQw.append((CharSequence) spannableStringBuilder);
        }
    }

    public TbRichTextVoiceInfo ID() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aoN;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.aoN = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aQw != null) {
                return this.aQw.toString();
            }
        } else if (this.mType == 8) {
            if (this.aQx != null) {
                return this.aQx.IQ();
            }
        } else if (this.mType == 17 && this.aQA != null) {
            return this.aQA.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo IE() {
        if (this.mType != 1) {
            return null;
        }
        return this.aQz;
    }

    public void a(e eVar) {
        if (this.mType == 32) {
            this.aQB = eVar;
        }
    }

    public e IF() {
        if (this.mType != 32) {
            return null;
        }
        return this.aQB;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.aQA = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.aQF = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo IG() {
        return this.aQA;
    }

    public TbRichTextMemeInfo IH() {
        return this.aQF;
    }

    public int II() {
        return this.aQG;
    }

    public void fz(int i) {
        this.aQG = i;
    }

    public TbRichTextLinkImageInfo IJ() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aQC;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.aQC = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo IK() {
        return this.aQD;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.aQD = tbRichTextLinkButtonInfo;
    }

    public TbRichTextGraffitiInfo IL() {
        return this.aQE;
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo) {
        if (this.mType == 1536) {
            this.aQE = tbRichTextGraffitiInfo;
        }
    }

    public void ci(boolean z) {
        this.aQH = z;
    }

    public boolean IM() {
        return this.aQH;
    }
}
