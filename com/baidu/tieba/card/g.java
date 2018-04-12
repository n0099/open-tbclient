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
    private LinearLayout cmS;
    private TextView cmT;
    private LinearLayout cmU;
    private e cmV;
    private f cmW;
    private f cmX;
    private com.baidu.tieba.e.a cmY;
    private com.baidu.tieba.e.b cmZ;
    private com.baidu.tieba.e.b cna;
    private View cnb;
    private View cnc;
    private a cnd;
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
        this.cmS = (LinearLayout) view2.findViewById(d.g.card_frs_game_head_line_layout);
        this.cmT = (TextView) view2.findViewById(d.g.frs_game_head_line_title);
        this.cmU = (LinearLayout) view2.findViewById(d.g.frs_game_head_line_container);
        this.cnb = view2.findViewById(d.g.divider_line_1);
        this.cnc = view2.findViewById(d.g.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.tbds44);
        if (this.cmV == null) {
            this.cmV = new e(this.mTbPageContext, null, null);
        }
        this.cmV.m(0, 0, 0, 0);
        this.cmV.iJ(8);
        this.cmV.iK(8);
        if (this.cmV.getView().getParent() != null) {
            ((ViewGroup) this.cmV.getView().getParent()).removeView(this.cmV.getView());
        }
        this.cmV.getView().setOnClickListener(this);
        this.cmV.getView().setVisibility(8);
        this.cmU.addView(this.cmV.getView());
        if (this.cmW == null) {
            this.cmW = new f(this.mTbPageContext);
        }
        this.cmW.iK(8);
        this.cmW.n(0, dimensionPixelSize, 0, 0);
        if (this.cmW.getView().getParent() != null) {
            ((ViewGroup) this.cmW.getView().getParent()).removeView(this.cmW.getView());
        }
        this.cmW.getView().setOnClickListener(this);
        this.cmW.getView().setVisibility(8);
        this.cmU.addView(this.cmW.getView());
        if (this.cmX == null) {
            this.cmX = new f(this.mTbPageContext);
        }
        this.cmX.iK(8);
        this.cmX.n(0, dimensionPixelSize, 0, 0);
        if (this.cmX.getView().getParent() != null) {
            ((ViewGroup) this.cmX.getView().getParent()).removeView(this.cmX.getView());
        }
        this.cmX.getView().setOnClickListener(this);
        this.cmX.getView().setVisibility(8);
        this.cmU.addView(this.cmX.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        ak.i(getView(), d.C0126d.cp_bg_line_d);
        ak.c(this.cmT, d.C0126d.cp_cont_f, 1);
        ak.i(this.cnb, d.C0126d.cp_bg_line_e);
        ak.i(this.cnc, d.C0126d.cp_bg_line_e);
        if (this.cmV != null) {
            this.cmV.d(tbPageContext, i);
        }
        if (this.cmW != null) {
            this.cmW.d(tbPageContext, i);
        }
        if (this.cmX != null) {
            this.cmX.d(tbPageContext, i);
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
                this.cmT.setText(dVar.ajw().title);
            }
            List<bd> list = dVar.ajw().sub_nodes;
            if (com.baidu.tbadk.core.util.v.v(list) >= 1) {
                this.cmY = new com.baidu.tieba.e.a();
                this.cmY.setData(list.get(0));
                this.cmV.getView().setVisibility(0);
                this.cmV.a(this.cmY);
            }
            if (com.baidu.tbadk.core.util.v.v(list) >= 2) {
                this.cmZ = new com.baidu.tieba.e.b();
                this.cmZ.setData(list.get(1));
                this.cmW.getView().setVisibility(0);
                this.cmW.a(this.cmZ);
                this.cmW.iL(8);
            }
            if (com.baidu.tbadk.core.util.v.v(list) >= 3) {
                this.cna = new com.baidu.tieba.e.b();
                this.cna.setData(list.get(2));
                this.cmX.getView().setVisibility(0);
                this.cmX.a(this.cna);
                this.cmX.iL(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        TiebaStatic.log(new al("c13047").r("obj_locate", 6).ac(ImageViewerConfig.FORUM_ID, this.mForumId));
        if (view2 == this.cmV.getView()) {
            if (this.cmY != null) {
                if (this.cnd != null) {
                    this.cnd.b(view2, this.cmY);
                }
                F(this.cmY.Pe());
            }
        } else if (view2 == this.cmW.getView()) {
            if (this.cmZ != null) {
                if (this.cnd != null) {
                    this.cnd.b(view2, this.cmZ);
                }
                F(this.cmZ.Pe());
            }
        } else if (view2 == this.cmX.getView() && this.cna != null) {
            if (this.cnd != null) {
                this.cnd.b(view2, this.cna);
            }
            F(this.cna.Pe());
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
        this.cnd = aVar;
    }
}
