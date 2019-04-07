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
    private ImageView eqZ;
    private MessageRedDotView era;
    private int erb = d.f.icon_topbar_remind_n_svg;
    private int erc = d.C0277d.select_topbar_icon_color_tint;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.widget_message_entrance, (ViewGroup) null);
        this.eqZ = (ImageView) this.mRootView.findViewById(d.g.img_message);
        this.era = (MessageRedDotView) this.mRootView.findViewById(d.g.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView aSh() {
        return this.eqZ;
    }

    public void l(boolean z, int i) {
        if (z) {
            this.era.refresh(i);
            this.era.setVisibility(0);
            return;
        }
        this.era.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.era.onChangeSkinType();
        aq.adl().d(this.eqZ, this.erb, this.erc);
    }

    public void oD(int i) {
        this.erc = i;
    }

    public void setVisibility(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}
