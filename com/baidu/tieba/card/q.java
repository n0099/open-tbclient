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
/* loaded from: classes6.dex */
public class q extends a<com.baidu.tieba.card.data.o> {
    private View fEA;
    private String fED;
    private HeadImageView fFB;
    private TextView fFC;
    private TextView fFD;
    private TbImageView fFE;
    private TextView fFF;
    private com.baidu.tieba.card.data.o fFG;
    private int fFH;
    private String fFI;
    private String fFJ;
    private View mRootView;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fFH = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void ah(String str, String str2, String str3) {
        this.fED = str;
        this.fFI = str2;
        this.fFJ = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.fFB = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.fFC = (TextView) view.findViewById(R.id.promotion_name);
        this.fFD = (TextView) view.findViewById(R.id.promotion_desc);
        this.fFE = (TbImageView) view.findViewById(R.id.promotion_img);
        this.fFF = (TextView) view.findViewById(R.id.promotion_icon);
        this.fEA = view.findViewById(R.id.top_line);
        this.fFB.setOnClickListener(this);
        this.fFC.setOnClickListener(this);
        this.fFF.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.fFB.setDefaultResource(17170445);
        this.fFB.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fFB.setPlaceHolder(1);
        this.fFB.setRadius(this.fFH);
        this.fFE.setDrawBorder(true);
        this.fFE.setBorderWidth(1);
        this.fFE.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.fFB || view == this.fFC || view == this.fFF) && !StringUtils.isNull(this.fFG.fIp)) {
            TiebaStatic.log(new an(this.fFI).cp("obj_id", String.valueOf(this.fFG.fIn)));
            ba.aEa().b(getTbPageContext(), new String[]{this.fFG.fIp});
        } else if ((view == this.mRootView || view == this.fFD || view == this.fFE) && !StringUtils.isNull(this.fFG.fIs)) {
            TiebaStatic.log(new an(this.fFJ).cp("obj_id", String.valueOf(this.fFG.fIn)));
            ba.aEa().b(getTbPageContext(), new String[]{this.fFG.fIs});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.fFF, R.drawable.label_bg_gray);
            am.setBackgroundResource(this.fEA, R.color.cp_bg_line_c);
            am.setViewTextColor(this.fFC, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fFF, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fFD, R.color.cp_cont_b, 1);
            this.fFB.setPlaceHolder(1);
            this.fFE.setPlaceHolder(2);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_promotion_item;
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
        this.fFG = oVar;
        this.fFB.startLoad(oVar.fIo, 10, false);
        this.fFC.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.fIu)) {
            this.fFF.setVisibility(8);
        } else {
            this.fFF.setVisibility(0);
            this.fFF.setText(oVar.fIu);
        }
        this.fFD.setText(oVar.fIq);
        if (com.baidu.tbadk.core.i.axf().isShowImages()) {
            this.fFE.setVisibility(0);
            this.fFE.startLoad(oVar.fIr, 10, false);
            return;
        }
        this.fFE.setVisibility(8);
    }
}
