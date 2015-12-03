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
    private TbImageView MW;
    private TextView aEp;
    private View aOA;
    private View aOB;
    private View aOC;
    private ImageView aOv;
    private ImageView aOz;
    private TextView agd;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aOC = view.findViewById(n.f.root_view);
        this.MW = (TbImageView) view.findViewById(n.f.icon);
        this.agd = (TextView) view.findViewById(n.f.title);
        this.aEp = (TextView) view.findViewById(n.f.desc);
        this.aOv = (ImageView) view.findViewById(n.f.red_tip);
        this.aOz = (ImageView) view.findViewById(n.f.red_new_tip);
        this.aOA = view.findViewById(n.f.top_divider);
        this.aOB = view.findViewById(n.f.bottom_divider);
        a(tbPageContext, TbadkApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: h */
    public void B(com.baidu.tieba.discover.data.c cVar) {
        super.B(cVar);
        if (cVar != null) {
            this.MW.setDefaultResource(t.gG(cVar.IZ()));
            if (!StringUtils.isNull(cVar.getIcon_url())) {
                this.MW.d(cVar.getIcon_url(), 10, false);
            }
            this.agd.setText(o.e(cVar.getTitle(), 0, 16));
            this.aEp.setText(cVar.IY());
            if (cVar.Ja()) {
                this.aOz.setVisibility(0);
            } else {
                this.aOz.setVisibility(8);
            }
            if (cVar.Jb()) {
                this.aOv.setVisibility(0);
            } else {
                this.aOv.setVisibility(8);
            }
            switch (cVar.Jc()) {
                case 1:
                    this.aOA.setVisibility(0);
                    this.aOB.setVisibility(0);
                    return;
                case 2:
                    this.aOA.setVisibility(8);
                    this.aOB.setVisibility(8);
                    return;
                case 3:
                    this.aOA.setVisibility(0);
                    this.aOB.setVisibility(8);
                    return;
                default:
                    this.aOA.setVisibility(8);
                    this.aOB.setVisibility(0);
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        as.i(this.aOC, n.e.addresslist_item_bg);
        this.MW.setIsNight(TbadkApplication.getInst().getSkinType() == 1);
        return true;
    }
}
