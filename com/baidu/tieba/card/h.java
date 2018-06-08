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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class h extends a<com.baidu.tieba.e.e> {
    private View cwM;
    private View cwN;
    private TextView cwP;
    private TextView cwQ;
    private TextView cwR;
    private TextView cwS;
    private TextView cwT;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cwP = (TextView) view.findViewById(d.g.card_frs_game_hot_title);
        this.cwQ = (TextView) view.findViewById(d.g.card_frs_game_hot_topic_1);
        this.cwR = (TextView) view.findViewById(d.g.card_frs_game_hot_topic_2);
        this.cwS = (TextView) view.findViewById(d.g.card_frs_game_hot_topic_3);
        this.cwT = (TextView) view.findViewById(d.g.card_frs_game_hot_topic_4);
        this.cwQ.setOnClickListener(this);
        this.cwR.setOnClickListener(this);
        this.cwS.setOnClickListener(this);
        this.cwT.setOnClickListener(this);
        this.cwM = view.findViewById(d.g.divider_line_1);
        this.cwN = view.findViewById(d.g.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.i(getView(), d.C0141d.cp_bg_line_d);
        al.i(this.cwM, d.C0141d.cp_bg_line_e);
        al.i(this.cwN, d.C0141d.cp_bg_line_e);
        al.c(this.cwP, d.C0141d.cp_cont_f, 1);
        al.c(this.cwQ, d.C0141d.cp_cont_b, 1);
        al.c(this.cwR, d.C0141d.cp_cont_b, 1);
        al.c(this.cwS, d.C0141d.cp_cont_b, 1);
        al.c(this.cwT, d.C0141d.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.anu() != null) {
            if (!TextUtils.isEmpty(eVar.anu().title)) {
                this.cwP.setText(eVar.anu().title);
            }
            this.cwQ.setVisibility(8);
            this.cwR.setVisibility(8);
            this.cwS.setVisibility(8);
            this.cwT.setVisibility(8);
            if (eVar.anu().sub_nodes.size() >= 1) {
                this.cwQ.setVisibility(0);
                this.cwQ.setTag(eVar.anu().sub_nodes.get(0).url);
                this.cwQ.setText(eVar.anu().sub_nodes.get(0).title);
            }
            if (eVar.anu().sub_nodes.size() >= 2) {
                this.cwR.setVisibility(0);
                this.cwR.setTag(eVar.anu().sub_nodes.get(1).url);
                this.cwR.setText(eVar.anu().sub_nodes.get(1).title);
            }
            if (eVar.anu().sub_nodes.size() >= 3) {
                this.cwS.setVisibility(0);
                this.cwS.setTag(eVar.anu().sub_nodes.get(2).url);
                this.cwS.setText(eVar.anu().sub_nodes.get(2).title);
            }
            if (eVar.anu().sub_nodes.size() >= 4) {
                this.cwT.setVisibility(0);
                this.cwT.setTag(eVar.anu().sub_nodes.get(3).url);
                this.cwT.setText(eVar.anu().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cwQ || view == this.cwR || view == this.cwS || view == this.cwT) {
            TiebaStatic.log(new am("c13047").r("obj_locate", 8).ah(ImageViewerConfig.FORUM_ID, this.mForumId));
            ay.zG().a((TbPageContext) com.baidu.adp.base.i.ad(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
