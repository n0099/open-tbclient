package com.baidu.tieba.homepage.listview.card.e.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.homepage.listview.card.e.b;
import com.baidu.tieba.homepage.listview.g;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class a extends x.a implements g<b.a> {
    private View aFP;
    private View bAu;
    private HeadImageView bAv;
    private TextView bAw;
    private TextView bAx;
    private TextView bAy;
    private View bAz;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, View view) {
        super(view);
        this.mPageContext = tbPageContext;
        this.bAu = view.findViewById(n.f.hot_god_item_root);
        this.bAv = (HeadImageView) view.findViewById(n.f.hot_god_item_head);
        this.bAw = (TextView) view.findViewById(n.f.hot_god_item_name);
        this.bAx = (TextView) view.findViewById(n.f.hot_god_item_god_intro);
        this.bAy = (TextView) view.findViewById(n.f.hot_god_item_user_intro);
        this.bAz = view.findViewById(n.f.hot_god_item_right_arrow);
        this.aFP = view.findViewById(n.f.hot_god_top_divider);
        TX();
    }

    @Override // com.baidu.tieba.homepage.listview.g
    public View TY() {
        return getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.homepage.listview.g
    /* renamed from: a */
    public void D(b.a aVar) {
        this.bAv.d(aVar.avatar, 10, false);
        this.bAw.setText(ax.dw(aVar.userName));
        if (StringUtils.isNull(aVar.bAp)) {
            this.bAx.setText(n.i.god_intro_default);
        } else {
            this.bAx.setText(aVar.bAp);
        }
        this.bAy.setText(aVar.bAo);
        this.bAu.setOnClickListener(new b(this, aVar));
    }

    private void TX() {
        as.i(this.bAu, n.e.topic_name_selector);
        as.h((View) this.bAw, n.c.cp_cont_b);
        as.i((View) this.bAx, n.e.icon_shen);
        as.h((View) this.bAx, n.c.cp_cont_h);
        as.h((View) this.bAy, n.c.cp_cont_c);
        as.i(this.bAz, n.e.icon_arrow_list);
        as.j(this.aFP, n.c.cp_bg_line_c);
    }

    public void cZ(int i) {
        TX();
    }
}
