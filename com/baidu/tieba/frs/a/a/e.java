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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.v;
import com.sina.weibo.sdk.constant.WBPageConstants;
/* loaded from: classes3.dex */
public class e extends q.a {
    View.OnClickListener bWZ;
    private RelativeLayout dqd;
    private LinearLayout dqe;
    private TbImageView dqf;
    private TextView dqg;
    private TextView dqh;
    private TextView dqi;
    private TextView dqj;
    private View dqk;
    private TextView dql;
    private ImageView dqm;
    private View dqn;
    private TbPageContext mContext;
    private int mSkinType;
    private bi news_info;
    private bf top_code;

    public e(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.bWZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.aU(e.this.mContext.getPageActivity()) && l.jU()) {
                    if (view2 == e.this.dqd) {
                        if (e.this.top_code != null && !TextUtils.isEmpty(e.this.top_code.wI())) {
                            TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            ay.zG().c((TbPageContext) i.ad(e.this.mContext.getPageActivity()), new String[]{e.this.top_code.wI()});
                        }
                    } else if (view2 == e.this.dqe && e.this.news_info != null && !TextUtils.isEmpty(e.this.news_info.wP())) {
                        TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "info_click", "click", 1, WBPageConstants.ParamKey.PAGE, "frs");
                        ay.zG().c((TbPageContext) i.ad(e.this.mContext.getPageActivity()), new String[]{e.this.news_info.wP()});
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.dqd = (RelativeLayout) view.findViewById(d.g.u9_top_code);
        this.dqe = (LinearLayout) view.findViewById(d.g.u9_news_info);
        this.dqf = (TbImageView) view.findViewById(d.g.top_code_img);
        this.dqf.setPageId(bdUniqueId);
        this.dqg = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.dqh = (TextView) view.findViewById(d.g.top_code_detail_surplus_text);
        this.dqi = (TextView) view.findViewById(d.g.top_code_detail_giftworth_text);
        this.dqj = (TextView) view.findViewById(d.g.top_code_getnum_btn);
        this.dqk = view.findViewById(d.g.u9_top_code_divider);
        this.dqm = (ImageView) view.findViewById(d.g.news_info_img);
        this.dqm.setBackgroundDrawable(al.getDrawable(d.f.icon_frs_news));
        this.dql = (TextView) view.findViewById(d.g.news_info_text);
        this.dqn = view.findViewById(d.g.frs_list_item_u9_top_line);
        al.i(this.dqj, d.f.frs_star_btn_like);
        al.h(this.dqj, d.f.frs_text_color_selector);
        setOnClickListener();
    }

    public void a(v vVar) {
        if (vVar != null) {
            bf bww = vVar.bww();
            bi bwx = vVar.bwx();
            this.top_code = bww;
            this.news_info = bwx;
            if (vVar.bwv()) {
                this.dqn.setVisibility(0);
            } else {
                this.dqn.setVisibility(8);
            }
            if (this.top_code == null) {
                this.dqd.setVisibility(8);
                this.dqk.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.dqd.setVisibility(8);
                this.dqk.setVisibility(8);
            } else {
                this.dqd.setVisibility(0);
                this.dqk.setVisibility(0);
                this.dqf.startLoad(this.top_code.ub(), 10, false);
                this.dqg.setText(this.top_code.getSummary());
                if (StringUtils.isNull(bww.wM())) {
                    this.dqj.setVisibility(8);
                } else {
                    this.dqj.setText(bww.wM());
                    this.dqj.setVisibility(0);
                }
                int wJ = this.top_code.wJ();
                if (wJ == 1 || wJ == 2) {
                    if (StringUtils.isNull(this.top_code.wK())) {
                        this.dqh.setVisibility(8);
                    } else {
                        String str = this.mContext.getResources().getString(d.k.u9_shengyu) + this.top_code.wK();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.wK(), new ForegroundColorSpan(al.getColor(d.C0141d.cp_link_tip_d)));
                        this.dqh.setText(spannableString);
                        this.dqh.setVisibility(0);
                    }
                    if (bww.wL() <= 0) {
                        this.dqi.setVisibility(8);
                    } else {
                        String str2 = this.mContext.getResources().getString(d.k.u9_worth) + this.top_code.wL();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.wL()), new ForegroundColorSpan(al.getColor(d.C0141d.cp_link_tip_d)));
                        this.dqi.setText(spannableString2);
                        this.dqi.setVisibility(0);
                    }
                } else {
                    this.dqi.setVisibility(8);
                    this.dqh.setText(bww.getSubTitle());
                    this.dqh.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(bwx.getSummary())) {
                this.dqe.setVisibility(8);
                return;
            }
            this.dqe.setVisibility(0);
            this.dql.setText(bwx.getSummary());
        }
    }

    public void setOnClickListener() {
        this.dqd.setOnClickListener(this.bWZ);
        this.dqe.setOnClickListener(this.bWZ);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.i(this.dqm, d.f.icon_frs_news);
            al.i(this.dqj, d.f.frs_star_btn_like);
            al.h(this.dqj, d.f.frs_text_color_selector);
            this.mContext.getLayoutMode().setNightMode(i == 1);
            this.mContext.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
