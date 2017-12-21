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
    private BdUniqueId aAT;
    private int ds94;
    public ImageView dsU;
    private LinearLayout dsV;
    private TextView dsW;
    private ImageView dsX;
    private int dsY;
    private TextView mInfo;
    private TextView mTitle;

    public a(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.ds94 = l.f(getContext(), d.e.tbds94);
        this.dsY = 0 - l.f(getContext(), d.e.tbds18);
        LayoutInflater.from(context).inflate(d.h.concern_unread_tip_view_layout, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(d.g.concern_unread_tip_title);
        this.dsU = (ImageView) findViewById(d.g.concern_unread_tip_close);
        this.dsV = (LinearLayout) findViewById(d.g.concern_unread_tip_header_box);
        this.mInfo = (TextView) findViewById(d.g.concern_unread_tip_info);
        this.dsW = (TextView) findViewById(d.g.concern_unread_tip_show);
        this.dsX = (ImageView) findViewById(d.g.concern_unread_tip_show_arrow);
        setPadding(0, 0, 0, l.f(context, d.e.tbds44));
        onChangeSkinType();
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.aAT = bdUniqueId;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
        this.dsU.setOnClickListener(onClickListener);
    }

    public void setData(e eVar) {
        if (eVar != null) {
            if (!eVar.auv()) {
                setVisibility(8);
                return;
            }
            if (eVar.dsy > 0) {
                b.getInstance().putLong(b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), System.currentTimeMillis() + eVar.dsy);
            }
            if (this.mInfo != null && !StringUtils.isNull(eVar.dsz)) {
                this.mInfo.setText(eVar.dsz);
            }
            if (this.dsV != null && eVar.dsx != null) {
                this.dsV.removeAllViews();
                List<String> list = eVar.dsx;
                for (int i = 0; i < list.size(); i++) {
                    String str = list.get(i);
                    if (!StringUtils.isNull(str)) {
                        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), d.h.concern_unread_tip_head_group, null);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds94, this.ds94);
                        if (i > 0) {
                            layoutParams.leftMargin = this.dsY;
                        }
                        frameLayout.setLayoutParams(layoutParams);
                        HeadImageView headImageView = (HeadImageView) frameLayout.findViewById(d.g.inner_img);
                        headImageView.setIsRound(true);
                        headImageView.setDrawBorder(false);
                        aj.c((ImageView) frameLayout.findViewById(d.g.out_img), d.f.bg_unread_tip_head_border);
                        this.dsV.addView(frameLayout);
                        headImageView.setPageId(this.aAT);
                        headImageView.startLoad(str, 12, false);
                    }
                }
            }
        }
    }

    public void onChangeSkinType() {
        aj.k(this, d.C0095d.cp_bg_line_d);
        aj.i(this.mTitle, d.C0095d.cp_cont_b);
        aj.c(this.dsU, d.f.icon_home_feedback_selector);
        aj.i(this.mInfo, d.C0095d.cp_cont_b);
        aj.i(this.dsW, d.C0095d.cp_cont_d);
        aj.c(this.dsX, d.f.icon_arrow_gray_right_n);
    }
}
