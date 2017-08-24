package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder aQN;
    private TbRichTextImageInfo aQO;
    private ArrayList<a> aQP;
    private TbRichTextTextInfo aQQ;
    private TbRichTextEmotionInfo aQR;
    private e aQS;
    private TbRichTextLinkImageInfo aQT;
    private TbRichTextLinkButtonInfo aQU;
    private TbRichTextGraffitiInfo aQV;
    private TbRichTextMemeInfo aQW;
    private int aQX;
    private boolean aQY;
    private TbRichTextVoiceInfo aph;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.aQN = null;
        this.aQO = null;
        this.aQP = null;
        this.aph = null;
        this.aQQ = null;
        this.aQY = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.aQN = null;
        this.aQO = null;
        this.aQP = null;
        this.aph = null;
        this.aQQ = null;
        this.aQY = false;
        this.mType = i;
        this.aQQ = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<a> Is() {
        if (this.aQP == null) {
            this.aQP = new ArrayList<>();
        }
        return this.aQP;
    }

    public void Q(int i, int i2) {
        if (this.aQP != null) {
            Iterator<a> it = this.aQP.iterator();
            while (it.hasNext()) {
                a next = it.next();
                Rect bounds = next.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    next.S(0, i2);
                }
            }
        }
    }

    public void R(int i, int i2) {
        if (this.aQP != null) {
            Iterator<a> it = this.aQP.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aQN == null) {
                this.aQN = new SpannableStringBuilder("");
            }
            this.aQN.append(charSequence);
            this.aQQ.charLength = this.aQN.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aQN = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo It() {
        if (this.mType != 8) {
            return null;
        }
        return this.aQO;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.aQO = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder Iu() {
        return this.aQN;
    }

    public void b(SpannableStringBuilder spannableStringBuilder) {
        if (this.aQN != null) {
            this.aQN.clear();
            this.aQN.append((CharSequence) spannableStringBuilder);
        }
    }

    public TbRichTextVoiceInfo Iv() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aph;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.aph = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aQN != null) {
                return this.aQN.toString();
            }
        } else if (this.mType == 8) {
            if (this.aQO != null) {
                return this.aQO.II();
            }
        } else if (this.mType == 17 && this.aQR != null) {
            return this.aQR.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo Iw() {
        if (this.mType != 1) {
            return null;
        }
        return this.aQQ;
    }

    public void a(e eVar) {
        if (this.mType == 32) {
            this.aQS = eVar;
        }
    }

    public e Ix() {
        if (this.mType != 32) {
            return null;
        }
        return this.aQS;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.aQR = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.aQW = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo Iy() {
        return this.aQR;
    }

    public TbRichTextMemeInfo Iz() {
        return this.aQW;
    }

    public int IA() {
        return this.aQX;
    }

    public void fy(int i) {
        this.aQX = i;
    }

    public TbRichTextLinkImageInfo IB() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aQT;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.aQT = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo IC() {
        return this.aQU;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.aQU = tbRichTextLinkButtonInfo;
    }

    public TbRichTextGraffitiInfo ID() {
        return this.aQV;
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo) {
        if (this.mType == 1536) {
            this.aQV = tbRichTextGraffitiInfo;
        }
    }

    public void ch(boolean z) {
        this.aQY = z;
    }

    public boolean IE() {
        return this.aQY;
    }
}
