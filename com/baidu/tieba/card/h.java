package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class h extends a<com.baidu.tieba.e.e> {
    private View cWg;
    private View cWh;
    private TextView cWj;
    private TextView cWk;
    private TextView cWl;
    private TextView cWm;
    private TextView cWn;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cWj = (TextView) view.findViewById(e.g.card_frs_game_hot_title);
        this.cWk = (TextView) view.findViewById(e.g.card_frs_game_hot_topic_1);
        this.cWl = (TextView) view.findViewById(e.g.card_frs_game_hot_topic_2);
        this.cWm = (TextView) view.findViewById(e.g.card_frs_game_hot_topic_3);
        this.cWn = (TextView) view.findViewById(e.g.card_frs_game_hot_topic_4);
        this.cWk.setOnClickListener(this);
        this.cWl.setOnClickListener(this);
        this.cWm.setOnClickListener(this);
        this.cWn.setOnClickListener(this);
        this.cWg = view.findViewById(e.g.divider_line_1);
        this.cWh = view.findViewById(e.g.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.i(getView(), e.d.cp_bg_line_d);
        al.i(this.cWg, e.d.cp_bg_line_e);
        al.i(this.cWh, e.d.cp_bg_line_e);
        al.c(this.cWj, e.d.cp_cont_f, 1);
        al.c(this.cWk, e.d.cp_cont_b, 1);
        al.c(this.cWl, e.d.cp_cont_b, 1);
        al.c(this.cWm, e.d.cp_cont_b, 1);
        al.c(this.cWn, e.d.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.auA() != null) {
            if (!TextUtils.isEmpty(eVar.auA().title)) {
                this.cWj.setText(eVar.auA().title);
            }
            this.cWk.setVisibility(8);
            this.cWl.setVisibility(8);
            this.cWm.setVisibility(8);
            this.cWn.setVisibility(8);
            if (eVar.auA().sub_nodes.size() >= 1) {
                this.cWk.setVisibility(0);
                this.cWk.setTag(eVar.auA().sub_nodes.get(0).url);
                this.cWk.setText(eVar.auA().sub_nodes.get(0).title);
            }
            if (eVar.auA().sub_nodes.size() >= 2) {
                this.cWl.setVisibility(0);
                this.cWl.setTag(eVar.auA().sub_nodes.get(1).url);
                this.cWl.setText(eVar.auA().sub_nodes.get(1).title);
            }
            if (eVar.auA().sub_nodes.size() >= 3) {
                this.cWm.setVisibility(0);
                this.cWm.setTag(eVar.auA().sub_nodes.get(2).url);
                this.cWm.setText(eVar.auA().sub_nodes.get(2).title);
            }
            if (eVar.auA().sub_nodes.size() >= 4) {
                this.cWn.setVisibility(0);
                this.cWn.setTag(eVar.auA().sub_nodes.get(3).url);
                this.cWn.setText(eVar.auA().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cWk || view == this.cWl || view == this.cWm || view == this.cWn) {
            TiebaStatic.log(new am("c13047").x("obj_locate", 8).aA(ImageViewerConfig.FORUM_ID, this.mForumId));
            ay.Ef().a((TbPageContext) com.baidu.adp.base.i.aK(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
