package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class f implements c {
    private int cIY;
    protected int cIZ;
    private double cJa;
    private boolean cJb;

    public f() {
        this.cIY = 3;
        this.cIZ = this.cIY;
        this.cJb = true;
    }

    public f(int i) {
        this.cIY = 3;
        this.cIZ = this.cIY;
        this.cJb = true;
        if (i > 0) {
            this.cIZ = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int lh(int i) {
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
            constrainImageLayout.setImageMaxChildCount(this.cIY);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = Z - this.cIZ;
        if (i3 > 0) {
            int i4 = this.cIZ + i;
            List<MediaData> c = v.c(list, i, i4);
            String string = TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)});
            if (!this.cJb) {
                string = null;
            }
            constrainImageLayout.setExtraCenterText(string);
            constrainImageLayout.setUrls(c, i, true, this.cJb);
            i2 = i4;
        } else {
            constrainImageLayout.setUrls(v.c(list, i, Z), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = Z;
        }
        constrainImageLayout.setSingleImageRatio(ll(Z));
        return i2;
    }

    private double ll(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.cJa > 0.0d) {
            return this.cJa;
        }
        return 0.6666666666666666d;
    }

    public void h(double d) {
        this.cJa = d;
    }

    public void fN(boolean z) {
        this.cJb = z;
    }
}
