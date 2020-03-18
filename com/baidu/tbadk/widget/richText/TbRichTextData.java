package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder dOX;
    private TbRichTextImageInfo dOY;
    private ArrayList<d> dOZ;
    private TbRichTextTextInfo dPa;
    private TbRichTextEmotionInfo dPb;
    private i dPc;
    private TbRichTextLinkImageInfo dPd;
    private TbRichTextLinkButtonInfo dPe;
    private TbRichTextMemeInfo dPf;
    private int dPg;
    private boolean dPh;
    private TbRichTextVoiceInfo diS;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.dOX = null;
        this.dOY = null;
        this.dOZ = null;
        this.diS = null;
        this.dPa = null;
        this.dPh = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.dOX = null;
        this.dOY = null;
        this.dOZ = null;
        this.diS = null;
        this.dPa = null;
        this.dPh = false;
        this.mType = i;
        this.dPa = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<d> aUc() {
        if (this.dOZ == null) {
            this.dOZ = new ArrayList<>();
        }
        return this.dOZ;
    }

    public void aV(int i, int i2) {
        if (this.dOZ != null) {
            Iterator<d> it = this.dOZ.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void j(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.dOX == null) {
                this.dOX = new SpannableStringBuilder("");
            }
            this.dOX.append(charSequence);
            this.dPa.charLength = this.dOX.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.dOX = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo aUd() {
        if (this.mType != 8) {
            return null;
        }
        return this.dOY;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.dOY = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder aUe() {
        return this.dOX;
    }

    public TbRichTextVoiceInfo aUf() {
        if (this.mType == 512 || this.mType == 768) {
            return this.diS;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.diS = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.dOX != null) {
                return this.dOX.toString();
            }
        } else if (this.mType == 8) {
            if (this.dOY != null) {
                return this.dOY.aUq();
            }
        } else if (this.mType == 17 && this.dPb != null) {
            return this.dPb.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo aUg() {
        if (this.mType != 1) {
            return null;
        }
        return this.dPa;
    }

    public void a(i iVar) {
        if (this.mType == 32) {
            this.dPc = iVar;
        }
    }

    public i aUh() {
        if (this.mType != 32) {
            return null;
        }
        return this.dPc;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.dPb = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.dPf = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo aUi() {
        return this.dPb;
    }

    public TbRichTextMemeInfo aUj() {
        return this.dPf;
    }

    public int aUk() {
        return this.dPg;
    }

    public void nv(int i) {
        this.dPg = i;
    }

    public TbRichTextLinkImageInfo aUl() {
        if (this.mType != 1280) {
            return null;
        }
        return this.dPd;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.dPd = tbRichTextLinkImageInfo;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.dPe = tbRichTextLinkButtonInfo;
    }

    public void hn(boolean z) {
        this.dPh = z;
    }

    public boolean aUm() {
        return this.dPh;
    }
}
