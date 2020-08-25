package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class r extends b<com.baidu.tieba.card.data.p> {
    private View hkf;
    private String hki;
    private HeadImageView hlj;
    private TextView hlk;
    private TextView hll;
    private TbImageView hlm;
    private TextView hln;
    private com.baidu.tieba.card.data.p hlo;
    private int hlp;
    private String hlq;
    private String hlr;
    private View mRootView;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hlp = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void an(String str, String str2, String str3) {
        this.hki = str;
        this.hlq = str2;
        this.hlr = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.hlj = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.hlk = (TextView) view.findViewById(R.id.promotion_name);
        this.hll = (TextView) view.findViewById(R.id.promotion_desc);
        this.hlm = (TbImageView) view.findViewById(R.id.promotion_img);
        this.hln = (TextView) view.findViewById(R.id.promotion_icon);
        this.hkf = view.findViewById(R.id.top_line);
        this.hlj.setOnClickListener(this);
        this.hlk.setOnClickListener(this);
        this.hln.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.hlj.setDefaultResource(17170445);
        this.hlj.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hlj.setPlaceHolder(1);
        this.hlj.setRadius(this.hlp);
        this.hlm.setDrawBorder(true);
        this.hlm.setBorderWidth(1);
        this.hlm.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.hlj || view == this.hlk || view == this.hln) && !StringUtils.isNull(this.hlo.hnW)) {
            TiebaStatic.log(new aq(this.hlq).dD("obj_id", String.valueOf(this.hlo.hnU)));
            be.bju().b(getTbPageContext(), new String[]{this.hlo.hnW});
        } else if ((view == this.mRootView || view == this.hll || view == this.hlm) && !StringUtils.isNull(this.hlo.hnZ)) {
            TiebaStatic.log(new aq(this.hlr).dD("obj_id", String.valueOf(this.hlo.hnU)));
            be.bju().b(getTbPageContext(), new String[]{this.hlo.hnZ});
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.hln, R.drawable.label_bg_gray);
            ap.setBackgroundResource(this.hkf, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.hlk, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hln, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hll, R.color.cp_cont_b, 1);
            this.hlj.setPlaceHolder(1);
            this.hlm.setPlaceHolder(2);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.p pVar) {
        if (pVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.hlo = pVar;
        this.hlj.startLoad(pVar.hnV, 10, false);
        this.hlk.setText(UtilHelper.getFixedText(pVar.userName, 7, true));
        if (StringUtils.isNull(pVar.hob)) {
            this.hln.setVisibility(8);
        } else {
            this.hln.setVisibility(0);
            this.hln.setText(pVar.hob);
        }
        this.hll.setText(pVar.hnX);
        if (com.baidu.tbadk.core.k.bbM().isShowImages()) {
            this.hlm.setVisibility(0);
            this.hlm.startLoad(pVar.hnY, 10, false);
            return;
        }
        this.hlm.setVisibility(8);
    }
}
