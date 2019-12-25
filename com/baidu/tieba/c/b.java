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
    private ImageView fJR;
    private MessageRedDotView fJS;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.fJR = (ImageView) this.mRootView.findViewById(R.id.img_message);
        this.fJS = (MessageRedDotView) this.mRootView.findViewById(R.id.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView bty() {
        return this.fJR;
    }

    public void p(boolean z, int i) {
        if (z) {
            this.fJS.refresh(i);
            this.fJS.setVisibility(0);
            return;
        }
        this.fJS.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.fJS.onChangeSkinType();
        SvgManager.aDW().a(this.fJR, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setVisibility(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}
