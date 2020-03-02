package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextLinkButtonInfo dOA;
    private TbRichTextMemeInfo dOB;
    private int dOC;
    private boolean dOD;
    private SpannableStringBuilder dOt;
    private TbRichTextImageInfo dOu;
    private ArrayList<d> dOv;
    private TbRichTextTextInfo dOw;
    private TbRichTextEmotionInfo dOx;
    private i dOy;
    private TbRichTextLinkImageInfo dOz;
    private TbRichTextVoiceInfo diq;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.dOt = null;
        this.dOu = null;
        this.dOv = null;
        this.diq = null;
        this.dOw = null;
        this.dOD = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.dOt = null;
        this.dOu = null;
        this.dOv = null;
        this.diq = null;
        this.dOw = null;
        this.dOD = false;
        this.mType = i;
        this.dOw = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<d> aTX() {
        if (this.dOv == null) {
            this.dOv = new ArrayList<>();
        }
        return this.dOv;
    }

    public void aU(int i, int i2) {
        if (this.dOv != null) {
            Iterator<d> it = this.dOv.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void j(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.dOt == null) {
                this.dOt = new SpannableStringBuilder("");
            }
            this.dOt.append(charSequence);
            this.dOw.charLength = this.dOt.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.dOt = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo aTY() {
        if (this.mType != 8) {
            return null;
        }
        return this.dOu;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.dOu = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder aTZ() {
        return this.dOt;
    }

    public TbRichTextVoiceInfo aUa() {
        if (this.mType == 512 || this.mType == 768) {
            return this.diq;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.diq = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.dOt != null) {
                return this.dOt.toString();
            }
        } else if (this.mType == 8) {
            if (this.dOu != null) {
                return this.dOu.aUl();
            }
        } else if (this.mType == 17 && this.dOx != null) {
            return this.dOx.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo aUb() {
        if (this.mType != 1) {
            return null;
        }
        return this.dOw;
    }

    public void a(i iVar) {
        if (this.mType == 32) {
            this.dOy = iVar;
        }
    }

    public i aUc() {
        if (this.mType != 32) {
            return null;
        }
        return this.dOy;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.dOx = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.dOB = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo aUd() {
        return this.dOx;
    }

    public TbRichTextMemeInfo aUe() {
        return this.dOB;
    }

    public int aUf() {
        return this.dOC;
    }

    public void nt(int i) {
        this.dOC = i;
    }

    public TbRichTextLinkImageInfo aUg() {
        if (this.mType != 1280) {
            return null;
        }
        return this.dOz;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.dOz = tbRichTextLinkImageInfo;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.dOA = tbRichTextLinkButtonInfo;
    }

    public void hm(boolean z) {
        this.dOD = z;
    }

    public boolean aUh() {
        return this.dOD;
    }
}
