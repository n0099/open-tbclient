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
    private View cbv;
    private String cbx;
    private HeadImageView ccA;
    private TextView ccB;
    private TextView ccC;
    private TbImageView ccD;
    private TextView ccE;
    private com.baidu.tieba.card.data.q ccF;
    private int ccG;
    private String ccH;
    private String ccI;
    private View mRootView;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ccG = tbPageContext.getResources().getDimensionPixelSize(d.e.ds70);
        init(getView());
    }

    public void x(String str, String str2, String str3) {
        this.cbx = str;
        this.ccH = str2;
        this.ccI = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.root_view);
        this.ccA = (HeadImageView) view.findViewById(d.g.promotion_head_img);
        this.ccB = (TextView) view.findViewById(d.g.promotion_name);
        this.ccC = (TextView) view.findViewById(d.g.promotion_desc);
        this.ccD = (TbImageView) view.findViewById(d.g.promotion_img);
        this.ccE = (TextView) view.findViewById(d.g.promotion_icon);
        this.cbv = view.findViewById(d.g.top_line);
        this.ccA.setOnClickListener(this);
        this.ccB.setOnClickListener(this);
        this.ccE.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.ccA.setDefaultResource(17170445);
        this.ccA.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.ccA.setDefaultBgResource(d.C0095d.cp_bg_line_e);
        this.ccA.setRadius(this.ccG);
        this.ccD.setDrawBorder(true);
        this.ccD.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.ccA || view == this.ccB || view == this.ccE) && !StringUtils.isNull(this.ccF.ceP)) {
            TiebaStatic.log(new ak(this.ccH).ac("obj_id", String.valueOf(this.ccF.ceN)));
            av.vI().c(abs(), new String[]{this.ccF.ceP});
        } else if ((view == this.mRootView || view == this.ccC || view == this.ccD) && !StringUtils.isNull(this.ccF.ceS)) {
            TiebaStatic.log(new ak(this.ccI).ac("obj_id", String.valueOf(this.ccF.ceN)));
            av.vI().c(abs(), new String[]{this.ccF.ceS});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.mRootView, d.f.addresslist_item_bg);
            aj.j(this.ccE, d.f.label_bg_gray);
            aj.j(this.cbv, d.C0095d.cp_bg_line_b);
            aj.c(this.ccB, d.C0095d.cp_cont_b, 1);
            aj.c(this.ccE, d.C0095d.cp_cont_d, 1);
            aj.c(this.ccC, d.C0095d.cp_cont_b, 1);
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
        this.ccF = qVar;
        this.ccA.startLoad(qVar.ceO, 10, false);
        this.ccB.setText(UtilHelper.getFixedText(qVar.userName, 7, true));
        if (StringUtils.isNull(qVar.ceU)) {
            this.ccE.setVisibility(8);
        } else {
            this.ccE.setVisibility(0);
            this.ccE.setText(qVar.ceU);
        }
        this.ccC.setText(qVar.ceQ);
        if (com.baidu.tbadk.core.h.oY().pe()) {
            this.ccD.setVisibility(0);
            this.ccD.startLoad(qVar.ceR, 10, false);
            return;
        }
        this.ccD.setVisibility(8);
    }
}
