package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class f implements c {
    private int bHf;
    private int bHg;
    private double bHh;

    public f() {
        this.bHf = 3;
        this.bHg = this.bHf;
    }

    public f(int i) {
        this.bHf = 3;
        this.bHg = this.bHf;
        if (i > 0) {
            this.bHg = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int iH(int i) {
        return 1;
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int a(b bVar, List<MediaData> list, int i, int i2) {
        return v.D(list) <= 0 ? i2 : d(bVar, list, i2);
    }

    private int d(b bVar, List<MediaData> list, int i) {
        int i2;
        if (bVar == null || v.E(list)) {
            return i;
        }
        int D = v.D(list);
        if (D >= 2) {
            bVar.setImageMaxChildCount(this.bHf);
        } else {
            bVar.setImageMaxChildCount(-1);
        }
        int i3 = D - this.bHg;
        if (i3 > 0) {
            i2 = this.bHg + i;
            List<MediaData> b = v.b(list, i, i2);
            bVar.setExtraCenterText(TbadkCoreApplication.getInst().getString(d.j.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)}));
            bVar.b(b, i, true);
        } else {
            bVar.i(v.b(list, i, D), i);
            bVar.setExtraCenterText(null);
            i2 = D;
        }
        bVar.setSingleImageRatio(iL(D));
        return i2;
    }

    private double iL(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.bHh > 0.0d) {
            return this.bHh;
        }
        return 0.6666666666666666d;
    }

    public void g(double d) {
        this.bHh = d;
    }
}
