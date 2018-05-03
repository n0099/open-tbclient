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
    private ImageView cxF;
    private MessageRedDotView cxG;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.widget_message_entrance, (ViewGroup) null);
        this.cxF = (ImageView) this.mRootView.findViewById(d.g.img_message);
        this.cxG = (MessageRedDotView) this.mRootView.findViewById(d.g.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView ahd() {
        return this.cxF;
    }

    public void f(boolean z, int i) {
        if (z) {
            this.cxG.refresh(i);
            this.cxG.setVisibility(0);
            return;
        }
        this.cxG.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.cxG.onChangeSkinType();
        ao.vP().c(this.cxF, d.f.icon_topbar_remind_n_svg, d.f.select_topbar_icon_color_tint);
    }
}
