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
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.a<c> {
    protected ConstrainImageGroup fKc;
    private TbImageView gtg;
    private TextView gth;
    private TextView gti;
    private c gtj;
    private RelativeLayout mContainer;
    private View mDivider;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.gtg = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.gth = (TextView) view.findViewById(R.id.ad_title);
        this.gti = (TextView) view.findViewById(R.id.ad_desc);
        this.fKc = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.mDivider = view.findViewById(R.id.item_divider);
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.gth, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gti, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            this.fKc.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.fKc != null) {
            this.fKc.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fKc != null) {
            this.fKc.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fKc != null) {
            this.fKc.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.gtj = cVar;
            this.gtg.setPlaceHolder(1);
            this.gtg.startLoad(cVar.bFY(), 10, false);
            this.gtg.setRadius(l.getDimens(getContext(), R.dimen.tbds26));
            this.gtg.setDrawerType(1);
            this.gtg.setDrawBorder(true);
            this.gtg.setBorderColor(am.getColor(R.color.black_alpha15));
            this.gtg.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.gtg.setDefaultResource(R.drawable.transparent_bg);
            this.gtg.setDefaultBgResource(R.drawable.transparent_bg);
            this.gth.setText(cVar.bFZ());
            this.gti.setText(cVar.bGa());
            am.setViewTextColor(this.gth, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gti, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            if (v.getCount(cVar.bGb()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.h(1.0d);
                this.fKc.setVisibility(0);
                this.fKc.setFromCDN(true);
                this.fKc.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.fKc.setImageProcessor(fVar);
                this.fKc.setImageMediaList(cVar.bGb());
                if (!cVar.bGc()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16));
                    layoutParams.addRule(12);
                    this.mDivider.setLayoutParams(layoutParams);
                    am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
                    this.mDivider.setVisibility(0);
                    return;
                }
                this.mDivider.setVisibility(8);
                return;
            }
            this.fKc.setVisibility(8);
            if (!cVar.bGc()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds1));
                layoutParams2.addRule(12);
                this.mDivider.setLayoutParams(layoutParams2);
                am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
                this.mDivider.setVisibility(0);
                return;
            }
            this.mDivider.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
