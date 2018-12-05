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
    private ImageView ddO;
    private MessageRedDotView ddP;
    private int ddQ = e.f.icon_topbar_remind_n_svg;
    private int ddR = e.d.select_topbar_icon_color_tint;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.widget_message_entrance, (ViewGroup) null);
        this.ddO = (ImageView) this.mRootView.findViewById(e.g.img_message);
        this.ddP = (MessageRedDotView) this.mRootView.findViewById(e.g.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView are() {
        return this.ddO;
    }

    public void h(boolean z, int i) {
        if (z) {
            this.ddP.refresh(i);
            this.ddP.setVisibility(0);
            return;
        }
        this.ddP.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.ddP.onChangeSkinType();
        ap.DQ().c(this.ddO, this.ddQ, this.ddR);
    }

    public void kR(int i) {
        this.ddR = i;
    }
}
