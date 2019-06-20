package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.e.d> {
    private LinearLayout evS;
    private TextView evT;
    private LinearLayout evU;
    private d evV;
    private e evW;
    private e evX;
    private com.baidu.tieba.e.a evY;
    private com.baidu.tieba.e.b evZ;
    private com.baidu.tieba.e.b ewa;
    private View ewb;
    private View ewc;
    private a ewd;
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
        this.evS = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.evT = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.evU = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.ewb = view.findViewById(R.id.divider_line_1);
        this.ewc = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.evV == null) {
            this.evV = new d(this.mTbPageContext, null, null);
        }
        this.evV.q(0, 0, 0, 0);
        this.evV.pk(8);
        this.evV.pl(8);
        if (this.evV.getView().getParent() != null) {
            ((ViewGroup) this.evV.getView().getParent()).removeView(this.evV.getView());
        }
        this.evV.getView().setOnClickListener(this);
        this.evV.getView().setVisibility(8);
        this.evU.addView(this.evV.getView());
        if (this.evW == null) {
            this.evW = new e(this.mTbPageContext);
        }
        this.evW.pl(8);
        this.evW.r(0, dimensionPixelSize, 0, 0);
        if (this.evW.getView().getParent() != null) {
            ((ViewGroup) this.evW.getView().getParent()).removeView(this.evW.getView());
        }
        this.evW.getView().setOnClickListener(this);
        this.evW.getView().setVisibility(8);
        this.evU.addView(this.evW.getView());
        if (this.evX == null) {
            this.evX = new e(this.mTbPageContext);
        }
        this.evX.pl(8);
        this.evX.r(0, dimensionPixelSize, 0, 0);
        if (this.evX.getView().getParent() != null) {
            ((ViewGroup) this.evX.getView().getParent()).removeView(this.evX.getView());
        }
        this.evX.getView().setOnClickListener(this);
        this.evX.getView().setVisibility(8);
        this.evU.addView(this.evX.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        al.k(getView(), R.color.cp_bg_line_d);
        al.f(this.evT, R.color.cp_cont_f, 1);
        al.k(this.ewb, R.color.cp_bg_line_e);
        al.k(this.ewc, R.color.cp_bg_line_e);
        if (this.evV != null) {
            this.evV.onChangeSkinType(tbPageContext, i);
        }
        if (this.evW != null) {
            this.evW.onChangeSkinType(tbPageContext, i);
        }
        if (this.evX != null) {
            this.evX.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.bbX() != null) {
            if (!TextUtils.isEmpty(dVar.bbX().title)) {
                this.evT.setText(dVar.bbX().title);
            }
            List<bg> list = dVar.bbX().sub_nodes;
            if (com.baidu.tbadk.core.util.v.Z(list) >= 1) {
                this.evY = new com.baidu.tieba.e.a();
                this.evY.setData(list.get(0));
                this.evV.getView().setVisibility(0);
                this.evV.a(this.evY);
            }
            if (com.baidu.tbadk.core.util.v.Z(list) >= 2) {
                this.evZ = new com.baidu.tieba.e.b();
                this.evZ.setData(list.get(1));
                this.evW.getView().setVisibility(0);
                this.evW.a(this.evZ);
                this.evW.pm(8);
            }
            if (com.baidu.tbadk.core.util.v.Z(list) >= 3) {
                this.ewa = new com.baidu.tieba.e.b();
                this.ewa.setData(list.get(2));
                this.evX.getView().setVisibility(0);
                this.evX.a(this.ewa);
                this.evX.pm(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new am("c13047").P("obj_locate", 6).bT("fid", this.mForumId));
        if (view == this.evV.getView()) {
            if (this.evY != null) {
                if (this.ewd != null) {
                    this.ewd.b(view, this.evY);
                }
                Q(this.evY.abv());
            }
        } else if (view == this.evW.getView()) {
            if (this.evZ != null) {
                if (this.ewd != null) {
                    this.ewd.b(view, this.evZ);
                }
                Q(this.evZ.abv());
            }
        } else if (view == this.evX.getView() && this.ewa != null) {
            if (this.ewd != null) {
                this.ewd.b(view, this.ewa);
            }
            Q(this.ewa.abv());
        }
    }

    private void Q(bg bgVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bgVar, null, n.adi(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bgVar.getFid()));
        createFromThreadCfg.setForumName(bgVar.adA());
        createFromThreadCfg.setStartFrom(0);
        n.uR(bgVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.ewd = aVar;
    }
}
