package com.baidu.tieba.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b {
    private ImageView eLE;
    private MessageRedDotView eLF;
    private int eLG = R.drawable.icon_topbar_remind_n_svg;
    private int eLH = R.color.select_topbar_icon_color_tint;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.eLE = (ImageView) this.mRootView.findViewById(R.id.img_message);
        this.eLF = (MessageRedDotView) this.mRootView.findViewById(R.id.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView bbs() {
        return this.eLE;
    }

    public void l(boolean z, int i) {
        if (z) {
            this.eLF.refresh(i);
            this.eLF.setVisibility(0);
            return;
        }
        this.eLF.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.eLF.onChangeSkinType();
        ar.ajn().d(this.eLE, this.eLG, this.eLH);
    }

    public void pY(int i) {
        this.eLH = i;
    }

    public void setVisibility(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}
