package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.e.d> {
    private LinearLayout eAY;
    private TextView eAZ;
    private LinearLayout eBa;
    private d eBb;
    private e eBc;
    private e eBd;
    private com.baidu.tieba.e.a eBe;
    private com.baidu.tieba.e.b eBf;
    private com.baidu.tieba.e.b eBg;
    private View eBh;
    private View eBi;
    private a eBj;
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
        this.eAY = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.eAZ = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.eBa = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.eBh = view.findViewById(R.id.divider_line_1);
        this.eBi = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.eBb == null) {
            this.eBb = new d(this.mTbPageContext, null, null);
        }
        this.eBb.r(0, 0, 0, 0);
        this.eBb.pC(8);
        this.eBb.pD(8);
        if (this.eBb.getView().getParent() != null) {
            ((ViewGroup) this.eBb.getView().getParent()).removeView(this.eBb.getView());
        }
        this.eBb.getView().setOnClickListener(this);
        this.eBb.getView().setVisibility(8);
        this.eBa.addView(this.eBb.getView());
        if (this.eBc == null) {
            this.eBc = new e(this.mTbPageContext);
        }
        this.eBc.pD(8);
        this.eBc.s(0, dimensionPixelSize, 0, 0);
        if (this.eBc.getView().getParent() != null) {
            ((ViewGroup) this.eBc.getView().getParent()).removeView(this.eBc.getView());
        }
        this.eBc.getView().setOnClickListener(this);
        this.eBc.getView().setVisibility(8);
        this.eBa.addView(this.eBc.getView());
        if (this.eBd == null) {
            this.eBd = new e(this.mTbPageContext);
        }
        this.eBd.pD(8);
        this.eBd.s(0, dimensionPixelSize, 0, 0);
        if (this.eBd.getView().getParent() != null) {
            ((ViewGroup) this.eBd.getView().getParent()).removeView(this.eBd.getView());
        }
        this.eBd.getView().setOnClickListener(this);
        this.eBd.getView().setVisibility(8);
        this.eBa.addView(this.eBd.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.k(getView(), R.color.cp_bg_line_d);
        am.f(this.eAZ, R.color.cp_cont_f, 1);
        am.k(this.eBh, R.color.cp_bg_line_e);
        am.k(this.eBi, R.color.cp_bg_line_e);
        if (this.eBb != null) {
            this.eBb.onChangeSkinType(tbPageContext, i);
        }
        if (this.eBc != null) {
            this.eBc.onChangeSkinType(tbPageContext, i);
        }
        if (this.eBd != null) {
            this.eBd.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.bea() != null) {
            if (!TextUtils.isEmpty(dVar.bea().title)) {
                this.eAZ.setText(dVar.bea().title);
            }
            List<bh> list = dVar.bea().sub_nodes;
            if (com.baidu.tbadk.core.util.v.Z(list) >= 1) {
                this.eBe = new com.baidu.tieba.e.a();
                this.eBe.setData(list.get(0));
                this.eBb.getView().setVisibility(0);
                this.eBb.a(this.eBe);
            }
            if (com.baidu.tbadk.core.util.v.Z(list) >= 2) {
                this.eBf = new com.baidu.tieba.e.b();
                this.eBf.setData(list.get(1));
                this.eBc.getView().setVisibility(0);
                this.eBc.a(this.eBf);
                this.eBc.pE(8);
            }
            if (com.baidu.tbadk.core.util.v.Z(list) >= 3) {
                this.eBg = new com.baidu.tieba.e.b();
                this.eBg.setData(list.get(2));
                this.eBd.getView().setVisibility(0);
                this.eBd.a(this.eBg);
                this.eBd.pE(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13047").P("obj_locate", 6).bT("fid", this.mForumId));
        if (view == this.eBb.getView()) {
            if (this.eBe != null) {
                if (this.eBj != null) {
                    this.eBj.b(view, this.eBe);
                }
                R(this.eBe.acy());
            }
        } else if (view == this.eBc.getView()) {
            if (this.eBf != null) {
                if (this.eBj != null) {
                    this.eBj.b(view, this.eBf);
                }
                R(this.eBf.acy());
            }
        } else if (view == this.eBd.getView() && this.eBg != null) {
            if (this.eBj != null) {
                this.eBj.b(view, this.eBg);
            }
            R(this.eBg.acy());
        }
    }

    private void R(bh bhVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bhVar, null, n.ael(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bhVar.getFid()));
        createFromThreadCfg.setForumName(bhVar.aeD());
        createFromThreadCfg.setStartFrom(0);
        n.vx(bhVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.eBj = aVar;
    }
}
