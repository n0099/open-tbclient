package com.baidu.tbadk.widget.richText;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private TbRichTextVoiceInfo aKA;
    private SpannableStringBuilder brO;
    private TbRichTextImageInfo brP;
    private ArrayList<b> brQ;
    private TbRichTextTextInfo brR;
    private TbRichTextEmotionInfo brS;
    private f brT;
    private TbRichTextLinkImageInfo brU;
    private TbRichTextLinkButtonInfo brV;
    private TbRichTextMemeInfo brW;
    private int brX;
    private boolean brY;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.brO = null;
        this.brP = null;
        this.brQ = null;
        this.aKA = null;
        this.brR = null;
        this.brY = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.brO = null;
        this.brP = null;
        this.brQ = null;
        this.aKA = null;
        this.brR = null;
        this.brY = false;
        this.mType = i;
        this.brR = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> SC() {
        if (this.brQ == null) {
            this.brQ = new ArrayList<>();
        }
        return this.brQ;
    }

    public void V(int i, int i2) {
        if (this.brQ != null) {
            Iterator<b> it = this.brQ.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.brO == null) {
                this.brO = new SpannableStringBuilder("");
            }
            this.brO.append(charSequence);
            this.brR.charLength = this.brO.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.brO = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo SD() {
        if (this.mType != 8) {
            return null;
        }
        return this.brP;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.brP = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder SE() {
        return this.brO;
    }

    public TbRichTextVoiceInfo SF() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aKA;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.aKA = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.brO != null) {
                return this.brO.toString();
            }
        } else if (this.mType == 8) {
            if (this.brP != null) {
                return this.brP.SS();
            }
        } else if (this.mType == 17 && this.brS != null) {
            return this.brS.mGifInfo.mSharpText;
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
        return this.brR;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.brT = fVar;
        }
    }

    public f SH() {
        if (this.mType != 32) {
            return null;
        }
        return this.brT;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.brS = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.brW = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo SI() {
        return this.brS;
    }

    public TbRichTextMemeInfo SJ() {
        return this.brW;
    }

    public int SK() {
        return this.brX;
    }

    public void gV(int i) {
        this.brX = i;
    }

    public TbRichTextLinkImageInfo SL() {
        if (this.mType != 1280) {
            return null;
        }
        return this.brU;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.brU = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo SM() {
        return this.brV;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.brV = tbRichTextLinkButtonInfo;
    }

    public void de(boolean z) {
        this.brY = z;
    }

    public boolean SN() {
        return this.brY;
    }
}
