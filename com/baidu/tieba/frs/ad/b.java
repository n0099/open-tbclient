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
    private View aNH;
    private RelativeLayout cWk;
    protected ConstrainImageGroup eCT;
    private TbImageView fzb;
    private TextView fzc;
    private TextView fzd;
    private c fze;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.fzb = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.fzc = (TextView) view.findViewById(R.id.ad_title);
        this.fzd = (TextView) view.findViewById(R.id.ad_desc);
        this.eCT = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.aNH = view.findViewById(R.id.item_divider);
        this.cWk = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.j(this.fzc, R.color.cp_cont_b);
            am.j(this.fzd, R.color.cp_cont_d);
            am.k(this.cWk, R.drawable.ad_list_item_bg);
            this.eCT.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.eCT != null) {
            this.eCT.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eCT != null) {
            this.eCT.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eCT != null) {
            this.eCT.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.fze = cVar;
            this.fzb.startLoad(cVar.boh(), 10, false);
            this.fzb.setRadius(l.g(getContext(), R.dimen.tbds26));
            this.fzb.setDrawerType(1);
            this.fzb.setDrawBorder(true);
            this.fzb.setBorderColor(am.getColor(R.color.black_alpha15));
            this.fzb.setBorderWidth(l.g(getContext(), R.dimen.tbds1));
            this.fzb.setDefaultResource(R.drawable.transparent_bg);
            this.fzb.setDefaultBgResource(R.drawable.transparent_bg);
            this.fzc.setText(cVar.boi());
            this.fzd.setText(cVar.boj());
            am.j(this.fzc, R.color.cp_cont_b);
            am.j(this.fzd, R.color.cp_cont_d);
            am.k(this.cWk, R.drawable.ad_list_item_bg);
            if (v.Z(cVar.bok()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.h(1.0d);
                this.eCT.setVisibility(0);
                this.eCT.setFromCDN(true);
                this.eCT.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.eCT.setImageProcessor(fVar);
                this.eCT.setImageMediaList(cVar.bok());
                if (!cVar.bol()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.g(getContext(), R.dimen.tbds16));
                    layoutParams.addRule(12);
                    this.aNH.setLayoutParams(layoutParams);
                    am.l(this.aNH, R.color.cp_bg_line_c);
                    this.aNH.setVisibility(0);
                    return;
                }
                this.aNH.setVisibility(8);
                return;
            }
            this.eCT.setVisibility(8);
            if (!cVar.bol()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.g(getContext(), R.dimen.tbds1));
                layoutParams2.addRule(12);
                this.aNH.setLayoutParams(layoutParams2);
                am.l(this.aNH, R.color.cp_bg_line_c);
                this.aNH.setVisibility(0);
                return;
            }
            this.aNH.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
