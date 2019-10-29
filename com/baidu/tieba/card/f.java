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
    private LinearLayout eLo;
    private TextView eLp;
    private LinearLayout eLq;
    private d eLr;
    private e eLs;
    private e eLt;
    private com.baidu.tieba.e.a eLu;
    private com.baidu.tieba.e.b eLv;
    private com.baidu.tieba.e.b eLw;
    private View eLx;
    private View eLy;
    private a eLz;
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
        this.eLo = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.eLp = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.eLq = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.eLx = view.findViewById(R.id.divider_line_1);
        this.eLy = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.eLr == null) {
            this.eLr = new d(this.mTbPageContext, null, null);
        }
        this.eLr.r(0, 0, 0, 0);
        this.eLr.oI(8);
        this.eLr.oJ(8);
        if (this.eLr.getView().getParent() != null) {
            ((ViewGroup) this.eLr.getView().getParent()).removeView(this.eLr.getView());
        }
        this.eLr.getView().setOnClickListener(this);
        this.eLr.getView().setVisibility(8);
        this.eLq.addView(this.eLr.getView());
        if (this.eLs == null) {
            this.eLs = new e(this.mTbPageContext);
        }
        this.eLs.oJ(8);
        this.eLs.s(0, dimensionPixelSize, 0, 0);
        if (this.eLs.getView().getParent() != null) {
            ((ViewGroup) this.eLs.getView().getParent()).removeView(this.eLs.getView());
        }
        this.eLs.getView().setOnClickListener(this);
        this.eLs.getView().setVisibility(8);
        this.eLq.addView(this.eLs.getView());
        if (this.eLt == null) {
            this.eLt = new e(this.mTbPageContext);
        }
        this.eLt.oJ(8);
        this.eLt.s(0, dimensionPixelSize, 0, 0);
        if (this.eLt.getView().getParent() != null) {
            ((ViewGroup) this.eLt.getView().getParent()).removeView(this.eLt.getView());
        }
        this.eLt.getView().setOnClickListener(this);
        this.eLt.getView().setVisibility(8);
        this.eLq.addView(this.eLt.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        am.setViewTextColor(this.eLp, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.eLx, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.eLy, R.color.cp_bg_line_e);
        if (this.eLr != null) {
            this.eLr.onChangeSkinType(tbPageContext, i);
        }
        if (this.eLs != null) {
            this.eLs.onChangeSkinType(tbPageContext, i);
        }
        if (this.eLt != null) {
            this.eLt.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.bcz() != null) {
            if (!TextUtils.isEmpty(dVar.bcz().title)) {
                this.eLp.setText(dVar.bcz().title);
            }
            List<bh> list = dVar.bcz().sub_nodes;
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 1) {
                this.eLu = new com.baidu.tieba.e.a();
                this.eLu.setData(list.get(0));
                this.eLr.getView().setVisibility(0);
                this.eLr.a(this.eLu);
            }
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 2) {
                this.eLv = new com.baidu.tieba.e.b();
                this.eLv.setData(list.get(1));
                this.eLs.getView().setVisibility(0);
                this.eLs.a(this.eLv);
                this.eLs.oK(8);
            }
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 3) {
                this.eLw = new com.baidu.tieba.e.b();
                this.eLw.setData(list.get(2));
                this.eLt.getView().setVisibility(0);
                this.eLt.a(this.eLw);
                this.eLt.oK(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13047").O("obj_locate", 6).bS("fid", this.mForumId));
        if (view == this.eLr.getView()) {
            if (this.eLu != null) {
                if (this.eLz != null) {
                    this.eLz.b(view, this.eLu);
                }
                Q(this.eLu.agI());
            }
        } else if (view == this.eLs.getView()) {
            if (this.eLv != null) {
                if (this.eLz != null) {
                    this.eLz.b(view, this.eLv);
                }
                Q(this.eLv.agI());
            }
        } else if (view == this.eLt.getView() && this.eLw != null) {
            if (this.eLz != null) {
                this.eLz.b(view, this.eLw);
            }
            Q(this.eLw.agI());
        }
    }

    private void Q(bh bhVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bhVar, null, n.ait(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bhVar.getFid()));
        createFromThreadCfg.setForumName(bhVar.aiL());
        createFromThreadCfg.setStartFrom(0);
        n.uz(bhVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.eLz = aVar;
    }
}
