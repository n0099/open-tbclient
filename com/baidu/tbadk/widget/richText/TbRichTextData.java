package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextEmotionInfo cWA;
    private f cWB;
    private TbRichTextLinkImageInfo cWC;
    private TbRichTextLinkButtonInfo cWD;
    private TbRichTextMemeInfo cWE;
    private int cWF;
    private boolean cWG;
    private SpannableStringBuilder cWw;
    private TbRichTextImageInfo cWx;
    private ArrayList<b> cWy;
    private TbRichTextTextInfo cWz;
    private TbRichTextVoiceInfo crA;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.cWw = null;
        this.cWx = null;
        this.cWy = null;
        this.crA = null;
        this.cWz = null;
        this.cWG = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.cWw = null;
        this.cWx = null;
        this.cWy = null;
        this.crA = null;
        this.cWz = null;
        this.cWG = false;
        this.mType = i;
        this.cWz = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> azo() {
        if (this.cWy == null) {
            this.cWy = new ArrayList<>();
        }
        return this.cWy;
    }

    public void ay(int i, int i2) {
        if (this.cWy != null) {
            Iterator<b> it = this.cWy.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void i(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.cWw == null) {
                this.cWw = new SpannableStringBuilder("");
            }
            this.cWw.append(charSequence);
            this.cWz.charLength = this.cWw.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.cWw = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo azp() {
        if (this.mType != 8) {
            return null;
        }
        return this.cWx;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.cWx = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder azq() {
        return this.cWw;
    }

    public TbRichTextVoiceInfo azr() {
        if (this.mType == 512 || this.mType == 768) {
            return this.crA;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.crA = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.cWw != null) {
                return this.cWw.toString();
            }
        } else if (this.mType == 8) {
            if (this.cWx != null) {
                return this.cWx.azD();
            }
        } else if (this.mType == 17 && this.cWA != null) {
            return this.cWA.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo azs() {
        if (this.mType != 1) {
            return null;
        }
        return this.cWz;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.cWB = fVar;
        }
    }

    public f azt() {
        if (this.mType != 32) {
            return null;
        }
        return this.cWB;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.cWA = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.cWE = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo azu() {
        return this.cWA;
    }

    public TbRichTextMemeInfo azv() {
        return this.cWE;
    }

    public int azw() {
        return this.cWF;
    }

    public void kO(int i) {
        this.cWF = i;
    }

    public TbRichTextLinkImageInfo azx() {
        if (this.mType != 1280) {
            return null;
        }
        return this.cWC;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.cWC = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo azy() {
        return this.cWD;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.cWD = tbRichTextLinkButtonInfo;
    }

    public void fN(boolean z) {
        this.cWG = z;
    }

    public boolean azz() {
        return this.cWG;
    }
}
