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
/* loaded from: classes21.dex */
public class r extends b<com.baidu.tieba.card.data.p> {
    private View hrm;
    private String hrp;
    private HeadImageView hsq;
    private TextView hsr;
    private TextView hss;
    private TbImageView hst;
    private TextView hsu;
    private com.baidu.tieba.card.data.p hsv;
    private int hsw;
    private String hsx;
    private String hsy;
    private View mRootView;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hsw = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void an(String str, String str2, String str3) {
        this.hrp = str;
        this.hsx = str2;
        this.hsy = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.hsq = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.hsr = (TextView) view.findViewById(R.id.promotion_name);
        this.hss = (TextView) view.findViewById(R.id.promotion_desc);
        this.hst = (TbImageView) view.findViewById(R.id.promotion_img);
        this.hsu = (TextView) view.findViewById(R.id.promotion_icon);
        this.hrm = view.findViewById(R.id.top_line);
        this.hsq.setOnClickListener(this);
        this.hsr.setOnClickListener(this);
        this.hsu.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.hsq.setDefaultResource(17170445);
        this.hsq.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hsq.setPlaceHolder(1);
        this.hsq.setRadius(this.hsw);
        this.hst.setDrawBorder(true);
        this.hst.setBorderWidth(1);
        this.hst.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.hsq || view == this.hsr || view == this.hsu) && !StringUtils.isNull(this.hsv.hve)) {
            TiebaStatic.log(new aq(this.hsx).dF("obj_id", String.valueOf(this.hsv.hvc)));
            be.bkp().b(getTbPageContext(), new String[]{this.hsv.hve});
        } else if ((view == this.mRootView || view == this.hss || view == this.hst) && !StringUtils.isNull(this.hsv.hvh)) {
            TiebaStatic.log(new aq(this.hsy).dF("obj_id", String.valueOf(this.hsv.hvc)));
            be.bkp().b(getTbPageContext(), new String[]{this.hsv.hvh});
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.hsu, R.drawable.label_bg_gray);
            ap.setBackgroundResource(this.hrm, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.hsr, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hsu, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hss, R.color.cp_cont_b, 1);
            this.hsq.setPlaceHolder(1);
            this.hst.setPlaceHolder(2);
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
        this.hsv = pVar;
        this.hsq.startLoad(pVar.hvd, 10, false);
        this.hsr.setText(UtilHelper.getFixedText(pVar.userName, 7, true));
        if (StringUtils.isNull(pVar.hvj)) {
            this.hsu.setVisibility(8);
        } else {
            this.hsu.setVisibility(0);
            this.hsu.setText(pVar.hvj);
        }
        this.hss.setText(pVar.hvf);
        if (com.baidu.tbadk.core.k.bcG().isShowImages()) {
            this.hst.setVisibility(0);
            this.hst.startLoad(pVar.hvg, 10, false);
            return;
        }
        this.hst.setVisibility(8);
    }
}
