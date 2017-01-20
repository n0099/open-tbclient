package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder aGV;
    private TbRichTextImageInfo aGW;
    private ArrayList<a> aGX;
    private TbRichTextVoiceInfo aGY;
    private TbRichTextTextInfo aGZ;
    private TbRichTextEmotionInfo aHa;
    private e aHb;
    private TbRichTextLinkImageInfo aHc;
    private TbRichTextLinkButtonInfo aHd;
    private TbRichTextGraffitiInfo aHe;
    private int aHf;
    private boolean aHg;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.aGV = null;
        this.aGW = null;
        this.aGX = null;
        this.aGY = null;
        this.aGZ = null;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.aGV = null;
        this.aGW = null;
        this.aGX = null;
        this.aGY = null;
        this.aGZ = null;
        this.mType = i;
        this.aGZ = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<a> Hu() {
        if (this.aGX == null) {
            this.aGX = new ArrayList<>();
        }
        return this.aGX;
    }

    public void K(int i, int i2) {
        if (this.aGX != null) {
            Iterator<a> it = this.aGX.iterator();
            while (it.hasNext()) {
                a next = it.next();
                Rect bounds = next.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    next.M(0, i2);
                }
            }
        }
    }

    public void L(int i, int i2) {
        if (this.aGX != null) {
            Iterator<a> it = this.aGX.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aGV == null) {
                this.aGV = new SpannableStringBuilder("");
            }
            this.aGV.append(charSequence);
            this.aGZ.charLength = this.aGV.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aGV = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo Hv() {
        if (this.mType != 8) {
            return null;
        }
        return this.aGW;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.aGW = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder Hw() {
        return this.aGV;
    }

    public void b(SpannableStringBuilder spannableStringBuilder) {
        if (this.aGV != null) {
            this.aGV.clear();
            this.aGV.append((CharSequence) spannableStringBuilder);
        }
    }

    public TbRichTextVoiceInfo Hx() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aGY;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.aGY = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aGV != null) {
                return this.aGV.toString();
            }
        } else if (this.mType == 8) {
            if (this.aGW != null) {
                return this.aGW.HJ();
            }
        } else if (this.mType == 17 && this.aHa != null) {
            return this.aHa.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo Hy() {
        if (this.mType != 1) {
            return null;
        }
        return this.aGZ;
    }

    public void a(e eVar) {
        if (this.mType == 32) {
            this.aHb = eVar;
        }
    }

    public e Hz() {
        if (this.mType != 32) {
            return null;
        }
        return this.aHb;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.aHa = tbRichTextEmotionInfo;
        }
    }

    public TbRichTextEmotionInfo HA() {
        return this.aHa;
    }

    public int HB() {
        return this.aHf;
    }

    public void fx(int i) {
        this.aHf = i;
    }

    public TbRichTextLinkImageInfo HC() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aHc;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.aHc = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo HD() {
        return this.aHd;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.aHd = tbRichTextLinkButtonInfo;
    }

    public TbRichTextGraffitiInfo HE() {
        return this.aHe;
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo) {
        if (this.mType == 1536) {
            this.aHe = tbRichTextGraffitiInfo;
        }
    }

    public void cb(boolean z) {
        this.aHg = z;
    }

    public boolean HF() {
        return this.aHg;
    }
}
