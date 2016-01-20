package com.baidu.tieba.discover.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.discover.t;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.d.b> {
    private TbImageView Nm;
    private TextView aFP;
    private ImageView aSn;
    private ImageView aSr;
    private View aSs;
    private View aSt;
    private View aSu;
    private TextView ahk;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aSu = view.findViewById(n.g.root_view);
        this.Nm = (TbImageView) view.findViewById(n.g.icon);
        this.ahk = (TextView) view.findViewById(n.g.title);
        this.aFP = (TextView) view.findViewById(n.g.desc);
        this.aSn = (ImageView) view.findViewById(n.g.red_tip);
        this.aSr = (ImageView) view.findViewById(n.g.red_new_tip);
        this.aSs = view.findViewById(n.g.top_divider);
        this.aSt = view.findViewById(n.g.bottom_divider);
        a(tbPageContext, TbadkApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: h */
    public void B(com.baidu.tieba.discover.data.c cVar) {
        super.B(cVar);
        if (cVar != null) {
            this.Nm.setDefaultResource(t.gR(cVar.Jq()));
            if (!StringUtils.isNull(cVar.getIcon_url())) {
                this.Nm.d(cVar.getIcon_url(), 10, false);
            }
            this.ahk.setText(o.e(cVar.getTitle(), 0, 16));
            this.aFP.setText(cVar.Jp());
            if (cVar.Jr()) {
                this.aSr.setVisibility(0);
            } else {
                this.aSr.setVisibility(8);
            }
            if (cVar.Js()) {
                this.aSn.setVisibility(0);
            } else {
                this.aSn.setVisibility(8);
            }
            switch (cVar.Jt()) {
                case 1:
                    this.aSs.setVisibility(0);
                    this.aSt.setVisibility(0);
                    return;
                case 2:
                    this.aSs.setVisibility(8);
                    this.aSt.setVisibility(8);
                    return;
                case 3:
                    this.aSs.setVisibility(0);
                    this.aSt.setVisibility(8);
                    return;
                default:
                    this.aSs.setVisibility(8);
                    this.aSt.setVisibility(0);
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        as.i(this.aSu, n.f.addresslist_item_bg);
        this.Nm.setIsNight(TbadkApplication.getInst().getSkinType() == 1);
        return true;
    }
}
