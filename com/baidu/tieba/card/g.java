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
    private LinearLayout cTh;
    private TextView cTi;
    private LinearLayout cTj;
    private e cTk;
    private f cTl;
    private f cTm;
    private com.baidu.tieba.e.a cTn;
    private com.baidu.tieba.e.b cTo;
    private com.baidu.tieba.e.b cTp;
    private View cTq;
    private View cTr;
    private a cTs;
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
        this.cTh = (LinearLayout) view.findViewById(e.g.card_frs_game_head_line_layout);
        this.cTi = (TextView) view.findViewById(e.g.frs_game_head_line_title);
        this.cTj = (LinearLayout) view.findViewById(e.g.frs_game_head_line_container);
        this.cTq = view.findViewById(e.g.divider_line_1);
        this.cTr = view.findViewById(e.g.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds44);
        if (this.cTk == null) {
            this.cTk = new e(this.mTbPageContext, null, null);
        }
        this.cTk.m(0, 0, 0, 0);
        this.cTk.kw(8);
        this.cTk.kx(8);
        if (this.cTk.getView().getParent() != null) {
            ((ViewGroup) this.cTk.getView().getParent()).removeView(this.cTk.getView());
        }
        this.cTk.getView().setOnClickListener(this);
        this.cTk.getView().setVisibility(8);
        this.cTj.addView(this.cTk.getView());
        if (this.cTl == null) {
            this.cTl = new f(this.mTbPageContext);
        }
        this.cTl.kx(8);
        this.cTl.n(0, dimensionPixelSize, 0, 0);
        if (this.cTl.getView().getParent() != null) {
            ((ViewGroup) this.cTl.getView().getParent()).removeView(this.cTl.getView());
        }
        this.cTl.getView().setOnClickListener(this);
        this.cTl.getView().setVisibility(8);
        this.cTj.addView(this.cTl.getView());
        if (this.cTm == null) {
            this.cTm = new f(this.mTbPageContext);
        }
        this.cTm.kx(8);
        this.cTm.n(0, dimensionPixelSize, 0, 0);
        if (this.cTm.getView().getParent() != null) {
            ((ViewGroup) this.cTm.getView().getParent()).removeView(this.cTm.getView());
        }
        this.cTm.getView().setOnClickListener(this);
        this.cTm.getView().setVisibility(8);
        this.cTj.addView(this.cTm.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.i(getView(), e.d.cp_bg_line_d);
        al.c(this.cTi, e.d.cp_cont_f, 1);
        al.i(this.cTq, e.d.cp_bg_line_e);
        al.i(this.cTr, e.d.cp_bg_line_e);
        if (this.cTk != null) {
            this.cTk.d(tbPageContext, i);
        }
        if (this.cTl != null) {
            this.cTl.d(tbPageContext, i);
        }
        if (this.cTm != null) {
            this.cTm.d(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.atK() != null) {
            if (!TextUtils.isEmpty(dVar.atK().title)) {
                this.cTi.setText(dVar.atK().title);
            }
            List<bb> list = dVar.atK().sub_nodes;
            if (com.baidu.tbadk.core.util.v.H(list) >= 1) {
                this.cTn = new com.baidu.tieba.e.a();
                this.cTn.setData(list.get(0));
                this.cTk.getView().setVisibility(0);
                this.cTk.a(this.cTn);
            }
            if (com.baidu.tbadk.core.util.v.H(list) >= 2) {
                this.cTo = new com.baidu.tieba.e.b();
                this.cTo.setData(list.get(1));
                this.cTl.getView().setVisibility(0);
                this.cTl.a(this.cTo);
                this.cTl.ky(8);
            }
            if (com.baidu.tbadk.core.util.v.H(list) >= 3) {
                this.cTp = new com.baidu.tieba.e.b();
                this.cTp.setData(list.get(2));
                this.cTm.getView().setVisibility(0);
                this.cTm.a(this.cTp);
                this.cTm.ky(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new am("c13047").x("obj_locate", 6).aA(ImageViewerConfig.FORUM_ID, this.mForumId));
        if (view == this.cTk.getView()) {
            if (this.cTn != null) {
                if (this.cTs != null) {
                    this.cTs.b(view, this.cTn);
                }
                K(this.cTn.ZR());
            }
        } else if (view == this.cTl.getView()) {
            if (this.cTo != null) {
                if (this.cTs != null) {
                    this.cTs.b(view, this.cTo);
                }
                K(this.cTo.ZR());
            }
        } else if (view == this.cTm.getView() && this.cTp != null) {
            if (this.cTs != null) {
                this.cTs.b(view, this.cTp);
            }
            K(this.cTp.ZR());
        }
    }

    private void K(bb bbVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bbVar, null, o.zu(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bbVar.getFid()));
        createFromThreadCfg.setForumName(bbVar.zM());
        createFromThreadCfg.setStartFrom(0);
        o.mD(bbVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.cTs = aVar;
    }
}
