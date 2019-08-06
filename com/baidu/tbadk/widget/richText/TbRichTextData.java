package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder cMo;
    private TbRichTextImageInfo cMp;
    private ArrayList<b> cMq;
    private TbRichTextTextInfo cMr;
    private TbRichTextEmotionInfo cMs;
    private f cMt;
    private TbRichTextLinkImageInfo cMu;
    private TbRichTextLinkButtonInfo cMv;
    private TbRichTextMemeInfo cMw;
    private int cMx;
    private boolean cMy;
    private TbRichTextVoiceInfo cct;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.cMo = null;
        this.cMp = null;
        this.cMq = null;
        this.cct = null;
        this.cMr = null;
        this.cMy = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.cMo = null;
        this.cMp = null;
        this.cMq = null;
        this.cct = null;
        this.cMr = null;
        this.cMy = false;
        this.mType = i;
        this.cMr = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> ayT() {
        if (this.cMq == null) {
            this.cMq = new ArrayList<>();
        }
        return this.cMq;
    }

    public void ax(int i, int i2) {
        if (this.cMq != null) {
            Iterator<b> it = this.cMq.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void k(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.cMo == null) {
                this.cMo = new SpannableStringBuilder("");
            }
            this.cMo.append(charSequence);
            this.cMr.charLength = this.cMo.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.cMo = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo ayU() {
        if (this.mType != 8) {
            return null;
        }
        return this.cMp;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.cMp = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder ayV() {
        return this.cMo;
    }

    public TbRichTextVoiceInfo ayW() {
        if (this.mType == 512 || this.mType == 768) {
            return this.cct;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.cct = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.cMo != null) {
                return this.cMo.toString();
            }
        } else if (this.mType == 8) {
            if (this.cMp != null) {
                return this.cMp.azi();
            }
        } else if (this.mType == 17 && this.cMs != null) {
            return this.cMs.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo ayX() {
        if (this.mType != 1) {
            return null;
        }
        return this.cMr;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.cMt = fVar;
        }
    }

    public f ayY() {
        if (this.mType != 32) {
            return null;
        }
        return this.cMt;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.cMs = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.cMw = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo ayZ() {
        return this.cMs;
    }

    public TbRichTextMemeInfo aza() {
        return this.cMw;
    }

    public int azb() {
        return this.cMx;
    }

    public void lF(int i) {
        this.cMx = i;
    }

    public TbRichTextLinkImageInfo azc() {
        if (this.mType != 1280) {
            return null;
        }
        return this.cMu;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.cMu = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo azd() {
        return this.cMv;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.cMv = tbRichTextLinkButtonInfo;
    }

    public void fV(boolean z) {
        this.cMy = z;
    }

    public boolean aze() {
        return this.cMy;
    }
}
