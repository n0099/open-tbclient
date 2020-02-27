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
    private View fKh;
    private String fKk;
    private HeadImageView fLi;
    private TextView fLj;
    private TextView fLk;
    private TbImageView fLl;
    private TextView fLm;
    private com.baidu.tieba.card.data.o fLn;
    private int fLo;
    private String fLp;
    private String fLq;
    private View mRootView;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fLo = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void ai(String str, String str2, String str3) {
        this.fKk = str;
        this.fLp = str2;
        this.fLq = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.fLi = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.fLj = (TextView) view.findViewById(R.id.promotion_name);
        this.fLk = (TextView) view.findViewById(R.id.promotion_desc);
        this.fLl = (TbImageView) view.findViewById(R.id.promotion_img);
        this.fLm = (TextView) view.findViewById(R.id.promotion_icon);
        this.fKh = view.findViewById(R.id.top_line);
        this.fLi.setOnClickListener(this);
        this.fLj.setOnClickListener(this);
        this.fLm.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.fLi.setDefaultResource(17170445);
        this.fLi.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fLi.setPlaceHolder(1);
        this.fLi.setRadius(this.fLo);
        this.fLl.setDrawBorder(true);
        this.fLl.setBorderWidth(1);
        this.fLl.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.fLi || view == this.fLj || view == this.fLm) && !StringUtils.isNull(this.fLn.fNV)) {
            TiebaStatic.log(new an(this.fLp).cy("obj_id", String.valueOf(this.fLn.fNT)));
            ba.aGE().b(getTbPageContext(), new String[]{this.fLn.fNV});
        } else if ((view == this.mRootView || view == this.fLk || view == this.fLl) && !StringUtils.isNull(this.fLn.fNY)) {
            TiebaStatic.log(new an(this.fLq).cy("obj_id", String.valueOf(this.fLn.fNT)));
            ba.aGE().b(getTbPageContext(), new String[]{this.fLn.fNY});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.fLm, R.drawable.label_bg_gray);
            am.setBackgroundResource(this.fKh, R.color.cp_bg_line_c);
            am.setViewTextColor(this.fLj, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fLm, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fLk, R.color.cp_cont_b, 1);
            this.fLi.setPlaceHolder(1);
            this.fLl.setPlaceHolder(2);
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
        this.fLn = oVar;
        this.fLi.startLoad(oVar.fNU, 10, false);
        this.fLj.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.fOa)) {
            this.fLm.setVisibility(8);
        } else {
            this.fLm.setVisibility(0);
            this.fLm.setText(oVar.fOa);
        }
        this.fLk.setText(oVar.fNW);
        if (com.baidu.tbadk.core.i.azM().isShowImages()) {
            this.fLl.setVisibility(0);
            this.fLl.startLoad(oVar.fNX, 10, false);
            return;
        }
        this.fLl.setVisibility(8);
    }
}
