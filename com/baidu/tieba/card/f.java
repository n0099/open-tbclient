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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes6.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.e.d> {
    private com.baidu.tieba.e.a fCA;
    private com.baidu.tieba.e.b fCB;
    private com.baidu.tieba.e.b fCC;
    private View fCD;
    private View fCE;
    private a fCF;
    private LinearLayout fCu;
    private TextView fCv;
    private LinearLayout fCw;
    private d fCx;
    private e fCy;
    private e fCz;
    private String mForumId;

    /* loaded from: classes6.dex */
    public interface a {
        void b(View view, com.baidu.tieba.card.data.b bVar);
    }

    public f(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        this.mForumId = str;
        init(getView());
    }

    private void init(View view) {
        this.fCu = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.fCv = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.fCw = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.fCD = view.findViewById(R.id.divider_line_1);
        this.fCE = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.fCx == null) {
            this.fCx = new d(this.mTbPageContext, null, null);
        }
        this.fCx.v(0, 0, 0, 0);
        this.fCx.ra(8);
        this.fCx.rb(8);
        if (this.fCx.getView().getParent() != null) {
            ((ViewGroup) this.fCx.getView().getParent()).removeView(this.fCx.getView());
        }
        this.fCx.getView().setOnClickListener(this);
        this.fCx.getView().setVisibility(8);
        this.fCw.addView(this.fCx.getView());
        if (this.fCy == null) {
            this.fCy = new e(this.mTbPageContext);
        }
        this.fCy.rb(8);
        this.fCy.w(0, dimensionPixelSize, 0, 0);
        if (this.fCy.getView().getParent() != null) {
            ((ViewGroup) this.fCy.getView().getParent()).removeView(this.fCy.getView());
        }
        this.fCy.getView().setOnClickListener(this);
        this.fCy.getView().setVisibility(8);
        this.fCw.addView(this.fCy.getView());
        if (this.fCz == null) {
            this.fCz = new e(this.mTbPageContext);
        }
        this.fCz.rb(8);
        this.fCz.w(0, dimensionPixelSize, 0, 0);
        if (this.fCz.getView().getParent() != null) {
            ((ViewGroup) this.fCz.getView().getParent()).removeView(this.fCz.getView());
        }
        this.fCz.getView().setOnClickListener(this);
        this.fCz.getView().setVisibility(8);
        this.fCw.addView(this.fCz.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        am.setViewTextColor(this.fCv, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.fCD, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.fCE, R.color.cp_bg_line_e);
        if (this.fCx != null) {
            this.fCx.onChangeSkinType(tbPageContext, i);
        }
        if (this.fCy != null) {
            this.fCy.onChangeSkinType(tbPageContext, i);
        }
        if (this.fCz != null) {
            this.fCz.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.btU() != null) {
            if (!TextUtils.isEmpty(dVar.btU().title)) {
                this.fCv.setText(dVar.btU().title);
            }
            List<bj> list = dVar.btU().sub_nodes;
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 1) {
                this.fCA = new com.baidu.tieba.e.a();
                this.fCA.setData(list.get(0));
                this.fCx.getView().setVisibility(0);
                this.fCx.a(this.fCA);
            }
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 2) {
                this.fCB = new com.baidu.tieba.e.b();
                this.fCB.setData(list.get(1));
                this.fCy.getView().setVisibility(0);
                this.fCy.a(this.fCB);
                this.fCy.rc(8);
            }
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 3) {
                this.fCC = new com.baidu.tieba.e.b();
                this.fCC.setData(list.get(2));
                this.fCz.getView().setVisibility(0);
                this.fCz.a(this.fCC);
                this.fCz.rc(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13047").Z("obj_locate", 6).cp("fid", this.mForumId));
        if (view == this.fCx.getView()) {
            if (this.fCA != null) {
                if (this.fCF != null) {
                    this.fCF.b(view, this.fCA);
                }
                U(this.fCA.axx());
            }
        } else if (view == this.fCy.getView()) {
            if (this.fCB != null) {
                if (this.fCF != null) {
                    this.fCF.b(view, this.fCB);
                }
                U(this.fCB.axx());
            }
        } else if (view == this.fCz.getView() && this.fCC != null) {
            if (this.fCF != null) {
                this.fCF.b(view, this.fCC);
            }
            U(this.fCC.axx());
        }
    }

    private void U(bj bjVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bjVar, null, l.azq(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bjVar.getFid()));
        createFromThreadCfg.setForumName(bjVar.azJ());
        createFromThreadCfg.setStartFrom(0);
        l.zs(bjVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.fCF = aVar;
    }
}
