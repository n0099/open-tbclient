package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class i implements f {
    private int aLI;
    private int aLJ;
    private double aLK;

    public i() {
        this.aLI = 3;
        this.aLJ = this.aLI;
    }

    public i(int i) {
        this.aLI = 3;
        this.aLJ = this.aLI;
        if (i > 0) {
            this.aLJ = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.f
    public int fl(int i) {
        return 1;
    }

    @Override // com.baidu.tbadk.widget.layout.f
    public int a(c cVar, List<String> list, int i, int i2) {
        return x.q(list) <= 0 ? i2 : d(cVar, list, i2);
    }

    private int d(c cVar, List<String> list, int i) {
        int i2;
        if (cVar == null || x.r(list)) {
            return i;
        }
        int q = x.q(list);
        int i3 = q - this.aLJ;
        if (i3 > 0) {
            i2 = this.aLJ + i;
            List<String> a = x.a(list, i, i2);
            cVar.setExtraCenterText(TbadkCoreApplication.m9getInst().getString(w.l.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)}));
            cVar.a(a, i, true);
        } else {
            cVar.f(x.a(list, i, q), i);
            cVar.setExtraCenterText(null);
            i2 = q;
        }
        cVar.setSingleImageRatio(fp(q));
        return i2;
    }

    private double fp(int i) {
        TbadkCoreApplication.m9getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.aLK > 0.0d) {
            return this.aLK;
        }
        return 0.6666666666666666d;
    }

    public void c(double d) {
        this.aLK = d;
    }
}
