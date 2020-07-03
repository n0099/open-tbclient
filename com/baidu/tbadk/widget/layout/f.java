package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class f implements c {
    private int eLH;
    protected int eLI;
    private double eLJ;
    private boolean eLK;

    public f() {
        this.eLH = 3;
        this.eLI = this.eLH;
        this.eLK = true;
    }

    public f(int i) {
        this.eLH = 3;
        this.eLI = this.eLH;
        this.eLK = true;
        if (i > 0) {
            this.eLI = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int os(int i) {
        return 1;
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        return w.getCount(list) <= 0 ? i2 : d(constrainImageLayout, list, i2);
    }

    protected int d(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        int i2;
        if (constrainImageLayout == null || w.isEmpty(list)) {
            return i;
        }
        int count = w.getCount(list);
        if (count >= 2) {
            constrainImageLayout.setImageMaxChildCount(this.eLH);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = count - this.eLI;
        if (i3 > 0) {
            int i4 = this.eLI + i;
            List<MediaData> subList = w.subList(list, i, i4);
            String string = TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)});
            if (!this.eLK) {
                string = null;
            }
            constrainImageLayout.setExtraCenterText(string);
            constrainImageLayout.setUrls(subList, i, true, this.eLK);
            i2 = i4;
        } else {
            constrainImageLayout.setUrls(w.subList(list, i, count), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = count;
        }
        constrainImageLayout.setSingleImageRatio(ow(count));
        return i2;
    }

    private double ow(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.eLJ > 0.0d) {
            return this.eLJ;
        }
        return 0.6666666666666666d;
    }

    public void o(double d) {
        this.eLJ = d;
    }
}
