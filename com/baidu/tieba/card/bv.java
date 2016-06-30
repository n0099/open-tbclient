package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class bv extends a<com.baidu.tieba.card.a.r> {
    private View aRC;
    private String aUA;
    private HeadImageView aUD;
    private TextView aUE;
    private TextView aUF;
    private TbImageView aUG;
    private TextView aUH;
    private com.baidu.tieba.card.a.r aUI;
    private int aUJ;
    private String aUK;
    private String aUL;
    private View mRootView;

    public bv(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aUJ = tbPageContext.getResources().getDimensionPixelSize(u.e.ds70);
        S(getView());
    }

    public void u(String str, String str2, String str3) {
        this.aUA = str;
        this.aUK = str2;
        this.aUL = str3;
    }

    private void S(View view) {
        this.mRootView = view.findViewById(u.g.root_view);
        this.aUD = (HeadImageView) view.findViewById(u.g.promotion_head_img);
        this.aUE = (TextView) view.findViewById(u.g.promotion_name);
        this.aUF = (TextView) view.findViewById(u.g.promotion_desc);
        this.aUG = (TbImageView) view.findViewById(u.g.promotion_img);
        this.aUH = (TextView) view.findViewById(u.g.promotion_icon);
        this.aRC = view.findViewById(u.g.top_line);
        this.aUD.setOnClickListener(this);
        this.aUE.setOnClickListener(this);
        this.aUH.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.aUD.setDefaultResource(17170445);
        this.aUD.setDefaultErrorResource(u.f.icon_default_avatar100);
        this.aUD.setDefaultBgResource(u.d.cp_bg_line_e);
        this.aUD.setRadius(this.aUJ);
        this.aUG.setDrawBorder(true);
        this.aUG.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.aUD || view == this.aUE || view == this.aUH) && !StringUtils.isNull(this.aUI.aVP)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay(this.aUK).ab("obj_id", String.valueOf(this.aUI.aVN)));
            com.baidu.tbadk.core.util.bi.us().c(KN(), new String[]{this.aUI.aVP});
        } else if ((view == this.mRootView || view == this.aUF || view == this.aUG) && !StringUtils.isNull(this.aUI.aVS)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay(this.aUL).ab("obj_id", String.valueOf(this.aUI.aVN)));
            com.baidu.tbadk.core.util.bi.us().c(KN(), new String[]{this.aUI.aVS});
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(this.mRootView, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.k(this.aUH, u.f.label_bg_gray);
            com.baidu.tbadk.core.util.av.k(this.aRC, u.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.c(this.aUE, u.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(this.aUH, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(this.aUF, u.d.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_promotion_item;
    }

    public void a(com.baidu.tieba.card.a.r rVar) {
        if (rVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.aUI = rVar;
        this.aUD.c(rVar.aVO, 10, false);
        this.aUE.setText(UtilHelper.getFixedText(rVar.userName, 7, true));
        if (StringUtils.isNull(rVar.aVU)) {
            this.aUH.setVisibility(8);
        } else {
            this.aUH.setVisibility(0);
            this.aUH.setText(rVar.aVU);
        }
        this.aUF.setText(rVar.aVQ);
        if (com.baidu.tbadk.core.l.nW().oc()) {
            this.aUG.setVisibility(0);
            this.aUG.c(rVar.aVR, 10, false);
            return;
        }
        this.aUG.setVisibility(8);
    }
}
