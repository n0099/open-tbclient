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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class h extends a<com.baidu.tieba.e.e> {
    private View cxs;
    private View cxt;
    private TextView cxv;
    private TextView cxw;
    private TextView cxx;
    private TextView cxy;
    private TextView cxz;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cxv = (TextView) view.findViewById(f.g.card_frs_game_hot_title);
        this.cxw = (TextView) view.findViewById(f.g.card_frs_game_hot_topic_1);
        this.cxx = (TextView) view.findViewById(f.g.card_frs_game_hot_topic_2);
        this.cxy = (TextView) view.findViewById(f.g.card_frs_game_hot_topic_3);
        this.cxz = (TextView) view.findViewById(f.g.card_frs_game_hot_topic_4);
        this.cxw.setOnClickListener(this);
        this.cxx.setOnClickListener(this);
        this.cxy.setOnClickListener(this);
        this.cxz.setOnClickListener(this);
        this.cxs = view.findViewById(f.g.divider_line_1);
        this.cxt = view.findViewById(f.g.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        am.i(getView(), f.d.cp_bg_line_d);
        am.i(this.cxs, f.d.cp_bg_line_e);
        am.i(this.cxt, f.d.cp_bg_line_e);
        am.c(this.cxv, f.d.cp_cont_f, 1);
        am.c(this.cxw, f.d.cp_cont_b, 1);
        am.c(this.cxx, f.d.cp_cont_b, 1);
        am.c(this.cxy, f.d.cp_cont_b, 1);
        am.c(this.cxz, f.d.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.anp() != null) {
            if (!TextUtils.isEmpty(eVar.anp().title)) {
                this.cxv.setText(eVar.anp().title);
            }
            this.cxw.setVisibility(8);
            this.cxx.setVisibility(8);
            this.cxy.setVisibility(8);
            this.cxz.setVisibility(8);
            if (eVar.anp().sub_nodes.size() >= 1) {
                this.cxw.setVisibility(0);
                this.cxw.setTag(eVar.anp().sub_nodes.get(0).url);
                this.cxw.setText(eVar.anp().sub_nodes.get(0).title);
            }
            if (eVar.anp().sub_nodes.size() >= 2) {
                this.cxx.setVisibility(0);
                this.cxx.setTag(eVar.anp().sub_nodes.get(1).url);
                this.cxx.setText(eVar.anp().sub_nodes.get(1).title);
            }
            if (eVar.anp().sub_nodes.size() >= 3) {
                this.cxy.setVisibility(0);
                this.cxy.setTag(eVar.anp().sub_nodes.get(2).url);
                this.cxy.setText(eVar.anp().sub_nodes.get(2).title);
            }
            if (eVar.anp().sub_nodes.size() >= 4) {
                this.cxz.setVisibility(0);
                this.cxz.setTag(eVar.anp().sub_nodes.get(3).url);
                this.cxz.setText(eVar.anp().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cxw || view == this.cxx || view == this.cxy || view == this.cxz) {
            TiebaStatic.log(new an("c13047").r("obj_locate", 8).ae(ImageViewerConfig.FORUM_ID, this.mForumId));
            az.zI().a((TbPageContext) com.baidu.adp.base.i.ad(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
