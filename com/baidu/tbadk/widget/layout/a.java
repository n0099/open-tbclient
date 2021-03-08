package com.baidu.tbadk.widget.layout;

import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class a extends f {
    private int fUT;
    ConstrainImageLayout.a fUU;

    public a(int i) {
        super(i);
        this.fUT = 0;
        this.fUU = new ConstrainImageLayout.a() { // from class: com.baidu.tbadk.widget.layout.a.1
            @Override // com.baidu.tbadk.widget.layout.ConstrainImageLayout.a
            public void a(TbImageView tbImageView, int i2, int i3) {
                tbImageView.setRadiusById(R.string.J_X05);
                tbImageView.bGs();
                tbImageView.setDrawCorner(true);
                tbImageView.setConrers(0);
                if (i3 == 1) {
                    tbImageView.setConrers(15);
                } else if (i3 > 1) {
                    if (i2 == 0) {
                        tbImageView.setConrers(5);
                    } else if (i2 == i3 - 1) {
                        tbImageView.setConrers(10);
                    }
                }
            }
        };
    }

    @Override // com.baidu.tbadk.widget.layout.f, com.baidu.tbadk.widget.layout.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        this.fUT = list.size() < this.fWi ? list.size() : this.fWi;
        constrainImageLayout.setTbImageViewConfiguration(this.fUU);
        return super.a(constrainImageLayout, list, i, i2);
    }
}
