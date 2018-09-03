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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.a<c> {
    private View bHR;
    private RelativeLayout bmt;
    protected ConstrainImageGroup czb;
    private TbImageView dqi;
    private TextView dqj;
    private TextView dqk;
    private c dql;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.dqi = (TbImageView) view.findViewById(f.g.ad_portrait);
        this.dqj = (TextView) view.findViewById(f.g.ad_title);
        this.dqk = (TextView) view.findViewById(f.g.ad_desc);
        this.czb = (ConstrainImageGroup) view.findViewById(f.g.ad_img_layout);
        this.bHR = view.findViewById(f.g.item_divider);
        this.bmt = (RelativeLayout) view.findViewById(f.g.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.h(this.dqj, f.d.cp_cont_b);
            am.h(this.dqk, f.d.cp_cont_d);
            am.i(this.bmt, f.C0146f.ad_list_item_bg);
            this.czb.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.czb != null) {
            this.czb.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.czb != null) {
            this.czb.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.czb != null) {
            this.czb.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.dql = cVar;
            this.dqi.startLoad(cVar.avU(), 10, false);
            this.dqi.setRadius(l.f(getContext(), f.e.tbds26));
            this.dqi.setDrawerType(1);
            this.dqi.setDrawBorder(true);
            this.dqi.setBorderColor(am.getColor(f.d.black_alpha15));
            this.dqi.setBorderWidth(l.f(getContext(), f.e.tbds1));
            this.dqi.setDefaultResource(f.C0146f.transparent_bg);
            this.dqi.setDefaultBgResource(f.C0146f.transparent_bg);
            this.dqj.setText(cVar.avV());
            this.dqk.setText(cVar.avW());
            am.h(this.dqj, f.d.cp_cont_b);
            am.h(this.dqk, f.d.cp_cont_d);
            am.i(this.bmt, f.C0146f.ad_list_item_bg);
            if (w.y(cVar.avX()) > 0) {
                com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
                eVar.g(1.0d);
                this.czb.setVisibility(0);
                this.czb.setFromCDN(true);
                this.czb.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.tbds20));
                this.czb.setImageProcessor(eVar);
                this.czb.setImageMediaList(cVar.avX());
                if (!cVar.avY()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.f(getContext(), f.e.tbds16));
                    layoutParams.addRule(12);
                    this.bHR.setLayoutParams(layoutParams);
                    am.j(this.bHR, f.d.cp_bg_line_c);
                    this.bHR.setVisibility(0);
                    return;
                }
                this.bHR.setVisibility(8);
                return;
            }
            this.czb.setVisibility(8);
            if (!cVar.avY()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.f(getContext(), f.e.tbds1));
                layoutParams2.addRule(12);
                this.bHR.setLayoutParams(layoutParams2);
                am.j(this.bHR, f.d.cp_bg_line_c);
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
