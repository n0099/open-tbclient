package com.baidu.tieba.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b {
    private ImageView eGI;
    private MessageRedDotView eGJ;
    private int eGK = R.drawable.icon_topbar_remind_n_svg;
    private int eGL = R.color.select_topbar_icon_color_tint;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.eGI = (ImageView) this.mRootView.findViewById(R.id.img_message);
        this.eGJ = (MessageRedDotView) this.mRootView.findViewById(R.id.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView aZt() {
        return this.eGI;
    }

    public void l(boolean z, int i) {
        if (z) {
            this.eGJ.refresh(i);
            this.eGJ.setVisibility(0);
            return;
        }
        this.eGJ.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.eGJ.onChangeSkinType();
        aq.aik().d(this.eGI, this.eGK, this.eGL);
    }

    public void pH(int i) {
        this.eGL = i;
    }

    public void setVisibility(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}
