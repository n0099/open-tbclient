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
/* loaded from: classes16.dex */
public class c extends af.a {
    View.OnClickListener aBk;
    private TbPageContext efn;
    private RelativeLayout igF;
    private LinearLayout igG;
    private TbImageView igH;
    private TextView igI;
    private TextView igJ;
    private TextView igK;
    private TextView igL;
    private View igM;
    private TextView igN;
    private ImageView igO;
    private View igP;
    private int mSkinType;
    private cb news_info;
    private by top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.aBk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bg.checkUpIsLogin(c.this.efn.getPageActivity()) && l.isNetOk()) {
                    if (view2 == c.this.igF) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.bgN())) {
                            TiebaStatic.eventStat(c.this.efn.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            be.bju().b((TbPageContext) i.I(c.this.efn.getPageActivity()), new String[]{c.this.top_code.bgN()});
                        }
                    } else if (view2 == c.this.igG && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.bgU())) {
                        TiebaStatic.eventStat(c.this.efn.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        be.bju().b((TbPageContext) i.I(c.this.efn.getPageActivity()), new String[]{c.this.news_info.bgU()});
                    }
                }
            }
        };
        this.efn = tbPageContext;
        this.igF = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.igG = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.igH = (TbImageView) view.findViewById(R.id.top_code_img);
        this.igH.setPageId(bdUniqueId);
        this.igI = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.igJ = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.igK = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.igL = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.igM = view.findViewById(R.id.u9_top_code_divider);
        this.igO = (ImageView) view.findViewById(R.id.news_info_img);
        this.igO.setBackgroundDrawable(ap.getDrawable(R.drawable.icon_frs_news));
        this.igN = (TextView) view.findViewById(R.id.news_info_text);
        this.igP = view.findViewById(R.id.frs_list_item_u9_top_line);
        ap.setBackgroundResource(this.igL, R.drawable.frs_star_btn_like);
        ap.setViewTextColor(this.igL, (int) R.drawable.frs_text_color_selector);
        cqg();
    }

    public void a(ac acVar) {
        if (acVar != null) {
            by dwf = acVar.dwf();
            cb dwg = acVar.dwg();
            this.top_code = dwf;
            this.news_info = dwg;
            if (acVar.dwe()) {
                this.igP.setVisibility(0);
            } else {
                this.igP.setVisibility(8);
            }
            if (this.top_code == null) {
                this.igF.setVisibility(8);
                this.igM.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.igF.setVisibility(8);
                this.igM.setVisibility(8);
            } else {
                this.igF.setVisibility(0);
                this.igM.setVisibility(0);
                this.igH.startLoad(this.top_code.bcA(), 10, false);
                this.igI.setText(this.top_code.getSummary());
                if (StringUtils.isNull(dwf.bgR())) {
                    this.igL.setVisibility(8);
                } else {
                    this.igL.setText(dwf.bgR());
                    this.igL.setVisibility(0);
                }
                int bgO = this.top_code.bgO();
                if (bgO == 1 || bgO == 2) {
                    if (StringUtils.isNull(this.top_code.bgP())) {
                        this.igJ.setVisibility(8);
                    } else {
                        String str = this.efn.getResources().getString(R.string.u9_shengyu) + this.top_code.bgP();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.bgP(), new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_d)));
                        this.igJ.setText(spannableString);
                        this.igJ.setVisibility(0);
                    }
                    if (dwf.bgQ() <= 0) {
                        this.igK.setVisibility(8);
                    } else {
                        String str2 = this.efn.getResources().getString(R.string.u9_worth) + this.top_code.bgQ();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.bgQ()), new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_d)));
                        this.igK.setText(spannableString2);
                        this.igK.setVisibility(0);
                    }
                } else {
                    this.igK.setVisibility(8);
                    this.igJ.setText(dwf.getSubTitle());
                    this.igJ.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(dwg.getSummary())) {
                this.igG.setVisibility(8);
                return;
            }
            this.igG.setVisibility(0);
            this.igN.setText(dwg.getSummary());
        }
    }

    public void cqg() {
        this.igF.setOnClickListener(this.aBk);
        this.igG.setOnClickListener(this.aBk);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.igO, R.drawable.icon_frs_news);
            ap.setBackgroundResource(this.igL, R.drawable.frs_star_btn_like);
            ap.setViewTextColor(this.igL, (int) R.drawable.frs_text_color_selector);
            this.efn.getLayoutMode().setNightMode(i == 1);
            this.efn.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
