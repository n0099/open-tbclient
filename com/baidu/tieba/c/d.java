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
    private RelativeLayout hwF;
    private ImageView hwG;
    private MessageRedDotView hwH;
    private Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.hwF = (RelativeLayout) this.mRootView.findViewById(R.id.message_view_layout);
        this.hwG = (ImageView) this.mRootView.findViewById(R.id.img_message);
        this.hwH = (MessageRedDotView) this.mRootView.findViewById(R.id.img_red_tip);
        this.hwH.setShadowEnabled(true);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView cgp() {
        return this.hwG;
    }

    public MessageRedDotView cgq() {
        return this.hwH;
    }

    public void x(boolean z, int i) {
        if (z) {
            this.hwH.refresh(i);
            this.hwH.setVisibility(0);
            return;
        }
        this.hwH.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.hwH.onChangeSkinType();
        SvgManager.bkl().a(this.hwG, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setVisibility(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }

    public void a(NavigationBar.ControlAlign controlAlign, boolean z) {
        if (!z && controlAlign == NavigationBar.ControlAlign.HORIZONTAL_RIGHT) {
            ((RelativeLayout.LayoutParams) this.hwG.getLayoutParams()).rightMargin = -l.getDimens(this.mContext, R.dimen.tbds10);
            ((RelativeLayout.LayoutParams) this.hwH.getLayoutParams()).rightMargin = -l.getDimens(this.mContext, R.dimen.tbds10);
            this.hwF.getLayoutParams().width = l.getDimens(this.mContext, R.dimen.ds88);
        }
    }
}
