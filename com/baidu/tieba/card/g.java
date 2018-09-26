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
    private LinearLayout cCZ;
    private TextView cDa;
    private LinearLayout cDb;
    private e cDc;
    private f cDd;
    private f cDe;
    private com.baidu.tieba.e.a cDf;
    private com.baidu.tieba.e.b cDg;
    private com.baidu.tieba.e.b cDh;
    private View cDi;
    private View cDj;
    private a cDk;
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
        this.cCZ = (LinearLayout) view.findViewById(e.g.card_frs_game_head_line_layout);
        this.cDa = (TextView) view.findViewById(e.g.frs_game_head_line_title);
        this.cDb = (LinearLayout) view.findViewById(e.g.frs_game_head_line_container);
        this.cDi = view.findViewById(e.g.divider_line_1);
        this.cDj = view.findViewById(e.g.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0141e.tbds44);
        if (this.cDc == null) {
            this.cDc = new e(this.mTbPageContext, null, null);
        }
        this.cDc.m(0, 0, 0, 0);
        this.cDc.jo(8);
        this.cDc.jp(8);
        if (this.cDc.getView().getParent() != null) {
            ((ViewGroup) this.cDc.getView().getParent()).removeView(this.cDc.getView());
        }
        this.cDc.getView().setOnClickListener(this);
        this.cDc.getView().setVisibility(8);
        this.cDb.addView(this.cDc.getView());
        if (this.cDd == null) {
            this.cDd = new f(this.mTbPageContext);
        }
        this.cDd.jp(8);
        this.cDd.n(0, dimensionPixelSize, 0, 0);
        if (this.cDd.getView().getParent() != null) {
            ((ViewGroup) this.cDd.getView().getParent()).removeView(this.cDd.getView());
        }
        this.cDd.getView().setOnClickListener(this);
        this.cDd.getView().setVisibility(8);
        this.cDb.addView(this.cDd.getView());
        if (this.cDe == null) {
            this.cDe = new f(this.mTbPageContext);
        }
        this.cDe.jp(8);
        this.cDe.n(0, dimensionPixelSize, 0, 0);
        if (this.cDe.getView().getParent() != null) {
            ((ViewGroup) this.cDe.getView().getParent()).removeView(this.cDe.getView());
        }
        this.cDe.getView().setOnClickListener(this);
        this.cDe.getView().setVisibility(8);
        this.cDb.addView(this.cDe.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.i(getView(), e.d.cp_bg_line_d);
        al.c(this.cDa, e.d.cp_cont_f, 1);
        al.i(this.cDi, e.d.cp_bg_line_e);
        al.i(this.cDj, e.d.cp_bg_line_e);
        if (this.cDc != null) {
            this.cDc.d(tbPageContext, i);
        }
        if (this.cDd != null) {
            this.cDd.d(tbPageContext, i);
        }
        if (this.cDe != null) {
            this.cDe.d(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.apa() != null) {
            if (!TextUtils.isEmpty(dVar.apa().title)) {
                this.cDa.setText(dVar.apa().title);
            }
            List<bb> list = dVar.apa().sub_nodes;
            if (com.baidu.tbadk.core.util.v.y(list) >= 1) {
                this.cDf = new com.baidu.tieba.e.a();
                this.cDf.setData(list.get(0));
                this.cDc.getView().setVisibility(0);
                this.cDc.a(this.cDf);
            }
            if (com.baidu.tbadk.core.util.v.y(list) >= 2) {
                this.cDg = new com.baidu.tieba.e.b();
                this.cDg.setData(list.get(1));
                this.cDd.getView().setVisibility(0);
                this.cDd.a(this.cDg);
                this.cDd.jq(8);
            }
            if (com.baidu.tbadk.core.util.v.y(list) >= 3) {
                this.cDh = new com.baidu.tieba.e.b();
                this.cDh.setData(list.get(2));
                this.cDe.getView().setVisibility(0);
                this.cDe.a(this.cDh);
                this.cDe.jq(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new am("c13047").w("obj_locate", 6).al(ImageViewerConfig.FORUM_ID, this.mForumId));
        if (view == this.cDc.getView()) {
            if (this.cDf != null) {
                if (this.cDk != null) {
                    this.cDk.b(view, this.cDf);
                }
                K(this.cDf.UT());
            }
        } else if (view == this.cDd.getView()) {
            if (this.cDg != null) {
                if (this.cDk != null) {
                    this.cDk.b(view, this.cDg);
                }
                K(this.cDg.UT());
            }
        } else if (view == this.cDe.getView() && this.cDh != null) {
            if (this.cDk != null) {
                this.cDk.b(view, this.cDh);
            }
            K(this.cDh.UT());
        }
    }

    private void K(bb bbVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bbVar, null, o.wa(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bbVar.getFid()));
        createFromThreadCfg.setForumName(bbVar.ws());
        createFromThreadCfg.setStartFrom(0);
        o.lA(bbVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.cDk = aVar;
    }
}
