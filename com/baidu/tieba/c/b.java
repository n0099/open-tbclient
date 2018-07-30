package com.baidu.tieba.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private ImageView cHS;
    private MessageRedDotView cHT;
    private int cHU = d.f.icon_topbar_remind_n_svg;
    private int cHV = d.C0140d.select_topbar_icon_color_tint;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.widget_message_entrance, (ViewGroup) null);
        this.cHS = (ImageView) this.mRootView.findViewById(d.g.img_message);
        this.cHT = (MessageRedDotView) this.mRootView.findViewById(d.g.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView akE() {
        return this.cHS;
    }

    public void f(boolean z, int i) {
        if (z) {
            this.cHT.refresh(i);
            this.cHT.setVisibility(0);
            return;
        }
        this.cHT.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.cHT.onChangeSkinType();
        aq.zv().c(this.cHS, this.cHU, this.cHV);
    }

    public void jm(int i) {
        this.cHV = i;
    }
}
