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
    private TextView bjM;
    private View.OnClickListener ccC;
    private com.baidu.tieba.channel.data.d emP;
    private TextView epH;
    private TextView epI;
    private View epJ;
    private View.OnClickListener mClickListener;

    public ChannelMoreView(Context context, com.baidu.tieba.channel.data.d dVar, View.OnClickListener onClickListener) {
        super(context);
        this.ccC = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelMoreView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChannelMoreView.this.mClickListener.onClick(view);
            }
        };
        this.mClickListener = onClickListener;
        this.emP = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), d.h.channel_more_view_layout, this);
        this.bjM = (TextView) findViewById(d.g.channel_more_cancel);
        this.epJ = findViewById(d.g.channel_more_layer);
        this.epH = (TextView) findViewById(d.g.channel_up_info);
        this.epI = (TextView) findViewById(d.g.channel_push_switch);
        this.bjM.setOnClickListener(this.mClickListener);
        this.epJ.setOnClickListener(this.mClickListener);
        this.epH.setOnClickListener(this.mClickListener);
        this.epI.setOnClickListener(this.mClickListener);
        if (this.emP != null && this.emP.aRq() != null) {
            ChannelInfo aRq = this.emP.aRq();
            if (aRq.isSubscribe()) {
                this.epI.setVisibility(0);
                if (aRq.isPushOpen()) {
                    this.epI.setText(getContext().getResources().getString(d.j.channel_push_switch_close));
                    return;
                } else {
                    this.epI.setText(getContext().getResources().getString(d.j.channel_push_switch_open));
                    return;
                }
            }
            this.epI.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.bjM;
    }

    public View getLayerView() {
        return this.epJ;
    }

    public TextView getUpInfoView() {
        return this.epH;
    }

    public TextView getPushView() {
        return this.epI;
    }

    public void setBackGround() {
        al.k(this.bjM, d.f.pb_more_pop_cancle_selector);
        al.d(this.bjM, d.C0277d.channel_pop_cancel_text_color, 1);
        al.k(this.epH, d.f.pb_more_pop_cancle_selector);
        al.d(this.epH, d.C0277d.channel_pop_text_color, 1);
        al.k(this.epI, d.f.pb_more_pop_cancle_selector);
        al.d(this.epI, d.C0277d.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(d.g.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(d.C0277d.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(d.C0277d.channel_pop_devide_line));
        }
    }
}
