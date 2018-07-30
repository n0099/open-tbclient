package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class e implements b {
    private int bds;
    private int bdt;
    private double bdu;
    private boolean bdv;

    public e() {
        this.bds = 3;
        this.bdt = this.bds;
        this.bdv = true;
    }

    public e(int i) {
        this.bds = 3;
        this.bdt = this.bds;
        this.bdv = true;
        if (i > 0) {
            this.bdt = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.b
    public int fI(int i) {
        return 1;
    }

    @Override // com.baidu.tbadk.widget.layout.b
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        return w.y(list) <= 0 ? i2 : d(constrainImageLayout, list, i2);
    }

    private int d(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        int i2;
        if (constrainImageLayout == null || w.z(list)) {
            return i;
        }
        int y = w.y(list);
        if (y >= 2) {
            constrainImageLayout.setImageMaxChildCount(this.bds);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = y - this.bdt;
        if (i3 > 0) {
            int i4 = this.bdt + i;
            List<MediaData> a = w.a(list, i, i4);
            String string = TbadkCoreApplication.getInst().getString(d.j.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)});
            if (!this.bdv) {
                string = null;
            }
            constrainImageLayout.setExtraCenterText(string);
            constrainImageLayout.setUrls(a, i, true, this.bdv);
            i2 = i4;
        } else {
            constrainImageLayout.setUrls(w.a(list, i, y), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = y;
        }
        constrainImageLayout.setSingleImageRatio(fM(y));
        return i2;
    }

    private double fM(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.bdu > 0.0d) {
            return this.bdu;
        }
        return 0.6666666666666666d;
    }

    public void h(double d) {
        this.bdu = d;
    }

    public void cj(boolean z) {
        this.bdv = z;
    }
}
