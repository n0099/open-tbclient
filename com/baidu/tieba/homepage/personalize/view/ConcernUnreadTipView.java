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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class ConcernUnreadTipView extends RelativeLayout {
    private BdUniqueId agK;
    private int ds94;
    public ImageView gqS;
    private TextView hoI;
    private LinearLayout ivF;
    private TextView ivG;
    private ImageView ivH;
    private int ivI;
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
        this.ivI = 0 - l.getDimens(getContext(), R.dimen.tbds18);
        LayoutInflater.from(context).inflate(R.layout.concern_unread_tip_view_layout, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(R.id.concern_unread_tip_title);
        this.gqS = (ImageView) findViewById(R.id.concern_unread_tip_close);
        this.ivF = (LinearLayout) findViewById(R.id.concern_unread_tip_header_box);
        this.hoI = (TextView) findViewById(R.id.concern_unread_tip_info);
        this.ivG = (TextView) findViewById(R.id.concern_unread_tip_show);
        this.ivH = (ImageView) findViewById(R.id.concern_unread_tip_show_arrow);
        setPadding(0, 0, 0, l.getDimens(context, R.dimen.tbds44));
        onChangeSkinType();
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.agK = bdUniqueId;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
        this.gqS.setOnClickListener(onClickListener);
    }

    public void setData(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (eVar != null) {
            if (!eVar.cjY()) {
                setVisibility(8);
                return;
            }
            if (eVar.iuT > 0) {
                com.baidu.tbadk.core.sharedPref.b.aVP().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), System.currentTimeMillis() + eVar.iuT);
            }
            if (this.hoI != null && !StringUtils.isNull(eVar.iuU)) {
                this.hoI.setText(eVar.iuU);
            }
            if (this.ivF != null && eVar.iuS != null) {
                this.ivF.removeAllViews();
                List<String> list = eVar.iuS;
                for (int i = 0; i < list.size(); i++) {
                    String str = list.get(i);
                    if (!StringUtils.isNull(str)) {
                        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.concern_unread_tip_head_group, null);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds94, this.ds94);
                        if (i > 0) {
                            layoutParams.leftMargin = this.ivI;
                        }
                        frameLayout.setLayoutParams(layoutParams);
                        HeadImageView headImageView = (HeadImageView) frameLayout.findViewById(R.id.inner_img);
                        headImageView.setIsRound(true);
                        headImageView.setDrawBorder(false);
                        an.setImageResource((ImageView) frameLayout.findViewById(R.id.out_img), R.drawable.bg_unread_tip_head_border);
                        this.ivF.addView(frameLayout);
                        headImageView.setPageId(this.agK);
                        headImageView.startLoad(str, 12, false);
                    }
                }
            }
        }
    }

    public void onChangeSkinType() {
        an.setBackgroundColor(this, R.color.cp_bg_line_d);
        an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        an.setImageResource(this.gqS, R.drawable.icon_home_card_delete);
        an.setViewTextColor(this.hoI, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.ivG, (int) R.color.cp_cont_d);
        SvgManager.aWQ().a(this.ivH, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }
}
