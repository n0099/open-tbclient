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
    private ImageView ern;
    private MessageRedDotView ero;
    private int erp = d.f.icon_topbar_remind_n_svg;
    private int erq = d.C0277d.select_topbar_icon_color_tint;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.widget_message_entrance, (ViewGroup) null);
        this.ern = (ImageView) this.mRootView.findViewById(d.g.img_message);
        this.ero = (MessageRedDotView) this.mRootView.findViewById(d.g.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView aSj() {
        return this.ern;
    }

    public void l(boolean z, int i) {
        if (z) {
            this.ero.refresh(i);
            this.ero.setVisibility(0);
            return;
        }
        this.ero.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.ero.onChangeSkinType();
        aq.ado().d(this.ern, this.erp, this.erq);
    }

    public void oH(int i) {
        this.erq = i;
    }

    public void setVisibility(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}
