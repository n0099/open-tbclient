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
    private RelativeLayout hcG;
    private ImageView hcH;
    private MessageRedDotView hcI;
    private Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.hcG = (RelativeLayout) this.mRootView.findViewById(R.id.message_view_layout);
        this.hcH = (ImageView) this.mRootView.findViewById(R.id.img_message);
        this.hcI = (MessageRedDotView) this.mRootView.findViewById(R.id.img_red_tip);
        this.hcI.setShadowEnabled(true);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView bSN() {
        return this.hcH;
    }

    public MessageRedDotView bSO() {
        return this.hcI;
    }

    public void x(boolean z, int i) {
        if (z) {
            this.hcI.refresh(i);
            this.hcI.setVisibility(0);
            return;
        }
        this.hcI.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.hcI.onChangeSkinType();
        SvgManager.baR().a(this.hcH, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setVisibility(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }

    public void a(NavigationBar.ControlAlign controlAlign, boolean z) {
        if (!z && controlAlign == NavigationBar.ControlAlign.HORIZONTAL_RIGHT) {
            ((RelativeLayout.LayoutParams) this.hcH.getLayoutParams()).rightMargin = -l.getDimens(this.mContext, R.dimen.tbds10);
            ((RelativeLayout.LayoutParams) this.hcI.getLayoutParams()).rightMargin = -l.getDimens(this.mContext, R.dimen.tbds10);
            this.hcG.getLayoutParams().width = l.getDimens(this.mContext, R.dimen.ds88);
        }
    }
}
