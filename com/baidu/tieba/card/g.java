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
    private View egA;
    private View egB;
    private TextView egD;
    private TextView egE;
    private TextView egF;
    private TextView egG;
    private TextView egH;
    private String mForumId;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.egD = (TextView) view.findViewById(d.g.card_frs_game_hot_title);
        this.egE = (TextView) view.findViewById(d.g.card_frs_game_hot_topic_1);
        this.egF = (TextView) view.findViewById(d.g.card_frs_game_hot_topic_2);
        this.egG = (TextView) view.findViewById(d.g.card_frs_game_hot_topic_3);
        this.egH = (TextView) view.findViewById(d.g.card_frs_game_hot_topic_4);
        this.egE.setOnClickListener(this);
        this.egF.setOnClickListener(this);
        this.egG.setOnClickListener(this);
        this.egH.setOnClickListener(this);
        this.egA = view.findViewById(d.g.divider_line_1);
        this.egB = view.findViewById(d.g.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        al.k(getView(), d.C0277d.cp_bg_line_d);
        al.k(this.egA, d.C0277d.cp_bg_line_e);
        al.k(this.egB, d.C0277d.cp_bg_line_e);
        al.d(this.egD, d.C0277d.cp_cont_f, 1);
        al.d(this.egE, d.C0277d.cp_cont_b, 1);
        al.d(this.egF, d.C0277d.cp_cont_b, 1);
        al.d(this.egG, d.C0277d.cp_cont_b, 1);
        al.d(this.egH, d.C0277d.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.aUP() != null) {
            if (!TextUtils.isEmpty(eVar.aUP().title)) {
                this.egD.setText(eVar.aUP().title);
            }
            this.egE.setVisibility(8);
            this.egF.setVisibility(8);
            this.egG.setVisibility(8);
            this.egH.setVisibility(8);
            if (eVar.aUP().sub_nodes.size() >= 1) {
                this.egE.setVisibility(0);
                this.egE.setTag(eVar.aUP().sub_nodes.get(0).url);
                this.egE.setText(eVar.aUP().sub_nodes.get(0).title);
            }
            if (eVar.aUP().sub_nodes.size() >= 2) {
                this.egF.setVisibility(0);
                this.egF.setTag(eVar.aUP().sub_nodes.get(1).url);
                this.egF.setText(eVar.aUP().sub_nodes.get(1).title);
            }
            if (eVar.aUP().sub_nodes.size() >= 3) {
                this.egG.setVisibility(0);
                this.egG.setTag(eVar.aUP().sub_nodes.get(2).url);
                this.egG.setText(eVar.aUP().sub_nodes.get(2).title);
            }
            if (eVar.aUP().sub_nodes.size() >= 4) {
                this.egH.setVisibility(0);
                this.egH.setTag(eVar.aUP().sub_nodes.get(3).url);
                this.egH.setText(eVar.aUP().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.egE || view == this.egF || view == this.egG || view == this.egH) {
            TiebaStatic.log(new am("c13047").T("obj_locate", 8).bJ(ImageViewerConfig.FORUM_ID, this.mForumId));
            ba.adD().a((TbPageContext) com.baidu.adp.base.i.aK(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
