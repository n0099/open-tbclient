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
    private View eiI;
    private String eiK;
    private HeadImageView ejJ;
    private TextView ejK;
    private TextView ejL;
    private TbImageView ejM;
    private TextView ejN;
    private o ejO;
    private int ejP;
    private String ejQ;
    private String ejR;
    private View mRootView;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ejP = tbPageContext.getResources().getDimensionPixelSize(d.e.ds70);
        init(getView());
    }

    public void Q(String str, String str2, String str3) {
        this.eiK = str;
        this.ejQ = str2;
        this.ejR = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.root_view);
        this.ejJ = (HeadImageView) view.findViewById(d.g.promotion_head_img);
        this.ejK = (TextView) view.findViewById(d.g.promotion_name);
        this.ejL = (TextView) view.findViewById(d.g.promotion_desc);
        this.ejM = (TbImageView) view.findViewById(d.g.promotion_img);
        this.ejN = (TextView) view.findViewById(d.g.promotion_icon);
        this.eiI = view.findViewById(d.g.top_line);
        this.ejJ.setOnClickListener(this);
        this.ejK.setOnClickListener(this);
        this.ejN.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.ejJ.setDefaultResource(17170445);
        this.ejJ.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.ejJ.setRadius(this.ejP);
        this.ejM.setDrawBorder(true);
        this.ejM.setBorderWidth(1);
        this.ejM.setDefaultBgResource(com.baidu.tbadk.util.e.get());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.ejJ || view == this.ejK || view == this.ejN) && !StringUtils.isNull(this.ejO.ems)) {
            TiebaStatic.log(new am(this.ejQ).bJ(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.ejO.emq)));
            ba.adD().c(getTbPageContext(), new String[]{this.ejO.ems});
        } else if ((view == this.mRootView || view == this.ejL || view == this.ejM) && !StringUtils.isNull(this.ejO.emv)) {
            TiebaStatic.log(new am(this.ejR).bJ(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.ejO.emq)));
            ba.adD().c(getTbPageContext(), new String[]{this.ejO.emv});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.mRootView, d.f.addresslist_item_bg);
            al.k(this.ejN, d.f.label_bg_gray);
            al.k(this.eiI, d.C0277d.cp_bg_line_b);
            al.d(this.ejK, d.C0277d.cp_cont_b, 1);
            al.d(this.ejN, d.C0277d.cp_cont_d, 1);
            al.d(this.ejL, d.C0277d.cp_cont_b, 1);
            this.ejJ.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.ejM.setDefaultBgResource(com.baidu.tbadk.util.e.get());
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
        this.ejO = oVar;
        this.ejJ.startLoad(oVar.emr, 10, false);
        this.ejK.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.emx)) {
            this.ejN.setVisibility(8);
        } else {
            this.ejN.setVisibility(0);
            this.ejN.setText(oVar.emx);
        }
        this.ejL.setText(oVar.emt);
        if (com.baidu.tbadk.core.i.Wy().WC()) {
            this.ejM.setVisibility(0);
            this.ejM.startLoad(oVar.emu, 10, false);
            return;
        }
        this.ejM.setVisibility(8);
    }
}
