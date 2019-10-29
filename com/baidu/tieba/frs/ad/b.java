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
    private View bhm;
    protected ConstrainImageGroup eNi;
    private TbImageView fAc;
    private TextView fAd;
    private TextView fAe;
    private c fAf;
    private RelativeLayout mContainer;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.fAc = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.fAd = (TextView) view.findViewById(R.id.ad_title);
        this.fAe = (TextView) view.findViewById(R.id.ad_desc);
        this.eNi = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.bhm = view.findViewById(R.id.item_divider);
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.fAd, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fAe, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            this.eNi.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.eNi != null) {
            this.eNi.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eNi != null) {
            this.eNi.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eNi != null) {
            this.eNi.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.fAf = cVar;
            this.fAc.startLoad(cVar.blW(), 10, false);
            this.fAc.setRadius(l.getDimens(getContext(), R.dimen.tbds26));
            this.fAc.setDrawerType(1);
            this.fAc.setDrawBorder(true);
            this.fAc.setBorderColor(am.getColor(R.color.black_alpha15));
            this.fAc.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.fAc.setDefaultResource(R.drawable.transparent_bg);
            this.fAc.setDefaultBgResource(R.drawable.transparent_bg);
            this.fAd.setText(cVar.blX());
            this.fAe.setText(cVar.blY());
            am.setViewTextColor(this.fAd, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fAe, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            if (v.getCount(cVar.blZ()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.g(1.0d);
                this.eNi.setVisibility(0);
                this.eNi.setFromCDN(true);
                this.eNi.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.eNi.setImageProcessor(fVar);
                this.eNi.setImageMediaList(cVar.blZ());
                if (!cVar.bma()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16));
                    layoutParams.addRule(12);
                    this.bhm.setLayoutParams(layoutParams);
                    am.setBackgroundColor(this.bhm, R.color.cp_bg_line_c);
                    this.bhm.setVisibility(0);
                    return;
                }
                this.bhm.setVisibility(8);
                return;
            }
            this.eNi.setVisibility(8);
            if (!cVar.bma()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds1));
                layoutParams2.addRule(12);
                this.bhm.setLayoutParams(layoutParams2);
                am.setBackgroundColor(this.bhm, R.color.cp_bg_line_c);
                this.bhm.setVisibility(0);
                return;
            }
            this.bhm.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
