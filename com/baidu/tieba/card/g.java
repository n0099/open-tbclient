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
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.e.d> {
    private LinearLayout cxm;
    private TextView cxn;
    private LinearLayout cxo;
    private e cxp;
    private f cxq;
    private f cxr;
    private com.baidu.tieba.e.a cxs;
    private com.baidu.tieba.e.b cxt;
    private com.baidu.tieba.e.b cxu;
    private View cxv;
    private View cxw;
    private a cxx;
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
        this.cxm = (LinearLayout) view.findViewById(d.g.card_frs_game_head_line_layout);
        this.cxn = (TextView) view.findViewById(d.g.frs_game_head_line_title);
        this.cxo = (LinearLayout) view.findViewById(d.g.frs_game_head_line_container);
        this.cxv = view.findViewById(d.g.divider_line_1);
        this.cxw = view.findViewById(d.g.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.tbds44);
        if (this.cxp == null) {
            this.cxp = new e(this.mTbPageContext, null, null);
        }
        this.cxp.l(0, 0, 0, 0);
        this.cxp.iQ(8);
        this.cxp.iR(8);
        if (this.cxp.getView().getParent() != null) {
            ((ViewGroup) this.cxp.getView().getParent()).removeView(this.cxp.getView());
        }
        this.cxp.getView().setOnClickListener(this);
        this.cxp.getView().setVisibility(8);
        this.cxo.addView(this.cxp.getView());
        if (this.cxq == null) {
            this.cxq = new f(this.mTbPageContext);
        }
        this.cxq.iR(8);
        this.cxq.m(0, dimensionPixelSize, 0, 0);
        if (this.cxq.getView().getParent() != null) {
            ((ViewGroup) this.cxq.getView().getParent()).removeView(this.cxq.getView());
        }
        this.cxq.getView().setOnClickListener(this);
        this.cxq.getView().setVisibility(8);
        this.cxo.addView(this.cxq.getView());
        if (this.cxr == null) {
            this.cxr = new f(this.mTbPageContext);
        }
        this.cxr.iR(8);
        this.cxr.m(0, dimensionPixelSize, 0, 0);
        if (this.cxr.getView().getParent() != null) {
            ((ViewGroup) this.cxr.getView().getParent()).removeView(this.cxr.getView());
        }
        this.cxr.getView().setOnClickListener(this);
        this.cxr.getView().setVisibility(8);
        this.cxo.addView(this.cxr.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        am.i(getView(), d.C0140d.cp_bg_line_d);
        am.c(this.cxn, d.C0140d.cp_cont_f, 1);
        am.i(this.cxv, d.C0140d.cp_bg_line_e);
        am.i(this.cxw, d.C0140d.cp_bg_line_e);
        if (this.cxp != null) {
            this.cxp.d(tbPageContext, i);
        }
        if (this.cxq != null) {
            this.cxq.d(tbPageContext, i);
        }
        if (this.cxr != null) {
            this.cxr.d(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.anm() != null) {
            if (!TextUtils.isEmpty(dVar.anm().title)) {
                this.cxn.setText(dVar.anm().title);
            }
            List<bb> list = dVar.anm().sub_nodes;
            if (com.baidu.tbadk.core.util.w.y(list) >= 1) {
                this.cxs = new com.baidu.tieba.e.a();
                this.cxs.setData(list.get(0));
                this.cxp.getView().setVisibility(0);
                this.cxp.a(this.cxs);
            }
            if (com.baidu.tbadk.core.util.w.y(list) >= 2) {
                this.cxt = new com.baidu.tieba.e.b();
                this.cxt.setData(list.get(1));
                this.cxq.getView().setVisibility(0);
                this.cxq.a(this.cxt);
                this.cxq.iS(8);
            }
            if (com.baidu.tbadk.core.util.w.y(list) >= 3) {
                this.cxu = new com.baidu.tieba.e.b();
                this.cxu.setData(list.get(2));
                this.cxr.getView().setVisibility(0);
                this.cxr.a(this.cxu);
                this.cxr.iS(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13047").r("obj_locate", 6).af(ImageViewerConfig.FORUM_ID, this.mForumId));
        if (view == this.cxp.getView()) {
            if (this.cxs != null) {
                if (this.cxx != null) {
                    this.cxx.b(view, this.cxs);
                }
                J(this.cxs.Td());
            }
        } else if (view == this.cxq.getView()) {
            if (this.cxt != null) {
                if (this.cxx != null) {
                    this.cxx.b(view, this.cxt);
                }
                J(this.cxt.Td());
            }
        } else if (view == this.cxr.getView() && this.cxu != null) {
            if (this.cxx != null) {
                this.cxx.b(view, this.cxu);
            }
            J(this.cxu.Td());
        }
    }

    private void J(bb bbVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(aiy().getPageActivity()).createFromThreadCfg(bbVar, null, o.uY(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bbVar.getFid()));
        createFromThreadCfg.setForumName(bbVar.vq());
        createFromThreadCfg.setStartFrom(0);
        o.kW(bbVar.getTid());
        aiy().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.cxx = aVar;
    }
}
