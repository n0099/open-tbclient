package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class b implements c {
    @Override // com.baidu.tbadk.widget.layout.c
    public int ls(int i) {
        if (i < 4) {
            return 1;
        }
        if (i >= 4 && i < 7) {
            return 2;
        }
        return 3;
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        if (v.Z(list) > 0) {
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
        if (constrainImageLayout == null || v.aa(list)) {
            return i;
        }
        int Z = v.Z(list);
        int i2 = Z - 3;
        if (Z == 1) {
            constrainImageLayout.setUrls(list, i);
            return 0;
        } else if (Z == 2 || Z == 4 || Z == 5) {
            int i3 = i + 2;
            constrainImageLayout.setUrls(v.c(list, i, i3), i);
            return i3;
        } else {
            int i4 = i + 3;
            constrainImageLayout.setUrls(v.c(list, i, i4), i);
            return i4;
        }
    }

    private int b(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        if (constrainImageLayout == null || v.aa(list)) {
            return i;
        }
        if (v.Z(list) == 4) {
            int i2 = i + 2;
            constrainImageLayout.setUrls(v.c(list, i, i2), i);
            return i2;
        }
        int i3 = i + 3;
        constrainImageLayout.setUrls(v.c(list, i, i3), i);
        return i3;
    }

    private int c(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        if (constrainImageLayout == null || v.aa(list)) {
            return i;
        }
        int Z = v.Z(list);
        constrainImageLayout.setImageMaxChildCount(3);
        int i2 = Z - 9;
        if (i2 > 0) {
            int i3 = i + 3;
            List<MediaData> c = v.c(list, i, i3);
            constrainImageLayout.setExtraCenterText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(i2)}));
            constrainImageLayout.setUrls(c, i, true);
            return i3;
        }
        constrainImageLayout.setUrls(v.c(list, i, Z), i);
        constrainImageLayout.setExtraCenterText(null);
        return Z;
    }
}
