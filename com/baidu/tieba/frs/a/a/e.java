package com.baidu.tieba.frs.a.a;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes3.dex */
public class e extends q.a {
    View.OnClickListener bZi;
    private RelativeLayout dtm;
    private LinearLayout dtn;
    private TbImageView dto;
    private TextView dtp;
    private TextView dtq;
    private TextView dtr;
    private TextView dts;
    private View dtt;
    private TextView dtu;
    private ImageView dtv;
    private View dtw;
    private TbPageContext mContext;
    private int mSkinType;
    private bh news_info;
    private be top_code;

    public e(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.bZi = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bb.aU(e.this.mContext.getPageActivity()) && l.jU()) {
                    if (view2 == e.this.dtm) {
                        if (e.this.top_code != null && !TextUtils.isEmpty(e.this.top_code.wV())) {
                            TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            az.zV().c((TbPageContext) i.ad(e.this.mContext.getPageActivity()), new String[]{e.this.top_code.wV()});
                        }
                    } else if (view2 == e.this.dtn && e.this.news_info != null && !TextUtils.isEmpty(e.this.news_info.xc())) {
                        TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        az.zV().c((TbPageContext) i.ad(e.this.mContext.getPageActivity()), new String[]{e.this.news_info.xc()});
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.dtm = (RelativeLayout) view.findViewById(d.g.u9_top_code);
        this.dtn = (LinearLayout) view.findViewById(d.g.u9_news_info);
        this.dto = (TbImageView) view.findViewById(d.g.top_code_img);
        this.dto.setPageId(bdUniqueId);
        this.dtp = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.dtq = (TextView) view.findViewById(d.g.top_code_detail_surplus_text);
        this.dtr = (TextView) view.findViewById(d.g.top_code_detail_giftworth_text);
        this.dts = (TextView) view.findViewById(d.g.top_code_getnum_btn);
        this.dtt = view.findViewById(d.g.u9_top_code_divider);
        this.dtv = (ImageView) view.findViewById(d.g.news_info_img);
        this.dtv.setBackgroundDrawable(am.getDrawable(d.f.icon_frs_news));
        this.dtu = (TextView) view.findViewById(d.g.news_info_text);
        this.dtw = view.findViewById(d.g.frs_list_item_u9_top_line);
        am.i(this.dts, d.f.frs_star_btn_like);
        am.h(this.dts, d.f.frs_text_color_selector);
        setOnClickListener();
    }

    public void a(v vVar) {
        if (vVar != null) {
            be bwX = vVar.bwX();
            bh bwY = vVar.bwY();
            this.top_code = bwX;
            this.news_info = bwY;
            if (vVar.bwW()) {
                this.dtw.setVisibility(0);
            } else {
                this.dtw.setVisibility(8);
            }
            if (this.top_code == null) {
                this.dtm.setVisibility(8);
                this.dtt.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.dtm.setVisibility(8);
                this.dtt.setVisibility(8);
            } else {
                this.dtm.setVisibility(0);
                this.dtt.setVisibility(0);
                this.dto.startLoad(this.top_code.uh(), 10, false);
                this.dtp.setText(this.top_code.getSummary());
                if (StringUtils.isNull(bwX.wZ())) {
                    this.dts.setVisibility(8);
                } else {
                    this.dts.setText(bwX.wZ());
                    this.dts.setVisibility(0);
                }
                int wW = this.top_code.wW();
                if (wW == 1 || wW == 2) {
                    if (StringUtils.isNull(this.top_code.wX())) {
                        this.dtq.setVisibility(8);
                    } else {
                        String str = this.mContext.getResources().getString(d.k.u9_shengyu) + this.top_code.wX();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.wX(), new ForegroundColorSpan(am.getColor(d.C0142d.cp_link_tip_d)));
                        this.dtq.setText(spannableString);
                        this.dtq.setVisibility(0);
                    }
                    if (bwX.wY() <= 0) {
                        this.dtr.setVisibility(8);
                    } else {
                        String str2 = this.mContext.getResources().getString(d.k.u9_worth) + this.top_code.wY();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.wY()), new ForegroundColorSpan(am.getColor(d.C0142d.cp_link_tip_d)));
                        this.dtr.setText(spannableString2);
                        this.dtr.setVisibility(0);
                    }
                } else {
                    this.dtr.setVisibility(8);
                    this.dtq.setText(bwX.getSubTitle());
                    this.dtq.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(bwY.getSummary())) {
                this.dtn.setVisibility(8);
                return;
            }
            this.dtn.setVisibility(0);
            this.dtu.setText(bwY.getSummary());
        }
    }

    public void setOnClickListener() {
        this.dtm.setOnClickListener(this.bZi);
        this.dtn.setOnClickListener(this.bZi);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.i(this.dtv, d.f.icon_frs_news);
            am.i(this.dts, d.f.frs_star_btn_like);
            am.h(this.dts, d.f.frs_text_color_selector);
            this.mContext.getLayoutMode().setNightMode(i == 1);
            this.mContext.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
