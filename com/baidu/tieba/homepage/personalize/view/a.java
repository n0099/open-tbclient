package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.personalize.data.e;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends RelativeLayout {
    private BdUniqueId bph;
    private int ds94;
    public ImageView egM;
    private LinearLayout egN;
    private TextView egO;
    private ImageView egP;
    private int egQ;
    private TextView mInfo;
    private TextView mTitle;

    public a(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.ds94 = l.s(getContext(), d.e.tbds94);
        this.egQ = 0 - l.s(getContext(), d.e.tbds18);
        LayoutInflater.from(context).inflate(d.h.concern_unread_tip_view_layout, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(d.g.concern_unread_tip_title);
        this.egM = (ImageView) findViewById(d.g.concern_unread_tip_close);
        this.egN = (LinearLayout) findViewById(d.g.concern_unread_tip_header_box);
        this.mInfo = (TextView) findViewById(d.g.concern_unread_tip_info);
        this.egO = (TextView) findViewById(d.g.concern_unread_tip_show);
        this.egP = (ImageView) findViewById(d.g.concern_unread_tip_show_arrow);
        setPadding(0, 0, 0, l.s(context, d.e.tbds44));
        onChangeSkinType();
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.bph = bdUniqueId;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
        this.egM.setOnClickListener(onClickListener);
    }

    public void setData(e eVar) {
        if (eVar != null) {
            if (!eVar.aBJ()) {
                setVisibility(8);
                return;
            }
            if (eVar.ego > 0) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), System.currentTimeMillis() + eVar.ego);
            }
            if (this.mInfo != null && !StringUtils.isNull(eVar.egp)) {
                this.mInfo.setText(eVar.egp);
            }
            if (this.egN != null && eVar.egn != null) {
                this.egN.removeAllViews();
                List<String> list = eVar.egn;
                for (int i = 0; i < list.size(); i++) {
                    String str = list.get(i);
                    if (!StringUtils.isNull(str)) {
                        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), d.h.concern_unread_tip_head_group, null);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds94, this.ds94);
                        if (i > 0) {
                            layoutParams.leftMargin = this.egQ;
                        }
                        frameLayout.setLayoutParams(layoutParams);
                        HeadImageView headImageView = (HeadImageView) frameLayout.findViewById(d.g.inner_img);
                        headImageView.setIsRound(true);
                        headImageView.setDrawBorder(false);
                        aj.c((ImageView) frameLayout.findViewById(d.g.out_img), d.f.bg_unread_tip_head_border);
                        this.egN.addView(frameLayout);
                        headImageView.setPageId(this.bph);
                        headImageView.startLoad(str, 12, false);
                    }
                }
            }
        }
    }

    public void onChangeSkinType() {
        aj.t(this, d.C0108d.cp_bg_line_d);
        aj.r(this.mTitle, d.C0108d.cp_cont_b);
        aj.c(this.egM, d.f.icon_home_feedback_selector);
        aj.r(this.mInfo, d.C0108d.cp_cont_b);
        aj.r(this.egO, d.C0108d.cp_cont_d);
        aj.c(this.egP, d.f.icon_arrow_gray_right_n);
    }
}
