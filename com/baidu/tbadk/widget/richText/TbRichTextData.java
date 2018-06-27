package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo ayr;
    private SpannableStringBuilder bfc;
    private TbRichTextImageInfo bfd;
    private ArrayList<b> bfe;
    private TbRichTextTextInfo bff;
    private TbRichTextEmotionInfo bfg;
    private f bfh;
    private TbRichTextLinkImageInfo bfi;
    private TbRichTextLinkButtonInfo bfj;
    private TbRichTextMemeInfo bfk;
    private int bfl;
    private boolean bfm;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.bfc = null;
        this.bfd = null;
        this.bfe = null;
        this.ayr = null;
        this.bff = null;
        this.bfm = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.bfc = null;
        this.bfd = null;
        this.bfe = null;
        this.ayr = null;
        this.bff = null;
        this.bfm = false;
        this.mType = i;
        this.bff = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> NE() {
        if (this.bfe == null) {
            this.bfe = new ArrayList<>();
        }
        return this.bfe;
    }

    public void Q(int i, int i2) {
        if (this.bfe != null) {
            Iterator<b> it = this.bfe.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.bfc == null) {
                this.bfc = new SpannableStringBuilder("");
            }
            this.bfc.append(charSequence);
            this.bff.charLength = this.bfc.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.bfc = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo NF() {
        if (this.mType != 8) {
            return null;
        }
        return this.bfd;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.bfd = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder NG() {
        return this.bfc;
    }

    public TbRichTextVoiceInfo NH() {
        if (this.mType == 512 || this.mType == 768) {
            return this.ayr;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.ayr = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.bfc != null) {
                return this.bfc.toString();
            }
        } else if (this.mType == 8) {
            if (this.bfd != null) {
                return this.bfd.NS();
            }
        } else if (this.mType == 17 && this.bfg != null) {
            return this.bfg.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo NI() {
        if (this.mType != 1) {
            return null;
        }
        return this.bff;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.bfh = fVar;
        }
    }

    public f NJ() {
        if (this.mType != 32) {
            return null;
        }
        return this.bfh;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.bfg = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.bfk = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo NK() {
        return this.bfg;
    }

    public TbRichTextMemeInfo NL() {
        return this.bfk;
    }

    public int NM() {
        return this.bfl;
    }

    public void fX(int i) {
        this.bfl = i;
    }

    public TbRichTextLinkImageInfo NN() {
        if (this.mType != 1280) {
            return null;
        }
        return this.bfi;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.bfi = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo NO() {
        return this.bfj;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.bfj = tbRichTextLinkButtonInfo;
    }

    public void cn(boolean z) {
        this.bfm = z;
    }

    public boolean NP() {
        return this.bfm;
    }
}
