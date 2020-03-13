package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class f implements c {
    private int dMV;
    protected int dMW;
    private double dMX;
    private boolean dMY;

    public f() {
        this.dMV = 3;
        this.dMW = this.dMV;
        this.dMY = true;
    }

    public f(int i) {
        this.dMV = 3;
        this.dMW = this.dMV;
        this.dMY = true;
        if (i > 0) {
            this.dMW = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int nc(int i) {
        return 1;
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        return v.getCount(list) <= 0 ? i2 : d(constrainImageLayout, list, i2);
    }

    protected int d(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        int i2;
        if (constrainImageLayout == null || v.isEmpty(list)) {
            return i;
        }
        int count = v.getCount(list);
        if (count >= 2) {
            constrainImageLayout.setImageMaxChildCount(this.dMV);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = count - this.dMW;
        if (i3 > 0) {
            int i4 = this.dMW + i;
            List<MediaData> subList = v.subList(list, i, i4);
            String string = TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)});
            if (!this.dMY) {
                string = null;
            }
            constrainImageLayout.setExtraCenterText(string);
            constrainImageLayout.setUrls(subList, i, true, this.dMY);
            i2 = i4;
        } else {
            constrainImageLayout.setUrls(v.subList(list, i, count), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = count;
        }
        constrainImageLayout.setSingleImageRatio(ng(count));
        return i2;
    }

    private double ng(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.dMX > 0.0d) {
            return this.dMX;
        }
        return 0.6666666666666666d;
    }

    public void h(double d) {
        this.dMX = d;
    }
}
