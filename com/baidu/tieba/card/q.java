package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class q extends a<com.baidu.tieba.card.data.p> {
    private View cXx;
    private String cXz;
    private TextView cYA;
    private TextView cYB;
    private TbImageView cYC;
    private TextView cYD;
    private com.baidu.tieba.card.data.p cYE;
    private int cYF;
    private String cYG;
    private String cYH;
    private HeadImageView cYz;
    private View mRootView;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cYF = tbPageContext.getResources().getDimensionPixelSize(d.e.ds70);
        init(getView());
    }

    public void z(String str, String str2, String str3) {
        this.cXz = str;
        this.cYG = str2;
        this.cYH = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.root_view);
        this.cYz = (HeadImageView) view.findViewById(d.g.promotion_head_img);
        this.cYA = (TextView) view.findViewById(d.g.promotion_name);
        this.cYB = (TextView) view.findViewById(d.g.promotion_desc);
        this.cYC = (TbImageView) view.findViewById(d.g.promotion_img);
        this.cYD = (TextView) view.findViewById(d.g.promotion_icon);
        this.cXx = view.findViewById(d.g.top_line);
        this.cYz.setOnClickListener(this);
        this.cYA.setOnClickListener(this);
        this.cYD.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.cYz.setDefaultResource(17170445);
        this.cYz.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cYz.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.cYz.setRadius(this.cYF);
        this.cYC.setDrawBorder(true);
        this.cYC.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.cYz || view == this.cYA || view == this.cYD) && !StringUtils.isNull(this.cYE.daR)) {
            TiebaStatic.log(new ak(this.cYG).ab("obj_id", String.valueOf(this.cYE.daP)));
            aw.Dt().c(akN(), new String[]{this.cYE.daR});
        } else if ((view == this.mRootView || view == this.cYB || view == this.cYC) && !StringUtils.isNull(this.cYE.daU)) {
            TiebaStatic.log(new ak(this.cYH).ab("obj_id", String.valueOf(this.cYE.daP)));
            aw.Dt().c(akN(), new String[]{this.cYE.daU});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.mRootView, d.f.addresslist_item_bg);
            aj.s(this.cYD, d.f.label_bg_gray);
            aj.s(this.cXx, d.C0141d.cp_bg_line_b);
            aj.e(this.cYA, d.C0141d.cp_cont_b, 1);
            aj.e(this.cYD, d.C0141d.cp_cont_d, 1);
            aj.e(this.cYB, d.C0141d.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.p pVar) {
        if (pVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.cYE = pVar;
        this.cYz.startLoad(pVar.daQ, 10, false);
        this.cYA.setText(UtilHelper.getFixedText(pVar.userName, 7, true));
        if (StringUtils.isNull(pVar.daW)) {
            this.cYD.setVisibility(8);
        } else {
            this.cYD.setVisibility(0);
            this.cYD.setText(pVar.daW);
        }
        this.cYB.setText(pVar.daS);
        if (com.baidu.tbadk.core.i.xo().xu()) {
            this.cYC.setVisibility(0);
            this.cYC.startLoad(pVar.daT, 10, false);
            return;
        }
        this.cYC.setVisibility(8);
    }
}
