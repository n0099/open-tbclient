package com.baidu.tieba.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private RelativeLayout iCd;
    private ImageView iCe;
    private MessageRedDotView iCf;
    private Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.iCd = (RelativeLayout) this.mRootView.findViewById(R.id.message_view_layout);
        this.iCe = (ImageView) this.mRootView.findViewById(R.id.img_message);
        this.iCf = (MessageRedDotView) this.mRootView.findViewById(R.id.img_red_tip);
        this.iCf.setShadowEnabled(false);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView cwd() {
        return this.iCe;
    }

    public MessageRedDotView cwe() {
        return this.iCf;
    }

    public void z(boolean z, int i) {
        if (z) {
            this.iCf.refresh(i);
            this.iCf.setVisibility(0);
            return;
        }
        this.iCf.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.iCf.onChangeSkinType();
        this.iCe.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, ao.getColor(R.color.CAM_X0106), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void setVisibility(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }

    public void a(NavigationBar.ControlAlign controlAlign, boolean z) {
        if (!z && controlAlign == NavigationBar.ControlAlign.HORIZONTAL_RIGHT) {
            ((RelativeLayout.LayoutParams) this.iCe.getLayoutParams()).rightMargin = -l.getDimens(this.mContext, R.dimen.tbds10);
            ((RelativeLayout.LayoutParams) this.iCf.getLayoutParams()).rightMargin = -l.getDimens(this.mContext, R.dimen.tbds10);
            this.iCd.getLayoutParams().width = l.getDimens(this.mContext, R.dimen.ds88);
        }
    }
}
