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
/* loaded from: classes21.dex */
public class b extends com.baidu.tieba.card.b<c> {
    protected ConstrainImageGroup hYG;
    private TbImageView iOg;
    private TextView iOh;
    private TextView iOi;
    private c iOj;
    private RelativeLayout mContainer;
    private View mDivider;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.iOg = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.iOh = (TextView) view.findViewById(R.id.ad_title);
        this.iOi = (TextView) view.findViewById(R.id.ad_desc);
        this.hYG = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.mDivider = view.findViewById(R.id.item_divider);
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.iOh, R.color.CAM_X0105);
            ap.setViewTextColor(this.iOi, R.color.CAM_X0109);
            ap.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            this.hYG.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.hYG != null) {
            this.hYG.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hYG != null) {
            this.hYG.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hYG != null) {
            this.hYG.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(c cVar) {
        if (cVar != null) {
            this.iOj = cVar;
            this.iOg.setPlaceHolder(1);
            this.iOg.startLoad(cVar.cAt(), 10, false);
            this.iOg.setRadius(l.getDimens(getContext(), R.dimen.tbds26));
            this.iOg.setDrawerType(1);
            this.iOg.setDrawBorder(true);
            this.iOg.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.iOg.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.iOg.setDefaultResource(R.drawable.transparent_bg);
            this.iOg.setDefaultBgResource(R.drawable.transparent_bg);
            this.iOh.setText(cVar.cAu());
            this.iOi.setText(cVar.cAv());
            ap.setViewTextColor(this.iOh, R.color.CAM_X0105);
            ap.setViewTextColor(this.iOi, R.color.CAM_X0109);
            ap.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            if (y.getCount(cVar.cAw()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.x(1.0d);
                this.hYG.setVisibility(0);
                this.hYG.setFromCDN(true);
                this.hYG.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.hYG.setImageProcessor(fVar);
                this.hYG.setImageMediaList(cVar.cAw());
                if (!cVar.cAx()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16));
                    layoutParams.addRule(12);
                    this.mDivider.setLayoutParams(layoutParams);
                    ap.setBackgroundColor(this.mDivider, R.color.CAM_X0204);
                    this.mDivider.setVisibility(0);
                    return;
                }
                this.mDivider.setVisibility(8);
                return;
            }
            this.hYG.setVisibility(8);
            if (!cVar.cAx()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds1));
                layoutParams2.addRule(12);
                this.mDivider.setLayoutParams(layoutParams2);
                ap.setBackgroundColor(this.mDivider, R.color.CAM_X0204);
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
