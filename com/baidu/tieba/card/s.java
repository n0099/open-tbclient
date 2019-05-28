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
    private View eyj;
    private String eyl;
    private HeadImageView ezl;
    private TextView ezm;
    private TextView ezn;
    private TbImageView ezo;
    private TextView ezp;
    private o ezq;
    private int ezr;
    private String ezs;
    private String ezt;
    private View mRootView;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ezr = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void Q(String str, String str2, String str3) {
        this.eyl = str;
        this.ezs = str2;
        this.ezt = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.ezl = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.ezm = (TextView) view.findViewById(R.id.promotion_name);
        this.ezn = (TextView) view.findViewById(R.id.promotion_desc);
        this.ezo = (TbImageView) view.findViewById(R.id.promotion_img);
        this.ezp = (TextView) view.findViewById(R.id.promotion_icon);
        this.eyj = view.findViewById(R.id.top_line);
        this.ezl.setOnClickListener(this);
        this.ezm.setOnClickListener(this);
        this.ezp.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.ezl.setDefaultResource(17170445);
        this.ezl.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.ezl.setRadius(this.ezr);
        this.ezo.setDrawBorder(true);
        this.ezo.setBorderWidth(1);
        this.ezo.setDefaultBgResource(com.baidu.tbadk.util.e.get());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.ezl || view == this.ezm || view == this.ezp) && !StringUtils.isNull(this.ezq.eBT)) {
            TiebaStatic.log(new am(this.ezs).bT(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.ezq.eBR)));
            ba.aiz().c(getTbPageContext(), new String[]{this.ezq.eBT});
        } else if ((view == this.mRootView || view == this.ezn || view == this.ezo) && !StringUtils.isNull(this.ezq.eBW)) {
            TiebaStatic.log(new am(this.ezt).bT(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.ezq.eBR)));
            ba.aiz().c(getTbPageContext(), new String[]{this.ezq.eBW});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.mRootView, R.drawable.addresslist_item_bg);
            al.k(this.ezp, R.drawable.label_bg_gray);
            al.k(this.eyj, R.color.cp_bg_line_b);
            al.f(this.ezm, R.color.cp_cont_b, 1);
            al.f(this.ezp, R.color.cp_cont_d, 1);
            al.f(this.ezn, R.color.cp_cont_b, 1);
            this.ezl.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.ezo.setDefaultBgResource(com.baidu.tbadk.util.e.get());
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
        this.ezq = oVar;
        this.ezl.startLoad(oVar.eBS, 10, false);
        this.ezm.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.eBY)) {
            this.ezp.setVisibility(8);
        } else {
            this.ezp.setVisibility(0);
            this.ezp.setText(oVar.eBY);
        }
        this.ezn.setText(oVar.eBU);
        if (com.baidu.tbadk.core.i.abb().abf()) {
            this.ezo.setVisibility(0);
            this.ezo.startLoad(oVar.eBV, 10, false);
            return;
        }
        this.ezo.setVisibility(8);
    }
}
