package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private boolean aOA;
    private SpannableStringBuilder aOp;
    private TbRichTextImageInfo aOq;
    private ArrayList<a> aOr;
    private TbRichTextTextInfo aOs;
    private TbRichTextEmotionInfo aOt;
    private e aOu;
    private TbRichTextLinkImageInfo aOv;
    private TbRichTextLinkButtonInfo aOw;
    private TbRichTextGraffitiInfo aOx;
    private TbRichTextMemeInfo aOy;
    private int aOz;
    private TbRichTextVoiceInfo anc;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.aOp = null;
        this.aOq = null;
        this.aOr = null;
        this.anc = null;
        this.aOs = null;
        this.aOA = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.aOp = null;
        this.aOq = null;
        this.aOr = null;
        this.anc = null;
        this.aOs = null;
        this.aOA = false;
        this.mType = i;
        this.aOs = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<a> HZ() {
        if (this.aOr == null) {
            this.aOr = new ArrayList<>();
        }
        return this.aOr;
    }

    public void P(int i, int i2) {
        if (this.aOr != null) {
            Iterator<a> it = this.aOr.iterator();
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
        if (this.aOr != null) {
            Iterator<a> it = this.aOr.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aOp == null) {
                this.aOp = new SpannableStringBuilder("");
            }
            this.aOp.append(charSequence);
            this.aOs.charLength = this.aOp.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aOp = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo Ia() {
        if (this.mType != 8) {
            return null;
        }
        return this.aOq;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.aOq = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder Ib() {
        return this.aOp;
    }

    public void b(SpannableStringBuilder spannableStringBuilder) {
        if (this.aOp != null) {
            this.aOp.clear();
            this.aOp.append((CharSequence) spannableStringBuilder);
        }
    }

    public TbRichTextVoiceInfo Ic() {
        if (this.mType == 512 || this.mType == 768) {
            return this.anc;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.anc = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aOp != null) {
                return this.aOp.toString();
            }
        } else if (this.mType == 8) {
            if (this.aOq != null) {
                return this.aOq.Ip();
            }
        } else if (this.mType == 17 && this.aOt != null) {
            return this.aOt.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo Id() {
        if (this.mType != 1) {
            return null;
        }
        return this.aOs;
    }

    public void a(e eVar) {
        if (this.mType == 32) {
            this.aOu = eVar;
        }
    }

    public e Ie() {
        if (this.mType != 32) {
            return null;
        }
        return this.aOu;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.aOt = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.aOy = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo If() {
        return this.aOt;
    }

    public TbRichTextMemeInfo Ig() {
        return this.aOy;
    }

    public int Ih() {
        return this.aOz;
    }

    public void ft(int i) {
        this.aOz = i;
    }

    public TbRichTextLinkImageInfo Ii() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aOv;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.aOv = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo Ij() {
        return this.aOw;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.aOw = tbRichTextLinkButtonInfo;
    }

    public TbRichTextGraffitiInfo Ik() {
        return this.aOx;
    }

    public void a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo) {
        if (this.mType == 1536) {
            this.aOx = tbRichTextGraffitiInfo;
        }
    }

    public void ce(boolean z) {
        this.aOA = z;
    }

    public boolean Il() {
        return this.aOA;
    }
}
