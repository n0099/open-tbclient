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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes3.dex */
public class c extends q.a {
    View.OnClickListener coI;
    private RelativeLayout dKG;
    private LinearLayout dKH;
    private TbImageView dKI;
    private TextView dKJ;
    private TextView dKK;
    private TextView dKL;
    private TextView dKM;
    private View dKN;
    private TextView dKO;
    private ImageView dKP;
    private View dKQ;
    private TbPageContext mContext;
    private int mSkinType;
    private bg news_info;
    private bd top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.coI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.bI(c.this.mContext.getPageActivity()) && l.lo()) {
                    if (view2 == c.this.dKG) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.Ac())) {
                            TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "num_click", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                            ay.CU().c((TbPageContext) i.aK(c.this.mContext.getPageActivity()), new String[]{c.this.top_code.Ac()});
                        }
                    } else if (view2 == c.this.dKH && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.Aj())) {
                        TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "info_click", AiAppsUBCStatistic.TYPE_CLICK, 1, SystemScreenshotManager.PAGE, "frs");
                        ay.CU().c((TbPageContext) i.aK(c.this.mContext.getPageActivity()), new String[]{c.this.news_info.Aj()});
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.dKG = (RelativeLayout) view.findViewById(e.g.u9_top_code);
        this.dKH = (LinearLayout) view.findViewById(e.g.u9_news_info);
        this.dKI = (TbImageView) view.findViewById(e.g.top_code_img);
        this.dKI.setPageId(bdUniqueId);
        this.dKJ = (TextView) view.findViewById(e.g.top_code_detail_summary_text);
        this.dKK = (TextView) view.findViewById(e.g.top_code_detail_surplus_text);
        this.dKL = (TextView) view.findViewById(e.g.top_code_detail_giftworth_text);
        this.dKM = (TextView) view.findViewById(e.g.top_code_getnum_btn);
        this.dKN = view.findViewById(e.g.u9_top_code_divider);
        this.dKP = (ImageView) view.findViewById(e.g.news_info_img);
        this.dKP.setBackgroundDrawable(al.getDrawable(e.f.icon_frs_news));
        this.dKO = (TextView) view.findViewById(e.g.news_info_text);
        this.dKQ = view.findViewById(e.g.frs_list_item_u9_top_line);
        al.i(this.dKM, e.f.frs_star_btn_like);
        al.h(this.dKM, e.f.frs_text_color_selector);
        setOnClickListener();
    }

    public void a(v vVar) {
        if (vVar != null) {
            bd bBw = vVar.bBw();
            bg bBx = vVar.bBx();
            this.top_code = bBw;
            this.news_info = bBx;
            if (vVar.aJe()) {
                this.dKQ.setVisibility(0);
            } else {
                this.dKQ.setVisibility(8);
            }
            if (this.top_code == null) {
                this.dKG.setVisibility(8);
                this.dKN.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.dKG.setVisibility(8);
                this.dKN.setVisibility(8);
            } else {
                this.dKG.setVisibility(0);
                this.dKN.setVisibility(0);
                this.dKI.startLoad(this.top_code.xf(), 10, false);
                this.dKJ.setText(this.top_code.getSummary());
                if (StringUtils.isNull(bBw.Ag())) {
                    this.dKM.setVisibility(8);
                } else {
                    this.dKM.setText(bBw.Ag());
                    this.dKM.setVisibility(0);
                }
                int Ad = this.top_code.Ad();
                if (Ad == 1 || Ad == 2) {
                    if (StringUtils.isNull(this.top_code.Ae())) {
                        this.dKK.setVisibility(8);
                    } else {
                        String str = this.mContext.getResources().getString(e.j.u9_shengyu) + this.top_code.Ae();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.Ae(), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)));
                        this.dKK.setText(spannableString);
                        this.dKK.setVisibility(0);
                    }
                    if (bBw.Af() <= 0) {
                        this.dKL.setVisibility(8);
                    } else {
                        String str2 = this.mContext.getResources().getString(e.j.u9_worth) + this.top_code.Af();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.Af()), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)));
                        this.dKL.setText(spannableString2);
                        this.dKL.setVisibility(0);
                    }
                } else {
                    this.dKL.setVisibility(8);
                    this.dKK.setText(bBw.getSubTitle());
                    this.dKK.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(bBx.getSummary())) {
                this.dKH.setVisibility(8);
                return;
            }
            this.dKH.setVisibility(0);
            this.dKO.setText(bBx.getSummary());
        }
    }

    public void setOnClickListener() {
        this.dKG.setOnClickListener(this.coI);
        this.dKH.setOnClickListener(this.coI);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.i(this.dKP, e.f.icon_frs_news);
            al.i(this.dKM, e.f.frs_star_btn_like);
            al.h(this.dKM, e.f.frs_text_color_selector);
            this.mContext.getLayoutMode().setNightMode(i == 1);
            this.mContext.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
