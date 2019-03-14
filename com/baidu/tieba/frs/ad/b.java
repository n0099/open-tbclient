package com.baidu.tieba.frs.ad;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.f;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.a<c> {
    private View aLb;
    private RelativeLayout cMr;
    protected ConstrainImageGroup ein;
    private TbImageView fdE;
    private TextView fdF;
    private TextView fdG;
    private c fdH;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.fdE = (TbImageView) view.findViewById(d.g.ad_portrait);
        this.fdF = (TextView) view.findViewById(d.g.ad_title);
        this.fdG = (TextView) view.findViewById(d.g.ad_desc);
        this.ein = (ConstrainImageGroup) view.findViewById(d.g.ad_img_layout);
        this.aLb = view.findViewById(d.g.item_divider);
        this.cMr = (RelativeLayout) view.findViewById(d.g.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.j(this.fdF, d.C0277d.cp_cont_b);
            al.j(this.fdG, d.C0277d.cp_cont_d);
            al.k(this.cMr, d.f.ad_list_item_bg);
            this.ein.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.ein != null) {
            this.ein.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.ein != null) {
            this.ein.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.ein != null) {
            this.ein.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.fdH = cVar;
            this.fdE.startLoad(cVar.beD(), 10, false);
            this.fdE.setRadius(l.h(getContext(), d.e.tbds26));
            this.fdE.setDrawerType(1);
            this.fdE.setDrawBorder(true);
            this.fdE.setBorderColor(al.getColor(d.C0277d.black_alpha15));
            this.fdE.setBorderWidth(l.h(getContext(), d.e.tbds1));
            this.fdE.setDefaultResource(d.f.transparent_bg);
            this.fdE.setDefaultBgResource(d.f.transparent_bg);
            this.fdF.setText(cVar.beE());
            this.fdG.setText(cVar.beF());
            al.j(this.fdF, d.C0277d.cp_cont_b);
            al.j(this.fdG, d.C0277d.cp_cont_d);
            al.k(this.cMr, d.f.ad_list_item_bg);
            if (v.S(cVar.beG()) > 0) {
                f fVar = new f(3);
                fVar.h(1.0d);
                this.ein.setVisibility(0);
                this.ein.setFromCDN(true);
                this.ein.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
                this.ein.setImageProcessor(fVar);
                this.ein.setImageMediaList(cVar.beG());
                if (!cVar.beH()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.h(getContext(), d.e.tbds16));
                    layoutParams.addRule(12);
                    this.aLb.setLayoutParams(layoutParams);
                    al.l(this.aLb, d.C0277d.cp_bg_line_c);
                    this.aLb.setVisibility(0);
                    return;
                }
                this.aLb.setVisibility(8);
                return;
            }
            this.ein.setVisibility(8);
            if (!cVar.beH()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.h(getContext(), d.e.tbds1));
                layoutParams2.addRule(12);
                this.aLb.setLayoutParams(layoutParams2);
                al.l(this.aLb, d.C0277d.cp_bg_line_c);
                this.aLb.setVisibility(0);
                return;
            }
            this.aLb.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
