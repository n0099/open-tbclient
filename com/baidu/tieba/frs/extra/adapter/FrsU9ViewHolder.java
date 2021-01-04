package com.baidu.tieba.frs.extra.adapter;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.data.ce;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.ad;
/* loaded from: classes2.dex */
public class FrsU9ViewHolder extends TypeAdapter.ViewHolder {
    View.OnClickListener aHh;
    private TbPageContext eXu;
    private RelativeLayout jtj;
    private LinearLayout jtk;
    private TbImageView jtl;
    private TextView jtm;
    private TextView jtn;
    private TextView jto;
    private TextView jtp;
    private View jtq;
    private TextView jtr;
    private ImageView jts;
    private View jtt;
    private int mSkinType;
    private ce news_info;
    private cb top_code;

    public FrsU9ViewHolder(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.aHh = new View.OnClickListener() { // from class: com.baidu.tieba.frs.extra.adapter.FrsU9ViewHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bg.checkUpIsLogin(FrsU9ViewHolder.this.eXu.getPageActivity()) && l.isNetOk()) {
                    if (view2 == FrsU9ViewHolder.this.jtj) {
                        if (FrsU9ViewHolder.this.top_code != null && !TextUtils.isEmpty(FrsU9ViewHolder.this.top_code.btE())) {
                            TiebaStatic.eventStat(FrsU9ViewHolder.this.eXu.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            be.bwu().b((TbPageContext) j.K(FrsU9ViewHolder.this.eXu.getPageActivity()), new String[]{FrsU9ViewHolder.this.top_code.btE()});
                        }
                    } else if (view2 == FrsU9ViewHolder.this.jtk && FrsU9ViewHolder.this.news_info != null && !TextUtils.isEmpty(FrsU9ViewHolder.this.news_info.btL())) {
                        TiebaStatic.eventStat(FrsU9ViewHolder.this.eXu.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        be.bwu().b((TbPageContext) j.K(FrsU9ViewHolder.this.eXu.getPageActivity()), new String[]{FrsU9ViewHolder.this.news_info.btL()});
                    }
                }
            }
        };
        this.eXu = tbPageContext;
        this.jtj = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.jtk = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.jtl = (TbImageView) view.findViewById(R.id.top_code_img);
        this.jtl.setPageId(bdUniqueId);
        this.jtm = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.jtn = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.jto = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.jtp = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.jtq = view.findViewById(R.id.u9_top_code_divider);
        this.jts = (ImageView) view.findViewById(R.id.news_info_img);
        this.jts.setBackgroundDrawable(ao.getDrawable(R.drawable.icon_frs_news));
        this.jtr = (TextView) view.findViewById(R.id.news_info_text);
        this.jtt = view.findViewById(R.id.frs_list_item_u9_top_line);
        ao.setBackgroundResource(this.jtp, R.drawable.frs_star_btn_like);
        ao.setViewTextColor(this.jtp, R.drawable.frs_text_color_selector);
        cJw();
    }

    public void a(ad adVar) {
        if (adVar != null) {
            cb dOA = adVar.dOA();
            ce dOB = adVar.dOB();
            this.top_code = dOA;
            this.news_info = dOB;
            if (adVar.dOz()) {
                this.jtt.setVisibility(0);
            } else {
                this.jtt.setVisibility(8);
            }
            if (this.top_code == null) {
                this.jtj.setVisibility(8);
                this.jtq.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.jtj.setVisibility(8);
                this.jtq.setVisibility(8);
            } else {
                this.jtj.setVisibility(0);
                this.jtq.setVisibility(0);
                this.jtl.startLoad(this.top_code.getImgUrl(), 10, false);
                this.jtm.setText(this.top_code.getSummary());
                if (StringUtils.isNull(dOA.btI())) {
                    this.jtp.setVisibility(8);
                } else {
                    this.jtp.setText(dOA.btI());
                    this.jtp.setVisibility(0);
                }
                int btF = this.top_code.btF();
                if (btF == 1 || btF == 2) {
                    if (StringUtils.isNull(this.top_code.btG())) {
                        this.jtn.setVisibility(8);
                    } else {
                        String str = this.eXu.getResources().getString(R.string.u9_shengyu) + this.top_code.btG();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.btG(), new ForegroundColorSpan(ao.getColor(R.color.CAM_X0305)));
                        this.jtn.setText(spannableString);
                        this.jtn.setVisibility(0);
                    }
                    if (dOA.btH() <= 0) {
                        this.jto.setVisibility(8);
                    } else {
                        String str2 = this.eXu.getResources().getString(R.string.u9_worth) + this.top_code.btH();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.btH()), new ForegroundColorSpan(ao.getColor(R.color.CAM_X0305)));
                        this.jto.setText(spannableString2);
                        this.jto.setVisibility(0);
                    }
                } else {
                    this.jto.setVisibility(8);
                    this.jtn.setText(dOA.getSubTitle());
                    this.jtn.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(dOB.getSummary())) {
                this.jtk.setVisibility(8);
                return;
            }
            this.jtk.setVisibility(0);
            this.jtr.setText(dOB.getSummary());
        }
    }

    public void cJw() {
        this.jtj.setOnClickListener(this.aHh);
        this.jtk.setOnClickListener(this.aHh);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.jts, R.drawable.icon_frs_news);
            ao.setBackgroundResource(this.jtp, R.drawable.frs_star_btn_like);
            ao.setViewTextColor(this.jtp, R.drawable.frs_text_color_selector);
            this.eXu.getLayoutMode().setNightMode(i == 1);
            this.eXu.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
