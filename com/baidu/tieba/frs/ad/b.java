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
    private RelativeLayout bwZ;
    protected ConstrainImageGroup cOt;
    private TbImageView dFN;
    private TextView dFO;
    private TextView dFP;
    private c dFQ;
    private View mDivider;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.dFN = (TbImageView) view.findViewById(e.g.ad_portrait);
        this.dFO = (TextView) view.findViewById(e.g.ad_title);
        this.dFP = (TextView) view.findViewById(e.g.ad_desc);
        this.cOt = (ConstrainImageGroup) view.findViewById(e.g.ad_img_layout);
        this.mDivider = view.findViewById(e.g.item_divider);
        this.bwZ = (RelativeLayout) view.findViewById(e.g.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.dFO, e.d.cp_cont_b);
            al.h(this.dFP, e.d.cp_cont_d);
            al.i(this.bwZ, e.f.ad_list_item_bg);
            this.cOt.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.cOt != null) {
            this.cOt.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cOt != null) {
            this.cOt.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cOt != null) {
            this.cOt.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.dFQ = cVar;
            this.dFN.startLoad(cVar.aAY(), 10, false);
            this.dFN.setRadius(l.h(getContext(), e.C0200e.tbds26));
            this.dFN.setDrawerType(1);
            this.dFN.setDrawBorder(true);
            this.dFN.setBorderColor(al.getColor(e.d.black_alpha15));
            this.dFN.setBorderWidth(l.h(getContext(), e.C0200e.tbds1));
            this.dFN.setDefaultResource(e.f.transparent_bg);
            this.dFN.setDefaultBgResource(e.f.transparent_bg);
            this.dFO.setText(cVar.aAZ());
            this.dFP.setText(cVar.aBa());
            al.h(this.dFO, e.d.cp_cont_b);
            al.h(this.dFP, e.d.cp_cont_d);
            al.i(this.bwZ, e.f.ad_list_item_bg);
            if (v.H(cVar.aBb()) > 0) {
                com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
                eVar.g(1.0d);
                this.cOt.setVisibility(0);
                this.cOt.setFromCDN(true);
                this.cOt.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.tbds20));
                this.cOt.setImageProcessor(eVar);
                this.cOt.setImageMediaList(cVar.aBb());
                if (!cVar.aBc()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.h(getContext(), e.C0200e.tbds16));
                    layoutParams.addRule(12);
                    this.mDivider.setLayoutParams(layoutParams);
                    al.j(this.mDivider, e.d.cp_bg_line_c);
                    this.mDivider.setVisibility(0);
                    return;
                }
                this.mDivider.setVisibility(8);
                return;
            }
            this.cOt.setVisibility(8);
            if (!cVar.aBc()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.h(getContext(), e.C0200e.tbds1));
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
