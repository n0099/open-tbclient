package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo aye;
    private SpannableStringBuilder bfm;
    private TbRichTextImageInfo bfn;
    private ArrayList<b> bfo;
    private TbRichTextTextInfo bfp;
    private TbRichTextEmotionInfo bfq;
    private f bfr;
    private TbRichTextLinkImageInfo bfs;
    private TbRichTextLinkButtonInfo bft;
    private TbRichTextMemeInfo bfu;
    private int bfv;
    private boolean bfw;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.bfm = null;
        this.bfn = null;
        this.bfo = null;
        this.aye = null;
        this.bfp = null;
        this.bfw = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.bfm = null;
        this.bfn = null;
        this.bfo = null;
        this.aye = null;
        this.bfp = null;
        this.bfw = false;
        this.mType = i;
        this.bfp = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> NC() {
        if (this.bfo == null) {
            this.bfo = new ArrayList<>();
        }
        return this.bfo;
    }

    public void R(int i, int i2) {
        if (this.bfo != null) {
            Iterator<b> it = this.bfo.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.bfm == null) {
                this.bfm = new SpannableStringBuilder("");
            }
            this.bfm.append(charSequence);
            this.bfp.charLength = this.bfm.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.bfm = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo ND() {
        if (this.mType != 8) {
            return null;
        }
        return this.bfn;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.bfn = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder NE() {
        return this.bfm;
    }

    public TbRichTextVoiceInfo NF() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aye;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.aye = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.bfm != null) {
                return this.bfm.toString();
            }
        } else if (this.mType == 8) {
            if (this.bfn != null) {
                return this.bfn.NS();
            }
        } else if (this.mType == 17 && this.bfq != null) {
            return this.bfq.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo NG() {
        if (this.mType != 1) {
            return null;
        }
        return this.bfp;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.bfr = fVar;
        }
    }

    public f NH() {
        if (this.mType != 32) {
            return null;
        }
        return this.bfr;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.bfq = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.bfu = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo NI() {
        return this.bfq;
    }

    public TbRichTextMemeInfo NJ() {
        return this.bfu;
    }

    public int NK() {
        return this.bfv;
    }

    public void fZ(int i) {
        this.bfv = i;
    }

    public TbRichTextLinkImageInfo NL() {
        if (this.mType != 1280) {
            return null;
        }
        return this.bfs;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.bfs = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo NM() {
        return this.bft;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.bft = tbRichTextLinkButtonInfo;
    }

    public void cn(boolean z) {
        this.bfw = z;
    }

    public boolean NN() {
        return this.bfw;
    }
}
