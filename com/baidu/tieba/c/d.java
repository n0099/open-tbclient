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
    private RelativeLayout iDu;
    private ImageView iDv;
    private MessageRedDotView iDw;
    private Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.iDu = (RelativeLayout) this.mRootView.findViewById(R.id.message_view_layout);
        this.iDv = (ImageView) this.mRootView.findViewById(R.id.img_message);
        this.iDw = (MessageRedDotView) this.mRootView.findViewById(R.id.img_red_tip);
        this.iDw.setShadowEnabled(false);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView ctE() {
        return this.iDv;
    }

    public MessageRedDotView ctF() {
        return this.iDw;
    }

    public void z(boolean z, int i) {
        if (z) {
            this.iDw.refresh(i);
            this.iDw.setVisibility(0);
            return;
        }
        this.iDw.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.iDw.onChangeSkinType();
        this.iDv.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, ap.getColor(R.color.CAM_X0106), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void setVisibility(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }

    public void a(NavigationBar.ControlAlign controlAlign, boolean z) {
        if (!z && controlAlign == NavigationBar.ControlAlign.HORIZONTAL_RIGHT) {
            ((RelativeLayout.LayoutParams) this.iDv.getLayoutParams()).rightMargin = -l.getDimens(this.mContext, R.dimen.tbds10);
            ((RelativeLayout.LayoutParams) this.iDw.getLayoutParams()).rightMargin = -l.getDimens(this.mContext, R.dimen.tbds10);
            this.iDu.getLayoutParams().width = l.getDimens(this.mContext, R.dimen.ds88);
        }
    }
}
