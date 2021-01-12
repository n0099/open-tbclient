package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder fUE;
    private TbRichTextImageInfo fUF;
    private ArrayList<d> fUG;
    private TbRichTextTextInfo fUH;
    private TbRichTextEmotionInfo fUI;
    private i fUJ;
    private TbRichTextLinkImageInfo fUK;
    private TbRichTextLinkButtonInfo fUL;
    private TbRichTextMemeInfo fUM;
    private int fUN;
    private boolean fUO;
    private TbRichTextVoiceInfo fiM;
    private int iconType;
    private TbRichTextEvaluateItemInfo mEvaluateItemInfo;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.fUE = null;
        this.fUF = null;
        this.fUG = null;
        this.fiM = null;
        this.fUH = null;
        this.fUO = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.fUE = null;
        this.fUF = null;
        this.fUG = null;
        this.fiM = null;
        this.fUH = null;
        this.fUO = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
        this.mType = i;
        this.fUH = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<d> bHk() {
        if (this.fUG == null) {
            this.fUG = new ArrayList<>();
        }
        return this.fUG;
    }

    public void bt(int i, int i2) {
        if (this.fUG != null) {
            Iterator<d> it = this.fUG.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void q(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.fUE == null) {
                this.fUE = new SpannableStringBuilder("");
            }
            this.fUE.append(charSequence);
            this.fUH.charLength = this.fUE.length();
        }
    }

    public void r(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.fUE == null) {
                this.fUE = new SpannableStringBuilder("");
            }
            this.fUE.replace(0, 0, charSequence);
            this.fUH.charLength = this.fUE.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.fUE = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo bHl() {
        if (this.mType != 8) {
            return null;
        }
        return this.fUF;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.fUF = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder bHm() {
        return this.fUE;
    }

    public TbRichTextVoiceInfo bHn() {
        if (this.mType == 512 || this.mType == 768) {
            return this.fiM;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.fiM = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.fUE != null) {
                return this.fUE.toString();
            }
        } else if (this.mType == 8) {
            if (this.fUF != null) {
                return this.fUF.bHy();
            }
        } else if (this.mType == 17 && this.fUI != null) {
            return this.fUI.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo bHo() {
        if (this.mType != 1) {
            return null;
        }
        return this.fUH;
    }

    public void a(i iVar) {
        if (this.mType == 32) {
            this.fUJ = iVar;
        }
    }

    public i bHp() {
        if (this.mType != 32) {
            return null;
        }
        return this.fUJ;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.fUI = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.fUM = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo bHq() {
        return this.fUI;
    }

    public TbRichTextMemeInfo bHr() {
        return this.fUM;
    }

    public int bHs() {
        return this.fUN;
    }

    public void sf(int i) {
        this.fUN = i;
    }

    public TbRichTextLinkImageInfo bHt() {
        if (this.mType != 1280) {
            return null;
        }
        return this.fUK;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.fUK = tbRichTextLinkImageInfo;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.fUL = tbRichTextLinkButtonInfo;
    }

    public void a(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        if (this.mType == 1281) {
            this.mEvaluateItemInfo = tbRichTextEvaluateItemInfo;
        }
    }

    public TbRichTextEvaluateItemInfo getEvaluateItemInfo() {
        return this.mEvaluateItemInfo;
    }

    public void lH(boolean z) {
        this.fUO = z;
    }

    public boolean bHu() {
        return this.fUO;
    }

    public int getIconType() {
        return this.iconType;
    }
}
