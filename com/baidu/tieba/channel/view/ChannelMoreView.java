package com.baidu.tieba.channel.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.channel.data.ChannelInfo;
/* loaded from: classes6.dex */
public class ChannelMoreView extends LinearLayout {
    private TextView bqD;
    private View.OnClickListener cmb;
    private com.baidu.tieba.channel.data.d eHF;
    private TextView eKt;
    private TextView eKu;
    private View eKv;
    private View.OnClickListener mClickListener;

    public ChannelMoreView(Context context, com.baidu.tieba.channel.data.d dVar, View.OnClickListener onClickListener) {
        super(context);
        this.cmb = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelMoreView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChannelMoreView.this.mClickListener.onClick(view);
            }
        };
        this.mClickListener = onClickListener;
        this.eHF = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), R.layout.channel_more_view_layout, this);
        this.bqD = (TextView) findViewById(R.id.channel_more_cancel);
        this.eKv = findViewById(R.id.channel_more_layer);
        this.eKt = (TextView) findViewById(R.id.channel_up_info);
        this.eKu = (TextView) findViewById(R.id.channel_push_switch);
        this.bqD.setOnClickListener(this.mClickListener);
        this.eKv.setOnClickListener(this.mClickListener);
        this.eKt.setOnClickListener(this.mClickListener);
        this.eKu.setOnClickListener(this.mClickListener);
        if (this.eHF != null && this.eHF.baD() != null) {
            ChannelInfo baD = this.eHF.baD();
            if (baD.isSubscribe()) {
                this.eKu.setVisibility(0);
                if (baD.isPushOpen()) {
                    this.eKu.setText(getContext().getResources().getString(R.string.channel_push_switch_close));
                    return;
                } else {
                    this.eKu.setText(getContext().getResources().getString(R.string.channel_push_switch_open));
                    return;
                }
            }
            this.eKu.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.bqD;
    }

    public View getLayerView() {
        return this.eKv;
    }

    public TextView getUpInfoView() {
        return this.eKt;
    }

    public TextView getPushView() {
        return this.eKu;
    }

    public void setBackGround() {
        am.k(this.bqD, R.drawable.pb_more_pop_cancle_selector);
        am.f(this.bqD, R.color.channel_pop_cancel_text_color, 1);
        am.k(this.eKt, R.drawable.pb_more_pop_cancle_selector);
        am.f(this.eKt, R.color.channel_pop_text_color, 1);
        am.k(this.eKu, R.drawable.pb_more_pop_cancle_selector);
        am.f(this.eKu, R.color.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(R.id.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(R.color.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(R.color.channel_pop_devide_line));
        }
    }
}
