package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder dKg;
    private TbRichTextImageInfo dKh;
    private ArrayList<d> dKi;
    private TbRichTextTextInfo dKj;
    private TbRichTextEmotionInfo dKk;
    private i dKl;
    private TbRichTextLinkImageInfo dKm;
    private TbRichTextLinkButtonInfo dKn;
    private TbRichTextMemeInfo dKo;
    private int dKp;
    private boolean dKq;
    private TbRichTextVoiceInfo dea;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.dKg = null;
        this.dKh = null;
        this.dKi = null;
        this.dea = null;
        this.dKj = null;
        this.dKq = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.dKg = null;
        this.dKh = null;
        this.dKi = null;
        this.dea = null;
        this.dKj = null;
        this.dKq = false;
        this.mType = i;
        this.dKj = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<d> aRk() {
        if (this.dKi == null) {
            this.dKi = new ArrayList<>();
        }
        return this.dKi;
    }

    public void aQ(int i, int i2) {
        if (this.dKi != null) {
            Iterator<d> it = this.dKi.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void j(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.dKg == null) {
                this.dKg = new SpannableStringBuilder("");
            }
            this.dKg.append(charSequence);
            this.dKj.charLength = this.dKg.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.dKg = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo aRl() {
        if (this.mType != 8) {
            return null;
        }
        return this.dKh;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.dKh = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder aRm() {
        return this.dKg;
    }

    public TbRichTextVoiceInfo aRn() {
        if (this.mType == 512 || this.mType == 768) {
            return this.dea;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.dea = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.dKg != null) {
                return this.dKg.toString();
            }
        } else if (this.mType == 8) {
            if (this.dKh != null) {
                return this.dKh.aRz();
            }
        } else if (this.mType == 17 && this.dKk != null) {
            return this.dKk.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo aRo() {
        if (this.mType != 1) {
            return null;
        }
        return this.dKj;
    }

    public void a(i iVar) {
        if (this.mType == 32) {
            this.dKl = iVar;
        }
    }

    public i aRp() {
        if (this.mType != 32) {
            return null;
        }
        return this.dKl;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.dKk = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.dKo = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo aRq() {
        return this.dKk;
    }

    public TbRichTextMemeInfo aRr() {
        return this.dKo;
    }

    public int aRs() {
        return this.dKp;
    }

    public void nc(int i) {
        this.dKp = i;
    }

    public TbRichTextLinkImageInfo aRt() {
        if (this.mType != 1280) {
            return null;
        }
        return this.dKm;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.dKm = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo aRu() {
        return this.dKn;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.dKn = tbRichTextLinkButtonInfo;
    }

    public void ha(boolean z) {
        this.dKq = z;
    }

    public boolean aRv() {
        return this.dKq;
    }
}
