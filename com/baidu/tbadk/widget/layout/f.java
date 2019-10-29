package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class f implements c {
    private int cUP;
    protected int cUQ;
    private double cUR;
    private boolean cUS;

    public f() {
        this.cUP = 3;
        this.cUQ = this.cUP;
        this.cUS = true;
    }

    public f(int i) {
        this.cUP = 3;
        this.cUQ = this.cUP;
        this.cUS = true;
        if (i > 0) {
            this.cUQ = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int kx(int i) {
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
            constrainImageLayout.setImageMaxChildCount(this.cUP);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = count - this.cUQ;
        if (i3 > 0) {
            int i4 = this.cUQ + i;
            List<MediaData> subList = v.subList(list, i, i4);
            String string = TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)});
            if (!this.cUS) {
                string = null;
            }
            constrainImageLayout.setExtraCenterText(string);
            constrainImageLayout.setUrls(subList, i, true, this.cUS);
            i2 = i4;
        } else {
            constrainImageLayout.setUrls(v.subList(list, i, count), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = count;
        }
        constrainImageLayout.setSingleImageRatio(kB(count));
        return i2;
    }

    private double kB(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.cUR > 0.0d) {
            return this.cUR;
        }
        return 0.6666666666666666d;
    }

    public void g(double d) {
        this.cUR = d;
    }

    public void fJ(boolean z) {
        this.cUS = z;
    }
}
