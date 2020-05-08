package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo dIP;
    private SpannableStringBuilder eoW;
    private TbRichTextImageInfo eoX;
    private ArrayList<d> eoY;
    private TbRichTextTextInfo eoZ;
    private TbRichTextEmotionInfo epa;
    private i epb;
    private TbRichTextLinkImageInfo epc;
    private TbRichTextLinkButtonInfo epd;
    private TbRichTextMemeInfo epe;
    private int epf;
    private boolean epg;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.eoW = null;
        this.eoX = null;
        this.eoY = null;
        this.dIP = null;
        this.eoZ = null;
        this.epg = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.eoW = null;
        this.eoX = null;
        this.eoY = null;
        this.dIP = null;
        this.eoZ = null;
        this.epg = false;
        this.mType = i;
        this.eoZ = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<d> bck() {
        if (this.eoY == null) {
            this.eoY = new ArrayList<>();
        }
        return this.eoY;
    }

    public void aZ(int i, int i2) {
        if (this.eoY != null) {
            Iterator<d> it = this.eoY.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void j(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.eoW == null) {
                this.eoW = new SpannableStringBuilder("");
            }
            this.eoW.append(charSequence);
            this.eoZ.charLength = this.eoW.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.eoW = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo bcl() {
        if (this.mType != 8) {
            return null;
        }
        return this.eoX;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.eoX = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder bcm() {
        return this.eoW;
    }

    public TbRichTextVoiceInfo bcn() {
        if (this.mType == 512 || this.mType == 768) {
            return this.dIP;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.dIP = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.eoW != null) {
                return this.eoW.toString();
            }
        } else if (this.mType == 8) {
            if (this.eoX != null) {
                return this.eoX.bcy();
            }
        } else if (this.mType == 17 && this.epa != null) {
            return this.epa.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo bco() {
        if (this.mType != 1) {
            return null;
        }
        return this.eoZ;
    }

    public void a(i iVar) {
        if (this.mType == 32) {
            this.epb = iVar;
        }
    }

    public i bcp() {
        if (this.mType != 32) {
            return null;
        }
        return this.epb;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.epa = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.epe = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo bcq() {
        return this.epa;
    }

    public TbRichTextMemeInfo bcr() {
        return this.epe;
    }

    public int bcs() {
        return this.epf;
    }

    public void nH(int i) {
        this.epf = i;
    }

    public TbRichTextLinkImageInfo bct() {
        if (this.mType != 1280) {
            return null;
        }
        return this.epc;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.epc = tbRichTextLinkImageInfo;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.epd = tbRichTextLinkButtonInfo;
    }

    public void il(boolean z) {
        this.epg = z;
    }

    public boolean bcu() {
        return this.epg;
    }
}
