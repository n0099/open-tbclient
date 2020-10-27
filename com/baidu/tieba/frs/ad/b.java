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
/* loaded from: classes22.dex */
public class b extends com.baidu.tieba.card.b<c> {
    protected ConstrainImageGroup hSj;
    private TbImageView iHw;
    private TextView iHx;
    private TextView iHy;
    private c iHz;
    private RelativeLayout mContainer;
    private View mDivider;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.iHw = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.iHx = (TextView) view.findViewById(R.id.ad_title);
        this.iHy = (TextView) view.findViewById(R.id.ad_desc);
        this.hSj = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.mDivider = view.findViewById(R.id.item_divider);
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.iHx, R.color.cp_cont_b);
            ap.setViewTextColor(this.iHy, R.color.cp_cont_d);
            ap.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            this.hSj.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.hSj != null) {
            this.hSj.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hSj != null) {
            this.hSj.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hSj != null) {
            this.hSj.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(c cVar) {
        if (cVar != null) {
            this.iHz = cVar;
            this.iHw.setPlaceHolder(1);
            this.iHw.startLoad(cVar.cyp(), 10, false);
            this.iHw.setRadius(l.getDimens(getContext(), R.dimen.tbds26));
            this.iHw.setDrawerType(1);
            this.iHw.setDrawBorder(true);
            this.iHw.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.iHw.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.iHw.setDefaultResource(R.drawable.transparent_bg);
            this.iHw.setDefaultBgResource(R.drawable.transparent_bg);
            this.iHx.setText(cVar.cyq());
            this.iHy.setText(cVar.cyr());
            ap.setViewTextColor(this.iHx, R.color.cp_cont_b);
            ap.setViewTextColor(this.iHy, R.color.cp_cont_d);
            ap.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            if (y.getCount(cVar.cys()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.y(1.0d);
                this.hSj.setVisibility(0);
                this.hSj.setFromCDN(true);
                this.hSj.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.hSj.setImageProcessor(fVar);
                this.hSj.setImageMediaList(cVar.cys());
                if (!cVar.cyt()) {
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
            this.hSj.setVisibility(8);
            if (!cVar.cyt()) {
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
