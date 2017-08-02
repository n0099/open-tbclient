package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class f implements c {
    private int aOh;
    private int aOi;
    private double aOj;

    public f() {
        this.aOh = 3;
        this.aOi = this.aOh;
    }

    public f(int i) {
        this.aOh = 3;
        this.aOi = this.aOh;
        if (i > 0) {
            this.aOi = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int fq(int i) {
        return 1;
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int a(b bVar, List<String> list, int i, int i2) {
        return u.u(list) <= 0 ? i2 : d(bVar, list, i2);
    }

    private int d(b bVar, List<String> list, int i) {
        int i2;
        if (bVar == null || u.v(list)) {
            return i;
        }
        int u = u.u(list);
        int i3 = u - this.aOi;
        if (i3 > 0) {
            i2 = this.aOi + i;
            List<String> a = u.a(list, i, i2);
            bVar.setExtraCenterText(TbadkCoreApplication.getInst().getString(d.l.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)}));
            bVar.a(a, i, true);
        } else {
            bVar.f(u.a(list, i, u), i);
            bVar.setExtraCenterText(null);
            i2 = u;
        }
        bVar.setSingleImageRatio(fu(u));
        return i2;
    }

    private double fu(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.aOj > 0.0d) {
            return this.aOj;
        }
        return 0.6666666666666666d;
    }

    public void e(double d) {
        this.aOj = d;
    }
}
