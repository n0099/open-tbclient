package com.baidu.tieba.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class b {
    private ImageView cHP;
    private MessageRedDotView cHQ;
    private int cHR = f.C0146f.icon_topbar_remind_n_svg;
    private int cHS = f.d.select_topbar_icon_color_tint;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(f.h.widget_message_entrance, (ViewGroup) null);
        this.cHP = (ImageView) this.mRootView.findViewById(f.g.img_message);
        this.cHQ = (MessageRedDotView) this.mRootView.findViewById(f.g.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView akG() {
        return this.cHP;
    }

    public void f(boolean z, int i) {
        if (z) {
            this.cHQ.refresh(i);
            this.cHQ.setVisibility(0);
            return;
        }
        this.cHQ.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.cHQ.onChangeSkinType();
        aq.zt().c(this.cHP, this.cHR, this.cHS);
    }

    public void jl(int i) {
        this.cHS = i;
    }
}
