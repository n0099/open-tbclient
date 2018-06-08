package com.baidu.tieba.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private ImageView cHr;
    private MessageRedDotView cHs;
    private int cHt = d.f.icon_topbar_remind_n_svg;
    private int cHu = d.C0141d.select_topbar_icon_color_tint;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.widget_message_entrance, (ViewGroup) null);
        this.cHr = (ImageView) this.mRootView.findViewById(d.g.img_message);
        this.cHs = (MessageRedDotView) this.mRootView.findViewById(d.g.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView akL() {
        return this.cHr;
    }

    public void f(boolean z, int i) {
        if (z) {
            this.cHs.refresh(i);
            this.cHs.setVisibility(0);
            return;
        }
        this.cHs.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.cHs.onChangeSkinType();
        ap.zp().c(this.cHr, this.cHt, this.cHu);
    }

    public void jc(int i) {
        this.cHu = i;
    }
}
