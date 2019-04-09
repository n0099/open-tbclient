package com.baidu.tieba.channel.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class ChannelMoreView extends LinearLayout {
    private TextView bjN;
    private View.OnClickListener ccD;
    private com.baidu.tieba.channel.data.d emQ;
    private TextView epI;
    private TextView epJ;
    private View epK;
    private View.OnClickListener mClickListener;

    public ChannelMoreView(Context context, com.baidu.tieba.channel.data.d dVar, View.OnClickListener onClickListener) {
        super(context);
        this.ccD = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelMoreView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChannelMoreView.this.mClickListener.onClick(view);
            }
        };
        this.mClickListener = onClickListener;
        this.emQ = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), d.h.channel_more_view_layout, this);
        this.bjN = (TextView) findViewById(d.g.channel_more_cancel);
        this.epK = findViewById(d.g.channel_more_layer);
        this.epI = (TextView) findViewById(d.g.channel_up_info);
        this.epJ = (TextView) findViewById(d.g.channel_push_switch);
        this.bjN.setOnClickListener(this.mClickListener);
        this.epK.setOnClickListener(this.mClickListener);
        this.epI.setOnClickListener(this.mClickListener);
        this.epJ.setOnClickListener(this.mClickListener);
        if (this.emQ != null && this.emQ.aRq() != null) {
            ChannelInfo aRq = this.emQ.aRq();
            if (aRq.isSubscribe()) {
                this.epJ.setVisibility(0);
                if (aRq.isPushOpen()) {
                    this.epJ.setText(getContext().getResources().getString(d.j.channel_push_switch_close));
                    return;
                } else {
                    this.epJ.setText(getContext().getResources().getString(d.j.channel_push_switch_open));
                    return;
                }
            }
            this.epJ.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.bjN;
    }

    public View getLayerView() {
        return this.epK;
    }

    public TextView getUpInfoView() {
        return this.epI;
    }

    public TextView getPushView() {
        return this.epJ;
    }

    public void setBackGround() {
        al.k(this.bjN, d.f.pb_more_pop_cancle_selector);
        al.d(this.bjN, d.C0277d.channel_pop_cancel_text_color, 1);
        al.k(this.epI, d.f.pb_more_pop_cancle_selector);
        al.d(this.epI, d.C0277d.channel_pop_text_color, 1);
        al.k(this.epJ, d.f.pb_more_pop_cancle_selector);
        al.d(this.epJ, d.C0277d.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(d.g.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(d.C0277d.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(d.C0277d.channel_pop_devide_line));
        }
    }
}
