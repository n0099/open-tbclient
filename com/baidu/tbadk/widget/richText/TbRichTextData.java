package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder aMZ;
    private TbRichTextImageInfo aNa;
    private ArrayList<a> aNb;
    private TbRichTextVoiceInfo aNc;
    private TbRichTextTextInfo aNd;
    private TbRichTextEmotionInfo aNe;
    private e aNf;
    private TbRichTextLinkImageInfo aNg;
    private TbRichTextLinkButtonInfo aNh;
    private TbRichTextGraffitiInfo aNi;
    private int aNj;
    private boolean aNk;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.aMZ = null;
        this.aNa = null;
        this.aNb = null;
        this.aNc = null;
        this.aNd = null;
        this.aNk = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.aMZ = null;
        this.aNa = null;
        this.aNb = null;
        this.aNc = null;
        this.aNd = null;
        this.aNk = false;
        this.mType = i;
        this.aNd = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<a> HC() {
        if (this.aNb == null) {
            this.aNb = new ArrayList<>();
        }
        return this.aNb;
    }

    public void P(int i, int i2) {
        if (this.aNb != null) {
            Iterator<a> it = this.aNb.iterator();
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
        if (this.aNb != null) {
            Iterator<a> it = this.aNb.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aMZ == null) {
                this.aMZ = new SpannableStringBuilder("");
            }
            this.aMZ.append(charSequence);
            this.aNd.charLength = this.aMZ.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aMZ = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo HD() {
        if (this.mType != 8) {
            return null;
        }
        return this.aNa;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.aNa = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder HE() {
        return this.aMZ;
    }

    public void b(SpannableStringBuilder spannableStringBuilder) {
        if (this.aMZ != null) {
            this.aMZ.clear();
            this.aMZ.append((CharSequence) spannableStringBuilder);
        }
    }

    public TbRichTextVoiceInfo HF() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aNc;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.aNc = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aMZ != null) {
                return this.aMZ.toString();
            }
        } else if (this.mType == 8) {
            if (this.aNa != null) {
                return this.aNa.HR();
            }
        } else if (this.mType == 17 && this.aNe != null) {
            return this.aNe.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo HG() {
        if (this.mType != 1) {
            return null;
        }
        return this.aNd;
    }

    public void a(e eVar) {
        if (this.mType == 32) {
            this.aNf = eVar;
        }
    }

    public e HH() {
        if (this.mType != 32) {
            return null;
        }
        return this.aNf;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.aNe = tbRichTextEmotionInfo;
        }
    }

    public TbRichTextEmotionInfo HI() {
        return this.aNe;
    }

    public int HJ() {
        return this.aNj;
    }

    public void fr(int i) {
        this.aNj = i;
    }

    public TbRichTextLinkImageInfo HK() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aNg;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.aNg = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo HL() {
        return this.aNh;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.aNh = tbRichTextLinkButtonInfo;
    }

    public TbRichTextGraffitiInfo HM() {
        return this.aNi;
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo) {
        if (this.mType == 1536) {
            this.aNi = tbRichTextGraffitiInfo;
        }
    }

    public void cc(boolean z) {
        this.aNk = z;
    }

    public boolean HN() {
        return this.aNk;
    }
}
