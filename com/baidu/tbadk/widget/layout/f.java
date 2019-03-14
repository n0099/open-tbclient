package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class f implements c {
    private int cAM;
    protected int cAN;
    private double cAO;
    private boolean cAP;

    public f() {
        this.cAM = 3;
        this.cAN = this.cAM;
        this.cAP = true;
    }

    public f(int i) {
        this.cAM = 3;
        this.cAN = this.cAM;
        this.cAP = true;
        if (i > 0) {
            this.cAN = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int kt(int i) {
        return 1;
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        return v.S(list) <= 0 ? i2 : d(constrainImageLayout, list, i2);
    }

    protected int d(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        int i2;
        if (constrainImageLayout == null || v.T(list)) {
            return i;
        }
        int S = v.S(list);
        if (S >= 2) {
            constrainImageLayout.setImageMaxChildCount(this.cAM);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = S - this.cAN;
        if (i3 > 0) {
            int i4 = this.cAN + i;
            List<MediaData> c = v.c(list, i, i4);
            String string = TbadkCoreApplication.getInst().getString(d.j.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)});
            if (!this.cAP) {
                string = null;
            }
            constrainImageLayout.setExtraCenterText(string);
            constrainImageLayout.setUrls(c, i, true, this.cAP);
            i2 = i4;
        } else {
            constrainImageLayout.setUrls(v.c(list, i, S), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = S;
        }
        constrainImageLayout.setSingleImageRatio(kx(S));
        return i2;
    }

    private double kx(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.cAO > 0.0d) {
            return this.cAO;
        }
        return 0.6666666666666666d;
    }

    public void h(double d) {
        this.cAO = d;
    }

    public void fq(boolean z) {
        this.cAP = z;
    }
}
