package com.baidu.tieba.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private ImageView dgd;
    private MessageRedDotView dge;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.widget_message_entrance, (ViewGroup) null);
        this.dgd = (ImageView) this.mRootView.findViewById(d.g.img_message);
        this.dge = (MessageRedDotView) this.mRootView.findViewById(d.g.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView anf() {
        return this.dgd;
    }

    public void j(boolean z, int i) {
        if (z) {
            this.dge.refresh(i);
            this.dge.setVisibility(0);
            return;
        }
        this.dge.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.dge.onChangeSkinType();
        an.Dd().c(this.dgd, d.f.icon_topbar_remind_n_svg, d.f.select_topbar_icon_color_tint);
    }
}
