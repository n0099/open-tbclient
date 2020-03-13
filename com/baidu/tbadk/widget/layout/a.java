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
    private static final int dLF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private int dLG;
    ConstrainImageLayout.a dLH;

    public a(int i) {
        super(i);
        this.dLG = 0;
        this.dLH = new ConstrainImageLayout.a() { // from class: com.baidu.tbadk.widget.layout.a.1
            @Override // com.baidu.tbadk.widget.layout.ConstrainImageLayout.a
            public void a(TbImageView tbImageView, int i2) {
                tbImageView.setRadius(a.dLF);
                tbImageView.aST();
                tbImageView.setDrawCorner(true);
                tbImageView.mU(15);
            }
        };
    }

    @Override // com.baidu.tbadk.widget.layout.f, com.baidu.tbadk.widget.layout.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        this.dLG = list.size() < this.dMW ? list.size() : this.dMW;
        constrainImageLayout.setTbImageViewConfiguration(this.dLH);
        return super.a(constrainImageLayout, list, i, i2);
    }
}
