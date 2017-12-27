package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class f implements c {
    private int bGX;
    private int bGY;
    private double bGZ;

    public f() {
        this.bGX = 3;
        this.bGY = this.bGX;
    }

    public f(int i) {
        this.bGX = 3;
        this.bGY = this.bGX;
        if (i > 0) {
            this.bGY = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int iL(int i) {
        return 1;
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int a(b bVar, List<MediaData> list, int i, int i2) {
        return v.F(list) <= 0 ? i2 : d(bVar, list, i2);
    }

    private int d(b bVar, List<MediaData> list, int i) {
        int i2;
        if (bVar == null || v.G(list)) {
            return i;
        }
        int F = v.F(list);
        if (F >= 2) {
            bVar.setImageMaxChildCount(this.bGX);
        } else {
            bVar.setImageMaxChildCount(-1);
        }
        int i3 = F - this.bGY;
        if (i3 > 0) {
            i2 = this.bGY + i;
            List<MediaData> b = v.b(list, i, i2);
            bVar.setExtraCenterText(TbadkCoreApplication.getInst().getString(d.j.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)}));
            bVar.b(b, i, true);
        } else {
            bVar.i(v.b(list, i, F), i);
            bVar.setExtraCenterText(null);
            i2 = F;
        }
        bVar.setSingleImageRatio(iP(F));
        return i2;
    }

    private double iP(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.bGZ > 0.0d) {
            return this.bGZ;
        }
        return 0.6666666666666666d;
    }

    public void f(double d) {
        this.bGZ = d;
    }
}
