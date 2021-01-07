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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class f extends b<com.baidu.tieba.e.d> {
    private com.baidu.tieba.e.b iuA;
    private com.baidu.tieba.e.b iuB;
    private View iuC;
    private View iuD;
    private a iuE;
    private LinearLayout iut;
    private TextView iuu;
    private LinearLayout iuv;
    private d iuw;
    private e iux;
    private e iuy;
    private com.baidu.tieba.e.a iuz;
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
        this.iut = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.iuu = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.iuv = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.iuC = view.findViewById(R.id.divider_line_1);
        this.iuD = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.iuw == null) {
            this.iuw = new d(this.mTbPageContext, null, null);
        }
        this.iuw.E(0, 0, 0, 0);
        this.iuw.yu(8);
        this.iuw.yv(8);
        if (this.iuw.getView().getParent() != null) {
            ((ViewGroup) this.iuw.getView().getParent()).removeView(this.iuw.getView());
        }
        this.iuw.getView().setOnClickListener(this);
        this.iuw.getView().setVisibility(8);
        this.iuv.addView(this.iuw.getView());
        if (this.iux == null) {
            this.iux = new e(this.mTbPageContext);
        }
        this.iux.yv(8);
        this.iux.F(0, dimensionPixelSize, 0, 0);
        if (this.iux.getView().getParent() != null) {
            ((ViewGroup) this.iux.getView().getParent()).removeView(this.iux.getView());
        }
        this.iux.getView().setOnClickListener(this);
        this.iux.getView().setVisibility(8);
        this.iuv.addView(this.iux.getView());
        if (this.iuy == null) {
            this.iuy = new e(this.mTbPageContext);
        }
        this.iuy.yv(8);
        this.iuy.F(0, dimensionPixelSize, 0, 0);
        if (this.iuy.getView().getParent() != null) {
            ((ViewGroup) this.iuy.getView().getParent()).removeView(this.iuy.getView());
        }
        this.iuy.getView().setOnClickListener(this);
        this.iuy.getView().setVisibility(8);
        this.iuv.addView(this.iuy.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundResource(getView(), R.color.CAM_X0201);
        ao.setViewTextColor(this.iuu, R.color.CAM_X0106, 1);
        ao.setBackgroundResource(this.iuC, R.color.CAM_X0205);
        ao.setBackgroundResource(this.iuD, R.color.CAM_X0205);
        if (this.iuw != null) {
            this.iuw.onChangeSkinType(tbPageContext, i);
        }
        if (this.iux != null) {
            this.iux.onChangeSkinType(tbPageContext, i);
        }
        if (this.iuy != null) {
            this.iuy.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.cwx() != null) {
            if (!TextUtils.isEmpty(dVar.cwx().title)) {
                this.iuu.setText(dVar.cwx().title);
            }
            List<bz> list = dVar.cwx().sub_nodes;
            if (com.baidu.tbadk.core.util.x.getCount(list) >= 1) {
                this.iuz = new com.baidu.tieba.e.a();
                this.iuz.setData(list.get(0));
                this.iuw.getView().setVisibility(0);
                this.iuw.a(this.iuz);
            }
            if (com.baidu.tbadk.core.util.x.getCount(list) >= 2) {
                this.iuA = new com.baidu.tieba.e.b();
                this.iuA.setData(list.get(1));
                this.iux.getView().setVisibility(0);
                this.iux.a(this.iuA);
                this.iux.yw(8);
            }
            if (com.baidu.tbadk.core.util.x.getCount(list) >= 3) {
                this.iuB = new com.baidu.tieba.e.b();
                this.iuB.setData(list.get(2));
                this.iuy.getView().setVisibility(0);
                this.iuy.a(this.iuB);
                this.iuy.yw(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new aq("c13047").an("obj_locate", 6).dX("fid", this.mForumId));
        if (view == this.iuw.getView()) {
            if (this.iuz != null) {
                if (this.iuE != null) {
                    this.iuE.b(view, this.iuz);
                }
                Z(this.iuz.boP());
            }
        } else if (view == this.iux.getView()) {
            if (this.iuA != null) {
                if (this.iuE != null) {
                    this.iuE.b(view, this.iuA);
                }
                Z(this.iuA.boP());
            }
        } else if (view == this.iuy.getView() && this.iuB != null) {
            if (this.iuE != null) {
                this.iuE.b(view, this.iuB);
            }
            Z(this.iuB.boP());
        }
    }

    private void Z(bz bzVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bzVar, null, m.brd(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bzVar.getFid()));
        createFromThreadCfg.setForumName(bzVar.brv());
        createFromThreadCfg.setStartFrom(0);
        m.Jn(bzVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.iuE = aVar;
    }
}
