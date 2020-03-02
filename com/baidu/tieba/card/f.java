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
    private LinearLayout fIe;
    private TextView fIf;
    private LinearLayout fIg;
    private d fIh;
    private e fIi;
    private e fIj;
    private com.baidu.tieba.e.a fIk;
    private com.baidu.tieba.e.b fIl;
    private com.baidu.tieba.e.b fIm;
    private View fIn;
    private View fIo;
    private a fIp;
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
        this.fIe = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.fIf = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.fIg = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.fIn = view.findViewById(R.id.divider_line_1);
        this.fIo = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.fIh == null) {
            this.fIh = new d(this.mTbPageContext, null, null);
        }
        this.fIh.v(0, 0, 0, 0);
        this.fIh.rm(8);
        this.fIh.rn(8);
        if (this.fIh.getView().getParent() != null) {
            ((ViewGroup) this.fIh.getView().getParent()).removeView(this.fIh.getView());
        }
        this.fIh.getView().setOnClickListener(this);
        this.fIh.getView().setVisibility(8);
        this.fIg.addView(this.fIh.getView());
        if (this.fIi == null) {
            this.fIi = new e(this.mTbPageContext);
        }
        this.fIi.rn(8);
        this.fIi.w(0, dimensionPixelSize, 0, 0);
        if (this.fIi.getView().getParent() != null) {
            ((ViewGroup) this.fIi.getView().getParent()).removeView(this.fIi.getView());
        }
        this.fIi.getView().setOnClickListener(this);
        this.fIi.getView().setVisibility(8);
        this.fIg.addView(this.fIi.getView());
        if (this.fIj == null) {
            this.fIj = new e(this.mTbPageContext);
        }
        this.fIj.rn(8);
        this.fIj.w(0, dimensionPixelSize, 0, 0);
        if (this.fIj.getView().getParent() != null) {
            ((ViewGroup) this.fIj.getView().getParent()).removeView(this.fIj.getView());
        }
        this.fIj.getView().setOnClickListener(this);
        this.fIj.getView().setVisibility(8);
        this.fIg.addView(this.fIj.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        am.setViewTextColor(this.fIf, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.fIn, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.fIo, R.color.cp_bg_line_e);
        if (this.fIh != null) {
            this.fIh.onChangeSkinType(tbPageContext, i);
        }
        if (this.fIi != null) {
            this.fIi.onChangeSkinType(tbPageContext, i);
        }
        if (this.fIj != null) {
            this.fIj.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.bwC() != null) {
            if (!TextUtils.isEmpty(dVar.bwC().title)) {
                this.fIf.setText(dVar.bwC().title);
            }
            List<bj> list = dVar.bwC().sub_nodes;
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 1) {
                this.fIk = new com.baidu.tieba.e.a();
                this.fIk.setData(list.get(0));
                this.fIh.getView().setVisibility(0);
                this.fIh.a(this.fIk);
            }
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 2) {
                this.fIl = new com.baidu.tieba.e.b();
                this.fIl.setData(list.get(1));
                this.fIi.getView().setVisibility(0);
                this.fIi.a(this.fIl);
                this.fIi.ro(8);
            }
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 3) {
                this.fIm = new com.baidu.tieba.e.b();
                this.fIm.setData(list.get(2));
                this.fIj.getView().setVisibility(0);
                this.fIj.a(this.fIm);
                this.fIj.ro(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13047").X("obj_locate", 6).cy("fid", this.mForumId));
        if (view == this.fIh.getView()) {
            if (this.fIk != null) {
                if (this.fIp != null) {
                    this.fIp.b(view, this.fIk);
                }
                W(this.fIk.aAg());
            }
        } else if (view == this.fIi.getView()) {
            if (this.fIl != null) {
                if (this.fIp != null) {
                    this.fIp.b(view, this.fIl);
                }
                W(this.fIl.aAg());
            }
        } else if (view == this.fIj.getView() && this.fIm != null) {
            if (this.fIp != null) {
                this.fIp.b(view, this.fIm);
            }
            W(this.fIm.aAg());
        }
    }

    private void W(bj bjVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bjVar, null, l.aCa(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bjVar.getFid()));
        createFromThreadCfg.setForumName(bjVar.aCt());
        createFromThreadCfg.setStartFrom(0);
        l.zS(bjVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.fIp = aVar;
    }
}
