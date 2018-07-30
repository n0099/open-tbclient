package com.baidu.tieba.channel.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ChannelMoreView extends LinearLayout {
    private View.OnClickListener aGU;
    private com.baidu.tieba.channel.data.d cDH;
    private TextView cGA;
    private View cGB;
    private TextView cGy;
    private TextView cGz;
    private View.OnClickListener mClickListener;

    public ChannelMoreView(Context context, com.baidu.tieba.channel.data.d dVar, View.OnClickListener onClickListener) {
        super(context);
        this.aGU = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelMoreView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChannelMoreView.this.mClickListener.onClick(view);
            }
        };
        this.mClickListener = onClickListener;
        this.cDH = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), d.h.channel_more_view_layout, this);
        this.cGy = (TextView) findViewById(d.g.channel_more_cancel);
        this.cGB = findViewById(d.g.channel_more_layer);
        this.cGz = (TextView) findViewById(d.g.channel_up_info);
        this.cGA = (TextView) findViewById(d.g.channel_push_switch);
        this.cGy.setOnClickListener(this.mClickListener);
        this.cGB.setOnClickListener(this.mClickListener);
        this.cGz.setOnClickListener(this.mClickListener);
        this.cGA.setOnClickListener(this.mClickListener);
        if (this.cDH != null && this.cDH.ajJ() != null) {
            ChannelInfo ajJ = this.cDH.ajJ();
            if (ajJ.isSubscribe()) {
                this.cGA.setVisibility(0);
                if (ajJ.isPushOpen()) {
                    this.cGA.setText(getContext().getResources().getString(d.j.channel_push_switch_close));
                    return;
                } else {
                    this.cGA.setText(getContext().getResources().getString(d.j.channel_push_switch_open));
                    return;
                }
            }
            this.cGA.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.cGy;
    }

    public View getLayerView() {
        return this.cGB;
    }

    public TextView getUpInfoView() {
        return this.cGz;
    }

    public TextView getPushView() {
        return this.cGA;
    }

    public void setBackGround() {
        am.i(this.cGy, d.f.pb_more_pop_cancle_selector);
        am.c(this.cGy, d.C0140d.channel_pop_cancel_text_color, 1);
        am.i(this.cGz, d.f.pb_more_pop_cancle_selector);
        am.c(this.cGz, d.C0140d.channel_pop_text_color, 1);
        am.i(this.cGA, d.f.pb_more_pop_cancle_selector);
        am.c(this.cGA, d.C0140d.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(d.g.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(d.C0140d.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(d.C0140d.channel_pop_devide_line));
        }
    }
}
