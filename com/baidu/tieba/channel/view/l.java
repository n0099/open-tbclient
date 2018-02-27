package com.baidu.tieba.channel.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class l extends LinearLayout {
    private View.OnClickListener blQ;
    private com.baidu.tieba.channel.data.d dbC;
    private View deA;
    private TextView dex;
    private TextView dey;
    private TextView dez;
    private View.OnClickListener mClickListener;

    public l(Context context, com.baidu.tieba.channel.data.d dVar, View.OnClickListener onClickListener) {
        super(context);
        this.blQ = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.this.mClickListener.onClick(view);
            }
        };
        this.mClickListener = onClickListener;
        this.dbC = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), d.h.channel_more_view_layout, this);
        this.dex = (TextView) findViewById(d.g.channel_more_cancel);
        this.deA = findViewById(d.g.channel_more_layer);
        this.dey = (TextView) findViewById(d.g.channel_up_info);
        this.dez = (TextView) findViewById(d.g.channel_push_switch);
        this.dex.setOnClickListener(this.mClickListener);
        this.deA.setOnClickListener(this.mClickListener);
        this.dey.setOnClickListener(this.mClickListener);
        this.dez.setOnClickListener(this.mClickListener);
        if (this.dbC != null && this.dbC.ami() != null) {
            ChannelInfo ami = this.dbC.ami();
            if (ami.isSubscribe()) {
                this.dez.setVisibility(0);
                if (ami.isPushOpen()) {
                    this.dez.setText(getContext().getResources().getString(d.j.channel_push_switch_close));
                    return;
                } else {
                    this.dez.setText(getContext().getResources().getString(d.j.channel_push_switch_open));
                    return;
                }
            }
            this.dez.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.dex;
    }

    public View getLayerView() {
        return this.deA;
    }

    public TextView getUpInfoView() {
        return this.dey;
    }

    public TextView getPushView() {
        return this.dez;
    }

    public void amH() {
        aj.s(this.dex, d.f.pb_more_pop_cancle_selector);
        aj.e(this.dex, d.C0141d.channel_pop_cancel_text_color, 1);
        aj.s(this.dey, d.f.pb_more_pop_cancle_selector);
        aj.e(this.dey, d.C0141d.channel_pop_text_color, 1);
        aj.s(this.dez, d.f.pb_more_pop_cancle_selector);
        aj.e(this.dez, d.C0141d.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(d.g.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(d.C0141d.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(d.C0141d.channel_pop_devide_line));
        }
    }
}
