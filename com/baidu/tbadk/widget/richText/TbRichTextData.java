package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo dXe;
    private TbRichTextTextInfo eDA;
    private TbRichTextEmotionInfo eDB;
    private i eDC;
    private TbRichTextLinkImageInfo eDD;
    private TbRichTextLinkButtonInfo eDE;
    private TbRichTextMemeInfo eDF;
    private int eDG;
    private boolean eDH;
    private SpannableStringBuilder eDx;
    private TbRichTextImageInfo eDy;
    private ArrayList<d> eDz;
    private int iconType;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.eDx = null;
        this.eDy = null;
        this.eDz = null;
        this.dXe = null;
        this.eDA = null;
        this.eDH = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.eDx = null;
        this.eDy = null;
        this.eDz = null;
        this.dXe = null;
        this.eDA = null;
        this.eDH = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
        this.mType = i;
        this.eDA = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<d> biv() {
        if (this.eDz == null) {
            this.eDz = new ArrayList<>();
        }
        return this.eDz;
    }

    public void bd(int i, int i2) {
        if (this.eDz != null) {
            Iterator<d> it = this.eDz.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void j(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.eDx == null) {
                this.eDx = new SpannableStringBuilder("");
            }
            this.eDx.append(charSequence);
            this.eDA.charLength = this.eDx.length();
        }
    }

    public void k(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.eDx == null) {
                this.eDx = new SpannableStringBuilder("");
            }
            this.eDx.replace(0, 0, charSequence);
            this.eDA.charLength = this.eDx.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.eDx = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo biw() {
        if (this.mType != 8) {
            return null;
        }
        return this.eDy;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.eDy = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder bix() {
        return this.eDx;
    }

    public TbRichTextVoiceInfo biy() {
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
            if (this.eDx != null) {
                return this.eDx.toString();
            }
        } else if (this.mType == 8) {
            if (this.eDy != null) {
                return this.eDy.biJ();
            }
        } else if (this.mType == 17 && this.eDB != null) {
            return this.eDB.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo biz() {
        if (this.mType != 1) {
            return null;
        }
        return this.eDA;
    }

    public void a(i iVar) {
        if (this.mType == 32) {
            this.eDC = iVar;
        }
    }

    public i biA() {
        if (this.mType != 32) {
            return null;
        }
        return this.eDC;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.eDB = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.eDF = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo biB() {
        return this.eDB;
    }

    public TbRichTextMemeInfo biC() {
        return this.eDF;
    }

    public int biD() {
        return this.eDG;
    }

    public void ok(int i) {
        this.eDG = i;
    }

    public TbRichTextLinkImageInfo biE() {
        if (this.mType != 1280) {
            return null;
        }
        return this.eDD;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.eDD = tbRichTextLinkImageInfo;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.eDE = tbRichTextLinkButtonInfo;
    }

    public void iI(boolean z) {
        this.eDH = z;
    }

    public boolean biF() {
        return this.eDH;
    }

    public int getIconType() {
        return this.iconType;
    }

    public void ol(int i) {
        this.iconType = i;
    }
}
