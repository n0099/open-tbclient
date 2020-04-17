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
    private LinearLayout gnF;
    private TextView gnG;
    private LinearLayout gnH;
    private d gnI;
    private e gnJ;
    private e gnK;
    private com.baidu.tieba.e.a gnL;
    private com.baidu.tieba.e.b gnM;
    private com.baidu.tieba.e.b gnN;
    private View gnO;
    private View gnP;
    private a gnQ;
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
        this.gnF = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.gnG = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.gnH = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.gnO = view.findViewById(R.id.divider_line_1);
        this.gnP = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.gnI == null) {
            this.gnI = new d(this.mTbPageContext, null, null);
        }
        this.gnI.v(0, 0, 0, 0);
        this.gnI.rG(8);
        this.gnI.rH(8);
        if (this.gnI.getView().getParent() != null) {
            ((ViewGroup) this.gnI.getView().getParent()).removeView(this.gnI.getView());
        }
        this.gnI.getView().setOnClickListener(this);
        this.gnI.getView().setVisibility(8);
        this.gnH.addView(this.gnI.getView());
        if (this.gnJ == null) {
            this.gnJ = new e(this.mTbPageContext);
        }
        this.gnJ.rH(8);
        this.gnJ.w(0, dimensionPixelSize, 0, 0);
        if (this.gnJ.getView().getParent() != null) {
            ((ViewGroup) this.gnJ.getView().getParent()).removeView(this.gnJ.getView());
        }
        this.gnJ.getView().setOnClickListener(this);
        this.gnJ.getView().setVisibility(8);
        this.gnH.addView(this.gnJ.getView());
        if (this.gnK == null) {
            this.gnK = new e(this.mTbPageContext);
        }
        this.gnK.rH(8);
        this.gnK.w(0, dimensionPixelSize, 0, 0);
        if (this.gnK.getView().getParent() != null) {
            ((ViewGroup) this.gnK.getView().getParent()).removeView(this.gnK.getView());
        }
        this.gnK.getView().setOnClickListener(this);
        this.gnK.getView().setVisibility(8);
        this.gnH.addView(this.gnK.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        am.setViewTextColor(this.gnG, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.gnO, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.gnP, R.color.cp_bg_line_e);
        if (this.gnI != null) {
            this.gnI.onChangeSkinType(tbPageContext, i);
        }
        if (this.gnJ != null) {
            this.gnJ.onChangeSkinType(tbPageContext, i);
        }
        if (this.gnK != null) {
            this.gnK.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.bGu() != null) {
            if (!TextUtils.isEmpty(dVar.bGu().title)) {
                this.gnG.setText(dVar.bGu().title);
            }
            List<bj> list = dVar.bGu().sub_nodes;
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 1) {
                this.gnL = new com.baidu.tieba.e.a();
                this.gnL.setData(list.get(0));
                this.gnI.getView().setVisibility(0);
                this.gnI.a(this.gnL);
            }
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 2) {
                this.gnM = new com.baidu.tieba.e.b();
                this.gnM.setData(list.get(1));
                this.gnJ.getView().setVisibility(0);
                this.gnJ.a(this.gnM);
                this.gnJ.rI(8);
            }
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 3) {
                this.gnN = new com.baidu.tieba.e.b();
                this.gnN.setData(list.get(2));
                this.gnK.getView().setVisibility(0);
                this.gnK.a(this.gnN);
                this.gnK.rI(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13047").af("obj_locate", 6).cI("fid", this.mForumId));
        if (view == this.gnI.getView()) {
            if (this.gnL != null) {
                if (this.gnQ != null) {
                    this.gnQ.b(view, this.gnL);
                }
                X(this.gnL.aIw());
            }
        } else if (view == this.gnJ.getView()) {
            if (this.gnM != null) {
                if (this.gnQ != null) {
                    this.gnQ.b(view, this.gnM);
                }
                X(this.gnM.aIw());
            }
        } else if (view == this.gnK.getView() && this.gnN != null) {
            if (this.gnQ != null) {
                this.gnQ.b(view, this.gnN);
            }
            X(this.gnN.aIw());
        }
    }

    private void X(bj bjVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bjVar, null, l.aKq(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bjVar.getFid()));
        createFromThreadCfg.setForumName(bjVar.aKJ());
        createFromThreadCfg.setStartFrom(0);
        l.BB(bjVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.gnQ = aVar;
    }
}
