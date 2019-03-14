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
    private TextView bjJ;
    private View.OnClickListener ccA;
    private com.baidu.tieba.channel.data.d ene;
    private TextView epV;
    private TextView epW;
    private View epX;
    private View.OnClickListener mClickListener;

    public ChannelMoreView(Context context, com.baidu.tieba.channel.data.d dVar, View.OnClickListener onClickListener) {
        super(context);
        this.ccA = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelMoreView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChannelMoreView.this.mClickListener.onClick(view);
            }
        };
        this.mClickListener = onClickListener;
        this.ene = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), d.h.channel_more_view_layout, this);
        this.bjJ = (TextView) findViewById(d.g.channel_more_cancel);
        this.epX = findViewById(d.g.channel_more_layer);
        this.epV = (TextView) findViewById(d.g.channel_up_info);
        this.epW = (TextView) findViewById(d.g.channel_push_switch);
        this.bjJ.setOnClickListener(this.mClickListener);
        this.epX.setOnClickListener(this.mClickListener);
        this.epV.setOnClickListener(this.mClickListener);
        this.epW.setOnClickListener(this.mClickListener);
        if (this.ene != null && this.ene.aRs() != null) {
            ChannelInfo aRs = this.ene.aRs();
            if (aRs.isSubscribe()) {
                this.epW.setVisibility(0);
                if (aRs.isPushOpen()) {
                    this.epW.setText(getContext().getResources().getString(d.j.channel_push_switch_close));
                    return;
                } else {
                    this.epW.setText(getContext().getResources().getString(d.j.channel_push_switch_open));
                    return;
                }
            }
            this.epW.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.bjJ;
    }

    public View getLayerView() {
        return this.epX;
    }

    public TextView getUpInfoView() {
        return this.epV;
    }

    public TextView getPushView() {
        return this.epW;
    }

    public void setBackGround() {
        al.k(this.bjJ, d.f.pb_more_pop_cancle_selector);
        al.d(this.bjJ, d.C0277d.channel_pop_cancel_text_color, 1);
        al.k(this.epV, d.f.pb_more_pop_cancle_selector);
        al.d(this.epV, d.C0277d.channel_pop_text_color, 1);
        al.k(this.epW, d.f.pb_more_pop_cancle_selector);
        al.d(this.epW, d.C0277d.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(d.g.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(d.C0277d.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(d.C0277d.channel_pop_devide_line));
        }
    }
}
