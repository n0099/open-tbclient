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
    private ImageView fQs;
    private MessageRedDotView fQt;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.fQs = (ImageView) this.mRootView.findViewById(R.id.img_message);
        this.fQt = (MessageRedDotView) this.mRootView.findViewById(R.id.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView bwm() {
        return this.fQs;
    }

    public void r(boolean z, int i) {
        if (z) {
            this.fQt.refresh(i);
            this.fQt.setVisibility(0);
            return;
        }
        this.fQt.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.fQt.onChangeSkinType();
        SvgManager.aGG().a(this.fQs, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setVisibility(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}
