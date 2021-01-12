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
import com.baidu.tieba.homepage.personalize.data.e;
import java.util.List;
/* loaded from: classes2.dex */
public class ConcernUnreadTipView extends RelativeLayout {
    private BdUniqueId agN;
    private int ds94;
    private TextView iPx;
    public ImageView kdU;
    private LinearLayout kdV;
    private TextView kdW;
    private ImageView kdX;
    private int kdY;
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
        this.kdY = 0 - l.getDimens(getContext(), R.dimen.tbds18);
        LayoutInflater.from(context).inflate(R.layout.concern_unread_tip_view_layout, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(R.id.concern_unread_tip_title);
        this.kdU = (ImageView) findViewById(R.id.concern_unread_tip_close);
        this.kdV = (LinearLayout) findViewById(R.id.concern_unread_tip_header_box);
        this.iPx = (TextView) findViewById(R.id.concern_unread_tip_info);
        this.kdW = (TextView) findViewById(R.id.concern_unread_tip_show);
        this.kdX = (ImageView) findViewById(R.id.concern_unread_tip_show_arrow);
        setPadding(0, 0, 0, l.getDimens(context, R.dimen.tbds44));
        onChangeSkinType();
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.agN = bdUniqueId;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
        this.kdU.setOnClickListener(onClickListener);
    }

    public void setData(e eVar) {
        if (eVar != null) {
            if (!eVar.cPC()) {
                setVisibility(8);
                return;
            }
            if (eVar.kdi > 0) {
                com.baidu.tbadk.core.sharedPref.b.brx().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), System.currentTimeMillis() + eVar.kdi);
            }
            if (this.iPx != null && !StringUtils.isNull(eVar.kdj)) {
                this.iPx.setText(eVar.kdj);
            }
            if (this.kdV != null && eVar.kdh != null) {
                this.kdV.removeAllViews();
                List<String> list = eVar.kdh;
                for (int i = 0; i < list.size(); i++) {
                    String str = list.get(i);
                    if (!StringUtils.isNull(str)) {
                        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.concern_unread_tip_head_group, null);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds94, this.ds94);
                        if (i > 0) {
                            layoutParams.leftMargin = this.kdY;
                        }
                        frameLayout.setLayoutParams(layoutParams);
                        HeadImageView headImageView = (HeadImageView) frameLayout.findViewById(R.id.inner_img);
                        headImageView.setIsRound(true);
                        headImageView.setDrawBorder(false);
                        ao.setImageResource((ImageView) frameLayout.findViewById(R.id.out_img), R.drawable.bg_unread_tip_head_border);
                        this.kdV.addView(frameLayout);
                        headImageView.setPageId(this.agN);
                        headImageView.startLoad(str, 12, false);
                    }
                }
            }
        }
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this, R.color.CAM_X0201);
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ao.setImageResource(this.kdU, R.drawable.icon_home_card_delete);
        ao.setViewTextColor(this.iPx, R.color.CAM_X0105);
        ao.setViewTextColor(this.kdW, R.color.CAM_X0109);
        SvgManager.bsx().a(this.kdX, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
    }
}
