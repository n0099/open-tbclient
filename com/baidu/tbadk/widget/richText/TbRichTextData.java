package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder dKn;
    private TbRichTextImageInfo dKo;
    private ArrayList<d> dKp;
    private TbRichTextTextInfo dKq;
    private TbRichTextEmotionInfo dKr;
    private i dKs;
    private TbRichTextLinkImageInfo dKt;
    private TbRichTextLinkButtonInfo dKu;
    private TbRichTextMemeInfo dKv;
    private int dKw;
    private boolean dKx;
    private TbRichTextVoiceInfo dek;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.dKn = null;
        this.dKo = null;
        this.dKp = null;
        this.dek = null;
        this.dKq = null;
        this.dKx = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.dKn = null;
        this.dKo = null;
        this.dKp = null;
        this.dek = null;
        this.dKq = null;
        this.dKx = false;
        this.mType = i;
        this.dKq = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<d> aRE() {
        if (this.dKp == null) {
            this.dKp = new ArrayList<>();
        }
        return this.dKp;
    }

    public void aU(int i, int i2) {
        if (this.dKp != null) {
            Iterator<d> it = this.dKp.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void j(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.dKn == null) {
                this.dKn = new SpannableStringBuilder("");
            }
            this.dKn.append(charSequence);
            this.dKq.charLength = this.dKn.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.dKn = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo aRF() {
        if (this.mType != 8) {
            return null;
        }
        return this.dKo;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.dKo = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder aRG() {
        return this.dKn;
    }

    public TbRichTextVoiceInfo aRH() {
        if (this.mType == 512 || this.mType == 768) {
            return this.dek;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.dek = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.dKn != null) {
                return this.dKn.toString();
            }
        } else if (this.mType == 8) {
            if (this.dKo != null) {
                return this.dKo.aRT();
            }
        } else if (this.mType == 17 && this.dKr != null) {
            return this.dKr.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo aRI() {
        if (this.mType != 1) {
            return null;
        }
        return this.dKq;
    }

    public void a(i iVar) {
        if (this.mType == 32) {
            this.dKs = iVar;
        }
    }

    public i aRJ() {
        if (this.mType != 32) {
            return null;
        }
        return this.dKs;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.dKr = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.dKv = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo aRK() {
        return this.dKr;
    }

    public TbRichTextMemeInfo aRL() {
        return this.dKv;
    }

    public int aRM() {
        return this.dKw;
    }

    public void nc(int i) {
        this.dKw = i;
    }

    public TbRichTextLinkImageInfo aRN() {
        if (this.mType != 1280) {
            return null;
        }
        return this.dKt;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.dKt = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo aRO() {
        return this.dKu;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.dKu = tbRichTextLinkButtonInfo;
    }

    public void hf(boolean z) {
        this.dKx = z;
    }

    public boolean aRP() {
        return this.dKx;
    }
}
