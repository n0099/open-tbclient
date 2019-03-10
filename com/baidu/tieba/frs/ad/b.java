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
    private View aLa;
    private RelativeLayout cMu;
    protected ConstrainImageGroup eir;
    private TbImageView fdF;
    private TextView fdG;
    private TextView fdH;
    private c fdI;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.fdF = (TbImageView) view.findViewById(d.g.ad_portrait);
        this.fdG = (TextView) view.findViewById(d.g.ad_title);
        this.fdH = (TextView) view.findViewById(d.g.ad_desc);
        this.eir = (ConstrainImageGroup) view.findViewById(d.g.ad_img_layout);
        this.aLa = view.findViewById(d.g.item_divider);
        this.cMu = (RelativeLayout) view.findViewById(d.g.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.j(this.fdG, d.C0236d.cp_cont_b);
            al.j(this.fdH, d.C0236d.cp_cont_d);
            al.k(this.cMu, d.f.ad_list_item_bg);
            this.eir.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.eir != null) {
            this.eir.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eir != null) {
            this.eir.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eir != null) {
            this.eir.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.fdI = cVar;
            this.fdF.startLoad(cVar.beE(), 10, false);
            this.fdF.setRadius(l.h(getContext(), d.e.tbds26));
            this.fdF.setDrawerType(1);
            this.fdF.setDrawBorder(true);
            this.fdF.setBorderColor(al.getColor(d.C0236d.black_alpha15));
            this.fdF.setBorderWidth(l.h(getContext(), d.e.tbds1));
            this.fdF.setDefaultResource(d.f.transparent_bg);
            this.fdF.setDefaultBgResource(d.f.transparent_bg);
            this.fdG.setText(cVar.beF());
            this.fdH.setText(cVar.beG());
            al.j(this.fdG, d.C0236d.cp_cont_b);
            al.j(this.fdH, d.C0236d.cp_cont_d);
            al.k(this.cMu, d.f.ad_list_item_bg);
            if (v.S(cVar.beH()) > 0) {
                f fVar = new f(3);
                fVar.h(1.0d);
                this.eir.setVisibility(0);
                this.eir.setFromCDN(true);
                this.eir.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
                this.eir.setImageProcessor(fVar);
                this.eir.setImageMediaList(cVar.beH());
                if (!cVar.beI()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.h(getContext(), d.e.tbds16));
                    layoutParams.addRule(12);
                    this.aLa.setLayoutParams(layoutParams);
                    al.l(this.aLa, d.C0236d.cp_bg_line_c);
                    this.aLa.setVisibility(0);
                    return;
                }
                this.aLa.setVisibility(8);
                return;
            }
            this.eir.setVisibility(8);
            if (!cVar.beI()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.h(getContext(), d.e.tbds1));
                layoutParams2.addRule(12);
                this.aLa.setLayoutParams(layoutParams2);
                al.l(this.aLa, d.C0236d.cp_bg_line_c);
                this.aLa.setVisibility(0);
                return;
            }
            this.aLa.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
