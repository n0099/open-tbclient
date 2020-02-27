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
/* loaded from: classes9.dex */
public class c extends v.a {
    View.OnClickListener auX;
    private TbPageContext cVg;
    private RelativeLayout gyZ;
    private LinearLayout gza;
    private TbImageView gzb;
    private TextView gzc;
    private TextView gzd;
    private TextView gze;
    private TextView gzf;
    private View gzg;
    private TextView gzh;
    private ImageView gzi;
    private View gzj;
    private int mSkinType;
    private bo news_info;
    private bl top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.auX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(c.this.cVg.getPageActivity()) && l.isNetOk()) {
                    if (view2 == c.this.gyZ) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.aEl())) {
                            TiebaStatic.eventStat(c.this.cVg.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            ba.aGE().b((TbPageContext) i.ab(c.this.cVg.getPageActivity()), new String[]{c.this.top_code.aEl()});
                        }
                    } else if (view2 == c.this.gza && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.aEs())) {
                        TiebaStatic.eventStat(c.this.cVg.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        ba.aGE().b((TbPageContext) i.ab(c.this.cVg.getPageActivity()), new String[]{c.this.news_info.aEs()});
                    }
                }
            }
        };
        this.cVg = tbPageContext;
        this.gyZ = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.gza = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.gzb = (TbImageView) view.findViewById(R.id.top_code_img);
        this.gzb.setPageId(bdUniqueId);
        this.gzc = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.gzd = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.gze = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.gzf = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.gzg = view.findViewById(R.id.u9_top_code_divider);
        this.gzi = (ImageView) view.findViewById(R.id.news_info_img);
        this.gzi.setBackgroundDrawable(am.getDrawable(R.drawable.icon_frs_news));
        this.gzh = (TextView) view.findViewById(R.id.news_info_text);
        this.gzj = view.findViewById(R.id.frs_list_item_u9_top_line);
        am.setBackgroundResource(this.gzf, R.drawable.frs_star_btn_like);
        am.setViewTextColor(this.gzf, (int) R.drawable.frs_text_color_selector);
        bHw();
    }

    public void a(x xVar) {
        if (xVar != null) {
            bl cKz = xVar.cKz();
            bo cKA = xVar.cKA();
            this.top_code = cKz;
            this.news_info = cKA;
            if (xVar.cKy()) {
                this.gzj.setVisibility(0);
            } else {
                this.gzj.setVisibility(8);
            }
            if (this.top_code == null) {
                this.gyZ.setVisibility(8);
                this.gzg.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.gyZ.setVisibility(8);
                this.gzg.setVisibility(8);
            } else {
                this.gyZ.setVisibility(0);
                this.gzg.setVisibility(0);
                this.gzb.startLoad(this.top_code.aAE(), 10, false);
                this.gzc.setText(this.top_code.getSummary());
                if (StringUtils.isNull(cKz.aEp())) {
                    this.gzf.setVisibility(8);
                } else {
                    this.gzf.setText(cKz.aEp());
                    this.gzf.setVisibility(0);
                }
                int aEm = this.top_code.aEm();
                if (aEm == 1 || aEm == 2) {
                    if (StringUtils.isNull(this.top_code.aEn())) {
                        this.gzd.setVisibility(8);
                    } else {
                        String str = this.cVg.getResources().getString(R.string.u9_shengyu) + this.top_code.aEn();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.aEn(), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.gzd.setText(spannableString);
                        this.gzd.setVisibility(0);
                    }
                    if (cKz.aEo() <= 0) {
                        this.gze.setVisibility(8);
                    } else {
                        String str2 = this.cVg.getResources().getString(R.string.u9_worth) + this.top_code.aEo();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.aEo()), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.gze.setText(spannableString2);
                        this.gze.setVisibility(0);
                    }
                } else {
                    this.gze.setVisibility(8);
                    this.gzd.setText(cKz.getSubTitle());
                    this.gzd.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(cKA.getSummary())) {
                this.gza.setVisibility(8);
                return;
            }
            this.gza.setVisibility(0);
            this.gzh.setText(cKA.getSummary());
        }
    }

    public void bHw() {
        this.gyZ.setOnClickListener(this.auX);
        this.gza.setOnClickListener(this.auX);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.gzi, R.drawable.icon_frs_news);
            am.setBackgroundResource(this.gzf, R.drawable.frs_star_btn_like);
            am.setViewTextColor(this.gzf, (int) R.drawable.frs_text_color_selector);
            this.cVg.getLayoutMode().setNightMode(i == 1);
            this.cVg.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
