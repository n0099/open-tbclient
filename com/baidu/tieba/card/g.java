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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes16.dex */
public class g extends b<com.baidu.tieba.e.d> {
    private LinearLayout gVm;
    private TextView gVn;
    private LinearLayout gVo;
    private e gVp;
    private f gVq;
    private f gVr;
    private com.baidu.tieba.e.a gVs;
    private com.baidu.tieba.e.b gVt;
    private com.baidu.tieba.e.b gVu;
    private View gVv;
    private View gVw;
    private a gVx;
    private String mForumId;

    /* loaded from: classes16.dex */
    public interface a {
        void b(View view, com.baidu.tieba.card.data.b bVar);
    }

    public g(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        this.mForumId = str;
        init(getView());
    }

    private void init(View view) {
        this.gVm = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.gVn = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.gVo = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.gVv = view.findViewById(R.id.divider_line_1);
        this.gVw = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.gVp == null) {
            this.gVp = new e(this.mTbPageContext, null, null);
        }
        this.gVp.x(0, 0, 0, 0);
        this.gVp.tc(8);
        this.gVp.td(8);
        if (this.gVp.getView().getParent() != null) {
            ((ViewGroup) this.gVp.getView().getParent()).removeView(this.gVp.getView());
        }
        this.gVp.getView().setOnClickListener(this);
        this.gVp.getView().setVisibility(8);
        this.gVo.addView(this.gVp.getView());
        if (this.gVq == null) {
            this.gVq = new f(this.mTbPageContext);
        }
        this.gVq.td(8);
        this.gVq.y(0, dimensionPixelSize, 0, 0);
        if (this.gVq.getView().getParent() != null) {
            ((ViewGroup) this.gVq.getView().getParent()).removeView(this.gVq.getView());
        }
        this.gVq.getView().setOnClickListener(this);
        this.gVq.getView().setVisibility(8);
        this.gVo.addView(this.gVq.getView());
        if (this.gVr == null) {
            this.gVr = new f(this.mTbPageContext);
        }
        this.gVr.td(8);
        this.gVr.y(0, dimensionPixelSize, 0, 0);
        if (this.gVr.getView().getParent() != null) {
            ((ViewGroup) this.gVr.getView().getParent()).removeView(this.gVr.getView());
        }
        this.gVr.getView().setOnClickListener(this);
        this.gVr.getView().setVisibility(8);
        this.gVo.addView(this.gVr.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        ao.setViewTextColor(this.gVn, R.color.cp_cont_f, 1);
        ao.setBackgroundResource(this.gVv, R.color.cp_bg_line_e);
        ao.setBackgroundResource(this.gVw, R.color.cp_bg_line_e);
        if (this.gVp != null) {
            this.gVp.onChangeSkinType(tbPageContext, i);
        }
        if (this.gVq != null) {
            this.gVq.onChangeSkinType(tbPageContext, i);
        }
        if (this.gVr != null) {
            this.gVr.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.bTf() != null) {
            if (!TextUtils.isEmpty(dVar.bTf().title)) {
                this.gVn.setText(dVar.bTf().title);
            }
            List<bv> list = dVar.bTf().sub_nodes;
            if (com.baidu.tbadk.core.util.x.getCount(list) >= 1) {
                this.gVs = new com.baidu.tieba.e.a();
                this.gVs.setData(list.get(0));
                this.gVp.getView().setVisibility(0);
                this.gVp.a(this.gVs);
            }
            if (com.baidu.tbadk.core.util.x.getCount(list) >= 2) {
                this.gVt = new com.baidu.tieba.e.b();
                this.gVt.setData(list.get(1));
                this.gVq.getView().setVisibility(0);
                this.gVq.a(this.gVt);
                this.gVq.te(8);
            }
            if (com.baidu.tbadk.core.util.x.getCount(list) >= 3) {
                this.gVu = new com.baidu.tieba.e.b();
                this.gVu.setData(list.get(2));
                this.gVr.getView().setVisibility(0);
                this.gVr.a(this.gVu);
                this.gVr.te(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new ap("c13047").ah("obj_locate", 6).dn("fid", this.mForumId));
        if (view == this.gVp.getView()) {
            if (this.gVs != null) {
                if (this.gVx != null) {
                    this.gVx.b(view, this.gVs);
                }
                W(this.gVs.aTN());
            }
        } else if (view == this.gVq.getView()) {
            if (this.gVt != null) {
                if (this.gVx != null) {
                    this.gVx.b(view, this.gVt);
                }
                W(this.gVt.aTN());
            }
        } else if (view == this.gVr.getView() && this.gVu != null) {
            if (this.gVx != null) {
                this.gVx.b(view, this.gVu);
            }
            W(this.gVu.aTN());
        }
    }

    private void W(bv bvVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bvVar, null, m.aVX(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bvVar.getFid()));
        createFromThreadCfg.setForumName(bvVar.aWp());
        createFromThreadCfg.setStartFrom(0);
        m.Ez(bvVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.gVx = aVar;
    }
}
