package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class r extends b<com.baidu.tieba.card.data.o> {
    private View gXm;
    private String gXp;
    private HeadImageView gYq;
    private TextView gYr;
    private TextView gYs;
    private TbImageView gYt;
    private TextView gYu;
    private com.baidu.tieba.card.data.o gYv;
    private int gYw;
    private String gYx;
    private String gYy;
    private View mRootView;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gYw = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void an(String str, String str2, String str3) {
        this.gXp = str;
        this.gYx = str2;
        this.gYy = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.gYq = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.gYr = (TextView) view.findViewById(R.id.promotion_name);
        this.gYs = (TextView) view.findViewById(R.id.promotion_desc);
        this.gYt = (TbImageView) view.findViewById(R.id.promotion_img);
        this.gYu = (TextView) view.findViewById(R.id.promotion_icon);
        this.gXm = view.findViewById(R.id.top_line);
        this.gYq.setOnClickListener(this);
        this.gYr.setOnClickListener(this);
        this.gYu.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.gYq.setDefaultResource(17170445);
        this.gYq.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gYq.setPlaceHolder(1);
        this.gYq.setRadius(this.gYw);
        this.gYt.setDrawBorder(true);
        this.gYt.setBorderWidth(1);
        this.gYt.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.gYq || view == this.gYr || view == this.gYu) && !StringUtils.isNull(this.gYv.hbf)) {
            TiebaStatic.log(new ap(this.gYx).dn("obj_id", String.valueOf(this.gYv.hbd)));
            bd.baV().b(getTbPageContext(), new String[]{this.gYv.hbf});
        } else if ((view == this.mRootView || view == this.gYs || view == this.gYt) && !StringUtils.isNull(this.gYv.hbi)) {
            TiebaStatic.log(new ap(this.gYy).dn("obj_id", String.valueOf(this.gYv.hbd)));
            bd.baV().b(getTbPageContext(), new String[]{this.gYv.hbi});
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            ao.setBackgroundResource(this.gYu, R.drawable.label_bg_gray);
            ao.setBackgroundResource(this.gXm, R.color.cp_bg_line_c);
            ao.setViewTextColor(this.gYr, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.gYu, R.color.cp_cont_d, 1);
            ao.setViewTextColor(this.gYs, R.color.cp_cont_b, 1);
            this.gYq.setPlaceHolder(1);
            this.gYt.setPlaceHolder(2);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.gYv = oVar;
        this.gYq.startLoad(oVar.hbe, 10, false);
        this.gYr.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.hbk)) {
            this.gYu.setVisibility(8);
        } else {
            this.gYu.setVisibility(0);
            this.gYu.setText(oVar.hbk);
        }
        this.gYs.setText(oVar.hbg);
        if (com.baidu.tbadk.core.k.aTv().isShowImages()) {
            this.gYt.setVisibility(0);
            this.gYt.startLoad(oVar.hbh, 10, false);
            return;
        }
        this.gYt.setVisibility(8);
    }
}
