package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes22.dex */
public class g extends b<com.baidu.tieba.e.d> {
    private LinearLayout hQC;
    private TextView hQD;
    private LinearLayout hQE;
    private e hQF;
    private f hQG;
    private f hQH;
    private com.baidu.tieba.e.a hQI;
    private com.baidu.tieba.e.b hQJ;
    private com.baidu.tieba.e.b hQK;
    private View hQL;
    private View hQM;
    private a hQN;
    private String mForumId;

    /* loaded from: classes22.dex */
    public interface a {
        void b(View view, com.baidu.tieba.card.data.b bVar);
    }

    public g(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        this.mForumId = str;
        init(getView());
    }

    private void init(View view) {
        this.hQC = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.hQD = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.hQE = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.hQL = view.findViewById(R.id.divider_line_1);
        this.hQM = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.hQF == null) {
            this.hQF = new e(this.mTbPageContext, null, null);
        }
        this.hQF.y(0, 0, 0, 0);
        this.hQF.wP(8);
        this.hQF.wQ(8);
        if (this.hQF.getView().getParent() != null) {
            ((ViewGroup) this.hQF.getView().getParent()).removeView(this.hQF.getView());
        }
        this.hQF.getView().setOnClickListener(this);
        this.hQF.getView().setVisibility(8);
        this.hQE.addView(this.hQF.getView());
        if (this.hQG == null) {
            this.hQG = new f(this.mTbPageContext);
        }
        this.hQG.wQ(8);
        this.hQG.z(0, dimensionPixelSize, 0, 0);
        if (this.hQG.getView().getParent() != null) {
            ((ViewGroup) this.hQG.getView().getParent()).removeView(this.hQG.getView());
        }
        this.hQG.getView().setOnClickListener(this);
        this.hQG.getView().setVisibility(8);
        this.hQE.addView(this.hQG.getView());
        if (this.hQH == null) {
            this.hQH = new f(this.mTbPageContext);
        }
        this.hQH.wQ(8);
        this.hQH.z(0, dimensionPixelSize, 0, 0);
        if (this.hQH.getView().getParent() != null) {
            ((ViewGroup) this.hQH.getView().getParent()).removeView(this.hQH.getView());
        }
        this.hQH.getView().setOnClickListener(this);
        this.hQH.getView().setVisibility(8);
        this.hQE.addView(this.hQH.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        ap.setViewTextColor(this.hQD, R.color.cp_cont_f, 1);
        ap.setBackgroundResource(this.hQL, R.color.cp_bg_line_e);
        ap.setBackgroundResource(this.hQM, R.color.cp_bg_line_e);
        if (this.hQF != null) {
            this.hQF.onChangeSkinType(tbPageContext, i);
        }
        if (this.hQG != null) {
            this.hQG.onChangeSkinType(tbPageContext, i);
        }
        if (this.hQH != null) {
            this.hQH.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.cnk() != null) {
            if (!TextUtils.isEmpty(dVar.cnk().title)) {
                this.hQD.setText(dVar.cnk().title);
            }
            List<bw> list = dVar.cnk().sub_nodes;
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 1) {
                this.hQI = new com.baidu.tieba.e.a();
                this.hQI.setData(list.get(0));
                this.hQF.getView().setVisibility(0);
                this.hQF.a(this.hQI);
            }
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 2) {
                this.hQJ = new com.baidu.tieba.e.b();
                this.hQJ.setData(list.get(1));
                this.hQG.getView().setVisibility(0);
                this.hQG.a(this.hQJ);
                this.hQG.wR(8);
            }
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 3) {
                this.hQK = new com.baidu.tieba.e.b();
                this.hQK.setData(list.get(2));
                this.hQH.getView().setVisibility(0);
                this.hQH.a(this.hQK);
                this.hQH.wR(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new aq("c13047").aj("obj_locate", 6).dR("fid", this.mForumId));
        if (view == this.hQF.getView()) {
            if (this.hQI != null) {
                if (this.hQN != null) {
                    this.hQN.b(view, this.hQI);
                }
                X(this.hQI.bhz());
            }
        } else if (view == this.hQG.getView()) {
            if (this.hQJ != null) {
                if (this.hQN != null) {
                    this.hQN.b(view, this.hQJ);
                }
                X(this.hQJ.bhz());
            }
        } else if (view == this.hQH.getView() && this.hQK != null) {
            if (this.hQN != null) {
                this.hQN.b(view, this.hQK);
            }
            X(this.hQK.bhz());
        }
    }

    private void X(bw bwVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bwVar, null, n.bjM(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bwVar.getFid()));
        createFromThreadCfg.setForumName(bwVar.bke());
        createFromThreadCfg.setStartFrom(0);
        n.II(bwVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.hQN = aVar;
    }
}
