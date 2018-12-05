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
    private View.OnClickListener aSY;
    private com.baidu.tieba.channel.data.d cZB;
    private TextView dcv;
    private TextView dcw;
    private View dcx;
    private TextView mCancelView;
    private View.OnClickListener mClickListener;

    public ChannelMoreView(Context context, com.baidu.tieba.channel.data.d dVar, View.OnClickListener onClickListener) {
        super(context);
        this.aSY = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelMoreView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChannelMoreView.this.mClickListener.onClick(view);
            }
        };
        this.mClickListener = onClickListener;
        this.cZB = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), e.h.channel_more_view_layout, this);
        this.mCancelView = (TextView) findViewById(e.g.channel_more_cancel);
        this.dcx = findViewById(e.g.channel_more_layer);
        this.dcv = (TextView) findViewById(e.g.channel_up_info);
        this.dcw = (TextView) findViewById(e.g.channel_push_switch);
        this.mCancelView.setOnClickListener(this.mClickListener);
        this.dcx.setOnClickListener(this.mClickListener);
        this.dcv.setOnClickListener(this.mClickListener);
        this.dcw.setOnClickListener(this.mClickListener);
        if (this.cZB != null && this.cZB.aqo() != null) {
            ChannelInfo aqo = this.cZB.aqo();
            if (aqo.isSubscribe()) {
                this.dcw.setVisibility(0);
                if (aqo.isPushOpen()) {
                    this.dcw.setText(getContext().getResources().getString(e.j.channel_push_switch_close));
                    return;
                } else {
                    this.dcw.setText(getContext().getResources().getString(e.j.channel_push_switch_open));
                    return;
                }
            }
            this.dcw.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.mCancelView;
    }

    public View getLayerView() {
        return this.dcx;
    }

    public TextView getUpInfoView() {
        return this.dcv;
    }

    public TextView getPushView() {
        return this.dcw;
    }

    public void setBackGround() {
        al.i(this.mCancelView, e.f.pb_more_pop_cancle_selector);
        al.c(this.mCancelView, e.d.channel_pop_cancel_text_color, 1);
        al.i(this.dcv, e.f.pb_more_pop_cancle_selector);
        al.c(this.dcv, e.d.channel_pop_text_color, 1);
        al.i(this.dcw, e.f.pb_more_pop_cancle_selector);
        al.c(this.dcw, e.d.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(e.g.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(e.d.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(e.d.channel_pop_devide_line));
        }
    }
}
