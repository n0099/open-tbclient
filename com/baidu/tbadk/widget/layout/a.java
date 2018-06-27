package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class a implements b {
    @Override // com.baidu.tbadk.widget.layout.b
    public int fH(int i) {
        if (i < 4) {
            return 1;
        }
        if (i >= 4 && i < 7) {
            return 2;
        }
        return 3;
    }

    @Override // com.baidu.tbadk.widget.layout.b
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        if (w.z(list) > 0) {
            if (i == 0) {
                return a(constrainImageLayout, list, i2);
            }
            if (i == 1) {
                return b(constrainImageLayout, list, i2);
            }
            if (i == 2) {
                return c(constrainImageLayout, list, i2);
            }
            return i2;
        }
        return i2;
    }

    private int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        if (constrainImageLayout == null || w.A(list)) {
            return i;
        }
        int z = w.z(list);
        int i2 = z - 3;
        if (z == 1) {
            constrainImageLayout.setUrls(list, i);
            return 0;
        } else if (z == 2 || z == 4 || z == 5) {
            int i3 = i + 2;
            constrainImageLayout.setUrls(w.a(list, i, i3), i);
            return i3;
        } else {
            int i4 = i + 3;
            constrainImageLayout.setUrls(w.a(list, i, i4), i);
            return i4;
        }
    }

    private int b(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        if (constrainImageLayout == null || w.A(list)) {
            return i;
        }
        if (w.z(list) == 4) {
            int i2 = i + 2;
            constrainImageLayout.setUrls(w.a(list, i, i2), i);
            return i2;
        }
        int i3 = i + 3;
        constrainImageLayout.setUrls(w.a(list, i, i3), i);
        return i3;
    }

    private int c(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        if (constrainImageLayout == null || w.A(list)) {
            return i;
        }
        int z = w.z(list);
        constrainImageLayout.setImageMaxChildCount(3);
        int i2 = z - 9;
        if (i2 > 0) {
            int i3 = i + 3;
            List<MediaData> a = w.a(list, i, i3);
            constrainImageLayout.setExtraCenterText(TbadkCoreApplication.getInst().getString(d.k.constrain_image_extra_text, new Object[]{Integer.valueOf(i2)}));
            constrainImageLayout.setUrls(a, i, true);
            return i3;
        }
        constrainImageLayout.setUrls(w.a(list, i, z), i);
        constrainImageLayout.setExtraCenterText(null);
        return z;
    }
}
