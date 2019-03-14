package com.baidu.tbadk.widget.layout;

import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class a extends f {
    private static final int czA = l.h(TbadkCoreApplication.getInst(), d.e.tbds20);
    private int czB;
    ConstrainImageLayout.a czC;

    public a(int i) {
        super(i);
        this.czB = 0;
        this.czC = new ConstrainImageLayout.a() { // from class: com.baidu.tbadk.widget.layout.a.1
            @Override // com.baidu.tbadk.widget.layout.ConstrainImageLayout.a
            public void a(TbImageView tbImageView, int i2) {
                tbImageView.setRadius(a.czA);
                tbImageView.clearCornerFlag();
                tbImageView.setDrawCorner(true);
                if (i2 == 0) {
                    tbImageView.addCornerFlags(5);
                }
                if (i2 == a.this.czB - 1) {
                    tbImageView.addCornerFlags(10);
                }
            }
        };
    }

    @Override // com.baidu.tbadk.widget.layout.f, com.baidu.tbadk.widget.layout.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        this.czB = list.size() < this.cAN ? list.size() : this.cAN;
        constrainImageLayout.setTbImageViewConfiguration(this.czC);
        return super.a(constrainImageLayout, list, i, i2);
    }
}
