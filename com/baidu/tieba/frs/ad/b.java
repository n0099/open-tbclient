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
    private RelativeLayout bAz;
    protected ConstrainImageGroup cXQ;
    private TbImageView dPa;
    private TextView dPb;
    private TextView dPc;
    private c dPd;
    private View mDivider;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.dPa = (TbImageView) view.findViewById(e.g.ad_portrait);
        this.dPb = (TextView) view.findViewById(e.g.ad_title);
        this.dPc = (TextView) view.findViewById(e.g.ad_desc);
        this.cXQ = (ConstrainImageGroup) view.findViewById(e.g.ad_img_layout);
        this.mDivider = view.findViewById(e.g.item_divider);
        this.bAz = (RelativeLayout) view.findViewById(e.g.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.dPb, e.d.cp_cont_b);
            al.h(this.dPc, e.d.cp_cont_d);
            al.i(this.bAz, e.f.ad_list_item_bg);
            this.cXQ.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.cXQ != null) {
            this.cXQ.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cXQ != null) {
            this.cXQ.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cXQ != null) {
            this.cXQ.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.dPd = cVar;
            this.dPa.startLoad(cVar.aDx(), 10, false);
            this.dPa.setRadius(l.h(getContext(), e.C0210e.tbds26));
            this.dPa.setDrawerType(1);
            this.dPa.setDrawBorder(true);
            this.dPa.setBorderColor(al.getColor(e.d.black_alpha15));
            this.dPa.setBorderWidth(l.h(getContext(), e.C0210e.tbds1));
            this.dPa.setDefaultResource(e.f.transparent_bg);
            this.dPa.setDefaultBgResource(e.f.transparent_bg);
            this.dPb.setText(cVar.aDy());
            this.dPc.setText(cVar.aDz());
            al.h(this.dPb, e.d.cp_cont_b);
            al.h(this.dPc, e.d.cp_cont_d);
            al.i(this.bAz, e.f.ad_list_item_bg);
            if (v.H(cVar.aDA()) > 0) {
                com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
                eVar.g(1.0d);
                this.cXQ.setVisibility(0);
                this.cXQ.setFromCDN(true);
                this.cXQ.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20));
                this.cXQ.setImageProcessor(eVar);
                this.cXQ.setImageMediaList(cVar.aDA());
                if (!cVar.aDB()) {
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
            this.cXQ.setVisibility(8);
            if (!cVar.aDB()) {
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
