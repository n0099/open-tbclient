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
    private View cYV;
    private String cYX;
    private HeadImageView cZW;
    private TextView cZX;
    private TextView cZY;
    private TbImageView cZZ;
    private TextView daa;
    private com.baidu.tieba.card.data.o dab;
    private int dac;
    private String dad;
    private String dae;
    private View mRootView;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dac = tbPageContext.getResources().getDimensionPixelSize(e.C0210e.ds70);
        init(getView());
    }

    public void F(String str, String str2, String str3) {
        this.cYX = str;
        this.dad = str2;
        this.dae = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(e.g.root_view);
        this.cZW = (HeadImageView) view.findViewById(e.g.promotion_head_img);
        this.cZX = (TextView) view.findViewById(e.g.promotion_name);
        this.cZY = (TextView) view.findViewById(e.g.promotion_desc);
        this.cZZ = (TbImageView) view.findViewById(e.g.promotion_img);
        this.daa = (TextView) view.findViewById(e.g.promotion_icon);
        this.cYV = view.findViewById(e.g.top_line);
        this.cZW.setOnClickListener(this);
        this.cZX.setOnClickListener(this);
        this.daa.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.cZW.setDefaultResource(17170445);
        this.cZW.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cZW.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cZW.setRadius(this.dac);
        this.cZZ.setDrawBorder(true);
        this.cZZ.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.cZW || view == this.cZX || view == this.daa) && !StringUtils.isNull(this.dab.dcw)) {
            TiebaStatic.log(new am(this.dad).aB(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.dab.dct)));
            ay.Es().c(getTbPageContext(), new String[]{this.dab.dcw});
        } else if ((view == this.mRootView || view == this.cZY || view == this.cZZ) && !StringUtils.isNull(this.dab.dcz)) {
            TiebaStatic.log(new am(this.dae).aB(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.dab.dct)));
            ay.Es().c(getTbPageContext(), new String[]{this.dab.dcz});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, e.f.addresslist_item_bg);
            al.i(this.daa, e.f.label_bg_gray);
            al.i(this.cYV, e.d.cp_bg_line_b);
            al.c(this.cZX, e.d.cp_cont_b, 1);
            al.c(this.daa, e.d.cp_cont_d, 1);
            al.c(this.cZY, e.d.cp_cont_b, 1);
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
        this.dab = oVar;
        this.cZW.startLoad(oVar.dcv, 10, false);
        this.cZX.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.dcB)) {
            this.daa.setVisibility(8);
        } else {
            this.daa.setVisibility(0);
            this.daa.setText(oVar.dcB);
        }
        this.cZY.setText(oVar.dcx);
        if (com.baidu.tbadk.core.i.xR().xV()) {
            this.cZZ.setVisibility(0);
            this.cZZ.startLoad(oVar.dcy, 10, false);
            return;
        }
        this.cZZ.setVisibility(8);
    }
}
