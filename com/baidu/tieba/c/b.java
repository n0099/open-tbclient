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
    private ImageView cVX;
    private MessageRedDotView cVY;
    private int cVZ = e.f.icon_topbar_remind_n_svg;
    private int cWa = e.d.select_topbar_icon_color_tint;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.widget_message_entrance, (ViewGroup) null);
        this.cVX = (ImageView) this.mRootView.findViewById(e.g.img_message);
        this.cVY = (MessageRedDotView) this.mRootView.findViewById(e.g.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView apR() {
        return this.cVX;
    }

    public void g(boolean z, int i) {
        if (z) {
            this.cVY.refresh(i);
            this.cVY.setVisibility(0);
            return;
        }
        this.cVY.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.cVY.onChangeSkinType();
        ap.CF().c(this.cVX, this.cVZ, this.cWa);
    }

    public void ki(int i) {
        this.cWa = i;
    }
}
