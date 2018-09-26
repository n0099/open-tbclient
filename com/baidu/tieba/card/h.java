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
    private View cDi;
    private View cDj;
    private TextView cDl;
    private TextView cDm;
    private TextView cDn;
    private TextView cDo;
    private TextView cDp;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cDl = (TextView) view.findViewById(e.g.card_frs_game_hot_title);
        this.cDm = (TextView) view.findViewById(e.g.card_frs_game_hot_topic_1);
        this.cDn = (TextView) view.findViewById(e.g.card_frs_game_hot_topic_2);
        this.cDo = (TextView) view.findViewById(e.g.card_frs_game_hot_topic_3);
        this.cDp = (TextView) view.findViewById(e.g.card_frs_game_hot_topic_4);
        this.cDm.setOnClickListener(this);
        this.cDn.setOnClickListener(this);
        this.cDo.setOnClickListener(this);
        this.cDp.setOnClickListener(this);
        this.cDi = view.findViewById(e.g.divider_line_1);
        this.cDj = view.findViewById(e.g.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.i(getView(), e.d.cp_bg_line_d);
        al.i(this.cDi, e.d.cp_bg_line_e);
        al.i(this.cDj, e.d.cp_bg_line_e);
        al.c(this.cDl, e.d.cp_cont_f, 1);
        al.c(this.cDm, e.d.cp_cont_b, 1);
        al.c(this.cDn, e.d.cp_cont_b, 1);
        al.c(this.cDo, e.d.cp_cont_b, 1);
        al.c(this.cDp, e.d.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.apb() != null) {
            if (!TextUtils.isEmpty(eVar.apb().title)) {
                this.cDl.setText(eVar.apb().title);
            }
            this.cDm.setVisibility(8);
            this.cDn.setVisibility(8);
            this.cDo.setVisibility(8);
            this.cDp.setVisibility(8);
            if (eVar.apb().sub_nodes.size() >= 1) {
                this.cDm.setVisibility(0);
                this.cDm.setTag(eVar.apb().sub_nodes.get(0).url);
                this.cDm.setText(eVar.apb().sub_nodes.get(0).title);
            }
            if (eVar.apb().sub_nodes.size() >= 2) {
                this.cDn.setVisibility(0);
                this.cDn.setTag(eVar.apb().sub_nodes.get(1).url);
                this.cDn.setText(eVar.apb().sub_nodes.get(1).title);
            }
            if (eVar.apb().sub_nodes.size() >= 3) {
                this.cDo.setVisibility(0);
                this.cDo.setTag(eVar.apb().sub_nodes.get(2).url);
                this.cDo.setText(eVar.apb().sub_nodes.get(2).title);
            }
            if (eVar.apb().sub_nodes.size() >= 4) {
                this.cDp.setVisibility(0);
                this.cDp.setTag(eVar.apb().sub_nodes.get(3).url);
                this.cDp.setText(eVar.apb().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cDm || view == this.cDn || view == this.cDo || view == this.cDp) {
            TiebaStatic.log(new am("c13047").w("obj_locate", 8).al(ImageViewerConfig.FORUM_ID, this.mForumId));
            ay.AN().a((TbPageContext) com.baidu.adp.base.i.aK(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
