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
    private LinearLayout cMA;
    private TextView cMB;
    private LinearLayout cMC;
    private e cMD;
    private f cME;
    private f cMF;
    private com.baidu.tieba.e.a cMG;
    private com.baidu.tieba.e.b cMH;
    private com.baidu.tieba.e.b cMI;
    private View cMJ;
    private View cMK;
    private a cML;
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
        this.cMA = (LinearLayout) view.findViewById(e.g.card_frs_game_head_line_layout);
        this.cMB = (TextView) view.findViewById(e.g.frs_game_head_line_title);
        this.cMC = (LinearLayout) view.findViewById(e.g.frs_game_head_line_container);
        this.cMJ = view.findViewById(e.g.divider_line_1);
        this.cMK = view.findViewById(e.g.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0200e.tbds44);
        if (this.cMD == null) {
            this.cMD = new e(this.mTbPageContext, null, null);
        }
        this.cMD.m(0, 0, 0, 0);
        this.cMD.kg(8);
        this.cMD.kh(8);
        if (this.cMD.getView().getParent() != null) {
            ((ViewGroup) this.cMD.getView().getParent()).removeView(this.cMD.getView());
        }
        this.cMD.getView().setOnClickListener(this);
        this.cMD.getView().setVisibility(8);
        this.cMC.addView(this.cMD.getView());
        if (this.cME == null) {
            this.cME = new f(this.mTbPageContext);
        }
        this.cME.kh(8);
        this.cME.n(0, dimensionPixelSize, 0, 0);
        if (this.cME.getView().getParent() != null) {
            ((ViewGroup) this.cME.getView().getParent()).removeView(this.cME.getView());
        }
        this.cME.getView().setOnClickListener(this);
        this.cME.getView().setVisibility(8);
        this.cMC.addView(this.cME.getView());
        if (this.cMF == null) {
            this.cMF = new f(this.mTbPageContext);
        }
        this.cMF.kh(8);
        this.cMF.n(0, dimensionPixelSize, 0, 0);
        if (this.cMF.getView().getParent() != null) {
            ((ViewGroup) this.cMF.getView().getParent()).removeView(this.cMF.getView());
        }
        this.cMF.getView().setOnClickListener(this);
        this.cMF.getView().setVisibility(8);
        this.cMC.addView(this.cMF.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.i(getView(), e.d.cp_bg_line_d);
        al.c(this.cMB, e.d.cp_cont_f, 1);
        al.i(this.cMJ, e.d.cp_bg_line_e);
        al.i(this.cMK, e.d.cp_bg_line_e);
        if (this.cMD != null) {
            this.cMD.d(tbPageContext, i);
        }
        if (this.cME != null) {
            this.cME.d(tbPageContext, i);
        }
        if (this.cMF != null) {
            this.cMF.d(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.arY() != null) {
            if (!TextUtils.isEmpty(dVar.arY().title)) {
                this.cMB.setText(dVar.arY().title);
            }
            List<bb> list = dVar.arY().sub_nodes;
            if (com.baidu.tbadk.core.util.v.H(list) >= 1) {
                this.cMG = new com.baidu.tieba.e.a();
                this.cMG.setData(list.get(0));
                this.cMD.getView().setVisibility(0);
                this.cMD.a(this.cMG);
            }
            if (com.baidu.tbadk.core.util.v.H(list) >= 2) {
                this.cMH = new com.baidu.tieba.e.b();
                this.cMH.setData(list.get(1));
                this.cME.getView().setVisibility(0);
                this.cME.a(this.cMH);
                this.cME.ki(8);
            }
            if (com.baidu.tbadk.core.util.v.H(list) >= 3) {
                this.cMI = new com.baidu.tieba.e.b();
                this.cMI.setData(list.get(2));
                this.cMF.getView().setVisibility(0);
                this.cMF.a(this.cMI);
                this.cMF.ki(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new am("c13047").x("obj_locate", 6).ax(ImageViewerConfig.FORUM_ID, this.mForumId));
        if (view == this.cMD.getView()) {
            if (this.cMG != null) {
                if (this.cML != null) {
                    this.cML.b(view, this.cMG);
                }
                K(this.cMG.YL());
            }
        } else if (view == this.cME.getView()) {
            if (this.cMH != null) {
                if (this.cML != null) {
                    this.cML.b(view, this.cMH);
                }
                K(this.cMH.YL());
            }
        } else if (view == this.cMF.getView() && this.cMI != null) {
            if (this.cML != null) {
                this.cML.b(view, this.cMI);
            }
            K(this.cMI.YL());
        }
    }

    private void K(bb bbVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bbVar, null, o.yq(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bbVar.getFid()));
        createFromThreadCfg.setForumName(bbVar.yI());
        createFromThreadCfg.setStartFrom(0);
        o.me(bbVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.cML = aVar;
    }
}
