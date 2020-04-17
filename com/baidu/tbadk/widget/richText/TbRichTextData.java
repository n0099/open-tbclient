package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo dIL;
    private SpannableStringBuilder eoR;
    private TbRichTextImageInfo eoS;
    private ArrayList<d> eoT;
    private TbRichTextTextInfo eoU;
    private TbRichTextEmotionInfo eoV;
    private i eoW;
    private TbRichTextLinkImageInfo eoX;
    private TbRichTextLinkButtonInfo eoY;
    private TbRichTextMemeInfo eoZ;
    private int epa;
    private boolean epb;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.eoR = null;
        this.eoS = null;
        this.eoT = null;
        this.dIL = null;
        this.eoU = null;
        this.epb = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.eoR = null;
        this.eoS = null;
        this.eoT = null;
        this.dIL = null;
        this.eoU = null;
        this.epb = false;
        this.mType = i;
        this.eoU = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<d> bcm() {
        if (this.eoT == null) {
            this.eoT = new ArrayList<>();
        }
        return this.eoT;
    }

    public void aZ(int i, int i2) {
        if (this.eoT != null) {
            Iterator<d> it = this.eoT.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void j(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.eoR == null) {
                this.eoR = new SpannableStringBuilder("");
            }
            this.eoR.append(charSequence);
            this.eoU.charLength = this.eoR.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.eoR = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo bcn() {
        if (this.mType != 8) {
            return null;
        }
        return this.eoS;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.eoS = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder bco() {
        return this.eoR;
    }

    public TbRichTextVoiceInfo bcp() {
        if (this.mType == 512 || this.mType == 768) {
            return this.dIL;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.dIL = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.eoR != null) {
                return this.eoR.toString();
            }
        } else if (this.mType == 8) {
            if (this.eoS != null) {
                return this.eoS.bcA();
            }
        } else if (this.mType == 17 && this.eoV != null) {
            return this.eoV.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo bcq() {
        if (this.mType != 1) {
            return null;
        }
        return this.eoU;
    }

    public void a(i iVar) {
        if (this.mType == 32) {
            this.eoW = iVar;
        }
    }

    public i bcr() {
        if (this.mType != 32) {
            return null;
        }
        return this.eoW;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.eoV = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.eoZ = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo bcs() {
        return this.eoV;
    }

    public TbRichTextMemeInfo bct() {
        return this.eoZ;
    }

    public int bcu() {
        return this.epa;
    }

    public void nH(int i) {
        this.epa = i;
    }

    public TbRichTextLinkImageInfo bcv() {
        if (this.mType != 1280) {
            return null;
        }
        return this.eoX;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.eoX = tbRichTextLinkImageInfo;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.eoY = tbRichTextLinkButtonInfo;
    }

    public void il(boolean z) {
        this.epb = z;
    }

    public boolean bcw() {
        return this.epb;
    }
}
