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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.e.d> {
    private LinearLayout cwD;
    private TextView cwE;
    private LinearLayout cwF;
    private e cwG;
    private f cwH;
    private f cwI;
    private com.baidu.tieba.e.a cwJ;
    private com.baidu.tieba.e.b cwK;
    private com.baidu.tieba.e.b cwL;
    private View cwM;
    private View cwN;
    private a cwO;
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
        this.cwD = (LinearLayout) view.findViewById(d.g.card_frs_game_head_line_layout);
        this.cwE = (TextView) view.findViewById(d.g.frs_game_head_line_title);
        this.cwF = (LinearLayout) view.findViewById(d.g.frs_game_head_line_container);
        this.cwM = view.findViewById(d.g.divider_line_1);
        this.cwN = view.findViewById(d.g.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.tbds44);
        if (this.cwG == null) {
            this.cwG = new e(this.mTbPageContext, null, null);
        }
        this.cwG.m(0, 0, 0, 0);
        this.cwG.iI(8);
        this.cwG.iJ(8);
        if (this.cwG.getView().getParent() != null) {
            ((ViewGroup) this.cwG.getView().getParent()).removeView(this.cwG.getView());
        }
        this.cwG.getView().setOnClickListener(this);
        this.cwG.getView().setVisibility(8);
        this.cwF.addView(this.cwG.getView());
        if (this.cwH == null) {
            this.cwH = new f(this.mTbPageContext);
        }
        this.cwH.iJ(8);
        this.cwH.n(0, dimensionPixelSize, 0, 0);
        if (this.cwH.getView().getParent() != null) {
            ((ViewGroup) this.cwH.getView().getParent()).removeView(this.cwH.getView());
        }
        this.cwH.getView().setOnClickListener(this);
        this.cwH.getView().setVisibility(8);
        this.cwF.addView(this.cwH.getView());
        if (this.cwI == null) {
            this.cwI = new f(this.mTbPageContext);
        }
        this.cwI.iJ(8);
        this.cwI.n(0, dimensionPixelSize, 0, 0);
        if (this.cwI.getView().getParent() != null) {
            ((ViewGroup) this.cwI.getView().getParent()).removeView(this.cwI.getView());
        }
        this.cwI.getView().setOnClickListener(this);
        this.cwI.getView().setVisibility(8);
        this.cwF.addView(this.cwI.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.i(getView(), d.C0141d.cp_bg_line_d);
        al.c(this.cwE, d.C0141d.cp_cont_f, 1);
        al.i(this.cwM, d.C0141d.cp_bg_line_e);
        al.i(this.cwN, d.C0141d.cp_bg_line_e);
        if (this.cwG != null) {
            this.cwG.d(tbPageContext, i);
        }
        if (this.cwH != null) {
            this.cwH.d(tbPageContext, i);
        }
        if (this.cwI != null) {
            this.cwI.d(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.ant() != null) {
            if (!TextUtils.isEmpty(dVar.ant().title)) {
                this.cwE.setText(dVar.ant().title);
            }
            List<bd> list = dVar.ant().sub_nodes;
            if (com.baidu.tbadk.core.util.w.y(list) >= 1) {
                this.cwJ = new com.baidu.tieba.e.a();
                this.cwJ.setData(list.get(0));
                this.cwG.getView().setVisibility(0);
                this.cwG.a(this.cwJ);
            }
            if (com.baidu.tbadk.core.util.w.y(list) >= 2) {
                this.cwK = new com.baidu.tieba.e.b();
                this.cwK.setData(list.get(1));
                this.cwH.getView().setVisibility(0);
                this.cwH.a(this.cwK);
                this.cwH.iK(8);
            }
            if (com.baidu.tbadk.core.util.w.y(list) >= 3) {
                this.cwL = new com.baidu.tieba.e.b();
                this.cwL.setData(list.get(2));
                this.cwI.getView().setVisibility(0);
                this.cwI.a(this.cwL);
                this.cwI.iK(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new am("c13047").r("obj_locate", 6).ah(ImageViewerConfig.FORUM_ID, this.mForumId));
        if (view == this.cwG.getView()) {
            if (this.cwJ != null) {
                if (this.cwO != null) {
                    this.cwO.b(view, this.cwJ);
                }
                F(this.cwJ.Sz());
            }
        } else if (view == this.cwH.getView()) {
            if (this.cwK != null) {
                if (this.cwO != null) {
                    this.cwO.b(view, this.cwK);
                }
                F(this.cwK.Sz());
            }
        } else if (view == this.cwI.getView() && this.cwL != null) {
            if (this.cwO != null) {
                this.cwO.b(view, this.cwL);
            }
            F(this.cwL.Sz());
        }
    }

    private void F(bd bdVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(aiH().getPageActivity()).createFromThreadCfg(bdVar, null, o.vb(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bdVar.getFid()));
        createFromThreadCfg.setForumName(bdVar.vr());
        createFromThreadCfg.setStartFrom(0);
        o.lb(bdVar.getTid());
        aiH().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.cwO = aVar;
    }
}
