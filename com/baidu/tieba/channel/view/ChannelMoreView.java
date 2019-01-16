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
    private View.OnClickListener aTI;
    private com.baidu.tieba.channel.data.d ddg;
    private TextView dfZ;
    private TextView dga;
    private View dgb;
    private TextView mCancelView;
    private View.OnClickListener mClickListener;

    public ChannelMoreView(Context context, com.baidu.tieba.channel.data.d dVar, View.OnClickListener onClickListener) {
        super(context);
        this.aTI = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelMoreView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChannelMoreView.this.mClickListener.onClick(view);
            }
        };
        this.mClickListener = onClickListener;
        this.ddg = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), e.h.channel_more_view_layout, this);
        this.mCancelView = (TextView) findViewById(e.g.channel_more_cancel);
        this.dgb = findViewById(e.g.channel_more_layer);
        this.dfZ = (TextView) findViewById(e.g.channel_up_info);
        this.dga = (TextView) findViewById(e.g.channel_push_switch);
        this.mCancelView.setOnClickListener(this.mClickListener);
        this.dgb.setOnClickListener(this.mClickListener);
        this.dfZ.setOnClickListener(this.mClickListener);
        this.dga.setOnClickListener(this.mClickListener);
        if (this.ddg != null && this.ddg.arB() != null) {
            ChannelInfo arB = this.ddg.arB();
            if (arB.isSubscribe()) {
                this.dga.setVisibility(0);
                if (arB.isPushOpen()) {
                    this.dga.setText(getContext().getResources().getString(e.j.channel_push_switch_close));
                    return;
                } else {
                    this.dga.setText(getContext().getResources().getString(e.j.channel_push_switch_open));
                    return;
                }
            }
            this.dga.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.mCancelView;
    }

    public View getLayerView() {
        return this.dgb;
    }

    public TextView getUpInfoView() {
        return this.dfZ;
    }

    public TextView getPushView() {
        return this.dga;
    }

    public void setBackGround() {
        al.i(this.mCancelView, e.f.pb_more_pop_cancle_selector);
        al.c(this.mCancelView, e.d.channel_pop_cancel_text_color, 1);
        al.i(this.dfZ, e.f.pb_more_pop_cancle_selector);
        al.c(this.dfZ, e.d.channel_pop_text_color, 1);
        al.i(this.dga, e.f.pb_more_pop_cancle_selector);
        al.c(this.dga, e.d.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(e.g.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(e.d.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(e.d.channel_pop_devide_line));
        }
    }
}
