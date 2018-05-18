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
    private LinearLayout cnZ;
    private TextView coa;
    private LinearLayout cob;
    private e coc;
    private f cod;
    private f coe;
    private com.baidu.tieba.e.a cof;
    private com.baidu.tieba.e.b cog;
    private com.baidu.tieba.e.b coh;
    private View coi;
    private View coj;
    private a cok;
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
        this.cnZ = (LinearLayout) view2.findViewById(d.g.card_frs_game_head_line_layout);
        this.coa = (TextView) view2.findViewById(d.g.frs_game_head_line_title);
        this.cob = (LinearLayout) view2.findViewById(d.g.frs_game_head_line_container);
        this.coi = view2.findViewById(d.g.divider_line_1);
        this.coj = view2.findViewById(d.g.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.tbds44);
        if (this.coc == null) {
            this.coc = new e(this.mTbPageContext, null, null);
        }
        this.coc.m(0, 0, 0, 0);
        this.coc.iH(8);
        this.coc.iI(8);
        if (this.coc.getView().getParent() != null) {
            ((ViewGroup) this.coc.getView().getParent()).removeView(this.coc.getView());
        }
        this.coc.getView().setOnClickListener(this);
        this.coc.getView().setVisibility(8);
        this.cob.addView(this.coc.getView());
        if (this.cod == null) {
            this.cod = new f(this.mTbPageContext);
        }
        this.cod.iI(8);
        this.cod.n(0, dimensionPixelSize, 0, 0);
        if (this.cod.getView().getParent() != null) {
            ((ViewGroup) this.cod.getView().getParent()).removeView(this.cod.getView());
        }
        this.cod.getView().setOnClickListener(this);
        this.cod.getView().setVisibility(8);
        this.cob.addView(this.cod.getView());
        if (this.coe == null) {
            this.coe = new f(this.mTbPageContext);
        }
        this.coe.iI(8);
        this.coe.n(0, dimensionPixelSize, 0, 0);
        if (this.coe.getView().getParent() != null) {
            ((ViewGroup) this.coe.getView().getParent()).removeView(this.coe.getView());
        }
        this.coe.getView().setOnClickListener(this);
        this.coe.getView().setVisibility(8);
        this.cob.addView(this.coe.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        ak.i(getView(), d.C0126d.cp_bg_line_d);
        ak.c(this.coa, d.C0126d.cp_cont_f, 1);
        ak.i(this.coi, d.C0126d.cp_bg_line_e);
        ak.i(this.coj, d.C0126d.cp_bg_line_e);
        if (this.coc != null) {
            this.coc.d(tbPageContext, i);
        }
        if (this.cod != null) {
            this.cod.d(tbPageContext, i);
        }
        if (this.coe != null) {
            this.coe.d(tbPageContext, i);
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
                this.coa.setText(dVar.ajw().title);
            }
            List<bd> list = dVar.ajw().sub_nodes;
            if (com.baidu.tbadk.core.util.v.v(list) >= 1) {
                this.cof = new com.baidu.tieba.e.a();
                this.cof.setData(list.get(0));
                this.coc.getView().setVisibility(0);
                this.coc.a(this.cof);
            }
            if (com.baidu.tbadk.core.util.v.v(list) >= 2) {
                this.cog = new com.baidu.tieba.e.b();
                this.cog.setData(list.get(1));
                this.cod.getView().setVisibility(0);
                this.cod.a(this.cog);
                this.cod.iJ(8);
            }
            if (com.baidu.tbadk.core.util.v.v(list) >= 3) {
                this.coh = new com.baidu.tieba.e.b();
                this.coh.setData(list.get(2));
                this.coe.getView().setVisibility(0);
                this.coe.a(this.coh);
                this.coe.iJ(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        TiebaStatic.log(new al("c13047").r("obj_locate", 6).ac(ImageViewerConfig.FORUM_ID, this.mForumId));
        if (view2 == this.coc.getView()) {
            if (this.cof != null) {
                if (this.cok != null) {
                    this.cok.b(view2, this.cof);
                }
                F(this.cof.Pb());
            }
        } else if (view2 == this.cod.getView()) {
            if (this.cog != null) {
                if (this.cok != null) {
                    this.cok.b(view2, this.cog);
                }
                F(this.cog.Pb());
            }
        } else if (view2 == this.coe.getView() && this.coh != null) {
            if (this.cok != null) {
                this.cok.b(view2, this.coh);
            }
            F(this.coh.Pb());
        }
    }

    private void F(bd bdVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(aeY().getPageActivity()).createFromThreadCfg(bdVar, null, o.rF(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bdVar.getFid()));
        createFromThreadCfg.setForumName(bdVar.rU());
        createFromThreadCfg.setStartFrom(0);
        o.ky(bdVar.getTid());
        aeY().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.cok = aVar;
    }
}
