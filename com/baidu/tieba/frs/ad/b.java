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
    private RelativeLayout bwo;
    protected ConstrainImageGroup cNn;
    private c dEA;
    private TbImageView dEx;
    private TextView dEy;
    private TextView dEz;
    private View mDivider;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.dEx = (TbImageView) view.findViewById(e.g.ad_portrait);
        this.dEy = (TextView) view.findViewById(e.g.ad_title);
        this.dEz = (TextView) view.findViewById(e.g.ad_desc);
        this.cNn = (ConstrainImageGroup) view.findViewById(e.g.ad_img_layout);
        this.mDivider = view.findViewById(e.g.item_divider);
        this.bwo = (RelativeLayout) view.findViewById(e.g.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.dEy, e.d.cp_cont_b);
            al.h(this.dEz, e.d.cp_cont_d);
            al.i(this.bwo, e.f.ad_list_item_bg);
            this.cNn.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.cNn != null) {
            this.cNn.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cNn != null) {
            this.cNn.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cNn != null) {
            this.cNn.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.dEA = cVar;
            this.dEx.startLoad(cVar.aBB(), 10, false);
            this.dEx.setRadius(l.h(getContext(), e.C0175e.tbds26));
            this.dEx.setDrawerType(1);
            this.dEx.setDrawBorder(true);
            this.dEx.setBorderColor(al.getColor(e.d.black_alpha15));
            this.dEx.setBorderWidth(l.h(getContext(), e.C0175e.tbds1));
            this.dEx.setDefaultResource(e.f.transparent_bg);
            this.dEx.setDefaultBgResource(e.f.transparent_bg);
            this.dEy.setText(cVar.aBC());
            this.dEz.setText(cVar.aBD());
            al.h(this.dEy, e.d.cp_cont_b);
            al.h(this.dEz, e.d.cp_cont_d);
            al.i(this.bwo, e.f.ad_list_item_bg);
            if (v.I(cVar.aBE()) > 0) {
                com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
                eVar.g(1.0d);
                this.cNn.setVisibility(0);
                this.cNn.setFromCDN(true);
                this.cNn.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.tbds20));
                this.cNn.setImageProcessor(eVar);
                this.cNn.setImageMediaList(cVar.aBE());
                if (!cVar.aBF()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.h(getContext(), e.C0175e.tbds16));
                    layoutParams.addRule(12);
                    this.mDivider.setLayoutParams(layoutParams);
                    al.j(this.mDivider, e.d.cp_bg_line_c);
                    this.mDivider.setVisibility(0);
                    return;
                }
                this.mDivider.setVisibility(8);
                return;
            }
            this.cNn.setVisibility(8);
            if (!cVar.aBF()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.h(getContext(), e.C0175e.tbds1));
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
