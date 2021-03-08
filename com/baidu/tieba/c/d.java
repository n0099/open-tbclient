package com.baidu.tieba.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private RelativeLayout iFd;
    private ImageView iFe;
    private MessageRedDotView iFf;
    private Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.iFd = (RelativeLayout) this.mRootView.findViewById(R.id.message_view_layout);
        this.iFe = (ImageView) this.mRootView.findViewById(R.id.img_message);
        this.iFf = (MessageRedDotView) this.mRootView.findViewById(R.id.img_red_tip);
        this.iFf.setShadowEnabled(false);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView ctK() {
        return this.iFe;
    }

    public MessageRedDotView ctL() {
        return this.iFf;
    }

    public void z(boolean z, int i) {
        if (z) {
            this.iFf.refresh(i);
            this.iFf.setVisibility(0);
            return;
        }
        this.iFf.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.iFf.onChangeSkinType();
        this.iFe.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, ap.getColor(R.color.CAM_X0106), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void setVisibility(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }

    public void a(NavigationBar.ControlAlign controlAlign, boolean z) {
        if (!z && controlAlign == NavigationBar.ControlAlign.HORIZONTAL_RIGHT) {
            ((RelativeLayout.LayoutParams) this.iFe.getLayoutParams()).rightMargin = -l.getDimens(this.mContext, R.dimen.tbds10);
            ((RelativeLayout.LayoutParams) this.iFf.getLayoutParams()).rightMargin = -l.getDimens(this.mContext, R.dimen.tbds10);
            this.iFd.getLayoutParams().width = l.getDimens(this.mContext, R.dimen.ds88);
        }
    }
}
