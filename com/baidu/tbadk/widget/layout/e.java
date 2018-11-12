package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes.dex */
public class e implements b {
    private int blN;
    private int blO;
    private double blP;
    private boolean blQ;

    public e() {
        this.blN = 3;
        this.blO = this.blN;
        this.blQ = true;
    }

    public e(int i) {
        this.blN = 3;
        this.blO = this.blN;
        this.blQ = true;
        if (i > 0) {
            this.blO = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.b
    public int gq(int i) {
        return 1;
    }

    @Override // com.baidu.tbadk.widget.layout.b
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        return v.H(list) <= 0 ? i2 : d(constrainImageLayout, list, i2);
    }

    private int d(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        int i2;
        if (constrainImageLayout == null || v.I(list)) {
            return i;
        }
        int H = v.H(list);
        if (H >= 2) {
            constrainImageLayout.setImageMaxChildCount(this.blN);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = H - this.blO;
        if (i3 > 0) {
            int i4 = this.blO + i;
            List<MediaData> b = v.b(list, i, i4);
            String string = TbadkCoreApplication.getInst().getString(e.j.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)});
            if (!this.blQ) {
                string = null;
            }
            constrainImageLayout.setExtraCenterText(string);
            constrainImageLayout.setUrls(b, i, true, this.blQ);
            i2 = i4;
        } else {
            constrainImageLayout.setUrls(v.b(list, i, H), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = H;
        }
        constrainImageLayout.setSingleImageRatio(gu(H));
        return i2;
    }

    private double gu(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.blP > 0.0d) {
            return this.blP;
        }
        return 0.6666666666666666d;
    }

    public void g(double d) {
        this.blP = d;
    }

    public void cW(boolean z) {
        this.blQ = z;
    }
}
