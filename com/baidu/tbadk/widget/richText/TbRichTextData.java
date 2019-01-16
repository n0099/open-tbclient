package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo aKz;
    private SpannableStringBuilder brN;
    private TbRichTextImageInfo brO;
    private ArrayList<b> brP;
    private TbRichTextTextInfo brQ;
    private TbRichTextEmotionInfo brR;
    private f brS;
    private TbRichTextLinkImageInfo brT;
    private TbRichTextLinkButtonInfo brU;
    private TbRichTextMemeInfo brV;
    private int brW;
    private boolean brX;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.brN = null;
        this.brO = null;
        this.brP = null;
        this.aKz = null;
        this.brQ = null;
        this.brX = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.brN = null;
        this.brO = null;
        this.brP = null;
        this.aKz = null;
        this.brQ = null;
        this.brX = false;
        this.mType = i;
        this.brQ = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> SC() {
        if (this.brP == null) {
            this.brP = new ArrayList<>();
        }
        return this.brP;
    }

    public void V(int i, int i2) {
        if (this.brP != null) {
            Iterator<b> it = this.brP.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.brN == null) {
                this.brN = new SpannableStringBuilder("");
            }
            this.brN.append(charSequence);
            this.brQ.charLength = this.brN.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.brN = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo SD() {
        if (this.mType != 8) {
            return null;
        }
        return this.brO;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.brO = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder SE() {
        return this.brN;
    }

    public TbRichTextVoiceInfo SF() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aKz;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.aKz = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.brN != null) {
                return this.brN.toString();
            }
        } else if (this.mType == 8) {
            if (this.brO != null) {
                return this.brO.SS();
            }
        } else if (this.mType == 17 && this.brR != null) {
            return this.brR.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo SG() {
        if (this.mType != 1) {
            return null;
        }
        return this.brQ;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.brS = fVar;
        }
    }

    public f SH() {
        if (this.mType != 32) {
            return null;
        }
        return this.brS;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.brR = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.brV = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo SI() {
        return this.brR;
    }

    public TbRichTextMemeInfo SJ() {
        return this.brV;
    }

    public int SK() {
        return this.brW;
    }

    public void gV(int i) {
        this.brW = i;
    }

    public TbRichTextLinkImageInfo SL() {
        if (this.mType != 1280) {
            return null;
        }
        return this.brT;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.brT = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo SM() {
        return this.brU;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.brU = tbRichTextLinkButtonInfo;
    }

    public void de(boolean z) {
        this.brX = z;
    }

    public boolean SN() {
        return this.brX;
    }
}
