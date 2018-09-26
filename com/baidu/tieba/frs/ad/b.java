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
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.a<c> {
    private View bNG;
    private RelativeLayout bsh;
    protected ConstrainImageGroup cET;
    private TbImageView dww;
    private TextView dwx;
    private TextView dwy;
    private c dwz;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.dww = (TbImageView) view.findViewById(e.g.ad_portrait);
        this.dwx = (TextView) view.findViewById(e.g.ad_title);
        this.dwy = (TextView) view.findViewById(e.g.ad_desc);
        this.cET = (ConstrainImageGroup) view.findViewById(e.g.ad_img_layout);
        this.bNG = view.findViewById(e.g.item_divider);
        this.bsh = (RelativeLayout) view.findViewById(e.g.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.dwx, e.d.cp_cont_b);
            al.h(this.dwy, e.d.cp_cont_d);
            al.i(this.bsh, e.f.ad_list_item_bg);
            this.cET.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.cET != null) {
            this.cET.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cET != null) {
            this.cET.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cET != null) {
            this.cET.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.dwz = cVar;
            this.dww.startLoad(cVar.ayf(), 10, false);
            this.dww.setRadius(l.h(getContext(), e.C0141e.tbds26));
            this.dww.setDrawerType(1);
            this.dww.setDrawBorder(true);
            this.dww.setBorderColor(al.getColor(e.d.black_alpha15));
            this.dww.setBorderWidth(l.h(getContext(), e.C0141e.tbds1));
            this.dww.setDefaultResource(e.f.transparent_bg);
            this.dww.setDefaultBgResource(e.f.transparent_bg);
            this.dwx.setText(cVar.ayg());
            this.dwy.setText(cVar.ayh());
            al.h(this.dwx, e.d.cp_cont_b);
            al.h(this.dwy, e.d.cp_cont_d);
            al.i(this.bsh, e.f.ad_list_item_bg);
            if (v.y(cVar.ayi()) > 0) {
                com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
                eVar.g(1.0d);
                this.cET.setVisibility(0);
                this.cET.setFromCDN(true);
                this.cET.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.tbds20));
                this.cET.setImageProcessor(eVar);
                this.cET.setImageMediaList(cVar.ayi());
                if (!cVar.ayj()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.h(getContext(), e.C0141e.tbds16));
                    layoutParams.addRule(12);
                    this.bNG.setLayoutParams(layoutParams);
                    al.j(this.bNG, e.d.cp_bg_line_c);
                    this.bNG.setVisibility(0);
                    return;
                }
                this.bNG.setVisibility(8);
                return;
            }
            this.cET.setVisibility(8);
            if (!cVar.ayj()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.h(getContext(), e.C0141e.tbds1));
                layoutParams2.addRule(12);
                this.bNG.setLayoutParams(layoutParams2);
                al.j(this.bNG, e.d.cp_bg_line_c);
                this.bNG.setVisibility(0);
                return;
            }
            this.bNG.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
