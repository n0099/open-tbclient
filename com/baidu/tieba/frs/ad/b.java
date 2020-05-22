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
public class b extends com.baidu.tieba.card.b<c> {
    protected ConstrainImageGroup gEm;
    private TbImageView hrP;
    private TextView hrQ;
    private TextView hrR;
    private c hrS;
    private RelativeLayout mContainer;
    private View mDivider;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.hrP = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.hrQ = (TextView) view.findViewById(R.id.ad_title);
        this.hrR = (TextView) view.findViewById(R.id.ad_desc);
        this.gEm = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.mDivider = view.findViewById(R.id.item_divider);
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.hrQ, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hrR, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            this.gEm.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.gEm != null) {
            this.gEm.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gEm != null) {
            this.gEm.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gEm != null) {
            this.gEm.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(c cVar) {
        if (cVar != null) {
            this.hrS = cVar;
            this.hrP.setPlaceHolder(1);
            this.hrP.startLoad(cVar.bXg(), 10, false);
            this.hrP.setRadius(l.getDimens(getContext(), R.dimen.tbds26));
            this.hrP.setDrawerType(1);
            this.hrP.setDrawBorder(true);
            this.hrP.setBorderColor(am.getColor(R.color.black_alpha15));
            this.hrP.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.hrP.setDefaultResource(R.drawable.transparent_bg);
            this.hrP.setDefaultBgResource(R.drawable.transparent_bg);
            this.hrQ.setText(cVar.bXh());
            this.hrR.setText(cVar.bXi());
            am.setViewTextColor(this.hrQ, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hrR, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            if (v.getCount(cVar.bXj()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.o(1.0d);
                this.gEm.setVisibility(0);
                this.gEm.setFromCDN(true);
                this.gEm.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.gEm.setImageProcessor(fVar);
                this.gEm.setImageMediaList(cVar.bXj());
                if (!cVar.bXk()) {
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
            this.gEm.setVisibility(8);
            if (!cVar.bXk()) {
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
