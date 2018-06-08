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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.personalize.data.e;
import java.util.List;
/* loaded from: classes2.dex */
public class ConcernUnreadTipView extends RelativeLayout {
    private BdUniqueId aKh;
    public ImageView dSa;
    private LinearLayout dSb;
    private TextView dSc;
    private ImageView dSd;
    private int dSe;
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
        this.dSe = 0 - l.e(getContext(), d.e.tbds18);
        LayoutInflater.from(context).inflate(d.i.concern_unread_tip_view_layout, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(d.g.concern_unread_tip_title);
        this.dSa = (ImageView) findViewById(d.g.concern_unread_tip_close);
        this.dSb = (LinearLayout) findViewById(d.g.concern_unread_tip_header_box);
        this.mInfo = (TextView) findViewById(d.g.concern_unread_tip_info);
        this.dSc = (TextView) findViewById(d.g.concern_unread_tip_show);
        this.dSd = (ImageView) findViewById(d.g.concern_unread_tip_show_arrow);
        setPadding(0, 0, 0, l.e(context, d.e.tbds44));
        onChangeSkinType();
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.aKh = bdUniqueId;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
        this.dSa.setOnClickListener(onClickListener);
    }

    public void setData(e eVar) {
        if (eVar != null) {
            if (!eVar.aCU()) {
                setVisibility(8);
                return;
            }
            if (eVar.dRC > 0) {
                b.getInstance().putLong(b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), System.currentTimeMillis() + eVar.dRC);
            }
            if (this.mInfo != null && !StringUtils.isNull(eVar.dRD)) {
                this.mInfo.setText(eVar.dRD);
            }
            if (this.dSb != null && eVar.dRB != null) {
                this.dSb.removeAllViews();
                List<String> list = eVar.dRB;
                for (int i = 0; i < list.size(); i++) {
                    String str = list.get(i);
                    if (!StringUtils.isNull(str)) {
                        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), d.i.concern_unread_tip_head_group, null);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds94, this.ds94);
                        if (i > 0) {
                            layoutParams.leftMargin = this.dSe;
                        }
                        frameLayout.setLayoutParams(layoutParams);
                        HeadImageView headImageView = (HeadImageView) frameLayout.findViewById(d.g.inner_img);
                        headImageView.setIsRound(true);
                        headImageView.setDrawBorder(false);
                        al.c((ImageView) frameLayout.findViewById(d.g.out_img), d.f.bg_unread_tip_head_border);
                        this.dSb.addView(frameLayout);
                        headImageView.setPageId(this.aKh);
                        headImageView.startLoad(str, 12, false);
                    }
                }
            }
        }
    }

    public void onChangeSkinType() {
        al.j(this, d.C0141d.cp_bg_line_d);
        al.h(this.mTitle, d.C0141d.cp_cont_b);
        al.c(this.dSa, d.f.icon_home_feedback_selector);
        al.h(this.mInfo, d.C0141d.cp_cont_b);
        al.h(this.dSc, d.C0141d.cp_cont_d);
        al.c(this.dSd, d.f.icon_arrow_gray_right_n);
    }
}
