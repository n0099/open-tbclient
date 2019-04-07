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
    private View eiu;
    private String eiw;
    private o ejA;
    private int ejB;
    private String ejC;
    private String ejD;
    private HeadImageView ejv;
    private TextView ejw;
    private TextView ejx;
    private TbImageView ejy;
    private TextView ejz;
    private View mRootView;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ejB = tbPageContext.getResources().getDimensionPixelSize(d.e.ds70);
        init(getView());
    }

    public void Q(String str, String str2, String str3) {
        this.eiw = str;
        this.ejC = str2;
        this.ejD = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.root_view);
        this.ejv = (HeadImageView) view.findViewById(d.g.promotion_head_img);
        this.ejw = (TextView) view.findViewById(d.g.promotion_name);
        this.ejx = (TextView) view.findViewById(d.g.promotion_desc);
        this.ejy = (TbImageView) view.findViewById(d.g.promotion_img);
        this.ejz = (TextView) view.findViewById(d.g.promotion_icon);
        this.eiu = view.findViewById(d.g.top_line);
        this.ejv.setOnClickListener(this);
        this.ejw.setOnClickListener(this);
        this.ejz.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.ejv.setDefaultResource(17170445);
        this.ejv.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.ejv.setRadius(this.ejB);
        this.ejy.setDrawBorder(true);
        this.ejy.setBorderWidth(1);
        this.ejy.setDefaultBgResource(com.baidu.tbadk.util.e.get());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.ejv || view == this.ejw || view == this.ejz) && !StringUtils.isNull(this.ejA.eme)) {
            TiebaStatic.log(new am(this.ejC).bJ(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.ejA.emc)));
            ba.adA().c(getTbPageContext(), new String[]{this.ejA.eme});
        } else if ((view == this.mRootView || view == this.ejx || view == this.ejy) && !StringUtils.isNull(this.ejA.emh)) {
            TiebaStatic.log(new am(this.ejD).bJ(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.ejA.emc)));
            ba.adA().c(getTbPageContext(), new String[]{this.ejA.emh});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.mRootView, d.f.addresslist_item_bg);
            al.k(this.ejz, d.f.label_bg_gray);
            al.k(this.eiu, d.C0277d.cp_bg_line_b);
            al.d(this.ejw, d.C0277d.cp_cont_b, 1);
            al.d(this.ejz, d.C0277d.cp_cont_d, 1);
            al.d(this.ejx, d.C0277d.cp_cont_b, 1);
            this.ejv.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.ejy.setDefaultBgResource(com.baidu.tbadk.util.e.get());
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
        this.ejA = oVar;
        this.ejv.startLoad(oVar.emd, 10, false);
        this.ejw.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.emj)) {
            this.ejz.setVisibility(8);
        } else {
            this.ejz.setVisibility(0);
            this.ejz.setText(oVar.emj);
        }
        this.ejx.setText(oVar.emf);
        if (com.baidu.tbadk.core.i.Wv().Wz()) {
            this.ejy.setVisibility(0);
            this.ejy.startLoad(oVar.emg, 10, false);
            return;
        }
        this.ejy.setVisibility(8);
    }
}
