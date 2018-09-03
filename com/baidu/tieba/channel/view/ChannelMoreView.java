package com.baidu.tieba.channel.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class ChannelMoreView extends LinearLayout {
    private View.OnClickListener aGT;
    private com.baidu.tieba.channel.data.d cDE;
    private TextView cGv;
    private TextView cGw;
    private TextView cGx;
    private View cGy;
    private View.OnClickListener mClickListener;

    public ChannelMoreView(Context context, com.baidu.tieba.channel.data.d dVar, View.OnClickListener onClickListener) {
        super(context);
        this.aGT = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelMoreView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChannelMoreView.this.mClickListener.onClick(view);
            }
        };
        this.mClickListener = onClickListener;
        this.cDE = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), f.h.channel_more_view_layout, this);
        this.cGv = (TextView) findViewById(f.g.channel_more_cancel);
        this.cGy = findViewById(f.g.channel_more_layer);
        this.cGw = (TextView) findViewById(f.g.channel_up_info);
        this.cGx = (TextView) findViewById(f.g.channel_push_switch);
        this.cGv.setOnClickListener(this.mClickListener);
        this.cGy.setOnClickListener(this.mClickListener);
        this.cGw.setOnClickListener(this.mClickListener);
        this.cGx.setOnClickListener(this.mClickListener);
        if (this.cDE != null && this.cDE.ajM() != null) {
            ChannelInfo ajM = this.cDE.ajM();
            if (ajM.isSubscribe()) {
                this.cGx.setVisibility(0);
                if (ajM.isPushOpen()) {
                    this.cGx.setText(getContext().getResources().getString(f.j.channel_push_switch_close));
                    return;
                } else {
                    this.cGx.setText(getContext().getResources().getString(f.j.channel_push_switch_open));
                    return;
                }
            }
            this.cGx.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.cGv;
    }

    public View getLayerView() {
        return this.cGy;
    }

    public TextView getUpInfoView() {
        return this.cGw;
    }

    public TextView getPushView() {
        return this.cGx;
    }

    public void setBackGround() {
        am.i(this.cGv, f.C0146f.pb_more_pop_cancle_selector);
        am.c(this.cGv, f.d.channel_pop_cancel_text_color, 1);
        am.i(this.cGw, f.C0146f.pb_more_pop_cancle_selector);
        am.c(this.cGw, f.d.channel_pop_text_color, 1);
        am.i(this.cGx, f.C0146f.pb_more_pop_cancle_selector);
        am.c(this.cGx, f.d.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(f.g.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(f.d.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(f.d.channel_pop_devide_line));
        }
    }
}
