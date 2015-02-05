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
    private TextView Xl;
    private ImageView awn;
    private TextView awr;
    private ImageView aws;
    private View awt;
    private View awu;
    private View awv;
    private TbImageView zP;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.awv = view.findViewById(w.root_view);
        this.zP = (TbImageView) view.findViewById(w.icon);
        this.Xl = (TextView) view.findViewById(w.title);
        this.awr = (TextView) view.findViewById(w.desc);
        this.awn = (ImageView) view.findViewById(w.red_tip);
        this.aws = (ImageView) view.findViewById(w.red_new_tip);
        this.awt = view.findViewById(w.top_divider);
        this.awu = view.findViewById(w.bottom_divider);
        this.zP.setSupportNoImage(false);
        a(tbPageContext, TbadkApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.d
    /* renamed from: h */
    public void y(com.baidu.tieba.discover.data.c cVar) {
        super.y(cVar);
        if (cVar != null) {
            this.zP.setDefaultResource(p.fd(cVar.Dl()));
            if (!StringUtils.isNull(cVar.getIcon_url())) {
                this.zP.d(cVar.getIcon_url(), 10, false);
            }
            this.Xl.setText(m.f(cVar.getTitle(), 0, 16));
            this.awr.setText(cVar.Dk());
            if (cVar.Dm()) {
                this.aws.setVisibility(0);
            } else {
                this.aws.setVisibility(8);
            }
            if (cVar.Dn()) {
                this.awn.setVisibility(0);
            } else {
                this.awn.setVisibility(8);
            }
            switch (cVar.Do()) {
                case 1:
                    this.awt.setVisibility(0);
                    this.awu.setVisibility(0);
                    return;
                case 2:
                    this.awt.setVisibility(8);
                    this.awu.setVisibility(8);
                    return;
                case 3:
                    this.awt.setVisibility(0);
                    this.awu.setVisibility(8);
                    return;
                default:
                    this.awt.setVisibility(8);
                    this.awu.setVisibility(0);
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.g.a.a(tbPageContext, getRootView());
        bc.i(this.awv, v.addresslist_item_bg);
        this.zP.setIsNight(TbadkApplication.getInst().getSkinType() == 1);
        return true;
    }
}
