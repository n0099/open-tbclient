package com.baidu.tieba.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private RelativeLayout hXX;
    private ImageView hXY;
    private MessageRedDotView hXZ;
    private Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.hXX = (RelativeLayout) this.mRootView.findViewById(R.id.message_view_layout);
        this.hXY = (ImageView) this.mRootView.findViewById(R.id.img_message);
        this.hXZ = (MessageRedDotView) this.mRootView.findViewById(R.id.img_red_tip);
        this.hXZ.setShadowEnabled(true);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView cmS() {
        return this.hXY;
    }

    public MessageRedDotView cmT() {
        return this.hXZ;
    }

    public void A(boolean z, int i) {
        if (z) {
            this.hXZ.refresh(i);
            this.hXZ.setVisibility(0);
            return;
        }
        this.hXZ.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.hXZ.onChangeSkinType();
        SvgManager.boN().a(this.hXY, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setVisibility(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }

    public void a(NavigationBar.ControlAlign controlAlign, boolean z) {
        if (!z && controlAlign == NavigationBar.ControlAlign.HORIZONTAL_RIGHT) {
            ((RelativeLayout.LayoutParams) this.hXY.getLayoutParams()).rightMargin = -l.getDimens(this.mContext, R.dimen.tbds10);
            ((RelativeLayout.LayoutParams) this.hXZ.getLayoutParams()).rightMargin = -l.getDimens(this.mContext, R.dimen.tbds10);
            this.hXX.getLayoutParams().width = l.getDimens(this.mContext, R.dimen.ds88);
        }
    }
}
