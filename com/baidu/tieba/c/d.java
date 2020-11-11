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
    private RelativeLayout idY;
    private ImageView idZ;
    private MessageRedDotView iea;
    private Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.idY = (RelativeLayout) this.mRootView.findViewById(R.id.message_view_layout);
        this.idZ = (ImageView) this.mRootView.findViewById(R.id.img_message);
        this.iea = (MessageRedDotView) this.mRootView.findViewById(R.id.img_red_tip);
        this.iea.setShadowEnabled(true);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView cpt() {
        return this.idZ;
    }

    public MessageRedDotView cpu() {
        return this.iea;
    }

    public void A(boolean z, int i) {
        if (z) {
            this.iea.refresh(i);
            this.iea.setVisibility(0);
            return;
        }
        this.iea.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.iea.onChangeSkinType();
        SvgManager.brn().a(this.idZ, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setVisibility(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }

    public void a(NavigationBar.ControlAlign controlAlign, boolean z) {
        if (!z && controlAlign == NavigationBar.ControlAlign.HORIZONTAL_RIGHT) {
            ((RelativeLayout.LayoutParams) this.idZ.getLayoutParams()).rightMargin = -l.getDimens(this.mContext, R.dimen.tbds10);
            ((RelativeLayout.LayoutParams) this.iea.getLayoutParams()).rightMargin = -l.getDimens(this.mContext, R.dimen.tbds10);
            this.idY.getLayoutParams().width = l.getDimens(this.mContext, R.dimen.ds88);
        }
    }
}
