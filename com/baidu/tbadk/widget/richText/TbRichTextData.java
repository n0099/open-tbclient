package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo eXi;
    private int fIA;
    private boolean fIB;
    private TbRichTextEvaluateItemInfo fIC;
    private SpannableStringBuilder fIr;
    private TbRichTextImageInfo fIs;
    private ArrayList<d> fIt;
    private TbRichTextTextInfo fIu;
    private TbRichTextEmotionInfo fIv;
    private j fIw;
    private TbRichTextLinkImageInfo fIx;
    private TbRichTextLinkButtonInfo fIy;
    private TbRichTextMemeInfo fIz;
    private int iconType;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.fIr = null;
        this.fIs = null;
        this.fIt = null;
        this.eXi = null;
        this.fIu = null;
        this.fIB = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.fIr = null;
        this.fIs = null;
        this.fIt = null;
        this.eXi = null;
        this.fIu = null;
        this.fIB = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
        this.mType = i;
        this.fIu = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<d> bFN() {
        if (this.fIt == null) {
            this.fIt = new ArrayList<>();
        }
        return this.fIt;
    }

    public void bt(int i, int i2) {
        if (this.fIt != null) {
            Iterator<d> it = this.fIt.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void o(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.fIr == null) {
                this.fIr = new SpannableStringBuilder("");
            }
            this.fIr.append(charSequence);
            this.fIu.charLength = this.fIr.length();
        }
    }

    public void p(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.fIr == null) {
                this.fIr = new SpannableStringBuilder("");
            }
            this.fIr.replace(0, 0, charSequence);
            this.fIu.charLength = this.fIr.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.fIr = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo bFO() {
        if (this.mType != 8) {
            return null;
        }
        return this.fIs;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.fIs = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder bFP() {
        return this.fIr;
    }

    public TbRichTextVoiceInfo bFQ() {
        if (this.mType == 512 || this.mType == 768) {
            return this.eXi;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.eXi = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.fIr != null) {
                return this.fIr.toString();
            }
        } else if (this.mType == 8) {
            if (this.fIs != null) {
                return this.fIs.bGe();
            }
        } else if (this.mType == 17 && this.fIv != null) {
            return this.fIv.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo bFR() {
        if (this.mType != 1) {
            return null;
        }
        return this.fIu;
    }

    public void a(j jVar) {
        if (this.mType == 32) {
            this.fIw = jVar;
        }
    }

    public j bFS() {
        if (this.mType != 32) {
            return null;
        }
        return this.fIw;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.fIv = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.fIz = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo bFT() {
        return this.fIv;
    }

    public TbRichTextMemeInfo bFU() {
        return this.fIz;
    }

    public int bFV() {
        return this.fIA;
    }

    public void sz(int i) {
        this.fIA = i;
    }

    public TbRichTextLinkImageInfo bFW() {
        if (this.mType != 1280) {
            return null;
        }
        return this.fIx;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.fIx = tbRichTextLinkImageInfo;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.fIy = tbRichTextLinkButtonInfo;
    }

    public void a(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        if (this.mType == 1281) {
            this.fIC = tbRichTextEvaluateItemInfo;
        }
    }

    public TbRichTextEvaluateItemInfo bFX() {
        return this.fIC;
    }

    public void kU(boolean z) {
        this.fIB = z;
    }

    public boolean bFY() {
        return this.fIB;
    }

    public int getIconType() {
        return this.iconType;
    }
}
