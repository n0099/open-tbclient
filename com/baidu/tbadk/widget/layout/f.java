package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class f implements c {
    private int bJi;
    private int bJj;
    private double bJk;

    public f() {
        this.bJi = 3;
        this.bJj = this.bJi;
    }

    public f(int i) {
        this.bJi = 3;
        this.bJj = this.bJi;
        if (i > 0) {
            this.bJj = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int iE(int i) {
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
            bVar.setImageMaxChildCount(this.bJi);
            bVar.setCanCenterStart(false);
        } else {
            bVar.setImageMaxChildCount(-1);
            bVar.setCanCenterStart(true);
        }
        int i3 = D - this.bJj;
        if (i3 > 0) {
            i2 = this.bJj + i;
            List<MediaData> b = v.b(list, i, i2);
            bVar.setExtraCenterText(TbadkCoreApplication.getInst().getString(d.j.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)}));
            bVar.c(b, i, true);
        } else {
            bVar.i(v.b(list, i, D), i);
            bVar.setExtraCenterText(null);
            i2 = D;
        }
        bVar.setSingleImageRatio(iI(D));
        return i2;
    }

    private double iI(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.bJk > 0.0d) {
            return this.bJk;
        }
        return 0.6666666666666666d;
    }

    public void h(double d) {
        this.bJk = d;
    }
}
