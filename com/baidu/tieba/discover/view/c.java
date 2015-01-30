package com.baidu.tieba.discover.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.discover.p;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.e.c> {
    private TextView Xo;
    private ImageView awq;
    private TextView awu;
    private ImageView awv;
    private View aww;
    private View awx;
    private View awy;
    private TbImageView zS;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.awy = view.findViewById(w.root_view);
        this.zS = (TbImageView) view.findViewById(w.icon);
        this.Xo = (TextView) view.findViewById(w.title);
        this.awu = (TextView) view.findViewById(w.desc);
        this.awq = (ImageView) view.findViewById(w.red_tip);
        this.awv = (ImageView) view.findViewById(w.red_new_tip);
        this.aww = view.findViewById(w.top_divider);
        this.awx = view.findViewById(w.bottom_divider);
        this.zS.setSupportNoImage(false);
        a(tbPageContext, TbadkApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.d
    /* renamed from: h */
    public void y(com.baidu.tieba.discover.data.c cVar) {
        super.y(cVar);
        if (cVar != null) {
            this.zS.setDefaultResource(p.fg(cVar.Dr()));
            if (!StringUtils.isNull(cVar.getIcon_url())) {
                this.zS.d(cVar.getIcon_url(), 10, false);
            }
            this.Xo.setText(m.f(cVar.getTitle(), 0, 16));
            this.awu.setText(cVar.Dq());
            if (cVar.Ds()) {
                this.awv.setVisibility(0);
            } else {
                this.awv.setVisibility(8);
            }
            if (cVar.Dt()) {
                this.awq.setVisibility(0);
            } else {
                this.awq.setVisibility(8);
            }
            switch (cVar.Du()) {
                case 1:
                    this.aww.setVisibility(0);
                    this.awx.setVisibility(0);
                    return;
                case 2:
                    this.aww.setVisibility(8);
                    this.awx.setVisibility(8);
                    return;
                case 3:
                    this.aww.setVisibility(0);
                    this.awx.setVisibility(8);
                    return;
                default:
                    this.aww.setVisibility(8);
                    this.awx.setVisibility(0);
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.g.a.a(tbPageContext, getRootView());
        bc.i(this.awy, v.addresslist_item_bg);
        this.zS.setIsNight(TbadkApplication.getInst().getSkinType() == 1);
        return true;
    }
}
