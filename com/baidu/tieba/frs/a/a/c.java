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
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.ac;
/* loaded from: classes22.dex */
public class c extends af.a {
    View.OnClickListener aFf;
    private TbPageContext eCn;
    private RelativeLayout iPc;
    private LinearLayout iPd;
    private TbImageView iPe;
    private TextView iPf;
    private TextView iPg;
    private TextView iPh;
    private TextView iPi;
    private View iPj;
    private TextView iPk;
    private ImageView iPl;
    private View iPm;
    private int mSkinType;
    private cb news_info;
    private by top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.aFf = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bg.checkUpIsLogin(c.this.eCn.getPageActivity()) && l.isNetOk()) {
                    if (view2 == c.this.iPc) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.bmj())) {
                            TiebaStatic.eventStat(c.this.eCn.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            be.boR().b((TbPageContext) i.I(c.this.eCn.getPageActivity()), new String[]{c.this.top_code.bmj()});
                        }
                    } else if (view2 == c.this.iPd && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.bmq())) {
                        TiebaStatic.eventStat(c.this.eCn.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        be.boR().b((TbPageContext) i.I(c.this.eCn.getPageActivity()), new String[]{c.this.news_info.bmq()});
                    }
                }
            }
        };
        this.eCn = tbPageContext;
        this.iPc = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.iPd = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.iPe = (TbImageView) view.findViewById(R.id.top_code_img);
        this.iPe.setPageId(bdUniqueId);
        this.iPf = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.iPg = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.iPh = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.iPi = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.iPj = view.findViewById(R.id.u9_top_code_divider);
        this.iPl = (ImageView) view.findViewById(R.id.news_info_img);
        this.iPl.setBackgroundDrawable(ap.getDrawable(R.drawable.icon_frs_news));
        this.iPk = (TextView) view.findViewById(R.id.news_info_text);
        this.iPm = view.findViewById(R.id.frs_list_item_u9_top_line);
        ap.setBackgroundResource(this.iPi, R.drawable.frs_star_btn_like);
        ap.setViewTextColor(this.iPi, (int) R.drawable.frs_text_color_selector);
        czY();
    }

    public void a(ac acVar) {
        if (acVar != null) {
            by dGX = acVar.dGX();
            cb dGY = acVar.dGY();
            this.top_code = dGX;
            this.news_info = dGY;
            if (acVar.dGW()) {
                this.iPm.setVisibility(0);
            } else {
                this.iPm.setVisibility(8);
            }
            if (this.top_code == null) {
                this.iPc.setVisibility(8);
                this.iPj.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.iPc.setVisibility(8);
                this.iPj.setVisibility(8);
            } else {
                this.iPc.setVisibility(0);
                this.iPj.setVisibility(0);
                this.iPe.startLoad(this.top_code.bhW(), 10, false);
                this.iPf.setText(this.top_code.getSummary());
                if (StringUtils.isNull(dGX.bmn())) {
                    this.iPi.setVisibility(8);
                } else {
                    this.iPi.setText(dGX.bmn());
                    this.iPi.setVisibility(0);
                }
                int bmk = this.top_code.bmk();
                if (bmk == 1 || bmk == 2) {
                    if (StringUtils.isNull(this.top_code.bml())) {
                        this.iPg.setVisibility(8);
                    } else {
                        String str = this.eCn.getResources().getString(R.string.u9_shengyu) + this.top_code.bml();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.bml(), new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_d)));
                        this.iPg.setText(spannableString);
                        this.iPg.setVisibility(0);
                    }
                    if (dGX.bmm() <= 0) {
                        this.iPh.setVisibility(8);
                    } else {
                        String str2 = this.eCn.getResources().getString(R.string.u9_worth) + this.top_code.bmm();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.bmm()), new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_d)));
                        this.iPh.setText(spannableString2);
                        this.iPh.setVisibility(0);
                    }
                } else {
                    this.iPh.setVisibility(8);
                    this.iPg.setText(dGX.getSubTitle());
                    this.iPg.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(dGY.getSummary())) {
                this.iPd.setVisibility(8);
                return;
            }
            this.iPd.setVisibility(0);
            this.iPk.setText(dGY.getSummary());
        }
    }

    public void czY() {
        this.iPc.setOnClickListener(this.aFf);
        this.iPd.setOnClickListener(this.aFf);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.iPl, R.drawable.icon_frs_news);
            ap.setBackgroundResource(this.iPi, R.drawable.frs_star_btn_like);
            ap.setViewTextColor(this.iPi, (int) R.drawable.frs_text_color_selector);
            this.eCn.getLayoutMode().setNightMode(i == 1);
            this.eCn.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
