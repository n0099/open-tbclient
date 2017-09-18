package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextLinkButtonInfo aQA;
    private TbRichTextGraffitiInfo aQB;
    private TbRichTextMemeInfo aQC;
    private int aQD;
    private boolean aQE;
    private SpannableStringBuilder aQt;
    private TbRichTextImageInfo aQu;
    private ArrayList<a> aQv;
    private TbRichTextTextInfo aQw;
    private TbRichTextEmotionInfo aQx;
    private e aQy;
    private TbRichTextLinkImageInfo aQz;
    private TbRichTextVoiceInfo aoL;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.aQt = null;
        this.aQu = null;
        this.aQv = null;
        this.aoL = null;
        this.aQw = null;
        this.aQE = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.aQt = null;
        this.aQu = null;
        this.aQv = null;
        this.aoL = null;
        this.aQw = null;
        this.aQE = false;
        this.mType = i;
        this.aQw = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<a> IA() {
        if (this.aQv == null) {
            this.aQv = new ArrayList<>();
        }
        return this.aQv;
    }

    public void O(int i, int i2) {
        if (this.aQv != null) {
            Iterator<a> it = this.aQv.iterator();
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
        if (this.aQv != null) {
            Iterator<a> it = this.aQv.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aQt == null) {
                this.aQt = new SpannableStringBuilder("");
            }
            this.aQt.append(charSequence);
            this.aQw.charLength = this.aQt.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aQt = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo IB() {
        if (this.mType != 8) {
            return null;
        }
        return this.aQu;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.aQu = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder IC() {
        return this.aQt;
    }

    public void c(SpannableStringBuilder spannableStringBuilder) {
        if (this.aQt != null) {
            this.aQt.clear();
            this.aQt.append((CharSequence) spannableStringBuilder);
        }
    }

    public TbRichTextVoiceInfo ID() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aoL;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.aoL = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aQt != null) {
                return this.aQt.toString();
            }
        } else if (this.mType == 8) {
            if (this.aQu != null) {
                return this.aQu.IQ();
            }
        } else if (this.mType == 17 && this.aQx != null) {
            return this.aQx.mGifInfo.mSharpText;
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
        return this.aQw;
    }

    public void a(e eVar) {
        if (this.mType == 32) {
            this.aQy = eVar;
        }
    }

    public e IF() {
        if (this.mType != 32) {
            return null;
        }
        return this.aQy;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.aQx = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.aQC = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo IG() {
        return this.aQx;
    }

    public TbRichTextMemeInfo IH() {
        return this.aQC;
    }

    public int II() {
        return this.aQD;
    }

    public void fz(int i) {
        this.aQD = i;
    }

    public TbRichTextLinkImageInfo IJ() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aQz;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.aQz = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo IK() {
        return this.aQA;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.aQA = tbRichTextLinkButtonInfo;
    }

    public TbRichTextGraffitiInfo IL() {
        return this.aQB;
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo) {
        if (this.mType == 1536) {
            this.aQB = tbRichTextGraffitiInfo;
        }
    }

    public void ci(boolean z) {
        this.aQE = z;
    }

    public boolean IM() {
        return this.aQE;
    }
}
