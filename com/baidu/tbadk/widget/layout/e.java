package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes.dex */
public class e implements b {
    private int bpl;
    private int bpm;
    private double bpn;
    private boolean bpo;

    public e() {
        this.bpl = 3;
        this.bpm = this.bpl;
        this.bpo = true;
    }

    public e(int i) {
        this.bpl = 3;
        this.bpm = this.bpl;
        this.bpo = true;
        if (i > 0) {
            this.bpm = i;
        }
    }

    @Override // com.baidu.tbadk.widget.layout.b
    public int gE(int i) {
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
            constrainImageLayout.setImageMaxChildCount(this.bpl);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = H - this.bpm;
        if (i3 > 0) {
            int i4 = this.bpm + i;
            List<MediaData> b = v.b(list, i, i4);
            String string = TbadkCoreApplication.getInst().getString(e.j.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)});
            if (!this.bpo) {
                string = null;
            }
            constrainImageLayout.setExtraCenterText(string);
            constrainImageLayout.setUrls(b, i, true, this.bpo);
            i2 = i4;
        } else {
            constrainImageLayout.setUrls(v.b(list, i, H), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = H;
        }
        constrainImageLayout.setSingleImageRatio(gI(H));
        return i2;
    }

    private double gI(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        if (this.bpn > 0.0d) {
            return this.bpn;
        }
        return 0.6666666666666666d;
    }

    public void g(double d) {
        this.bpn = d;
    }

    public void cX(boolean z) {
        this.bpo = z;
    }
}
