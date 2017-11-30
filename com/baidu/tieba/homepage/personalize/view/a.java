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
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.personalize.data.e;
import java.util.List;
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private BdUniqueId aAL;
    public ImageView drL;
    private LinearLayout drM;
    private TextView drN;
    private ImageView drO;
    private int drP;
    private int ds94;
    private TextView mInfo;
    private TextView mTitle;

    public a(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.ds94 = l.f(getContext(), d.e.tbds94);
        this.drP = 0 - l.f(getContext(), d.e.tbds18);
        LayoutInflater.from(context).inflate(d.h.concern_unread_tip_view_layout, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(d.g.concern_unread_tip_title);
        this.drL = (ImageView) findViewById(d.g.concern_unread_tip_close);
        this.drM = (LinearLayout) findViewById(d.g.concern_unread_tip_header_box);
        this.mInfo = (TextView) findViewById(d.g.concern_unread_tip_info);
        this.drN = (TextView) findViewById(d.g.concern_unread_tip_show);
        this.drO = (ImageView) findViewById(d.g.concern_unread_tip_show_arrow);
        setPadding(0, 0, 0, l.f(context, d.e.tbds44));
        onChangeSkinType();
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.aAL = bdUniqueId;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
        this.drL.setOnClickListener(onClickListener);
    }

    public void setData(e eVar) {
        if (eVar != null) {
            if (!eVar.aum()) {
                setVisibility(8);
                return;
            }
            if (eVar.drp > 0) {
                b.getInstance().putLong(b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), System.currentTimeMillis() + eVar.drp);
            }
            if (this.mInfo != null && !StringUtils.isNull(eVar.drq)) {
                this.mInfo.setText(eVar.drq);
            }
            if (this.drM != null && eVar.dro != null) {
                this.drM.removeAllViews();
                List<String> list = eVar.dro;
                for (int i = 0; i < list.size(); i++) {
                    String str = list.get(i);
                    if (!StringUtils.isNull(str)) {
                        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), d.h.concern_unread_tip_head_group, null);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds94, this.ds94);
                        if (i > 0) {
                            layoutParams.leftMargin = this.drP;
                        }
                        frameLayout.setLayoutParams(layoutParams);
                        HeadImageView headImageView = (HeadImageView) frameLayout.findViewById(d.g.inner_img);
                        headImageView.setIsRound(true);
                        headImageView.setDrawBorder(false);
                        aj.c((ImageView) frameLayout.findViewById(d.g.out_img), d.f.bg_unread_tip_head_border);
                        this.drM.addView(frameLayout);
                        headImageView.setPageId(this.aAL);
                        headImageView.startLoad(str, 12, false);
                    }
                }
            }
        }
    }

    public void onChangeSkinType() {
        aj.k(this, d.C0082d.cp_bg_line_d);
        aj.i(this.mTitle, d.C0082d.cp_cont_b);
        aj.c(this.drL, d.f.icon_home_feedback_selector);
        aj.i(this.mInfo, d.C0082d.cp_cont_b);
        aj.i(this.drN, d.C0082d.cp_cont_b);
        aj.c(this.drO, d.f.icon_arrow_gray_right_n);
    }
}
