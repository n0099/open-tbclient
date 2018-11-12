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
    private View cMJ;
    private View cMK;
    private TextView cMM;
    private TextView cMN;
    private TextView cMO;
    private TextView cMP;
    private TextView cMQ;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cMM = (TextView) view.findViewById(e.g.card_frs_game_hot_title);
        this.cMN = (TextView) view.findViewById(e.g.card_frs_game_hot_topic_1);
        this.cMO = (TextView) view.findViewById(e.g.card_frs_game_hot_topic_2);
        this.cMP = (TextView) view.findViewById(e.g.card_frs_game_hot_topic_3);
        this.cMQ = (TextView) view.findViewById(e.g.card_frs_game_hot_topic_4);
        this.cMN.setOnClickListener(this);
        this.cMO.setOnClickListener(this);
        this.cMP.setOnClickListener(this);
        this.cMQ.setOnClickListener(this);
        this.cMJ = view.findViewById(e.g.divider_line_1);
        this.cMK = view.findViewById(e.g.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.i(getView(), e.d.cp_bg_line_d);
        al.i(this.cMJ, e.d.cp_bg_line_e);
        al.i(this.cMK, e.d.cp_bg_line_e);
        al.c(this.cMM, e.d.cp_cont_f, 1);
        al.c(this.cMN, e.d.cp_cont_b, 1);
        al.c(this.cMO, e.d.cp_cont_b, 1);
        al.c(this.cMP, e.d.cp_cont_b, 1);
        al.c(this.cMQ, e.d.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.arZ() != null) {
            if (!TextUtils.isEmpty(eVar.arZ().title)) {
                this.cMM.setText(eVar.arZ().title);
            }
            this.cMN.setVisibility(8);
            this.cMO.setVisibility(8);
            this.cMP.setVisibility(8);
            this.cMQ.setVisibility(8);
            if (eVar.arZ().sub_nodes.size() >= 1) {
                this.cMN.setVisibility(0);
                this.cMN.setTag(eVar.arZ().sub_nodes.get(0).url);
                this.cMN.setText(eVar.arZ().sub_nodes.get(0).title);
            }
            if (eVar.arZ().sub_nodes.size() >= 2) {
                this.cMO.setVisibility(0);
                this.cMO.setTag(eVar.arZ().sub_nodes.get(1).url);
                this.cMO.setText(eVar.arZ().sub_nodes.get(1).title);
            }
            if (eVar.arZ().sub_nodes.size() >= 3) {
                this.cMP.setVisibility(0);
                this.cMP.setTag(eVar.arZ().sub_nodes.get(2).url);
                this.cMP.setText(eVar.arZ().sub_nodes.get(2).title);
            }
            if (eVar.arZ().sub_nodes.size() >= 4) {
                this.cMQ.setVisibility(0);
                this.cMQ.setTag(eVar.arZ().sub_nodes.get(3).url);
                this.cMQ.setText(eVar.arZ().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cMN || view == this.cMO || view == this.cMP || view == this.cMQ) {
            TiebaStatic.log(new am("c13047").x("obj_locate", 8).ax(ImageViewerConfig.FORUM_ID, this.mForumId));
            ay.Db().a((TbPageContext) com.baidu.adp.base.i.aK(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
