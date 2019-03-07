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
import com.baidu.tbadk.util.e;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.o;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class s extends a<o> {
    private View eiM;
    private String eiO;
    private HeadImageView ejN;
    private TextView ejO;
    private TextView ejP;
    private TbImageView ejQ;
    private TextView ejR;
    private o ejS;
    private int ejT;
    private String ejU;
    private String ejV;
    private View mRootView;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ejT = tbPageContext.getResources().getDimensionPixelSize(d.e.ds70);
        init(getView());
    }

    public void Q(String str, String str2, String str3) {
        this.eiO = str;
        this.ejU = str2;
        this.ejV = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.root_view);
        this.ejN = (HeadImageView) view.findViewById(d.g.promotion_head_img);
        this.ejO = (TextView) view.findViewById(d.g.promotion_name);
        this.ejP = (TextView) view.findViewById(d.g.promotion_desc);
        this.ejQ = (TbImageView) view.findViewById(d.g.promotion_img);
        this.ejR = (TextView) view.findViewById(d.g.promotion_icon);
        this.eiM = view.findViewById(d.g.top_line);
        this.ejN.setOnClickListener(this);
        this.ejO.setOnClickListener(this);
        this.ejR.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.ejN.setDefaultResource(17170445);
        this.ejN.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.ejN.setRadius(this.ejT);
        this.ejQ.setDrawBorder(true);
        this.ejQ.setBorderWidth(1);
        this.ejQ.setDefaultBgResource(e.get());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.ejN || view == this.ejO || view == this.ejR) && !StringUtils.isNull(this.ejS.emw)) {
            TiebaStatic.log(new am(this.ejU).bJ(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.ejS.emu)));
            ba.adD().c(getTbPageContext(), new String[]{this.ejS.emw});
        } else if ((view == this.mRootView || view == this.ejP || view == this.ejQ) && !StringUtils.isNull(this.ejS.emz)) {
            TiebaStatic.log(new am(this.ejV).bJ(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.ejS.emu)));
            ba.adD().c(getTbPageContext(), new String[]{this.ejS.emz});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.mRootView, d.f.addresslist_item_bg);
            al.k(this.ejR, d.f.label_bg_gray);
            al.k(this.eiM, d.C0236d.cp_bg_line_b);
            al.d(this.ejO, d.C0236d.cp_cont_b, 1);
            al.d(this.ejR, d.C0236d.cp_cont_d, 1);
            al.d(this.ejP, d.C0236d.cp_cont_b, 1);
            this.ejN.setDefaultBgResource(e.get());
            this.ejQ.setDefaultBgResource(e.get());
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
        this.ejS = oVar;
        this.ejN.startLoad(oVar.emv, 10, false);
        this.ejO.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.emB)) {
            this.ejR.setVisibility(8);
        } else {
            this.ejR.setVisibility(0);
            this.ejR.setText(oVar.emB);
        }
        this.ejP.setText(oVar.emx);
        if (com.baidu.tbadk.core.i.Wy().WC()) {
            this.ejQ.setVisibility(0);
            this.ejQ.startLoad(oVar.emy, 10, false);
            return;
        }
        this.ejQ.setVisibility(8);
    }
}
