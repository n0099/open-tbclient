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
/* loaded from: classes22.dex */
public class r extends b<com.baidu.tieba.card.data.p> {
    private View hGg;
    private String hGj;
    private HeadImageView hHk;
    private TextView hHl;
    private TextView hHm;
    private TbImageView hHn;
    private TextView hHo;
    private com.baidu.tieba.card.data.p hHp;
    private int hHq;
    private String hHr;
    private String hHs;
    private View mRootView;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hHq = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void ap(String str, String str2, String str3) {
        this.hGj = str;
        this.hHr = str2;
        this.hHs = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.hHk = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.hHl = (TextView) view.findViewById(R.id.promotion_name);
        this.hHm = (TextView) view.findViewById(R.id.promotion_desc);
        this.hHn = (TbImageView) view.findViewById(R.id.promotion_img);
        this.hHo = (TextView) view.findViewById(R.id.promotion_icon);
        this.hGg = view.findViewById(R.id.top_line);
        this.hHk.setOnClickListener(this);
        this.hHl.setOnClickListener(this);
        this.hHo.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.hHk.setDefaultResource(17170445);
        this.hHk.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hHk.setPlaceHolder(1);
        this.hHk.setRadius(this.hHq);
        this.hHn.setDrawBorder(true);
        this.hHn.setBorderWidth(1);
        this.hHn.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.hHk || view == this.hHl || view == this.hHo) && !StringUtils.isNull(this.hHp.hJZ)) {
            TiebaStatic.log(new aq(this.hHr).dK("obj_id", String.valueOf(this.hHp.hJX)));
            be.bmY().b(getTbPageContext(), new String[]{this.hHp.hJZ});
        } else if ((view == this.mRootView || view == this.hHm || view == this.hHn) && !StringUtils.isNull(this.hHp.hKc)) {
            TiebaStatic.log(new aq(this.hHs).dK("obj_id", String.valueOf(this.hHp.hJX)));
            be.bmY().b(getTbPageContext(), new String[]{this.hHp.hKc});
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.hHo, R.drawable.label_bg_gray);
            ap.setBackgroundResource(this.hGg, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.hHl, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hHo, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hHm, R.color.cp_cont_b, 1);
            this.hHk.setPlaceHolder(1);
            this.hHn.setPlaceHolder(2);
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
        this.hHp = pVar;
        this.hHk.startLoad(pVar.hJY, 10, false);
        this.hHl.setText(UtilHelper.getFixedText(pVar.userName, 7, true));
        if (StringUtils.isNull(pVar.hKe)) {
            this.hHo.setVisibility(8);
        } else {
            this.hHo.setVisibility(0);
            this.hHo.setText(pVar.hKe);
        }
        this.hHm.setText(pVar.hKa);
        if (com.baidu.tbadk.core.k.bfo().isShowImages()) {
            this.hHn.setVisibility(0);
            this.hHn.startLoad(pVar.hKb, 10, false);
            return;
        }
        this.hHn.setVisibility(8);
    }
}
