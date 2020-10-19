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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes22.dex */
public class g extends b<com.baidu.tieba.e.d> {
    private LinearLayout hEg;
    private TextView hEh;
    private LinearLayout hEi;
    private e hEj;
    private f hEk;
    private f hEl;
    private com.baidu.tieba.e.a hEm;
    private com.baidu.tieba.e.b hEn;
    private com.baidu.tieba.e.b hEo;
    private View hEp;
    private View hEq;
    private a hEr;
    private String mForumId;

    /* loaded from: classes22.dex */
    public interface a {
        void b(View view, com.baidu.tieba.card.data.b bVar);
    }

    public g(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        this.mForumId = str;
        init(getView());
    }

    private void init(View view) {
        this.hEg = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.hEh = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.hEi = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.hEp = view.findViewById(R.id.divider_line_1);
        this.hEq = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.hEj == null) {
            this.hEj = new e(this.mTbPageContext, null, null);
        }
        this.hEj.x(0, 0, 0, 0);
        this.hEj.ww(8);
        this.hEj.wx(8);
        if (this.hEj.getView().getParent() != null) {
            ((ViewGroup) this.hEj.getView().getParent()).removeView(this.hEj.getView());
        }
        this.hEj.getView().setOnClickListener(this);
        this.hEj.getView().setVisibility(8);
        this.hEi.addView(this.hEj.getView());
        if (this.hEk == null) {
            this.hEk = new f(this.mTbPageContext);
        }
        this.hEk.wx(8);
        this.hEk.y(0, dimensionPixelSize, 0, 0);
        if (this.hEk.getView().getParent() != null) {
            ((ViewGroup) this.hEk.getView().getParent()).removeView(this.hEk.getView());
        }
        this.hEk.getView().setOnClickListener(this);
        this.hEk.getView().setVisibility(8);
        this.hEi.addView(this.hEk.getView());
        if (this.hEl == null) {
            this.hEl = new f(this.mTbPageContext);
        }
        this.hEl.wx(8);
        this.hEl.y(0, dimensionPixelSize, 0, 0);
        if (this.hEl.getView().getParent() != null) {
            ((ViewGroup) this.hEl.getView().getParent()).removeView(this.hEl.getView());
        }
        this.hEl.getView().setOnClickListener(this);
        this.hEl.getView().setVisibility(8);
        this.hEi.addView(this.hEl.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        ap.setViewTextColor(this.hEh, R.color.cp_cont_f, 1);
        ap.setBackgroundResource(this.hEp, R.color.cp_bg_line_e);
        ap.setBackgroundResource(this.hEq, R.color.cp_bg_line_e);
        if (this.hEj != null) {
            this.hEj.onChangeSkinType(tbPageContext, i);
        }
        if (this.hEk != null) {
            this.hEk.onChangeSkinType(tbPageContext, i);
        }
        if (this.hEl != null) {
            this.hEl.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.ckd() != null) {
            if (!TextUtils.isEmpty(dVar.ckd().title)) {
                this.hEh.setText(dVar.ckd().title);
            }
            List<bw> list = dVar.ckd().sub_nodes;
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 1) {
                this.hEm = new com.baidu.tieba.e.a();
                this.hEm.setData(list.get(0));
                this.hEj.getView().setVisibility(0);
                this.hEj.a(this.hEm);
            }
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 2) {
                this.hEn = new com.baidu.tieba.e.b();
                this.hEn.setData(list.get(1));
                this.hEk.getView().setVisibility(0);
                this.hEk.a(this.hEn);
                this.hEk.wy(8);
            }
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 3) {
                this.hEo = new com.baidu.tieba.e.b();
                this.hEo.setData(list.get(2));
                this.hEl.getView().setVisibility(0);
                this.hEl.a(this.hEo);
                this.hEl.wy(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new aq("c13047").aj("obj_locate", 6).dK("fid", this.mForumId));
        if (view == this.hEj.getView()) {
            if (this.hEm != null) {
                if (this.hEr != null) {
                    this.hEr.b(view, this.hEm);
                }
                X(this.hEm.bfG());
            }
        } else if (view == this.hEk.getView()) {
            if (this.hEn != null) {
                if (this.hEr != null) {
                    this.hEr.b(view, this.hEn);
                }
                X(this.hEn.bfG());
            }
        } else if (view == this.hEl.getView() && this.hEo != null) {
            if (this.hEr != null) {
                this.hEr.b(view, this.hEo);
            }
            X(this.hEo.bfG());
        }
    }

    private void X(bw bwVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bwVar, null, m.bhT(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bwVar.getFid()));
        createFromThreadCfg.setForumName(bwVar.bil());
        createFromThreadCfg.setStartFrom(0);
        m.Ij(bwVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.hEr = aVar;
    }
}
