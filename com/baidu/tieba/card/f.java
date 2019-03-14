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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes4.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.e.d> {
    private View egA;
    private View egB;
    private a egC;
    private LinearLayout egr;
    private TextView egs;
    private LinearLayout egt;
    private d egu;
    private e egv;
    private e egw;
    private com.baidu.tieba.e.a egx;
    private com.baidu.tieba.e.b egy;
    private com.baidu.tieba.e.b egz;
    private String mForumId;

    /* loaded from: classes4.dex */
    public interface a {
        void b(View view, com.baidu.tieba.card.data.b bVar);
    }

    public f(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        this.mForumId = str;
        init(getView());
    }

    private void init(View view) {
        this.egr = (LinearLayout) view.findViewById(d.g.card_frs_game_head_line_layout);
        this.egs = (TextView) view.findViewById(d.g.frs_game_head_line_title);
        this.egt = (LinearLayout) view.findViewById(d.g.frs_game_head_line_container);
        this.egA = view.findViewById(d.g.divider_line_1);
        this.egB = view.findViewById(d.g.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.tbds44);
        if (this.egu == null) {
            this.egu = new d(this.mTbPageContext, null, null);
        }
        this.egu.q(0, 0, 0, 0);
        this.egu.ol(8);
        this.egu.om(8);
        if (this.egu.getView().getParent() != null) {
            ((ViewGroup) this.egu.getView().getParent()).removeView(this.egu.getView());
        }
        this.egu.getView().setOnClickListener(this);
        this.egu.getView().setVisibility(8);
        this.egt.addView(this.egu.getView());
        if (this.egv == null) {
            this.egv = new e(this.mTbPageContext);
        }
        this.egv.om(8);
        this.egv.r(0, dimensionPixelSize, 0, 0);
        if (this.egv.getView().getParent() != null) {
            ((ViewGroup) this.egv.getView().getParent()).removeView(this.egv.getView());
        }
        this.egv.getView().setOnClickListener(this);
        this.egv.getView().setVisibility(8);
        this.egt.addView(this.egv.getView());
        if (this.egw == null) {
            this.egw = new e(this.mTbPageContext);
        }
        this.egw.om(8);
        this.egw.r(0, dimensionPixelSize, 0, 0);
        if (this.egw.getView().getParent() != null) {
            ((ViewGroup) this.egw.getView().getParent()).removeView(this.egw.getView());
        }
        this.egw.getView().setOnClickListener(this);
        this.egw.getView().setVisibility(8);
        this.egt.addView(this.egw.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        al.k(getView(), d.C0277d.cp_bg_line_d);
        al.d(this.egs, d.C0277d.cp_cont_f, 1);
        al.k(this.egA, d.C0277d.cp_bg_line_e);
        al.k(this.egB, d.C0277d.cp_bg_line_e);
        if (this.egu != null) {
            this.egu.onChangeSkinType(tbPageContext, i);
        }
        if (this.egv != null) {
            this.egv.onChangeSkinType(tbPageContext, i);
        }
        if (this.egw != null) {
            this.egw.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.aUO() != null) {
            if (!TextUtils.isEmpty(dVar.aUO().title)) {
                this.egs.setText(dVar.aUO().title);
            }
            List<bg> list = dVar.aUO().sub_nodes;
            if (com.baidu.tbadk.core.util.v.S(list) >= 1) {
                this.egx = new com.baidu.tieba.e.a();
                this.egx.setData(list.get(0));
                this.egu.getView().setVisibility(0);
                this.egu.a(this.egx);
            }
            if (com.baidu.tbadk.core.util.v.S(list) >= 2) {
                this.egy = new com.baidu.tieba.e.b();
                this.egy.setData(list.get(1));
                this.egv.getView().setVisibility(0);
                this.egv.a(this.egy);
                this.egv.on(8);
            }
            if (com.baidu.tbadk.core.util.v.S(list) >= 3) {
                this.egz = new com.baidu.tieba.e.b();
                this.egz.setData(list.get(2));
                this.egw.getView().setVisibility(0);
                this.egw.a(this.egz);
                this.egw.on(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new am("c13047").T("obj_locate", 6).bJ(ImageViewerConfig.FORUM_ID, this.mForumId));
        if (view == this.egu.getView()) {
            if (this.egx != null) {
                if (this.egC != null) {
                    this.egC.b(view, this.egx);
                }
                R(this.egx.WR());
            }
        } else if (view == this.egv.getView()) {
            if (this.egy != null) {
                if (this.egC != null) {
                    this.egC.b(view, this.egy);
                }
                R(this.egy.WR());
            }
        } else if (view == this.egw.getView() && this.egz != null) {
            if (this.egC != null) {
                this.egC.b(view, this.egz);
            }
            R(this.egz.WR());
        }
    }

    private void R(bg bgVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bgVar, null, n.YE(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bgVar.getFid()));
        createFromThreadCfg.setForumName(bgVar.YW());
        createFromThreadCfg.setStartFrom(0);
        n.tA(bgVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.egC = aVar;
    }
}
