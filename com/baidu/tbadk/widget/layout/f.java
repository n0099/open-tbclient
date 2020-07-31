package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class f implements c {
    private int eSc;
    protected int eSd;
    private double eSe;
    private boolean eSf;

    public f() {
        this.eSc = 3;
        this.eSd = this.eSc;
        this.eSf = true;
    }

    public f(int i) {
        this.eSc = 3;
        this.eSd = this.eSc;
        this.eSf = true;
        if (i > 0) {
            this.eSd = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int oL(int i) {
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
            constrainImageLayout.setImageMaxChildCount(this.eSc);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = count - this.eSd;
        if (i3 > 0) {
            int i4 = this.eSd + i;
            List<MediaData> subList = x.subList(list, i, i4);
            String string = TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)});
            if (!this.eSf) {
                string = null;
            }
            constrainImageLayout.setExtraCenterText(string);
            constrainImageLayout.setUrls(subList, i, true, this.eSf);
            i2 = i4;
        } else {
            constrainImageLayout.setUrls(x.subList(list, i, count), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = count;
        }
        constrainImageLayout.setSingleImageRatio(oP(count));
        return i2;
    }

    private double oP(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.eSe > 0.0d) {
            return this.eSe;
        }
        return 0.6666666666666666d;
    }

    public void o(double d) {
        this.eSe = d;
    }
}
