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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class ConcernUnreadTipView extends RelativeLayout {
    private BdUniqueId afD;
    private int ds94;
    public ImageView fPd;
    private TextView gNA;
    private LinearLayout hQW;
    private TextView hQX;
    private ImageView hQY;
    private int hQZ;
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
        this.hQZ = 0 - l.getDimens(getContext(), R.dimen.tbds18);
        LayoutInflater.from(context).inflate(R.layout.concern_unread_tip_view_layout, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(R.id.concern_unread_tip_title);
        this.fPd = (ImageView) findViewById(R.id.concern_unread_tip_close);
        this.hQW = (LinearLayout) findViewById(R.id.concern_unread_tip_header_box);
        this.gNA = (TextView) findViewById(R.id.concern_unread_tip_info);
        this.hQX = (TextView) findViewById(R.id.concern_unread_tip_show);
        this.hQY = (ImageView) findViewById(R.id.concern_unread_tip_show_arrow);
        setPadding(0, 0, 0, l.getDimens(context, R.dimen.tbds44));
        onChangeSkinType();
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.afD = bdUniqueId;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
        this.fPd.setOnClickListener(onClickListener);
    }

    public void setData(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (eVar != null) {
            if (!eVar.bZU()) {
                setVisibility(8);
                return;
            }
            if (eVar.hQq > 0) {
                com.baidu.tbadk.core.sharedPref.b.aNT().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), System.currentTimeMillis() + eVar.hQq);
            }
            if (this.gNA != null && !StringUtils.isNull(eVar.hQr)) {
                this.gNA.setText(eVar.hQr);
            }
            if (this.hQW != null && eVar.hQp != null) {
                this.hQW.removeAllViews();
                List<String> list = eVar.hQp;
                for (int i = 0; i < list.size(); i++) {
                    String str = list.get(i);
                    if (!StringUtils.isNull(str)) {
                        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.concern_unread_tip_head_group, null);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds94, this.ds94);
                        if (i > 0) {
                            layoutParams.leftMargin = this.hQZ;
                        }
                        frameLayout.setLayoutParams(layoutParams);
                        HeadImageView headImageView = (HeadImageView) frameLayout.findViewById(R.id.inner_img);
                        headImageView.setIsRound(true);
                        headImageView.setDrawBorder(false);
                        am.setImageResource((ImageView) frameLayout.findViewById(R.id.out_img), R.drawable.bg_unread_tip_head_border);
                        this.hQW.addView(frameLayout);
                        headImageView.setPageId(this.afD);
                        headImageView.startLoad(str, 12, false);
                    }
                }
            }
        }
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        am.setImageResource(this.fPd, R.drawable.icon_home_card_delete);
        am.setViewTextColor(this.gNA, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hQX, (int) R.color.cp_cont_d);
        SvgManager.aOR().a(this.hQY, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }
}
