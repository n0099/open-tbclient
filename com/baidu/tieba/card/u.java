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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class u extends a<com.baidu.tieba.card.data.o> {
    private View cYU;
    private String cYW;
    private HeadImageView cZV;
    private TextView cZW;
    private TextView cZX;
    private TbImageView cZY;
    private TextView cZZ;
    private com.baidu.tieba.card.data.o daa;
    private int dab;
    private String dac;
    private String dad;
    private View mRootView;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dab = tbPageContext.getResources().getDimensionPixelSize(e.C0210e.ds70);
        init(getView());
    }

    public void F(String str, String str2, String str3) {
        this.cYW = str;
        this.dac = str2;
        this.dad = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(e.g.root_view);
        this.cZV = (HeadImageView) view.findViewById(e.g.promotion_head_img);
        this.cZW = (TextView) view.findViewById(e.g.promotion_name);
        this.cZX = (TextView) view.findViewById(e.g.promotion_desc);
        this.cZY = (TbImageView) view.findViewById(e.g.promotion_img);
        this.cZZ = (TextView) view.findViewById(e.g.promotion_icon);
        this.cYU = view.findViewById(e.g.top_line);
        this.cZV.setOnClickListener(this);
        this.cZW.setOnClickListener(this);
        this.cZZ.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.cZV.setDefaultResource(17170445);
        this.cZV.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cZV.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cZV.setRadius(this.dab);
        this.cZY.setDrawBorder(true);
        this.cZY.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.cZV || view == this.cZW || view == this.cZZ) && !StringUtils.isNull(this.daa.dcv)) {
            TiebaStatic.log(new am(this.dac).aB(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.daa.dcs)));
            ay.Es().c(getTbPageContext(), new String[]{this.daa.dcv});
        } else if ((view == this.mRootView || view == this.cZX || view == this.cZY) && !StringUtils.isNull(this.daa.dcy)) {
            TiebaStatic.log(new am(this.dad).aB(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.daa.dcs)));
            ay.Es().c(getTbPageContext(), new String[]{this.daa.dcy});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, e.f.addresslist_item_bg);
            al.i(this.cZZ, e.f.label_bg_gray);
            al.i(this.cYU, e.d.cp_bg_line_b);
            al.c(this.cZW, e.d.cp_cont_b, 1);
            al.c(this.cZZ, e.d.cp_cont_d, 1);
            al.c(this.cZX, e.d.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.daa = oVar;
        this.cZV.startLoad(oVar.dct, 10, false);
        this.cZW.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.dcA)) {
            this.cZZ.setVisibility(8);
        } else {
            this.cZZ.setVisibility(0);
            this.cZZ.setText(oVar.dcA);
        }
        this.cZX.setText(oVar.dcw);
        if (com.baidu.tbadk.core.i.xR().xV()) {
            this.cZY.setVisibility(0);
            this.cZY.startLoad(oVar.dcx, 10, false);
            return;
        }
        this.cZY.setVisibility(8);
    }
}
