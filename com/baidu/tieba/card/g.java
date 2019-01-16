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
    private LinearLayout cWI;
    private TextView cWJ;
    private LinearLayout cWK;
    private e cWL;
    private f cWM;
    private f cWN;
    private com.baidu.tieba.e.a cWO;
    private com.baidu.tieba.e.b cWP;
    private com.baidu.tieba.e.b cWQ;
    private View cWR;
    private View cWS;
    private a cWT;
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
        this.cWI = (LinearLayout) view.findViewById(e.g.card_frs_game_head_line_layout);
        this.cWJ = (TextView) view.findViewById(e.g.frs_game_head_line_title);
        this.cWK = (LinearLayout) view.findViewById(e.g.frs_game_head_line_container);
        this.cWR = view.findViewById(e.g.divider_line_1);
        this.cWS = view.findViewById(e.g.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds44);
        if (this.cWL == null) {
            this.cWL = new e(this.mTbPageContext, null, null);
        }
        this.cWL.m(0, 0, 0, 0);
        this.cWL.kI(8);
        this.cWL.kJ(8);
        if (this.cWL.getView().getParent() != null) {
            ((ViewGroup) this.cWL.getView().getParent()).removeView(this.cWL.getView());
        }
        this.cWL.getView().setOnClickListener(this);
        this.cWL.getView().setVisibility(8);
        this.cWK.addView(this.cWL.getView());
        if (this.cWM == null) {
            this.cWM = new f(this.mTbPageContext);
        }
        this.cWM.kJ(8);
        this.cWM.n(0, dimensionPixelSize, 0, 0);
        if (this.cWM.getView().getParent() != null) {
            ((ViewGroup) this.cWM.getView().getParent()).removeView(this.cWM.getView());
        }
        this.cWM.getView().setOnClickListener(this);
        this.cWM.getView().setVisibility(8);
        this.cWK.addView(this.cWM.getView());
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
        this.cWK.addView(this.cWN.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.i(getView(), e.d.cp_bg_line_d);
        al.c(this.cWJ, e.d.cp_cont_f, 1);
        al.i(this.cWR, e.d.cp_bg_line_e);
        al.i(this.cWS, e.d.cp_bg_line_e);
        if (this.cWL != null) {
            this.cWL.d(tbPageContext, i);
        }
        if (this.cWM != null) {
            this.cWM.d(tbPageContext, i);
        }
        if (this.cWN != null) {
            this.cWN.d(tbPageContext, i);
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
                this.cWJ.setText(dVar.auX().title);
            }
            List<bb> list = dVar.auX().sub_nodes;
            if (com.baidu.tbadk.core.util.v.H(list) >= 1) {
                this.cWO = new com.baidu.tieba.e.a();
                this.cWO.setData(list.get(0));
                this.cWL.getView().setVisibility(0);
                this.cWL.a(this.cWO);
            }
            if (com.baidu.tbadk.core.util.v.H(list) >= 2) {
                this.cWP = new com.baidu.tieba.e.b();
                this.cWP.setData(list.get(1));
                this.cWM.getView().setVisibility(0);
                this.cWM.a(this.cWP);
                this.cWM.kK(8);
            }
            if (com.baidu.tbadk.core.util.v.H(list) >= 3) {
                this.cWQ = new com.baidu.tieba.e.b();
                this.cWQ.setData(list.get(2));
                this.cWN.getView().setVisibility(0);
                this.cWN.a(this.cWQ);
                this.cWN.kK(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new am("c13047").y("obj_locate", 6).aB(ImageViewerConfig.FORUM_ID, this.mForumId));
        if (view == this.cWL.getView()) {
            if (this.cWO != null) {
                if (this.cWT != null) {
                    this.cWT.b(view, this.cWO);
                }
                K(this.cWO.aaq());
            }
        } else if (view == this.cWM.getView()) {
            if (this.cWP != null) {
                if (this.cWT != null) {
                    this.cWT.b(view, this.cWP);
                }
                K(this.cWP.aaq());
            }
        } else if (view == this.cWN.getView() && this.cWQ != null) {
            if (this.cWT != null) {
                this.cWT.b(view, this.cWQ);
            }
            K(this.cWQ.aaq());
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
        this.cWT = aVar;
    }
}
