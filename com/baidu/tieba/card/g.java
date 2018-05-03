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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.e.d> {
    private LinearLayout cmP;
    private TextView cmQ;
    private LinearLayout cmR;
    private e cmS;
    private f cmT;
    private f cmU;
    private com.baidu.tieba.e.a cmV;
    private com.baidu.tieba.e.b cmW;
    private com.baidu.tieba.e.b cmX;
    private View cmY;
    private View cmZ;
    private a cna;
    private String mForumId;

    /* loaded from: classes3.dex */
    public interface a {
        void b(View view2, com.baidu.tieba.card.data.b bVar);
    }

    public g(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        this.mForumId = str;
        init(getView());
    }

    private void init(View view2) {
        this.cmP = (LinearLayout) view2.findViewById(d.g.card_frs_game_head_line_layout);
        this.cmQ = (TextView) view2.findViewById(d.g.frs_game_head_line_title);
        this.cmR = (LinearLayout) view2.findViewById(d.g.frs_game_head_line_container);
        this.cmY = view2.findViewById(d.g.divider_line_1);
        this.cmZ = view2.findViewById(d.g.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.tbds44);
        if (this.cmS == null) {
            this.cmS = new e(this.mTbPageContext, null, null);
        }
        this.cmS.m(0, 0, 0, 0);
        this.cmS.iI(8);
        this.cmS.iJ(8);
        if (this.cmS.getView().getParent() != null) {
            ((ViewGroup) this.cmS.getView().getParent()).removeView(this.cmS.getView());
        }
        this.cmS.getView().setOnClickListener(this);
        this.cmS.getView().setVisibility(8);
        this.cmR.addView(this.cmS.getView());
        if (this.cmT == null) {
            this.cmT = new f(this.mTbPageContext);
        }
        this.cmT.iJ(8);
        this.cmT.n(0, dimensionPixelSize, 0, 0);
        if (this.cmT.getView().getParent() != null) {
            ((ViewGroup) this.cmT.getView().getParent()).removeView(this.cmT.getView());
        }
        this.cmT.getView().setOnClickListener(this);
        this.cmT.getView().setVisibility(8);
        this.cmR.addView(this.cmT.getView());
        if (this.cmU == null) {
            this.cmU = new f(this.mTbPageContext);
        }
        this.cmU.iJ(8);
        this.cmU.n(0, dimensionPixelSize, 0, 0);
        if (this.cmU.getView().getParent() != null) {
            ((ViewGroup) this.cmU.getView().getParent()).removeView(this.cmU.getView());
        }
        this.cmU.getView().setOnClickListener(this);
        this.cmU.getView().setVisibility(8);
        this.cmR.addView(this.cmU.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        ak.i(getView(), d.C0126d.cp_bg_line_d);
        ak.c(this.cmQ, d.C0126d.cp_cont_f, 1);
        ak.i(this.cmY, d.C0126d.cp_bg_line_e);
        ak.i(this.cmZ, d.C0126d.cp_bg_line_e);
        if (this.cmS != null) {
            this.cmS.d(tbPageContext, i);
        }
        if (this.cmT != null) {
            this.cmT.d(tbPageContext, i);
        }
        if (this.cmU != null) {
            this.cmU.d(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.ajw() != null) {
            if (!TextUtils.isEmpty(dVar.ajw().title)) {
                this.cmQ.setText(dVar.ajw().title);
            }
            List<bd> list = dVar.ajw().sub_nodes;
            if (com.baidu.tbadk.core.util.v.v(list) >= 1) {
                this.cmV = new com.baidu.tieba.e.a();
                this.cmV.setData(list.get(0));
                this.cmS.getView().setVisibility(0);
                this.cmS.a(this.cmV);
            }
            if (com.baidu.tbadk.core.util.v.v(list) >= 2) {
                this.cmW = new com.baidu.tieba.e.b();
                this.cmW.setData(list.get(1));
                this.cmT.getView().setVisibility(0);
                this.cmT.a(this.cmW);
                this.cmT.iK(8);
            }
            if (com.baidu.tbadk.core.util.v.v(list) >= 3) {
                this.cmX = new com.baidu.tieba.e.b();
                this.cmX.setData(list.get(2));
                this.cmU.getView().setVisibility(0);
                this.cmU.a(this.cmX);
                this.cmU.iK(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        TiebaStatic.log(new al("c13047").r("obj_locate", 6).ac(ImageViewerConfig.FORUM_ID, this.mForumId));
        if (view2 == this.cmS.getView()) {
            if (this.cmV != null) {
                if (this.cna != null) {
                    this.cna.b(view2, this.cmV);
                }
                F(this.cmV.Pe());
            }
        } else if (view2 == this.cmT.getView()) {
            if (this.cmW != null) {
                if (this.cna != null) {
                    this.cna.b(view2, this.cmW);
                }
                F(this.cmW.Pe());
            }
        } else if (view2 == this.cmU.getView() && this.cmX != null) {
            if (this.cna != null) {
                this.cna.b(view2, this.cmX);
            }
            F(this.cmX.Pe());
        }
    }

    private void F(bd bdVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(aeY().getPageActivity()).createFromThreadCfg(bdVar, null, o.rG(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bdVar.getFid()));
        createFromThreadCfg.setForumName(bdVar.rV());
        createFromThreadCfg.setStartFrom(0);
        o.kv(bdVar.getTid());
        aeY().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.cna = aVar;
    }
}
