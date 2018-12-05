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
    private View cTq;
    private View cTr;
    private TextView cTt;
    private TextView cTu;
    private TextView cTv;
    private TextView cTw;
    private TextView cTx;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cTt = (TextView) view.findViewById(e.g.card_frs_game_hot_title);
        this.cTu = (TextView) view.findViewById(e.g.card_frs_game_hot_topic_1);
        this.cTv = (TextView) view.findViewById(e.g.card_frs_game_hot_topic_2);
        this.cTw = (TextView) view.findViewById(e.g.card_frs_game_hot_topic_3);
        this.cTx = (TextView) view.findViewById(e.g.card_frs_game_hot_topic_4);
        this.cTu.setOnClickListener(this);
        this.cTv.setOnClickListener(this);
        this.cTw.setOnClickListener(this);
        this.cTx.setOnClickListener(this);
        this.cTq = view.findViewById(e.g.divider_line_1);
        this.cTr = view.findViewById(e.g.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.i(getView(), e.d.cp_bg_line_d);
        al.i(this.cTq, e.d.cp_bg_line_e);
        al.i(this.cTr, e.d.cp_bg_line_e);
        al.c(this.cTt, e.d.cp_cont_f, 1);
        al.c(this.cTu, e.d.cp_cont_b, 1);
        al.c(this.cTv, e.d.cp_cont_b, 1);
        al.c(this.cTw, e.d.cp_cont_b, 1);
        al.c(this.cTx, e.d.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.atL() != null) {
            if (!TextUtils.isEmpty(eVar.atL().title)) {
                this.cTt.setText(eVar.atL().title);
            }
            this.cTu.setVisibility(8);
            this.cTv.setVisibility(8);
            this.cTw.setVisibility(8);
            this.cTx.setVisibility(8);
            if (eVar.atL().sub_nodes.size() >= 1) {
                this.cTu.setVisibility(0);
                this.cTu.setTag(eVar.atL().sub_nodes.get(0).url);
                this.cTu.setText(eVar.atL().sub_nodes.get(0).title);
            }
            if (eVar.atL().sub_nodes.size() >= 2) {
                this.cTv.setVisibility(0);
                this.cTv.setTag(eVar.atL().sub_nodes.get(1).url);
                this.cTv.setText(eVar.atL().sub_nodes.get(1).title);
            }
            if (eVar.atL().sub_nodes.size() >= 3) {
                this.cTw.setVisibility(0);
                this.cTw.setTag(eVar.atL().sub_nodes.get(2).url);
                this.cTw.setText(eVar.atL().sub_nodes.get(2).title);
            }
            if (eVar.atL().sub_nodes.size() >= 4) {
                this.cTx.setVisibility(0);
                this.cTx.setTag(eVar.atL().sub_nodes.get(3).url);
                this.cTx.setText(eVar.atL().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cTu || view == this.cTv || view == this.cTw || view == this.cTx) {
            TiebaStatic.log(new am("c13047").x("obj_locate", 8).aA(ImageViewerConfig.FORUM_ID, this.mForumId));
            ay.Ef().a((TbPageContext) com.baidu.adp.base.i.aK(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
