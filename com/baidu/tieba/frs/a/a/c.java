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
/* loaded from: classes7.dex */
public class c extends v.a {
    View.OnClickListener arL;
    private TbPageContext cRe;
    private RelativeLayout gwY;
    private LinearLayout gwZ;
    private TbImageView gxa;
    private TextView gxb;
    private TextView gxc;
    private TextView gxd;
    private TextView gxe;
    private View gxf;
    private TextView gxg;
    private ImageView gxh;
    private View gxi;
    private int mSkinType;
    private bo news_info;
    private bl top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.arL = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(c.this.cRe.getPageActivity()) && l.isNetOk()) {
                    if (view2 == c.this.gwY) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.aCa())) {
                            TiebaStatic.eventStat(c.this.cRe.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            ba.aEt().b((TbPageContext) i.ab(c.this.cRe.getPageActivity()), new String[]{c.this.top_code.aCa()});
                        }
                    } else if (view2 == c.this.gwZ && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.aCh())) {
                        TiebaStatic.eventStat(c.this.cRe.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        ba.aEt().b((TbPageContext) i.ab(c.this.cRe.getPageActivity()), new String[]{c.this.news_info.aCh()});
                    }
                }
            }
        };
        this.cRe = tbPageContext;
        this.gwY = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.gwZ = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.gxa = (TbImageView) view.findViewById(R.id.top_code_img);
        this.gxa.setPageId(bdUniqueId);
        this.gxb = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.gxc = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.gxd = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.gxe = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.gxf = view.findViewById(R.id.u9_top_code_divider);
        this.gxh = (ImageView) view.findViewById(R.id.news_info_img);
        this.gxh.setBackgroundDrawable(am.getDrawable(R.drawable.icon_frs_news));
        this.gxg = (TextView) view.findViewById(R.id.news_info_text);
        this.gxi = view.findViewById(R.id.frs_list_item_u9_top_line);
        am.setBackgroundResource(this.gxe, R.drawable.frs_star_btn_like);
        am.setViewTextColor(this.gxe, (int) R.drawable.frs_text_color_selector);
        bFU();
    }

    public void a(x xVar) {
        if (xVar != null) {
            bl cIT = xVar.cIT();
            bo cIU = xVar.cIU();
            this.top_code = cIT;
            this.news_info = cIU;
            if (xVar.cIS()) {
                this.gxi.setVisibility(0);
            } else {
                this.gxi.setVisibility(8);
            }
            if (this.top_code == null) {
                this.gwY.setVisibility(8);
                this.gxf.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.gwY.setVisibility(8);
                this.gxf.setVisibility(8);
            } else {
                this.gwY.setVisibility(0);
                this.gxf.setVisibility(0);
                this.gxa.startLoad(this.top_code.ayq(), 10, false);
                this.gxb.setText(this.top_code.getSummary());
                if (StringUtils.isNull(cIT.aCe())) {
                    this.gxe.setVisibility(8);
                } else {
                    this.gxe.setText(cIT.aCe());
                    this.gxe.setVisibility(0);
                }
                int aCb = this.top_code.aCb();
                if (aCb == 1 || aCb == 2) {
                    if (StringUtils.isNull(this.top_code.aCc())) {
                        this.gxc.setVisibility(8);
                    } else {
                        String str = this.cRe.getResources().getString(R.string.u9_shengyu) + this.top_code.aCc();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.aCc(), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.gxc.setText(spannableString);
                        this.gxc.setVisibility(0);
                    }
                    if (cIT.aCd() <= 0) {
                        this.gxd.setVisibility(8);
                    } else {
                        String str2 = this.cRe.getResources().getString(R.string.u9_worth) + this.top_code.aCd();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.aCd()), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.gxd.setText(spannableString2);
                        this.gxd.setVisibility(0);
                    }
                } else {
                    this.gxd.setVisibility(8);
                    this.gxc.setText(cIT.getSubTitle());
                    this.gxc.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(cIU.getSummary())) {
                this.gwZ.setVisibility(8);
                return;
            }
            this.gwZ.setVisibility(0);
            this.gxg.setText(cIU.getSummary());
        }
    }

    public void bFU() {
        this.gwY.setOnClickListener(this.arL);
        this.gwZ.setOnClickListener(this.arL);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.gxh, R.drawable.icon_frs_news);
            am.setBackgroundResource(this.gxe, R.drawable.frs_star_btn_like);
            am.setViewTextColor(this.gxe, (int) R.drawable.frs_text_color_selector);
            this.cRe.getLayoutMode().setNightMode(i == 1);
            this.cRe.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
