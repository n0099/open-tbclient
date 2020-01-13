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
/* loaded from: classes7.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.e.d> {
    private LinearLayout fFF;
    private TextView fFG;
    private LinearLayout fFH;
    private d fFI;
    private e fFJ;
    private e fFK;
    private com.baidu.tieba.e.a fFL;
    private com.baidu.tieba.e.b fFM;
    private com.baidu.tieba.e.b fFN;
    private View fFO;
    private View fFP;
    private a fFQ;
    private String mForumId;

    /* loaded from: classes7.dex */
    public interface a {
        void b(View view, com.baidu.tieba.card.data.b bVar);
    }

    public f(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        this.mForumId = str;
        init(getView());
    }

    private void init(View view) {
        this.fFF = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.fFG = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.fFH = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.fFO = view.findViewById(R.id.divider_line_1);
        this.fFP = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.fFI == null) {
            this.fFI = new d(this.mTbPageContext, null, null);
        }
        this.fFI.v(0, 0, 0, 0);
        this.fFI.rf(8);
        this.fFI.rg(8);
        if (this.fFI.getView().getParent() != null) {
            ((ViewGroup) this.fFI.getView().getParent()).removeView(this.fFI.getView());
        }
        this.fFI.getView().setOnClickListener(this);
        this.fFI.getView().setVisibility(8);
        this.fFH.addView(this.fFI.getView());
        if (this.fFJ == null) {
            this.fFJ = new e(this.mTbPageContext);
        }
        this.fFJ.rg(8);
        this.fFJ.w(0, dimensionPixelSize, 0, 0);
        if (this.fFJ.getView().getParent() != null) {
            ((ViewGroup) this.fFJ.getView().getParent()).removeView(this.fFJ.getView());
        }
        this.fFJ.getView().setOnClickListener(this);
        this.fFJ.getView().setVisibility(8);
        this.fFH.addView(this.fFJ.getView());
        if (this.fFK == null) {
            this.fFK = new e(this.mTbPageContext);
        }
        this.fFK.rg(8);
        this.fFK.w(0, dimensionPixelSize, 0, 0);
        if (this.fFK.getView().getParent() != null) {
            ((ViewGroup) this.fFK.getView().getParent()).removeView(this.fFK.getView());
        }
        this.fFK.getView().setOnClickListener(this);
        this.fFK.getView().setVisibility(8);
        this.fFH.addView(this.fFK.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        am.setViewTextColor(this.fFG, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.fFO, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.fFP, R.color.cp_bg_line_e);
        if (this.fFI != null) {
            this.fFI.onChangeSkinType(tbPageContext, i);
        }
        if (this.fFJ != null) {
            this.fFJ.onChangeSkinType(tbPageContext, i);
        }
        if (this.fFK != null) {
            this.fFK.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.buW() != null) {
            if (!TextUtils.isEmpty(dVar.buW().title)) {
                this.fFG.setText(dVar.buW().title);
            }
            List<bj> list = dVar.buW().sub_nodes;
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 1) {
                this.fFL = new com.baidu.tieba.e.a();
                this.fFL.setData(list.get(0));
                this.fFI.getView().setVisibility(0);
                this.fFI.a(this.fFL);
            }
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 2) {
                this.fFM = new com.baidu.tieba.e.b();
                this.fFM.setData(list.get(1));
                this.fFJ.getView().setVisibility(0);
                this.fFJ.a(this.fFM);
                this.fFJ.rh(8);
            }
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 3) {
                this.fFN = new com.baidu.tieba.e.b();
                this.fFN.setData(list.get(2));
                this.fFK.getView().setVisibility(0);
                this.fFK.a(this.fFN);
                this.fFK.rh(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13047").Z("obj_locate", 6).cp("fid", this.mForumId));
        if (view == this.fFI.getView()) {
            if (this.fFL != null) {
                if (this.fFQ != null) {
                    this.fFQ.b(view, this.fFL);
                }
                V(this.fFL.axQ());
            }
        } else if (view == this.fFJ.getView()) {
            if (this.fFM != null) {
                if (this.fFQ != null) {
                    this.fFQ.b(view, this.fFM);
                }
                V(this.fFM.axQ());
            }
        } else if (view == this.fFK.getView() && this.fFN != null) {
            if (this.fFQ != null) {
                this.fFQ.b(view, this.fFN);
            }
            V(this.fFN.axQ());
        }
    }

    private void V(bj bjVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bjVar, null, l.azJ(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bjVar.getFid()));
        createFromThreadCfg.setForumName(bjVar.aAc());
        createFromThreadCfg.setStartFrom(0);
        l.zC(bjVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.fFQ = aVar;
    }
}
