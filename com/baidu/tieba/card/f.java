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
    private View fIA;
    private View fIB;
    private a fIC;
    private LinearLayout fIr;
    private TextView fIs;
    private LinearLayout fIt;
    private d fIu;
    private e fIv;
    private e fIw;
    private com.baidu.tieba.e.a fIx;
    private com.baidu.tieba.e.b fIy;
    private com.baidu.tieba.e.b fIz;
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
        this.fIr = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.fIs = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.fIt = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.fIA = view.findViewById(R.id.divider_line_1);
        this.fIB = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.fIu == null) {
            this.fIu = new d(this.mTbPageContext, null, null);
        }
        this.fIu.v(0, 0, 0, 0);
        this.fIu.rm(8);
        this.fIu.rn(8);
        if (this.fIu.getView().getParent() != null) {
            ((ViewGroup) this.fIu.getView().getParent()).removeView(this.fIu.getView());
        }
        this.fIu.getView().setOnClickListener(this);
        this.fIu.getView().setVisibility(8);
        this.fIt.addView(this.fIu.getView());
        if (this.fIv == null) {
            this.fIv = new e(this.mTbPageContext);
        }
        this.fIv.rn(8);
        this.fIv.w(0, dimensionPixelSize, 0, 0);
        if (this.fIv.getView().getParent() != null) {
            ((ViewGroup) this.fIv.getView().getParent()).removeView(this.fIv.getView());
        }
        this.fIv.getView().setOnClickListener(this);
        this.fIv.getView().setVisibility(8);
        this.fIt.addView(this.fIv.getView());
        if (this.fIw == null) {
            this.fIw = new e(this.mTbPageContext);
        }
        this.fIw.rn(8);
        this.fIw.w(0, dimensionPixelSize, 0, 0);
        if (this.fIw.getView().getParent() != null) {
            ((ViewGroup) this.fIw.getView().getParent()).removeView(this.fIw.getView());
        }
        this.fIw.getView().setOnClickListener(this);
        this.fIw.getView().setVisibility(8);
        this.fIt.addView(this.fIw.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        am.setViewTextColor(this.fIs, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.fIA, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.fIB, R.color.cp_bg_line_e);
        if (this.fIu != null) {
            this.fIu.onChangeSkinType(tbPageContext, i);
        }
        if (this.fIv != null) {
            this.fIv.onChangeSkinType(tbPageContext, i);
        }
        if (this.fIw != null) {
            this.fIw.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.bwD() != null) {
            if (!TextUtils.isEmpty(dVar.bwD().title)) {
                this.fIs.setText(dVar.bwD().title);
            }
            List<bj> list = dVar.bwD().sub_nodes;
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 1) {
                this.fIx = new com.baidu.tieba.e.a();
                this.fIx.setData(list.get(0));
                this.fIu.getView().setVisibility(0);
                this.fIu.a(this.fIx);
            }
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 2) {
                this.fIy = new com.baidu.tieba.e.b();
                this.fIy.setData(list.get(1));
                this.fIv.getView().setVisibility(0);
                this.fIv.a(this.fIy);
                this.fIv.ro(8);
            }
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 3) {
                this.fIz = new com.baidu.tieba.e.b();
                this.fIz.setData(list.get(2));
                this.fIw.getView().setVisibility(0);
                this.fIw.a(this.fIz);
                this.fIw.ro(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13047").X("obj_locate", 6).cy("fid", this.mForumId));
        if (view == this.fIu.getView()) {
            if (this.fIx != null) {
                if (this.fIC != null) {
                    this.fIC.b(view, this.fIx);
                }
                W(this.fIx.aAg());
            }
        } else if (view == this.fIv.getView()) {
            if (this.fIy != null) {
                if (this.fIC != null) {
                    this.fIC.b(view, this.fIy);
                }
                W(this.fIy.aAg());
            }
        } else if (view == this.fIw.getView() && this.fIz != null) {
            if (this.fIC != null) {
                this.fIC.b(view, this.fIz);
            }
            W(this.fIz.aAg());
        }
    }

    private void W(bj bjVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bjVar, null, l.aCa(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bjVar.getFid()));
        createFromThreadCfg.setForumName(bjVar.aCt());
        createFromThreadCfg.setStartFrom(0);
        l.zT(bjVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.fIC = aVar;
    }
}
