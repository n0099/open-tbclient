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
    private View.OnClickListener axH;
    private com.baidu.tieba.channel.data.d cuF;
    private TextView cxw;
    private TextView cxx;
    private TextView cxy;
    private View cxz;
    private View.OnClickListener mClickListener;

    public ChannelMoreView(Context context, com.baidu.tieba.channel.data.d dVar, View.OnClickListener onClickListener) {
        super(context);
        this.axH = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelMoreView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ChannelMoreView.this.mClickListener.onClick(view2);
            }
        };
        this.mClickListener = onClickListener;
        this.cuF = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), d.i.channel_more_view_layout, this);
        this.cxw = (TextView) findViewById(d.g.channel_more_cancel);
        this.cxz = findViewById(d.g.channel_more_layer);
        this.cxx = (TextView) findViewById(d.g.channel_up_info);
        this.cxy = (TextView) findViewById(d.g.channel_push_switch);
        this.cxw.setOnClickListener(this.mClickListener);
        this.cxz.setOnClickListener(this.mClickListener);
        this.cxx.setOnClickListener(this.mClickListener);
        this.cxy.setOnClickListener(this.mClickListener);
        if (this.cuF != null && this.cuF.agj() != null) {
            ChannelInfo agj = this.cuF.agj();
            if (agj.isSubscribe()) {
                this.cxy.setVisibility(0);
                if (agj.isPushOpen()) {
                    this.cxy.setText(getContext().getResources().getString(d.k.channel_push_switch_close));
                    return;
                } else {
                    this.cxy.setText(getContext().getResources().getString(d.k.channel_push_switch_open));
                    return;
                }
            }
            this.cxy.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.cxw;
    }

    public View getLayerView() {
        return this.cxz;
    }

    public TextView getUpInfoView() {
        return this.cxx;
    }

    public TextView getPushView() {
        return this.cxy;
    }

    public void setBackGround() {
        ak.i(this.cxw, d.f.pb_more_pop_cancle_selector);
        ak.c(this.cxw, d.C0126d.channel_pop_cancel_text_color, 1);
        ak.i(this.cxx, d.f.pb_more_pop_cancle_selector);
        ak.c(this.cxx, d.C0126d.channel_pop_text_color, 1);
        ak.i(this.cxy, d.f.pb_more_pop_cancle_selector);
        ak.c(this.cxy, d.C0126d.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(d.g.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(d.C0126d.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(d.C0126d.channel_pop_devide_line));
        }
    }
}
