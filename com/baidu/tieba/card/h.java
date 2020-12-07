package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class h extends b<com.baidu.tieba.f.e> {
    private View iif;
    private View iig;
    private TextView iii;
    private TextView iij;
    private TextView iik;
    private TextView iil;
    private TextView iim;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.iii = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.iij = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.iik = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.iil = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.iim = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.iij.setOnClickListener(this);
        this.iik.setOnClickListener(this);
        this.iil.setOnClickListener(this);
        this.iim.setOnClickListener(this);
        this.iif = view.findViewById(R.id.divider_line_1);
        this.iig = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(getView(), R.color.CAM_X0201);
        ap.setBackgroundResource(this.iif, R.color.CAM_X0205);
        ap.setBackgroundResource(this.iig, R.color.CAM_X0205);
        ap.setViewTextColor(this.iii, R.color.CAM_X0106, 1);
        ap.setViewTextColor(this.iij, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.iik, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.iil, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.iim, R.color.CAM_X0105, 1);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.f.e eVar) {
        if (eVar != null && eVar.ctD() != null) {
            if (!TextUtils.isEmpty(eVar.ctD().title)) {
                this.iii.setText(eVar.ctD().title);
            }
            this.iij.setVisibility(8);
            this.iik.setVisibility(8);
            this.iil.setVisibility(8);
            this.iim.setVisibility(8);
            if (eVar.ctD().sub_nodes.size() >= 1) {
                this.iij.setVisibility(0);
                this.iij.setTag(eVar.ctD().sub_nodes.get(0).url);
                this.iij.setText(eVar.ctD().sub_nodes.get(0).title);
            }
            if (eVar.ctD().sub_nodes.size() >= 2) {
                this.iik.setVisibility(0);
                this.iik.setTag(eVar.ctD().sub_nodes.get(1).url);
                this.iik.setText(eVar.ctD().sub_nodes.get(1).title);
            }
            if (eVar.ctD().sub_nodes.size() >= 3) {
                this.iil.setVisibility(0);
                this.iil.setTag(eVar.ctD().sub_nodes.get(2).url);
                this.iil.setText(eVar.ctD().sub_nodes.get(2).title);
            }
            if (eVar.ctD().sub_nodes.size() >= 4) {
                this.iim.setVisibility(0);
                this.iim.setTag(eVar.ctD().sub_nodes.get(3).url);
                this.iim.setText(eVar.ctD().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iij || view == this.iik || view == this.iil || view == this.iim) {
            TiebaStatic.log(new ar("c13047").al("obj_locate", 8).dY("fid", this.mForumId));
            bf.bua().a((TbPageContext) com.baidu.adp.base.i.J(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
