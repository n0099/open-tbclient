package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder aMJ;
    private TbRichTextImageInfo aMK;
    private ArrayList<a> aML;
    private TbRichTextVoiceInfo aMM;
    private TbRichTextTextInfo aMN;
    private TbRichTextEmotionInfo aMO;
    private e aMP;
    private TbRichTextLinkImageInfo aMQ;
    private TbRichTextLinkButtonInfo aMR;
    private TbRichTextGraffitiInfo aMS;
    private int aMT;
    private boolean aMU;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.aMJ = null;
        this.aMK = null;
        this.aML = null;
        this.aMM = null;
        this.aMN = null;
        this.aMU = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.aMJ = null;
        this.aMK = null;
        this.aML = null;
        this.aMM = null;
        this.aMN = null;
        this.aMU = false;
        this.mType = i;
        this.aMN = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<a> It() {
        if (this.aML == null) {
            this.aML = new ArrayList<>();
        }
        return this.aML;
    }

    public void P(int i, int i2) {
        if (this.aML != null) {
            Iterator<a> it = this.aML.iterator();
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
        if (this.aML != null) {
            Iterator<a> it = this.aML.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aMJ == null) {
                this.aMJ = new SpannableStringBuilder("");
            }
            this.aMJ.append(charSequence);
            this.aMN.charLength = this.aMJ.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aMJ = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo Iu() {
        if (this.mType != 8) {
            return null;
        }
        return this.aMK;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.aMK = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder Iv() {
        return this.aMJ;
    }

    public void b(SpannableStringBuilder spannableStringBuilder) {
        if (this.aMJ != null) {
            this.aMJ.clear();
            this.aMJ.append((CharSequence) spannableStringBuilder);
        }
    }

    public TbRichTextVoiceInfo Iw() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aMM;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.aMM = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aMJ != null) {
                return this.aMJ.toString();
            }
        } else if (this.mType == 8) {
            if (this.aMK != null) {
                return this.aMK.II();
            }
        } else if (this.mType == 17 && this.aMO != null) {
            return this.aMO.mGifInfo.mSharpText;
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
        return this.aMN;
    }

    public void a(e eVar) {
        if (this.mType == 32) {
            this.aMP = eVar;
        }
    }

    public e Iy() {
        if (this.mType != 32) {
            return null;
        }
        return this.aMP;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.aMO = tbRichTextEmotionInfo;
        }
    }

    public TbRichTextEmotionInfo Iz() {
        return this.aMO;
    }

    public int IA() {
        return this.aMT;
    }

    public void ft(int i) {
        this.aMT = i;
    }

    public TbRichTextLinkImageInfo IB() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aMQ;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.aMQ = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo IC() {
        return this.aMR;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.aMR = tbRichTextLinkButtonInfo;
    }

    public TbRichTextGraffitiInfo ID() {
        return this.aMS;
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo) {
        if (this.mType == 1536) {
            this.aMS = tbRichTextGraffitiInfo;
        }
    }

    public void cc(boolean z) {
        this.aMU = z;
    }

    public boolean IE() {
        return this.aMU;
    }
}
