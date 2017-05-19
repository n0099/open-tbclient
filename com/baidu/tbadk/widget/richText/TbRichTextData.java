package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder aNc;
    private TbRichTextImageInfo aNd;
    private ArrayList<a> aNe;
    private TbRichTextVoiceInfo aNf;
    private TbRichTextTextInfo aNg;
    private TbRichTextEmotionInfo aNh;
    private e aNi;
    private TbRichTextLinkImageInfo aNj;
    private TbRichTextLinkButtonInfo aNk;
    private TbRichTextGraffitiInfo aNl;
    private int aNm;
    private boolean aNn;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.aNc = null;
        this.aNd = null;
        this.aNe = null;
        this.aNf = null;
        this.aNg = null;
        this.aNn = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.aNc = null;
        this.aNd = null;
        this.aNe = null;
        this.aNf = null;
        this.aNg = null;
        this.aNn = false;
        this.mType = i;
        this.aNg = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<a> HH() {
        if (this.aNe == null) {
            this.aNe = new ArrayList<>();
        }
        return this.aNe;
    }

    public void Q(int i, int i2) {
        if (this.aNe != null) {
            Iterator<a> it = this.aNe.iterator();
            while (it.hasNext()) {
                a next = it.next();
                Rect bounds = next.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    next.S(0, i2);
                }
            }
        }
    }

    public void R(int i, int i2) {
        if (this.aNe != null) {
            Iterator<a> it = this.aNe.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aNc == null) {
                this.aNc = new SpannableStringBuilder("");
            }
            this.aNc.append(charSequence);
            this.aNg.charLength = this.aNc.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aNc = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo HI() {
        if (this.mType != 8) {
            return null;
        }
        return this.aNd;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.aNd = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder HJ() {
        return this.aNc;
    }

    public void b(SpannableStringBuilder spannableStringBuilder) {
        if (this.aNc != null) {
            this.aNc.clear();
            this.aNc.append((CharSequence) spannableStringBuilder);
        }
    }

    public TbRichTextVoiceInfo HK() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aNf;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.aNf = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aNc != null) {
                return this.aNc.toString();
            }
        } else if (this.mType == 8) {
            if (this.aNd != null) {
                return this.aNd.HW();
            }
        } else if (this.mType == 17 && this.aNh != null) {
            return this.aNh.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo HL() {
        if (this.mType != 1) {
            return null;
        }
        return this.aNg;
    }

    public void a(e eVar) {
        if (this.mType == 32) {
            this.aNi = eVar;
        }
    }

    public e HM() {
        if (this.mType != 32) {
            return null;
        }
        return this.aNi;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.aNh = tbRichTextEmotionInfo;
        }
    }

    public TbRichTextEmotionInfo HN() {
        return this.aNh;
    }

    public int HO() {
        return this.aNm;
    }

    public void fq(int i) {
        this.aNm = i;
    }

    public TbRichTextLinkImageInfo HP() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aNj;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.aNj = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo HQ() {
        return this.aNk;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.aNk = tbRichTextLinkButtonInfo;
    }

    public TbRichTextGraffitiInfo HR() {
        return this.aNl;
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo) {
        if (this.mType == 1536) {
            this.aNl = tbRichTextGraffitiInfo;
        }
    }

    public void cf(boolean z) {
        this.aNn = z;
    }

    public boolean HS() {
        return this.aNn;
    }
}
