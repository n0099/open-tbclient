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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.personalize.data.e;
import java.util.List;
/* loaded from: classes4.dex */
public class ConcernUnreadTipView extends RelativeLayout {
    private BdUniqueId Zq;
    private int ds94;
    public ImageView fNR;
    private LinearLayout fNS;
    private TextView fNT;
    private ImageView fNU;
    private int fNV;
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
        this.ds94 = l.h(getContext(), d.e.tbds94);
        this.fNV = 0 - l.h(getContext(), d.e.tbds18);
        LayoutInflater.from(context).inflate(d.h.concern_unread_tip_view_layout, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(d.g.concern_unread_tip_title);
        this.fNR = (ImageView) findViewById(d.g.concern_unread_tip_close);
        this.fNS = (LinearLayout) findViewById(d.g.concern_unread_tip_header_box);
        this.mInfo = (TextView) findViewById(d.g.concern_unread_tip_info);
        this.fNT = (TextView) findViewById(d.g.concern_unread_tip_show);
        this.fNU = (ImageView) findViewById(d.g.concern_unread_tip_show_arrow);
        setPadding(0, 0, 0, l.h(context, d.e.tbds44));
        onChangeSkinType();
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.Zq = bdUniqueId;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
        this.fNR.setOnClickListener(onClickListener);
    }

    public void setData(e eVar) {
        if (eVar != null) {
            if (!eVar.bmV()) {
                setVisibility(8);
                return;
            }
            if (eVar.fNr > 0) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), System.currentTimeMillis() + eVar.fNr);
            }
            if (this.mInfo != null && !StringUtils.isNull(eVar.fNs)) {
                this.mInfo.setText(eVar.fNs);
            }
            if (this.fNS != null && eVar.fNq != null) {
                this.fNS.removeAllViews();
                List<String> list = eVar.fNq;
                for (int i = 0; i < list.size(); i++) {
                    String str = list.get(i);
                    if (!StringUtils.isNull(str)) {
                        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), d.h.concern_unread_tip_head_group, null);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds94, this.ds94);
                        if (i > 0) {
                            layoutParams.leftMargin = this.fNV;
                        }
                        frameLayout.setLayoutParams(layoutParams);
                        HeadImageView headImageView = (HeadImageView) frameLayout.findViewById(d.g.inner_img);
                        headImageView.setIsRound(true);
                        headImageView.setDrawBorder(false);
                        al.c((ImageView) frameLayout.findViewById(d.g.out_img), d.f.bg_unread_tip_head_border);
                        this.fNS.addView(frameLayout);
                        headImageView.setPageId(this.Zq);
                        headImageView.startLoad(str, 12, false);
                    }
                }
            }
        }
    }

    public void onChangeSkinType() {
        al.l(this, d.C0236d.cp_bg_line_d);
        al.j(this.mTitle, d.C0236d.cp_cont_b);
        al.c(this.fNR, d.f.icon_home_card_delete);
        al.j(this.mInfo, d.C0236d.cp_cont_b);
        al.j(this.fNT, d.C0236d.cp_cont_d);
        al.c(this.fNU, d.f.icon_arrow_gray_right_n);
    }
}
