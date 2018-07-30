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
    private BdUniqueId aqv;
    public ImageView dZM;
    private LinearLayout dZN;
    private TextView dZO;
    private ImageView dZP;
    private int dZQ;
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
        this.ds94 = l.f(getContext(), d.e.tbds94);
        this.dZQ = 0 - l.f(getContext(), d.e.tbds18);
        LayoutInflater.from(context).inflate(d.h.concern_unread_tip_view_layout, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(d.g.concern_unread_tip_title);
        this.dZM = (ImageView) findViewById(d.g.concern_unread_tip_close);
        this.dZN = (LinearLayout) findViewById(d.g.concern_unread_tip_header_box);
        this.mInfo = (TextView) findViewById(d.g.concern_unread_tip_info);
        this.dZO = (TextView) findViewById(d.g.concern_unread_tip_show);
        this.dZP = (ImageView) findViewById(d.g.concern_unread_tip_show_arrow);
        setPadding(0, 0, 0, l.f(context, d.e.tbds44));
        onChangeSkinType();
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.aqv = bdUniqueId;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
        this.dZM.setOnClickListener(onClickListener);
    }

    public void setData(e eVar) {
        if (eVar != null) {
            if (!eVar.aEE()) {
                setVisibility(8);
                return;
            }
            if (eVar.dZn > 0) {
                b.getInstance().putLong(b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), System.currentTimeMillis() + eVar.dZn);
            }
            if (this.mInfo != null && !StringUtils.isNull(eVar.dZo)) {
                this.mInfo.setText(eVar.dZo);
            }
            if (this.dZN != null && eVar.dZm != null) {
                this.dZN.removeAllViews();
                List<String> list = eVar.dZm;
                for (int i = 0; i < list.size(); i++) {
                    String str = list.get(i);
                    if (!StringUtils.isNull(str)) {
                        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), d.h.concern_unread_tip_head_group, null);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds94, this.ds94);
                        if (i > 0) {
                            layoutParams.leftMargin = this.dZQ;
                        }
                        frameLayout.setLayoutParams(layoutParams);
                        HeadImageView headImageView = (HeadImageView) frameLayout.findViewById(d.g.inner_img);
                        headImageView.setIsRound(true);
                        headImageView.setDrawBorder(false);
                        am.c((ImageView) frameLayout.findViewById(d.g.out_img), d.f.bg_unread_tip_head_border);
                        this.dZN.addView(frameLayout);
                        headImageView.setPageId(this.aqv);
                        headImageView.startLoad(str, 12, false);
                    }
                }
            }
        }
    }

    public void onChangeSkinType() {
        am.j(this, d.C0140d.cp_bg_line_d);
        am.h(this.mTitle, d.C0140d.cp_cont_b);
        am.c(this.dZM, d.f.icon_home_feedback_selector);
        am.h(this.mInfo, d.C0140d.cp_cont_b);
        am.h(this.dZO, d.C0140d.cp_cont_d);
        am.c(this.dZP, d.f.icon_arrow_gray_right_n);
    }
}
