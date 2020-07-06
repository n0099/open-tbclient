package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder eNS;
    private TbRichTextImageInfo eNT;
    private ArrayList<d> eNU;
    private TbRichTextTextInfo eNV;
    private TbRichTextEmotionInfo eNW;
    private j eNX;
    private TbRichTextLinkImageInfo eNY;
    private TbRichTextLinkButtonInfo eNZ;
    private TbRichTextMemeInfo eOa;
    private int eOb;
    private boolean eOc;
    private TbRichTextEvaluateItemInfo eOd;
    private TbRichTextVoiceInfo eeA;
    private int iconType;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.eNS = null;
        this.eNT = null;
        this.eNU = null;
        this.eeA = null;
        this.eNV = null;
        this.eOc = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.eNS = null;
        this.eNT = null;
        this.eNU = null;
        this.eeA = null;
        this.eNV = null;
        this.eOc = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
        this.mType = i;
        this.eNV = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<d> bkU() {
        if (this.eNU == null) {
            this.eNU = new ArrayList<>();
        }
        return this.eNU;
    }

    public void bh(int i, int i2) {
        if (this.eNU != null) {
            Iterator<d> it = this.eNU.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void n(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.eNS == null) {
                this.eNS = new SpannableStringBuilder("");
            }
            this.eNS.append(charSequence);
            this.eNV.charLength = this.eNS.length();
        }
    }

    public void o(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.eNS == null) {
                this.eNS = new SpannableStringBuilder("");
            }
            this.eNS.replace(0, 0, charSequence);
            this.eNV.charLength = this.eNS.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.eNS = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo bkV() {
        if (this.mType != 8) {
            return null;
        }
        return this.eNT;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.eNT = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder bkW() {
        return this.eNS;
    }

    public TbRichTextVoiceInfo bkX() {
        if (this.mType == 512 || this.mType == 768) {
            return this.eeA;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.eeA = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.eNS != null) {
                return this.eNS.toString();
            }
        } else if (this.mType == 8) {
            if (this.eNT != null) {
                return this.eNT.blk();
            }
        } else if (this.mType == 17 && this.eNW != null) {
            return this.eNW.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo bkY() {
        if (this.mType != 1) {
            return null;
        }
        return this.eNV;
    }

    public void a(j jVar) {
        if (this.mType == 32) {
            this.eNX = jVar;
        }
    }

    public j bkZ() {
        if (this.mType != 32) {
            return null;
        }
        return this.eNX;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.eNW = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.eOa = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo bla() {
        return this.eNW;
    }

    public TbRichTextMemeInfo blb() {
        return this.eOa;
    }

    public int blc() {
        return this.eOb;
    }

    public void oK(int i) {
        this.eOb = i;
    }

    public TbRichTextLinkImageInfo bld() {
        if (this.mType != 1280) {
            return null;
        }
        return this.eNY;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.eNY = tbRichTextLinkImageInfo;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.eNZ = tbRichTextLinkButtonInfo;
    }

    public void a(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        if (this.mType == 1281) {
            this.eOd = tbRichTextEvaluateItemInfo;
        }
    }

    public TbRichTextEvaluateItemInfo ble() {
        return this.eOd;
    }

    public void iU(boolean z) {
        this.eOc = z;
    }

    public boolean blf() {
        return this.eOc;
    }

    public int getIconType() {
        return this.iconType;
    }

    public void oL(int i) {
        this.iconType = i;
    }
}
