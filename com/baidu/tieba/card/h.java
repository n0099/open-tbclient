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
    private View cmY;
    private View cmZ;
    private TextView cnb;
    private TextView cnc;
    private TextView cnd;
    private TextView cne;
    private TextView cnf;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view2) {
        this.cnb = (TextView) view2.findViewById(d.g.card_frs_game_hot_title);
        this.cnc = (TextView) view2.findViewById(d.g.card_frs_game_hot_topic_1);
        this.cnd = (TextView) view2.findViewById(d.g.card_frs_game_hot_topic_2);
        this.cne = (TextView) view2.findViewById(d.g.card_frs_game_hot_topic_3);
        this.cnf = (TextView) view2.findViewById(d.g.card_frs_game_hot_topic_4);
        this.cnc.setOnClickListener(this);
        this.cnd.setOnClickListener(this);
        this.cne.setOnClickListener(this);
        this.cnf.setOnClickListener(this);
        this.cmY = view2.findViewById(d.g.divider_line_1);
        this.cmZ = view2.findViewById(d.g.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        ak.i(getView(), d.C0126d.cp_bg_line_d);
        ak.i(this.cmY, d.C0126d.cp_bg_line_e);
        ak.i(this.cmZ, d.C0126d.cp_bg_line_e);
        ak.c(this.cnb, d.C0126d.cp_cont_f, 1);
        ak.c(this.cnc, d.C0126d.cp_cont_b, 1);
        ak.c(this.cnd, d.C0126d.cp_cont_b, 1);
        ak.c(this.cne, d.C0126d.cp_cont_b, 1);
        ak.c(this.cnf, d.C0126d.cp_cont_b, 1);
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
                this.cnb.setText(eVar.ajx().title);
            }
            this.cnc.setVisibility(8);
            this.cnd.setVisibility(8);
            this.cne.setVisibility(8);
            this.cnf.setVisibility(8);
            if (eVar.ajx().sub_nodes.size() >= 1) {
                this.cnc.setVisibility(0);
                this.cnc.setTag(eVar.ajx().sub_nodes.get(0).url);
                this.cnc.setText(eVar.ajx().sub_nodes.get(0).title);
            }
            if (eVar.ajx().sub_nodes.size() >= 2) {
                this.cnd.setVisibility(0);
                this.cnd.setTag(eVar.ajx().sub_nodes.get(1).url);
                this.cnd.setText(eVar.ajx().sub_nodes.get(1).title);
            }
            if (eVar.ajx().sub_nodes.size() >= 3) {
                this.cne.setVisibility(0);
                this.cne.setTag(eVar.ajx().sub_nodes.get(2).url);
                this.cne.setText(eVar.ajx().sub_nodes.get(2).title);
            }
            if (eVar.ajx().sub_nodes.size() >= 4) {
                this.cnf.setVisibility(0);
                this.cnf.setTag(eVar.ajx().sub_nodes.get(3).url);
                this.cnf.setText(eVar.ajx().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.cnc || view2 == this.cnd || view2 == this.cne || view2 == this.cnf) {
            TiebaStatic.log(new al("c13047").r("obj_locate", 8).ac(ImageViewerConfig.FORUM_ID, this.mForumId));
            ax.wg().a((TbPageContext) com.baidu.adp.base.i.ab(this.mTbPageContext.getPageActivity()), new String[]{(String) view2.getTag()}, true);
        }
    }
}
