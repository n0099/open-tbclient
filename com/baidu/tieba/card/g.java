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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.e.d> {
    private LinearLayout cxj;
    private TextView cxk;
    private LinearLayout cxl;
    private e cxm;
    private f cxn;
    private f cxo;
    private com.baidu.tieba.e.a cxp;
    private com.baidu.tieba.e.b cxq;
    private com.baidu.tieba.e.b cxr;
    private View cxs;
    private View cxt;
    private a cxu;
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
        this.cxj = (LinearLayout) view.findViewById(f.g.card_frs_game_head_line_layout);
        this.cxk = (TextView) view.findViewById(f.g.frs_game_head_line_title);
        this.cxl = (LinearLayout) view.findViewById(f.g.frs_game_head_line_container);
        this.cxs = view.findViewById(f.g.divider_line_1);
        this.cxt = view.findViewById(f.g.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(f.e.tbds44);
        if (this.cxm == null) {
            this.cxm = new e(this.mTbPageContext, null, null);
        }
        this.cxm.l(0, 0, 0, 0);
        this.cxm.iP(8);
        this.cxm.iQ(8);
        if (this.cxm.getView().getParent() != null) {
            ((ViewGroup) this.cxm.getView().getParent()).removeView(this.cxm.getView());
        }
        this.cxm.getView().setOnClickListener(this);
        this.cxm.getView().setVisibility(8);
        this.cxl.addView(this.cxm.getView());
        if (this.cxn == null) {
            this.cxn = new f(this.mTbPageContext);
        }
        this.cxn.iQ(8);
        this.cxn.m(0, dimensionPixelSize, 0, 0);
        if (this.cxn.getView().getParent() != null) {
            ((ViewGroup) this.cxn.getView().getParent()).removeView(this.cxn.getView());
        }
        this.cxn.getView().setOnClickListener(this);
        this.cxn.getView().setVisibility(8);
        this.cxl.addView(this.cxn.getView());
        if (this.cxo == null) {
            this.cxo = new f(this.mTbPageContext);
        }
        this.cxo.iQ(8);
        this.cxo.m(0, dimensionPixelSize, 0, 0);
        if (this.cxo.getView().getParent() != null) {
            ((ViewGroup) this.cxo.getView().getParent()).removeView(this.cxo.getView());
        }
        this.cxo.getView().setOnClickListener(this);
        this.cxo.getView().setVisibility(8);
        this.cxl.addView(this.cxo.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        am.i(getView(), f.d.cp_bg_line_d);
        am.c(this.cxk, f.d.cp_cont_f, 1);
        am.i(this.cxs, f.d.cp_bg_line_e);
        am.i(this.cxt, f.d.cp_bg_line_e);
        if (this.cxm != null) {
            this.cxm.d(tbPageContext, i);
        }
        if (this.cxn != null) {
            this.cxn.d(tbPageContext, i);
        }
        if (this.cxo != null) {
            this.cxo.d(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.ano() != null) {
            if (!TextUtils.isEmpty(dVar.ano().title)) {
                this.cxk.setText(dVar.ano().title);
            }
            List<bb> list = dVar.ano().sub_nodes;
            if (com.baidu.tbadk.core.util.w.y(list) >= 1) {
                this.cxp = new com.baidu.tieba.e.a();
                this.cxp.setData(list.get(0));
                this.cxm.getView().setVisibility(0);
                this.cxm.a(this.cxp);
            }
            if (com.baidu.tbadk.core.util.w.y(list) >= 2) {
                this.cxq = new com.baidu.tieba.e.b();
                this.cxq.setData(list.get(1));
                this.cxn.getView().setVisibility(0);
                this.cxn.a(this.cxq);
                this.cxn.iR(8);
            }
            if (com.baidu.tbadk.core.util.w.y(list) >= 3) {
                this.cxr = new com.baidu.tieba.e.b();
                this.cxr.setData(list.get(2));
                this.cxo.getView().setVisibility(0);
                this.cxo.a(this.cxr);
                this.cxo.iR(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13047").r("obj_locate", 6).ae(ImageViewerConfig.FORUM_ID, this.mForumId));
        if (view == this.cxm.getView()) {
            if (this.cxp != null) {
                if (this.cxu != null) {
                    this.cxu.b(view, this.cxp);
                }
                J(this.cxp.Tg());
            }
        } else if (view == this.cxn.getView()) {
            if (this.cxq != null) {
                if (this.cxu != null) {
                    this.cxu.b(view, this.cxq);
                }
                J(this.cxq.Tg());
            }
        } else if (view == this.cxo.getView() && this.cxr != null) {
            if (this.cxu != null) {
                this.cxu.b(view, this.cxr);
            }
            J(this.cxr.Tg());
        }
    }

    private void J(bb bbVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(aiB().getPageActivity()).createFromThreadCfg(bbVar, null, o.uX(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bbVar.getFid()));
        createFromThreadCfg.setForumName(bbVar.vp());
        createFromThreadCfg.setStartFrom(0);
        o.kY(bbVar.getTid());
        aiB().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.cxu = aVar;
    }
}
