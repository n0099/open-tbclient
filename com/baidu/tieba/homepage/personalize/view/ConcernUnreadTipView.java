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
import com.baidu.tieba.homepage.personalize.data.e;
import java.util.List;
/* loaded from: classes2.dex */
public class ConcernUnreadTipView extends RelativeLayout {
    private BdUniqueId agC;
    private int ds94;
    private TextView iVs;
    public ImageView ixO;
    private LinearLayout kms;
    private TextView kmt;
    private ImageView kmu;
    private int kmv;
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
        this.kmv = 0 - l.getDimens(getContext(), R.dimen.tbds18);
        LayoutInflater.from(context).inflate(R.layout.concern_unread_tip_view_layout, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(R.id.concern_unread_tip_title);
        this.ixO = (ImageView) findViewById(R.id.concern_unread_tip_close);
        this.kms = (LinearLayout) findViewById(R.id.concern_unread_tip_header_box);
        this.iVs = (TextView) findViewById(R.id.concern_unread_tip_info);
        this.kmt = (TextView) findViewById(R.id.concern_unread_tip_show);
        this.kmu = (ImageView) findViewById(R.id.concern_unread_tip_show_arrow);
        setPadding(0, 0, 0, l.getDimens(context, R.dimen.tbds44));
        onChangeSkinType();
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.agC = bdUniqueId;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
        this.ixO.setOnClickListener(onClickListener);
    }

    public void setData(e eVar) {
        if (eVar != null) {
            if (!eVar.cRI()) {
                setVisibility(8);
                return;
            }
            if (eVar.klG > 0) {
                com.baidu.tbadk.core.sharedPref.b.brQ().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), System.currentTimeMillis() + eVar.klG);
            }
            if (this.iVs != null && !StringUtils.isNull(eVar.klH)) {
                this.iVs.setText(eVar.klH);
            }
            if (this.kms != null && eVar.klF != null) {
                this.kms.removeAllViews();
                List<String> list = eVar.klF;
                for (int i = 0; i < list.size(); i++) {
                    String str = list.get(i);
                    if (!StringUtils.isNull(str)) {
                        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.concern_unread_tip_head_group, null);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds94, this.ds94);
                        if (i > 0) {
                            layoutParams.leftMargin = this.kmv;
                        }
                        frameLayout.setLayoutParams(layoutParams);
                        HeadImageView headImageView = (HeadImageView) frameLayout.findViewById(R.id.inner_img);
                        headImageView.setIsRound(true);
                        headImageView.setDrawBorder(false);
                        ap.setImageResource((ImageView) frameLayout.findViewById(R.id.out_img), R.drawable.bg_unread_tip_head_border);
                        this.kms.addView(frameLayout);
                        headImageView.setPageId(this.agC);
                        headImageView.startLoad(str, 12, false);
                    }
                }
            }
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ap.setImageResource(this.ixO, R.drawable.icon_home_card_delete);
        ap.setViewTextColor(this.iVs, R.color.CAM_X0105);
        ap.setViewTextColor(this.kmt, R.color.CAM_X0109);
        SvgManager.bsR().a(this.kmu, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
    }
}
