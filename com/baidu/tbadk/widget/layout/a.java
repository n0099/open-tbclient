package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class a implements f {
    @Override // com.baidu.tbadk.widget.layout.f
    public int fr(int i) {
        if (i < 4) {
            return 1;
        }
        if (i >= 4 && i < 7) {
            return 2;
        }
        return 3;
    }

    @Override // com.baidu.tbadk.widget.layout.f
    public int a(c cVar, List<String> list, int i, int i2) {
        if (x.s(list) > 0) {
            if (i == 0) {
                return a(cVar, list, i2);
            }
            if (i == 1) {
                return b(cVar, list, i2);
            }
            if (i == 2) {
                return c(cVar, list, i2);
            }
            return i2;
        }
        return i2;
    }

    private int a(c cVar, List<String> list, int i) {
        if (cVar == null || x.t(list)) {
            return i;
        }
        int s = x.s(list);
        if (s == 1) {
            cVar.f(list, i);
            return 0;
        } else if (s == 2 || s == 4 || s == 5) {
            int i2 = i + 2;
            cVar.f(x.a(list, i, i2), i);
            return i2;
        } else {
            int i3 = i + 3;
            cVar.f(x.a(list, i, i3), i);
            return i3;
        }
    }

    private int b(c cVar, List<String> list, int i) {
        if (cVar == null || x.t(list)) {
            return i;
        }
        if (x.s(list) == 4) {
            int i2 = i + 2;
            cVar.f(x.a(list, i, i2), i);
            return i2;
        }
        int i3 = i + 3;
        cVar.f(x.a(list, i, i3), i);
        return i3;
    }

    private int c(c cVar, List<String> list, int i) {
        if (cVar == null || x.t(list)) {
            return i;
        }
        int s = x.s(list);
        cVar.setImageMaxChildCount(3);
        int i2 = s - 9;
        if (i2 > 0) {
            int i3 = i + 3;
            List<String> a = x.a(list, i, i3);
            cVar.setExtraCenterText(TbadkCoreApplication.m9getInst().getString(r.j.constrain_image_extra_text, new Object[]{Integer.valueOf(i2)}));
            cVar.a(a, i, true);
            return i3;
        }
        cVar.f(x.a(list, i, s), i);
        cVar.setExtraCenterText(null);
        return s;
    }
}
