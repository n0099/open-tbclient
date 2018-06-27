package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.util.AttributeSet;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.personalize.data.e;
import java.util.List;
/* loaded from: classes2.dex */
public class ConcernUnreadTipView extends RelativeLayout {
    private BdUniqueId aqU;
    public ImageView dVU;
    private LinearLayout dVV;
    private TextView dVW;
    private ImageView dVX;
    private int dVY;
    private int ds94;
    private TextView mInfo;
    private TextView mTitle;

    public ConcernUnreadTipView(Context context) {
        super(context);
        init(context);
    }

    public ConcernUnreadTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ConcernUnreadTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.ds94 = l.e(getContext(), d.e.tbds94);
        this.dVY = 0 - l.e(getContext(), d.e.tbds18);
        LayoutInflater.from(context).inflate(d.i.concern_unread_tip_view_layout, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(d.g.concern_unread_tip_title);
        this.dVU = (ImageView) findViewById(d.g.concern_unread_tip_close);
        this.dVV = (LinearLayout) findViewById(d.g.concern_unread_tip_header_box);
        this.mInfo = (TextView) findViewById(d.g.concern_unread_tip_info);
        this.dVW = (TextView) findViewById(d.g.concern_unread_tip_show);
        this.dVX = (ImageView) findViewById(d.g.concern_unread_tip_show_arrow);
        setPadding(0, 0, 0, l.e(context, d.e.tbds44));
        onChangeSkinType();
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.aqU = bdUniqueId;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
        this.dVU.setOnClickListener(onClickListener);
    }

    public void setData(e eVar) {
        if (eVar != null) {
            if (!eVar.aDE()) {
                setVisibility(8);
                return;
            }
            if (eVar.dVv > 0) {
                b.getInstance().putLong(b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), System.currentTimeMillis() + eVar.dVv);
            }
            if (this.mInfo != null && !StringUtils.isNull(eVar.dVw)) {
                this.mInfo.setText(eVar.dVw);
            }
            if (this.dVV != null && eVar.dVu != null) {
                this.dVV.removeAllViews();
                List<String> list = eVar.dVu;
                for (int i = 0; i < list.size(); i++) {
                    String str = list.get(i);
                    if (!StringUtils.isNull(str)) {
                        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), d.i.concern_unread_tip_head_group, null);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds94, this.ds94);
                        if (i > 0) {
                            layoutParams.leftMargin = this.dVY;
                        }
                        frameLayout.setLayoutParams(layoutParams);
                        HeadImageView headImageView = (HeadImageView) frameLayout.findViewById(d.g.inner_img);
                        headImageView.setIsRound(true);
                        headImageView.setDrawBorder(false);
                        am.c((ImageView) frameLayout.findViewById(d.g.out_img), d.f.bg_unread_tip_head_border);
                        this.dVV.addView(frameLayout);
                        headImageView.setPageId(this.aqU);
                        headImageView.startLoad(str, 12, false);
                    }
                }
            }
        }
    }

    public void onChangeSkinType() {
        am.j(this, d.C0142d.cp_bg_line_d);
        am.h(this.mTitle, d.C0142d.cp_cont_b);
        am.c(this.dVU, d.f.icon_home_feedback_selector);
        am.h(this.mInfo, d.C0142d.cp_cont_b);
        am.h(this.dVW, d.C0142d.cp_cont_d);
        am.c(this.dVX, d.f.icon_arrow_gray_right_n);
    }
}
