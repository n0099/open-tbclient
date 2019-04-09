package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class g extends a<com.baidu.tieba.e.e> {
    private View egn;
    private View ego;
    private TextView egq;
    private TextView egr;
    private TextView egs;
    private TextView egt;
    private TextView egu;
    private String mForumId;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.egq = (TextView) view.findViewById(d.g.card_frs_game_hot_title);
        this.egr = (TextView) view.findViewById(d.g.card_frs_game_hot_topic_1);
        this.egs = (TextView) view.findViewById(d.g.card_frs_game_hot_topic_2);
        this.egt = (TextView) view.findViewById(d.g.card_frs_game_hot_topic_3);
        this.egu = (TextView) view.findViewById(d.g.card_frs_game_hot_topic_4);
        this.egr.setOnClickListener(this);
        this.egs.setOnClickListener(this);
        this.egt.setOnClickListener(this);
        this.egu.setOnClickListener(this);
        this.egn = view.findViewById(d.g.divider_line_1);
        this.ego = view.findViewById(d.g.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        al.k(getView(), d.C0277d.cp_bg_line_d);
        al.k(this.egn, d.C0277d.cp_bg_line_e);
        al.k(this.ego, d.C0277d.cp_bg_line_e);
        al.d(this.egq, d.C0277d.cp_cont_f, 1);
        al.d(this.egr, d.C0277d.cp_cont_b, 1);
        al.d(this.egs, d.C0277d.cp_cont_b, 1);
        al.d(this.egt, d.C0277d.cp_cont_b, 1);
        al.d(this.egu, d.C0277d.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.aUN() != null) {
            if (!TextUtils.isEmpty(eVar.aUN().title)) {
                this.egq.setText(eVar.aUN().title);
            }
            this.egr.setVisibility(8);
            this.egs.setVisibility(8);
            this.egt.setVisibility(8);
            this.egu.setVisibility(8);
            if (eVar.aUN().sub_nodes.size() >= 1) {
                this.egr.setVisibility(0);
                this.egr.setTag(eVar.aUN().sub_nodes.get(0).url);
                this.egr.setText(eVar.aUN().sub_nodes.get(0).title);
            }
            if (eVar.aUN().sub_nodes.size() >= 2) {
                this.egs.setVisibility(0);
                this.egs.setTag(eVar.aUN().sub_nodes.get(1).url);
                this.egs.setText(eVar.aUN().sub_nodes.get(1).title);
            }
            if (eVar.aUN().sub_nodes.size() >= 3) {
                this.egt.setVisibility(0);
                this.egt.setTag(eVar.aUN().sub_nodes.get(2).url);
                this.egt.setText(eVar.aUN().sub_nodes.get(2).title);
            }
            if (eVar.aUN().sub_nodes.size() >= 4) {
                this.egu.setVisibility(0);
                this.egu.setTag(eVar.aUN().sub_nodes.get(3).url);
                this.egu.setText(eVar.aUN().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.egr || view == this.egs || view == this.egt || view == this.egu) {
            TiebaStatic.log(new am("c13047").T("obj_locate", 8).bJ(ImageViewerConfig.FORUM_ID, this.mForumId));
            ba.adA().a((TbPageContext) com.baidu.adp.base.i.aK(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
