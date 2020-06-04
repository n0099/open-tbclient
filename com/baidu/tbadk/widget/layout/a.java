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
    private static final int eAH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private int eAI;
    ConstrainImageLayout.a eAJ;

    public a(int i) {
        super(i);
        this.eAI = 0;
        this.eAJ = new ConstrainImageLayout.a() { // from class: com.baidu.tbadk.widget.layout.a.1
            @Override // com.baidu.tbadk.widget.layout.ConstrainImageLayout.a
            public void a(TbImageView tbImageView, int i2) {
                tbImageView.setRadius(a.eAH);
                tbImageView.bhs();
                tbImageView.setDrawCorner(true);
                tbImageView.nM(15);
            }
        };
    }

    @Override // com.baidu.tbadk.widget.layout.f, com.baidu.tbadk.widget.layout.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        this.eAI = list.size() < this.eBZ ? list.size() : this.eBZ;
        constrainImageLayout.setTbImageViewConfiguration(this.eAJ);
        return super.a(constrainImageLayout, list, i, i2);
    }
}
