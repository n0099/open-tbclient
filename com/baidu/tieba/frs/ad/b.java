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
    protected ConstrainImageGroup gpr;
    private TbImageView hcV;
    private TextView hcW;
    private TextView hcX;
    private c hcY;
    private RelativeLayout mContainer;
    private View mDivider;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.hcV = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.hcW = (TextView) view.findViewById(R.id.ad_title);
        this.hcX = (TextView) view.findViewById(R.id.ad_desc);
        this.gpr = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.mDivider = view.findViewById(R.id.item_divider);
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.hcW, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hcX, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            this.gpr.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.gpr != null) {
            this.gpr.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gpr != null) {
            this.gpr.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gpr != null) {
            this.gpr.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.hcY = cVar;
            this.hcV.setPlaceHolder(1);
            this.hcV.startLoad(cVar.bQL(), 10, false);
            this.hcV.setRadius(l.getDimens(getContext(), R.dimen.tbds26));
            this.hcV.setDrawerType(1);
            this.hcV.setDrawBorder(true);
            this.hcV.setBorderColor(am.getColor(R.color.black_alpha15));
            this.hcV.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.hcV.setDefaultResource(R.drawable.transparent_bg);
            this.hcV.setDefaultBgResource(R.drawable.transparent_bg);
            this.hcW.setText(cVar.bQM());
            this.hcX.setText(cVar.bQN());
            am.setViewTextColor(this.hcW, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hcX, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            if (v.getCount(cVar.bQO()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.n(1.0d);
                this.gpr.setVisibility(0);
                this.gpr.setFromCDN(true);
                this.gpr.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.gpr.setImageProcessor(fVar);
                this.gpr.setImageMediaList(cVar.bQO());
                if (!cVar.bQP()) {
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
            this.gpr.setVisibility(8);
            if (!cVar.bQP()) {
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
