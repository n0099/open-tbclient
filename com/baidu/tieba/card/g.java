package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.e.d> {
    private LinearLayout cWJ;
    private TextView cWK;
    private LinearLayout cWL;
    private e cWM;
    private f cWN;
    private f cWO;
    private com.baidu.tieba.e.a cWP;
    private com.baidu.tieba.e.b cWQ;
    private com.baidu.tieba.e.b cWR;
    private View cWS;
    private View cWT;
    private a cWU;
    private String mForumId;

    /* loaded from: classes3.dex */
    public interface a {
        void b(View view, com.baidu.tieba.card.data.b bVar);
    }

    public g(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        this.mForumId = str;
        init(getView());
    }

    private void init(View view) {
        this.cWJ = (LinearLayout) view.findViewById(e.g.card_frs_game_head_line_layout);
        this.cWK = (TextView) view.findViewById(e.g.frs_game_head_line_title);
        this.cWL = (LinearLayout) view.findViewById(e.g.frs_game_head_line_container);
        this.cWS = view.findViewById(e.g.divider_line_1);
        this.cWT = view.findViewById(e.g.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds44);
        if (this.cWM == null) {
            this.cWM = new e(this.mTbPageContext, null, null);
        }
        this.cWM.m(0, 0, 0, 0);
        this.cWM.kI(8);
        this.cWM.kJ(8);
        if (this.cWM.getView().getParent() != null) {
            ((ViewGroup) this.cWM.getView().getParent()).removeView(this.cWM.getView());
        }
        this.cWM.getView().setOnClickListener(this);
        this.cWM.getView().setVisibility(8);
        this.cWL.addView(this.cWM.getView());
        if (this.cWN == null) {
            this.cWN = new f(this.mTbPageContext);
        }
        this.cWN.kJ(8);
        this.cWN.n(0, dimensionPixelSize, 0, 0);
        if (this.cWN.getView().getParent() != null) {
            ((ViewGroup) this.cWN.getView().getParent()).removeView(this.cWN.getView());
        }
        this.cWN.getView().setOnClickListener(this);
        this.cWN.getView().setVisibility(8);
        this.cWL.addView(this.cWN.getView());
        if (this.cWO == null) {
            this.cWO = new f(this.mTbPageContext);
        }
        this.cWO.kJ(8);
        this.cWO.n(0, dimensionPixelSize, 0, 0);
        if (this.cWO.getView().getParent() != null) {
            ((ViewGroup) this.cWO.getView().getParent()).removeView(this.cWO.getView());
        }
        this.cWO.getView().setOnClickListener(this);
        this.cWO.getView().setVisibility(8);
        this.cWL.addView(this.cWO.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.i(getView(), e.d.cp_bg_line_d);
        al.c(this.cWK, e.d.cp_cont_f, 1);
        al.i(this.cWS, e.d.cp_bg_line_e);
        al.i(this.cWT, e.d.cp_bg_line_e);
        if (this.cWM != null) {
            this.cWM.d(tbPageContext, i);
        }
        if (this.cWN != null) {
            this.cWN.d(tbPageContext, i);
        }
        if (this.cWO != null) {
            this.cWO.d(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.auX() != null) {
            if (!TextUtils.isEmpty(dVar.auX().title)) {
                this.cWK.setText(dVar.auX().title);
            }
            List<bb> list = dVar.auX().sub_nodes;
            if (com.baidu.tbadk.core.util.v.H(list) >= 1) {
                this.cWP = new com.baidu.tieba.e.a();
                this.cWP.setData(list.get(0));
                this.cWM.getView().setVisibility(0);
                this.cWM.a(this.cWP);
            }
            if (com.baidu.tbadk.core.util.v.H(list) >= 2) {
                this.cWQ = new com.baidu.tieba.e.b();
                this.cWQ.setData(list.get(1));
                this.cWN.getView().setVisibility(0);
                this.cWN.a(this.cWQ);
                this.cWN.kK(8);
            }
            if (com.baidu.tbadk.core.util.v.H(list) >= 3) {
                this.cWR = new com.baidu.tieba.e.b();
                this.cWR.setData(list.get(2));
                this.cWO.getView().setVisibility(0);
                this.cWO.a(this.cWR);
                this.cWO.kK(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new am("c13047").y("obj_locate", 6).aB(ImageViewerConfig.FORUM_ID, this.mForumId));
        if (view == this.cWM.getView()) {
            if (this.cWP != null) {
                if (this.cWU != null) {
                    this.cWU.b(view, this.cWP);
                }
                K(this.cWP.aaq());
            }
        } else if (view == this.cWN.getView()) {
            if (this.cWQ != null) {
                if (this.cWU != null) {
                    this.cWU.b(view, this.cWQ);
                }
                K(this.cWQ.aaq());
            }
        } else if (view == this.cWO.getView() && this.cWR != null) {
            if (this.cWU != null) {
                this.cWU.b(view, this.cWR);
            }
            K(this.cWR.aaq());
        }
    }

    private void K(bb bbVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bbVar, null, o.zH(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bbVar.getFid()));
        createFromThreadCfg.setForumName(bbVar.zZ());
        createFromThreadCfg.setStartFrom(0);
        o.mW(bbVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.cWU = aVar;
    }
}
