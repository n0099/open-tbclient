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
    private LinearLayout evR;
    private TextView evS;
    private LinearLayout evT;
    private d evU;
    private e evV;
    private e evW;
    private com.baidu.tieba.e.a evX;
    private com.baidu.tieba.e.b evY;
    private com.baidu.tieba.e.b evZ;
    private View ewa;
    private View ewb;
    private a ewc;
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
        this.evR = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.evS = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.evT = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.ewa = view.findViewById(R.id.divider_line_1);
        this.ewb = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.evU == null) {
            this.evU = new d(this.mTbPageContext, null, null);
        }
        this.evU.q(0, 0, 0, 0);
        this.evU.pk(8);
        this.evU.pl(8);
        if (this.evU.getView().getParent() != null) {
            ((ViewGroup) this.evU.getView().getParent()).removeView(this.evU.getView());
        }
        this.evU.getView().setOnClickListener(this);
        this.evU.getView().setVisibility(8);
        this.evT.addView(this.evU.getView());
        if (this.evV == null) {
            this.evV = new e(this.mTbPageContext);
        }
        this.evV.pl(8);
        this.evV.r(0, dimensionPixelSize, 0, 0);
        if (this.evV.getView().getParent() != null) {
            ((ViewGroup) this.evV.getView().getParent()).removeView(this.evV.getView());
        }
        this.evV.getView().setOnClickListener(this);
        this.evV.getView().setVisibility(8);
        this.evT.addView(this.evV.getView());
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
        this.evT.addView(this.evW.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        al.k(getView(), R.color.cp_bg_line_d);
        al.f(this.evS, R.color.cp_cont_f, 1);
        al.k(this.ewa, R.color.cp_bg_line_e);
        al.k(this.ewb, R.color.cp_bg_line_e);
        if (this.evU != null) {
            this.evU.onChangeSkinType(tbPageContext, i);
        }
        if (this.evV != null) {
            this.evV.onChangeSkinType(tbPageContext, i);
        }
        if (this.evW != null) {
            this.evW.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.bbU() != null) {
            if (!TextUtils.isEmpty(dVar.bbU().title)) {
                this.evS.setText(dVar.bbU().title);
            }
            List<bg> list = dVar.bbU().sub_nodes;
            if (com.baidu.tbadk.core.util.v.Z(list) >= 1) {
                this.evX = new com.baidu.tieba.e.a();
                this.evX.setData(list.get(0));
                this.evU.getView().setVisibility(0);
                this.evU.a(this.evX);
            }
            if (com.baidu.tbadk.core.util.v.Z(list) >= 2) {
                this.evY = new com.baidu.tieba.e.b();
                this.evY.setData(list.get(1));
                this.evV.getView().setVisibility(0);
                this.evV.a(this.evY);
                this.evV.pm(8);
            }
            if (com.baidu.tbadk.core.util.v.Z(list) >= 3) {
                this.evZ = new com.baidu.tieba.e.b();
                this.evZ.setData(list.get(2));
                this.evW.getView().setVisibility(0);
                this.evW.a(this.evZ);
                this.evW.pm(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new am("c13047").P("obj_locate", 6).bT("fid", this.mForumId));
        if (view == this.evU.getView()) {
            if (this.evX != null) {
                if (this.ewc != null) {
                    this.ewc.b(view, this.evX);
                }
                Q(this.evX.abv());
            }
        } else if (view == this.evV.getView()) {
            if (this.evY != null) {
                if (this.ewc != null) {
                    this.ewc.b(view, this.evY);
                }
                Q(this.evY.abv());
            }
        } else if (view == this.evW.getView() && this.evZ != null) {
            if (this.ewc != null) {
                this.ewc.b(view, this.evZ);
            }
            Q(this.evZ.abv());
        }
    }

    private void Q(bg bgVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bgVar, null, n.adi(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bgVar.getFid()));
        createFromThreadCfg.setForumName(bgVar.adA());
        createFromThreadCfg.setStartFrom(0);
        n.uS(bgVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.ewc = aVar;
    }
}
