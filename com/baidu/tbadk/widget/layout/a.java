package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class a implements c {
    @Override // com.baidu.tbadk.widget.layout.c
    public int iH(int i) {
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
        if (v.D(list) > 0) {
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
        if (bVar == null || v.E(list)) {
            return i;
        }
        int D = v.D(list);
        int i2 = D - 3;
        if (D == 1) {
            bVar.i(list, i);
            return 0;
        } else if (D == 2 || D == 4 || D == 5) {
            int i3 = i + 2;
            bVar.i(v.b(list, i, i3), i);
            return i3;
        } else {
            int i4 = i + 3;
            bVar.i(v.b(list, i, i4), i);
            return i4;
        }
    }

    private int b(b bVar, List<MediaData> list, int i) {
        if (bVar == null || v.E(list)) {
            return i;
        }
        if (v.D(list) == 4) {
            int i2 = i + 2;
            bVar.i(v.b(list, i, i2), i);
            return i2;
        }
        int i3 = i + 3;
        bVar.i(v.b(list, i, i3), i);
        return i3;
    }

    private int c(b bVar, List<MediaData> list, int i) {
        if (bVar == null || v.E(list)) {
            return i;
        }
        int D = v.D(list);
        bVar.setImageMaxChildCount(3);
        int i2 = D - 9;
        if (i2 > 0) {
            int i3 = i + 3;
            List<MediaData> b = v.b(list, i, i3);
            bVar.setExtraCenterText(TbadkCoreApplication.getInst().getString(d.j.constrain_image_extra_text, new Object[]{Integer.valueOf(i2)}));
            bVar.b(b, i, true);
            return i3;
        }
        bVar.i(v.b(list, i, D), i);
        bVar.setExtraCenterText(null);
        return D;
    }
}
