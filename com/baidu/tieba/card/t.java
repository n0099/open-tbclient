package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.q;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class t extends a<q> {
    private HeadImageView bIH;
    private TextView bII;
    private TextView bIJ;
    private TbImageView bIK;
    private TextView bIL;
    private q bIM;
    private int bIN;
    private String bIO;
    private String bIP;
    private View bIk;
    private String bIm;
    private View mRootView;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bIN = tbPageContext.getResources().getDimensionPixelSize(d.f.ds70);
        S(getView());
    }

    public void y(String str, String str2, String str3) {
        this.bIm = str;
        this.bIO = str2;
        this.bIP = str3;
    }

    private void S(View view) {
        this.mRootView = view.findViewById(d.h.root_view);
        this.bIH = (HeadImageView) view.findViewById(d.h.promotion_head_img);
        this.bII = (TextView) view.findViewById(d.h.promotion_name);
        this.bIJ = (TextView) view.findViewById(d.h.promotion_desc);
        this.bIK = (TbImageView) view.findViewById(d.h.promotion_img);
        this.bIL = (TextView) view.findViewById(d.h.promotion_icon);
        this.bIk = view.findViewById(d.h.top_line);
        this.bIH.setOnClickListener(this);
        this.bII.setOnClickListener(this);
        this.bIL.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.bIH.setDefaultResource(17170445);
        this.bIH.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.bIH.setDefaultBgResource(d.e.cp_bg_line_e);
        this.bIH.setRadius(this.bIN);
        this.bIK.setDrawBorder(true);
        this.bIK.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.bIH || view == this.bII || view == this.bIL) && !StringUtils.isNull(this.bIM.bKu)) {
            TiebaStatic.log(new aj(this.bIO).aa("obj_id", String.valueOf(this.bIM.bKs)));
            at.wf().c(Wd(), new String[]{this.bIM.bKu});
        } else if ((view == this.mRootView || view == this.bIJ || view == this.bIK) && !StringUtils.isNull(this.bIM.bKx)) {
            TiebaStatic.log(new aj(this.bIP).aa("obj_id", String.valueOf(this.bIM.bKs)));
            at.wf().c(Wd(), new String[]{this.bIM.bKx});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.mRootView, d.g.addresslist_item_bg);
            ai.j(this.bIL, d.g.label_bg_gray);
            ai.j(this.bIk, d.e.cp_bg_line_b);
            ai.c(this.bII, d.e.cp_cont_b, 1);
            ai.c(this.bIL, d.e.cp_cont_d, 1);
            ai.c(this.bIJ, d.e.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(q qVar) {
        if (qVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.bIM = qVar;
        this.bIH.c(qVar.bKt, 10, false);
        this.bII.setText(UtilHelper.getFixedText(qVar.userName, 7, true));
        if (StringUtils.isNull(qVar.bKz)) {
            this.bIL.setVisibility(8);
        } else {
            this.bIL.setVisibility(0);
            this.bIL.setText(qVar.bKz);
        }
        this.bIJ.setText(qVar.bKv);
        if (com.baidu.tbadk.core.h.oX().pd()) {
            this.bIK.setVisibility(0);
            this.bIK.c(qVar.bKw, 10, false);
            return;
        }
        this.bIK.setVisibility(8);
    }
}
