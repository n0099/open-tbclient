package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class r extends a<com.baidu.tieba.card.data.q> {
    private View cbr;
    private String cbt;
    private TextView ccA;
    private com.baidu.tieba.card.data.q ccB;
    private int ccC;
    private String ccD;
    private String ccE;
    private HeadImageView ccw;
    private TextView ccx;
    private TextView ccy;
    private TbImageView ccz;
    private View mRootView;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ccC = tbPageContext.getResources().getDimensionPixelSize(d.e.ds70);
        init(getView());
    }

    public void x(String str, String str2, String str3) {
        this.cbt = str;
        this.ccD = str2;
        this.ccE = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.root_view);
        this.ccw = (HeadImageView) view.findViewById(d.g.promotion_head_img);
        this.ccx = (TextView) view.findViewById(d.g.promotion_name);
        this.ccy = (TextView) view.findViewById(d.g.promotion_desc);
        this.ccz = (TbImageView) view.findViewById(d.g.promotion_img);
        this.ccA = (TextView) view.findViewById(d.g.promotion_icon);
        this.cbr = view.findViewById(d.g.top_line);
        this.ccw.setOnClickListener(this);
        this.ccx.setOnClickListener(this);
        this.ccA.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.ccw.setDefaultResource(17170445);
        this.ccw.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.ccw.setDefaultBgResource(d.C0096d.cp_bg_line_e);
        this.ccw.setRadius(this.ccC);
        this.ccz.setDrawBorder(true);
        this.ccz.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.ccw || view == this.ccx || view == this.ccA) && !StringUtils.isNull(this.ccB.ceL)) {
            TiebaStatic.log(new ak(this.ccD).ac("obj_id", String.valueOf(this.ccB.ceJ)));
            av.vI().c(abs(), new String[]{this.ccB.ceL});
        } else if ((view == this.mRootView || view == this.ccy || view == this.ccz) && !StringUtils.isNull(this.ccB.ceO)) {
            TiebaStatic.log(new ak(this.ccE).ac("obj_id", String.valueOf(this.ccB.ceJ)));
            av.vI().c(abs(), new String[]{this.ccB.ceO});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.mRootView, d.f.addresslist_item_bg);
            aj.j(this.ccA, d.f.label_bg_gray);
            aj.j(this.cbr, d.C0096d.cp_bg_line_b);
            aj.c(this.ccx, d.C0096d.cp_cont_b, 1);
            aj.c(this.ccA, d.C0096d.cp_cont_d, 1);
            aj.c(this.ccy, d.C0096d.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.q qVar) {
        if (qVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.ccB = qVar;
        this.ccw.startLoad(qVar.ceK, 10, false);
        this.ccx.setText(UtilHelper.getFixedText(qVar.userName, 7, true));
        if (StringUtils.isNull(qVar.ceQ)) {
            this.ccA.setVisibility(8);
        } else {
            this.ccA.setVisibility(0);
            this.ccA.setText(qVar.ceQ);
        }
        this.ccy.setText(qVar.ceM);
        if (com.baidu.tbadk.core.h.oY().pe()) {
            this.ccz.setVisibility(0);
            this.ccz.startLoad(qVar.ceN, 10, false);
            return;
        }
        this.ccz.setVisibility(8);
    }
}
