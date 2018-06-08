package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class e implements b {
    private int bbV;
    private int bbW;
    private double bbX;

    public e() {
        this.bbV = 3;
        this.bbW = this.bbV;
    }

    public e(int i) {
        this.bbV = 3;
        this.bbW = this.bbV;
        if (i > 0) {
            this.bbW = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.b
    public int fG(int i) {
        return 1;
    }

    @Override // com.baidu.tbadk.widget.layout.b
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        return w.y(list) <= 0 ? i2 : d(constrainImageLayout, list, i2);
    }

    private int d(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        int i2;
        if (constrainImageLayout == null || w.z(list)) {
            return i;
        }
        int y = w.y(list);
        if (y >= 2) {
            constrainImageLayout.setImageMaxChildCount(this.bbV);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = y - this.bbW;
        if (i3 > 0) {
            i2 = this.bbW + i;
            List<MediaData> a = w.a(list, i, i2);
            constrainImageLayout.setExtraCenterText(TbadkCoreApplication.getInst().getString(d.k.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)}));
            constrainImageLayout.setUrls(a, i, true);
        } else {
            constrainImageLayout.setUrls(w.a(list, i, y), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = y;
        }
        constrainImageLayout.setSingleImageRatio(fK(y));
        return i2;
    }

    private double fK(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.bbX > 0.0d) {
            return this.bbX;
        }
        return 0.6666666666666666d;
    }

    public void j(double d) {
        this.bbX = d;
    }
}
