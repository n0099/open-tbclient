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
public class b {
    private RelativeLayout gKb;
    private ImageView gKc;
    private MessageRedDotView gKd;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.gKb = (RelativeLayout) this.mRootView.findViewById(R.id.message_view_layout);
        this.gKc = (ImageView) this.mRootView.findViewById(R.id.img_message);
        this.gKd = (MessageRedDotView) this.mRootView.findViewById(R.id.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView bMr() {
        return this.gKc;
    }

    public MessageRedDotView bMs() {
        return this.gKd;
    }

    public void v(boolean z, int i) {
        if (z) {
            this.gKd.refresh(i);
            this.gKd.setVisibility(0);
            return;
        }
        this.gKd.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.gKd.onChangeSkinType();
        SvgManager.aUW().a(this.gKc, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setVisibility(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }

    public void a(NavigationBar.ControlAlign controlAlign, boolean z) {
        if (!z && controlAlign == NavigationBar.ControlAlign.HORIZONTAL_RIGHT) {
            ((RelativeLayout.LayoutParams) this.gKc.getLayoutParams()).rightMargin = -l.getDimens(this.mContext, R.dimen.tbds10);
            ((RelativeLayout.LayoutParams) this.gKd.getLayoutParams()).rightMargin = -l.getDimens(this.mContext, R.dimen.tbds10);
            this.gKb.getLayoutParams().width = l.getDimens(this.mContext, R.dimen.ds88);
        }
    }
}
