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
    private LinearLayout fIc;
    private TextView fId;
    private LinearLayout fIe;
    private d fIf;
    private e fIg;
    private e fIh;
    private com.baidu.tieba.e.a fIi;
    private com.baidu.tieba.e.b fIj;
    private com.baidu.tieba.e.b fIk;
    private View fIl;
    private View fIm;
    private a fIn;
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
        this.fIc = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.fId = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.fIe = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.fIl = view.findViewById(R.id.divider_line_1);
        this.fIm = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.fIf == null) {
            this.fIf = new d(this.mTbPageContext, null, null);
        }
        this.fIf.v(0, 0, 0, 0);
        this.fIf.rm(8);
        this.fIf.rn(8);
        if (this.fIf.getView().getParent() != null) {
            ((ViewGroup) this.fIf.getView().getParent()).removeView(this.fIf.getView());
        }
        this.fIf.getView().setOnClickListener(this);
        this.fIf.getView().setVisibility(8);
        this.fIe.addView(this.fIf.getView());
        if (this.fIg == null) {
            this.fIg = new e(this.mTbPageContext);
        }
        this.fIg.rn(8);
        this.fIg.w(0, dimensionPixelSize, 0, 0);
        if (this.fIg.getView().getParent() != null) {
            ((ViewGroup) this.fIg.getView().getParent()).removeView(this.fIg.getView());
        }
        this.fIg.getView().setOnClickListener(this);
        this.fIg.getView().setVisibility(8);
        this.fIe.addView(this.fIg.getView());
        if (this.fIh == null) {
            this.fIh = new e(this.mTbPageContext);
        }
        this.fIh.rn(8);
        this.fIh.w(0, dimensionPixelSize, 0, 0);
        if (this.fIh.getView().getParent() != null) {
            ((ViewGroup) this.fIh.getView().getParent()).removeView(this.fIh.getView());
        }
        this.fIh.getView().setOnClickListener(this);
        this.fIh.getView().setVisibility(8);
        this.fIe.addView(this.fIh.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        am.setViewTextColor(this.fId, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.fIl, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.fIm, R.color.cp_bg_line_e);
        if (this.fIf != null) {
            this.fIf.onChangeSkinType(tbPageContext, i);
        }
        if (this.fIg != null) {
            this.fIg.onChangeSkinType(tbPageContext, i);
        }
        if (this.fIh != null) {
            this.fIh.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.bwA() != null) {
            if (!TextUtils.isEmpty(dVar.bwA().title)) {
                this.fId.setText(dVar.bwA().title);
            }
            List<bj> list = dVar.bwA().sub_nodes;
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 1) {
                this.fIi = new com.baidu.tieba.e.a();
                this.fIi.setData(list.get(0));
                this.fIf.getView().setVisibility(0);
                this.fIf.a(this.fIi);
            }
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 2) {
                this.fIj = new com.baidu.tieba.e.b();
                this.fIj.setData(list.get(1));
                this.fIg.getView().setVisibility(0);
                this.fIg.a(this.fIj);
                this.fIg.ro(8);
            }
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 3) {
                this.fIk = new com.baidu.tieba.e.b();
                this.fIk.setData(list.get(2));
                this.fIh.getView().setVisibility(0);
                this.fIh.a(this.fIk);
                this.fIh.ro(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13047").X("obj_locate", 6).cy("fid", this.mForumId));
        if (view == this.fIf.getView()) {
            if (this.fIi != null) {
                if (this.fIn != null) {
                    this.fIn.b(view, this.fIi);
                }
                W(this.fIi.aAe());
            }
        } else if (view == this.fIg.getView()) {
            if (this.fIj != null) {
                if (this.fIn != null) {
                    this.fIn.b(view, this.fIj);
                }
                W(this.fIj.aAe());
            }
        } else if (view == this.fIh.getView() && this.fIk != null) {
            if (this.fIn != null) {
                this.fIn.b(view, this.fIk);
            }
            W(this.fIk.aAe());
        }
    }

    private void W(bj bjVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bjVar, null, l.aBY(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bjVar.getFid()));
        createFromThreadCfg.setForumName(bjVar.aCr());
        createFromThreadCfg.setStartFrom(0);
        l.zS(bjVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.fIn = aVar;
    }
}
