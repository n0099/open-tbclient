package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class f implements c {
    private int fSs;
    protected int fSt;
    private double fSu;
    private boolean fSv;

    public f() {
        this.fSs = 3;
        this.fSt = this.fSs;
        this.fSv = true;
    }

    public f(int i) {
        this.fSs = 3;
        this.fSt = this.fSs;
        this.fSv = true;
        if (i > 0) {
            this.fSt = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int rN(int i) {
        return 1;
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        return x.getCount(list) <= 0 ? i2 : d(constrainImageLayout, list, i2);
    }

    protected int d(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        int i2;
        if (constrainImageLayout == null || x.isEmpty(list)) {
            return i;
        }
        int count = x.getCount(list);
        if (count >= 2) {
            constrainImageLayout.setImageMaxChildCount(this.fSs);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = count - this.fSt;
        if (i3 > 0) {
            int i4 = this.fSt + i;
            List<MediaData> subList = x.subList(list, i, i4);
            String string = TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)});
            if (!this.fSv) {
                string = null;
            }
            constrainImageLayout.setExtraCenterText(string);
            constrainImageLayout.setUrls(subList, i, true, this.fSv);
            i2 = i4;
        } else {
            constrainImageLayout.setUrls(x.subList(list, i, count), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = count;
        }
        constrainImageLayout.setSingleImageRatio(rR(count));
        return i2;
    }

    private double rR(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.fSu > 0.0d) {
            return this.fSu;
        }
        return 0.6666666666666666d;
    }

    public void r(double d) {
        this.fSu = d;
    }
}
