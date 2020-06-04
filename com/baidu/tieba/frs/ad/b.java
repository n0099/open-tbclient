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
    protected ConstrainImageGroup gEx;
    private TbImageView hsa;
    private TextView hsb;
    private TextView hsc;
    private c hsd;
    private RelativeLayout mContainer;
    private View mDivider;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.hsa = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.hsb = (TextView) view.findViewById(R.id.ad_title);
        this.hsc = (TextView) view.findViewById(R.id.ad_desc);
        this.gEx = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.mDivider = view.findViewById(R.id.item_divider);
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.hsb, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hsc, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            this.gEx.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.gEx != null) {
            this.gEx.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gEx != null) {
            this.gEx.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gEx != null) {
            this.gEx.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(c cVar) {
        if (cVar != null) {
            this.hsd = cVar;
            this.hsa.setPlaceHolder(1);
            this.hsa.startLoad(cVar.bXi(), 10, false);
            this.hsa.setRadius(l.getDimens(getContext(), R.dimen.tbds26));
            this.hsa.setDrawerType(1);
            this.hsa.setDrawBorder(true);
            this.hsa.setBorderColor(am.getColor(R.color.black_alpha15));
            this.hsa.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.hsa.setDefaultResource(R.drawable.transparent_bg);
            this.hsa.setDefaultBgResource(R.drawable.transparent_bg);
            this.hsb.setText(cVar.bXj());
            this.hsc.setText(cVar.bXk());
            am.setViewTextColor(this.hsb, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hsc, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            if (v.getCount(cVar.bXl()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.o(1.0d);
                this.gEx.setVisibility(0);
                this.gEx.setFromCDN(true);
                this.gEx.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.gEx.setImageProcessor(fVar);
                this.gEx.setImageMediaList(cVar.bXl());
                if (!cVar.bXm()) {
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
            this.gEx.setVisibility(8);
            if (!cVar.bXm()) {
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
