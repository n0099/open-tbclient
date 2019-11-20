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
    private ImageView eVk;
    private MessageRedDotView eVl;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.eVk = (ImageView) this.mRootView.findViewById(R.id.img_message);
        this.eVl = (MessageRedDotView) this.mRootView.findViewById(R.id.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView bcb() {
        return this.eVk;
    }

    public void m(boolean z, int i) {
        if (z) {
            this.eVl.refresh(i);
            this.eVl.setVisibility(0);
            return;
        }
        this.eVl.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.eVl.onChangeSkinType();
        SvgManager.amL().a(this.eVk, R.drawable.icon_pure_topbar_information_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setVisibility(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}
