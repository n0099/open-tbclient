package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.o;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class s extends a<o> {
    private View eiv;
    private String eix;
    private TextView ejA;
    private o ejB;
    private int ejC;
    private String ejD;
    private String ejE;
    private HeadImageView ejw;
    private TextView ejx;
    private TextView ejy;
    private TbImageView ejz;
    private View mRootView;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ejC = tbPageContext.getResources().getDimensionPixelSize(d.e.ds70);
        init(getView());
    }

    public void Q(String str, String str2, String str3) {
        this.eix = str;
        this.ejD = str2;
        this.ejE = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.root_view);
        this.ejw = (HeadImageView) view.findViewById(d.g.promotion_head_img);
        this.ejx = (TextView) view.findViewById(d.g.promotion_name);
        this.ejy = (TextView) view.findViewById(d.g.promotion_desc);
        this.ejz = (TbImageView) view.findViewById(d.g.promotion_img);
        this.ejA = (TextView) view.findViewById(d.g.promotion_icon);
        this.eiv = view.findViewById(d.g.top_line);
        this.ejw.setOnClickListener(this);
        this.ejx.setOnClickListener(this);
        this.ejA.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.ejw.setDefaultResource(17170445);
        this.ejw.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.ejw.setRadius(this.ejC);
        this.ejz.setDrawBorder(true);
        this.ejz.setBorderWidth(1);
        this.ejz.setDefaultBgResource(com.baidu.tbadk.util.e.get());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.ejw || view == this.ejx || view == this.ejA) && !StringUtils.isNull(this.ejB.emf)) {
            TiebaStatic.log(new am(this.ejD).bJ(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.ejB.emd)));
            ba.adA().c(getTbPageContext(), new String[]{this.ejB.emf});
        } else if ((view == this.mRootView || view == this.ejy || view == this.ejz) && !StringUtils.isNull(this.ejB.emi)) {
            TiebaStatic.log(new am(this.ejE).bJ(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.ejB.emd)));
            ba.adA().c(getTbPageContext(), new String[]{this.ejB.emi});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.mRootView, d.f.addresslist_item_bg);
            al.k(this.ejA, d.f.label_bg_gray);
            al.k(this.eiv, d.C0277d.cp_bg_line_b);
            al.d(this.ejx, d.C0277d.cp_cont_b, 1);
            al.d(this.ejA, d.C0277d.cp_cont_d, 1);
            al.d(this.ejy, d.C0277d.cp_cont_b, 1);
            this.ejw.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.ejz.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(o oVar) {
        if (oVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.ejB = oVar;
        this.ejw.startLoad(oVar.eme, 10, false);
        this.ejx.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.emk)) {
            this.ejA.setVisibility(8);
        } else {
            this.ejA.setVisibility(0);
            this.ejA.setText(oVar.emk);
        }
        this.ejy.setText(oVar.emg);
        if (com.baidu.tbadk.core.i.Wv().Wz()) {
            this.ejz.setVisibility(0);
            this.ejz.startLoad(oVar.emh, 10, false);
            return;
        }
        this.ejz.setVisibility(8);
    }
}
