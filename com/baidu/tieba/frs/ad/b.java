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
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.a<c> {
    private View aLe;
    private RelativeLayout cMt;
    protected ConstrainImageGroup ehZ;
    private TbImageView fdr;
    private TextView fds;
    private TextView fdt;
    private c fdu;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.fdr = (TbImageView) view.findViewById(d.g.ad_portrait);
        this.fds = (TextView) view.findViewById(d.g.ad_title);
        this.fdt = (TextView) view.findViewById(d.g.ad_desc);
        this.ehZ = (ConstrainImageGroup) view.findViewById(d.g.ad_img_layout);
        this.aLe = view.findViewById(d.g.item_divider);
        this.cMt = (RelativeLayout) view.findViewById(d.g.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.j(this.fds, d.C0277d.cp_cont_b);
            al.j(this.fdt, d.C0277d.cp_cont_d);
            al.k(this.cMt, d.f.ad_list_item_bg);
            this.ehZ.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.ehZ != null) {
            this.ehZ.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.ehZ != null) {
            this.ehZ.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.ehZ != null) {
            this.ehZ.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.fdu = cVar;
            this.fdr.startLoad(cVar.beB(), 10, false);
            this.fdr.setRadius(l.h(getContext(), d.e.tbds26));
            this.fdr.setDrawerType(1);
            this.fdr.setDrawBorder(true);
            this.fdr.setBorderColor(al.getColor(d.C0277d.black_alpha15));
            this.fdr.setBorderWidth(l.h(getContext(), d.e.tbds1));
            this.fdr.setDefaultResource(d.f.transparent_bg);
            this.fdr.setDefaultBgResource(d.f.transparent_bg);
            this.fds.setText(cVar.beC());
            this.fdt.setText(cVar.beD());
            al.j(this.fds, d.C0277d.cp_cont_b);
            al.j(this.fdt, d.C0277d.cp_cont_d);
            al.k(this.cMt, d.f.ad_list_item_bg);
            if (v.S(cVar.beE()) > 0) {
                f fVar = new f(3);
                fVar.h(1.0d);
                this.ehZ.setVisibility(0);
                this.ehZ.setFromCDN(true);
                this.ehZ.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
                this.ehZ.setImageProcessor(fVar);
                this.ehZ.setImageMediaList(cVar.beE());
                if (!cVar.beF()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.h(getContext(), d.e.tbds16));
                    layoutParams.addRule(12);
                    this.aLe.setLayoutParams(layoutParams);
                    al.l(this.aLe, d.C0277d.cp_bg_line_c);
                    this.aLe.setVisibility(0);
                    return;
                }
                this.aLe.setVisibility(8);
                return;
            }
            this.ehZ.setVisibility(8);
            if (!cVar.beF()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.h(getContext(), d.e.tbds1));
                layoutParams2.addRule(12);
                this.aLe.setLayoutParams(layoutParams2);
                al.l(this.aLe, d.C0277d.cp_bg_line_c);
                this.aLe.setVisibility(0);
                return;
            }
            this.aLe.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
