package com.baidu.tieba.channel.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class ChannelMoreView extends LinearLayout {
    private View.OnClickListener aTa;
    private com.baidu.tieba.channel.data.d dct;
    private TextView dfn;
    private TextView dfo;
    private View dfp;
    private TextView mCancelView;
    private View.OnClickListener mClickListener;

    public ChannelMoreView(Context context, com.baidu.tieba.channel.data.d dVar, View.OnClickListener onClickListener) {
        super(context);
        this.aTa = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelMoreView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChannelMoreView.this.mClickListener.onClick(view);
            }
        };
        this.mClickListener = onClickListener;
        this.dct = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), e.h.channel_more_view_layout, this);
        this.mCancelView = (TextView) findViewById(e.g.channel_more_cancel);
        this.dfp = findViewById(e.g.channel_more_layer);
        this.dfn = (TextView) findViewById(e.g.channel_up_info);
        this.dfo = (TextView) findViewById(e.g.channel_push_switch);
        this.mCancelView.setOnClickListener(this.mClickListener);
        this.dfp.setOnClickListener(this.mClickListener);
        this.dfn.setOnClickListener(this.mClickListener);
        this.dfo.setOnClickListener(this.mClickListener);
        if (this.dct != null && this.dct.ard() != null) {
            ChannelInfo ard = this.dct.ard();
            if (ard.isSubscribe()) {
                this.dfo.setVisibility(0);
                if (ard.isPushOpen()) {
                    this.dfo.setText(getContext().getResources().getString(e.j.channel_push_switch_close));
                    return;
                } else {
                    this.dfo.setText(getContext().getResources().getString(e.j.channel_push_switch_open));
                    return;
                }
            }
            this.dfo.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.mCancelView;
    }

    public View getLayerView() {
        return this.dfp;
    }

    public TextView getUpInfoView() {
        return this.dfn;
    }

    public TextView getPushView() {
        return this.dfo;
    }

    public void setBackGround() {
        al.i(this.mCancelView, e.f.pb_more_pop_cancle_selector);
        al.c(this.mCancelView, e.d.channel_pop_cancel_text_color, 1);
        al.i(this.dfn, e.f.pb_more_pop_cancle_selector);
        al.c(this.dfn, e.d.channel_pop_text_color, 1);
        al.i(this.dfo, e.f.pb_more_pop_cancle_selector);
        al.c(this.dfo, e.d.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(e.g.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(e.d.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(e.d.channel_pop_devide_line));
        }
    }
}
