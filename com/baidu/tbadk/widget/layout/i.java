package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class i implements f {
    private int aLL;
    private int aLM;
    private double aLN;

    public i() {
        this.aLL = 3;
        this.aLM = this.aLL;
    }

    public i(int i) {
        this.aLL = 3;
        this.aLM = this.aLL;
        if (i > 0) {
            this.aLM = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.f
    public int fk(int i) {
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
        int i3 = q - this.aLM;
        if (i3 > 0) {
            i2 = this.aLM + i;
            List<String> a = x.a(list, i, i2);
            cVar.setExtraCenterText(TbadkCoreApplication.m9getInst().getString(w.l.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)}));
            cVar.a(a, i, true);
        } else {
            cVar.f(x.a(list, i, q), i);
            cVar.setExtraCenterText(null);
            i2 = q;
        }
        cVar.setSingleImageRatio(fo(q));
        return i2;
    }

    private double fo(int i) {
        TbadkCoreApplication.m9getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.aLN > 0.0d) {
            return this.aLN;
        }
        return 0.6666666666666666d;
    }

    public void c(double d) {
        this.aLN = d;
    }
}
