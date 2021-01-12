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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class f extends b<com.baidu.tieba.e.d> {
    private LinearLayout ipM;
    private TextView ipN;
    private LinearLayout ipO;
    private d ipP;
    private e ipQ;
    private e ipR;
    private com.baidu.tieba.e.a ipS;
    private com.baidu.tieba.e.b ipT;
    private com.baidu.tieba.e.b ipU;
    private View ipV;
    private View ipW;
    private a ipX;
    private String mForumId;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, BaseCardInfo baseCardInfo);
    }

    public f(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        this.mForumId = str;
        init(getView());
    }

    private void init(View view) {
        this.ipM = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.ipN = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.ipO = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.ipV = view.findViewById(R.id.divider_line_1);
        this.ipW = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.ipP == null) {
            this.ipP = new d(this.mTbPageContext, null, null);
        }
        this.ipP.E(0, 0, 0, 0);
        this.ipP.wN(8);
        this.ipP.wO(8);
        if (this.ipP.getView().getParent() != null) {
            ((ViewGroup) this.ipP.getView().getParent()).removeView(this.ipP.getView());
        }
        this.ipP.getView().setOnClickListener(this);
        this.ipP.getView().setVisibility(8);
        this.ipO.addView(this.ipP.getView());
        if (this.ipQ == null) {
            this.ipQ = new e(this.mTbPageContext);
        }
        this.ipQ.wO(8);
        this.ipQ.F(0, dimensionPixelSize, 0, 0);
        if (this.ipQ.getView().getParent() != null) {
            ((ViewGroup) this.ipQ.getView().getParent()).removeView(this.ipQ.getView());
        }
        this.ipQ.getView().setOnClickListener(this);
        this.ipQ.getView().setVisibility(8);
        this.ipO.addView(this.ipQ.getView());
        if (this.ipR == null) {
            this.ipR = new e(this.mTbPageContext);
        }
        this.ipR.wO(8);
        this.ipR.F(0, dimensionPixelSize, 0, 0);
        if (this.ipR.getView().getParent() != null) {
            ((ViewGroup) this.ipR.getView().getParent()).removeView(this.ipR.getView());
        }
        this.ipR.getView().setOnClickListener(this);
        this.ipR.getView().setVisibility(8);
        this.ipO.addView(this.ipR.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundResource(getView(), R.color.CAM_X0201);
        ao.setViewTextColor(this.ipN, R.color.CAM_X0106, 1);
        ao.setBackgroundResource(this.ipV, R.color.CAM_X0205);
        ao.setBackgroundResource(this.ipW, R.color.CAM_X0205);
        if (this.ipP != null) {
            this.ipP.onChangeSkinType(tbPageContext, i);
        }
        if (this.ipQ != null) {
            this.ipQ.onChangeSkinType(tbPageContext, i);
        }
        if (this.ipR != null) {
            this.ipR.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.csF() != null) {
            if (!TextUtils.isEmpty(dVar.csF().title)) {
                this.ipN.setText(dVar.csF().title);
            }
            List<bz> list = dVar.csF().sub_nodes;
            if (com.baidu.tbadk.core.util.x.getCount(list) >= 1) {
                this.ipS = new com.baidu.tieba.e.a();
                this.ipS.setData(list.get(0));
                this.ipP.getView().setVisibility(0);
                this.ipP.a(this.ipS);
            }
            if (com.baidu.tbadk.core.util.x.getCount(list) >= 2) {
                this.ipT = new com.baidu.tieba.e.b();
                this.ipT.setData(list.get(1));
                this.ipQ.getView().setVisibility(0);
                this.ipQ.a(this.ipT);
                this.ipQ.wP(8);
            }
            if (com.baidu.tbadk.core.util.x.getCount(list) >= 3) {
                this.ipU = new com.baidu.tieba.e.b();
                this.ipU.setData(list.get(2));
                this.ipR.getView().setVisibility(0);
                this.ipR.a(this.ipU);
                this.ipR.wP(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new aq("c13047").an("obj_locate", 6).dW("fid", this.mForumId));
        if (view == this.ipP.getView()) {
            if (this.ipS != null) {
                if (this.ipX != null) {
                    this.ipX.b(view, this.ipS);
                }
                Z(this.ipS.bkV());
            }
        } else if (view == this.ipQ.getView()) {
            if (this.ipT != null) {
                if (this.ipX != null) {
                    this.ipX.b(view, this.ipT);
                }
                Z(this.ipT.bkV());
            }
        } else if (view == this.ipR.getView() && this.ipU != null) {
            if (this.ipX != null) {
                this.ipX.b(view, this.ipU);
            }
            Z(this.ipU.bkV());
        }
    }

    private void Z(bz bzVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bzVar, null, m.bnj(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bzVar.getFid()));
        createFromThreadCfg.setForumName(bzVar.bnB());
        createFromThreadCfg.setStartFrom(0);
        m.Ic(bzVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.ipX = aVar;
    }
}
