package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo eIX;
    private SpannableStringBuilder fug;
    private TbRichTextImageInfo fuh;
    private ArrayList<d> fui;
    private TbRichTextTextInfo fuj;
    private TbRichTextEmotionInfo fuk;
    private j ful;
    private TbRichTextLinkImageInfo fum;
    private TbRichTextLinkButtonInfo fun;
    private TbRichTextMemeInfo fuo;
    private int fup;
    private boolean fuq;
    private TbRichTextEvaluateItemInfo fur;
    private int iconType;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.fug = null;
        this.fuh = null;
        this.fui = null;
        this.eIX = null;
        this.fuj = null;
        this.fuq = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.fug = null;
        this.fuh = null;
        this.fui = null;
        this.eIX = null;
        this.fuj = null;
        this.fuq = false;
        this.iconType = com.baidu.adp.newwidget.ImageView.b.TYPE_NONE;
        this.mType = i;
        this.fuj = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<d> bBv() {
        if (this.fui == null) {
            this.fui = new ArrayList<>();
        }
        return this.fui;
    }

    public void bs(int i, int i2) {
        if (this.fui != null) {
            Iterator<d> it = this.fui.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void o(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.fug == null) {
                this.fug = new SpannableStringBuilder("");
            }
            this.fug.append(charSequence);
            this.fuj.charLength = this.fug.length();
        }
    }

    public void p(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.fug == null) {
                this.fug = new SpannableStringBuilder("");
            }
            this.fug.replace(0, 0, charSequence);
            this.fuj.charLength = this.fug.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.fug = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo bBw() {
        if (this.mType != 8) {
            return null;
        }
        return this.fuh;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.fuh = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder bBx() {
        return this.fug;
    }

    public TbRichTextVoiceInfo bBy() {
        if (this.mType == 512 || this.mType == 768) {
            return this.eIX;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.eIX = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.fug != null) {
                return this.fug.toString();
            }
        } else if (this.mType == 8) {
            if (this.fuh != null) {
                return this.fuh.bBM();
            }
        } else if (this.mType == 17 && this.fuk != null) {
            return this.fuk.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo bBz() {
        if (this.mType != 1) {
            return null;
        }
        return this.fuj;
    }

    public void a(j jVar) {
        if (this.mType == 32) {
            this.ful = jVar;
        }
    }

    public j bBA() {
        if (this.mType != 32) {
            return null;
        }
        return this.ful;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.fuk = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.fuo = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo bBB() {
        return this.fuk;
    }

    public TbRichTextMemeInfo bBC() {
        return this.fuo;
    }

    public int bBD() {
        return this.fup;
    }

    public void se(int i) {
        this.fup = i;
    }

    public TbRichTextLinkImageInfo bBE() {
        if (this.mType != 1280) {
            return null;
        }
        return this.fum;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.fum = tbRichTextLinkImageInfo;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.fun = tbRichTextLinkButtonInfo;
    }

    public void a(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        if (this.mType == 1281) {
            this.fur = tbRichTextEvaluateItemInfo;
        }
    }

    public TbRichTextEvaluateItemInfo bBF() {
        return this.fur;
    }

    public void ky(boolean z) {
        this.fuq = z;
    }

    public boolean bBG() {
        return this.fuq;
    }

    public int getIconType() {
        return this.iconType;
    }
}
