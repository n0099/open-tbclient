package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichTextData extends OrmObject {
    private SpannableStringBuilder aRi;
    private TbRichTextImageInfo aRj;
    private ArrayList<a> aRk;
    private TbRichTextTextInfo aRl;
    private TbRichTextEmotionInfo aRm;
    private e aRn;
    private TbRichTextLinkImageInfo aRo;
    private TbRichTextLinkButtonInfo aRp;
    private TbRichTextMemeInfo aRq;
    private int aRr;
    private boolean aRs;
    private TbRichTextVoiceInfo anG;
    private int mType;

    public TbRichTextData() {
        this.mType = 0;
        this.aRi = null;
        this.aRj = null;
        this.aRk = null;
        this.anG = null;
        this.aRl = null;
        this.aRs = false;
    }

    public TbRichTextData(int i) {
        this.mType = 0;
        this.aRi = null;
        this.aRj = null;
        this.aRk = null;
        this.anG = null;
        this.aRl = null;
        this.aRs = false;
        this.mType = i;
        this.aRl = new TbRichTextTextInfo();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<a> IC() {
        if (this.aRk == null) {
            this.aRk = new ArrayList<>();
        }
        return this.aRk;
    }

    public void S(int i, int i2) {
        if (this.aRk != null) {
            Iterator<a> it = this.aRk.iterator();
            while (it.hasNext()) {
                a next = it.next();
                Rect bounds = next.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    next.U(0, i2);
                }
            }
        }
    }

    public void T(int i, int i2) {
        if (this.aRk != null) {
            Iterator<a> it = this.aRk.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aRi == null) {
                this.aRi = new SpannableStringBuilder("");
            }
            this.aRi.append(charSequence);
            this.aRl.charLength = this.aRi.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aRi = new SpannableStringBuilder(str);
        }
    }

    public TbRichTextImageInfo ID() {
        if (this.mType != 8) {
            return null;
        }
        return this.aRj;
    }

    public void a(TbRichTextImageInfo tbRichTextImageInfo) {
        if (this.mType == 8) {
            this.aRj = tbRichTextImageInfo;
        }
    }

    public SpannableStringBuilder IE() {
        return this.aRi;
    }

    public void c(SpannableStringBuilder spannableStringBuilder) {
        if (this.aRi != null) {
            this.aRi.clear();
            this.aRi.append((CharSequence) spannableStringBuilder);
        }
    }

    public TbRichTextVoiceInfo IF() {
        if (this.mType == 512 || this.mType == 768) {
            return this.anG;
        }
        return null;
    }

    public void a(TbRichTextVoiceInfo tbRichTextVoiceInfo) {
        if (this.mType == 512 || this.mType == 768) {
            this.anG = tbRichTextVoiceInfo;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aRi != null) {
                return this.aRi.toString();
            }
        } else if (this.mType == 8) {
            if (this.aRj != null) {
                return this.aRj.IR();
            }
        } else if (this.mType == 17 && this.aRm != null) {
            return this.aRm.mGifInfo.mSharpText;
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

    public TbRichTextTextInfo IG() {
        if (this.mType != 1) {
            return null;
        }
        return this.aRl;
    }

    public void a(e eVar) {
        if (this.mType == 32) {
            this.aRn = eVar;
        }
    }

    public e IH() {
        if (this.mType != 32) {
            return null;
        }
        return this.aRn;
    }

    public void a(TbRichTextEmotionInfo tbRichTextEmotionInfo) {
        if (this.mType == 17) {
            this.aRm = tbRichTextEmotionInfo;
        }
    }

    public void a(TbRichTextMemeInfo tbRichTextMemeInfo) {
        if (this.mType == 20) {
            this.aRq = tbRichTextMemeInfo;
        }
    }

    public TbRichTextEmotionInfo II() {
        return this.aRm;
    }

    public TbRichTextMemeInfo IJ() {
        return this.aRq;
    }

    public int IK() {
        return this.aRr;
    }

    public void fM(int i) {
        this.aRr = i;
    }

    public TbRichTextLinkImageInfo IL() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aRo;
    }

    public void a(TbRichTextLinkImageInfo tbRichTextLinkImageInfo) {
        this.aRo = tbRichTextLinkImageInfo;
    }

    public TbRichTextLinkButtonInfo IM() {
        return this.aRp;
    }

    public void a(TbRichTextLinkButtonInfo tbRichTextLinkButtonInfo) {
        this.aRp = tbRichTextLinkButtonInfo;
    }

    public void cg(boolean z) {
        this.aRs = z;
    }

    public boolean IN() {
        return this.aRs;
    }
}
