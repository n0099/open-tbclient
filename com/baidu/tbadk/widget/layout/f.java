package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class f implements c {
    private int fNv;
    protected int fNw;
    private double fNx;
    private boolean fNy;

    public f() {
        this.fNv = 3;
        this.fNw = this.fNv;
        this.fNy = true;
    }

    public f(int i) {
        this.fNv = 3;
        this.fNw = this.fNv;
        this.fNy = true;
        if (i > 0) {
            this.fNw = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int ti(int i) {
        return 1;
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        return y.getCount(list) <= 0 ? i2 : d(constrainImageLayout, list, i2);
    }

    protected int d(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        int i2;
        if (constrainImageLayout == null || y.isEmpty(list)) {
            return i;
        }
        int count = y.getCount(list);
        if (count >= 2) {
            constrainImageLayout.setImageMaxChildCount(this.fNv);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = count - this.fNw;
        if (i3 > 0) {
            int i4 = this.fNw + i;
            List<MediaData> subList = y.subList(list, i, i4);
            String string = TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)});
            if (!this.fNy) {
                string = null;
            }
            constrainImageLayout.setExtraCenterText(string);
            constrainImageLayout.setUrls(subList, i, true, this.fNy);
            i2 = i4;
        } else {
            constrainImageLayout.setUrls(y.subList(list, i, count), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = count;
        }
        constrainImageLayout.setSingleImageRatio(tm(count));
        return i2;
    }

    private double tm(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.fNx > 0.0d) {
            return this.fNx;
        }
        return 0.6666666666666666d;
    }

    public void x(double d) {
        this.fNx = d;
    }
}
