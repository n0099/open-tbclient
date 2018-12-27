package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo aJX;
    private SpannableStringBuilder bqZ;
    private TbRichTextImageInfo bra;
    private ArrayList<b> brb;
    private TbRichTextTextInfo brc;
    private TbRichTextEmotionInfo brd;
    private f bre;
    private TbRichTextLinkImageInfo brf;
    private TbRichTextLinkButtonInfo brg;
    private TbRichTextMemeInfo brh;
    private int bri;
    private boolean brj;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.bqZ = null;
        this.bra = null;
        this.brb = null;
        this.aJX = null;
        this.brc = null;
        this.brj = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.bqZ = null;
        this.bra = null;
        this.brb = null;
        this.aJX = null;
        this.brc = null;
        this.brj = false;
        this.mType = i;
        this.brc = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> Sg() {
        if (this.brb == null) {
            this.brb = new ArrayList<>();
        }
        return this.brb;
    }

    public void V(int i, int i2) {
        if (this.brb != null) {
            Iterator<b> it = this.brb.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.bqZ == null) {
                this.bqZ = new SpannableStringBuilder("");
            }
            this.bqZ.append(charSequence);
            this.brc.charLength = this.bqZ.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.bqZ = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo Sh() {
        if (this.mType != 8) {
            return null;
        }
        return this.bra;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.bra = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder Si() {
        return this.bqZ;
    }

    public TbRichTextVoiceInfo Sj() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aJX;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.aJX = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.bqZ != null) {
                return this.bqZ.toString();
            }
        } else if (this.mType == 8) {
            if (this.bra != null) {
                return this.bra.Sw();
            }
        } else if (this.mType == 17 && this.brd != null) {
            return this.brd.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo Sk() {
        if (this.mType != 1) {
            return null;
        }
        return this.brc;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.bre = fVar;
        }
    }

    public f Sl() {
        if (this.mType != 32) {
            return null;
        }
        return this.bre;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.brd = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.brh = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo Sm() {
        return this.brd;
    }

    public TbRichTextMemeInfo Sn() {
        return this.brh;
    }

    public int So() {
        return this.bri;
    }

    public void gV(int i) {
        this.bri = i;
    }

    public TbRichTextLinkImageInfo Sp() {
        if (this.mType != 1280) {
            return null;
        }
        return this.brf;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.brf = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo Sq() {
        return this.brg;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.brg = tbRichTextLinkButtonInfo;
    }

    public void db(boolean z) {
        this.brj = z;
    }

    public boolean Sr() {
        return this.brj;
    }
}
