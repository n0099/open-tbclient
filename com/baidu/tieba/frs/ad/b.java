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
    private RelativeLayout bAw;
    protected ConstrainImageGroup cVa;
    private TbImageView dMm;
    private TextView dMn;
    private TextView dMo;
    private c dMp;
    private View mDivider;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.dMm = (TbImageView) view.findViewById(e.g.ad_portrait);
        this.dMn = (TextView) view.findViewById(e.g.ad_title);
        this.dMo = (TextView) view.findViewById(e.g.ad_desc);
        this.cVa = (ConstrainImageGroup) view.findViewById(e.g.ad_img_layout);
        this.mDivider = view.findViewById(e.g.item_divider);
        this.bAw = (RelativeLayout) view.findViewById(e.g.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.dMn, e.d.cp_cont_b);
            al.h(this.dMo, e.d.cp_cont_d);
            al.i(this.bAw, e.f.ad_list_item_bg);
            this.cVa.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.cVa != null) {
            this.cVa.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cVa != null) {
            this.cVa.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cVa != null) {
            this.cVa.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.dMp = cVar;
            this.dMm.startLoad(cVar.aCI(), 10, false);
            this.dMm.setRadius(l.h(getContext(), e.C0210e.tbds26));
            this.dMm.setDrawerType(1);
            this.dMm.setDrawBorder(true);
            this.dMm.setBorderColor(al.getColor(e.d.black_alpha15));
            this.dMm.setBorderWidth(l.h(getContext(), e.C0210e.tbds1));
            this.dMm.setDefaultResource(e.f.transparent_bg);
            this.dMm.setDefaultBgResource(e.f.transparent_bg);
            this.dMn.setText(cVar.aCJ());
            this.dMo.setText(cVar.aCK());
            al.h(this.dMn, e.d.cp_cont_b);
            al.h(this.dMo, e.d.cp_cont_d);
            al.i(this.bAw, e.f.ad_list_item_bg);
            if (v.H(cVar.aCL()) > 0) {
                com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
                eVar.g(1.0d);
                this.cVa.setVisibility(0);
                this.cVa.setFromCDN(true);
                this.cVa.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20));
                this.cVa.setImageProcessor(eVar);
                this.cVa.setImageMediaList(cVar.aCL());
                if (!cVar.aCM()) {
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
            this.cVa.setVisibility(8);
            if (!cVar.aCM()) {
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
