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
    private LinearLayout cVX;
    private TextView cVY;
    private LinearLayout cVZ;
    private e cWa;
    private f cWb;
    private f cWc;
    private com.baidu.tieba.e.a cWd;
    private com.baidu.tieba.e.b cWe;
    private com.baidu.tieba.e.b cWf;
    private View cWg;
    private View cWh;
    private a cWi;
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
        this.cVX = (LinearLayout) view.findViewById(e.g.card_frs_game_head_line_layout);
        this.cVY = (TextView) view.findViewById(e.g.frs_game_head_line_title);
        this.cVZ = (LinearLayout) view.findViewById(e.g.frs_game_head_line_container);
        this.cWg = view.findViewById(e.g.divider_line_1);
        this.cWh = view.findViewById(e.g.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds44);
        if (this.cWa == null) {
            this.cWa = new e(this.mTbPageContext, null, null);
        }
        this.cWa.m(0, 0, 0, 0);
        this.cWa.kI(8);
        this.cWa.kJ(8);
        if (this.cWa.getView().getParent() != null) {
            ((ViewGroup) this.cWa.getView().getParent()).removeView(this.cWa.getView());
        }
        this.cWa.getView().setOnClickListener(this);
        this.cWa.getView().setVisibility(8);
        this.cVZ.addView(this.cWa.getView());
        if (this.cWb == null) {
            this.cWb = new f(this.mTbPageContext);
        }
        this.cWb.kJ(8);
        this.cWb.n(0, dimensionPixelSize, 0, 0);
        if (this.cWb.getView().getParent() != null) {
            ((ViewGroup) this.cWb.getView().getParent()).removeView(this.cWb.getView());
        }
        this.cWb.getView().setOnClickListener(this);
        this.cWb.getView().setVisibility(8);
        this.cVZ.addView(this.cWb.getView());
        if (this.cWc == null) {
            this.cWc = new f(this.mTbPageContext);
        }
        this.cWc.kJ(8);
        this.cWc.n(0, dimensionPixelSize, 0, 0);
        if (this.cWc.getView().getParent() != null) {
            ((ViewGroup) this.cWc.getView().getParent()).removeView(this.cWc.getView());
        }
        this.cWc.getView().setOnClickListener(this);
        this.cWc.getView().setVisibility(8);
        this.cVZ.addView(this.cWc.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.i(getView(), e.d.cp_bg_line_d);
        al.c(this.cVY, e.d.cp_cont_f, 1);
        al.i(this.cWg, e.d.cp_bg_line_e);
        al.i(this.cWh, e.d.cp_bg_line_e);
        if (this.cWa != null) {
            this.cWa.d(tbPageContext, i);
        }
        if (this.cWb != null) {
            this.cWb.d(tbPageContext, i);
        }
        if (this.cWc != null) {
            this.cWc.d(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.auz() != null) {
            if (!TextUtils.isEmpty(dVar.auz().title)) {
                this.cVY.setText(dVar.auz().title);
            }
            List<bb> list = dVar.auz().sub_nodes;
            if (com.baidu.tbadk.core.util.v.H(list) >= 1) {
                this.cWd = new com.baidu.tieba.e.a();
                this.cWd.setData(list.get(0));
                this.cWa.getView().setVisibility(0);
                this.cWa.a(this.cWd);
            }
            if (com.baidu.tbadk.core.util.v.H(list) >= 2) {
                this.cWe = new com.baidu.tieba.e.b();
                this.cWe.setData(list.get(1));
                this.cWb.getView().setVisibility(0);
                this.cWb.a(this.cWe);
                this.cWb.kK(8);
            }
            if (com.baidu.tbadk.core.util.v.H(list) >= 3) {
                this.cWf = new com.baidu.tieba.e.b();
                this.cWf.setData(list.get(2));
                this.cWc.getView().setVisibility(0);
                this.cWc.a(this.cWf);
                this.cWc.kK(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new am("c13047").x("obj_locate", 6).aA(ImageViewerConfig.FORUM_ID, this.mForumId));
        if (view == this.cWa.getView()) {
            if (this.cWd != null) {
                if (this.cWi != null) {
                    this.cWi.b(view, this.cWd);
                }
                K(this.cWd.ZT());
            }
        } else if (view == this.cWb.getView()) {
            if (this.cWe != null) {
                if (this.cWi != null) {
                    this.cWi.b(view, this.cWe);
                }
                K(this.cWe.ZT());
            }
        } else if (view == this.cWc.getView() && this.cWf != null) {
            if (this.cWi != null) {
                this.cWi.b(view, this.cWf);
            }
            K(this.cWf.ZT());
        }
    }

    private void K(bb bbVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bbVar, null, o.zu(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bbVar.getFid()));
        createFromThreadCfg.setForumName(bbVar.zM());
        createFromThreadCfg.setStartFrom(0);
        o.mG(bbVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.cWi = aVar;
    }
}
