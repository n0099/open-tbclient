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
    private com.baidu.tieba.channel.data.d cBc;
    private TextView cDS;
    private TextView cDT;
    private TextView cDU;
    private View cDV;
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
        this.cBc = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), d.i.channel_more_view_layout, this);
        this.cDS = (TextView) findViewById(d.g.channel_more_cancel);
        this.cDV = findViewById(d.g.channel_more_layer);
        this.cDT = (TextView) findViewById(d.g.channel_up_info);
        this.cDU = (TextView) findViewById(d.g.channel_push_switch);
        this.cDS.setOnClickListener(this.mClickListener);
        this.cDV.setOnClickListener(this.mClickListener);
        this.cDT.setOnClickListener(this.mClickListener);
        this.cDU.setOnClickListener(this.mClickListener);
        if (this.cBc != null && this.cBc.ajl() != null) {
            ChannelInfo ajl = this.cBc.ajl();
            if (ajl.isSubscribe()) {
                this.cDU.setVisibility(0);
                if (ajl.isPushOpen()) {
                    this.cDU.setText(getContext().getResources().getString(d.k.channel_push_switch_close));
                    return;
                } else {
                    this.cDU.setText(getContext().getResources().getString(d.k.channel_push_switch_open));
                    return;
                }
            }
            this.cDU.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.cDS;
    }

    public View getLayerView() {
        return this.cDV;
    }

    public TextView getUpInfoView() {
        return this.cDT;
    }

    public TextView getPushView() {
        return this.cDU;
    }

    public void setBackGround() {
        am.i(this.cDS, d.f.pb_more_pop_cancle_selector);
        am.c(this.cDS, d.C0142d.channel_pop_cancel_text_color, 1);
        am.i(this.cDT, d.f.pb_more_pop_cancle_selector);
        am.c(this.cDT, d.C0142d.channel_pop_text_color, 1);
        am.i(this.cDU, d.f.pb_more_pop_cancle_selector);
        am.c(this.cDU, d.C0142d.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(d.g.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(d.C0142d.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(d.C0142d.channel_pop_devide_line));
        }
    }
}
