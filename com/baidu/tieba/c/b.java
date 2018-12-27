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
    private ImageView dgF;
    private MessageRedDotView dgG;
    private int dgH = e.f.icon_topbar_remind_n_svg;
    private int dgI = e.d.select_topbar_icon_color_tint;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.widget_message_entrance, (ViewGroup) null);
        this.dgF = (ImageView) this.mRootView.findViewById(e.g.img_message);
        this.dgG = (MessageRedDotView) this.mRootView.findViewById(e.g.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView arT() {
        return this.dgF;
    }

    public void h(boolean z, int i) {
        if (z) {
            this.dgG.refresh(i);
            this.dgG.setVisibility(0);
            return;
        }
        this.dgG.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.dgG.onChangeSkinType();
        ap.DQ().c(this.dgF, this.dgH, this.dgI);
    }

    public void le(int i) {
        this.dgI = i;
    }
}
