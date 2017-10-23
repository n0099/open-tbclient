package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class f implements c {
    private int aPV;
    private int aPW;
    private double aPX;

    public f() {
        this.aPV = 3;
        this.aPW = this.aPV;
    }

    public f(int i) {
        this.aPV = 3;
        this.aPW = this.aPV;
        if (i > 0) {
            this.aPW = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int fF(int i) {
        return 1;
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int a(b bVar, List<MediaData> list, int i, int i2) {
        return v.t(list) <= 0 ? i2 : d(bVar, list, i2);
    }

    private int d(b bVar, List<MediaData> list, int i) {
        int i2;
        if (bVar == null || v.u(list)) {
            return i;
        }
        int t = v.t(list);
        if (t >= 2) {
            bVar.setImageMaxChildCount(this.aPV);
        } else {
            bVar.setImageMaxChildCount(-1);
        }
        int i3 = t - this.aPW;
        if (i3 > 0) {
            i2 = this.aPW + i;
            List<MediaData> a = v.a(list, i, i2);
            bVar.setExtraCenterText(TbadkCoreApplication.getInst().getString(d.l.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)}));
            bVar.a(a, i, true);
        } else {
            bVar.f(v.a(list, i, t), i);
            bVar.setExtraCenterText(null);
            i2 = t;
        }
        bVar.setSingleImageRatio(fJ(t));
        return i2;
    }

    private double fJ(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.aPX > 0.0d) {
            return this.aPX;
        }
        return 0.6666666666666666d;
    }

    public void e(double d) {
        this.aPX = d;
    }
}
