package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder fZl;
    private TbRichTextImageInfo fZm;
    private ArrayList<d> fZn;
    private TbRichTextTextInfo fZo;
    private TbRichTextEmotionInfo fZp;
    private i fZq;
    private TbRichTextLinkImageInfo fZr;
    private TbRichTextLinkButtonInfo fZs;
    private TbRichTextMemeInfo fZt;
    private int fZu;
    private boolean fZv;
    private TbRichTextVoiceInfo fnv;
    private int iconType;
    private TbRichTextEvaluateItemInfo mEvaluateItemInfo;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.fZl = null;
        this.fZm = null;
        this.fZn = null;
        this.fnv = null;
        this.fZo = null;
        this.fZv = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.fZl = null;
        this.fZm = null;
        this.fZn = null;
        this.fnv = null;
        this.fZo = null;
        this.fZv = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
        this.mType = i;
        this.fZo = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<d> bLc() {
        if (this.fZn == null) {
            this.fZn = new ArrayList<>();
        }
        return this.fZn;
    }

    public void bt(int i, int i2) {
        if (this.fZn != null) {
            Iterator<d> it = this.fZn.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void q(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.fZl == null) {
                this.fZl = new SpannableStringBuilder("");
            }
            this.fZl.append(charSequence);
            this.fZo.charLength = this.fZl.length();
        }
    }

    public void r(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.fZl == null) {
                this.fZl = new SpannableStringBuilder("");
            }
            this.fZl.replace(0, 0, charSequence);
            this.fZo.charLength = this.fZl.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.fZl = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo bLd() {
        if (this.mType != 8) {
            return null;
        }
        return this.fZm;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.fZm = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder bLe() {
        return this.fZl;
    }

    public TbRichTextVoiceInfo bLf() {
        if (this.mType == 512 || this.mType == 768) {
            return this.fnv;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.fnv = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.fZl != null) {
                return this.fZl.toString();
            }
        } else if (this.mType == 8) {
            if (this.fZm != null) {
                return this.fZm.bLq();
            }
        } else if (this.mType == 17 && this.fZp != null) {
            return this.fZp.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo bLg() {
        if (this.mType != 1) {
            return null;
        }
        return this.fZo;
    }

    public void a(i iVar) {
        if (this.mType == 32) {
            this.fZq = iVar;
        }
    }

    public i bLh() {
        if (this.mType != 32) {
            return null;
        }
        return this.fZq;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.fZp = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.fZt = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo bLi() {
        return this.fZp;
    }

    public TbRichTextMemeInfo bLj() {
        return this.fZt;
    }

    public int bLk() {
        return this.fZu;
    }

    public void tL(int i) {
        this.fZu = i;
    }

    public TbRichTextLinkImageInfo bLl() {
        if (this.mType != 1280) {
            return null;
        }
        return this.fZr;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.fZr = tbRichTextLinkImageInfo;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.fZs = tbRichTextLinkButtonInfo;
    }

    public void a(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        if (this.mType == 1281) {
            this.mEvaluateItemInfo = tbRichTextEvaluateItemInfo;
        }
    }

    public TbRichTextEvaluateItemInfo getEvaluateItemInfo() {
        return this.mEvaluateItemInfo;
    }

    public void lL(boolean z) {
        this.fZv = z;
    }

    public boolean bLm() {
        return this.fZv;
    }

    public int getIconType() {
        return this.iconType;
    }
}
