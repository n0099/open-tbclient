package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class f implements c {
    private int aPd;
    private int aPe;
    private double aPf;

    public f() {
        this.aPd = 3;
        this.aPe = this.aPd;
    }

    public f(int i) {
        this.aPd = 3;
        this.aPe = this.aPd;
        if (i > 0) {
            this.aPe = i;
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
            bVar.setImageMaxChildCount(this.aPd);
        } else {
            bVar.setImageMaxChildCount(-1);
        }
        int i3 = u - this.aPe;
        if (i3 > 0) {
            i2 = this.aPe + i;
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
        if (this.aPf > 0.0d) {
            return this.aPf;
        }
        return 0.6666666666666666d;
    }

    public void e(double d) {
        this.aPf = d;
    }
}
