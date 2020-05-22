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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class g extends b<com.baidu.tieba.e.d> {
    private LinearLayout gCF;
    private TextView gCG;
    private LinearLayout gCH;
    private e gCI;
    private f gCJ;
    private f gCK;
    private com.baidu.tieba.e.a gCL;
    private com.baidu.tieba.e.b gCM;
    private com.baidu.tieba.e.b gCN;
    private View gCO;
    private View gCP;
    private a gCQ;
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
        this.gCF = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.gCG = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.gCH = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.gCO = view.findViewById(R.id.divider_line_1);
        this.gCP = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.gCI == null) {
            this.gCI = new e(this.mTbPageContext, null, null);
        }
        this.gCI.w(0, 0, 0, 0);
        this.gCI.sk(8);
        this.gCI.sl(8);
        if (this.gCI.getView().getParent() != null) {
            ((ViewGroup) this.gCI.getView().getParent()).removeView(this.gCI.getView());
        }
        this.gCI.getView().setOnClickListener(this);
        this.gCI.getView().setVisibility(8);
        this.gCH.addView(this.gCI.getView());
        if (this.gCJ == null) {
            this.gCJ = new f(this.mTbPageContext);
        }
        this.gCJ.sl(8);
        this.gCJ.x(0, dimensionPixelSize, 0, 0);
        if (this.gCJ.getView().getParent() != null) {
            ((ViewGroup) this.gCJ.getView().getParent()).removeView(this.gCJ.getView());
        }
        this.gCJ.getView().setOnClickListener(this);
        this.gCJ.getView().setVisibility(8);
        this.gCH.addView(this.gCJ.getView());
        if (this.gCK == null) {
            this.gCK = new f(this.mTbPageContext);
        }
        this.gCK.sl(8);
        this.gCK.x(0, dimensionPixelSize, 0, 0);
        if (this.gCK.getView().getParent() != null) {
            ((ViewGroup) this.gCK.getView().getParent()).removeView(this.gCK.getView());
        }
        this.gCK.getView().setOnClickListener(this);
        this.gCK.getView().setVisibility(8);
        this.gCH.addView(this.gCK.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        am.setViewTextColor(this.gCG, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.gCO, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.gCP, R.color.cp_bg_line_e);
        if (this.gCI != null) {
            this.gCI.onChangeSkinType(tbPageContext, i);
        }
        if (this.gCJ != null) {
            this.gCJ.onChangeSkinType(tbPageContext, i);
        }
        if (this.gCK != null) {
            this.gCK.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.bMM() != null) {
            if (!TextUtils.isEmpty(dVar.bMM().title)) {
                this.gCG.setText(dVar.bMM().title);
            }
            List<bk> list = dVar.bMM().sub_nodes;
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 1) {
                this.gCL = new com.baidu.tieba.e.a();
                this.gCL.setData(list.get(0));
                this.gCI.getView().setVisibility(0);
                this.gCI.a(this.gCL);
            }
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 2) {
                this.gCM = new com.baidu.tieba.e.b();
                this.gCM.setData(list.get(1));
                this.gCJ.getView().setVisibility(0);
                this.gCJ.a(this.gCM);
                this.gCJ.sm(8);
            }
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 3) {
                this.gCN = new com.baidu.tieba.e.b();
                this.gCN.setData(list.get(2));
                this.gCK.getView().setVisibility(0);
                this.gCK.a(this.gCN);
                this.gCK.sm(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13047").ag("obj_locate", 6).dh("fid", this.mForumId));
        if (view == this.gCI.getView()) {
            if (this.gCL != null) {
                if (this.gCQ != null) {
                    this.gCQ.b(view, this.gCL);
                }
                Y(this.gCL.aOi());
            }
        } else if (view == this.gCJ.getView()) {
            if (this.gCM != null) {
                if (this.gCQ != null) {
                    this.gCQ.b(view, this.gCM);
                }
                Y(this.gCM.aOi());
            }
        } else if (view == this.gCK.getView() && this.gCN != null) {
            if (this.gCQ != null) {
                this.gCQ.b(view, this.gCN);
            }
            Y(this.gCN.aOi());
        }
    }

    private void Y(bk bkVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bkVar, null, m.aQj(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bkVar.getFid()));
        createFromThreadCfg.setForumName(bkVar.aQC());
        createFromThreadCfg.setStartFrom(0);
        m.Dn(bkVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.gCQ = aVar;
    }
}
