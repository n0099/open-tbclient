package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class h extends a<com.baidu.tieba.e.e> {
    private TextView cxA;
    private TextView cxB;
    private TextView cxC;
    private View cxv;
    private View cxw;
    private TextView cxy;
    private TextView cxz;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cxy = (TextView) view.findViewById(d.g.card_frs_game_hot_title);
        this.cxz = (TextView) view.findViewById(d.g.card_frs_game_hot_topic_1);
        this.cxA = (TextView) view.findViewById(d.g.card_frs_game_hot_topic_2);
        this.cxB = (TextView) view.findViewById(d.g.card_frs_game_hot_topic_3);
        this.cxC = (TextView) view.findViewById(d.g.card_frs_game_hot_topic_4);
        this.cxz.setOnClickListener(this);
        this.cxA.setOnClickListener(this);
        this.cxB.setOnClickListener(this);
        this.cxC.setOnClickListener(this);
        this.cxv = view.findViewById(d.g.divider_line_1);
        this.cxw = view.findViewById(d.g.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        am.i(getView(), d.C0140d.cp_bg_line_d);
        am.i(this.cxv, d.C0140d.cp_bg_line_e);
        am.i(this.cxw, d.C0140d.cp_bg_line_e);
        am.c(this.cxy, d.C0140d.cp_cont_f, 1);
        am.c(this.cxz, d.C0140d.cp_cont_b, 1);
        am.c(this.cxA, d.C0140d.cp_cont_b, 1);
        am.c(this.cxB, d.C0140d.cp_cont_b, 1);
        am.c(this.cxC, d.C0140d.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.ann() != null) {
            if (!TextUtils.isEmpty(eVar.ann().title)) {
                this.cxy.setText(eVar.ann().title);
            }
            this.cxz.setVisibility(8);
            this.cxA.setVisibility(8);
            this.cxB.setVisibility(8);
            this.cxC.setVisibility(8);
            if (eVar.ann().sub_nodes.size() >= 1) {
                this.cxz.setVisibility(0);
                this.cxz.setTag(eVar.ann().sub_nodes.get(0).url);
                this.cxz.setText(eVar.ann().sub_nodes.get(0).title);
            }
            if (eVar.ann().sub_nodes.size() >= 2) {
                this.cxA.setVisibility(0);
                this.cxA.setTag(eVar.ann().sub_nodes.get(1).url);
                this.cxA.setText(eVar.ann().sub_nodes.get(1).title);
            }
            if (eVar.ann().sub_nodes.size() >= 3) {
                this.cxB.setVisibility(0);
                this.cxB.setTag(eVar.ann().sub_nodes.get(2).url);
                this.cxB.setText(eVar.ann().sub_nodes.get(2).title);
            }
            if (eVar.ann().sub_nodes.size() >= 4) {
                this.cxC.setVisibility(0);
                this.cxC.setTag(eVar.ann().sub_nodes.get(3).url);
                this.cxC.setText(eVar.ann().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cxz || view == this.cxA || view == this.cxB || view == this.cxC) {
            TiebaStatic.log(new an("c13047").r("obj_locate", 8).af(ImageViewerConfig.FORUM_ID, this.mForumId));
            ay.zK().a((TbPageContext) com.baidu.adp.base.i.ad(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
