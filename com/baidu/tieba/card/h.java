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
    private View cLD;
    private View cLE;
    private TextView cLG;
    private TextView cLH;
    private TextView cLI;
    private TextView cLJ;
    private TextView cLK;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cLG = (TextView) view.findViewById(e.g.card_frs_game_hot_title);
        this.cLH = (TextView) view.findViewById(e.g.card_frs_game_hot_topic_1);
        this.cLI = (TextView) view.findViewById(e.g.card_frs_game_hot_topic_2);
        this.cLJ = (TextView) view.findViewById(e.g.card_frs_game_hot_topic_3);
        this.cLK = (TextView) view.findViewById(e.g.card_frs_game_hot_topic_4);
        this.cLH.setOnClickListener(this);
        this.cLI.setOnClickListener(this);
        this.cLJ.setOnClickListener(this);
        this.cLK.setOnClickListener(this);
        this.cLD = view.findViewById(e.g.divider_line_1);
        this.cLE = view.findViewById(e.g.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.i(getView(), e.d.cp_bg_line_d);
        al.i(this.cLD, e.d.cp_bg_line_e);
        al.i(this.cLE, e.d.cp_bg_line_e);
        al.c(this.cLG, e.d.cp_cont_f, 1);
        al.c(this.cLH, e.d.cp_cont_b, 1);
        al.c(this.cLI, e.d.cp_cont_b, 1);
        al.c(this.cLJ, e.d.cp_cont_b, 1);
        al.c(this.cLK, e.d.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.asz() != null) {
            if (!TextUtils.isEmpty(eVar.asz().title)) {
                this.cLG.setText(eVar.asz().title);
            }
            this.cLH.setVisibility(8);
            this.cLI.setVisibility(8);
            this.cLJ.setVisibility(8);
            this.cLK.setVisibility(8);
            if (eVar.asz().sub_nodes.size() >= 1) {
                this.cLH.setVisibility(0);
                this.cLH.setTag(eVar.asz().sub_nodes.get(0).url);
                this.cLH.setText(eVar.asz().sub_nodes.get(0).title);
            }
            if (eVar.asz().sub_nodes.size() >= 2) {
                this.cLI.setVisibility(0);
                this.cLI.setTag(eVar.asz().sub_nodes.get(1).url);
                this.cLI.setText(eVar.asz().sub_nodes.get(1).title);
            }
            if (eVar.asz().sub_nodes.size() >= 3) {
                this.cLJ.setVisibility(0);
                this.cLJ.setTag(eVar.asz().sub_nodes.get(2).url);
                this.cLJ.setText(eVar.asz().sub_nodes.get(2).title);
            }
            if (eVar.asz().sub_nodes.size() >= 4) {
                this.cLK.setVisibility(0);
                this.cLK.setTag(eVar.asz().sub_nodes.get(3).url);
                this.cLK.setText(eVar.asz().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cLH || view == this.cLI || view == this.cLJ || view == this.cLK) {
            TiebaStatic.log(new am("c13047").x("obj_locate", 8).ax(ImageViewerConfig.FORUM_ID, this.mForumId));
            ay.CU().a((TbPageContext) com.baidu.adp.base.i.aK(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
