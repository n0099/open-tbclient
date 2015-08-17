package com.baidu.tieba.discover.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.discover.u;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.d.b> {
    private TbImageView MF;
    private ImageView aLK;
    private TextView aLO;
    private ImageView aLP;
    private View aLQ;
    private View aLR;
    private View aLS;
    private TextView anH;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aLS = view.findViewById(i.f.root_view);
        this.MF = (TbImageView) view.findViewById(i.f.icon);
        this.anH = (TextView) view.findViewById(i.f.title);
        this.aLO = (TextView) view.findViewById(i.f.desc);
        this.aLK = (ImageView) view.findViewById(i.f.red_tip);
        this.aLP = (ImageView) view.findViewById(i.f.red_new_tip);
        this.aLQ = view.findViewById(i.f.top_divider);
        this.aLR = view.findViewById(i.f.bottom_divider);
        a(tbPageContext, TbadkApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: h */
    public void A(com.baidu.tieba.discover.data.c cVar) {
        super.A(cVar);
        if (cVar != null) {
            this.MF.setDefaultResource(u.gf(cVar.If()));
            if (!StringUtils.isNull(cVar.getIcon_url())) {
                this.MF.d(cVar.getIcon_url(), 10, false);
            }
            this.anH.setText(k.f(cVar.getTitle(), 0, 16));
            this.aLO.setText(cVar.Ie());
            if (cVar.Ig()) {
                this.aLP.setVisibility(0);
            } else {
                this.aLP.setVisibility(8);
            }
            if (cVar.Ih()) {
                this.aLK.setVisibility(0);
            } else {
                this.aLK.setVisibility(8);
            }
            switch (cVar.Ii()) {
                case 1:
                    this.aLQ.setVisibility(0);
                    this.aLR.setVisibility(0);
                    return;
                case 2:
                    this.aLQ.setVisibility(8);
                    this.aLR.setVisibility(8);
                    return;
                case 3:
                    this.aLQ.setVisibility(0);
                    this.aLR.setVisibility(8);
                    return;
                default:
                    this.aLQ.setVisibility(8);
                    this.aLR.setVisibility(0);
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        al.i(this.aLS, i.e.addresslist_item_bg);
        this.MF.setIsNight(TbadkApplication.getInst().getSkinType() == 1);
        return true;
    }
}
