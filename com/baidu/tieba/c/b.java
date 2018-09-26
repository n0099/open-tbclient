package com.baidu.tieba.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class b {
    private ImageView cNG;
    private MessageRedDotView cNH;
    private int cNI = e.f.icon_topbar_remind_n_svg;
    private int cNJ = e.d.select_topbar_icon_color_tint;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.widget_message_entrance, (ViewGroup) null);
        this.cNG = (ImageView) this.mRootView.findViewById(e.g.img_message);
        this.cNH = (MessageRedDotView) this.mRootView.findViewById(e.g.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView amr() {
        return this.cNG;
    }

    public void f(boolean z, int i) {
        if (z) {
            this.cNH.refresh(i);
            this.cNH.setVisibility(0);
            return;
        }
        this.cNH.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.cNH.onChangeSkinType();
        ap.Ay().c(this.cNG, this.cNI, this.cNJ);
    }

    public void jK(int i) {
        this.cNJ = i;
    }
}
