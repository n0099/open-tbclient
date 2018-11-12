package com.baidu.tieba.channel.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class ChannelMoreView extends LinearLayout {
    private View.OnClickListener aPz;
    private com.baidu.tieba.channel.data.d cSU;
    private TextView cVL;
    private TextView cVM;
    private View cVN;
    private TextView mCancelView;
    private View.OnClickListener mClickListener;

    public ChannelMoreView(Context context, com.baidu.tieba.channel.data.d dVar, View.OnClickListener onClickListener) {
        super(context);
        this.aPz = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelMoreView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChannelMoreView.this.mClickListener.onClick(view);
            }
        };
        this.mClickListener = onClickListener;
        this.cSU = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), e.h.channel_more_view_layout, this);
        this.mCancelView = (TextView) findViewById(e.g.channel_more_cancel);
        this.cVN = findViewById(e.g.channel_more_layer);
        this.cVL = (TextView) findViewById(e.g.channel_up_info);
        this.cVM = (TextView) findViewById(e.g.channel_push_switch);
        this.mCancelView.setOnClickListener(this.mClickListener);
        this.cVN.setOnClickListener(this.mClickListener);
        this.cVL.setOnClickListener(this.mClickListener);
        this.cVM.setOnClickListener(this.mClickListener);
        if (this.cSU != null && this.cSU.aoB() != null) {
            ChannelInfo aoB = this.cSU.aoB();
            if (aoB.isSubscribe()) {
                this.cVM.setVisibility(0);
                if (aoB.isPushOpen()) {
                    this.cVM.setText(getContext().getResources().getString(e.j.channel_push_switch_close));
                    return;
                } else {
                    this.cVM.setText(getContext().getResources().getString(e.j.channel_push_switch_open));
                    return;
                }
            }
            this.cVM.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.mCancelView;
    }

    public View getLayerView() {
        return this.cVN;
    }

    public TextView getUpInfoView() {
        return this.cVL;
    }

    public TextView getPushView() {
        return this.cVM;
    }

    public void setBackGround() {
        al.i(this.mCancelView, e.f.pb_more_pop_cancle_selector);
        al.c(this.mCancelView, e.d.channel_pop_cancel_text_color, 1);
        al.i(this.cVL, e.f.pb_more_pop_cancle_selector);
        al.c(this.cVL, e.d.channel_pop_text_color, 1);
        al.i(this.cVM, e.f.pb_more_pop_cancle_selector);
        al.c(this.cVM, e.d.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(e.g.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(e.d.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(e.d.channel_pop_devide_line));
        }
    }
}
