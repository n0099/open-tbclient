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
import com.baidu.tbadk.widget.layout.f;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.a<c> {
    private View aNH;
    private RelativeLayout cWd;
    protected ConstrainImageGroup eCM;
    private TbImageView fyC;
    private TextView fyD;
    private TextView fyE;
    private c fyF;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.fyC = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.fyD = (TextView) view.findViewById(R.id.ad_title);
        this.fyE = (TextView) view.findViewById(R.id.ad_desc);
        this.eCM = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.aNH = view.findViewById(R.id.item_divider);
        this.cWd = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.j(this.fyD, R.color.cp_cont_b);
            am.j(this.fyE, R.color.cp_cont_d);
            am.k(this.cWd, R.drawable.ad_list_item_bg);
            this.eCM.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.eCM != null) {
            this.eCM.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eCM != null) {
            this.eCM.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eCM != null) {
            this.eCM.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.fyF = cVar;
            this.fyC.startLoad(cVar.bnX(), 10, false);
            this.fyC.setRadius(l.g(getContext(), R.dimen.tbds26));
            this.fyC.setDrawerType(1);
            this.fyC.setDrawBorder(true);
            this.fyC.setBorderColor(am.getColor(R.color.black_alpha15));
            this.fyC.setBorderWidth(l.g(getContext(), R.dimen.tbds1));
            this.fyC.setDefaultResource(R.drawable.transparent_bg);
            this.fyC.setDefaultBgResource(R.drawable.transparent_bg);
            this.fyD.setText(cVar.bnY());
            this.fyE.setText(cVar.bnZ());
            am.j(this.fyD, R.color.cp_cont_b);
            am.j(this.fyE, R.color.cp_cont_d);
            am.k(this.cWd, R.drawable.ad_list_item_bg);
            if (v.Z(cVar.boa()) > 0) {
                f fVar = new f(3);
                fVar.h(1.0d);
                this.eCM.setVisibility(0);
                this.eCM.setFromCDN(true);
                this.eCM.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.eCM.setImageProcessor(fVar);
                this.eCM.setImageMediaList(cVar.boa());
                if (!cVar.bob()) {
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
            this.eCM.setVisibility(8);
            if (!cVar.bob()) {
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
