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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes16.dex */
public class ConcernUnreadTipView extends RelativeLayout {
    private BdUniqueId agB;
    private int ds94;
    public ImageView gwo;
    private TextView huu;
    private LinearLayout iBJ;
    private TextView iBK;
    private ImageView iBL;
    private int iBM;
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
        this.iBM = 0 - l.getDimens(getContext(), R.dimen.tbds18);
        LayoutInflater.from(context).inflate(R.layout.concern_unread_tip_view_layout, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(R.id.concern_unread_tip_title);
        this.gwo = (ImageView) findViewById(R.id.concern_unread_tip_close);
        this.iBJ = (LinearLayout) findViewById(R.id.concern_unread_tip_header_box);
        this.huu = (TextView) findViewById(R.id.concern_unread_tip_info);
        this.iBK = (TextView) findViewById(R.id.concern_unread_tip_show);
        this.iBL = (ImageView) findViewById(R.id.concern_unread_tip_show_arrow);
        setPadding(0, 0, 0, l.getDimens(context, R.dimen.tbds44));
        onChangeSkinType();
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.agB = bdUniqueId;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
        this.gwo.setOnClickListener(onClickListener);
    }

    public void setData(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (eVar != null) {
            if (!eVar.cnA()) {
                setVisibility(8);
                return;
            }
            if (eVar.iAX > 0) {
                com.baidu.tbadk.core.sharedPref.b.aZP().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), System.currentTimeMillis() + eVar.iAX);
            }
            if (this.huu != null && !StringUtils.isNull(eVar.iAY)) {
                this.huu.setText(eVar.iAY);
            }
            if (this.iBJ != null && eVar.iAW != null) {
                this.iBJ.removeAllViews();
                List<String> list = eVar.iAW;
                for (int i = 0; i < list.size(); i++) {
                    String str = list.get(i);
                    if (!StringUtils.isNull(str)) {
                        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.concern_unread_tip_head_group, null);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds94, this.ds94);
                        if (i > 0) {
                            layoutParams.leftMargin = this.iBM;
                        }
                        frameLayout.setLayoutParams(layoutParams);
                        HeadImageView headImageView = (HeadImageView) frameLayout.findViewById(R.id.inner_img);
                        headImageView.setIsRound(true);
                        headImageView.setDrawBorder(false);
                        ao.setImageResource((ImageView) frameLayout.findViewById(R.id.out_img), R.drawable.bg_unread_tip_head_border);
                        this.iBJ.addView(frameLayout);
                        headImageView.setPageId(this.agB);
                        headImageView.startLoad(str, 12, false);
                    }
                }
            }
        }
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.mTitle, R.color.cp_cont_b);
        ao.setImageResource(this.gwo, R.drawable.icon_home_card_delete);
        ao.setViewTextColor(this.huu, R.color.cp_cont_b);
        ao.setViewTextColor(this.iBK, R.color.cp_cont_d);
        SvgManager.baR().a(this.iBL, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }
}
