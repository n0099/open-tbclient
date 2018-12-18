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
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes6.dex */
public class ConcernUnreadTipView extends RelativeLayout {
    private BdUniqueId aBS;
    private int ds94;
    public ImageView exm;
    private LinearLayout exn;
    private TextView exo;
    private ImageView exp;
    private int exq;
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
        this.ds94 = l.h(getContext(), e.C0210e.tbds94);
        this.exq = 0 - l.h(getContext(), e.C0210e.tbds18);
        LayoutInflater.from(context).inflate(e.h.concern_unread_tip_view_layout, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(e.g.concern_unread_tip_title);
        this.exm = (ImageView) findViewById(e.g.concern_unread_tip_close);
        this.exn = (LinearLayout) findViewById(e.g.concern_unread_tip_header_box);
        this.mInfo = (TextView) findViewById(e.g.concern_unread_tip_info);
        this.exo = (TextView) findViewById(e.g.concern_unread_tip_show);
        this.exp = (ImageView) findViewById(e.g.concern_unread_tip_show_arrow);
        setPadding(0, 0, 0, l.h(context, e.C0210e.tbds44));
        onChangeSkinType();
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.aBS = bdUniqueId;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
        this.exm.setOnClickListener(onClickListener);
    }

    public void setData(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (eVar != null) {
            if (!eVar.aLx()) {
                setVisibility(8);
                return;
            }
            if (eVar.ewO > 0) {
                b.getInstance().putLong(b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), System.currentTimeMillis() + eVar.ewO);
            }
            if (this.mInfo != null && !StringUtils.isNull(eVar.ewP)) {
                this.mInfo.setText(eVar.ewP);
            }
            if (this.exn != null && eVar.ewN != null) {
                this.exn.removeAllViews();
                List<String> list = eVar.ewN;
                for (int i = 0; i < list.size(); i++) {
                    String str = list.get(i);
                    if (!StringUtils.isNull(str)) {
                        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), e.h.concern_unread_tip_head_group, null);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds94, this.ds94);
                        if (i > 0) {
                            layoutParams.leftMargin = this.exq;
                        }
                        frameLayout.setLayoutParams(layoutParams);
                        HeadImageView headImageView = (HeadImageView) frameLayout.findViewById(e.g.inner_img);
                        headImageView.setIsRound(true);
                        headImageView.setDrawBorder(false);
                        al.c((ImageView) frameLayout.findViewById(e.g.out_img), e.f.bg_unread_tip_head_border);
                        this.exn.addView(frameLayout);
                        headImageView.setPageId(this.aBS);
                        headImageView.startLoad(str, 12, false);
                    }
                }
            }
        }
    }

    public void onChangeSkinType() {
        al.j(this, e.d.cp_bg_line_d);
        al.h(this.mTitle, e.d.cp_cont_b);
        al.c(this.exm, e.f.icon_home_feedback_selector);
        al.h(this.mInfo, e.d.cp_cont_b);
        al.h(this.exo, e.d.cp_cont_d);
        al.c(this.exp, e.f.icon_arrow_gray_right_n);
    }
}
