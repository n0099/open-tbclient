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
    protected ConstrainImageGroup hYg;
    private TbImageView iNt;
    private TextView iNu;
    private TextView iNv;
    private c iNw;
    private RelativeLayout mContainer;
    private View mDivider;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.iNt = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.iNu = (TextView) view.findViewById(R.id.ad_title);
        this.iNv = (TextView) view.findViewById(R.id.ad_desc);
        this.hYg = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.mDivider = view.findViewById(R.id.item_divider);
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.iNu, R.color.cp_cont_b);
            ap.setViewTextColor(this.iNv, R.color.cp_cont_d);
            ap.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            this.hYg.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.hYg != null) {
            this.hYg.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hYg != null) {
            this.hYg.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hYg != null) {
            this.hYg.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(c cVar) {
        if (cVar != null) {
            this.iNw = cVar;
            this.iNt.setPlaceHolder(1);
            this.iNt.startLoad(cVar.cAQ(), 10, false);
            this.iNt.setRadius(l.getDimens(getContext(), R.dimen.tbds26));
            this.iNt.setDrawerType(1);
            this.iNt.setDrawBorder(true);
            this.iNt.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.iNt.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.iNt.setDefaultResource(R.drawable.transparent_bg);
            this.iNt.setDefaultBgResource(R.drawable.transparent_bg);
            this.iNu.setText(cVar.cAR());
            this.iNv.setText(cVar.cAS());
            ap.setViewTextColor(this.iNu, R.color.cp_cont_b);
            ap.setViewTextColor(this.iNv, R.color.cp_cont_d);
            ap.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            if (y.getCount(cVar.cAT()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.y(1.0d);
                this.hYg.setVisibility(0);
                this.hYg.setFromCDN(true);
                this.hYg.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.hYg.setImageProcessor(fVar);
                this.hYg.setImageMediaList(cVar.cAT());
                if (!cVar.cAU()) {
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
            this.hYg.setVisibility(8);
            if (!cVar.cAU()) {
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
