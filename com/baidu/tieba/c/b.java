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
    private ImageView cXd;
    private MessageRedDotView cXe;
    private int cXf = e.f.icon_topbar_remind_n_svg;
    private int cXg = e.d.select_topbar_icon_color_tint;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.widget_message_entrance, (ViewGroup) null);
        this.cXd = (ImageView) this.mRootView.findViewById(e.g.img_message);
        this.cXe = (MessageRedDotView) this.mRootView.findViewById(e.g.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView aps() {
        return this.cXd;
    }

    public void g(boolean z, int i) {
        if (z) {
            this.cXe.refresh(i);
            this.cXe.setVisibility(0);
            return;
        }
        this.cXe.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.cXe.onChangeSkinType();
        ap.CM().c(this.cXd, this.cXf, this.cXg);
    }

    public void kB(int i) {
        this.cXg = i;
    }
}
