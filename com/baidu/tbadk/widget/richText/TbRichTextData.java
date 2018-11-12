package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo aGv;
    private TbRichTextImageInfo bnA;
    private ArrayList<b> bnB;
    private TbRichTextTextInfo bnC;
    private TbRichTextEmotionInfo bnD;
    private f bnE;
    private TbRichTextLinkImageInfo bnF;
    private TbRichTextLinkButtonInfo bnG;
    private TbRichTextMemeInfo bnH;
    private int bnI;
    private boolean bnJ;
    private SpannableStringBuilder bnz;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.bnz = null;
        this.bnA = null;
        this.bnB = null;
        this.aGv = null;
        this.bnC = null;
        this.bnJ = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.bnz = null;
        this.bnA = null;
        this.bnB = null;
        this.aGv = null;
        this.bnC = null;
        this.bnJ = false;
        this.mType = i;
        this.bnC = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> QY() {
        if (this.bnB == null) {
            this.bnB = new ArrayList<>();
        }
        return this.bnB;
    }

    public void U(int i, int i2) {
        if (this.bnB != null) {
            Iterator<b> it = this.bnB.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.bnz == null) {
                this.bnz = new SpannableStringBuilder("");
            }
            this.bnz.append(charSequence);
            this.bnC.charLength = this.bnz.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.bnz = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo QZ() {
        if (this.mType != 8) {
            return null;
        }
        return this.bnA;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.bnA = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder Ra() {
        return this.bnz;
    }

    public TbRichTextVoiceInfo Rb() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aGv;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.aGv = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.bnz != null) {
                return this.bnz.toString();
            }
        } else if (this.mType == 8) {
            if (this.bnA != null) {
                return this.bnA.Ro();
            }
        } else if (this.mType == 17 && this.bnD != null) {
            return this.bnD.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo Rc() {
        if (this.mType != 1) {
            return null;
        }
        return this.bnC;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.bnE = fVar;
        }
    }

    public f Rd() {
        if (this.mType != 32) {
            return null;
        }
        return this.bnE;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.bnD = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.bnH = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo Re() {
        return this.bnD;
    }

    public TbRichTextMemeInfo Rf() {
        return this.bnH;
    }

    public int Rg() {
        return this.bnI;
    }

    public void gG(int i) {
        this.bnI = i;
    }

    public TbRichTextLinkImageInfo Rh() {
        if (this.mType != 1280) {
            return null;
        }
        return this.bnF;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.bnF = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo Ri() {
        return this.bnG;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.bnG = tbRichTextLinkButtonInfo;
    }

    public void da(boolean z) {
        this.bnJ = z;
    }

    public boolean Rj() {
        return this.bnJ;
    }
}
