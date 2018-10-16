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
    private com.baidu.tieba.e.a cLA;
    private com.baidu.tieba.e.b cLB;
    private com.baidu.tieba.e.b cLC;
    private View cLD;
    private View cLE;
    private a cLF;
    private LinearLayout cLu;
    private TextView cLv;
    private LinearLayout cLw;
    private e cLx;
    private f cLy;
    private f cLz;
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
        this.cLu = (LinearLayout) view.findViewById(e.g.card_frs_game_head_line_layout);
        this.cLv = (TextView) view.findViewById(e.g.frs_game_head_line_title);
        this.cLw = (LinearLayout) view.findViewById(e.g.frs_game_head_line_container);
        this.cLD = view.findViewById(e.g.divider_line_1);
        this.cLE = view.findViewById(e.g.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0175e.tbds44);
        if (this.cLx == null) {
            this.cLx = new e(this.mTbPageContext, null, null);
        }
        this.cLx.m(0, 0, 0, 0);
        this.cLx.jN(8);
        this.cLx.jO(8);
        if (this.cLx.getView().getParent() != null) {
            ((ViewGroup) this.cLx.getView().getParent()).removeView(this.cLx.getView());
        }
        this.cLx.getView().setOnClickListener(this);
        this.cLx.getView().setVisibility(8);
        this.cLw.addView(this.cLx.getView());
        if (this.cLy == null) {
            this.cLy = new f(this.mTbPageContext);
        }
        this.cLy.jO(8);
        this.cLy.n(0, dimensionPixelSize, 0, 0);
        if (this.cLy.getView().getParent() != null) {
            ((ViewGroup) this.cLy.getView().getParent()).removeView(this.cLy.getView());
        }
        this.cLy.getView().setOnClickListener(this);
        this.cLy.getView().setVisibility(8);
        this.cLw.addView(this.cLy.getView());
        if (this.cLz == null) {
            this.cLz = new f(this.mTbPageContext);
        }
        this.cLz.jO(8);
        this.cLz.n(0, dimensionPixelSize, 0, 0);
        if (this.cLz.getView().getParent() != null) {
            ((ViewGroup) this.cLz.getView().getParent()).removeView(this.cLz.getView());
        }
        this.cLz.getView().setOnClickListener(this);
        this.cLz.getView().setVisibility(8);
        this.cLw.addView(this.cLz.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.i(getView(), e.d.cp_bg_line_d);
        al.c(this.cLv, e.d.cp_cont_f, 1);
        al.i(this.cLD, e.d.cp_bg_line_e);
        al.i(this.cLE, e.d.cp_bg_line_e);
        if (this.cLx != null) {
            this.cLx.d(tbPageContext, i);
        }
        if (this.cLy != null) {
            this.cLy.d(tbPageContext, i);
        }
        if (this.cLz != null) {
            this.cLz.d(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.asy() != null) {
            if (!TextUtils.isEmpty(dVar.asy().title)) {
                this.cLv.setText(dVar.asy().title);
            }
            List<bb> list = dVar.asy().sub_nodes;
            if (com.baidu.tbadk.core.util.v.I(list) >= 1) {
                this.cLA = new com.baidu.tieba.e.a();
                this.cLA.setData(list.get(0));
                this.cLx.getView().setVisibility(0);
                this.cLx.a(this.cLA);
            }
            if (com.baidu.tbadk.core.util.v.I(list) >= 2) {
                this.cLB = new com.baidu.tieba.e.b();
                this.cLB.setData(list.get(1));
                this.cLy.getView().setVisibility(0);
                this.cLy.a(this.cLB);
                this.cLy.jP(8);
            }
            if (com.baidu.tbadk.core.util.v.I(list) >= 3) {
                this.cLC = new com.baidu.tieba.e.b();
                this.cLC.setData(list.get(2));
                this.cLz.getView().setVisibility(0);
                this.cLz.a(this.cLC);
                this.cLz.jP(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new am("c13047").x("obj_locate", 6).ax(ImageViewerConfig.FORUM_ID, this.mForumId));
        if (view == this.cLx.getView()) {
            if (this.cLA != null) {
                if (this.cLF != null) {
                    this.cLF.b(view, this.cLA);
                }
                K(this.cLA.YA());
            }
        } else if (view == this.cLy.getView()) {
            if (this.cLB != null) {
                if (this.cLF != null) {
                    this.cLF.b(view, this.cLB);
                }
                K(this.cLB.YA());
            }
        } else if (view == this.cLz.getView() && this.cLC != null) {
            if (this.cLF != null) {
                this.cLF.b(view, this.cLC);
            }
            K(this.cLC.YA());
        }
    }

    private void K(bb bbVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bbVar, null, o.yj(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bbVar.getFid()));
        createFromThreadCfg.setForumName(bbVar.yB());
        createFromThreadCfg.setStartFrom(0);
        o.md(bbVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.cLF = aVar;
    }
}
