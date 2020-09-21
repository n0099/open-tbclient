package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo ewN;
    private SpannableStringBuilder fhP;
    private TbRichTextImageInfo fhQ;
    private ArrayList<d> fhR;
    private TbRichTextTextInfo fhS;
    private TbRichTextEmotionInfo fhT;
    private j fhU;
    private TbRichTextLinkImageInfo fhV;
    private TbRichTextLinkButtonInfo fhW;
    private TbRichTextMemeInfo fhX;
    private int fhY;
    private boolean fhZ;
    private TbRichTextEvaluateItemInfo fia;
    private int iconType;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.fhP = null;
        this.fhQ = null;
        this.fhR = null;
        this.ewN = null;
        this.fhS = null;
        this.fhZ = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.fhP = null;
        this.fhQ = null;
        this.fhR = null;
        this.ewN = null;
        this.fhS = null;
        this.fhZ = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
        this.mType = i;
        this.fhS = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<d> byL() {
        if (this.fhR == null) {
            this.fhR = new ArrayList<>();
        }
        return this.fhR;
    }

    public void bt(int i, int i2) {
        if (this.fhR != null) {
            Iterator<d> it = this.fhR.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void n(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.fhP == null) {
                this.fhP = new SpannableStringBuilder("");
            }
            this.fhP.append(charSequence);
            this.fhS.charLength = this.fhP.length();
        }
    }

    public void o(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.fhP == null) {
                this.fhP = new SpannableStringBuilder("");
            }
            this.fhP.replace(0, 0, charSequence);
            this.fhS.charLength = this.fhP.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.fhP = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo byM() {
        if (this.mType != 8) {
            return null;
        }
        return this.fhQ;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.fhQ = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder byN() {
        return this.fhP;
    }

    public TbRichTextVoiceInfo byO() {
        if (this.mType == 512 || this.mType == 768) {
            return this.ewN;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.ewN = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.fhP != null) {
                return this.fhP.toString();
            }
        } else if (this.mType == 8) {
            if (this.fhQ != null) {
                return this.fhQ.bzc();
            }
        } else if (this.mType == 17 && this.fhT != null) {
            return this.fhT.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo byP() {
        if (this.mType != 1) {
            return null;
        }
        return this.fhS;
    }

    public void a(j jVar) {
        if (this.mType == 32) {
            this.fhU = jVar;
        }
    }

    public j byQ() {
        if (this.mType != 32) {
            return null;
        }
        return this.fhU;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.fhT = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.fhX = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo byR() {
        return this.fhT;
    }

    public TbRichTextMemeInfo byS() {
        return this.fhX;
    }

    public int byT() {
        return this.fhY;
    }

    public void rG(int i) {
        this.fhY = i;
    }

    public TbRichTextLinkImageInfo byU() {
        if (this.mType != 1280) {
            return null;
        }
        return this.fhV;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.fhV = tbRichTextLinkImageInfo;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.fhW = tbRichTextLinkButtonInfo;
    }

    public void a(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        if (this.mType == 1281) {
            this.fia = tbRichTextEvaluateItemInfo;
        }
    }

    public TbRichTextEvaluateItemInfo byV() {
        return this.fia;
    }

    public void ka(boolean z) {
        this.fhZ = z;
    }

    public boolean byW() {
        return this.fhZ;
    }

    public int getIconType() {
        return this.iconType;
    }
}
