package com.baidu.tieba.discover.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.n;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.discover.u;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.d.b> {
    private TbImageView ME;
    private TextView aCJ;
    private ImageView aLa;
    private ImageView aLe;
    private View aLf;
    private View aLg;
    private View aLh;
    private TextView alu;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aLh = view.findViewById(i.f.root_view);
        this.ME = (TbImageView) view.findViewById(i.f.icon);
        this.alu = (TextView) view.findViewById(i.f.title);
        this.aCJ = (TextView) view.findViewById(i.f.desc);
        this.aLa = (ImageView) view.findViewById(i.f.red_tip);
        this.aLe = (ImageView) view.findViewById(i.f.red_new_tip);
        this.aLf = view.findViewById(i.f.top_divider);
        this.aLg = view.findViewById(i.f.bottom_divider);
        a(tbPageContext, TbadkApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: h */
    public void B(com.baidu.tieba.discover.data.c cVar) {
        super.B(cVar);
        if (cVar != null) {
            this.ME.setDefaultResource(u.gp(cVar.HJ()));
            if (!StringUtils.isNull(cVar.getIcon_url())) {
                this.ME.d(cVar.getIcon_url(), 10, false);
            }
            this.alu.setText(n.e(cVar.getTitle(), 0, 16));
            this.aCJ.setText(cVar.HI());
            if (cVar.HK()) {
                this.aLe.setVisibility(0);
            } else {
                this.aLe.setVisibility(8);
            }
            if (cVar.HL()) {
                this.aLa.setVisibility(0);
            } else {
                this.aLa.setVisibility(8);
            }
            switch (cVar.HM()) {
                case 1:
                    this.aLf.setVisibility(0);
                    this.aLg.setVisibility(0);
                    return;
                case 2:
                    this.aLf.setVisibility(8);
                    this.aLg.setVisibility(8);
                    return;
                case 3:
                    this.aLf.setVisibility(0);
                    this.aLg.setVisibility(8);
                    return;
                default:
                    this.aLf.setVisibility(8);
                    this.aLg.setVisibility(0);
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        an.i(this.aLh, i.e.addresslist_item_bg);
        this.ME.setIsNight(TbadkApplication.getInst().getSkinType() == 1);
        return true;
    }
}
