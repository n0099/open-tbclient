package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    private d eKA;
    private e eKB;
    private e eKC;
    private com.baidu.tieba.e.a eKD;
    private com.baidu.tieba.e.b eKE;
    private com.baidu.tieba.e.b eKF;
    private View eKG;
    private View eKH;
    private a eKI;
    private LinearLayout eKx;
    private TextView eKy;
    private LinearLayout eKz;
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
        this.eKx = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.eKy = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.eKz = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.eKG = view.findViewById(R.id.divider_line_1);
        this.eKH = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.eKA == null) {
            this.eKA = new d(this.mTbPageContext, null, null);
        }
        this.eKA.r(0, 0, 0, 0);
        this.eKA.oH(8);
        this.eKA.oI(8);
        if (this.eKA.getView().getParent() != null) {
            ((ViewGroup) this.eKA.getView().getParent()).removeView(this.eKA.getView());
        }
        this.eKA.getView().setOnClickListener(this);
        this.eKA.getView().setVisibility(8);
        this.eKz.addView(this.eKA.getView());
        if (this.eKB == null) {
            this.eKB = new e(this.mTbPageContext);
        }
        this.eKB.oI(8);
        this.eKB.s(0, dimensionPixelSize, 0, 0);
        if (this.eKB.getView().getParent() != null) {
            ((ViewGroup) this.eKB.getView().getParent()).removeView(this.eKB.getView());
        }
        this.eKB.getView().setOnClickListener(this);
        this.eKB.getView().setVisibility(8);
        this.eKz.addView(this.eKB.getView());
        if (this.eKC == null) {
            this.eKC = new e(this.mTbPageContext);
        }
        this.eKC.oI(8);
        this.eKC.s(0, dimensionPixelSize, 0, 0);
        if (this.eKC.getView().getParent() != null) {
            ((ViewGroup) this.eKC.getView().getParent()).removeView(this.eKC.getView());
        }
        this.eKC.getView().setOnClickListener(this);
        this.eKC.getView().setVisibility(8);
        this.eKz.addView(this.eKC.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        am.setViewTextColor(this.eKy, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.eKG, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.eKH, R.color.cp_bg_line_e);
        if (this.eKA != null) {
            this.eKA.onChangeSkinType(tbPageContext, i);
        }
        if (this.eKB != null) {
            this.eKB.onChangeSkinType(tbPageContext, i);
        }
        if (this.eKC != null) {
            this.eKC.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.bcx() != null) {
            if (!TextUtils.isEmpty(dVar.bcx().title)) {
                this.eKy.setText(dVar.bcx().title);
            }
            List<bh> list = dVar.bcx().sub_nodes;
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 1) {
                this.eKD = new com.baidu.tieba.e.a();
                this.eKD.setData(list.get(0));
                this.eKA.getView().setVisibility(0);
                this.eKA.a(this.eKD);
            }
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 2) {
                this.eKE = new com.baidu.tieba.e.b();
                this.eKE.setData(list.get(1));
                this.eKB.getView().setVisibility(0);
                this.eKB.a(this.eKE);
                this.eKB.oJ(8);
            }
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 3) {
                this.eKF = new com.baidu.tieba.e.b();
                this.eKF.setData(list.get(2));
                this.eKC.getView().setVisibility(0);
                this.eKC.a(this.eKF);
                this.eKC.oJ(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13047").O("obj_locate", 6).bS("fid", this.mForumId));
        if (view == this.eKA.getView()) {
            if (this.eKD != null) {
                if (this.eKI != null) {
                    this.eKI.b(view, this.eKD);
                }
                Q(this.eKD.agG());
            }
        } else if (view == this.eKB.getView()) {
            if (this.eKE != null) {
                if (this.eKI != null) {
                    this.eKI.b(view, this.eKE);
                }
                Q(this.eKE.agG());
            }
        } else if (view == this.eKC.getView() && this.eKF != null) {
            if (this.eKI != null) {
                this.eKI.b(view, this.eKF);
            }
            Q(this.eKF.agG());
        }
    }

    private void Q(bh bhVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bhVar, null, n.air(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bhVar.getFid()));
        createFromThreadCfg.setForumName(bhVar.aiJ());
        createFromThreadCfg.setStartFrom(0);
        n.uz(bhVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.eKI = aVar;
    }
}
