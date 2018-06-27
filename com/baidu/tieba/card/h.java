package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class h extends a<com.baidu.tieba.e.e> {
    private View cuT;
    private View cuU;
    private TextView cuW;
    private TextView cuX;
    private TextView cuY;
    private TextView cuZ;
    private TextView cva;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cuW = (TextView) view.findViewById(d.g.card_frs_game_hot_title);
        this.cuX = (TextView) view.findViewById(d.g.card_frs_game_hot_topic_1);
        this.cuY = (TextView) view.findViewById(d.g.card_frs_game_hot_topic_2);
        this.cuZ = (TextView) view.findViewById(d.g.card_frs_game_hot_topic_3);
        this.cva = (TextView) view.findViewById(d.g.card_frs_game_hot_topic_4);
        this.cuX.setOnClickListener(this);
        this.cuY.setOnClickListener(this);
        this.cuZ.setOnClickListener(this);
        this.cva.setOnClickListener(this);
        this.cuT = view.findViewById(d.g.divider_line_1);
        this.cuU = view.findViewById(d.g.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        am.i(getView(), d.C0142d.cp_bg_line_d);
        am.i(this.cuT, d.C0142d.cp_bg_line_e);
        am.i(this.cuU, d.C0142d.cp_bg_line_e);
        am.c(this.cuW, d.C0142d.cp_cont_f, 1);
        am.c(this.cuX, d.C0142d.cp_cont_b, 1);
        am.c(this.cuY, d.C0142d.cp_cont_b, 1);
        am.c(this.cuZ, d.C0142d.cp_cont_b, 1);
        am.c(this.cva, d.C0142d.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.amO() != null) {
            if (!TextUtils.isEmpty(eVar.amO().title)) {
                this.cuW.setText(eVar.amO().title);
            }
            this.cuX.setVisibility(8);
            this.cuY.setVisibility(8);
            this.cuZ.setVisibility(8);
            this.cva.setVisibility(8);
            if (eVar.amO().sub_nodes.size() >= 1) {
                this.cuX.setVisibility(0);
                this.cuX.setTag(eVar.amO().sub_nodes.get(0).url);
                this.cuX.setText(eVar.amO().sub_nodes.get(0).title);
            }
            if (eVar.amO().sub_nodes.size() >= 2) {
                this.cuY.setVisibility(0);
                this.cuY.setTag(eVar.amO().sub_nodes.get(1).url);
                this.cuY.setText(eVar.amO().sub_nodes.get(1).title);
            }
            if (eVar.amO().sub_nodes.size() >= 3) {
                this.cuZ.setVisibility(0);
                this.cuZ.setTag(eVar.amO().sub_nodes.get(2).url);
                this.cuZ.setText(eVar.amO().sub_nodes.get(2).title);
            }
            if (eVar.amO().sub_nodes.size() >= 4) {
                this.cva.setVisibility(0);
                this.cva.setTag(eVar.amO().sub_nodes.get(3).url);
                this.cva.setText(eVar.amO().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cuX || view == this.cuY || view == this.cuZ || view == this.cva) {
            TiebaStatic.log(new an("c13047").r("obj_locate", 8).ah(ImageViewerConfig.FORUM_ID, this.mForumId));
            az.zV().a((TbPageContext) com.baidu.adp.base.i.ad(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
