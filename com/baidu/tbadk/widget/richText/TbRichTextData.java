package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder cMh;
    private TbRichTextImageInfo cMi;
    private ArrayList<b> cMj;
    private TbRichTextTextInfo cMk;
    private TbRichTextEmotionInfo cMl;
    private f cMm;
    private TbRichTextLinkImageInfo cMn;
    private TbRichTextLinkButtonInfo cMo;
    private TbRichTextMemeInfo cMp;
    private int cMq;
    private boolean cMr;
    private TbRichTextVoiceInfo ccl;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.cMh = null;
        this.cMi = null;
        this.cMj = null;
        this.ccl = null;
        this.cMk = null;
        this.cMr = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.cMh = null;
        this.cMi = null;
        this.cMj = null;
        this.ccl = null;
        this.cMk = null;
        this.cMr = false;
        this.mType = i;
        this.cMk = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> ayR() {
        if (this.cMj == null) {
            this.cMj = new ArrayList<>();
        }
        return this.cMj;
    }

    public void ax(int i, int i2) {
        if (this.cMj != null) {
            Iterator<b> it = this.cMj.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void k(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.cMh == null) {
                this.cMh = new SpannableStringBuilder("");
            }
            this.cMh.append(charSequence);
            this.cMk.charLength = this.cMh.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.cMh = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo ayS() {
        if (this.mType != 8) {
            return null;
        }
        return this.cMi;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.cMi = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder ayT() {
        return this.cMh;
    }

    public TbRichTextVoiceInfo ayU() {
        if (this.mType == 512 || this.mType == 768) {
            return this.ccl;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.ccl = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.cMh != null) {
                return this.cMh.toString();
            }
        } else if (this.mType == 8) {
            if (this.cMi != null) {
                return this.cMi.azg();
            }
        } else if (this.mType == 17 && this.cMl != null) {
            return this.cMl.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo ayV() {
        if (this.mType != 1) {
            return null;
        }
        return this.cMk;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.cMm = fVar;
        }
    }

    public f ayW() {
        if (this.mType != 32) {
            return null;
        }
        return this.cMm;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.cMl = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.cMp = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo ayX() {
        return this.cMl;
    }

    public TbRichTextMemeInfo ayY() {
        return this.cMp;
    }

    public int ayZ() {
        return this.cMq;
    }

    public void lE(int i) {
        this.cMq = i;
    }

    public TbRichTextLinkImageInfo aza() {
        if (this.mType != 1280) {
            return null;
        }
        return this.cMn;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.cMn = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo azb() {
        return this.cMo;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.cMo = tbRichTextLinkButtonInfo;
    }

    public void fV(boolean z) {
        this.cMr = z;
    }

    public boolean azc() {
        return this.cMr;
    }
}
