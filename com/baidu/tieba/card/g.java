package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.e.d> {
    private LinearLayout cuK;
    private TextView cuL;
    private LinearLayout cuM;
    private e cuN;
    private f cuO;
    private f cuP;
    private com.baidu.tieba.e.a cuQ;
    private com.baidu.tieba.e.b cuR;
    private com.baidu.tieba.e.b cuS;
    private View cuT;
    private View cuU;
    private a cuV;
    private String mForumId;

    /* loaded from: classes3.dex */
    public interface a {
        void b(View view, com.baidu.tieba.card.data.b bVar);
    }

    public g(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        this.mForumId = str;
        init(getView());
    }

    private void init(View view) {
        this.cuK = (LinearLayout) view.findViewById(d.g.card_frs_game_head_line_layout);
        this.cuL = (TextView) view.findViewById(d.g.frs_game_head_line_title);
        this.cuM = (LinearLayout) view.findViewById(d.g.frs_game_head_line_container);
        this.cuT = view.findViewById(d.g.divider_line_1);
        this.cuU = view.findViewById(d.g.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.tbds44);
        if (this.cuN == null) {
            this.cuN = new e(this.mTbPageContext, null, null);
        }
        this.cuN.m(0, 0, 0, 0);
        this.cuN.iF(8);
        this.cuN.iG(8);
        if (this.cuN.getView().getParent() != null) {
            ((ViewGroup) this.cuN.getView().getParent()).removeView(this.cuN.getView());
        }
        this.cuN.getView().setOnClickListener(this);
        this.cuN.getView().setVisibility(8);
        this.cuM.addView(this.cuN.getView());
        if (this.cuO == null) {
            this.cuO = new f(this.mTbPageContext);
        }
        this.cuO.iG(8);
        this.cuO.n(0, dimensionPixelSize, 0, 0);
        if (this.cuO.getView().getParent() != null) {
            ((ViewGroup) this.cuO.getView().getParent()).removeView(this.cuO.getView());
        }
        this.cuO.getView().setOnClickListener(this);
        this.cuO.getView().setVisibility(8);
        this.cuM.addView(this.cuO.getView());
        if (this.cuP == null) {
            this.cuP = new f(this.mTbPageContext);
        }
        this.cuP.iG(8);
        this.cuP.n(0, dimensionPixelSize, 0, 0);
        if (this.cuP.getView().getParent() != null) {
            ((ViewGroup) this.cuP.getView().getParent()).removeView(this.cuP.getView());
        }
        this.cuP.getView().setOnClickListener(this);
        this.cuP.getView().setVisibility(8);
        this.cuM.addView(this.cuP.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        am.i(getView(), d.C0142d.cp_bg_line_d);
        am.c(this.cuL, d.C0142d.cp_cont_f, 1);
        am.i(this.cuT, d.C0142d.cp_bg_line_e);
        am.i(this.cuU, d.C0142d.cp_bg_line_e);
        if (this.cuN != null) {
            this.cuN.d(tbPageContext, i);
        }
        if (this.cuO != null) {
            this.cuO.d(tbPageContext, i);
        }
        if (this.cuP != null) {
            this.cuP.d(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.amN() != null) {
            if (!TextUtils.isEmpty(dVar.amN().title)) {
                this.cuL.setText(dVar.amN().title);
            }
            List<bc> list = dVar.amN().sub_nodes;
            if (com.baidu.tbadk.core.util.w.z(list) >= 1) {
                this.cuQ = new com.baidu.tieba.e.a();
                this.cuQ.setData(list.get(0));
                this.cuN.getView().setVisibility(0);
                this.cuN.a(this.cuQ);
            }
            if (com.baidu.tbadk.core.util.w.z(list) >= 2) {
                this.cuR = new com.baidu.tieba.e.b();
                this.cuR.setData(list.get(1));
                this.cuO.getView().setVisibility(0);
                this.cuO.a(this.cuR);
                this.cuO.iH(8);
            }
            if (com.baidu.tbadk.core.util.w.z(list) >= 3) {
                this.cuS = new com.baidu.tieba.e.b();
                this.cuS.setData(list.get(2));
                this.cuP.getView().setVisibility(0);
                this.cuP.a(this.cuS);
                this.cuP.iH(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13047").r("obj_locate", 6).ah(ImageViewerConfig.FORUM_ID, this.mForumId));
        if (view == this.cuN.getView()) {
            if (this.cuQ != null) {
                if (this.cuV != null) {
                    this.cuV.b(view, this.cuQ);
                }
                H(this.cuQ.SV());
            }
        } else if (view == this.cuO.getView()) {
            if (this.cuR != null) {
                if (this.cuV != null) {
                    this.cuV.b(view, this.cuR);
                }
                H(this.cuR.SV());
            }
        } else if (view == this.cuP.getView() && this.cuS != null) {
            if (this.cuV != null) {
                this.cuV.b(view, this.cuS);
            }
            H(this.cuS.SV());
        }
    }

    private void H(bc bcVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(ahZ().getPageActivity()).createFromThreadCfg(bcVar, null, o.vk(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bcVar.getFid()));
        createFromThreadCfg.setForumName(bcVar.vB());
        createFromThreadCfg.setStartFrom(0);
        o.kY(bcVar.getTid());
        ahZ().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.cuV = aVar;
    }
}
