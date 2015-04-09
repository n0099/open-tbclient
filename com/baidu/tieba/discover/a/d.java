package com.baidu.tieba.discover.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.discover.p;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.e.c> {
    private TbImageView Mw;
    private ImageView aCi;
    private TextView aCm;
    private ImageView aCn;
    private View aCo;
    private View aCp;
    private View aCq;
    private TextView ahz;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aCq = view.findViewById(v.root_view);
        this.Mw = (TbImageView) view.findViewById(v.icon);
        this.ahz = (TextView) view.findViewById(v.title);
        this.aCm = (TextView) view.findViewById(v.desc);
        this.aCi = (ImageView) view.findViewById(v.red_tip);
        this.aCn = (ImageView) view.findViewById(v.red_new_tip);
        this.aCo = view.findViewById(v.top_divider);
        this.aCp = view.findViewById(v.bottom_divider);
        a(tbPageContext, TbadkApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: h */
    public void A(com.baidu.tieba.discover.data.c cVar) {
        super.A(cVar);
        if (cVar != null) {
            this.Mw.setDefaultResource(p.fp(cVar.Gm()));
            if (!StringUtils.isNull(cVar.getIcon_url())) {
                this.Mw.c(cVar.getIcon_url(), 10, false);
            }
            this.ahz.setText(l.f(cVar.getTitle(), 0, 16));
            this.aCm.setText(cVar.Gl());
            if (cVar.Gn()) {
                this.aCn.setVisibility(0);
            } else {
                this.aCn.setVisibility(8);
            }
            if (cVar.Go()) {
                this.aCi.setVisibility(0);
            } else {
                this.aCi.setVisibility(8);
            }
            switch (cVar.Gp()) {
                case 1:
                    this.aCo.setVisibility(0);
                    this.aCp.setVisibility(0);
                    return;
                case 2:
                    this.aCo.setVisibility(8);
                    this.aCp.setVisibility(8);
                    return;
                case 3:
                    this.aCo.setVisibility(0);
                    this.aCp.setVisibility(8);
                    return;
                default:
                    this.aCo.setVisibility(8);
                    this.aCp.setVisibility(0);
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        ba.i(this.aCq, u.addresslist_item_bg);
        this.Mw.setIsNight(TbadkApplication.getInst().getSkinType() == 1);
        return true;
    }
}
