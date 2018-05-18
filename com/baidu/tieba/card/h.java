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
    private View coi;
    private View coj;
    private TextView col;

    /* renamed from: com  reason: collision with root package name */
    private TextView f10com;
    private TextView con;
    private TextView coo;
    private TextView cop;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view2) {
        this.col = (TextView) view2.findViewById(d.g.card_frs_game_hot_title);
        this.f10com = (TextView) view2.findViewById(d.g.card_frs_game_hot_topic_1);
        this.con = (TextView) view2.findViewById(d.g.card_frs_game_hot_topic_2);
        this.coo = (TextView) view2.findViewById(d.g.card_frs_game_hot_topic_3);
        this.cop = (TextView) view2.findViewById(d.g.card_frs_game_hot_topic_4);
        this.f10com.setOnClickListener(this);
        this.con.setOnClickListener(this);
        this.coo.setOnClickListener(this);
        this.cop.setOnClickListener(this);
        this.coi = view2.findViewById(d.g.divider_line_1);
        this.coj = view2.findViewById(d.g.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        ak.i(getView(), d.C0126d.cp_bg_line_d);
        ak.i(this.coi, d.C0126d.cp_bg_line_e);
        ak.i(this.coj, d.C0126d.cp_bg_line_e);
        ak.c(this.col, d.C0126d.cp_cont_f, 1);
        ak.c(this.f10com, d.C0126d.cp_cont_b, 1);
        ak.c(this.con, d.C0126d.cp_cont_b, 1);
        ak.c(this.coo, d.C0126d.cp_cont_b, 1);
        ak.c(this.cop, d.C0126d.cp_cont_b, 1);
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
                this.col.setText(eVar.ajx().title);
            }
            this.f10com.setVisibility(8);
            this.con.setVisibility(8);
            this.coo.setVisibility(8);
            this.cop.setVisibility(8);
            if (eVar.ajx().sub_nodes.size() >= 1) {
                this.f10com.setVisibility(0);
                this.f10com.setTag(eVar.ajx().sub_nodes.get(0).url);
                this.f10com.setText(eVar.ajx().sub_nodes.get(0).title);
            }
            if (eVar.ajx().sub_nodes.size() >= 2) {
                this.con.setVisibility(0);
                this.con.setTag(eVar.ajx().sub_nodes.get(1).url);
                this.con.setText(eVar.ajx().sub_nodes.get(1).title);
            }
            if (eVar.ajx().sub_nodes.size() >= 3) {
                this.coo.setVisibility(0);
                this.coo.setTag(eVar.ajx().sub_nodes.get(2).url);
                this.coo.setText(eVar.ajx().sub_nodes.get(2).title);
            }
            if (eVar.ajx().sub_nodes.size() >= 4) {
                this.cop.setVisibility(0);
                this.cop.setTag(eVar.ajx().sub_nodes.get(3).url);
                this.cop.setText(eVar.ajx().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.f10com || view2 == this.con || view2 == this.coo || view2 == this.cop) {
            TiebaStatic.log(new al("c13047").r("obj_locate", 8).ac(ImageViewerConfig.FORUM_ID, this.mForumId));
            ax.wf().a((TbPageContext) com.baidu.adp.base.i.ab(this.mTbPageContext.getPageActivity()), new String[]{(String) view2.getTag()}, true);
        }
    }
}
