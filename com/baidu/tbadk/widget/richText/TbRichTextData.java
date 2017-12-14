package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder aUR;
    private TbRichTextImageInfo aUS;
    private ArrayList<b> aUT;
    private TbRichTextTextInfo aUU;
    private TbRichTextEmotionInfo aUV;
    private f aUW;
    private TbRichTextLinkImageInfo aUX;
    private TbRichTextLinkButtonInfo aUY;
    private TbRichTextMemeInfo aUZ;
    private int aVa;
    private boolean aVb;
    private TbRichTextVoiceInfo aom;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.aUR = null;
        this.aUS = null;
        this.aUT = null;
        this.aom = null;
        this.aUU = null;
        this.aVb = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.aUR = null;
        this.aUS = null;
        this.aUT = null;
        this.aom = null;
        this.aUU = null;
        this.aVb = false;
        this.mType = i;
        this.aUU = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> Jw() {
        if (this.aUT == null) {
            this.aUT = new ArrayList<>();
        }
        return this.aUT;
    }

    public void U(int i, int i2) {
        if (this.aUT != null) {
            Iterator<b> it = this.aUT.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aUR == null) {
                this.aUR = new SpannableStringBuilder("");
            }
            this.aUR.append(charSequence);
            this.aUU.charLength = this.aUR.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aUR = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo Jx() {
        if (this.mType != 8) {
            return null;
        }
        return this.aUS;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.aUS = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder Jy() {
        return this.aUR;
    }

    public void c(SpannableStringBuilder spannableStringBuilder) {
        if (this.aUR != null) {
            this.aUR.clear();
            this.aUR.append((CharSequence) spannableStringBuilder);
        }
    }

    public TbRichTextVoiceInfo Jz() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aom;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.aom = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aUR != null) {
                return this.aUR.toString();
            }
        } else if (this.mType == 8) {
            if (this.aUS != null) {
                return this.aUS.JL();
            }
        } else if (this.mType == 17 && this.aUV != null) {
            return this.aUV.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo JA() {
        if (this.mType != 1) {
            return null;
        }
        return this.aUU;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.aUW = fVar;
        }
    }

    public f JB() {
        if (this.mType != 32) {
            return null;
        }
        return this.aUW;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.aUV = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.aUZ = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo JC() {
        return this.aUV;
    }

    public TbRichTextMemeInfo JD() {
        return this.aUZ;
    }

    public int JE() {
        return this.aVa;
    }

    public void gc(int i) {
        this.aVa = i;
    }

    public TbRichTextLinkImageInfo JF() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aUX;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.aUX = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo JG() {
        return this.aUY;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.aUY = tbRichTextLinkButtonInfo;
    }

    public void ch(boolean z) {
        this.aVb = z;
    }

    public boolean JH() {
        return this.aVb;
    }
}
