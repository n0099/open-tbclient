package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class u extends a<com.baidu.tieba.card.data.o> {
    private com.baidu.tieba.card.data.o cAA;
    private int cAB;
    private String cAC;
    private String cAD;
    private HeadImageView cAv;
    private TextView cAw;
    private TextView cAx;
    private TbImageView cAy;
    private TextView cAz;
    private View czu;
    private String czw;
    private View mRootView;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cAB = tbPageContext.getResources().getDimensionPixelSize(f.e.ds70);
        init(getView());
    }

    public void x(String str, String str2, String str3) {
        this.czw = str;
        this.cAC = str2;
        this.cAD = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(f.g.root_view);
        this.cAv = (HeadImageView) view.findViewById(f.g.promotion_head_img);
        this.cAw = (TextView) view.findViewById(f.g.promotion_name);
        this.cAx = (TextView) view.findViewById(f.g.promotion_desc);
        this.cAy = (TbImageView) view.findViewById(f.g.promotion_img);
        this.cAz = (TextView) view.findViewById(f.g.promotion_icon);
        this.czu = view.findViewById(f.g.top_line);
        this.cAv.setOnClickListener(this);
        this.cAw.setOnClickListener(this);
        this.cAz.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.cAv.setDefaultResource(17170445);
        this.cAv.setDefaultErrorResource(f.C0146f.icon_default_avatar100);
        this.cAv.setDefaultBgResource(f.d.cp_bg_line_e);
        this.cAv.setRadius(this.cAB);
        this.cAy.setDrawBorder(true);
        this.cAy.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.cAv || view == this.cAw || view == this.cAz) && !StringUtils.isNull(this.cAA.cCT)) {
            TiebaStatic.log(new an(this.cAC).ae(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.cAA.cCR)));
            az.zI().c(aiB(), new String[]{this.cAA.cCT});
        } else if ((view == this.mRootView || view == this.cAx || view == this.cAy) && !StringUtils.isNull(this.cAA.cCW)) {
            TiebaStatic.log(new an(this.cAD).ae(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.cAA.cCR)));
            az.zI().c(aiB(), new String[]{this.cAA.cCW});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.mRootView, f.C0146f.addresslist_item_bg);
            am.i(this.cAz, f.C0146f.label_bg_gray);
            am.i(this.czu, f.d.cp_bg_line_b);
            am.c(this.cAw, f.d.cp_cont_b, 1);
            am.c(this.cAz, f.d.cp_cont_d, 1);
            am.c(this.cAx, f.d.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_promotion_item;
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
        this.cAA = oVar;
        this.cAv.startLoad(oVar.cCS, 10, false);
        this.cAw.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.cCY)) {
            this.cAz.setVisibility(8);
        } else {
            this.cAz.setVisibility(0);
            this.cAz.setText(oVar.cCY);
        }
        this.cAx.setText(oVar.cCU);
        if (com.baidu.tbadk.core.i.td().tj()) {
            this.cAy.setVisibility(0);
            this.cAy.startLoad(oVar.cCV, 10, false);
            return;
        }
        this.cAy.setVisibility(8);
    }
}
