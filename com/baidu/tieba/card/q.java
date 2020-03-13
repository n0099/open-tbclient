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
/* loaded from: classes9.dex */
public class q extends a<com.baidu.tieba.card.data.o> {
    private View fKw;
    private String fKz;
    private TbImageView fLA;
    private TextView fLB;
    private com.baidu.tieba.card.data.o fLC;
    private int fLD;
    private String fLE;
    private String fLF;
    private HeadImageView fLx;
    private TextView fLy;
    private TextView fLz;
    private View mRootView;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fLD = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void ai(String str, String str2, String str3) {
        this.fKz = str;
        this.fLE = str2;
        this.fLF = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.fLx = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.fLy = (TextView) view.findViewById(R.id.promotion_name);
        this.fLz = (TextView) view.findViewById(R.id.promotion_desc);
        this.fLA = (TbImageView) view.findViewById(R.id.promotion_img);
        this.fLB = (TextView) view.findViewById(R.id.promotion_icon);
        this.fKw = view.findViewById(R.id.top_line);
        this.fLx.setOnClickListener(this);
        this.fLy.setOnClickListener(this);
        this.fLB.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.fLx.setDefaultResource(17170445);
        this.fLx.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fLx.setPlaceHolder(1);
        this.fLx.setRadius(this.fLD);
        this.fLA.setDrawBorder(true);
        this.fLA.setBorderWidth(1);
        this.fLA.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.fLx || view == this.fLy || view == this.fLB) && !StringUtils.isNull(this.fLC.fOk)) {
            TiebaStatic.log(new an(this.fLE).cy("obj_id", String.valueOf(this.fLC.fOi)));
            ba.aGG().b(getTbPageContext(), new String[]{this.fLC.fOk});
        } else if ((view == this.mRootView || view == this.fLz || view == this.fLA) && !StringUtils.isNull(this.fLC.fOn)) {
            TiebaStatic.log(new an(this.fLF).cy("obj_id", String.valueOf(this.fLC.fOi)));
            ba.aGG().b(getTbPageContext(), new String[]{this.fLC.fOn});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.fLB, R.drawable.label_bg_gray);
            am.setBackgroundResource(this.fKw, R.color.cp_bg_line_c);
            am.setViewTextColor(this.fLy, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fLB, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fLz, R.color.cp_cont_b, 1);
            this.fLx.setPlaceHolder(1);
            this.fLA.setPlaceHolder(2);
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
        this.fLC = oVar;
        this.fLx.startLoad(oVar.fOj, 10, false);
        this.fLy.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.fOp)) {
            this.fLB.setVisibility(8);
        } else {
            this.fLB.setVisibility(0);
            this.fLB.setText(oVar.fOp);
        }
        this.fLz.setText(oVar.fOl);
        if (com.baidu.tbadk.core.i.azO().isShowImages()) {
            this.fLA.setVisibility(0);
            this.fLA.startLoad(oVar.fOm, 10, false);
            return;
        }
        this.fLA.setVisibility(8);
    }
}
