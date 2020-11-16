package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo eWp;
    private SpannableStringBuilder fHV;
    private TbRichTextImageInfo fHW;
    private ArrayList<d> fHX;
    private TbRichTextTextInfo fHY;
    private TbRichTextEmotionInfo fHZ;
    private i fIa;
    private TbRichTextLinkImageInfo fIb;
    private TbRichTextLinkButtonInfo fIc;
    private TbRichTextMemeInfo fId;
    private int fIe;
    private boolean fIf;
    private TbRichTextEvaluateItemInfo fIg;
    private int iconType;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.fHV = null;
        this.fHW = null;
        this.fHX = null;
        this.eWp = null;
        this.fHY = null;
        this.fIf = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.fHV = null;
        this.fHW = null;
        this.fHX = null;
        this.eWp = null;
        this.fHY = null;
        this.fIf = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
        this.mType = i;
        this.fHY = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<d> bFg() {
        if (this.fHX == null) {
            this.fHX = new ArrayList<>();
        }
        return this.fHX;
    }

    public void bt(int i, int i2) {
        if (this.fHX != null) {
            Iterator<d> it = this.fHX.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void p(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.fHV == null) {
                this.fHV = new SpannableStringBuilder("");
            }
            this.fHV.append(charSequence);
            this.fHY.charLength = this.fHV.length();
        }
    }

    public void q(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.fHV == null) {
                this.fHV = new SpannableStringBuilder("");
            }
            this.fHV.replace(0, 0, charSequence);
            this.fHY.charLength = this.fHV.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.fHV = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo bFh() {
        if (this.mType != 8) {
            return null;
        }
        return this.fHW;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.fHW = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder bFi() {
        return this.fHV;
    }

    public TbRichTextVoiceInfo bFj() {
        if (this.mType == 512 || this.mType == 768) {
            return this.eWp;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.eWp = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.fHV != null) {
                return this.fHV.toString();
            }
        } else if (this.mType == 8) {
            if (this.fHW != null) {
                return this.fHW.bFx();
            }
        } else if (this.mType == 17 && this.fHZ != null) {
            return this.fHZ.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo bFk() {
        if (this.mType != 1) {
            return null;
        }
        return this.fHY;
    }

    public void a(i iVar) {
        if (this.mType == 32) {
            this.fIa = iVar;
        }
    }

    public i bFl() {
        if (this.mType != 32) {
            return null;
        }
        return this.fIa;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.fHZ = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.fId = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo bFm() {
        return this.fHZ;
    }

    public TbRichTextMemeInfo bFn() {
        return this.fId;
    }

    public int bFo() {
        return this.fIe;
    }

    public void sX(int i) {
        this.fIe = i;
    }

    public TbRichTextLinkImageInfo bFp() {
        if (this.mType != 1280) {
            return null;
        }
        return this.fIb;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.fIb = tbRichTextLinkImageInfo;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.fIc = tbRichTextLinkButtonInfo;
    }

    public void a(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        if (this.mType == 1281) {
            this.fIg = tbRichTextEvaluateItemInfo;
        }
    }

    public TbRichTextEvaluateItemInfo bFq() {
        return this.fIg;
    }

    public void kV(boolean z) {
        this.fIf = z;
    }

    public boolean bFr() {
        return this.fIf;
    }

    public int getIconType() {
        return this.iconType;
    }
}
