package com.baidu.tieba.channel.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ChannelMoreView extends LinearLayout {
    private View.OnClickListener axG;
    private com.baidu.tieba.channel.data.d cty;
    private TextView cwq;
    private TextView cwr;
    private TextView cws;
    private View cwt;
    private View.OnClickListener mClickListener;

    public ChannelMoreView(Context context, com.baidu.tieba.channel.data.d dVar, View.OnClickListener onClickListener) {
        super(context);
        this.axG = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelMoreView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ChannelMoreView.this.mClickListener.onClick(view2);
            }
        };
        this.mClickListener = onClickListener;
        this.cty = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), d.i.channel_more_view_layout, this);
        this.cwq = (TextView) findViewById(d.g.channel_more_cancel);
        this.cwt = findViewById(d.g.channel_more_layer);
        this.cwr = (TextView) findViewById(d.g.channel_up_info);
        this.cws = (TextView) findViewById(d.g.channel_push_switch);
        this.cwq.setOnClickListener(this.mClickListener);
        this.cwt.setOnClickListener(this.mClickListener);
        this.cwr.setOnClickListener(this.mClickListener);
        this.cws.setOnClickListener(this.mClickListener);
        if (this.cty != null && this.cty.agj() != null) {
            ChannelInfo agj = this.cty.agj();
            if (agj.isSubscribe()) {
                this.cws.setVisibility(0);
                if (agj.isPushOpen()) {
                    this.cws.setText(getContext().getResources().getString(d.k.channel_push_switch_close));
                    return;
                } else {
                    this.cws.setText(getContext().getResources().getString(d.k.channel_push_switch_open));
                    return;
                }
            }
            this.cws.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.cwq;
    }

    public View getLayerView() {
        return this.cwt;
    }

    public TextView getUpInfoView() {
        return this.cwr;
    }

    public TextView getPushView() {
        return this.cws;
    }

    public void setBackGround() {
        ak.i(this.cwq, d.f.pb_more_pop_cancle_selector);
        ak.c(this.cwq, d.C0126d.channel_pop_cancel_text_color, 1);
        ak.i(this.cwr, d.f.pb_more_pop_cancle_selector);
        ak.c(this.cwr, d.C0126d.channel_pop_text_color, 1);
        ak.i(this.cws, d.f.pb_more_pop_cancle_selector);
        ak.c(this.cws, d.C0126d.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(d.g.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(d.C0126d.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(d.C0126d.channel_pop_devide_line));
        }
    }
}
