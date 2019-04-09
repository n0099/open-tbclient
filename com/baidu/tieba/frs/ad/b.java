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
    private View aLf;
    private RelativeLayout cMu;
    protected ConstrainImageGroup eia;
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
        this.eia = (ConstrainImageGroup) view.findViewById(d.g.ad_img_layout);
        this.aLf = view.findViewById(d.g.item_divider);
        this.cMu = (RelativeLayout) view.findViewById(d.g.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.j(this.fds, d.C0277d.cp_cont_b);
            al.j(this.fdt, d.C0277d.cp_cont_d);
            al.k(this.cMu, d.f.ad_list_item_bg);
            this.eia.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.eia != null) {
            this.eia.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eia != null) {
            this.eia.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eia != null) {
            this.eia.setImageViewPool(bVar);
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
            al.k(this.cMu, d.f.ad_list_item_bg);
            if (v.S(cVar.beE()) > 0) {
                f fVar = new f(3);
                fVar.h(1.0d);
                this.eia.setVisibility(0);
                this.eia.setFromCDN(true);
                this.eia.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
                this.eia.setImageProcessor(fVar);
                this.eia.setImageMediaList(cVar.beE());
                if (!cVar.beF()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.h(getContext(), d.e.tbds16));
                    layoutParams.addRule(12);
                    this.aLf.setLayoutParams(layoutParams);
                    al.l(this.aLf, d.C0277d.cp_bg_line_c);
                    this.aLf.setVisibility(0);
                    return;
                }
                this.aLf.setVisibility(8);
                return;
            }
            this.eia.setVisibility(8);
            if (!cVar.beF()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.h(getContext(), d.e.tbds1));
                layoutParams2.addRule(12);
                this.aLf.setLayoutParams(layoutParams2);
                al.l(this.aLf, d.C0277d.cp_bg_line_c);
                this.aLf.setVisibility(0);
                return;
            }
            this.aLf.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
