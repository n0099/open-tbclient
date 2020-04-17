package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class f implements c {
    private int ene;
    protected int enf;
    private double eng;
    private boolean enh;

    public f() {
        this.ene = 3;
        this.enf = this.ene;
        this.enh = true;
    }

    public f(int i) {
        this.ene = 3;
        this.enf = this.ene;
        this.enh = true;
        if (i > 0) {
            this.enf = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.c
    public int nq(int i) {
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
            constrainImageLayout.setImageMaxChildCount(this.ene);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = count - this.enf;
        if (i3 > 0) {
            int i4 = this.enf + i;
            List<MediaData> subList = v.subList(list, i, i4);
            String string = TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)});
            if (!this.enh) {
                string = null;
            }
            constrainImageLayout.setExtraCenterText(string);
            constrainImageLayout.setUrls(subList, i, true, this.enh);
            i2 = i4;
        } else {
            constrainImageLayout.setUrls(v.subList(list, i, count), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = count;
        }
        constrainImageLayout.setSingleImageRatio(nu(count));
        return i2;
    }

    private double nu(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.eng > 0.0d) {
            return this.eng;
        }
        return 0.6666666666666666d;
    }

    public void n(double d) {
        this.eng = d;
    }
}
