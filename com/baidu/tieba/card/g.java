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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes21.dex */
public class g extends b<com.baidu.tieba.e.d> {
    private LinearLayout hpm;
    private TextView hpn;
    private LinearLayout hpo;
    private e hpp;
    private f hpq;
    private f hpr;
    private com.baidu.tieba.e.a hps;
    private com.baidu.tieba.e.b hpt;
    private com.baidu.tieba.e.b hpu;
    private View hpv;
    private View hpw;
    private a hpx;
    private String mForumId;

    /* loaded from: classes21.dex */
    public interface a {
        void b(View view, com.baidu.tieba.card.data.b bVar);
    }

    public g(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        this.mForumId = str;
        init(getView());
    }

    private void init(View view) {
        this.hpm = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.hpn = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.hpo = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.hpv = view.findViewById(R.id.divider_line_1);
        this.hpw = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.hpp == null) {
            this.hpp = new e(this.mTbPageContext, null, null);
        }
        this.hpp.x(0, 0, 0, 0);
        this.hpp.vQ(8);
        this.hpp.vR(8);
        if (this.hpp.getView().getParent() != null) {
            ((ViewGroup) this.hpp.getView().getParent()).removeView(this.hpp.getView());
        }
        this.hpp.getView().setOnClickListener(this);
        this.hpp.getView().setVisibility(8);
        this.hpo.addView(this.hpp.getView());
        if (this.hpq == null) {
            this.hpq = new f(this.mTbPageContext);
        }
        this.hpq.vR(8);
        this.hpq.y(0, dimensionPixelSize, 0, 0);
        if (this.hpq.getView().getParent() != null) {
            ((ViewGroup) this.hpq.getView().getParent()).removeView(this.hpq.getView());
        }
        this.hpq.getView().setOnClickListener(this);
        this.hpq.getView().setVisibility(8);
        this.hpo.addView(this.hpq.getView());
        if (this.hpr == null) {
            this.hpr = new f(this.mTbPageContext);
        }
        this.hpr.vR(8);
        this.hpr.y(0, dimensionPixelSize, 0, 0);
        if (this.hpr.getView().getParent() != null) {
            ((ViewGroup) this.hpr.getView().getParent()).removeView(this.hpr.getView());
        }
        this.hpr.getView().setOnClickListener(this);
        this.hpr.getView().setVisibility(8);
        this.hpo.addView(this.hpr.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        ap.setViewTextColor(this.hpn, R.color.cp_cont_f, 1);
        ap.setBackgroundResource(this.hpv, R.color.cp_bg_line_e);
        ap.setBackgroundResource(this.hpw, R.color.cp_bg_line_e);
        if (this.hpp != null) {
            this.hpp.onChangeSkinType(tbPageContext, i);
        }
        if (this.hpq != null) {
            this.hpq.onChangeSkinType(tbPageContext, i);
        }
        if (this.hpr != null) {
            this.hpr.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.cgH() != null) {
            if (!TextUtils.isEmpty(dVar.cgH().title)) {
                this.hpn.setText(dVar.cgH().title);
            }
            List<bw> list = dVar.cgH().sub_nodes;
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 1) {
                this.hps = new com.baidu.tieba.e.a();
                this.hps.setData(list.get(0));
                this.hpp.getView().setVisibility(0);
                this.hpp.a(this.hps);
            }
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 2) {
                this.hpt = new com.baidu.tieba.e.b();
                this.hpt.setData(list.get(1));
                this.hpq.getView().setVisibility(0);
                this.hpq.a(this.hpt);
                this.hpq.vS(8);
            }
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 3) {
                this.hpu = new com.baidu.tieba.e.b();
                this.hpu.setData(list.get(2));
                this.hpr.getView().setVisibility(0);
                this.hpr.a(this.hpu);
                this.hpr.vS(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new aq("c13047").ai("obj_locate", 6).dF("fid", this.mForumId));
        if (view == this.hpp.getView()) {
            if (this.hps != null) {
                if (this.hpx != null) {
                    this.hpx.b(view, this.hps);
                }
                X(this.hps.bcY());
            }
        } else if (view == this.hpq.getView()) {
            if (this.hpt != null) {
                if (this.hpx != null) {
                    this.hpx.b(view, this.hpt);
                }
                X(this.hpt.bcY());
            }
        } else if (view == this.hpr.getView() && this.hpu != null) {
            if (this.hpx != null) {
                this.hpx.b(view, this.hpu);
            }
            X(this.hpu.bcY());
        }
    }

    private void X(bw bwVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bwVar, null, m.bfk(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bwVar.getFid()));
        createFromThreadCfg.setForumName(bwVar.bfC());
        createFromThreadCfg.setStartFrom(0);
        m.Hw(bwVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.hpx = aVar;
    }
}
