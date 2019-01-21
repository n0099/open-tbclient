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
    private View cWS;
    private View cWT;
    private TextView cWV;
    private TextView cWW;
    private TextView cWX;
    private TextView cWY;
    private TextView cWZ;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cWV = (TextView) view.findViewById(e.g.card_frs_game_hot_title);
        this.cWW = (TextView) view.findViewById(e.g.card_frs_game_hot_topic_1);
        this.cWX = (TextView) view.findViewById(e.g.card_frs_game_hot_topic_2);
        this.cWY = (TextView) view.findViewById(e.g.card_frs_game_hot_topic_3);
        this.cWZ = (TextView) view.findViewById(e.g.card_frs_game_hot_topic_4);
        this.cWW.setOnClickListener(this);
        this.cWX.setOnClickListener(this);
        this.cWY.setOnClickListener(this);
        this.cWZ.setOnClickListener(this);
        this.cWS = view.findViewById(e.g.divider_line_1);
        this.cWT = view.findViewById(e.g.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.i(getView(), e.d.cp_bg_line_d);
        al.i(this.cWS, e.d.cp_bg_line_e);
        al.i(this.cWT, e.d.cp_bg_line_e);
        al.c(this.cWV, e.d.cp_cont_f, 1);
        al.c(this.cWW, e.d.cp_cont_b, 1);
        al.c(this.cWX, e.d.cp_cont_b, 1);
        al.c(this.cWY, e.d.cp_cont_b, 1);
        al.c(this.cWZ, e.d.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.auY() != null) {
            if (!TextUtils.isEmpty(eVar.auY().title)) {
                this.cWV.setText(eVar.auY().title);
            }
            this.cWW.setVisibility(8);
            this.cWX.setVisibility(8);
            this.cWY.setVisibility(8);
            this.cWZ.setVisibility(8);
            if (eVar.auY().sub_nodes.size() >= 1) {
                this.cWW.setVisibility(0);
                this.cWW.setTag(eVar.auY().sub_nodes.get(0).url);
                this.cWW.setText(eVar.auY().sub_nodes.get(0).title);
            }
            if (eVar.auY().sub_nodes.size() >= 2) {
                this.cWX.setVisibility(0);
                this.cWX.setTag(eVar.auY().sub_nodes.get(1).url);
                this.cWX.setText(eVar.auY().sub_nodes.get(1).title);
            }
            if (eVar.auY().sub_nodes.size() >= 3) {
                this.cWY.setVisibility(0);
                this.cWY.setTag(eVar.auY().sub_nodes.get(2).url);
                this.cWY.setText(eVar.auY().sub_nodes.get(2).title);
            }
            if (eVar.auY().sub_nodes.size() >= 4) {
                this.cWZ.setVisibility(0);
                this.cWZ.setTag(eVar.auY().sub_nodes.get(3).url);
                this.cWZ.setText(eVar.auY().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cWW || view == this.cWX || view == this.cWY || view == this.cWZ) {
            TiebaStatic.log(new am("c13047").y("obj_locate", 8).aB(ImageViewerConfig.FORUM_ID, this.mForumId));
            ay.Es().a((TbPageContext) com.baidu.adp.base.i.aK(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
