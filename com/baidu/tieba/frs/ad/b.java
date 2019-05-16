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
    private RelativeLayout cUF;
    protected ConstrainImageGroup exN;
    private TbImageView ftF;
    private TextView ftG;
    private TextView ftH;
    private c ftI;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.ftF = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.ftG = (TextView) view.findViewById(R.id.ad_title);
        this.ftH = (TextView) view.findViewById(R.id.ad_desc);
        this.exN = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.aMY = view.findViewById(R.id.item_divider);
        this.cUF = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.j(this.ftG, R.color.cp_cont_b);
            al.j(this.ftH, R.color.cp_cont_d);
            al.k(this.cUF, R.drawable.ad_list_item_bg);
            this.exN.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.exN != null) {
            this.exN.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.exN != null) {
            this.exN.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.exN != null) {
            this.exN.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.ftI = cVar;
            this.ftF.startLoad(cVar.blT(), 10, false);
            this.ftF.setRadius(l.g(getContext(), R.dimen.tbds26));
            this.ftF.setDrawerType(1);
            this.ftF.setDrawBorder(true);
            this.ftF.setBorderColor(al.getColor(R.color.black_alpha15));
            this.ftF.setBorderWidth(l.g(getContext(), R.dimen.tbds1));
            this.ftF.setDefaultResource(R.drawable.transparent_bg);
            this.ftF.setDefaultBgResource(R.drawable.transparent_bg);
            this.ftG.setText(cVar.blU());
            this.ftH.setText(cVar.blV());
            al.j(this.ftG, R.color.cp_cont_b);
            al.j(this.ftH, R.color.cp_cont_d);
            al.k(this.cUF, R.drawable.ad_list_item_bg);
            if (v.Z(cVar.blW()) > 0) {
                f fVar = new f(3);
                fVar.h(1.0d);
                this.exN.setVisibility(0);
                this.exN.setFromCDN(true);
                this.exN.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.exN.setImageProcessor(fVar);
                this.exN.setImageMediaList(cVar.blW());
                if (!cVar.blX()) {
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
            this.exN.setVisibility(8);
            if (!cVar.blX()) {
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
