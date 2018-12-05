package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo aJV;
    private SpannableStringBuilder bqW;
    private TbRichTextImageInfo bqX;
    private ArrayList<b> bqY;
    private TbRichTextTextInfo bqZ;
    private TbRichTextEmotionInfo bra;
    private f brb;
    private TbRichTextLinkImageInfo brc;
    private TbRichTextLinkButtonInfo brd;
    private TbRichTextMemeInfo bre;
    private int brf;
    private boolean brg;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.bqW = null;
        this.bqX = null;
        this.bqY = null;
        this.aJV = null;
        this.bqZ = null;
        this.brg = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.bqW = null;
        this.bqX = null;
        this.bqY = null;
        this.aJV = null;
        this.bqZ = null;
        this.brg = false;
        this.mType = i;
        this.bqZ = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> Se() {
        if (this.bqY == null) {
            this.bqY = new ArrayList<>();
        }
        return this.bqY;
    }

    public void V(int i, int i2) {
        if (this.bqY != null) {
            Iterator<b> it = this.bqY.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.bqW == null) {
                this.bqW = new SpannableStringBuilder("");
            }
            this.bqW.append(charSequence);
            this.bqZ.charLength = this.bqW.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.bqW = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo Sf() {
        if (this.mType != 8) {
            return null;
        }
        return this.bqX;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.bqX = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder Sg() {
        return this.bqW;
    }

    public TbRichTextVoiceInfo Sh() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aJV;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.aJV = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.bqW != null) {
                return this.bqW.toString();
            }
        } else if (this.mType == 8) {
            if (this.bqX != null) {
                return this.bqX.Su();
            }
        } else if (this.mType == 17 && this.bra != null) {
            return this.bra.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo Si() {
        if (this.mType != 1) {
            return null;
        }
        return this.bqZ;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.brb = fVar;
        }
    }

    public f Sj() {
        if (this.mType != 32) {
            return null;
        }
        return this.brb;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.bra = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.bre = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo Sk() {
        return this.bra;
    }

    public TbRichTextMemeInfo Sl() {
        return this.bre;
    }

    public int Sm() {
        return this.brf;
    }

    public void gU(int i) {
        this.brf = i;
    }

    public TbRichTextLinkImageInfo Sn() {
        if (this.mType != 1280) {
            return null;
        }
        return this.brc;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.brc = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo So() {
        return this.brd;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.brd = tbRichTextLinkButtonInfo;
    }

    public void db(boolean z) {
        this.brg = z;
    }

    public boolean Sp() {
        return this.brg;
    }
}
