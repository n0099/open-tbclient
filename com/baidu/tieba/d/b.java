package com.baidu.tieba.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private ImageView cyO;
    private MessageRedDotView cyP;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.widget_message_entrance, (ViewGroup) null);
        this.cyO = (ImageView) this.mRootView.findViewById(d.g.img_message);
        this.cyP = (MessageRedDotView) this.mRootView.findViewById(d.g.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView ahd() {
        return this.cyO;
    }

    public void f(boolean z, int i) {
        if (z) {
            this.cyP.refresh(i);
            this.cyP.setVisibility(0);
            return;
        }
        this.cyP.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.cyP.onChangeSkinType();
        ao.vO().c(this.cyO, d.f.icon_topbar_remind_n_svg, d.f.select_topbar_icon_color_tint);
    }
}
