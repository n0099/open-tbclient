package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class f implements c {
    private int cAO;
    protected int cAP;
    private double cAQ;
    private boolean cAR;

    public f() {
        this.cAO = 3;
        this.cAP = this.cAO;
        this.cAR = true;
    }

    public f(int i) {
        this.cAO = 3;
        this.cAP = this.cAO;
        this.cAR = true;
        if (i > 0) {
            this.cAP = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int ks(int i) {
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
            constrainImageLayout.setImageMaxChildCount(this.cAO);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = S - this.cAP;
        if (i3 > 0) {
            int i4 = this.cAP + i;
            List<MediaData> c = v.c(list, i, i4);
            String string = TbadkCoreApplication.getInst().getString(d.j.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)});
            if (!this.cAR) {
                string = null;
            }
            constrainImageLayout.setExtraCenterText(string);
            constrainImageLayout.setUrls(c, i, true, this.cAR);
            i2 = i4;
        } else {
            constrainImageLayout.setUrls(v.c(list, i, S), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = S;
        }
        constrainImageLayout.setSingleImageRatio(kw(S));
        return i2;
    }

    private double kw(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.cAQ > 0.0d) {
            return this.cAQ;
        }
        return 0.6666666666666666d;
    }

    public void h(double d) {
        this.cAQ = d;
    }

    public void fq(boolean z) {
        this.cAR = z;
    }
}
