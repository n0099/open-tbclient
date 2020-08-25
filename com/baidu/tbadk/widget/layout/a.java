package com.baidu.tbadk.widget.layout;

import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends f {
    private static final int fbs = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private int fbt;
    ConstrainImageLayout.a fbu;

    public a(int i) {
        super(i);
        this.fbt = 0;
        this.fbu = new ConstrainImageLayout.a() { // from class: com.baidu.tbadk.widget.layout.a.1
            @Override // com.baidu.tbadk.widget.layout.ConstrainImageLayout.a
            public void a(TbImageView tbImageView, int i2) {
                tbImageView.setRadius(a.fbs);
                tbImageView.bwm();
                tbImageView.setDrawCorner(true);
                tbImageView.qN(15);
            }
        };
    }

    @Override // com.baidu.tbadk.widget.layout.f, com.baidu.tbadk.widget.layout.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        this.fbt = list.size() < this.fcK ? list.size() : this.fcK;
        constrainImageLayout.setTbImageViewConfiguration(this.fbu);
        return super.a(constrainImageLayout, list, i, i2);
    }
}
