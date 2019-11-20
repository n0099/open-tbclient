package com.baidu.tbadk.widget.layout;

import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class a extends f {
    private static final int cSN = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private int cSO;
    ConstrainImageLayout.a cSP;

    public a(int i) {
        super(i);
        this.cSO = 0;
        this.cSP = new ConstrainImageLayout.a() { // from class: com.baidu.tbadk.widget.layout.a.1
            @Override // com.baidu.tbadk.widget.layout.ConstrainImageLayout.a
            public void a(TbImageView tbImageView, int i2) {
                tbImageView.setRadius(a.cSN);
                tbImageView.ayh();
                tbImageView.setDrawCorner(true);
                if (i2 == 0) {
                    tbImageView.ko(5);
                }
                if (i2 == a.this.cSO - 1) {
                    tbImageView.ko(10);
                }
            }
        };
    }

    @Override // com.baidu.tbadk.widget.layout.f, com.baidu.tbadk.widget.layout.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        this.cSO = list.size() < this.cTZ ? list.size() : this.cTZ;
        constrainImageLayout.setTbImageViewConfiguration(this.cSP);
        return super.a(constrainImageLayout, list, i, i2);
    }
}
