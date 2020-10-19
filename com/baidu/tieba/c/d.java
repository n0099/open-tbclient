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
    private RelativeLayout hLA;
    private ImageView hLB;
    private MessageRedDotView hLC;
    private Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.hLA = (RelativeLayout) this.mRootView.findViewById(R.id.message_view_layout);
        this.hLB = (ImageView) this.mRootView.findViewById(R.id.img_message);
        this.hLC = (MessageRedDotView) this.mRootView.findViewById(R.id.img_red_tip);
        this.hLC.setShadowEnabled(true);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView cjL() {
        return this.hLB;
    }

    public MessageRedDotView cjM() {
        return this.hLC;
    }

    public void A(boolean z, int i) {
        if (z) {
            this.hLC.refresh(i);
            this.hLC.setVisibility(0);
            return;
        }
        this.hLC.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.hLC.onChangeSkinType();
        SvgManager.bmU().a(this.hLB, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setVisibility(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }

    public void a(NavigationBar.ControlAlign controlAlign, boolean z) {
        if (!z && controlAlign == NavigationBar.ControlAlign.HORIZONTAL_RIGHT) {
            ((RelativeLayout.LayoutParams) this.hLB.getLayoutParams()).rightMargin = -l.getDimens(this.mContext, R.dimen.tbds10);
            ((RelativeLayout.LayoutParams) this.hLC.getLayoutParams()).rightMargin = -l.getDimens(this.mContext, R.dimen.tbds10);
            this.hLA.getLayoutParams().width = l.getDimens(this.mContext, R.dimen.ds88);
        }
    }
}
