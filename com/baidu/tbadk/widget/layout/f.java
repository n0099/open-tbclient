package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class f implements c {
    private int aPg;
    private int aPh;
    private double aPi;

    public f() {
        this.aPg = 3;
        this.aPh = this.aPg;
    }

    public f(int i) {
        this.aPg = 3;
        this.aPh = this.aPg;
        if (i > 0) {
            this.aPh = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int fs(int i) {
        return 1;
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int a(b bVar, List<String> list, int i, int i2) {
        return v.u(list) <= 0 ? i2 : d(bVar, list, i2);
    }

    private int d(b bVar, List<String> list, int i) {
        int i2;
        if (bVar == null || v.v(list)) {
            return i;
        }
        int u = v.u(list);
        if (u >= 2) {
            bVar.setImageMaxChildCount(this.aPg);
        } else {
            bVar.setImageMaxChildCount(-1);
        }
        int i3 = u - this.aPh;
        if (i3 > 0) {
            i2 = this.aPh + i;
            List<String> a = v.a(list, i, i2);
            bVar.setExtraCenterText(TbadkCoreApplication.getInst().getString(d.l.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)}));
            bVar.a(a, i, true);
        } else {
            bVar.f(v.a(list, i, u), i);
            bVar.setExtraCenterText(null);
            i2 = u;
        }
        bVar.setSingleImageRatio(fw(u));
        return i2;
    }

    private double fw(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.aPi > 0.0d) {
            return this.aPi;
        }
        return 0.6666666666666666d;
    }

    public void e(double d) {
        this.aPi = d;
    }
}
