package com.baidu.tieba.frs.ad;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.a<c> {
    private View bHc;
    private RelativeLayout blJ;
    protected ConstrainImageGroup cwB;
    private TbImageView dnq;
    private TextView dnr;
    private TextView dnt;
    private c dnu;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.dnq = (TbImageView) view.findViewById(d.g.ad_portrait);
        this.dnr = (TextView) view.findViewById(d.g.ad_title);
        this.dnt = (TextView) view.findViewById(d.g.ad_desc);
        this.cwB = (ConstrainImageGroup) view.findViewById(d.g.ad_img_layout);
        this.bHc = view.findViewById(d.g.item_divider);
        this.blJ = (RelativeLayout) view.findViewById(d.g.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.h(this.dnr, d.C0142d.cp_cont_b);
            am.h(this.dnt, d.C0142d.cp_cont_d);
            am.i(this.blJ, d.f.ad_list_item_bg);
            this.cwB.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.cwB != null) {
            this.cwB.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cwB != null) {
            this.cwB.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cwB != null) {
            this.cwB.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.dnu = cVar;
            this.dnq.startLoad(cVar.avq(), 10, false);
            this.dnq.setRadius(l.e(getContext(), d.e.tbds26));
            this.dnq.setDrawerType(1);
            this.dnq.setDrawBorder(true);
            this.dnq.setBorderColor(am.getColor(d.C0142d.black_alpha15));
            this.dnq.setBorderWidth(l.e(getContext(), d.e.tbds1));
            this.dnq.setDefaultResource(d.f.transparent_bg);
            this.dnq.setDefaultBgResource(d.f.transparent_bg);
            this.dnr.setText(cVar.avr());
            this.dnt.setText(cVar.avs());
            am.h(this.dnr, d.C0142d.cp_cont_b);
            am.h(this.dnt, d.C0142d.cp_cont_d);
            am.i(this.blJ, d.f.ad_list_item_bg);
            if (w.z(cVar.avt()) > 0) {
                com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
                eVar.i(1.0d);
                this.cwB.setVisibility(0);
                this.cwB.setFromCDN(true);
                this.cwB.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
                this.cwB.setImageProcessor(eVar);
                this.cwB.setImageMediaList(cVar.avt());
                if (!cVar.avu()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.e(getContext(), d.e.tbds16));
                    layoutParams.addRule(12);
                    this.bHc.setLayoutParams(layoutParams);
                    am.j(this.bHc, d.C0142d.cp_bg_line_c);
                    this.bHc.setVisibility(0);
                    return;
                }
                this.bHc.setVisibility(8);
                return;
            }
            this.cwB.setVisibility(8);
            if (!cVar.avu()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.e(getContext(), d.e.tbds1));
                layoutParams2.addRule(12);
                this.bHc.setLayoutParams(layoutParams2);
                am.j(this.bHc, d.C0142d.cp_bg_line_c);
                this.bHc.setVisibility(0);
                return;
            }
            this.bHc.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
