package com.baidu.tbadk.widget.richText;

import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a {
    public static final float aUh = l.af(TbadkCoreApplication.getInst());
    protected boolean aUx;
    protected TbImageView.b mOnDrawListener;
    protected float aUi = 0.0f;
    protected float aUj = 0.0f;
    protected int aUk = 0;
    protected int aUl = 0;
    protected float aUm = 15.0f;
    protected int aUn = -1;
    protected int aUo = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int aUp = 200;
    protected int aUq = 200;
    protected int aUr = 0;
    protected int aUs = 0;
    protected boolean aUt = false;
    protected int aUu = -9989158;
    protected ImageView.ScaleType aUv = ImageView.ScaleType.CENTER_CROP;
    protected boolean aUw = false;
    protected int aUy = l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds16);
    protected int aUz = l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int aUA = l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int aUB = 0;
    protected int aUC = -1;
    protected int aUD = -1;
    protected int aUE = -1;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void a(TypedArray typedArray) {
        this.aUl = typedArray.getDimensionPixelSize(d.l.TbRichTextView_segmentMargin, 0);
        this.aUk = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textPadding, 0);
        this.aUi = typedArray.getFloat(d.l.TbRichTextView_lineSpacing, 1.12f);
        this.aUm = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textSize, (int) this.aUm);
        this.mTextColor = typedArray.getColor(d.l.TbRichTextView_textColor, this.mTextColor);
        this.aUp = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageWidth, this.aUp);
        this.aUq = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageHeight, this.aUq);
        this.aUr = typedArray.getResourceId(d.l.TbRichTextView_defaultImage, 0);
        this.aUn = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceWidth, this.aUn);
        this.aUo = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceHeight, this.aUo);
        this.aUs = typedArray.getResourceId(d.l.TbRichTextView_videoImage, 0);
        this.aUt = typedArray.getBoolean(d.l.TbRichTextView_singleLine, false);
        this.aUD = this.aUl;
    }

    public void release() {
    }

    public void J(float f) {
        this.aUi = f;
    }

    public void S(int i, int i2) {
        this.aUn = i;
        this.aUo = i2;
    }

    public void fS(int i) {
        this.aUs = i;
    }

    public void fT(int i) {
        this.aUp = i;
    }

    public void fU(int i) {
        this.aUq = i;
    }

    public void fV(int i) {
        this.aUr = i;
    }

    public void Jq() {
        this.aUw = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.aUi = f2;
        this.aUj = f;
    }

    public void T(int i, int i2) {
        this.aUy = i;
        this.aUz = i2;
    }

    public void fW(int i) {
        this.aUA = i;
    }

    public void fX(int i) {
        this.aUB = i;
    }

    public void fY(int i) {
        this.aUC = i;
    }

    public void fZ(int i) {
        this.aUD = i;
    }

    public void ga(int i) {
        this.aUE = i;
    }

    public void cg(boolean z) {
        this.aUx = z;
    }

    public int[] l(int i, int i2, int i3, int i4) {
        int[] b = l.b(i, i2, i3, i4);
        if (b == null) {
            return null;
        }
        int[] iArr = {b[0], b[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.aUx || i3 <= i5 || aUh <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * aUh <= i3) {
                if (i5 * aUh > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * aUh);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.aUi = aVar.aUi;
        this.aUj = aVar.aUj;
        this.aUk = aVar.aUk;
        this.aUl = aVar.aUl;
        this.aUm = aVar.aUm;
        this.aUn = aVar.aUn;
        this.aUo = aVar.aUo;
        this.mTextColor = aVar.mTextColor;
        this.aUp = aVar.aUp;
        this.aUq = aVar.aUq;
        this.aUr = aVar.aUr;
        this.aUs = aVar.aUs;
        this.aUt = aVar.aUt;
        this.aUu = aVar.aUu;
        this.aUw = aVar.aUw;
        this.aUx = aVar.aUx;
        this.aUy = aVar.aUy;
        this.aUz = aVar.aUz;
        this.aUA = aVar.aUA;
        this.aUB = aVar.aUB;
        this.aUC = aVar.aUC;
        this.aUD = aVar.aUl;
        this.aUE = aVar.aUE;
    }
}
