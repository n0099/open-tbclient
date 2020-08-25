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
/* loaded from: classes2.dex */
public class d {
    private RelativeLayout hpx;
    private ImageView hpy;
    private MessageRedDotView hpz;
    private Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.hpx = (RelativeLayout) this.mRootView.findViewById(R.id.message_view_layout);
        this.hpy = (ImageView) this.mRootView.findViewById(R.id.img_message);
        this.hpz = (MessageRedDotView) this.mRootView.findViewById(R.id.img_red_tip);
        this.hpz.setShadowEnabled(true);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView ccZ() {
        return this.hpy;
    }

    public MessageRedDotView cda() {
        return this.hpz;
    }

    public void x(boolean z, int i) {
        if (z) {
            this.hpz.refresh(i);
            this.hpz.setVisibility(0);
            return;
        }
        this.hpz.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.hpz.onChangeSkinType();
        SvgManager.bjq().a(this.hpy, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setVisibility(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }

    public void a(NavigationBar.ControlAlign controlAlign, boolean z) {
        if (!z && controlAlign == NavigationBar.ControlAlign.HORIZONTAL_RIGHT) {
            ((RelativeLayout.LayoutParams) this.hpy.getLayoutParams()).rightMargin = -l.getDimens(this.mContext, R.dimen.tbds10);
            ((RelativeLayout.LayoutParams) this.hpz.getLayoutParams()).rightMargin = -l.getDimens(this.mContext, R.dimen.tbds10);
            this.hpx.getLayoutParams().width = l.getDimens(this.mContext, R.dimen.ds88);
        }
    }
}
