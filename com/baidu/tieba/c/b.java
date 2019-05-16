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
    private ImageView eGH;
    private MessageRedDotView eGI;
    private int eGJ = R.drawable.icon_topbar_remind_n_svg;
    private int eGK = R.color.select_topbar_icon_color_tint;
    private Context mContext;
    private View mRootView;

    public b(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.eGH = (ImageView) this.mRootView.findViewById(R.id.img_message);
        this.eGI = (MessageRedDotView) this.mRootView.findViewById(R.id.img_red_tip);
    }

    public View getView() {
        return this.mRootView;
    }

    public ImageView aZq() {
        return this.eGH;
    }

    public void l(boolean z, int i) {
        if (z) {
            this.eGI.refresh(i);
            this.eGI.setVisibility(0);
            return;
        }
        this.eGI.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.eGI.onChangeSkinType();
        aq.aik().d(this.eGH, this.eGJ, this.eGK);
    }

    public void pH(int i) {
        this.eGK = i;
    }

    public void setVisibility(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}
