package com.baidu.tieba.discover.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.j;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.discover.p;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.e.c> {
    private ImageView avq;
    private TextView avu;
    private ImageView avv;
    private View avw;
    private View avx;
    private View avy;
    private TextView title;
    private TbImageView zS;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.avy = view.findViewById(w.root_view);
        this.zS = (TbImageView) view.findViewById(w.icon);
        this.title = (TextView) view.findViewById(w.title);
        this.avu = (TextView) view.findViewById(w.desc);
        this.avq = (ImageView) view.findViewById(w.red_tip);
        this.avv = (ImageView) view.findViewById(w.red_new_tip);
        this.avw = view.findViewById(w.top_divider);
        this.avx = view.findViewById(w.bottom_divider);
        this.zS.setSupportNoImage(false);
        a(tbPageContext, TbadkApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.d
    /* renamed from: h */
    public void y(com.baidu.tieba.discover.data.c cVar) {
        super.y(cVar);
        if (cVar != null) {
            this.zS.setDefaultResource(p.fb(cVar.CS()));
            if (!StringUtils.isNull(cVar.getIcon_url())) {
                this.zS.d(cVar.getIcon_url(), 10, false);
            }
            this.title.setText(j.f(cVar.getTitle(), 0, 16));
            this.avu.setText(cVar.CR());
            if (cVar.CT()) {
                this.avv.setVisibility(0);
            } else {
                this.avv.setVisibility(8);
            }
            if (cVar.CU()) {
                this.avq.setVisibility(0);
            } else {
                this.avq.setVisibility(8);
            }
            switch (cVar.CV()) {
                case 1:
                    this.avw.setVisibility(0);
                    this.avx.setVisibility(0);
                    return;
                case 2:
                    this.avw.setVisibility(8);
                    this.avx.setVisibility(8);
                    return;
                case 3:
                    this.avw.setVisibility(0);
                    this.avx.setVisibility(8);
                    return;
                default:
                    this.avw.setVisibility(8);
                    this.avx.setVisibility(0);
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.g.a.a(tbPageContext, getRootView());
        ax.i(this.avy, v.addresslist_item_bg);
        this.zS.setIsNight(TbadkApplication.getInst().getSkinType() == 1);
        return true;
    }
}
