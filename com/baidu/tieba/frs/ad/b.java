package com.baidu.tieba.frs.ad;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.a<c> {
    private View bHR;
    private RelativeLayout bmp;
    protected ConstrainImageGroup cze;
    private TbImageView dqk;
    private TextView dql;
    private TextView dqm;
    private c dqn;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.dqk = (TbImageView) view.findViewById(d.g.ad_portrait);
        this.dql = (TextView) view.findViewById(d.g.ad_title);
        this.dqm = (TextView) view.findViewById(d.g.ad_desc);
        this.cze = (ConstrainImageGroup) view.findViewById(d.g.ad_img_layout);
        this.bHR = view.findViewById(d.g.item_divider);
        this.bmp = (RelativeLayout) view.findViewById(d.g.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.h(this.dql, d.C0140d.cp_cont_b);
            am.h(this.dqm, d.C0140d.cp_cont_d);
            am.i(this.bmp, d.f.ad_list_item_bg);
            this.cze.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.cze != null) {
            this.cze.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cze != null) {
            this.cze.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cze != null) {
            this.cze.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.dqn = cVar;
            this.dqk.startLoad(cVar.avV(), 10, false);
            this.dqk.setRadius(l.f(getContext(), d.e.tbds26));
            this.dqk.setDrawerType(1);
            this.dqk.setDrawBorder(true);
            this.dqk.setBorderColor(am.getColor(d.C0140d.black_alpha15));
            this.dqk.setBorderWidth(l.f(getContext(), d.e.tbds1));
            this.dqk.setDefaultResource(d.f.transparent_bg);
            this.dqk.setDefaultBgResource(d.f.transparent_bg);
            this.dql.setText(cVar.avW());
            this.dqm.setText(cVar.avX());
            am.h(this.dql, d.C0140d.cp_cont_b);
            am.h(this.dqm, d.C0140d.cp_cont_d);
            am.i(this.bmp, d.f.ad_list_item_bg);
            if (w.y(cVar.avY()) > 0) {
                com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
                eVar.h(1.0d);
                this.cze.setVisibility(0);
                this.cze.setFromCDN(true);
                this.cze.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
                this.cze.setImageProcessor(eVar);
                this.cze.setImageMediaList(cVar.avY());
                if (!cVar.avZ()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.f(getContext(), d.e.tbds16));
                    layoutParams.addRule(12);
                    this.bHR.setLayoutParams(layoutParams);
                    am.j(this.bHR, d.C0140d.cp_bg_line_c);
                    this.bHR.setVisibility(0);
                    return;
                }
                this.bHR.setVisibility(8);
                return;
            }
            this.cze.setVisibility(8);
            if (!cVar.avZ()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.f(getContext(), d.e.tbds1));
                layoutParams2.addRule(12);
                this.bHR.setLayoutParams(layoutParams2);
                am.j(this.bHR, d.C0140d.cp_bg_line_c);
                this.bHR.setVisibility(0);
                return;
            }
            this.bHR.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
