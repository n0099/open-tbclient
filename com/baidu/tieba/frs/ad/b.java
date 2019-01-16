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
    private RelativeLayout bBm;
    protected ConstrainImageGroup cYB;
    private TbImageView dPJ;
    private TextView dPK;
    private TextView dPL;
    private c dPM;
    private View mDivider;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.dPJ = (TbImageView) view.findViewById(e.g.ad_portrait);
        this.dPK = (TextView) view.findViewById(e.g.ad_title);
        this.dPL = (TextView) view.findViewById(e.g.ad_desc);
        this.cYB = (ConstrainImageGroup) view.findViewById(e.g.ad_img_layout);
        this.mDivider = view.findViewById(e.g.item_divider);
        this.bBm = (RelativeLayout) view.findViewById(e.g.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.dPK, e.d.cp_cont_b);
            al.h(this.dPL, e.d.cp_cont_d);
            al.i(this.bBm, e.f.ad_list_item_bg);
            this.cYB.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.cYB != null) {
            this.cYB.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cYB != null) {
            this.cYB.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cYB != null) {
            this.cYB.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.dPM = cVar;
            this.dPJ.startLoad(cVar.aDU(), 10, false);
            this.dPJ.setRadius(l.h(getContext(), e.C0210e.tbds26));
            this.dPJ.setDrawerType(1);
            this.dPJ.setDrawBorder(true);
            this.dPJ.setBorderColor(al.getColor(e.d.black_alpha15));
            this.dPJ.setBorderWidth(l.h(getContext(), e.C0210e.tbds1));
            this.dPJ.setDefaultResource(e.f.transparent_bg);
            this.dPJ.setDefaultBgResource(e.f.transparent_bg);
            this.dPK.setText(cVar.aDV());
            this.dPL.setText(cVar.aDW());
            al.h(this.dPK, e.d.cp_cont_b);
            al.h(this.dPL, e.d.cp_cont_d);
            al.i(this.bBm, e.f.ad_list_item_bg);
            if (v.H(cVar.aDX()) > 0) {
                com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
                eVar.g(1.0d);
                this.cYB.setVisibility(0);
                this.cYB.setFromCDN(true);
                this.cYB.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20));
                this.cYB.setImageProcessor(eVar);
                this.cYB.setImageMediaList(cVar.aDX());
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
            this.cYB.setVisibility(8);
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
