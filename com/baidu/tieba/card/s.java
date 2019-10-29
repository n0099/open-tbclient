package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.o;
/* loaded from: classes4.dex */
public class s extends a<o> {
    private View eND;
    private String eNG;
    private HeadImageView eOF;
    private TextView eOG;
    private TextView eOH;
    private TbImageView eOI;
    private TextView eOJ;
    private o eOK;
    private int eOL;
    private String eOM;
    private String eON;
    private View mRootView;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eOL = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void T(String str, String str2, String str3) {
        this.eNG = str;
        this.eOM = str2;
        this.eON = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.eOF = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.eOG = (TextView) view.findViewById(R.id.promotion_name);
        this.eOH = (TextView) view.findViewById(R.id.promotion_desc);
        this.eOI = (TbImageView) view.findViewById(R.id.promotion_img);
        this.eOJ = (TextView) view.findViewById(R.id.promotion_icon);
        this.eND = view.findViewById(R.id.top_line);
        this.eOF.setOnClickListener(this);
        this.eOG.setOnClickListener(this);
        this.eOJ.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.eOF.setDefaultResource(17170445);
        this.eOF.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eOF.setRadius(this.eOL);
        this.eOI.setDrawBorder(true);
        this.eOI.setBorderWidth(1);
        this.eOI.setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.eOF || view == this.eOG || view == this.eOJ) && !StringUtils.isNull(this.eOK.eRk)) {
            TiebaStatic.log(new an(this.eOM).bS("obj_id", String.valueOf(this.eOK.eRi)));
            ba.amQ().b(getTbPageContext(), new String[]{this.eOK.eRk});
        } else if ((view == this.mRootView || view == this.eOH || view == this.eOI) && !StringUtils.isNull(this.eOK.eRn)) {
            TiebaStatic.log(new an(this.eON).bS("obj_id", String.valueOf(this.eOK.eRi)));
            ba.amQ().b(getTbPageContext(), new String[]{this.eOK.eRn});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.eOJ, R.drawable.label_bg_gray);
            am.setBackgroundResource(this.eND, R.color.cp_bg_line_c);
            am.setViewTextColor(this.eOG, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.eOJ, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.eOH, R.color.cp_cont_b, 1);
            this.eOF.setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
            this.eOI.setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
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
        this.eOK = oVar;
        this.eOF.startLoad(oVar.eRj, 10, false);
        this.eOG.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.eRp)) {
            this.eOJ.setVisibility(8);
        } else {
            this.eOJ.setVisibility(0);
            this.eOJ.setText(oVar.eRp);
        }
        this.eOH.setText(oVar.eRl);
        if (com.baidu.tbadk.core.i.agq().isShowImages()) {
            this.eOI.setVisibility(0);
            this.eOI.startLoad(oVar.eRm, 10, false);
            return;
        }
        this.eOI.setVisibility(8);
    }
}
