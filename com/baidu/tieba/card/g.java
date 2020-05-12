package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class g extends a<com.baidu.tieba.e.e> {
    private View gnU;
    private View gnV;
    private TextView gnX;
    private TextView gnY;
    private TextView gnZ;
    private TextView goa;
    private TextView gob;
    private String mForumId;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.gnX = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.gnY = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.gnZ = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.goa = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.gob = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.gnY.setOnClickListener(this);
        this.gnZ.setOnClickListener(this);
        this.goa.setOnClickListener(this);
        this.gob.setOnClickListener(this);
        this.gnU = view.findViewById(R.id.divider_line_1);
        this.gnV = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        am.setBackgroundResource(this.gnU, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.gnV, R.color.cp_bg_line_e);
        am.setViewTextColor(this.gnX, R.color.cp_cont_f, 1);
        am.setViewTextColor(this.gnY, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.gnZ, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.goa, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.gob, R.color.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.bGu() != null) {
            if (!TextUtils.isEmpty(eVar.bGu().title)) {
                this.gnX.setText(eVar.bGu().title);
            }
            this.gnY.setVisibility(8);
            this.gnZ.setVisibility(8);
            this.goa.setVisibility(8);
            this.gob.setVisibility(8);
            if (eVar.bGu().sub_nodes.size() >= 1) {
                this.gnY.setVisibility(0);
                this.gnY.setTag(eVar.bGu().sub_nodes.get(0).url);
                this.gnY.setText(eVar.bGu().sub_nodes.get(0).title);
            }
            if (eVar.bGu().sub_nodes.size() >= 2) {
                this.gnZ.setVisibility(0);
                this.gnZ.setTag(eVar.bGu().sub_nodes.get(1).url);
                this.gnZ.setText(eVar.bGu().sub_nodes.get(1).title);
            }
            if (eVar.bGu().sub_nodes.size() >= 3) {
                this.goa.setVisibility(0);
                this.goa.setTag(eVar.bGu().sub_nodes.get(2).url);
                this.goa.setText(eVar.bGu().sub_nodes.get(2).title);
            }
            if (eVar.bGu().sub_nodes.size() >= 4) {
                this.gob.setVisibility(0);
                this.gob.setTag(eVar.bGu().sub_nodes.get(3).url);
                this.gob.setText(eVar.bGu().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gnY || view == this.gnZ || view == this.goa || view == this.gob) {
            TiebaStatic.log(new an("c13047").af("obj_locate", 8).cI("fid", this.mForumId));
            ba.aOV().a((TbPageContext) com.baidu.adp.base.i.G(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
