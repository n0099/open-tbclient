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
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.v;
import com.sina.weibo.sdk.constant.WBPageConstants;
/* loaded from: classes3.dex */
public class e extends q.a {
    private TbPageContext adf;
    View.OnClickListener bOj;
    private RelativeLayout dfK;
    private LinearLayout dfL;
    private TbImageView dfM;
    private TextView dfN;
    private TextView dfO;
    private TextView dfP;
    private TextView dfQ;
    private View dfR;
    private TextView dfS;
    private ImageView dfT;
    private View dfU;
    private int mSkinType;
    private bi news_info;
    private bf top_code;

    public e(TbPageContext tbPageContext, View view2, BdUniqueId bdUniqueId) {
        super(view2);
        this.mSkinType = 3;
        this.bOj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (az.aK(e.this.adf.getPageActivity()) && l.hg()) {
                    if (view3 == e.this.dfK) {
                        if (e.this.top_code != null && !TextUtils.isEmpty(e.this.top_code.tk())) {
                            TiebaStatic.eventStat(e.this.adf.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            ax.wg().c((TbPageContext) i.ab(e.this.adf.getPageActivity()), new String[]{e.this.top_code.tk()});
                        }
                    } else if (view3 == e.this.dfL && e.this.news_info != null && !TextUtils.isEmpty(e.this.news_info.ts())) {
                        TiebaStatic.eventStat(e.this.adf.getPageActivity(), "info_click", "click", 1, WBPageConstants.ParamKey.PAGE, "frs");
                        ax.wg().c((TbPageContext) i.ab(e.this.adf.getPageActivity()), new String[]{e.this.news_info.ts()});
                    }
                }
            }
        };
        this.adf = tbPageContext;
        this.dfK = (RelativeLayout) view2.findViewById(d.g.u9_top_code);
        this.dfL = (LinearLayout) view2.findViewById(d.g.u9_news_info);
        this.dfM = (TbImageView) view2.findViewById(d.g.top_code_img);
        this.dfM.setPageId(bdUniqueId);
        this.dfN = (TextView) view2.findViewById(d.g.top_code_detail_summary_text);
        this.dfO = (TextView) view2.findViewById(d.g.top_code_detail_surplus_text);
        this.dfP = (TextView) view2.findViewById(d.g.top_code_detail_giftworth_text);
        this.dfQ = (TextView) view2.findViewById(d.g.top_code_getnum_btn);
        this.dfR = view2.findViewById(d.g.u9_top_code_divider);
        this.dfT = (ImageView) view2.findViewById(d.g.news_info_img);
        this.dfT.setBackgroundDrawable(ak.getDrawable(d.f.icon_frs_news));
        this.dfS = (TextView) view2.findViewById(d.g.news_info_text);
        this.dfU = view2.findViewById(d.g.frs_list_item_u9_top_line);
        ak.i(this.dfQ, d.f.frs_star_btn_like);
        ak.h(this.dfQ, d.f.frs_text_color_selector);
        setOnClickListener();
    }

    public void a(v vVar) {
        if (vVar != null) {
            bf brw = vVar.brw();
            bi brx = vVar.brx();
            this.top_code = brw;
            this.news_info = brx;
            if (vVar.brv()) {
                this.dfU.setVisibility(0);
            } else {
                this.dfU.setVisibility(8);
            }
            if (this.top_code == null) {
                this.dfK.setVisibility(8);
                this.dfR.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.dfK.setVisibility(8);
                this.dfR.setVisibility(8);
            } else {
                this.dfK.setVisibility(0);
                this.dfR.setVisibility(0);
                this.dfM.startLoad(this.top_code.qG(), 10, false);
                this.dfN.setText(this.top_code.getSummary());
                if (StringUtils.isNull(brw.tp())) {
                    this.dfQ.setVisibility(8);
                } else {
                    this.dfQ.setText(brw.tp());
                    this.dfQ.setVisibility(0);
                }
                int tl = this.top_code.tl();
                if (tl == 1 || tl == 2) {
                    if (StringUtils.isNull(this.top_code.tm())) {
                        this.dfO.setVisibility(8);
                    } else {
                        String str = this.adf.getResources().getString(d.k.u9_shengyu) + this.top_code.tm();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.tm(), new ForegroundColorSpan(ak.getColor(d.C0126d.cp_link_tip_d)));
                        this.dfO.setText(spannableString);
                        this.dfO.setVisibility(0);
                    }
                    if (brw.tn() <= 0) {
                        this.dfP.setVisibility(8);
                    } else {
                        String str2 = this.adf.getResources().getString(d.k.u9_worth) + this.top_code.tn();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.tn()), new ForegroundColorSpan(ak.getColor(d.C0126d.cp_link_tip_d)));
                        this.dfP.setText(spannableString2);
                        this.dfP.setVisibility(0);
                    }
                } else {
                    this.dfP.setVisibility(8);
                    this.dfO.setText(brw.getSubTitle());
                    this.dfO.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(brx.getSummary())) {
                this.dfL.setVisibility(8);
                return;
            }
            this.dfL.setVisibility(0);
            this.dfS.setText(brx.getSummary());
        }
    }

    public void setOnClickListener() {
        this.dfK.setOnClickListener(this.bOj);
        this.dfL.setOnClickListener(this.bOj);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.i(this.dfT, d.f.icon_frs_news);
            ak.i(this.dfQ, d.f.frs_star_btn_like);
            ak.h(this.dfQ, d.f.frs_text_color_selector);
            this.adf.getLayoutMode().setNightMode(i == 1);
            this.adf.getLayoutMode().u(getView());
            this.mSkinType = i;
        }
    }
}
