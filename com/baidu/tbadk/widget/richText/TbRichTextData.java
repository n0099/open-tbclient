package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo euF;
    private SpannableStringBuilder feU;
    private TbRichTextImageInfo feV;
    private ArrayList<d> feW;
    private TbRichTextTextInfo feX;
    private TbRichTextEmotionInfo feY;
    private j feZ;
    private TbRichTextLinkImageInfo ffa;
    private TbRichTextLinkButtonInfo ffb;
    private TbRichTextMemeInfo ffc;
    private int ffd;
    private boolean ffe;
    private TbRichTextEvaluateItemInfo fff;
    private int iconType;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.feU = null;
        this.feV = null;
        this.feW = null;
        this.euF = null;
        this.feX = null;
        this.ffe = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.feU = null;
        this.feV = null;
        this.feW = null;
        this.euF = null;
        this.feX = null;
        this.ffe = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
        this.mType = i;
        this.feX = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<d> bxB() {
        if (this.feW == null) {
            this.feW = new ArrayList<>();
        }
        return this.feW;
    }

    public void bt(int i, int i2) {
        if (this.feW != null) {
            Iterator<d> it = this.feW.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void n(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.feU == null) {
                this.feU = new SpannableStringBuilder("");
            }
            this.feU.append(charSequence);
            this.feX.charLength = this.feU.length();
        }
    }

    public void o(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.feU == null) {
                this.feU = new SpannableStringBuilder("");
            }
            this.feU.replace(0, 0, charSequence);
            this.feX.charLength = this.feU.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.feU = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo bxC() {
        if (this.mType != 8) {
            return null;
        }
        return this.feV;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.feV = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder bxD() {
        return this.feU;
    }

    public TbRichTextVoiceInfo bxE() {
        if (this.mType == 512 || this.mType == 768) {
            return this.euF;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.euF = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.feU != null) {
                return this.feU.toString();
            }
        } else if (this.mType == 8) {
            if (this.feV != null) {
                return this.feV.bxS();
            }
        } else if (this.mType == 17 && this.feY != null) {
            return this.feY.mGifInfo.mSharpText;
        }
        return "";
    }

    /* loaded from: classes2.dex */
    public class TbRichTextTextInfo extends OrmObject {
        public boolean needRecompute;
        public int charLength = 0;
        public int viewWidth = 0;
        public int viewHeight = 0;

        public TbRichTextTextInfo() {
        }
    }

    public TbRichTextTextInfo bxF() {
        if (this.mType != 1) {
            return null;
        }
        return this.feX;
    }

    public void a(j jVar) {
        if (this.mType == 32) {
            this.feZ = jVar;
        }
    }

    public j bxG() {
        if (this.mType != 32) {
            return null;
        }
        return this.feZ;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.feY = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.ffc = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo bxH() {
        return this.feY;
    }

    public TbRichTextMemeInfo bxI() {
        return this.ffc;
    }

    public int bxJ() {
        return this.ffd;
    }

    public void rp(int i) {
        this.ffd = i;
    }

    public TbRichTextLinkImageInfo bxK() {
        if (this.mType != 1280) {
            return null;
        }
        return this.ffa;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.ffa = tbRichTextLinkImageInfo;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.ffb = tbRichTextLinkButtonInfo;
    }

    public void a(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        if (this.mType == 1281) {
            this.fff = tbRichTextEvaluateItemInfo;
        }
    }

    public TbRichTextEvaluateItemInfo bxL() {
        return this.fff;
    }

    public void jX(boolean z) {
        this.ffe = z;
    }

    public boolean bxM() {
        return this.ffe;
    }

    public int getIconType() {
        return this.iconType;
    }
}
