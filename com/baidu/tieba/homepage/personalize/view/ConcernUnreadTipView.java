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
import com.baidu.tieba.f;
import com.baidu.tieba.homepage.personalize.data.e;
import java.util.List;
/* loaded from: classes2.dex */
public class ConcernUnreadTipView extends RelativeLayout {
    private BdUniqueId aqw;
    public ImageView dZJ;
    private LinearLayout dZK;
    private TextView dZL;
    private ImageView dZM;
    private int dZN;
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
        this.ds94 = l.f(getContext(), f.e.tbds94);
        this.dZN = 0 - l.f(getContext(), f.e.tbds18);
        LayoutInflater.from(context).inflate(f.h.concern_unread_tip_view_layout, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(f.g.concern_unread_tip_title);
        this.dZJ = (ImageView) findViewById(f.g.concern_unread_tip_close);
        this.dZK = (LinearLayout) findViewById(f.g.concern_unread_tip_header_box);
        this.mInfo = (TextView) findViewById(f.g.concern_unread_tip_info);
        this.dZL = (TextView) findViewById(f.g.concern_unread_tip_show);
        this.dZM = (ImageView) findViewById(f.g.concern_unread_tip_show_arrow);
        setPadding(0, 0, 0, l.f(context, f.e.tbds44));
        onChangeSkinType();
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.aqw = bdUniqueId;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
        this.dZJ.setOnClickListener(onClickListener);
    }

    public void setData(e eVar) {
        if (eVar != null) {
            if (!eVar.aEB()) {
                setVisibility(8);
                return;
            }
            if (eVar.dZk > 0) {
                b.getInstance().putLong(b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), System.currentTimeMillis() + eVar.dZk);
            }
            if (this.mInfo != null && !StringUtils.isNull(eVar.dZl)) {
                this.mInfo.setText(eVar.dZl);
            }
            if (this.dZK != null && eVar.dZj != null) {
                this.dZK.removeAllViews();
                List<String> list = eVar.dZj;
                for (int i = 0; i < list.size(); i++) {
                    String str = list.get(i);
                    if (!StringUtils.isNull(str)) {
                        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), f.h.concern_unread_tip_head_group, null);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds94, this.ds94);
                        if (i > 0) {
                            layoutParams.leftMargin = this.dZN;
                        }
                        frameLayout.setLayoutParams(layoutParams);
                        HeadImageView headImageView = (HeadImageView) frameLayout.findViewById(f.g.inner_img);
                        headImageView.setIsRound(true);
                        headImageView.setDrawBorder(false);
                        am.c((ImageView) frameLayout.findViewById(f.g.out_img), f.C0146f.bg_unread_tip_head_border);
                        this.dZK.addView(frameLayout);
                        headImageView.setPageId(this.aqw);
                        headImageView.startLoad(str, 12, false);
                    }
                }
            }
        }
    }

    public void onChangeSkinType() {
        am.j(this, f.d.cp_bg_line_d);
        am.h(this.mTitle, f.d.cp_cont_b);
        am.c(this.dZJ, f.C0146f.icon_home_feedback_selector);
        am.h(this.mInfo, f.d.cp_cont_b);
        am.h(this.dZL, f.d.cp_cont_d);
        am.c(this.dZM, f.C0146f.icon_arrow_gray_right_n);
    }
}
