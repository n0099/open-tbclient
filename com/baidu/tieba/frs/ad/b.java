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
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.a<c> {
    private RelativeLayout bBn;
    protected ConstrainImageGroup cYC;
    private TbImageView dPK;
    private TextView dPL;
    private TextView dPM;
    private c dPN;
    private View mDivider;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.dPK = (TbImageView) view.findViewById(e.g.ad_portrait);
        this.dPL = (TextView) view.findViewById(e.g.ad_title);
        this.dPM = (TextView) view.findViewById(e.g.ad_desc);
        this.cYC = (ConstrainImageGroup) view.findViewById(e.g.ad_img_layout);
        this.mDivider = view.findViewById(e.g.item_divider);
        this.bBn = (RelativeLayout) view.findViewById(e.g.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.dPL, e.d.cp_cont_b);
            al.h(this.dPM, e.d.cp_cont_d);
            al.i(this.bBn, e.f.ad_list_item_bg);
            this.cYC.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.cYC != null) {
            this.cYC.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cYC != null) {
            this.cYC.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cYC != null) {
            this.cYC.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.dPN = cVar;
            this.dPK.startLoad(cVar.aDU(), 10, false);
            this.dPK.setRadius(l.h(getContext(), e.C0210e.tbds26));
            this.dPK.setDrawerType(1);
            this.dPK.setDrawBorder(true);
            this.dPK.setBorderColor(al.getColor(e.d.black_alpha15));
            this.dPK.setBorderWidth(l.h(getContext(), e.C0210e.tbds1));
            this.dPK.setDefaultResource(e.f.transparent_bg);
            this.dPK.setDefaultBgResource(e.f.transparent_bg);
            this.dPL.setText(cVar.aDV());
            this.dPM.setText(cVar.aDW());
            al.h(this.dPL, e.d.cp_cont_b);
            al.h(this.dPM, e.d.cp_cont_d);
            al.i(this.bBn, e.f.ad_list_item_bg);
            if (v.H(cVar.aDX()) > 0) {
                com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
                eVar.g(1.0d);
                this.cYC.setVisibility(0);
                this.cYC.setFromCDN(true);
                this.cYC.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20));
                this.cYC.setImageProcessor(eVar);
                this.cYC.setImageMediaList(cVar.aDX());
                if (!cVar.aDY()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.h(getContext(), e.C0210e.tbds16));
                    layoutParams.addRule(12);
                    this.mDivider.setLayoutParams(layoutParams);
                    al.j(this.mDivider, e.d.cp_bg_line_c);
                    this.mDivider.setVisibility(0);
                    return;
                }
                this.mDivider.setVisibility(8);
                return;
            }
            this.cYC.setVisibility(8);
            if (!cVar.aDY()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.h(getContext(), e.C0210e.tbds1));
                layoutParams2.addRule(12);
                this.mDivider.setLayoutParams(layoutParams2);
                al.j(this.mDivider, e.d.cp_bg_line_c);
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
