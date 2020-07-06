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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class g extends b<com.baidu.tieba.e.d> {
    private LinearLayout gPG;
    private TextView gPH;
    private LinearLayout gPI;
    private e gPJ;
    private f gPK;
    private f gPL;
    private com.baidu.tieba.e.a gPM;
    private com.baidu.tieba.e.b gPN;
    private com.baidu.tieba.e.b gPO;
    private View gPP;
    private View gPQ;
    private a gPR;
    private String mForumId;

    /* loaded from: classes9.dex */
    public interface a {
        void b(View view, com.baidu.tieba.card.data.b bVar);
    }

    public g(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        this.mForumId = str;
        init(getView());
    }

    private void init(View view) {
        this.gPG = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.gPH = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.gPI = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.gPP = view.findViewById(R.id.divider_line_1);
        this.gPQ = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.gPJ == null) {
            this.gPJ = new e(this.mTbPageContext, null, null);
        }
        this.gPJ.w(0, 0, 0, 0);
        this.gPJ.sK(8);
        this.gPJ.sL(8);
        if (this.gPJ.getView().getParent() != null) {
            ((ViewGroup) this.gPJ.getView().getParent()).removeView(this.gPJ.getView());
        }
        this.gPJ.getView().setOnClickListener(this);
        this.gPJ.getView().setVisibility(8);
        this.gPI.addView(this.gPJ.getView());
        if (this.gPK == null) {
            this.gPK = new f(this.mTbPageContext);
        }
        this.gPK.sL(8);
        this.gPK.x(0, dimensionPixelSize, 0, 0);
        if (this.gPK.getView().getParent() != null) {
            ((ViewGroup) this.gPK.getView().getParent()).removeView(this.gPK.getView());
        }
        this.gPK.getView().setOnClickListener(this);
        this.gPK.getView().setVisibility(8);
        this.gPI.addView(this.gPK.getView());
        if (this.gPL == null) {
            this.gPL = new f(this.mTbPageContext);
        }
        this.gPL.sL(8);
        this.gPL.x(0, dimensionPixelSize, 0, 0);
        if (this.gPL.getView().getParent() != null) {
            ((ViewGroup) this.gPL.getView().getParent()).removeView(this.gPL.getView());
        }
        this.gPL.getView().setOnClickListener(this);
        this.gPL.getView().setVisibility(8);
        this.gPI.addView(this.gPL.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        an.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        an.setViewTextColor(this.gPH, R.color.cp_cont_f, 1);
        an.setBackgroundResource(this.gPP, R.color.cp_bg_line_e);
        an.setBackgroundResource(this.gPQ, R.color.cp_bg_line_e);
        if (this.gPJ != null) {
            this.gPJ.onChangeSkinType(tbPageContext, i);
        }
        if (this.gPK != null) {
            this.gPK.onChangeSkinType(tbPageContext, i);
        }
        if (this.gPL != null) {
            this.gPL.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.bPU() != null) {
            if (!TextUtils.isEmpty(dVar.bPU().title)) {
                this.gPH.setText(dVar.bPU().title);
            }
            List<bu> list = dVar.bPU().sub_nodes;
            if (com.baidu.tbadk.core.util.w.getCount(list) >= 1) {
                this.gPM = new com.baidu.tieba.e.a();
                this.gPM.setData(list.get(0));
                this.gPJ.getView().setVisibility(0);
                this.gPJ.a(this.gPM);
            }
            if (com.baidu.tbadk.core.util.w.getCount(list) >= 2) {
                this.gPN = new com.baidu.tieba.e.b();
                this.gPN.setData(list.get(1));
                this.gPK.getView().setVisibility(0);
                this.gPK.a(this.gPN);
                this.gPK.sM(8);
            }
            if (com.baidu.tbadk.core.util.w.getCount(list) >= 3) {
                this.gPO = new com.baidu.tieba.e.b();
                this.gPO.setData(list.get(2));
                this.gPL.getView().setVisibility(0);
                this.gPL.a(this.gPO);
                this.gPL.sM(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new ao("c13047").ag("obj_locate", 6).dk("fid", this.mForumId));
        if (view == this.gPJ.getView()) {
            if (this.gPM != null) {
                if (this.gPR != null) {
                    this.gPR.b(view, this.gPM);
                }
                Z(this.gPM.aPS());
            }
        } else if (view == this.gPK.getView()) {
            if (this.gPN != null) {
                if (this.gPR != null) {
                    this.gPR.b(view, this.gPN);
                }
                Z(this.gPN.aPS());
            }
        } else if (view == this.gPL.getView() && this.gPO != null) {
            if (this.gPR != null) {
                this.gPR.b(view, this.gPO);
            }
            Z(this.gPO.aPS());
        }
    }

    private void Z(bu buVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(buVar, null, m.aSb(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(buVar.getFid()));
        createFromThreadCfg.setForumName(buVar.aSt());
        createFromThreadCfg.setStartFrom(0);
        m.DO(buVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.gPR = aVar;
    }
}
