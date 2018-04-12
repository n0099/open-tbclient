package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class e implements b {
    private int aUa;
    private int aUb;
    private double aUc;

    public e() {
        this.aUa = 3;
        this.aUb = this.aUa;
    }

    public e(int i) {
        this.aUa = 3;
        this.aUb = this.aUa;
        if (i > 0) {
            this.aUb = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.b
    public int fF(int i) {
        return 1;
    }

    @Override // com.baidu.tbadk.widget.layout.b
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        return v.v(list) <= 0 ? i2 : d(constrainImageLayout, list, i2);
    }

    private int d(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        int i2;
        if (constrainImageLayout == null || v.w(list)) {
            return i;
        }
        int v = v.v(list);
        if (v >= 2) {
            constrainImageLayout.setImageMaxChildCount(this.aUa);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = v - this.aUb;
        if (i3 > 0) {
            i2 = this.aUb + i;
            List<MediaData> a = v.a(list, i, i2);
            constrainImageLayout.setExtraCenterText(TbadkCoreApplication.getInst().getString(d.k.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)}));
            constrainImageLayout.setUrls(a, i, true);
        } else {
            constrainImageLayout.setUrls(v.a(list, i, v), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = v;
        }
        constrainImageLayout.setSingleImageRatio(fJ(v));
        return i2;
    }

    private double fJ(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.aUc > 0.0d) {
            return this.aUc;
        }
        return 0.6666666666666666d;
    }

    public void i(double d) {
        this.aUc = d;
    }
}
