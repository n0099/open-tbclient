package com.baidu.tieba.channel.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ChannelMoreView extends LinearLayout {
    private View.OnClickListener aGc;
    private com.baidu.tieba.channel.data.d cDi;
    private TextView cFZ;
    private TextView cGa;
    private TextView cGb;
    private View cGc;
    private View.OnClickListener mClickListener;

    public ChannelMoreView(Context context, com.baidu.tieba.channel.data.d dVar, View.OnClickListener onClickListener) {
        super(context);
        this.aGc = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelMoreView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChannelMoreView.this.mClickListener.onClick(view);
            }
        };
        this.mClickListener = onClickListener;
        this.cDi = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), d.i.channel_more_view_layout, this);
        this.cFZ = (TextView) findViewById(d.g.channel_more_cancel);
        this.cGc = findViewById(d.g.channel_more_layer);
        this.cGa = (TextView) findViewById(d.g.channel_up_info);
        this.cGb = (TextView) findViewById(d.g.channel_push_switch);
        this.cFZ.setOnClickListener(this.mClickListener);
        this.cGc.setOnClickListener(this.mClickListener);
        this.cGa.setOnClickListener(this.mClickListener);
        this.cGb.setOnClickListener(this.mClickListener);
        if (this.cDi != null && this.cDi.ajR() != null) {
            ChannelInfo ajR = this.cDi.ajR();
            if (ajR.isSubscribe()) {
                this.cGb.setVisibility(0);
                if (ajR.isPushOpen()) {
                    this.cGb.setText(getContext().getResources().getString(d.k.channel_push_switch_close));
                    return;
                } else {
                    this.cGb.setText(getContext().getResources().getString(d.k.channel_push_switch_open));
                    return;
                }
            }
            this.cGb.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.cFZ;
    }

    public View getLayerView() {
        return this.cGc;
    }

    public TextView getUpInfoView() {
        return this.cGa;
    }

    public TextView getPushView() {
        return this.cGb;
    }

    public void setBackGround() {
        al.i(this.cFZ, d.f.pb_more_pop_cancle_selector);
        al.c(this.cFZ, d.C0141d.channel_pop_cancel_text_color, 1);
        al.i(this.cGa, d.f.pb_more_pop_cancle_selector);
        al.c(this.cGa, d.C0141d.channel_pop_text_color, 1);
        al.i(this.cGb, d.f.pb_more_pop_cancle_selector);
        al.c(this.cGb, d.C0141d.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(d.g.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(d.C0141d.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(d.C0141d.channel_pop_devide_line));
        }
    }
}
