package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private ArrayList<a> aPA;
    private TbRichTextTextInfo aPB;
    private TbRichTextEmotionInfo aPC;
    private e aPD;
    private TbRichTextLinkImageInfo aPE;
    private TbRichTextLinkButtonInfo aPF;
    private TbRichTextGraffitiInfo aPG;
    private TbRichTextMemeInfo aPH;
    private int aPI;
    private boolean aPJ;
    private SpannableStringBuilder aPy;
    private TbRichTextImageInfo aPz;
    private TbRichTextVoiceInfo anN;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.aPy = null;
        this.aPz = null;
        this.aPA = null;
        this.anN = null;
        this.aPB = null;
        this.aPJ = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.aPy = null;
        this.aPz = null;
        this.aPA = null;
        this.anN = null;
        this.aPB = null;
        this.aPJ = false;
        this.mType = i;
        this.aPB = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<a> Il() {
        if (this.aPA == null) {
            this.aPA = new ArrayList<>();
        }
        return this.aPA;
    }

    public void P(int i, int i2) {
        if (this.aPA != null) {
            Iterator<a> it = this.aPA.iterator();
            while (it.hasNext()) {
                a next = it.next();
                Rect bounds = next.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    next.R(0, i2);
                }
            }
        }
    }

    public void Q(int i, int i2) {
        if (this.aPA != null) {
            Iterator<a> it = this.aPA.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aPy == null) {
                this.aPy = new SpannableStringBuilder("");
            }
            this.aPy.append(charSequence);
            this.aPB.charLength = this.aPy.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aPy = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo Im() {
        if (this.mType != 8) {
            return null;
        }
        return this.aPz;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.aPz = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder In() {
        return this.aPy;
    }

    public void b(SpannableStringBuilder spannableStringBuilder) {
        if (this.aPy != null) {
            this.aPy.clear();
            this.aPy.append((CharSequence) spannableStringBuilder);
        }
    }

    public TbRichTextVoiceInfo Io() {
        if (this.mType == 512 || this.mType == 768) {
            return this.anN;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.anN = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aPy != null) {
                return this.aPy.toString();
            }
        } else if (this.mType == 8) {
            if (this.aPz != null) {
                return this.aPz.IB();
            }
        } else if (this.mType == 17 && this.aPC != null) {
            return this.aPC.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo Ip() {
        if (this.mType != 1) {
            return null;
        }
        return this.aPB;
    }

    public void a(e eVar) {
        if (this.mType == 32) {
            this.aPD = eVar;
        }
    }

    public e Iq() {
        if (this.mType != 32) {
            return null;
        }
        return this.aPD;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.aPC = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.aPH = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo Ir() {
        return this.aPC;
    }

    public TbRichTextMemeInfo Is() {
        return this.aPH;
    }

    public int It() {
        return this.aPI;
    }

    public void fw(int i) {
        this.aPI = i;
    }

    public TbRichTextLinkImageInfo Iu() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aPE;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.aPE = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo Iv() {
        return this.aPF;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.aPF = tbRichTextLinkButtonInfo;
    }

    public TbRichTextGraffitiInfo Iw() {
        return this.aPG;
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo) {
        if (this.mType == 1536) {
            this.aPG = tbRichTextGraffitiInfo;
        }
    }

    public void ch(boolean z) {
        this.aPJ = z;
    }

    public boolean Ix() {
        return this.aPJ;
    }
}
