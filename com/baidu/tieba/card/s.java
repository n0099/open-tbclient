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
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.o;
/* loaded from: classes4.dex */
public class s extends a<o> {
    private View eyi;
    private String eyk;
    private HeadImageView ezk;
    private TextView ezl;
    private TextView ezm;
    private TbImageView ezn;
    private TextView ezo;
    private o ezp;
    private int ezq;
    private String ezr;
    private String ezs;
    private View mRootView;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ezq = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void Q(String str, String str2, String str3) {
        this.eyk = str;
        this.ezr = str2;
        this.ezs = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.ezk = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.ezl = (TextView) view.findViewById(R.id.promotion_name);
        this.ezm = (TextView) view.findViewById(R.id.promotion_desc);
        this.ezn = (TbImageView) view.findViewById(R.id.promotion_img);
        this.ezo = (TextView) view.findViewById(R.id.promotion_icon);
        this.eyi = view.findViewById(R.id.top_line);
        this.ezk.setOnClickListener(this);
        this.ezl.setOnClickListener(this);
        this.ezo.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.ezk.setDefaultResource(17170445);
        this.ezk.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.ezk.setRadius(this.ezq);
        this.ezn.setDrawBorder(true);
        this.ezn.setBorderWidth(1);
        this.ezn.setDefaultBgResource(com.baidu.tbadk.util.e.get());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.ezk || view == this.ezl || view == this.ezo) && !StringUtils.isNull(this.ezp.eBS)) {
            TiebaStatic.log(new am(this.ezr).bT(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.ezp.eBQ)));
            ba.aiz().c(getTbPageContext(), new String[]{this.ezp.eBS});
        } else if ((view == this.mRootView || view == this.ezm || view == this.ezn) && !StringUtils.isNull(this.ezp.eBV)) {
            TiebaStatic.log(new am(this.ezs).bT(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.ezp.eBQ)));
            ba.aiz().c(getTbPageContext(), new String[]{this.ezp.eBV});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.mRootView, R.drawable.addresslist_item_bg);
            al.k(this.ezo, R.drawable.label_bg_gray);
            al.k(this.eyi, R.color.cp_bg_line_b);
            al.f(this.ezl, R.color.cp_cont_b, 1);
            al.f(this.ezo, R.color.cp_cont_d, 1);
            al.f(this.ezm, R.color.cp_cont_b, 1);
            this.ezk.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.ezn.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_promotion_item;
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
        this.ezp = oVar;
        this.ezk.startLoad(oVar.eBR, 10, false);
        this.ezl.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.eBX)) {
            this.ezo.setVisibility(8);
        } else {
            this.ezo.setVisibility(0);
            this.ezo.setText(oVar.eBX);
        }
        this.ezm.setText(oVar.eBT);
        if (com.baidu.tbadk.core.i.abb().abf()) {
            this.ezn.setVisibility(0);
            this.ezn.startLoad(oVar.eBU, 10, false);
            return;
        }
        this.ezn.setVisibility(8);
    }
}
