package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder eUn;
    private TbRichTextImageInfo eUo;
    private ArrayList<d> eUp;
    private TbRichTextTextInfo eUq;
    private TbRichTextEmotionInfo eUr;
    private j eUs;
    private TbRichTextLinkImageInfo eUt;
    private TbRichTextLinkButtonInfo eUu;
    private TbRichTextMemeInfo eUv;
    private int eUw;
    private boolean eUx;
    private TbRichTextEvaluateItemInfo eUy;
    private TbRichTextVoiceInfo ekK;
    private int iconType;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.eUn = null;
        this.eUo = null;
        this.eUp = null;
        this.ekK = null;
        this.eUq = null;
        this.eUx = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.eUn = null;
        this.eUo = null;
        this.eUp = null;
        this.ekK = null;
        this.eUq = null;
        this.eUx = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
        this.mType = i;
        this.eUq = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<d> boO() {
        if (this.eUp == null) {
            this.eUp = new ArrayList<>();
        }
        return this.eUp;
    }

    public void bk(int i, int i2) {
        if (this.eUp != null) {
            Iterator<d> it = this.eUp.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void n(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.eUn == null) {
                this.eUn = new SpannableStringBuilder("");
            }
            this.eUn.append(charSequence);
            this.eUq.charLength = this.eUn.length();
        }
    }

    public void o(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.eUn == null) {
                this.eUn = new SpannableStringBuilder("");
            }
            this.eUn.replace(0, 0, charSequence);
            this.eUq.charLength = this.eUn.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.eUn = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo boP() {
        if (this.mType != 8) {
            return null;
        }
        return this.eUo;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.eUo = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder boQ() {
        return this.eUn;
    }

    public TbRichTextVoiceInfo boR() {
        if (this.mType == 512 || this.mType == 768) {
            return this.ekK;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.ekK = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.eUn != null) {
                return this.eUn.toString();
            }
        } else if (this.mType == 8) {
            if (this.eUo != null) {
                return this.eUo.bpe();
            }
        } else if (this.mType == 17 && this.eUr != null) {
            return this.eUr.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo boS() {
        if (this.mType != 1) {
            return null;
        }
        return this.eUq;
    }

    public void a(j jVar) {
        if (this.mType == 32) {
            this.eUs = jVar;
        }
    }

    public j boT() {
        if (this.mType != 32) {
            return null;
        }
        return this.eUs;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.eUr = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.eUv = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo boU() {
        return this.eUr;
    }

    public TbRichTextMemeInfo boV() {
        return this.eUv;
    }

    public int boW() {
        return this.eUw;
    }

    public void pd(int i) {
        this.eUw = i;
    }

    public TbRichTextLinkImageInfo boX() {
        if (this.mType != 1280) {
            return null;
        }
        return this.eUt;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.eUt = tbRichTextLinkImageInfo;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.eUu = tbRichTextLinkButtonInfo;
    }

    public void a(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        if (this.mType == 1281) {
            this.eUy = tbRichTextEvaluateItemInfo;
        }
    }

    public TbRichTextEvaluateItemInfo boY() {
        return this.eUy;
    }

    public void jz(boolean z) {
        this.eUx = z;
    }

    public boolean boZ() {
        return this.eUx;
    }

    public int getIconType() {
        return this.iconType;
    }
}
