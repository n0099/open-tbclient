package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes.dex */
public class e implements b {
    private int blc;
    private int bld;
    private double ble;
    private boolean blf;

    public e() {
        this.blc = 3;
        this.bld = this.blc;
        this.blf = true;
    }

    public e(int i) {
        this.blc = 3;
        this.bld = this.blc;
        this.blf = true;
        if (i > 0) {
            this.bld = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.b
    public int gc(int i) {
        return 1;
    }

    @Override // com.baidu.tbadk.widget.layout.b
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        return v.I(list) <= 0 ? i2 : d(constrainImageLayout, list, i2);
    }

    private int d(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        int i2;
        if (constrainImageLayout == null || v.J(list)) {
            return i;
        }
        int I = v.I(list);
        if (I >= 2) {
            constrainImageLayout.setImageMaxChildCount(this.blc);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = I - this.bld;
        if (i3 > 0) {
            int i4 = this.bld + i;
            List<MediaData> b = v.b(list, i, i4);
            String string = TbadkCoreApplication.getInst().getString(e.j.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)});
            if (!this.blf) {
                string = null;
            }
            constrainImageLayout.setExtraCenterText(string);
            constrainImageLayout.setUrls(b, i, true, this.blf);
            i2 = i4;
        } else {
            constrainImageLayout.setUrls(v.b(list, i, I), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = I;
        }
        constrainImageLayout.setSingleImageRatio(gg(I));
        return i2;
    }

    private double gg(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.ble > 0.0d) {
            return this.ble;
        }
        return 0.6666666666666666d;
    }

    public void g(double d) {
        this.ble = d;
    }

    public void cF(boolean z) {
        this.blf = z;
    }
}
