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
    private ImageView eWb;
    private MessageRedDotView eWc;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.eWb = (ImageView) this.mRootView.findViewById(R.id.img_message);
        this.eWc = (MessageRedDotView) this.mRootView.findViewById(R.id.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView bcd() {
        return this.eWb;
    }

    public void m(boolean z, int i) {
        if (z) {
            this.eWc.refresh(i);
            this.eWc.setVisibility(0);
            return;
        }
        this.eWc.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.eWc.onChangeSkinType();
        SvgManager.amN().a(this.eWb, R.drawable.icon_pure_topbar_information_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setVisibility(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}
