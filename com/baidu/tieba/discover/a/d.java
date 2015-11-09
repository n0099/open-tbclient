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
    private TbImageView MF;
    private TextView aBD;
    private ImageView aJU;
    private ImageView aJY;
    private View aJZ;
    private View aKa;
    private View aKb;
    private TextView alz;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aKb = view.findViewById(i.f.root_view);
        this.MF = (TbImageView) view.findViewById(i.f.icon);
        this.alz = (TextView) view.findViewById(i.f.title);
        this.aBD = (TextView) view.findViewById(i.f.desc);
        this.aJU = (ImageView) view.findViewById(i.f.red_tip);
        this.aJY = (ImageView) view.findViewById(i.f.red_new_tip);
        this.aJZ = view.findViewById(i.f.top_divider);
        this.aKa = view.findViewById(i.f.bottom_divider);
        a(tbPageContext, TbadkApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: h */
    public void B(com.baidu.tieba.discover.data.c cVar) {
        super.B(cVar);
        if (cVar != null) {
            this.MF.setDefaultResource(u.gr(cVar.HG()));
            if (!StringUtils.isNull(cVar.getIcon_url())) {
                this.MF.d(cVar.getIcon_url(), 10, false);
            }
            this.alz.setText(n.e(cVar.getTitle(), 0, 16));
            this.aBD.setText(cVar.HF());
            if (cVar.HH()) {
                this.aJY.setVisibility(0);
            } else {
                this.aJY.setVisibility(8);
            }
            if (cVar.HI()) {
                this.aJU.setVisibility(0);
            } else {
                this.aJU.setVisibility(8);
            }
            switch (cVar.HJ()) {
                case 1:
                    this.aJZ.setVisibility(0);
                    this.aKa.setVisibility(0);
                    return;
                case 2:
                    this.aJZ.setVisibility(8);
                    this.aKa.setVisibility(8);
                    return;
                case 3:
                    this.aJZ.setVisibility(0);
                    this.aKa.setVisibility(8);
                    return;
                default:
                    this.aJZ.setVisibility(8);
                    this.aKa.setVisibility(0);
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        an.i(this.aKb, i.e.addresslist_item_bg);
        this.MF.setIsNight(TbadkApplication.getInst().getSkinType() == 1);
        return true;
    }
}
