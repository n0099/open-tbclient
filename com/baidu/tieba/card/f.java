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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class f extends b<com.baidu.tieba.e.d> {
    private LinearLayout ivE;
    private TextView ivF;
    private LinearLayout ivG;
    private d ivH;
    private e ivI;
    private e ivJ;
    private com.baidu.tieba.e.a ivK;
    private com.baidu.tieba.e.b ivL;
    private com.baidu.tieba.e.b ivM;
    private View ivN;
    private View ivO;
    private a ivP;
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
        this.ivE = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.ivF = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.ivG = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.ivN = view.findViewById(R.id.divider_line_1);
        this.ivO = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.ivH == null) {
            this.ivH = new d(this.mTbPageContext, null, null);
        }
        this.ivH.E(0, 0, 0, 0);
        this.ivH.wX(8);
        this.ivH.wY(8);
        if (this.ivH.getView().getParent() != null) {
            ((ViewGroup) this.ivH.getView().getParent()).removeView(this.ivH.getView());
        }
        this.ivH.getView().setOnClickListener(this);
        this.ivH.getView().setVisibility(8);
        this.ivG.addView(this.ivH.getView());
        if (this.ivI == null) {
            this.ivI = new e(this.mTbPageContext);
        }
        this.ivI.wY(8);
        this.ivI.F(0, dimensionPixelSize, 0, 0);
        if (this.ivI.getView().getParent() != null) {
            ((ViewGroup) this.ivI.getView().getParent()).removeView(this.ivI.getView());
        }
        this.ivI.getView().setOnClickListener(this);
        this.ivI.getView().setVisibility(8);
        this.ivG.addView(this.ivI.getView());
        if (this.ivJ == null) {
            this.ivJ = new e(this.mTbPageContext);
        }
        this.ivJ.wY(8);
        this.ivJ.F(0, dimensionPixelSize, 0, 0);
        if (this.ivJ.getView().getParent() != null) {
            ((ViewGroup) this.ivJ.getView().getParent()).removeView(this.ivJ.getView());
        }
        this.ivJ.getView().setOnClickListener(this);
        this.ivJ.getView().setVisibility(8);
        this.ivG.addView(this.ivJ.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(getView(), R.color.CAM_X0201);
        ap.setViewTextColor(this.ivF, R.color.CAM_X0106, 1);
        ap.setBackgroundResource(this.ivN, R.color.CAM_X0205);
        ap.setBackgroundResource(this.ivO, R.color.CAM_X0205);
        if (this.ivH != null) {
            this.ivH.onChangeSkinType(tbPageContext, i);
        }
        if (this.ivI != null) {
            this.ivI.onChangeSkinType(tbPageContext, i);
        }
        if (this.ivJ != null) {
            this.ivJ.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.ctY() != null) {
            if (!TextUtils.isEmpty(dVar.ctY().title)) {
                this.ivF.setText(dVar.ctY().title);
            }
            List<cb> list = dVar.ctY().sub_nodes;
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 1) {
                this.ivK = new com.baidu.tieba.e.a();
                this.ivK.setData(list.get(0));
                this.ivH.getView().setVisibility(0);
                this.ivH.a(this.ivK);
            }
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 2) {
                this.ivL = new com.baidu.tieba.e.b();
                this.ivL.setData(list.get(1));
                this.ivI.getView().setVisibility(0);
                this.ivI.a(this.ivL);
                this.ivI.wZ(8);
            }
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 3) {
                this.ivM = new com.baidu.tieba.e.b();
                this.ivM.setData(list.get(2));
                this.ivJ.getView().setVisibility(0);
                this.ivJ.a(this.ivM);
                this.ivJ.wZ(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new ar("c13047").ap("obj_locate", 6).dR("fid", this.mForumId));
        if (view == this.ivH.getView()) {
            if (this.ivK != null) {
                if (this.ivP != null) {
                    this.ivP.b(view, this.ivK);
                }
                aa(this.ivK.bln());
            }
        } else if (view == this.ivI.getView()) {
            if (this.ivL != null) {
                if (this.ivP != null) {
                    this.ivP.b(view, this.ivL);
                }
                aa(this.ivL.bln());
            }
        } else if (view == this.ivJ.getView() && this.ivM != null) {
            if (this.ivP != null) {
                this.ivP.b(view, this.ivM);
            }
            aa(this.ivM.bln());
        }
    }

    private void aa(cb cbVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(cbVar, null, m.bnC(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(cbVar.getFid()));
        createFromThreadCfg.setForumName(cbVar.bnU());
        createFromThreadCfg.setStartFrom(0);
        m.IN(cbVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.ivP = aVar;
    }
}
