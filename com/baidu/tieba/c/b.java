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
    private ImageView eLL;
    private MessageRedDotView eLM;
    private int eLN = R.drawable.icon_topbar_remind_n_svg;
    private int eLO = R.color.select_topbar_icon_color_tint;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.eLL = (ImageView) this.mRootView.findViewById(R.id.img_message);
        this.eLM = (MessageRedDotView) this.mRootView.findViewById(R.id.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView bbu() {
        return this.eLL;
    }

    public void l(boolean z, int i) {
        if (z) {
            this.eLM.refresh(i);
            this.eLM.setVisibility(0);
            return;
        }
        this.eLM.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.eLM.onChangeSkinType();
        ar.ajp().d(this.eLL, this.eLN, this.eLO);
    }

    public void pZ(int i) {
        this.eLO = i;
    }

    public void setVisibility(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}
