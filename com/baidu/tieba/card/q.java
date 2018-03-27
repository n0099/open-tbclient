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
    private View cXA;
    private String cXC;
    private HeadImageView cYC;
    private TextView cYD;
    private TextView cYE;
    private TbImageView cYF;
    private TextView cYG;
    private com.baidu.tieba.card.data.p cYH;
    private int cYI;
    private String cYJ;
    private String cYK;
    private View mRootView;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cYI = tbPageContext.getResources().getDimensionPixelSize(d.e.ds70);
        init(getView());
    }

    public void z(String str, String str2, String str3) {
        this.cXC = str;
        this.cYJ = str2;
        this.cYK = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.root_view);
        this.cYC = (HeadImageView) view.findViewById(d.g.promotion_head_img);
        this.cYD = (TextView) view.findViewById(d.g.promotion_name);
        this.cYE = (TextView) view.findViewById(d.g.promotion_desc);
        this.cYF = (TbImageView) view.findViewById(d.g.promotion_img);
        this.cYG = (TextView) view.findViewById(d.g.promotion_icon);
        this.cXA = view.findViewById(d.g.top_line);
        this.cYC.setOnClickListener(this);
        this.cYD.setOnClickListener(this);
        this.cYG.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.cYC.setDefaultResource(17170445);
        this.cYC.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cYC.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.cYC.setRadius(this.cYI);
        this.cYF.setDrawBorder(true);
        this.cYF.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.cYC || view == this.cYD || view == this.cYG) && !StringUtils.isNull(this.cYH.daU)) {
            TiebaStatic.log(new ak(this.cYJ).ab("obj_id", String.valueOf(this.cYH.daS)));
            aw.Du().c(akO(), new String[]{this.cYH.daU});
        } else if ((view == this.mRootView || view == this.cYE || view == this.cYF) && !StringUtils.isNull(this.cYH.daX)) {
            TiebaStatic.log(new ak(this.cYK).ab("obj_id", String.valueOf(this.cYH.daS)));
            aw.Du().c(akO(), new String[]{this.cYH.daX});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.mRootView, d.f.addresslist_item_bg);
            aj.s(this.cYG, d.f.label_bg_gray);
            aj.s(this.cXA, d.C0141d.cp_bg_line_b);
            aj.e(this.cYD, d.C0141d.cp_cont_b, 1);
            aj.e(this.cYG, d.C0141d.cp_cont_d, 1);
            aj.e(this.cYE, d.C0141d.cp_cont_b, 1);
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
        this.cYH = pVar;
        this.cYC.startLoad(pVar.daT, 10, false);
        this.cYD.setText(UtilHelper.getFixedText(pVar.userName, 7, true));
        if (StringUtils.isNull(pVar.daZ)) {
            this.cYG.setVisibility(8);
        } else {
            this.cYG.setVisibility(0);
            this.cYG.setText(pVar.daZ);
        }
        this.cYE.setText(pVar.daV);
        if (com.baidu.tbadk.core.i.xo().xu()) {
            this.cYF.setVisibility(0);
            this.cYF.startLoad(pVar.daW, 10, false);
            return;
        }
        this.cYF.setVisibility(8);
    }
}
