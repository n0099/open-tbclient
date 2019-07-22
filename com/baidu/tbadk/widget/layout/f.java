package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class f implements c {
    private int cKs;
    protected int cKt;
    private double cKu;
    private boolean cKv;

    public f() {
        this.cKs = 3;
        this.cKt = this.cKs;
        this.cKv = true;
    }

    public f(int i) {
        this.cKs = 3;
        this.cKt = this.cKs;
        this.cKv = true;
        if (i > 0) {
            this.cKt = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int ln(int i) {
        return 1;
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        return v.Z(list) <= 0 ? i2 : d(constrainImageLayout, list, i2);
    }

    protected int d(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        int i2;
        if (constrainImageLayout == null || v.aa(list)) {
            return i;
        }
        int Z = v.Z(list);
        if (Z >= 2) {
            constrainImageLayout.setImageMaxChildCount(this.cKs);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = Z - this.cKt;
        if (i3 > 0) {
            int i4 = this.cKt + i;
            List<MediaData> c = v.c(list, i, i4);
            String string = TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)});
            if (!this.cKv) {
                string = null;
            }
            constrainImageLayout.setExtraCenterText(string);
            constrainImageLayout.setUrls(c, i, true, this.cKv);
            i2 = i4;
        } else {
            constrainImageLayout.setUrls(v.c(list, i, Z), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = Z;
        }
        constrainImageLayout.setSingleImageRatio(lr(Z));
        return i2;
    }

    private double lr(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.cKu > 0.0d) {
            return this.cKu;
        }
        return 0.6666666666666666d;
    }

    public void h(double d) {
        this.cKu = d;
    }

    public void fR(boolean z) {
        this.cKv = z;
    }
}
