package com.baidu.tieba.homepage.listview.card.g;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.homepage.listview.card.g.b;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.homepage.listview.c<b> {
    public List<c> bAQ;
    public ViewGroup bBp;
    public TbImageView bBq;
    public TextView bBr;
    public TextView bBs;
    public ViewGroup bzs;

    public f(TbPageContext<?> tbPageContext, View view) {
        super(tbPageContext, view);
        this.bzs = null;
        this.bBp = null;
        this.bBq = null;
        this.bBr = null;
        this.bBs = null;
        this.bAQ = null;
        this.bzs = (ViewGroup) view.findViewById(n.f.hot_topic_banner_root);
        this.bBp = (ViewGroup) view.findViewById(n.f.banner_area_root);
        this.bBq = (TbImageView) view.findViewById(n.f.hottopic_banner_pic);
        this.bBq.setDrawBorder(true);
        this.bBq.setBorderColor(as.getColor(n.c.black_alpha15));
        this.bBq.setBorderWidth(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds1));
        this.bBq.setAlpha(n.c.black_alpha15);
        this.bBr = (TextView) view.findViewById(n.f.banner_topic_name);
        this.bBr.setShadowLayer(1.0f, 0.0f, 1.0f, n.c.black_alpha80);
        this.bBr.setEnabled(false);
        this.bBs = (TextView) view.findViewById(n.f.banner_topic_discuss);
        this.bBs.setShadowLayer(1.0f, 0.0f, 1.0f, n.c.black_alpha80);
        this.bBs.setEnabled(false);
        this.bAQ = new ArrayList();
        TX();
    }

    private void TX() {
        as.b(this.bBr, n.c.cp_cont_i, 1);
        as.b(this.bBs, n.c.cp_cont_i, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.homepage.listview.c
    /* renamed from: a */
    public void c(b bVar) {
        super.D(bVar);
        if (bVar != null) {
            if (StringUtils.isNull(bVar.bAU)) {
                this.bBp.setVisibility(8);
            } else {
                this.bBp.setVisibility(0);
            }
            this.bBq.d(bVar.bAU, 10, false);
            this.bBq.setOnClickListener(new g(this, bVar));
            this.bBr.setText(bVar.bAW);
            this.bBs.setText(String.valueOf(ax.B(bVar.bAX)) + "人参与");
            com.baidu.tieba.homepage.fragment.a.b.a(this.pageContext.getPageActivity(), this.bzs, bVar.bAZ, b.C0064b.class, this.bAQ, c.class);
        }
    }

    @Override // com.baidu.tieba.homepage.listview.c
    public void cZ(int i) {
        if (this.mSkinType != i) {
            TX();
            if (this.bAQ != null) {
                for (c cVar : this.bAQ) {
                    if (cVar != null) {
                        cVar.cZ(i);
                    }
                }
            }
        }
        super.cZ(i);
    }
}
