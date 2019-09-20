package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.e.d> {
    private LinearLayout eCH;
    private TextView eCI;
    private LinearLayout eCJ;
    private d eCK;
    private e eCL;
    private e eCM;
    private com.baidu.tieba.e.a eCN;
    private com.baidu.tieba.e.b eCO;
    private com.baidu.tieba.e.b eCP;
    private View eCQ;
    private View eCR;
    private a eCS;
    private String mForumId;

    /* loaded from: classes4.dex */
    public interface a {
        void b(View view, com.baidu.tieba.card.data.b bVar);
    }

    public f(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        this.mForumId = str;
        init(getView());
    }

    private void init(View view) {
        this.eCH = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.eCI = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.eCJ = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.eCQ = view.findViewById(R.id.divider_line_1);
        this.eCR = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.eCK == null) {
            this.eCK = new d(this.mTbPageContext, null, null);
        }
        this.eCK.u(0, 0, 0, 0);
        this.eCK.pG(8);
        this.eCK.pH(8);
        if (this.eCK.getView().getParent() != null) {
            ((ViewGroup) this.eCK.getView().getParent()).removeView(this.eCK.getView());
        }
        this.eCK.getView().setOnClickListener(this);
        this.eCK.getView().setVisibility(8);
        this.eCJ.addView(this.eCK.getView());
        if (this.eCL == null) {
            this.eCL = new e(this.mTbPageContext);
        }
        this.eCL.pH(8);
        this.eCL.v(0, dimensionPixelSize, 0, 0);
        if (this.eCL.getView().getParent() != null) {
            ((ViewGroup) this.eCL.getView().getParent()).removeView(this.eCL.getView());
        }
        this.eCL.getView().setOnClickListener(this);
        this.eCL.getView().setVisibility(8);
        this.eCJ.addView(this.eCL.getView());
        if (this.eCM == null) {
            this.eCM = new e(this.mTbPageContext);
        }
        this.eCM.pH(8);
        this.eCM.v(0, dimensionPixelSize, 0, 0);
        if (this.eCM.getView().getParent() != null) {
            ((ViewGroup) this.eCM.getView().getParent()).removeView(this.eCM.getView());
        }
        this.eCM.getView().setOnClickListener(this);
        this.eCM.getView().setVisibility(8);
        this.eCJ.addView(this.eCM.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.k(getView(), R.color.cp_bg_line_d);
        am.f(this.eCI, R.color.cp_cont_f, 1);
        am.k(this.eCQ, R.color.cp_bg_line_e);
        am.k(this.eCR, R.color.cp_bg_line_e);
        if (this.eCK != null) {
            this.eCK.onChangeSkinType(tbPageContext, i);
        }
        if (this.eCL != null) {
            this.eCL.onChangeSkinType(tbPageContext, i);
        }
        if (this.eCM != null) {
            this.eCM.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.beE() != null) {
            if (!TextUtils.isEmpty(dVar.beE().title)) {
                this.eCI.setText(dVar.beE().title);
            }
            List<bh> list = dVar.beE().sub_nodes;
            if (com.baidu.tbadk.core.util.v.Z(list) >= 1) {
                this.eCN = new com.baidu.tieba.e.a();
                this.eCN.setData(list.get(0));
                this.eCK.getView().setVisibility(0);
                this.eCK.a(this.eCN);
            }
            if (com.baidu.tbadk.core.util.v.Z(list) >= 2) {
                this.eCO = new com.baidu.tieba.e.b();
                this.eCO.setData(list.get(1));
                this.eCL.getView().setVisibility(0);
                this.eCL.a(this.eCO);
                this.eCL.pI(8);
            }
            if (com.baidu.tbadk.core.util.v.Z(list) >= 3) {
                this.eCP = new com.baidu.tieba.e.b();
                this.eCP.setData(list.get(2));
                this.eCM.getView().setVisibility(0);
                this.eCM.a(this.eCP);
                this.eCM.pI(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13047").P("obj_locate", 6).bT("fid", this.mForumId));
        if (view == this.eCK.getView()) {
            if (this.eCN != null) {
                if (this.eCS != null) {
                    this.eCS.b(view, this.eCN);
                }
                S(this.eCN.acC());
            }
        } else if (view == this.eCL.getView()) {
            if (this.eCO != null) {
                if (this.eCS != null) {
                    this.eCS.b(view, this.eCO);
                }
                S(this.eCO.acC());
            }
        } else if (view == this.eCM.getView() && this.eCP != null) {
            if (this.eCS != null) {
                this.eCS.b(view, this.eCP);
            }
            S(this.eCP.acC());
        }
    }

    private void S(bh bhVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bhVar, null, n.aep(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bhVar.getFid()));
        createFromThreadCfg.setForumName(bhVar.aeH());
        createFromThreadCfg.setStartFrom(0);
        n.vW(bhVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.eCS = aVar;
    }
}
