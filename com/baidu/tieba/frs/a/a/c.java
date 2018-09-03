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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes3.dex */
public class c extends q.a {
    View.OnClickListener caq;
    private RelativeLayout dvW;
    private LinearLayout dvX;
    private TbImageView dvY;
    private TextView dvZ;
    private TextView dwa;
    private TextView dwb;
    private TextView dwc;
    private View dwd;
    private TextView dwe;
    private ImageView dwf;
    private View dwg;
    private TbPageContext mContext;
    private int mSkinType;
    private bg news_info;
    private bd top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.caq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bb.aU(c.this.mContext.getPageActivity()) && l.jV()) {
                    if (view2 == c.this.dvW) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.wM())) {
                            TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            az.zI().c((TbPageContext) i.ad(c.this.mContext.getPageActivity()), new String[]{c.this.top_code.wM()});
                        }
                    } else if (view2 == c.this.dvX && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.wT())) {
                        TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        az.zI().c((TbPageContext) i.ad(c.this.mContext.getPageActivity()), new String[]{c.this.news_info.wT()});
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.dvW = (RelativeLayout) view.findViewById(f.g.u9_top_code);
        this.dvX = (LinearLayout) view.findViewById(f.g.u9_news_info);
        this.dvY = (TbImageView) view.findViewById(f.g.top_code_img);
        this.dvY.setPageId(bdUniqueId);
        this.dvZ = (TextView) view.findViewById(f.g.top_code_detail_summary_text);
        this.dwa = (TextView) view.findViewById(f.g.top_code_detail_surplus_text);
        this.dwb = (TextView) view.findViewById(f.g.top_code_detail_giftworth_text);
        this.dwc = (TextView) view.findViewById(f.g.top_code_getnum_btn);
        this.dwd = view.findViewById(f.g.u9_top_code_divider);
        this.dwf = (ImageView) view.findViewById(f.g.news_info_img);
        this.dwf.setBackgroundDrawable(am.getDrawable(f.C0146f.icon_frs_news));
        this.dwe = (TextView) view.findViewById(f.g.news_info_text);
        this.dwg = view.findViewById(f.g.frs_list_item_u9_top_line);
        am.i(this.dwc, f.C0146f.frs_star_btn_like);
        am.h(this.dwc, f.C0146f.frs_text_color_selector);
        setOnClickListener();
    }

    public void a(v vVar) {
        if (vVar != null) {
            bd bvB = vVar.bvB();
            bg bvC = vVar.bvC();
            this.top_code = bvB;
            this.news_info = bvC;
            if (vVar.aDz()) {
                this.dwg.setVisibility(0);
            } else {
                this.dwg.setVisibility(8);
            }
            if (this.top_code == null) {
                this.dvW.setVisibility(8);
                this.dwd.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.dvW.setVisibility(8);
                this.dwd.setVisibility(8);
            } else {
                this.dvW.setVisibility(0);
                this.dwd.setVisibility(0);
                this.dvY.startLoad(this.top_code.tT(), 10, false);
                this.dvZ.setText(this.top_code.getSummary());
                if (StringUtils.isNull(bvB.wQ())) {
                    this.dwc.setVisibility(8);
                } else {
                    this.dwc.setText(bvB.wQ());
                    this.dwc.setVisibility(0);
                }
                int wN = this.top_code.wN();
                if (wN == 1 || wN == 2) {
                    if (StringUtils.isNull(this.top_code.wO())) {
                        this.dwa.setVisibility(8);
                    } else {
                        String str = this.mContext.getResources().getString(f.j.u9_shengyu) + this.top_code.wO();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.wO(), new ForegroundColorSpan(am.getColor(f.d.cp_link_tip_d)));
                        this.dwa.setText(spannableString);
                        this.dwa.setVisibility(0);
                    }
                    if (bvB.wP() <= 0) {
                        this.dwb.setVisibility(8);
                    } else {
                        String str2 = this.mContext.getResources().getString(f.j.u9_worth) + this.top_code.wP();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.wP()), new ForegroundColorSpan(am.getColor(f.d.cp_link_tip_d)));
                        this.dwb.setText(spannableString2);
                        this.dwb.setVisibility(0);
                    }
                } else {
                    this.dwb.setVisibility(8);
                    this.dwa.setText(bvB.getSubTitle());
                    this.dwa.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(bvC.getSummary())) {
                this.dvX.setVisibility(8);
                return;
            }
            this.dvX.setVisibility(0);
            this.dwe.setText(bvC.getSummary());
        }
    }

    public void setOnClickListener() {
        this.dvW.setOnClickListener(this.caq);
        this.dvX.setOnClickListener(this.caq);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.i(this.dwf, f.C0146f.icon_frs_news);
            am.i(this.dwc, f.C0146f.frs_star_btn_like);
            am.h(this.dwc, f.C0146f.frs_text_color_selector);
            this.mContext.getLayoutMode().setNightMode(i == 1);
            this.mContext.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
