package com.baidu.tieba.frs.ad;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.f;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.a<c> {
    private View aMY;
    private RelativeLayout cUH;
    protected ConstrainImageGroup exO;
    private TbImageView ftG;
    private TextView ftH;
    private TextView ftI;
    private c ftJ;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.ftG = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.ftH = (TextView) view.findViewById(R.id.ad_title);
        this.ftI = (TextView) view.findViewById(R.id.ad_desc);
        this.exO = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.aMY = view.findViewById(R.id.item_divider);
        this.cUH = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.j(this.ftH, R.color.cp_cont_b);
            al.j(this.ftI, R.color.cp_cont_d);
            al.k(this.cUH, R.drawable.ad_list_item_bg);
            this.exO.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.exO != null) {
            this.exO.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.exO != null) {
            this.exO.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.exO != null) {
            this.exO.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.ftJ = cVar;
            this.ftG.startLoad(cVar.blW(), 10, false);
            this.ftG.setRadius(l.g(getContext(), R.dimen.tbds26));
            this.ftG.setDrawerType(1);
            this.ftG.setDrawBorder(true);
            this.ftG.setBorderColor(al.getColor(R.color.black_alpha15));
            this.ftG.setBorderWidth(l.g(getContext(), R.dimen.tbds1));
            this.ftG.setDefaultResource(R.drawable.transparent_bg);
            this.ftG.setDefaultBgResource(R.drawable.transparent_bg);
            this.ftH.setText(cVar.blX());
            this.ftI.setText(cVar.blY());
            al.j(this.ftH, R.color.cp_cont_b);
            al.j(this.ftI, R.color.cp_cont_d);
            al.k(this.cUH, R.drawable.ad_list_item_bg);
            if (v.Z(cVar.blZ()) > 0) {
                f fVar = new f(3);
                fVar.h(1.0d);
                this.exO.setVisibility(0);
                this.exO.setFromCDN(true);
                this.exO.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.exO.setImageProcessor(fVar);
                this.exO.setImageMediaList(cVar.blZ());
                if (!cVar.bma()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.g(getContext(), R.dimen.tbds16));
                    layoutParams.addRule(12);
                    this.aMY.setLayoutParams(layoutParams);
                    al.l(this.aMY, R.color.cp_bg_line_c);
                    this.aMY.setVisibility(0);
                    return;
                }
                this.aMY.setVisibility(8);
                return;
            }
            this.exO.setVisibility(8);
            if (!cVar.bma()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.g(getContext(), R.dimen.tbds1));
                layoutParams2.addRule(12);
                this.aMY.setLayoutParams(layoutParams2);
                al.l(this.aMY, R.color.cp_bg_line_c);
                this.aMY.setVisibility(0);
                return;
            }
            this.aMY.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
