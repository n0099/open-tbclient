package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class f implements c {
    private int fGh;
    protected int fGi;
    private double fGj;
    private boolean fGk;

    public f() {
        this.fGh = 3;
        this.fGi = this.fGh;
        this.fGk = true;
    }

    public f(int i) {
        this.fGh = 3;
        this.fGi = this.fGh;
        this.fGk = true;
        if (i > 0) {
            this.fGi = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int sh(int i) {
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
            constrainImageLayout.setImageMaxChildCount(this.fGh);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = count - this.fGi;
        if (i3 > 0) {
            int i4 = this.fGi + i;
            List<MediaData> subList = y.subList(list, i, i4);
            String string = TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)});
            if (!this.fGk) {
                string = null;
            }
            constrainImageLayout.setExtraCenterText(string);
            constrainImageLayout.setUrls(subList, i, true, this.fGk);
            i2 = i4;
        } else {
            constrainImageLayout.setUrls(y.subList(list, i, count), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = count;
        }
        constrainImageLayout.setSingleImageRatio(sl(count));
        return i2;
    }

    private double sl(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.fGj > 0.0d) {
            return this.fGj;
        }
        return 0.6666666666666666d;
    }

    public void y(double d) {
        this.fGj = d;
    }
}
