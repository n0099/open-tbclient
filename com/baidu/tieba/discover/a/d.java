package com.baidu.tieba.discover.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.n;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.discover.u;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.d.b> {
    private TbImageView MD;
    private TextView aCy;
    private ImageView aKP;
    private ImageView aKT;
    private View aKU;
    private View aKV;
    private View aKW;
    private TextView alt;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aKW = view.findViewById(i.f.root_view);
        this.MD = (TbImageView) view.findViewById(i.f.icon);
        this.alt = (TextView) view.findViewById(i.f.title);
        this.aCy = (TextView) view.findViewById(i.f.desc);
        this.aKP = (ImageView) view.findViewById(i.f.red_tip);
        this.aKT = (ImageView) view.findViewById(i.f.red_new_tip);
        this.aKU = view.findViewById(i.f.top_divider);
        this.aKV = view.findViewById(i.f.bottom_divider);
        a(tbPageContext, TbadkApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: h */
    public void B(com.baidu.tieba.discover.data.c cVar) {
        super.B(cVar);
        if (cVar != null) {
            this.MD.setDefaultResource(u.gp(cVar.HN()));
            if (!StringUtils.isNull(cVar.getIcon_url())) {
                this.MD.d(cVar.getIcon_url(), 10, false);
            }
            this.alt.setText(n.e(cVar.getTitle(), 0, 16));
            this.aCy.setText(cVar.HM());
            if (cVar.HO()) {
                this.aKT.setVisibility(0);
            } else {
                this.aKT.setVisibility(8);
            }
            if (cVar.HP()) {
                this.aKP.setVisibility(0);
            } else {
                this.aKP.setVisibility(8);
            }
            switch (cVar.HQ()) {
                case 1:
                    this.aKU.setVisibility(0);
                    this.aKV.setVisibility(0);
                    return;
                case 2:
                    this.aKU.setVisibility(8);
                    this.aKV.setVisibility(8);
                    return;
                case 3:
                    this.aKU.setVisibility(0);
                    this.aKV.setVisibility(8);
                    return;
                default:
                    this.aKU.setVisibility(8);
                    this.aKV.setVisibility(0);
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        am.i(this.aKW, i.e.addresslist_item_bg);
        this.MD.setIsNight(TbadkApplication.getInst().getSkinType() == 1);
        return true;
    }
}
