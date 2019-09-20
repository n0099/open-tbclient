package com.baidu.tieba.frs.ad;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.a<c> {
    private View aOf;
    private RelativeLayout cXd;
    protected ConstrainImageGroup eEC;
    private TbImageView fAO;
    private TextView fAP;
    private TextView fAQ;
    private c fAR;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.fAO = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.fAP = (TextView) view.findViewById(R.id.ad_title);
        this.fAQ = (TextView) view.findViewById(R.id.ad_desc);
        this.eEC = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.aOf = view.findViewById(R.id.item_divider);
        this.cXd = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.j(this.fAP, R.color.cp_cont_b);
            am.j(this.fAQ, R.color.cp_cont_d);
            am.k(this.cXd, R.drawable.ad_list_item_bg);
            this.eEC.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.eEC != null) {
            this.eEC.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eEC != null) {
            this.eEC.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eEC != null) {
            this.eEC.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.fAR = cVar;
            this.fAO.startLoad(cVar.boS(), 10, false);
            this.fAO.setRadius(l.g(getContext(), R.dimen.tbds26));
            this.fAO.setDrawerType(1);
            this.fAO.setDrawBorder(true);
            this.fAO.setBorderColor(am.getColor(R.color.black_alpha15));
            this.fAO.setBorderWidth(l.g(getContext(), R.dimen.tbds1));
            this.fAO.setDefaultResource(R.drawable.transparent_bg);
            this.fAO.setDefaultBgResource(R.drawable.transparent_bg);
            this.fAP.setText(cVar.boT());
            this.fAQ.setText(cVar.boU());
            am.j(this.fAP, R.color.cp_cont_b);
            am.j(this.fAQ, R.color.cp_cont_d);
            am.k(this.cXd, R.drawable.ad_list_item_bg);
            if (v.Z(cVar.boV()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.h(1.0d);
                this.eEC.setVisibility(0);
                this.eEC.setFromCDN(true);
                this.eEC.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.eEC.setImageProcessor(fVar);
                this.eEC.setImageMediaList(cVar.boV());
                if (!cVar.boW()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.g(getContext(), R.dimen.tbds16));
                    layoutParams.addRule(12);
                    this.aOf.setLayoutParams(layoutParams);
                    am.l(this.aOf, R.color.cp_bg_line_c);
                    this.aOf.setVisibility(0);
                    return;
                }
                this.aOf.setVisibility(8);
                return;
            }
            this.eEC.setVisibility(8);
            if (!cVar.boW()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.g(getContext(), R.dimen.tbds1));
                layoutParams2.addRule(12);
                this.aOf.setLayoutParams(layoutParams2);
                am.l(this.aOf, R.color.cp_bg_line_c);
                this.aOf.setVisibility(0);
                return;
            }
            this.aOf.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
