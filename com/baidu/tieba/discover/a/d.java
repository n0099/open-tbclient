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
    private TbImageView MD;
    private ImageView aLX;
    private TextView aMb;
    private ImageView aMc;
    private View aMd;
    private View aMe;
    private View aMf;
    private TextView amV;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aMf = view.findViewById(i.f.root_view);
        this.MD = (TbImageView) view.findViewById(i.f.icon);
        this.amV = (TextView) view.findViewById(i.f.title);
        this.aMb = (TextView) view.findViewById(i.f.desc);
        this.aLX = (ImageView) view.findViewById(i.f.red_tip);
        this.aMc = (ImageView) view.findViewById(i.f.red_new_tip);
        this.aMd = view.findViewById(i.f.top_divider);
        this.aMe = view.findViewById(i.f.bottom_divider);
        a(tbPageContext, TbadkApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: h */
    public void B(com.baidu.tieba.discover.data.c cVar) {
        super.B(cVar);
        if (cVar != null) {
            this.MD.setDefaultResource(u.gm(cVar.HT()));
            if (!StringUtils.isNull(cVar.getIcon_url())) {
                this.MD.d(cVar.getIcon_url(), 10, false);
            }
            this.amV.setText(k.f(cVar.getTitle(), 0, 16));
            this.aMb.setText(cVar.HS());
            if (cVar.HU()) {
                this.aMc.setVisibility(0);
            } else {
                this.aMc.setVisibility(8);
            }
            if (cVar.HV()) {
                this.aLX.setVisibility(0);
            } else {
                this.aLX.setVisibility(8);
            }
            switch (cVar.HW()) {
                case 1:
                    this.aMd.setVisibility(0);
                    this.aMe.setVisibility(0);
                    return;
                case 2:
                    this.aMd.setVisibility(8);
                    this.aMe.setVisibility(8);
                    return;
                case 3:
                    this.aMd.setVisibility(0);
                    this.aMe.setVisibility(8);
                    return;
                default:
                    this.aMd.setVisibility(8);
                    this.aMe.setVisibility(0);
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        al.h(this.aMf, i.e.addresslist_item_bg);
        this.MD.setIsNight(TbadkApplication.getInst().getSkinType() == 1);
        return true;
    }
}
