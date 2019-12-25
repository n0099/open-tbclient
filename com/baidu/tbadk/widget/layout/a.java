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
    private static final int dHd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private int dHe;
    ConstrainImageLayout.a dHf;

    public a(int i) {
        super(i);
        this.dHe = 0;
        this.dHf = new ConstrainImageLayout.a() { // from class: com.baidu.tbadk.widget.layout.a.1
            @Override // com.baidu.tbadk.widget.layout.ConstrainImageLayout.a
            public void a(TbImageView tbImageView, int i2) {
                tbImageView.setRadius(a.dHd);
                tbImageView.aQg();
                tbImageView.setDrawCorner(true);
                tbImageView.mD(15);
            }
        };
    }

    @Override // com.baidu.tbadk.widget.layout.f, com.baidu.tbadk.widget.layout.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        this.dHe = list.size() < this.dIu ? list.size() : this.dIu;
        constrainImageLayout.setTbImageViewConfiguration(this.dHf);
        return super.a(constrainImageLayout, list, i, i2);
    }
}
