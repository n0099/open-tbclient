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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes4.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.e.d> {
    private LinearLayout egd;
    private TextView ege;
    private LinearLayout egf;
    private d egg;
    private e egh;
    private e egi;
    private com.baidu.tieba.e.a egj;
    private com.baidu.tieba.e.b egk;
    private com.baidu.tieba.e.b egl;
    private View egm;
    private View egn;
    private a ego;
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
        this.egd = (LinearLayout) view.findViewById(d.g.card_frs_game_head_line_layout);
        this.ege = (TextView) view.findViewById(d.g.frs_game_head_line_title);
        this.egf = (LinearLayout) view.findViewById(d.g.frs_game_head_line_container);
        this.egm = view.findViewById(d.g.divider_line_1);
        this.egn = view.findViewById(d.g.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.tbds44);
        if (this.egg == null) {
            this.egg = new d(this.mTbPageContext, null, null);
        }
        this.egg.q(0, 0, 0, 0);
        this.egg.oh(8);
        this.egg.oi(8);
        if (this.egg.getView().getParent() != null) {
            ((ViewGroup) this.egg.getView().getParent()).removeView(this.egg.getView());
        }
        this.egg.getView().setOnClickListener(this);
        this.egg.getView().setVisibility(8);
        this.egf.addView(this.egg.getView());
        if (this.egh == null) {
            this.egh = new e(this.mTbPageContext);
        }
        this.egh.oi(8);
        this.egh.r(0, dimensionPixelSize, 0, 0);
        if (this.egh.getView().getParent() != null) {
            ((ViewGroup) this.egh.getView().getParent()).removeView(this.egh.getView());
        }
        this.egh.getView().setOnClickListener(this);
        this.egh.getView().setVisibility(8);
        this.egf.addView(this.egh.getView());
        if (this.egi == null) {
            this.egi = new e(this.mTbPageContext);
        }
        this.egi.oi(8);
        this.egi.r(0, dimensionPixelSize, 0, 0);
        if (this.egi.getView().getParent() != null) {
            ((ViewGroup) this.egi.getView().getParent()).removeView(this.egi.getView());
        }
        this.egi.getView().setOnClickListener(this);
        this.egi.getView().setVisibility(8);
        this.egf.addView(this.egi.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        al.k(getView(), d.C0277d.cp_bg_line_d);
        al.d(this.ege, d.C0277d.cp_cont_f, 1);
        al.k(this.egm, d.C0277d.cp_bg_line_e);
        al.k(this.egn, d.C0277d.cp_bg_line_e);
        if (this.egg != null) {
            this.egg.onChangeSkinType(tbPageContext, i);
        }
        if (this.egh != null) {
            this.egh.onChangeSkinType(tbPageContext, i);
        }
        if (this.egi != null) {
            this.egi.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.aUM() != null) {
            if (!TextUtils.isEmpty(dVar.aUM().title)) {
                this.ege.setText(dVar.aUM().title);
            }
            List<bg> list = dVar.aUM().sub_nodes;
            if (com.baidu.tbadk.core.util.v.S(list) >= 1) {
                this.egj = new com.baidu.tieba.e.a();
                this.egj.setData(list.get(0));
                this.egg.getView().setVisibility(0);
                this.egg.a(this.egj);
            }
            if (com.baidu.tbadk.core.util.v.S(list) >= 2) {
                this.egk = new com.baidu.tieba.e.b();
                this.egk.setData(list.get(1));
                this.egh.getView().setVisibility(0);
                this.egh.a(this.egk);
                this.egh.oj(8);
            }
            if (com.baidu.tbadk.core.util.v.S(list) >= 3) {
                this.egl = new com.baidu.tieba.e.b();
                this.egl.setData(list.get(2));
                this.egi.getView().setVisibility(0);
                this.egi.a(this.egl);
                this.egi.oj(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new am("c13047").T("obj_locate", 6).bJ(ImageViewerConfig.FORUM_ID, this.mForumId));
        if (view == this.egg.getView()) {
            if (this.egj != null) {
                if (this.ego != null) {
                    this.ego.b(view, this.egj);
                }
                Q(this.egj.WO());
            }
        } else if (view == this.egh.getView()) {
            if (this.egk != null) {
                if (this.ego != null) {
                    this.ego.b(view, this.egk);
                }
                Q(this.egk.WO());
            }
        } else if (view == this.egi.getView() && this.egl != null) {
            if (this.ego != null) {
                this.ego.b(view, this.egl);
            }
            Q(this.egl.WO());
        }
    }

    private void Q(bg bgVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bgVar, null, n.YB(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bgVar.getFid()));
        createFromThreadCfg.setForumName(bgVar.YT());
        createFromThreadCfg.setStartFrom(0);
        n.tz(bgVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.ego = aVar;
    }
}
