package com.baidu.tieba.discover.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.discover.u;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.e.c> {
    private TbImageView Ms;
    private ImageView aEl;
    private TextView aEp;
    private ImageView aEq;
    private View aEr;
    private View aEs;
    private View aEt;
    private TextView aiA;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aEt = view.findViewById(q.root_view);
        this.Ms = (TbImageView) view.findViewById(q.icon);
        this.aiA = (TextView) view.findViewById(q.title);
        this.aEp = (TextView) view.findViewById(q.desc);
        this.aEl = (ImageView) view.findViewById(q.red_tip);
        this.aEq = (ImageView) view.findViewById(q.red_new_tip);
        this.aEr = view.findViewById(q.top_divider);
        this.aEs = view.findViewById(q.bottom_divider);
        a(tbPageContext, TbadkApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: h */
    public void z(com.baidu.tieba.discover.data.c cVar) {
        super.z(cVar);
        if (cVar != null) {
            this.Ms.setDefaultResource(u.fM(cVar.Hq()));
            if (!StringUtils.isNull(cVar.getIcon_url())) {
                this.Ms.c(cVar.getIcon_url(), 10, false);
            }
            this.aiA.setText(l.f(cVar.getTitle(), 0, 16));
            this.aEp.setText(cVar.Hp());
            if (cVar.Hr()) {
                this.aEq.setVisibility(0);
            } else {
                this.aEq.setVisibility(8);
            }
            if (cVar.Hs()) {
                this.aEl.setVisibility(0);
            } else {
                this.aEl.setVisibility(8);
            }
            switch (cVar.Ht()) {
                case 1:
                    this.aEr.setVisibility(0);
                    this.aEs.setVisibility(0);
                    return;
                case 2:
                    this.aEr.setVisibility(8);
                    this.aEs.setVisibility(8);
                    return;
                case 3:
                    this.aEr.setVisibility(0);
                    this.aEs.setVisibility(8);
                    return;
                default:
                    this.aEr.setVisibility(8);
                    this.aEs.setVisibility(0);
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        ay.i(this.aEt, p.addresslist_item_bg);
        this.Ms.setIsNight(TbadkApplication.getInst().getSkinType() == 1);
        return true;
    }
}
