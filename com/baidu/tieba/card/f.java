package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.e.d> {
    private LinearLayout eAR;
    private TextView eAS;
    private LinearLayout eAT;
    private d eAU;
    private e eAV;
    private e eAW;
    private com.baidu.tieba.e.a eAX;
    private com.baidu.tieba.e.b eAY;
    private com.baidu.tieba.e.b eAZ;
    private View eBa;
    private View eBb;
    private a eBc;
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
        this.eAR = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.eAS = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.eAT = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.eBa = view.findViewById(R.id.divider_line_1);
        this.eBb = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.eAU == null) {
            this.eAU = new d(this.mTbPageContext, null, null);
        }
        this.eAU.r(0, 0, 0, 0);
        this.eAU.pB(8);
        this.eAU.pC(8);
        if (this.eAU.getView().getParent() != null) {
            ((ViewGroup) this.eAU.getView().getParent()).removeView(this.eAU.getView());
        }
        this.eAU.getView().setOnClickListener(this);
        this.eAU.getView().setVisibility(8);
        this.eAT.addView(this.eAU.getView());
        if (this.eAV == null) {
            this.eAV = new e(this.mTbPageContext);
        }
        this.eAV.pC(8);
        this.eAV.s(0, dimensionPixelSize, 0, 0);
        if (this.eAV.getView().getParent() != null) {
            ((ViewGroup) this.eAV.getView().getParent()).removeView(this.eAV.getView());
        }
        this.eAV.getView().setOnClickListener(this);
        this.eAV.getView().setVisibility(8);
        this.eAT.addView(this.eAV.getView());
        if (this.eAW == null) {
            this.eAW = new e(this.mTbPageContext);
        }
        this.eAW.pC(8);
        this.eAW.s(0, dimensionPixelSize, 0, 0);
        if (this.eAW.getView().getParent() != null) {
            ((ViewGroup) this.eAW.getView().getParent()).removeView(this.eAW.getView());
        }
        this.eAW.getView().setOnClickListener(this);
        this.eAW.getView().setVisibility(8);
        this.eAT.addView(this.eAW.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.k(getView(), R.color.cp_bg_line_d);
        am.f(this.eAS, R.color.cp_cont_f, 1);
        am.k(this.eBa, R.color.cp_bg_line_e);
        am.k(this.eBb, R.color.cp_bg_line_e);
        if (this.eAU != null) {
            this.eAU.onChangeSkinType(tbPageContext, i);
        }
        if (this.eAV != null) {
            this.eAV.onChangeSkinType(tbPageContext, i);
        }
        if (this.eAW != null) {
            this.eAW.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.bdY() != null) {
            if (!TextUtils.isEmpty(dVar.bdY().title)) {
                this.eAS.setText(dVar.bdY().title);
            }
            List<bg> list = dVar.bdY().sub_nodes;
            if (com.baidu.tbadk.core.util.v.Z(list) >= 1) {
                this.eAX = new com.baidu.tieba.e.a();
                this.eAX.setData(list.get(0));
                this.eAU.getView().setVisibility(0);
                this.eAU.a(this.eAX);
            }
            if (com.baidu.tbadk.core.util.v.Z(list) >= 2) {
                this.eAY = new com.baidu.tieba.e.b();
                this.eAY.setData(list.get(1));
                this.eAV.getView().setVisibility(0);
                this.eAV.a(this.eAY);
                this.eAV.pD(8);
            }
            if (com.baidu.tbadk.core.util.v.Z(list) >= 3) {
                this.eAZ = new com.baidu.tieba.e.b();
                this.eAZ.setData(list.get(2));
                this.eAW.getView().setVisibility(0);
                this.eAW.a(this.eAZ);
                this.eAW.pD(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13047").P("obj_locate", 6).bT("fid", this.mForumId));
        if (view == this.eAU.getView()) {
            if (this.eAX != null) {
                if (this.eBc != null) {
                    this.eBc.b(view, this.eAX);
                }
                Q(this.eAX.acx());
            }
        } else if (view == this.eAV.getView()) {
            if (this.eAY != null) {
                if (this.eBc != null) {
                    this.eBc.b(view, this.eAY);
                }
                Q(this.eAY.acx());
            }
        } else if (view == this.eAW.getView() && this.eAZ != null) {
            if (this.eBc != null) {
                this.eBc.b(view, this.eAZ);
            }
            Q(this.eAZ.acx());
        }
    }

    private void Q(bg bgVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bgVar, null, n.aek(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bgVar.getFid()));
        createFromThreadCfg.setForumName(bgVar.aeC());
        createFromThreadCfg.setStartFrom(0);
        n.vw(bgVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.eBc = aVar;
    }
}
