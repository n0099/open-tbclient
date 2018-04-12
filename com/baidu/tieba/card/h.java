package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class h extends a<com.baidu.tieba.e.e> {
    private View cnb;
    private View cnc;
    private TextView cne;
    private TextView cnf;
    private TextView cng;
    private TextView cnh;
    private TextView cni;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view2) {
        this.cne = (TextView) view2.findViewById(d.g.card_frs_game_hot_title);
        this.cnf = (TextView) view2.findViewById(d.g.card_frs_game_hot_topic_1);
        this.cng = (TextView) view2.findViewById(d.g.card_frs_game_hot_topic_2);
        this.cnh = (TextView) view2.findViewById(d.g.card_frs_game_hot_topic_3);
        this.cni = (TextView) view2.findViewById(d.g.card_frs_game_hot_topic_4);
        this.cnf.setOnClickListener(this);
        this.cng.setOnClickListener(this);
        this.cnh.setOnClickListener(this);
        this.cni.setOnClickListener(this);
        this.cnb = view2.findViewById(d.g.divider_line_1);
        this.cnc = view2.findViewById(d.g.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        ak.i(getView(), d.C0126d.cp_bg_line_d);
        ak.i(this.cnb, d.C0126d.cp_bg_line_e);
        ak.i(this.cnc, d.C0126d.cp_bg_line_e);
        ak.c(this.cne, d.C0126d.cp_cont_f, 1);
        ak.c(this.cnf, d.C0126d.cp_cont_b, 1);
        ak.c(this.cng, d.C0126d.cp_cont_b, 1);
        ak.c(this.cnh, d.C0126d.cp_cont_b, 1);
        ak.c(this.cni, d.C0126d.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.ajx() != null) {
            if (!TextUtils.isEmpty(eVar.ajx().title)) {
                this.cne.setText(eVar.ajx().title);
            }
            this.cnf.setVisibility(8);
            this.cng.setVisibility(8);
            this.cnh.setVisibility(8);
            this.cni.setVisibility(8);
            if (eVar.ajx().sub_nodes.size() >= 1) {
                this.cnf.setVisibility(0);
                this.cnf.setTag(eVar.ajx().sub_nodes.get(0).url);
                this.cnf.setText(eVar.ajx().sub_nodes.get(0).title);
            }
            if (eVar.ajx().sub_nodes.size() >= 2) {
                this.cng.setVisibility(0);
                this.cng.setTag(eVar.ajx().sub_nodes.get(1).url);
                this.cng.setText(eVar.ajx().sub_nodes.get(1).title);
            }
            if (eVar.ajx().sub_nodes.size() >= 3) {
                this.cnh.setVisibility(0);
                this.cnh.setTag(eVar.ajx().sub_nodes.get(2).url);
                this.cnh.setText(eVar.ajx().sub_nodes.get(2).title);
            }
            if (eVar.ajx().sub_nodes.size() >= 4) {
                this.cni.setVisibility(0);
                this.cni.setTag(eVar.ajx().sub_nodes.get(3).url);
                this.cni.setText(eVar.ajx().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.cnf || view2 == this.cng || view2 == this.cnh || view2 == this.cni) {
            TiebaStatic.log(new al("c13047").r("obj_locate", 8).ac(ImageViewerConfig.FORUM_ID, this.mForumId));
            ax.wg().a((TbPageContext) com.baidu.adp.base.i.ab(this.mTbPageContext.getPageActivity()), new String[]{(String) view2.getTag()}, true);
        }
    }
}
