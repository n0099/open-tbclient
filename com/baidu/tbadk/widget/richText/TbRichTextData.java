package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder aUP;
    private TbRichTextImageInfo aUQ;
    private ArrayList<b> aUR;
    private TbRichTextTextInfo aUS;
    private TbRichTextEmotionInfo aUT;
    private f aUU;
    private TbRichTextLinkImageInfo aUV;
    private TbRichTextLinkButtonInfo aUW;
    private TbRichTextMemeInfo aUX;
    private int aUY;
    private boolean aUZ;
    private TbRichTextVoiceInfo aok;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.aUP = null;
        this.aUQ = null;
        this.aUR = null;
        this.aok = null;
        this.aUS = null;
        this.aUZ = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.aUP = null;
        this.aUQ = null;
        this.aUR = null;
        this.aok = null;
        this.aUS = null;
        this.aUZ = false;
        this.mType = i;
        this.aUS = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> Jv() {
        if (this.aUR == null) {
            this.aUR = new ArrayList<>();
        }
        return this.aUR;
    }

    public void T(int i, int i2) {
        if (this.aUR != null) {
            Iterator<b> it = this.aUR.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aUP == null) {
                this.aUP = new SpannableStringBuilder("");
            }
            this.aUP.append(charSequence);
            this.aUS.charLength = this.aUP.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aUP = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo Jw() {
        if (this.mType != 8) {
            return null;
        }
        return this.aUQ;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.aUQ = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder Jx() {
        return this.aUP;
    }

    public void c(SpannableStringBuilder spannableStringBuilder) {
        if (this.aUP != null) {
            this.aUP.clear();
            this.aUP.append((CharSequence) spannableStringBuilder);
        }
    }

    public TbRichTextVoiceInfo Jy() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aok;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.aok = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aUP != null) {
                return this.aUP.toString();
            }
        } else if (this.mType == 8) {
            if (this.aUQ != null) {
                return this.aUQ.JK();
            }
        } else if (this.mType == 17 && this.aUT != null) {
            return this.aUT.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo Jz() {
        if (this.mType != 1) {
            return null;
        }
        return this.aUS;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.aUU = fVar;
        }
    }

    public f JA() {
        if (this.mType != 32) {
            return null;
        }
        return this.aUU;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.aUT = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.aUX = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo JB() {
        return this.aUT;
    }

    public TbRichTextMemeInfo JC() {
        return this.aUX;
    }

    public int JD() {
        return this.aUY;
    }

    public void gc(int i) {
        this.aUY = i;
    }

    public TbRichTextLinkImageInfo JE() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aUV;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.aUV = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo JF() {
        return this.aUW;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.aUW = tbRichTextLinkButtonInfo;
    }

    public void cg(boolean z) {
        this.aUZ = z;
    }

    public boolean JG() {
        return this.aUZ;
    }
}
