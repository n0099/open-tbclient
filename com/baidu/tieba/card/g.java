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
    private View egm;
    private View egn;
    private TextView egp;
    private TextView egq;
    private TextView egr;
    private TextView egs;
    private TextView egt;
    private String mForumId;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.egp = (TextView) view.findViewById(d.g.card_frs_game_hot_title);
        this.egq = (TextView) view.findViewById(d.g.card_frs_game_hot_topic_1);
        this.egr = (TextView) view.findViewById(d.g.card_frs_game_hot_topic_2);
        this.egs = (TextView) view.findViewById(d.g.card_frs_game_hot_topic_3);
        this.egt = (TextView) view.findViewById(d.g.card_frs_game_hot_topic_4);
        this.egq.setOnClickListener(this);
        this.egr.setOnClickListener(this);
        this.egs.setOnClickListener(this);
        this.egt.setOnClickListener(this);
        this.egm = view.findViewById(d.g.divider_line_1);
        this.egn = view.findViewById(d.g.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        al.k(getView(), d.C0277d.cp_bg_line_d);
        al.k(this.egm, d.C0277d.cp_bg_line_e);
        al.k(this.egn, d.C0277d.cp_bg_line_e);
        al.d(this.egp, d.C0277d.cp_cont_f, 1);
        al.d(this.egq, d.C0277d.cp_cont_b, 1);
        al.d(this.egr, d.C0277d.cp_cont_b, 1);
        al.d(this.egs, d.C0277d.cp_cont_b, 1);
        al.d(this.egt, d.C0277d.cp_cont_b, 1);
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
                this.egp.setText(eVar.aUN().title);
            }
            this.egq.setVisibility(8);
            this.egr.setVisibility(8);
            this.egs.setVisibility(8);
            this.egt.setVisibility(8);
            if (eVar.aUN().sub_nodes.size() >= 1) {
                this.egq.setVisibility(0);
                this.egq.setTag(eVar.aUN().sub_nodes.get(0).url);
                this.egq.setText(eVar.aUN().sub_nodes.get(0).title);
            }
            if (eVar.aUN().sub_nodes.size() >= 2) {
                this.egr.setVisibility(0);
                this.egr.setTag(eVar.aUN().sub_nodes.get(1).url);
                this.egr.setText(eVar.aUN().sub_nodes.get(1).title);
            }
            if (eVar.aUN().sub_nodes.size() >= 3) {
                this.egs.setVisibility(0);
                this.egs.setTag(eVar.aUN().sub_nodes.get(2).url);
                this.egs.setText(eVar.aUN().sub_nodes.get(2).title);
            }
            if (eVar.aUN().sub_nodes.size() >= 4) {
                this.egt.setVisibility(0);
                this.egt.setTag(eVar.aUN().sub_nodes.get(3).url);
                this.egt.setText(eVar.aUN().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.egq || view == this.egr || view == this.egs || view == this.egt) {
            TiebaStatic.log(new am("c13047").T("obj_locate", 8).bJ(ImageViewerConfig.FORUM_ID, this.mForumId));
            ba.adA().a((TbPageContext) com.baidu.adp.base.i.aK(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
