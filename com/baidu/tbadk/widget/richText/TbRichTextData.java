package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder cNe;
    private TbRichTextImageInfo cNf;
    private ArrayList<b> cNg;
    private TbRichTextTextInfo cNh;
    private TbRichTextEmotionInfo cNi;
    private f cNj;
    private TbRichTextLinkImageInfo cNk;
    private TbRichTextLinkButtonInfo cNl;
    private TbRichTextMemeInfo cNm;
    private int cNn;
    private boolean cNo;
    private TbRichTextVoiceInfo cdm;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.cNe = null;
        this.cNf = null;
        this.cNg = null;
        this.cdm = null;
        this.cNh = null;
        this.cNo = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.cNe = null;
        this.cNf = null;
        this.cNg = null;
        this.cdm = null;
        this.cNh = null;
        this.cNo = false;
        this.mType = i;
        this.cNh = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> azf() {
        if (this.cNg == null) {
            this.cNg = new ArrayList<>();
        }
        return this.cNg;
    }

    public void ax(int i, int i2) {
        if (this.cNg != null) {
            Iterator<b> it = this.cNg.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void k(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.cNe == null) {
                this.cNe = new SpannableStringBuilder("");
            }
            this.cNe.append(charSequence);
            this.cNh.charLength = this.cNe.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.cNe = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo azg() {
        if (this.mType != 8) {
            return null;
        }
        return this.cNf;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.cNf = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder azh() {
        return this.cNe;
    }

    public TbRichTextVoiceInfo azi() {
        if (this.mType == 512 || this.mType == 768) {
            return this.cdm;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.cdm = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.cNe != null) {
                return this.cNe.toString();
            }
        } else if (this.mType == 8) {
            if (this.cNf != null) {
                return this.cNf.azu();
            }
        } else if (this.mType == 17 && this.cNi != null) {
            return this.cNi.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo azj() {
        if (this.mType != 1) {
            return null;
        }
        return this.cNh;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.cNj = fVar;
        }
    }

    public f azk() {
        if (this.mType != 32) {
            return null;
        }
        return this.cNj;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.cNi = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.cNm = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo azl() {
        return this.cNi;
    }

    public TbRichTextMemeInfo azm() {
        return this.cNm;
    }

    public int azn() {
        return this.cNn;
    }

    public void lJ(int i) {
        this.cNn = i;
    }

    public TbRichTextLinkImageInfo azo() {
        if (this.mType != 1280) {
            return null;
        }
        return this.cNk;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.cNk = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo azp() {
        return this.cNl;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.cNl = tbRichTextLinkButtonInfo;
    }

    public void fY(boolean z) {
        this.cNo = z;
    }

    public boolean azq() {
        return this.cNo;
    }
}
