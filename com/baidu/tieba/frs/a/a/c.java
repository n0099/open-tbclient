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
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes6.dex */
public class c extends v.a {
    View.OnClickListener aqZ;
    private TbPageContext cQU;
    private RelativeLayout gtO;
    private LinearLayout gtP;
    private TbImageView gtQ;
    private TextView gtR;
    private TextView gtS;
    private TextView gtT;
    private TextView gtU;
    private View gtV;
    private TextView gtW;
    private ImageView gtX;
    private View gtY;
    private int mSkinType;
    private bo news_info;
    private bl top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.aqZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(c.this.cQU.getPageActivity()) && l.isNetOk()) {
                    if (view2 == c.this.gtO) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.aBH())) {
                            TiebaStatic.eventStat(c.this.cQU.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            ba.aEa().b((TbPageContext) i.ab(c.this.cQU.getPageActivity()), new String[]{c.this.top_code.aBH()});
                        }
                    } else if (view2 == c.this.gtP && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.aBO())) {
                        TiebaStatic.eventStat(c.this.cQU.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        ba.aEa().b((TbPageContext) i.ab(c.this.cQU.getPageActivity()), new String[]{c.this.news_info.aBO()});
                    }
                }
            }
        };
        this.cQU = tbPageContext;
        this.gtO = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.gtP = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.gtQ = (TbImageView) view.findViewById(R.id.top_code_img);
        this.gtQ.setPageId(bdUniqueId);
        this.gtR = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.gtS = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.gtT = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.gtU = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.gtV = view.findViewById(R.id.u9_top_code_divider);
        this.gtX = (ImageView) view.findViewById(R.id.news_info_img);
        this.gtX.setBackgroundDrawable(am.getDrawable(R.drawable.icon_frs_news));
        this.gtW = (TextView) view.findViewById(R.id.news_info_text);
        this.gtY = view.findViewById(R.id.frs_list_item_u9_top_line);
        am.setBackgroundResource(this.gtU, R.drawable.frs_star_btn_like);
        am.setViewTextColor(this.gtU, (int) R.drawable.frs_text_color_selector);
        bES();
    }

    public void a(x xVar) {
        if (xVar != null) {
            bl cHP = xVar.cHP();
            bo cHQ = xVar.cHQ();
            this.top_code = cHP;
            this.news_info = cHQ;
            if (xVar.cHO()) {
                this.gtY.setVisibility(0);
            } else {
                this.gtY.setVisibility(8);
            }
            if (this.top_code == null) {
                this.gtO.setVisibility(8);
                this.gtV.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.gtO.setVisibility(8);
                this.gtV.setVisibility(8);
            } else {
                this.gtO.setVisibility(0);
                this.gtV.setVisibility(0);
                this.gtQ.startLoad(this.top_code.axX(), 10, false);
                this.gtR.setText(this.top_code.getSummary());
                if (StringUtils.isNull(cHP.aBL())) {
                    this.gtU.setVisibility(8);
                } else {
                    this.gtU.setText(cHP.aBL());
                    this.gtU.setVisibility(0);
                }
                int aBI = this.top_code.aBI();
                if (aBI == 1 || aBI == 2) {
                    if (StringUtils.isNull(this.top_code.aBJ())) {
                        this.gtS.setVisibility(8);
                    } else {
                        String str = this.cQU.getResources().getString(R.string.u9_shengyu) + this.top_code.aBJ();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.aBJ(), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.gtS.setText(spannableString);
                        this.gtS.setVisibility(0);
                    }
                    if (cHP.aBK() <= 0) {
                        this.gtT.setVisibility(8);
                    } else {
                        String str2 = this.cQU.getResources().getString(R.string.u9_worth) + this.top_code.aBK();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.aBK()), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.gtT.setText(spannableString2);
                        this.gtT.setVisibility(0);
                    }
                } else {
                    this.gtT.setVisibility(8);
                    this.gtS.setText(cHP.getSubTitle());
                    this.gtS.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(cHQ.getSummary())) {
                this.gtP.setVisibility(8);
                return;
            }
            this.gtP.setVisibility(0);
            this.gtW.setText(cHQ.getSummary());
        }
    }

    public void bES() {
        this.gtO.setOnClickListener(this.aqZ);
        this.gtP.setOnClickListener(this.aqZ);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.gtX, R.drawable.icon_frs_news);
            am.setBackgroundResource(this.gtU, R.drawable.frs_star_btn_like);
            am.setViewTextColor(this.gtU, (int) R.drawable.frs_text_color_selector);
            this.cQU.getLayoutMode().setNightMode(i == 1);
            this.cQU.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
