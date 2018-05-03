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
    private com.baidu.tieba.channel.data.d ctu;
    private TextView cwn;
    private TextView cwo;
    private TextView cwp;
    private View cwq;
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
        this.ctu = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), d.i.channel_more_view_layout, this);
        this.cwn = (TextView) findViewById(d.g.channel_more_cancel);
        this.cwq = findViewById(d.g.channel_more_layer);
        this.cwo = (TextView) findViewById(d.g.channel_up_info);
        this.cwp = (TextView) findViewById(d.g.channel_push_switch);
        this.cwn.setOnClickListener(this.mClickListener);
        this.cwq.setOnClickListener(this.mClickListener);
        this.cwo.setOnClickListener(this.mClickListener);
        this.cwp.setOnClickListener(this.mClickListener);
        if (this.ctu != null && this.ctu.agj() != null) {
            ChannelInfo agj = this.ctu.agj();
            if (agj.isSubscribe()) {
                this.cwp.setVisibility(0);
                if (agj.isPushOpen()) {
                    this.cwp.setText(getContext().getResources().getString(d.k.channel_push_switch_close));
                    return;
                } else {
                    this.cwp.setText(getContext().getResources().getString(d.k.channel_push_switch_open));
                    return;
                }
            }
            this.cwp.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.cwn;
    }

    public View getLayerView() {
        return this.cwq;
    }

    public TextView getUpInfoView() {
        return this.cwo;
    }

    public TextView getPushView() {
        return this.cwp;
    }

    public void setBackGround() {
        ak.i(this.cwn, d.f.pb_more_pop_cancle_selector);
        ak.c(this.cwn, d.C0126d.channel_pop_cancel_text_color, 1);
        ak.i(this.cwo, d.f.pb_more_pop_cancle_selector);
        ak.c(this.cwo, d.C0126d.channel_pop_text_color, 1);
        ak.i(this.cwp, d.f.pb_more_pop_cancle_selector);
        ak.c(this.cwp, d.C0126d.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(d.g.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(d.C0126d.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(d.C0126d.channel_pop_devide_line));
        }
    }
}
