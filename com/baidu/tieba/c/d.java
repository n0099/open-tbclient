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
    private RelativeLayout hpB;
    private ImageView hpC;
    private MessageRedDotView hpD;
    private Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.hpB = (RelativeLayout) this.mRootView.findViewById(R.id.message_view_layout);
        this.hpC = (ImageView) this.mRootView.findViewById(R.id.img_message);
        this.hpD = (MessageRedDotView) this.mRootView.findViewById(R.id.img_red_tip);
        this.hpD.setShadowEnabled(true);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView cda() {
        return this.hpC;
    }

    public MessageRedDotView cdb() {
        return this.hpD;
    }

    public void x(boolean z, int i) {
        if (z) {
            this.hpD.refresh(i);
            this.hpD.setVisibility(0);
            return;
        }
        this.hpD.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.hpD.onChangeSkinType();
        SvgManager.bjq().a(this.hpC, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setVisibility(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }

    public void a(NavigationBar.ControlAlign controlAlign, boolean z) {
        if (!z && controlAlign == NavigationBar.ControlAlign.HORIZONTAL_RIGHT) {
            ((RelativeLayout.LayoutParams) this.hpC.getLayoutParams()).rightMargin = -l.getDimens(this.mContext, R.dimen.tbds10);
            ((RelativeLayout.LayoutParams) this.hpD.getLayoutParams()).rightMargin = -l.getDimens(this.mContext, R.dimen.tbds10);
            this.hpB.getLayoutParams().width = l.getDimens(this.mContext, R.dimen.ds88);
        }
    }
}
