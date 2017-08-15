package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder aQM;
    private TbRichTextImageInfo aQN;
    private ArrayList<a> aQO;
    private TbRichTextTextInfo aQP;
    private TbRichTextEmotionInfo aQQ;
    private e aQR;
    private TbRichTextLinkImageInfo aQS;
    private TbRichTextLinkButtonInfo aQT;
    private TbRichTextGraffitiInfo aQU;
    private TbRichTextMemeInfo aQV;
    private int aQW;
    private boolean aQX;
    private TbRichTextVoiceInfo aph;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.aQM = null;
        this.aQN = null;
        this.aQO = null;
        this.aph = null;
        this.aQP = null;
        this.aQX = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.aQM = null;
        this.aQN = null;
        this.aQO = null;
        this.aph = null;
        this.aQP = null;
        this.aQX = false;
        this.mType = i;
        this.aQP = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<a> Is() {
        if (this.aQO == null) {
            this.aQO = new ArrayList<>();
        }
        return this.aQO;
    }

    public void Q(int i, int i2) {
        if (this.aQO != null) {
            Iterator<a> it = this.aQO.iterator();
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
        if (this.aQO != null) {
            Iterator<a> it = this.aQO.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aQM == null) {
                this.aQM = new SpannableStringBuilder("");
            }
            this.aQM.append(charSequence);
            this.aQP.charLength = this.aQM.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aQM = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo It() {
        if (this.mType != 8) {
            return null;
        }
        return this.aQN;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.aQN = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder Iu() {
        return this.aQM;
    }

    public void b(SpannableStringBuilder spannableStringBuilder) {
        if (this.aQM != null) {
            this.aQM.clear();
            this.aQM.append((CharSequence) spannableStringBuilder);
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
            if (this.aQM != null) {
                return this.aQM.toString();
            }
        } else if (this.mType == 8) {
            if (this.aQN != null) {
                return this.aQN.II();
            }
        } else if (this.mType == 17 && this.aQQ != null) {
            return this.aQQ.mGifInfo.mSharpText;
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
        return this.aQP;
    }

    public void a(e eVar) {
        if (this.mType == 32) {
            this.aQR = eVar;
        }
    }

    public e Ix() {
        if (this.mType != 32) {
            return null;
        }
        return this.aQR;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.aQQ = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.aQV = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo Iy() {
        return this.aQQ;
    }

    public TbRichTextMemeInfo Iz() {
        return this.aQV;
    }

    public int IA() {
        return this.aQW;
    }

    public void fy(int i) {
        this.aQW = i;
    }

    public TbRichTextLinkImageInfo IB() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aQS;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.aQS = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo IC() {
        return this.aQT;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.aQT = tbRichTextLinkButtonInfo;
    }

    public TbRichTextGraffitiInfo ID() {
        return this.aQU;
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo) {
        if (this.mType == 1536) {
            this.aQU = tbRichTextGraffitiInfo;
        }
    }

    public void ch(boolean z) {
        this.aQX = z;
    }

    public boolean IE() {
        return this.aQX;
    }
}
