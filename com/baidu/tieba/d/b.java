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
    private ImageView dfU;
    private MessageRedDotView dfV;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.widget_message_entrance, (ViewGroup) null);
        this.dfU = (ImageView) this.mRootView.findViewById(d.g.img_message);
        this.dfV = (MessageRedDotView) this.mRootView.findViewById(d.g.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView anf() {
        return this.dfU;
    }

    public void j(boolean z, int i) {
        if (z) {
            this.dfV.refresh(i);
            this.dfV.setVisibility(0);
            return;
        }
        this.dfV.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.dfV.onChangeSkinType();
        an.Dd().c(this.dfU, d.f.icon_topbar_remind_n_svg, d.f.select_topbar_icon_color_tint);
    }
}
