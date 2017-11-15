package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder aRQ;
    private TbRichTextImageInfo aRR;
    private ArrayList<b> aRS;
    private TbRichTextTextInfo aRT;
    private TbRichTextEmotionInfo aRU;
    private f aRV;
    private TbRichTextLinkImageInfo aRW;
    private TbRichTextLinkButtonInfo aRX;
    private TbRichTextMemeInfo aRY;
    private int aRZ;
    private boolean aSa;
    private TbRichTextVoiceInfo aoa;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.aRQ = null;
        this.aRR = null;
        this.aRS = null;
        this.aoa = null;
        this.aRT = null;
        this.aSa = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.aRQ = null;
        this.aRR = null;
        this.aRS = null;
        this.aoa = null;
        this.aRT = null;
        this.aSa = false;
        this.mType = i;
        this.aRT = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<b> IY() {
        if (this.aRS == null) {
            this.aRS = new ArrayList<>();
        }
        return this.aRS;
    }

    public void S(int i, int i2) {
        if (this.aRS != null) {
            Iterator<b> it = this.aRS.iterator();
            while (it.hasNext()) {
                b next = it.next();
                Rect bounds = next.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    next.U(0, i2);
                }
            }
        }
    }

    public void T(int i, int i2) {
        if (this.aRS != null) {
            Iterator<b> it = this.aRS.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aRQ == null) {
                this.aRQ = new SpannableStringBuilder("");
            }
            this.aRQ.append(charSequence);
            this.aRT.charLength = this.aRQ.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aRQ = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo IZ() {
        if (this.mType != 8) {
            return null;
        }
        return this.aRR;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.aRR = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder Ja() {
        return this.aRQ;
    }

    public void c(SpannableStringBuilder spannableStringBuilder) {
        if (this.aRQ != null) {
            this.aRQ.clear();
            this.aRQ.append((CharSequence) spannableStringBuilder);
        }
    }

    public TbRichTextVoiceInfo Jb() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aoa;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.aoa = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aRQ != null) {
                return this.aRQ.toString();
            }
        } else if (this.mType == 8) {
            if (this.aRR != null) {
                return this.aRR.Jn();
            }
        } else if (this.mType == 17 && this.aRU != null) {
            return this.aRU.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo Jc() {
        if (this.mType != 1) {
            return null;
        }
        return this.aRT;
    }

    public void a(f fVar) {
        if (this.mType == 32) {
            this.aRV = fVar;
        }
    }

    public f Jd() {
        if (this.mType != 32) {
            return null;
        }
        return this.aRV;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.aRU = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.aRY = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo Je() {
        return this.aRU;
    }

    public TbRichTextMemeInfo Jf() {
        return this.aRY;
    }

    public int Jg() {
        return this.aRZ;
    }

    public void fU(int i) {
        this.aRZ = i;
    }

    public TbRichTextLinkImageInfo Jh() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aRW;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.aRW = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo Ji() {
        return this.aRX;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.aRX = tbRichTextLinkButtonInfo;
    }

    public void cd(boolean z) {
        this.aSa = z;
    }

    public boolean Jj() {
        return this.aSa;
    }
}
