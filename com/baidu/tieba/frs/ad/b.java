package com.baidu.tieba.frs.ad;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class b extends com.baidu.tieba.card.b<c> {
    private TbImageView hYT;
    private TextView hYU;
    private TextView hYV;
    private c hYW;
    protected ConstrainImageGroup hjL;
    private RelativeLayout mContainer;
    private View mDivider;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.hYT = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.hYU = (TextView) view.findViewById(R.id.ad_title);
        this.hYV = (TextView) view.findViewById(R.id.ad_desc);
        this.hjL = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.mDivider = view.findViewById(R.id.item_divider);
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.hYU, R.color.cp_cont_b);
            ap.setViewTextColor(this.hYV, R.color.cp_cont_d);
            ap.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            this.hjL.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.hjL != null) {
            this.hjL.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hjL != null) {
            this.hjL.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hjL != null) {
            this.hjL.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(c cVar) {
        if (cVar != null) {
            this.hYW = cVar;
            this.hYT.setPlaceHolder(1);
            this.hYT.startLoad(cVar.cow(), 10, false);
            this.hYT.setRadius(l.getDimens(getContext(), R.dimen.tbds26));
            this.hYT.setDrawerType(1);
            this.hYT.setDrawBorder(true);
            this.hYT.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.hYT.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.hYT.setDefaultResource(R.drawable.transparent_bg);
            this.hYT.setDefaultBgResource(R.drawable.transparent_bg);
            this.hYU.setText(cVar.cox());
            this.hYV.setText(cVar.coy());
            ap.setViewTextColor(this.hYU, R.color.cp_cont_b);
            ap.setViewTextColor(this.hYV, R.color.cp_cont_d);
            ap.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            if (y.getCount(cVar.coz()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.u(1.0d);
                this.hjL.setVisibility(0);
                this.hjL.setFromCDN(true);
                this.hjL.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.hjL.setImageProcessor(fVar);
                this.hjL.setImageMediaList(cVar.coz());
                if (!cVar.coA()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16));
                    layoutParams.addRule(12);
                    this.mDivider.setLayoutParams(layoutParams);
                    ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
                    this.mDivider.setVisibility(0);
                    return;
                }
                this.mDivider.setVisibility(8);
                return;
            }
            this.hjL.setVisibility(8);
            if (!cVar.coA()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds1));
                layoutParams2.addRule(12);
                this.mDivider.setLayoutParams(layoutParams2);
                ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
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
