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
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.a<c> {
    private View bgU;
    protected ConstrainImageGroup eMr;
    private TbImageView fzl;
    private TextView fzm;
    private TextView fzn;
    private c fzo;
    private RelativeLayout mContainer;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.fzl = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.fzm = (TextView) view.findViewById(R.id.ad_title);
        this.fzn = (TextView) view.findViewById(R.id.ad_desc);
        this.eMr = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.bgU = view.findViewById(R.id.item_divider);
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.fzm, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fzn, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            this.eMr.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.eMr != null) {
            this.eMr.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eMr != null) {
            this.eMr.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eMr != null) {
            this.eMr.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.fzo = cVar;
            this.fzl.startLoad(cVar.blU(), 10, false);
            this.fzl.setRadius(l.getDimens(getContext(), R.dimen.tbds26));
            this.fzl.setDrawerType(1);
            this.fzl.setDrawBorder(true);
            this.fzl.setBorderColor(am.getColor(R.color.black_alpha15));
            this.fzl.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.fzl.setDefaultResource(R.drawable.transparent_bg);
            this.fzl.setDefaultBgResource(R.drawable.transparent_bg);
            this.fzm.setText(cVar.blV());
            this.fzn.setText(cVar.blW());
            am.setViewTextColor(this.fzm, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fzn, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            if (v.getCount(cVar.blX()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.g(1.0d);
                this.eMr.setVisibility(0);
                this.eMr.setFromCDN(true);
                this.eMr.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.eMr.setImageProcessor(fVar);
                this.eMr.setImageMediaList(cVar.blX());
                if (!cVar.blY()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16));
                    layoutParams.addRule(12);
                    this.bgU.setLayoutParams(layoutParams);
                    am.setBackgroundColor(this.bgU, R.color.cp_bg_line_c);
                    this.bgU.setVisibility(0);
                    return;
                }
                this.bgU.setVisibility(8);
                return;
            }
            this.eMr.setVisibility(8);
            if (!cVar.blY()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds1));
                layoutParams2.addRule(12);
                this.bgU.setLayoutParams(layoutParams2);
                am.setBackgroundColor(this.bgU, R.color.cp_bg_line_c);
                this.bgU.setVisibility(0);
                return;
            }
            this.bgU.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
