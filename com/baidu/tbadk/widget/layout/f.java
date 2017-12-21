package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class f implements c {
    private int aTk;
    private int aTl;
    private double aTm;

    public f() {
        this.aTk = 3;
        this.aTl = this.aTk;
    }

    public f(int i) {
        this.aTk = 3;
        this.aTl = this.aTk;
        if (i > 0) {
            this.aTl = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int fM(int i) {
        return 1;
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int a(b bVar, List<MediaData> list, int i, int i2) {
        return v.v(list) <= 0 ? i2 : d(bVar, list, i2);
    }

    private int d(b bVar, List<MediaData> list, int i) {
        int i2;
        if (bVar == null || v.w(list)) {
            return i;
        }
        int v = v.v(list);
        if (v >= 2) {
            bVar.setImageMaxChildCount(this.aTk);
        } else {
            bVar.setImageMaxChildCount(-1);
        }
        int i3 = v - this.aTl;
        if (i3 > 0) {
            i2 = this.aTl + i;
            List<MediaData> a = v.a(list, i, i2);
            bVar.setExtraCenterText(TbadkCoreApplication.getInst().getString(d.j.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)}));
            bVar.a(a, i, true);
        } else {
            bVar.f(v.a(list, i, v), i);
            bVar.setExtraCenterText(null);
            i2 = v;
        }
        bVar.setSingleImageRatio(fQ(v));
        return i2;
    }

    private double fQ(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.aTm > 0.0d) {
            return this.aTm;
        }
        return 0.6666666666666666d;
    }

    public void e(double d) {
        this.aTm = d;
    }
}
