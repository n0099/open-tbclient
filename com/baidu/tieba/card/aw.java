package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class aw extends a<com.baidu.tieba.card.a.v> {
    private View aOS;
    private int aOU;
    private String aRf;
    private HeadImageView aRh;
    private TextView aRi;
    private TextView aRj;
    private TbImageView aRk;
    private TextView aRl;
    private com.baidu.tieba.card.a.v aRm;
    private String aRn;
    private String aRo;
    private View mRootView;

    public aw(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aOU = tbPageContext.getResources().getDimensionPixelSize(t.e.ds70);
        L(getView());
    }

    public void n(String str, String str2, String str3) {
        this.aRf = str;
        this.aRn = str2;
        this.aRo = str3;
    }

    private void L(View view) {
        this.mRootView = view.findViewById(t.g.root_view);
        this.aRh = (HeadImageView) view.findViewById(t.g.promotion_head_img);
        this.aRi = (TextView) view.findViewById(t.g.promotion_name);
        this.aRj = (TextView) view.findViewById(t.g.promotion_desc);
        this.aRk = (TbImageView) view.findViewById(t.g.promotion_img);
        this.aRl = (TextView) view.findViewById(t.g.promotion_icon);
        this.aOS = view.findViewById(t.g.top_line);
        this.aRh.setOnClickListener(this);
        this.aRi.setOnClickListener(this);
        this.aRl.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.aRh.setDefaultResource(17170445);
        this.aRh.setDefaultBgResource(t.f.icon_default_avatar_round);
        this.aRh.setRadius(this.aOU);
        this.aRk.setDrawBorder(true);
        this.aRk.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.aRh || view == this.aRi || view == this.aRl) && !StringUtils.isNull(this.aRm.aSO)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.au(this.aRn).aa("obj_id", String.valueOf(this.aRm.aSM)));
            be.wt().c(JK(), new String[]{this.aRm.aSO});
        } else if ((view == this.mRootView || view == this.aRj || view == this.aRk) && !StringUtils.isNull(this.aRm.aSR)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.au(this.aRo).aa("obj_id", String.valueOf(this.aRm.aSM)));
            be.wt().c(JK(), new String[]{this.aRm.aSR});
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ar.k(this.mRootView, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.ar.k(this.aRl, t.f.label_bg_gray);
            com.baidu.tbadk.core.util.ar.k(this.aOS, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.ar.b(this.aRi, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ar.b(this.aRl, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ar.b(this.aRj, t.d.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int JM() {
        return t.h.card_promotion_item;
    }

    public void a(com.baidu.tieba.card.a.v vVar) {
        if (vVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.aRm = vVar;
        this.aRh.d(vVar.aSN, 10, false);
        this.aRi.setText(UtilHelper.getFixedText(vVar.userName, 7, true));
        if (StringUtils.isNull(vVar.aST)) {
            this.aRl.setVisibility(8);
        } else {
            this.aRl.setVisibility(0);
            this.aRl.setText(vVar.aST);
        }
        this.aRj.setText(vVar.aSP);
        if (com.baidu.tbadk.core.l.rn().rt()) {
            this.aRk.setVisibility(0);
            this.aRk.d(vVar.aSQ, 10, false);
            return;
        }
        this.aRk.setVisibility(8);
    }
}
