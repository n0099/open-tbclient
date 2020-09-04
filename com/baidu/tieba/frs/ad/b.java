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
    private TbImageView hYZ;
    private TextView hZa;
    private TextView hZb;
    private c hZc;
    protected ConstrainImageGroup hjP;
    private RelativeLayout mContainer;
    private View mDivider;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.hYZ = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.hZa = (TextView) view.findViewById(R.id.ad_title);
        this.hZb = (TextView) view.findViewById(R.id.ad_desc);
        this.hjP = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.mDivider = view.findViewById(R.id.item_divider);
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.hZa, R.color.cp_cont_b);
            ap.setViewTextColor(this.hZb, R.color.cp_cont_d);
            ap.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            this.hjP.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.hjP != null) {
            this.hjP.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hjP != null) {
            this.hjP.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hjP != null) {
            this.hjP.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(c cVar) {
        if (cVar != null) {
            this.hZc = cVar;
            this.hYZ.setPlaceHolder(1);
            this.hYZ.startLoad(cVar.cox(), 10, false);
            this.hYZ.setRadius(l.getDimens(getContext(), R.dimen.tbds26));
            this.hYZ.setDrawerType(1);
            this.hYZ.setDrawBorder(true);
            this.hYZ.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.hYZ.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.hYZ.setDefaultResource(R.drawable.transparent_bg);
            this.hYZ.setDefaultBgResource(R.drawable.transparent_bg);
            this.hZa.setText(cVar.coy());
            this.hZb.setText(cVar.coz());
            ap.setViewTextColor(this.hZa, R.color.cp_cont_b);
            ap.setViewTextColor(this.hZb, R.color.cp_cont_d);
            ap.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            if (y.getCount(cVar.coA()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.u(1.0d);
                this.hjP.setVisibility(0);
                this.hjP.setFromCDN(true);
                this.hjP.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.hjP.setImageProcessor(fVar);
                this.hjP.setImageMediaList(cVar.coA());
                if (!cVar.coB()) {
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
            this.hjP.setVisibility(8);
            if (!cVar.coB()) {
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
