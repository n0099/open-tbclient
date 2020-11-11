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
    private TextView hWA;
    private LinearLayout hWB;
    private e hWC;
    private f hWD;
    private f hWE;
    private com.baidu.tieba.e.a hWF;
    private com.baidu.tieba.e.b hWG;
    private com.baidu.tieba.e.b hWH;
    private View hWI;
    private View hWJ;
    private a hWK;
    private LinearLayout hWz;
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
        this.hWz = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.hWA = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.hWB = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.hWI = view.findViewById(R.id.divider_line_1);
        this.hWJ = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.hWC == null) {
            this.hWC = new e(this.mTbPageContext, null, null);
        }
        this.hWC.y(0, 0, 0, 0);
        this.hWC.xc(8);
        this.hWC.xd(8);
        if (this.hWC.getView().getParent() != null) {
            ((ViewGroup) this.hWC.getView().getParent()).removeView(this.hWC.getView());
        }
        this.hWC.getView().setOnClickListener(this);
        this.hWC.getView().setVisibility(8);
        this.hWB.addView(this.hWC.getView());
        if (this.hWD == null) {
            this.hWD = new f(this.mTbPageContext);
        }
        this.hWD.xd(8);
        this.hWD.z(0, dimensionPixelSize, 0, 0);
        if (this.hWD.getView().getParent() != null) {
            ((ViewGroup) this.hWD.getView().getParent()).removeView(this.hWD.getView());
        }
        this.hWD.getView().setOnClickListener(this);
        this.hWD.getView().setVisibility(8);
        this.hWB.addView(this.hWD.getView());
        if (this.hWE == null) {
            this.hWE = new f(this.mTbPageContext);
        }
        this.hWE.xd(8);
        this.hWE.z(0, dimensionPixelSize, 0, 0);
        if (this.hWE.getView().getParent() != null) {
            ((ViewGroup) this.hWE.getView().getParent()).removeView(this.hWE.getView());
        }
        this.hWE.getView().setOnClickListener(this);
        this.hWE.getView().setVisibility(8);
        this.hWB.addView(this.hWE.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        ap.setViewTextColor(this.hWA, R.color.cp_cont_f, 1);
        ap.setBackgroundResource(this.hWI, R.color.cp_bg_line_e);
        ap.setBackgroundResource(this.hWJ, R.color.cp_bg_line_e);
        if (this.hWC != null) {
            this.hWC.onChangeSkinType(tbPageContext, i);
        }
        if (this.hWD != null) {
            this.hWD.onChangeSkinType(tbPageContext, i);
        }
        if (this.hWE != null) {
            this.hWE.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.cpL() != null) {
            if (!TextUtils.isEmpty(dVar.cpL().title)) {
                this.hWA.setText(dVar.cpL().title);
            }
            List<bw> list = dVar.cpL().sub_nodes;
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 1) {
                this.hWF = new com.baidu.tieba.e.a();
                this.hWF.setData(list.get(0));
                this.hWC.getView().setVisibility(0);
                this.hWC.a(this.hWF);
            }
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 2) {
                this.hWG = new com.baidu.tieba.e.b();
                this.hWG.setData(list.get(1));
                this.hWD.getView().setVisibility(0);
                this.hWD.a(this.hWG);
                this.hWD.xe(8);
            }
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 3) {
                this.hWH = new com.baidu.tieba.e.b();
                this.hWH.setData(list.get(2));
                this.hWE.getView().setVisibility(0);
                this.hWE.a(this.hWH);
                this.hWE.xe(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new aq("c13047").al("obj_locate", 6).dR("fid", this.mForumId));
        if (view == this.hWC.getView()) {
            if (this.hWF != null) {
                if (this.hWK != null) {
                    this.hWK.b(view, this.hWF);
                }
                X(this.hWF.bjZ());
            }
        } else if (view == this.hWD.getView()) {
            if (this.hWG != null) {
                if (this.hWK != null) {
                    this.hWK.b(view, this.hWG);
                }
                X(this.hWG.bjZ());
            }
        } else if (view == this.hWE.getView() && this.hWH != null) {
            if (this.hWK != null) {
                this.hWK.b(view, this.hWH);
            }
            X(this.hWH.bjZ());
        }
    }

    private void X(bw bwVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bwVar, null, n.bmm(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bwVar.getFid()));
        createFromThreadCfg.setForumName(bwVar.bmE());
        createFromThreadCfg.setStartFrom(0);
        n.IZ(bwVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.hWK = aVar;
    }
}
