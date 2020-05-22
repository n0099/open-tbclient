package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class f implements c {
    private int eBN;
    protected int eBO;
    private double eBP;
    private boolean eBQ;

    public f() {
        this.eBN = 3;
        this.eBO = this.eBN;
        this.eBQ = true;
    }

    public f(int i) {
        this.eBN = 3;
        this.eBO = this.eBN;
        this.eBQ = true;
        if (i > 0) {
            this.eBO = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int nT(int i) {
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
            constrainImageLayout.setImageMaxChildCount(this.eBN);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = count - this.eBO;
        if (i3 > 0) {
            int i4 = this.eBO + i;
            List<MediaData> subList = v.subList(list, i, i4);
            String string = TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)});
            if (!this.eBQ) {
                string = null;
            }
            constrainImageLayout.setExtraCenterText(string);
            constrainImageLayout.setUrls(subList, i, true, this.eBQ);
            i2 = i4;
        } else {
            constrainImageLayout.setUrls(v.subList(list, i, count), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = count;
        }
        constrainImageLayout.setSingleImageRatio(nX(count));
        return i2;
    }

    private double nX(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.eBP > 0.0d) {
            return this.eBP;
        }
        return 0.6666666666666666d;
    }

    public void o(double d) {
        this.eBP = d;
    }
}
