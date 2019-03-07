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
    private ImageView ers;
    private MessageRedDotView ert;
    private int eru = d.f.icon_topbar_remind_n_svg;
    private int erv = d.C0236d.select_topbar_icon_color_tint;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.widget_message_entrance, (ViewGroup) null);
        this.ers = (ImageView) this.mRootView.findViewById(d.g.img_message);
        this.ert = (MessageRedDotView) this.mRootView.findViewById(d.g.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView aSj() {
        return this.ers;
    }

    public void l(boolean z, int i) {
        if (z) {
            this.ert.refresh(i);
            this.ert.setVisibility(0);
            return;
        }
        this.ert.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.ert.onChangeSkinType();
        aq.ado().d(this.ers, this.eru, this.erv);
    }

    public void oH(int i) {
        this.erv = i;
    }

    public void setVisibility(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}
