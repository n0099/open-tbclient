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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.e.d> {
    private LinearLayout gnL;
    private TextView gnM;
    private LinearLayout gnN;
    private d gnO;
    private e gnP;
    private e gnQ;
    private com.baidu.tieba.e.a gnR;
    private com.baidu.tieba.e.b gnS;
    private com.baidu.tieba.e.b gnT;
    private View gnU;
    private View gnV;
    private a gnW;
    private String mForumId;

    /* loaded from: classes9.dex */
    public interface a {
        void b(View view, com.baidu.tieba.card.data.b bVar);
    }

    public f(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        this.mForumId = str;
        init(getView());
    }

    private void init(View view) {
        this.gnL = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.gnM = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.gnN = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.gnU = view.findViewById(R.id.divider_line_1);
        this.gnV = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.gnO == null) {
            this.gnO = new d(this.mTbPageContext, null, null);
        }
        this.gnO.v(0, 0, 0, 0);
        this.gnO.rG(8);
        this.gnO.rH(8);
        if (this.gnO.getView().getParent() != null) {
            ((ViewGroup) this.gnO.getView().getParent()).removeView(this.gnO.getView());
        }
        this.gnO.getView().setOnClickListener(this);
        this.gnO.getView().setVisibility(8);
        this.gnN.addView(this.gnO.getView());
        if (this.gnP == null) {
            this.gnP = new e(this.mTbPageContext);
        }
        this.gnP.rH(8);
        this.gnP.w(0, dimensionPixelSize, 0, 0);
        if (this.gnP.getView().getParent() != null) {
            ((ViewGroup) this.gnP.getView().getParent()).removeView(this.gnP.getView());
        }
        this.gnP.getView().setOnClickListener(this);
        this.gnP.getView().setVisibility(8);
        this.gnN.addView(this.gnP.getView());
        if (this.gnQ == null) {
            this.gnQ = new e(this.mTbPageContext);
        }
        this.gnQ.rH(8);
        this.gnQ.w(0, dimensionPixelSize, 0, 0);
        if (this.gnQ.getView().getParent() != null) {
            ((ViewGroup) this.gnQ.getView().getParent()).removeView(this.gnQ.getView());
        }
        this.gnQ.getView().setOnClickListener(this);
        this.gnQ.getView().setVisibility(8);
        this.gnN.addView(this.gnQ.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        am.setViewTextColor(this.gnM, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.gnU, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.gnV, R.color.cp_bg_line_e);
        if (this.gnO != null) {
            this.gnO.onChangeSkinType(tbPageContext, i);
        }
        if (this.gnP != null) {
            this.gnP.onChangeSkinType(tbPageContext, i);
        }
        if (this.gnQ != null) {
            this.gnQ.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.bGt() != null) {
            if (!TextUtils.isEmpty(dVar.bGt().title)) {
                this.gnM.setText(dVar.bGt().title);
            }
            List<bj> list = dVar.bGt().sub_nodes;
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 1) {
                this.gnR = new com.baidu.tieba.e.a();
                this.gnR.setData(list.get(0));
                this.gnO.getView().setVisibility(0);
                this.gnO.a(this.gnR);
            }
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 2) {
                this.gnS = new com.baidu.tieba.e.b();
                this.gnS.setData(list.get(1));
                this.gnP.getView().setVisibility(0);
                this.gnP.a(this.gnS);
                this.gnP.rI(8);
            }
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 3) {
                this.gnT = new com.baidu.tieba.e.b();
                this.gnT.setData(list.get(2));
                this.gnQ.getView().setVisibility(0);
                this.gnQ.a(this.gnT);
                this.gnQ.rI(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13047").af("obj_locate", 6).cI("fid", this.mForumId));
        if (view == this.gnO.getView()) {
            if (this.gnR != null) {
                if (this.gnW != null) {
                    this.gnW.b(view, this.gnR);
                }
                X(this.gnR.aIu());
            }
        } else if (view == this.gnP.getView()) {
            if (this.gnS != null) {
                if (this.gnW != null) {
                    this.gnW.b(view, this.gnS);
                }
                X(this.gnS.aIu());
            }
        } else if (view == this.gnQ.getView() && this.gnT != null) {
            if (this.gnW != null) {
                this.gnW.b(view, this.gnT);
            }
            X(this.gnT.aIu());
        }
    }

    private void X(bj bjVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bjVar, null, l.aKo(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bjVar.getFid()));
        createFromThreadCfg.setForumName(bjVar.aKH());
        createFromThreadCfg.setStartFrom(0);
        l.BE(bjVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.gnW = aVar;
    }
}
