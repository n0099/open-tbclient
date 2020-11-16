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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes21.dex */
public class g extends b<com.baidu.tieba.f.d> {
    private LinearLayout hWZ;
    private TextView hXa;
    private LinearLayout hXb;
    private e hXc;
    private f hXd;
    private f hXe;
    private com.baidu.tieba.f.a hXf;
    private com.baidu.tieba.f.b hXg;
    private com.baidu.tieba.f.b hXh;
    private View hXi;
    private View hXj;
    private a hXk;
    private String mForumId;

    /* loaded from: classes21.dex */
    public interface a {
        void b(View view, BaseCardInfo baseCardInfo);
    }

    public g(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        this.mForumId = str;
        init(getView());
    }

    private void init(View view) {
        this.hWZ = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.hXa = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.hXb = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.hXi = view.findViewById(R.id.divider_line_1);
        this.hXj = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.hXc == null) {
            this.hXc = new e(this.mTbPageContext, null, null);
        }
        this.hXc.z(0, 0, 0, 0);
        this.hXc.xA(8);
        this.hXc.xB(8);
        if (this.hXc.getView().getParent() != null) {
            ((ViewGroup) this.hXc.getView().getParent()).removeView(this.hXc.getView());
        }
        this.hXc.getView().setOnClickListener(this);
        this.hXc.getView().setVisibility(8);
        this.hXb.addView(this.hXc.getView());
        if (this.hXd == null) {
            this.hXd = new f(this.mTbPageContext);
        }
        this.hXd.xB(8);
        this.hXd.A(0, dimensionPixelSize, 0, 0);
        if (this.hXd.getView().getParent() != null) {
            ((ViewGroup) this.hXd.getView().getParent()).removeView(this.hXd.getView());
        }
        this.hXd.getView().setOnClickListener(this);
        this.hXd.getView().setVisibility(8);
        this.hXb.addView(this.hXd.getView());
        if (this.hXe == null) {
            this.hXe = new f(this.mTbPageContext);
        }
        this.hXe.xB(8);
        this.hXe.A(0, dimensionPixelSize, 0, 0);
        if (this.hXe.getView().getParent() != null) {
            ((ViewGroup) this.hXe.getView().getParent()).removeView(this.hXe.getView());
        }
        this.hXe.getView().setOnClickListener(this);
        this.hXe.getView().setVisibility(8);
        this.hXb.addView(this.hXe.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(getView(), R.color.CAM_X0201);
        ap.setViewTextColor(this.hXa, R.color.CAM_X0106, 1);
        ap.setBackgroundResource(this.hXi, R.color.CAM_X0205);
        ap.setBackgroundResource(this.hXj, R.color.CAM_X0205);
        if (this.hXc != null) {
            this.hXc.onChangeSkinType(tbPageContext, i);
        }
        if (this.hXd != null) {
            this.hXd.onChangeSkinType(tbPageContext, i);
        }
        if (this.hXe != null) {
            this.hXe.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.f.d dVar) {
        if (dVar != null && dVar.cpo() != null) {
            if (!TextUtils.isEmpty(dVar.cpo().title)) {
                this.hXa.setText(dVar.cpo().title);
            }
            List<bx> list = dVar.cpo().sub_nodes;
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 1) {
                this.hXf = new com.baidu.tieba.f.a();
                this.hXf.setData(list.get(0));
                this.hXc.getView().setVisibility(0);
                this.hXc.a(this.hXf);
            }
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 2) {
                this.hXg = new com.baidu.tieba.f.b();
                this.hXg.setData(list.get(1));
                this.hXd.getView().setVisibility(0);
                this.hXd.a(this.hXg);
                this.hXd.xC(8);
            }
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 3) {
                this.hXh = new com.baidu.tieba.f.b();
                this.hXh.setData(list.get(2));
                this.hXe.getView().setVisibility(0);
                this.hXe.a(this.hXh);
                this.hXe.xC(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new ar("c13047").ak("obj_locate", 6).dR("fid", this.mForumId));
        if (view == this.hXc.getView()) {
            if (this.hXf != null) {
                if (this.hXk != null) {
                    this.hXk.b(view, this.hXf);
                }
                Z(this.hXf.bjd());
            }
        } else if (view == this.hXd.getView()) {
            if (this.hXg != null) {
                if (this.hXk != null) {
                    this.hXk.b(view, this.hXg);
                }
                Z(this.hXg.bjd());
            }
        } else if (view == this.hXe.getView() && this.hXh != null) {
            if (this.hXk != null) {
                this.hXk.b(view, this.hXh);
            }
            Z(this.hXh.bjd());
        }
    }

    private void Z(bx bxVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bxVar, null, n.blo(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bxVar.getFid()));
        createFromThreadCfg.setForumName(bxVar.blG());
        createFromThreadCfg.setStartFrom(0);
        n.IA(bxVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.hXk = aVar;
    }
}
