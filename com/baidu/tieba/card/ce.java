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
public class ce extends a<com.baidu.tieba.card.a.y> {
    private View aRI;
    private int aRK;
    private String aUM;
    private HeadImageView aUP;
    private TextView aUQ;
    private TextView aUR;
    private TbImageView aUS;
    private TextView aUT;
    private com.baidu.tieba.card.a.y aUU;
    private String aUV;
    private String aUW;
    private View mRootView;

    public ce(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aRK = tbPageContext.getResources().getDimensionPixelSize(t.e.ds70);
        P(getView());
    }

    public void p(String str, String str2, String str3) {
        this.aUM = str;
        this.aUV = str2;
        this.aUW = str3;
    }

    private void P(View view) {
        this.mRootView = view.findViewById(t.g.root_view);
        this.aUP = (HeadImageView) view.findViewById(t.g.promotion_head_img);
        this.aUQ = (TextView) view.findViewById(t.g.promotion_name);
        this.aUR = (TextView) view.findViewById(t.g.promotion_desc);
        this.aUS = (TbImageView) view.findViewById(t.g.promotion_img);
        this.aUT = (TextView) view.findViewById(t.g.promotion_icon);
        this.aRI = view.findViewById(t.g.top_line);
        this.aUP.setOnClickListener(this);
        this.aUQ.setOnClickListener(this);
        this.aUT.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.aUP.setDefaultResource(17170445);
        this.aUP.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.aUP.setDefaultBgResource(t.d.cp_bg_line_e);
        this.aUP.setRadius(this.aRK);
        this.aUS.setDrawBorder(true);
        this.aUS.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.aUP || view == this.aUQ || view == this.aUT) && !StringUtils.isNull(this.aUU.aWA)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw(this.aUV).ac("obj_id", String.valueOf(this.aUU.aWy)));
            com.baidu.tbadk.core.util.bg.wM().c(Lb(), new String[]{this.aUU.aWA});
        } else if ((view == this.mRootView || view == this.aUR || view == this.aUS) && !StringUtils.isNull(this.aUU.aWD)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw(this.aUW).ac("obj_id", String.valueOf(this.aUU.aWy)));
            com.baidu.tbadk.core.util.bg.wM().c(Lb(), new String[]{this.aUU.aWD});
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(this.mRootView, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.k(this.aUT, t.f.label_bg_gray);
            com.baidu.tbadk.core.util.at.k(this.aRI, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.b(this.aUQ, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.b(this.aUT, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.b(this.aUR, t.d.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int Le() {
        return t.h.card_promotion_item;
    }

    public void a(com.baidu.tieba.card.a.y yVar) {
        if (yVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.aUU = yVar;
        this.aUP.c(yVar.aWz, 10, false);
        this.aUQ.setText(UtilHelper.getFixedText(yVar.userName, 7, true));
        if (StringUtils.isNull(yVar.aWF)) {
            this.aUT.setVisibility(8);
        } else {
            this.aUT.setVisibility(0);
            this.aUT.setText(yVar.aWF);
        }
        this.aUR.setText(yVar.aWB);
        if (com.baidu.tbadk.core.l.qE().qK()) {
            this.aUS.setVisibility(0);
            this.aUS.c(yVar.aWC, 10, false);
            return;
        }
        this.aUS.setVisibility(8);
    }
}
