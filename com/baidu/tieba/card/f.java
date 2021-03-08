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
    private LinearLayout ixn;
    private TextView ixo;
    private LinearLayout ixp;
    private d ixq;
    private e ixr;
    private e ixs;
    private com.baidu.tieba.e.a ixt;
    private com.baidu.tieba.e.b ixu;
    private com.baidu.tieba.e.b ixv;
    private View ixw;
    private View ixx;
    private a ixy;
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
        this.ixn = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.ixo = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.ixp = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.ixw = view.findViewById(R.id.divider_line_1);
        this.ixx = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.ixq == null) {
            this.ixq = new d(this.mTbPageContext, null, null);
        }
        this.ixq.E(0, 0, 0, 0);
        this.ixq.wY(8);
        this.ixq.wZ(8);
        if (this.ixq.getView().getParent() != null) {
            ((ViewGroup) this.ixq.getView().getParent()).removeView(this.ixq.getView());
        }
        this.ixq.getView().setOnClickListener(this);
        this.ixq.getView().setVisibility(8);
        this.ixp.addView(this.ixq.getView());
        if (this.ixr == null) {
            this.ixr = new e(this.mTbPageContext);
        }
        this.ixr.wZ(8);
        this.ixr.F(0, dimensionPixelSize, 0, 0);
        if (this.ixr.getView().getParent() != null) {
            ((ViewGroup) this.ixr.getView().getParent()).removeView(this.ixr.getView());
        }
        this.ixr.getView().setOnClickListener(this);
        this.ixr.getView().setVisibility(8);
        this.ixp.addView(this.ixr.getView());
        if (this.ixs == null) {
            this.ixs = new e(this.mTbPageContext);
        }
        this.ixs.wZ(8);
        this.ixs.F(0, dimensionPixelSize, 0, 0);
        if (this.ixs.getView().getParent() != null) {
            ((ViewGroup) this.ixs.getView().getParent()).removeView(this.ixs.getView());
        }
        this.ixs.getView().setOnClickListener(this);
        this.ixs.getView().setVisibility(8);
        this.ixp.addView(this.ixs.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(getView(), R.color.CAM_X0201);
        ap.setViewTextColor(this.ixo, R.color.CAM_X0106, 1);
        ap.setBackgroundResource(this.ixw, R.color.CAM_X0205);
        ap.setBackgroundResource(this.ixx, R.color.CAM_X0205);
        if (this.ixq != null) {
            this.ixq.onChangeSkinType(tbPageContext, i);
        }
        if (this.ixr != null) {
            this.ixr.onChangeSkinType(tbPageContext, i);
        }
        if (this.ixs != null) {
            this.ixs.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.cue() != null) {
            if (!TextUtils.isEmpty(dVar.cue().title)) {
                this.ixo.setText(dVar.cue().title);
            }
            List<cb> list = dVar.cue().sub_nodes;
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 1) {
                this.ixt = new com.baidu.tieba.e.a();
                this.ixt.setData(list.get(0));
                this.ixq.getView().setVisibility(0);
                this.ixq.a(this.ixt);
            }
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 2) {
                this.ixu = new com.baidu.tieba.e.b();
                this.ixu.setData(list.get(1));
                this.ixr.getView().setVisibility(0);
                this.ixr.a(this.ixu);
                this.ixr.xa(8);
            }
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 3) {
                this.ixv = new com.baidu.tieba.e.b();
                this.ixv.setData(list.get(2));
                this.ixs.getView().setVisibility(0);
                this.ixs.a(this.ixv);
                this.ixs.xa(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new ar("c13047").aq("obj_locate", 6).dR("fid", this.mForumId));
        if (view == this.ixq.getView()) {
            if (this.ixt != null) {
                if (this.ixy != null) {
                    this.ixy.b(view, this.ixt);
                }
                aa(this.ixt.blp());
            }
        } else if (view == this.ixr.getView()) {
            if (this.ixu != null) {
                if (this.ixy != null) {
                    this.ixy.b(view, this.ixu);
                }
                aa(this.ixu.blp());
            }
        } else if (view == this.ixs.getView() && this.ixv != null) {
            if (this.ixy != null) {
                this.ixy.b(view, this.ixv);
            }
            aa(this.ixv.blp());
        }
    }

    private void aa(cb cbVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(cbVar, null, m.bnE(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(cbVar.getFid()));
        createFromThreadCfg.setForumName(cbVar.bnW());
        createFromThreadCfg.setStartFrom(0);
        m.IW(cbVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.ixy = aVar;
    }
}
