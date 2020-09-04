package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo euJ;
    private SpannableStringBuilder feY;
    private TbRichTextImageInfo feZ;
    private ArrayList<d> ffa;
    private TbRichTextTextInfo ffb;
    private TbRichTextEmotionInfo ffc;
    private j ffd;
    private TbRichTextLinkImageInfo ffe;
    private TbRichTextLinkButtonInfo fff;
    private TbRichTextMemeInfo ffg;
    private int ffh;
    private boolean ffi;
    private TbRichTextEvaluateItemInfo ffj;
    private int iconType;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.feY = null;
        this.feZ = null;
        this.ffa = null;
        this.euJ = null;
        this.ffb = null;
        this.ffi = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.feY = null;
        this.feZ = null;
        this.ffa = null;
        this.euJ = null;
        this.ffb = null;
        this.ffi = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
        this.mType = i;
        this.ffb = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<d> bxC() {
        if (this.ffa == null) {
            this.ffa = new ArrayList<>();
        }
        return this.ffa;
    }

    public void bt(int i, int i2) {
        if (this.ffa != null) {
            Iterator<d> it = this.ffa.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void n(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.feY == null) {
                this.feY = new SpannableStringBuilder("");
            }
            this.feY.append(charSequence);
            this.ffb.charLength = this.feY.length();
        }
    }

    public void o(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.feY == null) {
                this.feY = new SpannableStringBuilder("");
            }
            this.feY.replace(0, 0, charSequence);
            this.ffb.charLength = this.feY.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.feY = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo bxD() {
        if (this.mType != 8) {
            return null;
        }
        return this.feZ;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.feZ = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder bxE() {
        return this.feY;
    }

    public TbRichTextVoiceInfo bxF() {
        if (this.mType == 512 || this.mType == 768) {
            return this.euJ;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.euJ = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.feY != null) {
                return this.feY.toString();
            }
        } else if (this.mType == 8) {
            if (this.feZ != null) {
                return this.feZ.bxT();
            }
        } else if (this.mType == 17 && this.ffc != null) {
            return this.ffc.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo bxG() {
        if (this.mType != 1) {
            return null;
        }
        return this.ffb;
    }

    public void a(j jVar) {
        if (this.mType == 32) {
            this.ffd = jVar;
        }
    }

    public j bxH() {
        if (this.mType != 32) {
            return null;
        }
        return this.ffd;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.ffc = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.ffg = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo bxI() {
        return this.ffc;
    }

    public TbRichTextMemeInfo bxJ() {
        return this.ffg;
    }

    public int bxK() {
        return this.ffh;
    }

    public void rp(int i) {
        this.ffh = i;
    }

    public TbRichTextLinkImageInfo bxL() {
        if (this.mType != 1280) {
            return null;
        }
        return this.ffe;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.ffe = tbRichTextLinkImageInfo;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.fff = tbRichTextLinkButtonInfo;
    }

    public void a(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        if (this.mType == 1281) {
            this.ffj = tbRichTextEvaluateItemInfo;
        }
    }

    public TbRichTextEvaluateItemInfo bxM() {
        return this.ffj;
    }

    public void jZ(boolean z) {
        this.ffi = z;
    }

    public boolean bxN() {
        return this.ffi;
    }

    public int getIconType() {
        return this.iconType;
    }
}
