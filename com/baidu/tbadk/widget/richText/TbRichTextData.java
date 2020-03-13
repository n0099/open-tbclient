package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder dOG;
    private TbRichTextImageInfo dOH;
    private ArrayList<d> dOI;
    private TbRichTextTextInfo dOJ;
    private TbRichTextEmotionInfo dOK;
    private i dOL;
    private TbRichTextLinkImageInfo dOM;
    private TbRichTextLinkButtonInfo dON;
    private TbRichTextMemeInfo dOO;
    private int dOP;
    private boolean dOQ;
    private TbRichTextVoiceInfo diF;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.dOG = null;
        this.dOH = null;
        this.dOI = null;
        this.diF = null;
        this.dOJ = null;
        this.dOQ = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.dOG = null;
        this.dOH = null;
        this.dOI = null;
        this.diF = null;
        this.dOJ = null;
        this.dOQ = false;
        this.mType = i;
        this.dOJ = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<d> aTY() {
        if (this.dOI == null) {
            this.dOI = new ArrayList<>();
        }
        return this.dOI;
    }

    public void aU(int i, int i2) {
        if (this.dOI != null) {
            Iterator<d> it = this.dOI.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void j(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.dOG == null) {
                this.dOG = new SpannableStringBuilder("");
            }
            this.dOG.append(charSequence);
            this.dOJ.charLength = this.dOG.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.dOG = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo aTZ() {
        if (this.mType != 8) {
            return null;
        }
        return this.dOH;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.dOH = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder aUa() {
        return this.dOG;
    }

    public TbRichTextVoiceInfo aUb() {
        if (this.mType == 512 || this.mType == 768) {
            return this.diF;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.diF = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.dOG != null) {
                return this.dOG.toString();
            }
        } else if (this.mType == 8) {
            if (this.dOH != null) {
                return this.dOH.aUm();
            }
        } else if (this.mType == 17 && this.dOK != null) {
            return this.dOK.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo aUc() {
        if (this.mType != 1) {
            return null;
        }
        return this.dOJ;
    }

    public void a(i iVar) {
        if (this.mType == 32) {
            this.dOL = iVar;
        }
    }

    public i aUd() {
        if (this.mType != 32) {
            return null;
        }
        return this.dOL;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.dOK = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.dOO = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo aUe() {
        return this.dOK;
    }

    public TbRichTextMemeInfo aUf() {
        return this.dOO;
    }

    public int aUg() {
        return this.dOP;
    }

    public void nt(int i) {
        this.dOP = i;
    }

    public TbRichTextLinkImageInfo aUh() {
        if (this.mType != 1280) {
            return null;
        }
        return this.dOM;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.dOM = tbRichTextLinkImageInfo;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.dON = tbRichTextLinkButtonInfo;
    }

    public void hm(boolean z) {
        this.dOQ = z;
    }

    public boolean aUi() {
        return this.dOQ;
    }
}
