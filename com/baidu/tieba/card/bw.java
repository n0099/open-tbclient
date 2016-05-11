package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class bw extends a<com.baidu.tieba.card.a.q> {
    private View aOf;
    private String aRe;
    private HeadImageView aRh;
    private TextView aRi;
    private TextView aRj;
    private TbImageView aRk;
    private TextView aRl;
    private com.baidu.tieba.card.a.q aRm;
    private int aRn;
    private String aRo;
    private String aRp;
    private View mRootView;

    public bw(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aRn = tbPageContext.getResources().getDimensionPixelSize(t.e.ds70);
        R(getView());
    }

    public void p(String str, String str2, String str3) {
        this.aRe = str;
        this.aRo = str2;
        this.aRp = str3;
    }

    private void R(View view) {
        this.mRootView = view.findViewById(t.g.root_view);
        this.aRh = (HeadImageView) view.findViewById(t.g.promotion_head_img);
        this.aRi = (TextView) view.findViewById(t.g.promotion_name);
        this.aRj = (TextView) view.findViewById(t.g.promotion_desc);
        this.aRk = (TbImageView) view.findViewById(t.g.promotion_img);
        this.aRl = (TextView) view.findViewById(t.g.promotion_icon);
        this.aOf = view.findViewById(t.g.top_line);
        this.aRh.setOnClickListener(this);
        this.aRi.setOnClickListener(this);
        this.aRl.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.aRh.setDefaultResource(17170445);
        this.aRh.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.aRh.setDefaultBgResource(t.d.cp_bg_line_e);
        this.aRh.setRadius(this.aRn);
        this.aRk.setDrawBorder(true);
        this.aRk.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.aRh || view == this.aRi || view == this.aRl) && !StringUtils.isNull(this.aRm.aSu)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw(this.aRo).ac("obj_id", String.valueOf(this.aRm.aSs)));
            com.baidu.tbadk.core.util.bg.us().c(getTbPageContext(), new String[]{this.aRm.aSu});
        } else if ((view == this.mRootView || view == this.aRj || view == this.aRk) && !StringUtils.isNull(this.aRm.aSx)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw(this.aRp).ac("obj_id", String.valueOf(this.aRm.aSs)));
            com.baidu.tbadk.core.util.bg.us().c(getTbPageContext(), new String[]{this.aRm.aSx});
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(this.mRootView, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.k(this.aRl, t.f.label_bg_gray);
            com.baidu.tbadk.core.util.at.k(this.aOf, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.c(this.aRi, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.c(this.aRl, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(this.aRj, t.d.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int JN() {
        return t.h.card_promotion_item;
    }

    public void a(com.baidu.tieba.card.a.q qVar) {
        if (qVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.aRm = qVar;
        this.aRh.c(qVar.aSt, 10, false);
        this.aRi.setText(UtilHelper.getFixedText(qVar.userName, 7, true));
        if (StringUtils.isNull(qVar.aSz)) {
            this.aRl.setVisibility(8);
        } else {
            this.aRl.setVisibility(0);
            this.aRl.setText(qVar.aSz);
        }
        this.aRj.setText(qVar.aSv);
        if (com.baidu.tbadk.core.l.ob().oh()) {
            this.aRk.setVisibility(0);
            this.aRk.c(qVar.aSw, 10, false);
            return;
        }
        this.aRk.setVisibility(8);
    }
}
