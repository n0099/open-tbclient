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
    private View fKj;
    private String fKm;
    private HeadImageView fLk;
    private TextView fLl;
    private TextView fLm;
    private TbImageView fLn;
    private TextView fLo;
    private com.baidu.tieba.card.data.o fLp;
    private int fLq;
    private String fLr;
    private String fLs;
    private View mRootView;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fLq = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void ai(String str, String str2, String str3) {
        this.fKm = str;
        this.fLr = str2;
        this.fLs = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.fLk = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.fLl = (TextView) view.findViewById(R.id.promotion_name);
        this.fLm = (TextView) view.findViewById(R.id.promotion_desc);
        this.fLn = (TbImageView) view.findViewById(R.id.promotion_img);
        this.fLo = (TextView) view.findViewById(R.id.promotion_icon);
        this.fKj = view.findViewById(R.id.top_line);
        this.fLk.setOnClickListener(this);
        this.fLl.setOnClickListener(this);
        this.fLo.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.fLk.setDefaultResource(17170445);
        this.fLk.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fLk.setPlaceHolder(1);
        this.fLk.setRadius(this.fLq);
        this.fLn.setDrawBorder(true);
        this.fLn.setBorderWidth(1);
        this.fLn.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.fLk || view == this.fLl || view == this.fLo) && !StringUtils.isNull(this.fLp.fNX)) {
            TiebaStatic.log(new an(this.fLr).cy("obj_id", String.valueOf(this.fLp.fNV)));
            ba.aGG().b(getTbPageContext(), new String[]{this.fLp.fNX});
        } else if ((view == this.mRootView || view == this.fLm || view == this.fLn) && !StringUtils.isNull(this.fLp.fOa)) {
            TiebaStatic.log(new an(this.fLs).cy("obj_id", String.valueOf(this.fLp.fNV)));
            ba.aGG().b(getTbPageContext(), new String[]{this.fLp.fOa});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.fLo, R.drawable.label_bg_gray);
            am.setBackgroundResource(this.fKj, R.color.cp_bg_line_c);
            am.setViewTextColor(this.fLl, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fLo, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fLm, R.color.cp_cont_b, 1);
            this.fLk.setPlaceHolder(1);
            this.fLn.setPlaceHolder(2);
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
        this.fLp = oVar;
        this.fLk.startLoad(oVar.fNW, 10, false);
        this.fLl.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.fOc)) {
            this.fLo.setVisibility(8);
        } else {
            this.fLo.setVisibility(0);
            this.fLo.setText(oVar.fOc);
        }
        this.fLm.setText(oVar.fNY);
        if (com.baidu.tbadk.core.i.azO().isShowImages()) {
            this.fLn.setVisibility(0);
            this.fLn.startLoad(oVar.fNZ, 10, false);
            return;
        }
        this.fLn.setVisibility(8);
    }
}
