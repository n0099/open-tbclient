package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class a implements c {
    @Override // com.baidu.tbadk.widget.layout.c
    public int fG(int i) {
        if (i < 4) {
            return 1;
        }
        if (i >= 4 && i < 7) {
            return 2;
        }
        return 3;
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int a(b bVar, List<MediaData> list, int i, int i2) {
        if (v.t(list) > 0) {
            if (i == 0) {
                return a(bVar, list, i2);
            }
            if (i == 1) {
                return b(bVar, list, i2);
            }
            if (i == 2) {
                return c(bVar, list, i2);
            }
            return i2;
        }
        return i2;
    }

    private int a(b bVar, List<MediaData> list, int i) {
        if (bVar == null || v.u(list)) {
            return i;
        }
        int t = v.t(list);
        int i2 = t - 3;
        if (t == 1) {
            bVar.f(list, i);
            return 0;
        } else if (t == 2 || t == 4 || t == 5) {
            int i3 = i + 2;
            bVar.f(v.a(list, i, i3), i);
            return i3;
        } else {
            int i4 = i + 3;
            bVar.f(v.a(list, i, i4), i);
            return i4;
        }
    }

    private int b(b bVar, List<MediaData> list, int i) {
        if (bVar == null || v.u(list)) {
            return i;
        }
        if (v.t(list) == 4) {
            int i2 = i + 2;
            bVar.f(v.a(list, i, i2), i);
            return i2;
        }
        int i3 = i + 3;
        bVar.f(v.a(list, i, i3), i);
        return i3;
    }

    private int c(b bVar, List<MediaData> list, int i) {
        if (bVar == null || v.u(list)) {
            return i;
        }
        int t = v.t(list);
        bVar.setImageMaxChildCount(3);
        int i2 = t - 9;
        if (i2 > 0) {
            int i3 = i + 3;
            List<MediaData> a = v.a(list, i, i3);
            bVar.setExtraCenterText(TbadkCoreApplication.getInst().getString(d.l.constrain_image_extra_text, new Object[]{Integer.valueOf(i2)}));
            bVar.a(a, i, true);
            return i3;
        }
        bVar.f(v.a(list, i, t), i);
        bVar.setExtraCenterText(null);
        return t;
    }
}
