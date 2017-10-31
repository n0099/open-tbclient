package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class f implements c {
    private int aPZ;
    private int aQa;
    private double aQb;

    public f() {
        this.aPZ = 3;
        this.aQa = this.aPZ;
    }

    public f(int i) {
        this.aPZ = 3;
        this.aQa = this.aPZ;
        if (i > 0) {
            this.aQa = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int fG(int i) {
        return 1;
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int a(b bVar, List<MediaData> list, int i, int i2) {
        return v.u(list) <= 0 ? i2 : d(bVar, list, i2);
    }

    private int d(b bVar, List<MediaData> list, int i) {
        int i2;
        if (bVar == null || v.v(list)) {
            return i;
        }
        int u = v.u(list);
        if (u >= 2) {
            bVar.setImageMaxChildCount(this.aPZ);
        } else {
            bVar.setImageMaxChildCount(-1);
        }
        int i3 = u - this.aQa;
        if (i3 > 0) {
            i2 = this.aQa + i;
            List<MediaData> a = v.a(list, i, i2);
            bVar.setExtraCenterText(TbadkCoreApplication.getInst().getString(d.j.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)}));
            bVar.a(a, i, true);
        } else {
            bVar.f(v.a(list, i, u), i);
            bVar.setExtraCenterText(null);
            i2 = u;
        }
        bVar.setSingleImageRatio(fK(u));
        return i2;
    }

    private double fK(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.aQb > 0.0d) {
            return this.aQb;
        }
        return 0.6666666666666666d;
    }

    public void e(double d) {
        this.aQb = d;
    }
}
