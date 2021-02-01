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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class f extends b<com.baidu.tieba.e.d> {
    private View ivA;
    private a ivB;
    private LinearLayout ivq;
    private TextView ivr;
    private LinearLayout ivs;
    private d ivt;
    private e ivu;
    private e ivv;
    private com.baidu.tieba.e.a ivw;
    private com.baidu.tieba.e.b ivx;
    private com.baidu.tieba.e.b ivy;
    private View ivz;
    private String mForumId;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, BaseCardInfo baseCardInfo);
    }

    public f(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        this.mForumId = str;
        init(getView());
    }

    private void init(View view) {
        this.ivq = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.ivr = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.ivs = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.ivz = view.findViewById(R.id.divider_line_1);
        this.ivA = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.ivt == null) {
            this.ivt = new d(this.mTbPageContext, null, null);
        }
        this.ivt.E(0, 0, 0, 0);
        this.ivt.wX(8);
        this.ivt.wY(8);
        if (this.ivt.getView().getParent() != null) {
            ((ViewGroup) this.ivt.getView().getParent()).removeView(this.ivt.getView());
        }
        this.ivt.getView().setOnClickListener(this);
        this.ivt.getView().setVisibility(8);
        this.ivs.addView(this.ivt.getView());
        if (this.ivu == null) {
            this.ivu = new e(this.mTbPageContext);
        }
        this.ivu.wY(8);
        this.ivu.F(0, dimensionPixelSize, 0, 0);
        if (this.ivu.getView().getParent() != null) {
            ((ViewGroup) this.ivu.getView().getParent()).removeView(this.ivu.getView());
        }
        this.ivu.getView().setOnClickListener(this);
        this.ivu.getView().setVisibility(8);
        this.ivs.addView(this.ivu.getView());
        if (this.ivv == null) {
            this.ivv = new e(this.mTbPageContext);
        }
        this.ivv.wY(8);
        this.ivv.F(0, dimensionPixelSize, 0, 0);
        if (this.ivv.getView().getParent() != null) {
            ((ViewGroup) this.ivv.getView().getParent()).removeView(this.ivv.getView());
        }
        this.ivv.getView().setOnClickListener(this);
        this.ivv.getView().setVisibility(8);
        this.ivs.addView(this.ivv.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(getView(), R.color.CAM_X0201);
        ap.setViewTextColor(this.ivr, R.color.CAM_X0106, 1);
        ap.setBackgroundResource(this.ivz, R.color.CAM_X0205);
        ap.setBackgroundResource(this.ivA, R.color.CAM_X0205);
        if (this.ivt != null) {
            this.ivt.onChangeSkinType(tbPageContext, i);
        }
        if (this.ivu != null) {
            this.ivu.onChangeSkinType(tbPageContext, i);
        }
        if (this.ivv != null) {
            this.ivv.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.ctR() != null) {
            if (!TextUtils.isEmpty(dVar.ctR().title)) {
                this.ivr.setText(dVar.ctR().title);
            }
            List<cb> list = dVar.ctR().sub_nodes;
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 1) {
                this.ivw = new com.baidu.tieba.e.a();
                this.ivw.setData(list.get(0));
                this.ivt.getView().setVisibility(0);
                this.ivt.a(this.ivw);
            }
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 2) {
                this.ivx = new com.baidu.tieba.e.b();
                this.ivx.setData(list.get(1));
                this.ivu.getView().setVisibility(0);
                this.ivu.a(this.ivx);
                this.ivu.wZ(8);
            }
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 3) {
                this.ivy = new com.baidu.tieba.e.b();
                this.ivy.setData(list.get(2));
                this.ivv.getView().setVisibility(0);
                this.ivv.a(this.ivy);
                this.ivv.wZ(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new ar("c13047").ap("obj_locate", 6).dR("fid", this.mForumId));
        if (view == this.ivt.getView()) {
            if (this.ivw != null) {
                if (this.ivB != null) {
                    this.ivB.b(view, this.ivw);
                }
                aa(this.ivw.bln());
            }
        } else if (view == this.ivu.getView()) {
            if (this.ivx != null) {
                if (this.ivB != null) {
                    this.ivB.b(view, this.ivx);
                }
                aa(this.ivx.bln());
            }
        } else if (view == this.ivv.getView() && this.ivy != null) {
            if (this.ivB != null) {
                this.ivB.b(view, this.ivy);
            }
            aa(this.ivy.bln());
        }
    }

    private void aa(cb cbVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(cbVar, null, m.bnC(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(cbVar.getFid()));
        createFromThreadCfg.setForumName(cbVar.bnU());
        createFromThreadCfg.setStartFrom(0);
        m.IM(cbVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.ivB = aVar;
    }
}
