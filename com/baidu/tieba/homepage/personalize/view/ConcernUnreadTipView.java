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
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes22.dex */
public class ConcernUnreadTipView extends RelativeLayout {
    private BdUniqueId ajD;
    private int ds94;
    private TextView iHT;
    public ImageView jVp;
    private LinearLayout jVq;
    private TextView jVr;
    private ImageView jVs;
    private int jVt;
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
        this.ds94 = l.getDimens(getContext(), R.dimen.tbds94);
        this.jVt = 0 - l.getDimens(getContext(), R.dimen.tbds18);
        LayoutInflater.from(context).inflate(R.layout.concern_unread_tip_view_layout, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(R.id.concern_unread_tip_title);
        this.jVp = (ImageView) findViewById(R.id.concern_unread_tip_close);
        this.jVq = (LinearLayout) findViewById(R.id.concern_unread_tip_header_box);
        this.iHT = (TextView) findViewById(R.id.concern_unread_tip_info);
        this.jVr = (TextView) findViewById(R.id.concern_unread_tip_show);
        this.jVs = (ImageView) findViewById(R.id.concern_unread_tip_show_arrow);
        setPadding(0, 0, 0, l.getDimens(context, R.dimen.tbds44));
        onChangeSkinType();
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.ajD = bdUniqueId;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
        this.jVp.setOnClickListener(onClickListener);
    }

    public void setData(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (eVar != null) {
            if (!eVar.cQn()) {
                setVisibility(8);
                return;
            }
            if (eVar.jUD > 0) {
                com.baidu.tbadk.core.sharedPref.b.bsO().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), System.currentTimeMillis() + eVar.jUD);
            }
            if (this.iHT != null && !StringUtils.isNull(eVar.jUE)) {
                this.iHT.setText(eVar.jUE);
            }
            if (this.jVq != null && eVar.jUC != null) {
                this.jVq.removeAllViews();
                List<String> list = eVar.jUC;
                for (int i = 0; i < list.size(); i++) {
                    String str = list.get(i);
                    if (!StringUtils.isNull(str)) {
                        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.concern_unread_tip_head_group, null);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds94, this.ds94);
                        if (i > 0) {
                            layoutParams.leftMargin = this.jVt;
                        }
                        frameLayout.setLayoutParams(layoutParams);
                        HeadImageView headImageView = (HeadImageView) frameLayout.findViewById(R.id.inner_img);
                        headImageView.setIsRound(true);
                        headImageView.setDrawBorder(false);
                        ap.setImageResource((ImageView) frameLayout.findViewById(R.id.out_img), R.drawable.bg_unread_tip_head_border);
                        this.jVq.addView(frameLayout);
                        headImageView.setPageId(this.ajD);
                        headImageView.startLoad(str, 12, false);
                    }
                }
            }
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ap.setImageResource(this.jVp, R.drawable.icon_home_card_delete);
        ap.setViewTextColor(this.iHT, R.color.CAM_X0105);
        ap.setViewTextColor(this.jVr, R.color.CAM_X0109);
        SvgManager.btW().a(this.jVs, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
    }
}
