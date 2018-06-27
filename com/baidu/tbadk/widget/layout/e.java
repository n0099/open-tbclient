package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class e implements b {
    private int bdj;
    private int bdk;
    private double bdl;

    public e() {
        this.bdj = 3;
        this.bdk = this.bdj;
    }

    public e(int i) {
        this.bdj = 3;
        this.bdk = this.bdj;
        if (i > 0) {
            this.bdk = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.b
    public int fH(int i) {
        return 1;
    }

    @Override // com.baidu.tbadk.widget.layout.b
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        return w.z(list) <= 0 ? i2 : d(constrainImageLayout, list, i2);
    }

    private int d(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        int i2;
        if (constrainImageLayout == null || w.A(list)) {
            return i;
        }
        int z = w.z(list);
        if (z >= 2) {
            constrainImageLayout.setImageMaxChildCount(this.bdj);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = z - this.bdk;
        if (i3 > 0) {
            i2 = this.bdk + i;
            List<MediaData> a = w.a(list, i, i2);
            constrainImageLayout.setExtraCenterText(TbadkCoreApplication.getInst().getString(d.k.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)}));
            constrainImageLayout.setUrls(a, i, true);
        } else {
            constrainImageLayout.setUrls(w.a(list, i, z), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = z;
        }
        constrainImageLayout.setSingleImageRatio(fL(z));
        return i2;
    }

    private double fL(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.bdl > 0.0d) {
            return this.bdl;
        }
        return 0.6666666666666666d;
    }

    public void i(double d) {
        this.bdl = d;
    }
}
