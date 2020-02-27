package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextMemeInfo dOA;
    private int dOB;
    private boolean dOC;
    private SpannableStringBuilder dOs;
    private TbRichTextImageInfo dOt;
    private ArrayList<d> dOu;
    private TbRichTextTextInfo dOv;
    private TbRichTextEmotionInfo dOw;
    private i dOx;
    private TbRichTextLinkImageInfo dOy;
    private TbRichTextLinkButtonInfo dOz;
    private TbRichTextVoiceInfo dip;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.dOs = null;
        this.dOt = null;
        this.dOu = null;
        this.dip = null;
        this.dOv = null;
        this.dOC = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.dOs = null;
        this.dOt = null;
        this.dOu = null;
        this.dip = null;
        this.dOv = null;
        this.dOC = false;
        this.mType = i;
        this.dOv = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<d> aTV() {
        if (this.dOu == null) {
            this.dOu = new ArrayList<>();
        }
        return this.dOu;
    }

    public void aU(int i, int i2) {
        if (this.dOu != null) {
            Iterator<d> it = this.dOu.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void j(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.dOs == null) {
                this.dOs = new SpannableStringBuilder("");
            }
            this.dOs.append(charSequence);
            this.dOv.charLength = this.dOs.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.dOs = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo aTW() {
        if (this.mType != 8) {
            return null;
        }
        return this.dOt;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.dOt = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder aTX() {
        return this.dOs;
    }

    public TbRichTextVoiceInfo aTY() {
        if (this.mType == 512 || this.mType == 768) {
            return this.dip;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.dip = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.dOs != null) {
                return this.dOs.toString();
            }
        } else if (this.mType == 8) {
            if (this.dOt != null) {
                return this.dOt.aUj();
            }
        } else if (this.mType == 17 && this.dOw != null) {
            return this.dOw.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo aTZ() {
        if (this.mType != 1) {
            return null;
        }
        return this.dOv;
    }

    public void a(i iVar) {
        if (this.mType == 32) {
            this.dOx = iVar;
        }
    }

    public i aUa() {
        if (this.mType != 32) {
            return null;
        }
        return this.dOx;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.dOw = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.dOA = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo aUb() {
        return this.dOw;
    }

    public TbRichTextMemeInfo aUc() {
        return this.dOA;
    }

    public int aUd() {
        return this.dOB;
    }

    public void nt(int i) {
        this.dOB = i;
    }

    public TbRichTextLinkImageInfo aUe() {
        if (this.mType != 1280) {
            return null;
        }
        return this.dOy;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.dOy = tbRichTextLinkImageInfo;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.dOz = tbRichTextLinkButtonInfo;
    }

    public void hm(boolean z) {
        this.dOC = z;
    }

    public boolean aUf() {
        return this.dOC;
    }
}
