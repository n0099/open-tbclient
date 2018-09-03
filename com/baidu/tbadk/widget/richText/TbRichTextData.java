package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo ayb;
    private SpannableStringBuilder bfn;
    private TbRichTextImageInfo bfo;
    private ArrayList<b> bfp;
    private TbRichTextTextInfo bfq;
    private TbRichTextEmotionInfo bfr;
    private f bfs;
    private TbRichTextLinkImageInfo bft;
    private TbRichTextLinkButtonInfo bfu;
    private TbRichTextMemeInfo bfv;
    private int bfw;
    private boolean bfx;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.bfn = null;
        this.bfo = null;
        this.bfp = null;
        this.ayb = null;
        this.bfq = null;
        this.bfx = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.bfn = null;
        this.bfo = null;
        this.bfp = null;
        this.ayb = null;
        this.bfq = null;
        this.bfx = false;
        this.mType = i;
        this.bfq = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> NB() {
        if (this.bfp == null) {
            this.bfp = new ArrayList<>();
        }
        return this.bfp;
    }

    public void R(int i, int i2) {
        if (this.bfp != null) {
            Iterator<b> it = this.bfp.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.bfn == null) {
                this.bfn = new SpannableStringBuilder("");
            }
            this.bfn.append(charSequence);
            this.bfq.charLength = this.bfn.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.bfn = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo NC() {
        if (this.mType != 8) {
            return null;
        }
        return this.bfo;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.bfo = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder ND() {
        return this.bfn;
    }

    public TbRichTextVoiceInfo NE() {
        if (this.mType == 512 || this.mType == 768) {
            return this.ayb;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.ayb = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.bfn != null) {
                return this.bfn.toString();
            }
        } else if (this.mType == 8) {
            if (this.bfo != null) {
                return this.bfo.NR();
            }
        } else if (this.mType == 17 && this.bfr != null) {
            return this.bfr.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo NF() {
        if (this.mType != 1) {
            return null;
        }
        return this.bfq;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.bfs = fVar;
        }
    }

    public f NG() {
        if (this.mType != 32) {
            return null;
        }
        return this.bfs;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.bfr = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.bfv = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo NH() {
        return this.bfr;
    }

    public TbRichTextMemeInfo NI() {
        return this.bfv;
    }

    public int NJ() {
        return this.bfw;
    }

    public void fY(int i) {
        this.bfw = i;
    }

    public TbRichTextLinkImageInfo NK() {
        if (this.mType != 1280) {
            return null;
        }
        return this.bft;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.bft = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo NL() {
        return this.bfu;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.bfu = tbRichTextLinkButtonInfo;
    }

    public void co(boolean z) {
        this.bfx = z;
    }

    public boolean NM() {
        return this.bfx;
    }
}
