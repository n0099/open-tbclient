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
    private View hkj;
    private String hkm;
    private HeadImageView hln;
    private TextView hlo;
    private TextView hlp;
    private TbImageView hlq;
    private TextView hlr;
    private com.baidu.tieba.card.data.p hls;
    private int hlt;
    private String hlu;
    private String hlv;
    private View mRootView;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hlt = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void an(String str, String str2, String str3) {
        this.hkm = str;
        this.hlu = str2;
        this.hlv = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.hln = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.hlo = (TextView) view.findViewById(R.id.promotion_name);
        this.hlp = (TextView) view.findViewById(R.id.promotion_desc);
        this.hlq = (TbImageView) view.findViewById(R.id.promotion_img);
        this.hlr = (TextView) view.findViewById(R.id.promotion_icon);
        this.hkj = view.findViewById(R.id.top_line);
        this.hln.setOnClickListener(this);
        this.hlo.setOnClickListener(this);
        this.hlr.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.hln.setDefaultResource(17170445);
        this.hln.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hln.setPlaceHolder(1);
        this.hln.setRadius(this.hlt);
        this.hlq.setDrawBorder(true);
        this.hlq.setBorderWidth(1);
        this.hlq.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.hln || view == this.hlo || view == this.hlr) && !StringUtils.isNull(this.hls.hoa)) {
            TiebaStatic.log(new aq(this.hlu).dD("obj_id", String.valueOf(this.hls.hnY)));
            be.bju().b(getTbPageContext(), new String[]{this.hls.hoa});
        } else if ((view == this.mRootView || view == this.hlp || view == this.hlq) && !StringUtils.isNull(this.hls.hod)) {
            TiebaStatic.log(new aq(this.hlv).dD("obj_id", String.valueOf(this.hls.hnY)));
            be.bju().b(getTbPageContext(), new String[]{this.hls.hod});
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.hlr, R.drawable.label_bg_gray);
            ap.setBackgroundResource(this.hkj, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.hlo, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hlr, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hlp, R.color.cp_cont_b, 1);
            this.hln.setPlaceHolder(1);
            this.hlq.setPlaceHolder(2);
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
        this.hls = pVar;
        this.hln.startLoad(pVar.hnZ, 10, false);
        this.hlo.setText(UtilHelper.getFixedText(pVar.userName, 7, true));
        if (StringUtils.isNull(pVar.hof)) {
            this.hlr.setVisibility(8);
        } else {
            this.hlr.setVisibility(0);
            this.hlr.setText(pVar.hof);
        }
        this.hlp.setText(pVar.hob);
        if (com.baidu.tbadk.core.k.bbM().isShowImages()) {
            this.hlq.setVisibility(0);
            this.hlq.startLoad(pVar.hoc, 10, false);
            return;
        }
        this.hlq.setVisibility(8);
    }
}
