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
    private ImageView cFl;
    private MessageRedDotView cFm;
    private int cFn = d.f.icon_topbar_remind_n_svg;
    private int cFo = d.C0142d.select_topbar_icon_color_tint;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.widget_message_entrance, (ViewGroup) null);
        this.cFl = (ImageView) this.mRootView.findViewById(d.g.img_message);
        this.cFm = (MessageRedDotView) this.mRootView.findViewById(d.g.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView akf() {
        return this.cFl;
    }

    public void f(boolean z, int i) {
        if (z) {
            this.cFm.refresh(i);
            this.cFm.setVisibility(0);
            return;
        }
        this.cFm.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.cFm.onChangeSkinType();
        aq.zE().c(this.cFl, this.cFn, this.cFo);
    }

    public void ja(int i) {
        this.cFo = i;
    }
}
