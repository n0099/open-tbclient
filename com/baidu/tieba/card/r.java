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
    private View cUD;
    private String cUF;
    private HeadImageView cVF;
    private TextView cVG;
    private TextView cVH;
    private TbImageView cVI;
    private TextView cVJ;
    private com.baidu.tieba.card.data.q cVK;
    private int cVL;
    private String cVM;
    private String cVN;
    private View mRootView;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cVL = tbPageContext.getResources().getDimensionPixelSize(d.e.ds70);
        init(getView());
    }

    public void y(String str, String str2, String str3) {
        this.cUF = str;
        this.cVM = str2;
        this.cVN = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.root_view);
        this.cVF = (HeadImageView) view.findViewById(d.g.promotion_head_img);
        this.cVG = (TextView) view.findViewById(d.g.promotion_name);
        this.cVH = (TextView) view.findViewById(d.g.promotion_desc);
        this.cVI = (TbImageView) view.findViewById(d.g.promotion_img);
        this.cVJ = (TextView) view.findViewById(d.g.promotion_icon);
        this.cUD = view.findViewById(d.g.top_line);
        this.cVF.setOnClickListener(this);
        this.cVG.setOnClickListener(this);
        this.cVJ.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.cVF.setDefaultResource(17170445);
        this.cVF.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cVF.setDefaultBgResource(d.C0107d.cp_bg_line_e);
        this.cVF.setRadius(this.cVL);
        this.cVI.setDrawBorder(true);
        this.cVI.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.cVF || view == this.cVG || view == this.cVJ) && !StringUtils.isNull(this.cVK.cXV)) {
            TiebaStatic.log(new ak(this.cVM).ab("obj_id", String.valueOf(this.cVK.cXT)));
            av.CZ().c(aka(), new String[]{this.cVK.cXV});
        } else if ((view == this.mRootView || view == this.cVH || view == this.cVI) && !StringUtils.isNull(this.cVK.cXY)) {
            TiebaStatic.log(new ak(this.cVN).ab("obj_id", String.valueOf(this.cVK.cXT)));
            av.CZ().c(aka(), new String[]{this.cVK.cXY});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.mRootView, d.f.addresslist_item_bg);
            aj.s(this.cVJ, d.f.label_bg_gray);
            aj.s(this.cUD, d.C0107d.cp_bg_line_b);
            aj.e(this.cVG, d.C0107d.cp_cont_b, 1);
            aj.e(this.cVJ, d.C0107d.cp_cont_d, 1);
            aj.e(this.cVH, d.C0107d.cp_cont_b, 1);
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
        this.cVK = qVar;
        this.cVF.startLoad(qVar.cXU, 10, false);
        this.cVG.setText(UtilHelper.getFixedText(qVar.userName, 7, true));
        if (StringUtils.isNull(qVar.cYa)) {
            this.cVJ.setVisibility(8);
        } else {
            this.cVJ.setVisibility(0);
            this.cVJ.setText(qVar.cYa);
        }
        this.cVH.setText(qVar.cXW);
        if (com.baidu.tbadk.core.i.wA().wG()) {
            this.cVI.setVisibility(0);
            this.cVI.startLoad(qVar.cXX, 10, false);
            return;
        }
        this.cVI.setVisibility(8);
    }
}
