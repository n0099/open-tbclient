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
import com.baidu.tieba.card.data.q;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class t extends a<q> {
    private HeadImageView bMD;
    private TextView bME;
    private TextView bMF;
    private TbImageView bMG;
    private TextView bMH;
    private q bMI;
    private int bMJ;
    private String bMK;
    private String bML;
    private View bMb;
    private String bMd;
    private View mRootView;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bMJ = tbPageContext.getResources().getDimensionPixelSize(d.f.ds70);
        init(getView());
    }

    public void z(String str, String str2, String str3) {
        this.bMd = str;
        this.bMK = str2;
        this.bML = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.h.root_view);
        this.bMD = (HeadImageView) view.findViewById(d.h.promotion_head_img);
        this.bME = (TextView) view.findViewById(d.h.promotion_name);
        this.bMF = (TextView) view.findViewById(d.h.promotion_desc);
        this.bMG = (TbImageView) view.findViewById(d.h.promotion_img);
        this.bMH = (TextView) view.findViewById(d.h.promotion_icon);
        this.bMb = view.findViewById(d.h.top_line);
        this.bMD.setOnClickListener(this);
        this.bME.setOnClickListener(this);
        this.bMH.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.bMD.setDefaultResource(17170445);
        this.bMD.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.bMD.setDefaultBgResource(d.e.cp_bg_line_e);
        this.bMD.setRadius(this.bMJ);
        this.bMG.setDrawBorder(true);
        this.bMG.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.bMD || view == this.bME || view == this.bMH) && !StringUtils.isNull(this.bMI.bOu)) {
            TiebaStatic.log(new ak(this.bMK).ad("obj_id", String.valueOf(this.bMI.bOs)));
            av.vH().c(Xq(), new String[]{this.bMI.bOu});
        } else if ((view == this.mRootView || view == this.bMF || view == this.bMG) && !StringUtils.isNull(this.bMI.bOx)) {
            TiebaStatic.log(new ak(this.bML).ad("obj_id", String.valueOf(this.bMI.bOs)));
            av.vH().c(Xq(), new String[]{this.bMI.bOx});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.mRootView, d.g.addresslist_item_bg);
            aj.j(this.bMH, d.g.label_bg_gray);
            aj.j(this.bMb, d.e.cp_bg_line_b);
            aj.c(this.bME, d.e.cp_cont_b, 1);
            aj.c(this.bMH, d.e.cp_cont_d, 1);
            aj.c(this.bMF, d.e.cp_cont_b, 1);
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
        this.bMI = qVar;
        this.bMD.c(qVar.bOt, 10, false);
        this.bME.setText(UtilHelper.getFixedText(qVar.userName, 7, true));
        if (StringUtils.isNull(qVar.bOz)) {
            this.bMH.setVisibility(8);
        } else {
            this.bMH.setVisibility(0);
            this.bMH.setText(qVar.bOz);
        }
        this.bMF.setText(qVar.bOv);
        if (com.baidu.tbadk.core.h.oT().oZ()) {
            this.bMG.setVisibility(0);
            this.bMG.c(qVar.bOw, 10, false);
            return;
        }
        this.bMG.setVisibility(8);
    }
}
