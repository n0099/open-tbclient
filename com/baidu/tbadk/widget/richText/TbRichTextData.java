package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo dXe;
    private SpannableStringBuilder eDI;
    private TbRichTextImageInfo eDJ;
    private ArrayList<d> eDK;
    private TbRichTextTextInfo eDL;
    private TbRichTextEmotionInfo eDM;
    private i eDN;
    private TbRichTextLinkImageInfo eDO;
    private TbRichTextLinkButtonInfo eDP;
    private TbRichTextMemeInfo eDQ;
    private int eDR;
    private boolean eDS;
    private int iconType;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.eDI = null;
        this.eDJ = null;
        this.eDK = null;
        this.dXe = null;
        this.eDL = null;
        this.eDS = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.eDI = null;
        this.eDJ = null;
        this.eDK = null;
        this.dXe = null;
        this.eDL = null;
        this.eDS = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
        this.mType = i;
        this.eDL = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<d> bix() {
        if (this.eDK == null) {
            this.eDK = new ArrayList<>();
        }
        return this.eDK;
    }

    public void bd(int i, int i2) {
        if (this.eDK != null) {
            Iterator<d> it = this.eDK.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void j(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.eDI == null) {
                this.eDI = new SpannableStringBuilder("");
            }
            this.eDI.append(charSequence);
            this.eDL.charLength = this.eDI.length();
        }
    }

    public void k(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.eDI == null) {
                this.eDI = new SpannableStringBuilder("");
            }
            this.eDI.replace(0, 0, charSequence);
            this.eDL.charLength = this.eDI.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.eDI = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo biy() {
        if (this.mType != 8) {
            return null;
        }
        return this.eDJ;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.eDJ = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder biz() {
        return this.eDI;
    }

    public TbRichTextVoiceInfo biA() {
        if (this.mType == 512 || this.mType == 768) {
            return this.dXe;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.dXe = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.eDI != null) {
                return this.eDI.toString();
            }
        } else if (this.mType == 8) {
            if (this.eDJ != null) {
                return this.eDJ.biL();
            }
        } else if (this.mType == 17 && this.eDM != null) {
            return this.eDM.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo biB() {
        if (this.mType != 1) {
            return null;
        }
        return this.eDL;
    }

    public void a(i iVar) {
        if (this.mType == 32) {
            this.eDN = iVar;
        }
    }

    public i biC() {
        if (this.mType != 32) {
            return null;
        }
        return this.eDN;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.eDM = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.eDQ = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo biD() {
        return this.eDM;
    }

    public TbRichTextMemeInfo biE() {
        return this.eDQ;
    }

    public int biF() {
        return this.eDR;
    }

    public void om(int i) {
        this.eDR = i;
    }

    public TbRichTextLinkImageInfo biG() {
        if (this.mType != 1280) {
            return null;
        }
        return this.eDO;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.eDO = tbRichTextLinkImageInfo;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.eDP = tbRichTextLinkButtonInfo;
    }

    public void iI(boolean z) {
        this.eDS = z;
    }

    public boolean biH() {
        return this.eDS;
    }

    public int getIconType() {
        return this.iconType;
    }

    public void on(int i) {
        this.iconType = i;
    }
}
