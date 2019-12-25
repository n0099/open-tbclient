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
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.a<c> {
    protected ConstrainImageGroup fEg;
    private TbImageView gnH;
    private TextView gnI;
    private TextView gnJ;
    private c gnK;
    private RelativeLayout mContainer;
    private View mDivider;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.gnH = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.gnI = (TextView) view.findViewById(R.id.ad_title);
        this.gnJ = (TextView) view.findViewById(R.id.ad_desc);
        this.fEg = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.mDivider = view.findViewById(R.id.item_divider);
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.gnI, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gnJ, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            this.fEg.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.fEg != null) {
            this.fEg.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fEg != null) {
            this.fEg.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fEg != null) {
            this.fEg.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.gnK = cVar;
            this.gnH.setPlaceHolder(1);
            this.gnH.startLoad(cVar.bDr(), 10, false);
            this.gnH.setRadius(l.getDimens(getContext(), R.dimen.tbds26));
            this.gnH.setDrawerType(1);
            this.gnH.setDrawBorder(true);
            this.gnH.setBorderColor(am.getColor(R.color.black_alpha15));
            this.gnH.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.gnH.setDefaultResource(R.drawable.transparent_bg);
            this.gnH.setDefaultBgResource(R.drawable.transparent_bg);
            this.gnI.setText(cVar.bDs());
            this.gnJ.setText(cVar.bDt());
            am.setViewTextColor(this.gnI, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gnJ, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            if (v.getCount(cVar.bDu()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.h(1.0d);
                this.fEg.setVisibility(0);
                this.fEg.setFromCDN(true);
                this.fEg.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.fEg.setImageProcessor(fVar);
                this.fEg.setImageMediaList(cVar.bDu());
                if (!cVar.bDv()) {
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
            this.fEg.setVisibility(8);
            if (!cVar.bDv()) {
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
