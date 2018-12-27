package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes.dex */
public class e implements b {
    private int bpo;
    private int bpp;
    private double bpq;
    private boolean bpr;

    public e() {
        this.bpo = 3;
        this.bpp = this.bpo;
        this.bpr = true;
    }

    public e(int i) {
        this.bpo = 3;
        this.bpp = this.bpo;
        this.bpr = true;
        if (i > 0) {
            this.bpp = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.b
    public int gF(int i) {
        return 1;
    }

    @Override // com.baidu.tbadk.widget.layout.b
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        return v.H(list) <= 0 ? i2 : d(constrainImageLayout, list, i2);
    }

    private int d(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        int i2;
        if (constrainImageLayout == null || v.I(list)) {
            return i;
        }
        int H = v.H(list);
        if (H >= 2) {
            constrainImageLayout.setImageMaxChildCount(this.bpo);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = H - this.bpp;
        if (i3 > 0) {
            int i4 = this.bpp + i;
            List<MediaData> b = v.b(list, i, i4);
            String string = TbadkCoreApplication.getInst().getString(e.j.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)});
            if (!this.bpr) {
                string = null;
            }
            constrainImageLayout.setExtraCenterText(string);
            constrainImageLayout.setUrls(b, i, true, this.bpr);
            i2 = i4;
        } else {
            constrainImageLayout.setUrls(v.b(list, i, H), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = H;
        }
        constrainImageLayout.setSingleImageRatio(gJ(H));
        return i2;
    }

    private double gJ(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.bpq > 0.0d) {
            return this.bpq;
        }
        return 0.6666666666666666d;
    }

    public void g(double d) {
        this.bpq = d;
    }

    public void cX(boolean z) {
        this.bpr = z;
    }
}
