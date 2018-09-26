package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes.dex */
public class e implements b {
    private int bgN;
    private int bgO;
    private double bgP;
    private boolean bgQ;

    public e() {
        this.bgN = 3;
        this.bgO = this.bgN;
        this.bgQ = true;
    }

    public e(int i) {
        this.bgN = 3;
        this.bgO = this.bgN;
        this.bgQ = true;
        if (i > 0) {
            this.bgO = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.b
    public int fT(int i) {
        return 1;
    }

    @Override // com.baidu.tbadk.widget.layout.b
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        return v.y(list) <= 0 ? i2 : d(constrainImageLayout, list, i2);
    }

    private int d(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        int i2;
        if (constrainImageLayout == null || v.z(list)) {
            return i;
        }
        int y = v.y(list);
        if (y >= 2) {
            constrainImageLayout.setImageMaxChildCount(this.bgN);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = y - this.bgO;
        if (i3 > 0) {
            int i4 = this.bgO + i;
            List<MediaData> b = v.b(list, i, i4);
            String string = TbadkCoreApplication.getInst().getString(e.j.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)});
            if (!this.bgQ) {
                string = null;
            }
            constrainImageLayout.setExtraCenterText(string);
            constrainImageLayout.setUrls(b, i, true, this.bgQ);
            i2 = i4;
        } else {
            constrainImageLayout.setUrls(v.b(list, i, y), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = y;
        }
        constrainImageLayout.setSingleImageRatio(fX(y));
        return i2;
    }

    private double fX(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.bgP > 0.0d) {
            return this.bgP;
        }
        return 0.6666666666666666d;
    }

    public void g(double d) {
        this.bgP = d;
    }

    public void cw(boolean z) {
        this.bgQ = z;
    }
}
