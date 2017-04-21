package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder aML;
    private TbRichTextImageInfo aMM;
    private ArrayList<a> aMN;
    private TbRichTextVoiceInfo aMO;
    private TbRichTextTextInfo aMP;
    private TbRichTextEmotionInfo aMQ;
    private e aMR;
    private TbRichTextLinkImageInfo aMS;
    private TbRichTextLinkButtonInfo aMT;
    private TbRichTextGraffitiInfo aMU;
    private int aMV;
    private boolean aMW;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.aML = null;
        this.aMM = null;
        this.aMN = null;
        this.aMO = null;
        this.aMP = null;
        this.aMW = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.aML = null;
        this.aMM = null;
        this.aMN = null;
        this.aMO = null;
        this.aMP = null;
        this.aMW = false;
        this.mType = i;
        this.aMP = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<a> It() {
        if (this.aMN == null) {
            this.aMN = new ArrayList<>();
        }
        return this.aMN;
    }

    public void P(int i, int i2) {
        if (this.aMN != null) {
            Iterator<a> it = this.aMN.iterator();
            while (it.hasNext()) {
                a next = it.next();
                Rect bounds = next.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    next.R(0, i2);
                }
            }
        }
    }

    public void Q(int i, int i2) {
        if (this.aMN != null) {
            Iterator<a> it = this.aMN.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aML == null) {
                this.aML = new SpannableStringBuilder("");
            }
            this.aML.append(charSequence);
            this.aMP.charLength = this.aML.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aML = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo Iu() {
        if (this.mType != 8) {
            return null;
        }
        return this.aMM;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.aMM = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder Iv() {
        return this.aML;
    }

    public void b(SpannableStringBuilder spannableStringBuilder) {
        if (this.aML != null) {
            this.aML.clear();
            this.aML.append((CharSequence) spannableStringBuilder);
        }
    }

    public TbRichTextVoiceInfo Iw() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aMO;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.aMO = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aML != null) {
                return this.aML.toString();
            }
        } else if (this.mType == 8) {
            if (this.aMM != null) {
                return this.aMM.II();
            }
        } else if (this.mType == 17 && this.aMQ != null) {
            return this.aMQ.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo Ix() {
        if (this.mType != 1) {
            return null;
        }
        return this.aMP;
    }

    public void a(e eVar) {
        if (this.mType == 32) {
            this.aMR = eVar;
        }
    }

    public e Iy() {
        if (this.mType != 32) {
            return null;
        }
        return this.aMR;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.aMQ = tbRichTextEmotionInfo;
        }
    }

    public TbRichTextEmotionInfo Iz() {
        return this.aMQ;
    }

    public int IA() {
        return this.aMV;
    }

    public void ft(int i) {
        this.aMV = i;
    }

    public TbRichTextLinkImageInfo IB() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aMS;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.aMS = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo IC() {
        return this.aMT;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.aMT = tbRichTextLinkButtonInfo;
    }

    public TbRichTextGraffitiInfo ID() {
        return this.aMU;
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo) {
        if (this.mType == 1536) {
            this.aMU = tbRichTextGraffitiInfo;
        }
    }

    public void cc(boolean z) {
        this.aMW = z;
    }

    public boolean IE() {
        return this.aMW;
    }
}
