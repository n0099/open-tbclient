package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder aQL;
    private TbRichTextImageInfo aQM;
    private ArrayList<a> aQN;
    private TbRichTextTextInfo aQO;
    private TbRichTextEmotionInfo aQP;
    private e aQQ;
    private TbRichTextLinkImageInfo aQR;
    private TbRichTextLinkButtonInfo aQS;
    private TbRichTextGraffitiInfo aQT;
    private TbRichTextMemeInfo aQU;
    private int aQV;
    private boolean aQW;
    private TbRichTextVoiceInfo apg;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.aQL = null;
        this.aQM = null;
        this.aQN = null;
        this.apg = null;
        this.aQO = null;
        this.aQW = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.aQL = null;
        this.aQM = null;
        this.aQN = null;
        this.apg = null;
        this.aQO = null;
        this.aQW = false;
        this.mType = i;
        this.aQO = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<a> Is() {
        if (this.aQN == null) {
            this.aQN = new ArrayList<>();
        }
        return this.aQN;
    }

    public void Q(int i, int i2) {
        if (this.aQN != null) {
            Iterator<a> it = this.aQN.iterator();
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
        if (this.aQN != null) {
            Iterator<a> it = this.aQN.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aQL == null) {
                this.aQL = new SpannableStringBuilder("");
            }
            this.aQL.append(charSequence);
            this.aQO.charLength = this.aQL.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aQL = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo It() {
        if (this.mType != 8) {
            return null;
        }
        return this.aQM;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.aQM = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder Iu() {
        return this.aQL;
    }

    public void b(SpannableStringBuilder spannableStringBuilder) {
        if (this.aQL != null) {
            this.aQL.clear();
            this.aQL.append((CharSequence) spannableStringBuilder);
        }
    }

    public TbRichTextVoiceInfo Iv() {
        if (this.mType == 512 || this.mType == 768) {
            return this.apg;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.apg = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aQL != null) {
                return this.aQL.toString();
            }
        } else if (this.mType == 8) {
            if (this.aQM != null) {
                return this.aQM.II();
            }
        } else if (this.mType == 17 && this.aQP != null) {
            return this.aQP.mGifInfo.mSharpText;
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
        return this.aQO;
    }

    public void a(e eVar) {
        if (this.mType == 32) {
            this.aQQ = eVar;
        }
    }

    public e Ix() {
        if (this.mType != 32) {
            return null;
        }
        return this.aQQ;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.aQP = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.aQU = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo Iy() {
        return this.aQP;
    }

    public TbRichTextMemeInfo Iz() {
        return this.aQU;
    }

    public int IA() {
        return this.aQV;
    }

    public void fy(int i) {
        this.aQV = i;
    }

    public TbRichTextLinkImageInfo IB() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aQR;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.aQR = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo IC() {
        return this.aQS;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.aQS = tbRichTextLinkButtonInfo;
    }

    public TbRichTextGraffitiInfo ID() {
        return this.aQT;
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo) {
        if (this.mType == 1536) {
            this.aQT = tbRichTextGraffitiInfo;
        }
    }

    public void ch(boolean z) {
        this.aQW = z;
    }

    public boolean IE() {
        return this.aQW;
    }
}
