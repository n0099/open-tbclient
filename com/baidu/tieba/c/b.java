package com.baidu.tieba.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b {
    private ImageView fNa;
    private MessageRedDotView fNb;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.fNa = (ImageView) this.mRootView.findViewById(R.id.img_message);
        this.fNb = (MessageRedDotView) this.mRootView.findViewById(R.id.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView buA() {
        return this.fNa;
    }

    public void q(boolean z, int i) {
        if (z) {
            this.fNb.refresh(i);
            this.fNb.setVisibility(0);
            return;
        }
        this.fNb.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.fNb.onChangeSkinType();
        SvgManager.aEp().a(this.fNa, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setVisibility(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}
