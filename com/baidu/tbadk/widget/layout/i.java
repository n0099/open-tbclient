package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class i implements f {
    private int aMY;
    private int aMZ;
    private double aNa;

    public i() {
        this.aMY = 3;
        this.aMZ = this.aMY;
    }

    public i(int i) {
        this.aMY = 3;
        this.aMZ = this.aMY;
        if (i > 0) {
            this.aMZ = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.f
    public int fn(int i) {
        return 1;
    }

    @Override // com.baidu.tbadk.widget.layout.f
    public int a(c cVar, List<String> list, int i, int i2) {
        return z.s(list) <= 0 ? i2 : d(cVar, list, i2);
    }

    private int d(c cVar, List<String> list, int i) {
        int i2;
        if (cVar == null || z.t(list)) {
            return i;
        }
        int s = z.s(list);
        int i3 = s - this.aMZ;
        if (i3 > 0) {
            i2 = this.aMZ + i;
            List<String> a = z.a(list, i, i2);
            cVar.setExtraCenterText(TbadkCoreApplication.m9getInst().getString(w.l.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)}));
            cVar.a(a, i, true);
        } else {
            cVar.f(z.a(list, i, s), i);
            cVar.setExtraCenterText(null);
            i2 = s;
        }
        cVar.setSingleImageRatio(fr(s));
        return i2;
    }

    private double fr(int i) {
        TbadkCoreApplication.m9getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.aNa > 0.0d) {
            return this.aNa;
        }
        return 0.6666666666666666d;
    }

    public void e(double d) {
        this.aNa = d;
    }
}
