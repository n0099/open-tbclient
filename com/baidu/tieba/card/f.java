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
/* loaded from: classes9.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.e.d> {
    private LinearLayout fIZ;
    private TextView fJa;
    private LinearLayout fJb;
    private d fJc;
    private e fJd;
    private e fJe;
    private com.baidu.tieba.e.a fJf;
    private com.baidu.tieba.e.b fJg;
    private com.baidu.tieba.e.b fJh;
    private View fJi;
    private View fJj;
    private a fJk;
    private String mForumId;

    /* loaded from: classes9.dex */
    public interface a {
        void b(View view, com.baidu.tieba.card.data.b bVar);
    }

    public f(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        this.mForumId = str;
        init(getView());
    }

    private void init(View view) {
        this.fIZ = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.fJa = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.fJb = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.fJi = view.findViewById(R.id.divider_line_1);
        this.fJj = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.fJc == null) {
            this.fJc = new d(this.mTbPageContext, null, null);
        }
        this.fJc.v(0, 0, 0, 0);
        this.fJc.ro(8);
        this.fJc.rp(8);
        if (this.fJc.getView().getParent() != null) {
            ((ViewGroup) this.fJc.getView().getParent()).removeView(this.fJc.getView());
        }
        this.fJc.getView().setOnClickListener(this);
        this.fJc.getView().setVisibility(8);
        this.fJb.addView(this.fJc.getView());
        if (this.fJd == null) {
            this.fJd = new e(this.mTbPageContext);
        }
        this.fJd.rp(8);
        this.fJd.w(0, dimensionPixelSize, 0, 0);
        if (this.fJd.getView().getParent() != null) {
            ((ViewGroup) this.fJd.getView().getParent()).removeView(this.fJd.getView());
        }
        this.fJd.getView().setOnClickListener(this);
        this.fJd.getView().setVisibility(8);
        this.fJb.addView(this.fJd.getView());
        if (this.fJe == null) {
            this.fJe = new e(this.mTbPageContext);
        }
        this.fJe.rp(8);
        this.fJe.w(0, dimensionPixelSize, 0, 0);
        if (this.fJe.getView().getParent() != null) {
            ((ViewGroup) this.fJe.getView().getParent()).removeView(this.fJe.getView());
        }
        this.fJe.getView().setOnClickListener(this);
        this.fJe.getView().setVisibility(8);
        this.fJb.addView(this.fJe.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        am.setViewTextColor(this.fJa, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.fJi, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.fJj, R.color.cp_bg_line_e);
        if (this.fJc != null) {
            this.fJc.onChangeSkinType(tbPageContext, i);
        }
        if (this.fJd != null) {
            this.fJd.onChangeSkinType(tbPageContext, i);
        }
        if (this.fJe != null) {
            this.fJe.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.bwI() != null) {
            if (!TextUtils.isEmpty(dVar.bwI().title)) {
                this.fJa.setText(dVar.bwI().title);
            }
            List<bj> list = dVar.bwI().sub_nodes;
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 1) {
                this.fJf = new com.baidu.tieba.e.a();
                this.fJf.setData(list.get(0));
                this.fJc.getView().setVisibility(0);
                this.fJc.a(this.fJf);
            }
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 2) {
                this.fJg = new com.baidu.tieba.e.b();
                this.fJg.setData(list.get(1));
                this.fJd.getView().setVisibility(0);
                this.fJd.a(this.fJg);
                this.fJd.rq(8);
            }
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 3) {
                this.fJh = new com.baidu.tieba.e.b();
                this.fJh.setData(list.get(2));
                this.fJe.getView().setVisibility(0);
                this.fJe.a(this.fJh);
                this.fJe.rq(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13047").X("obj_locate", 6).cx("fid", this.mForumId));
        if (view == this.fJc.getView()) {
            if (this.fJf != null) {
                if (this.fJk != null) {
                    this.fJk.b(view, this.fJf);
                }
                X(this.fJf.aAj());
            }
        } else if (view == this.fJd.getView()) {
            if (this.fJg != null) {
                if (this.fJk != null) {
                    this.fJk.b(view, this.fJg);
                }
                X(this.fJg.aAj());
            }
        } else if (view == this.fJe.getView() && this.fJh != null) {
            if (this.fJk != null) {
                this.fJk.b(view, this.fJh);
            }
            X(this.fJh.aAj());
        }
    }

    private void X(bj bjVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bjVar, null, l.aCd(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bjVar.getFid()));
        createFromThreadCfg.setForumName(bjVar.aCw());
        createFromThreadCfg.setStartFrom(0);
        l.zV(bjVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.fJk = aVar;
    }
}
