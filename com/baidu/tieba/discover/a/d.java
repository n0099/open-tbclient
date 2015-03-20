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
    private TbImageView Mu;
    private ImageView aCa;
    private TextView aCe;
    private ImageView aCf;
    private View aCg;
    private View aCh;
    private View aCi;
    private TextView ahr;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aCi = view.findViewById(v.root_view);
        this.Mu = (TbImageView) view.findViewById(v.icon);
        this.ahr = (TextView) view.findViewById(v.title);
        this.aCe = (TextView) view.findViewById(v.desc);
        this.aCa = (ImageView) view.findViewById(v.red_tip);
        this.aCf = (ImageView) view.findViewById(v.red_new_tip);
        this.aCg = view.findViewById(v.top_divider);
        this.aCh = view.findViewById(v.bottom_divider);
        a(tbPageContext, TbadkApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: h */
    public void A(com.baidu.tieba.discover.data.c cVar) {
        super.A(cVar);
        if (cVar != null) {
            this.Mu.setDefaultResource(p.fm(cVar.Gg()));
            if (!StringUtils.isNull(cVar.getIcon_url())) {
                this.Mu.c(cVar.getIcon_url(), 10, false);
            }
            this.ahr.setText(l.f(cVar.getTitle(), 0, 16));
            this.aCe.setText(cVar.Gf());
            if (cVar.Gh()) {
                this.aCf.setVisibility(0);
            } else {
                this.aCf.setVisibility(8);
            }
            if (cVar.Gi()) {
                this.aCa.setVisibility(0);
            } else {
                this.aCa.setVisibility(8);
            }
            switch (cVar.Gj()) {
                case 1:
                    this.aCg.setVisibility(0);
                    this.aCh.setVisibility(0);
                    return;
                case 2:
                    this.aCg.setVisibility(8);
                    this.aCh.setVisibility(8);
                    return;
                case 3:
                    this.aCg.setVisibility(0);
                    this.aCh.setVisibility(8);
                    return;
                default:
                    this.aCg.setVisibility(8);
                    this.aCh.setVisibility(0);
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        ba.i(this.aCi, u.addresslist_item_bg);
        this.Mu.setIsNight(TbadkApplication.getInst().getSkinType() == 1);
        return true;
    }
}
