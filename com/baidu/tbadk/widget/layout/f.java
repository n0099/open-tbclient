package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class f implements c {
    private int fFJ;
    protected int fFK;
    private double fFL;
    private boolean fFM;

    public f() {
        this.fFJ = 3;
        this.fFK = this.fFJ;
        this.fFM = true;
    }

    public f(int i) {
        this.fFJ = 3;
        this.fFK = this.fFJ;
        this.fFM = true;
        if (i > 0) {
            this.fFK = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int sF(int i) {
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
            constrainImageLayout.setImageMaxChildCount(this.fFJ);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = count - this.fFK;
        if (i3 > 0) {
            int i4 = this.fFK + i;
            List<MediaData> subList = y.subList(list, i, i4);
            String string = TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)});
            if (!this.fFM) {
                string = null;
            }
            constrainImageLayout.setExtraCenterText(string);
            constrainImageLayout.setUrls(subList, i, true, this.fFM);
            i2 = i4;
        } else {
            constrainImageLayout.setUrls(y.subList(list, i, count), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = count;
        }
        constrainImageLayout.setSingleImageRatio(sJ(count));
        return i2;
    }

    private double sJ(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.fFL > 0.0d) {
            return this.fFL;
        }
        return 0.6666666666666666d;
    }

    public void x(double d) {
        this.fFL = d;
    }
}
