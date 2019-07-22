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
    private View.OnClickListener clU;
    private com.baidu.tieba.channel.data.d eHy;
    private TextView eKm;
    private TextView eKn;
    private View eKo;
    private View.OnClickListener mClickListener;

    public ChannelMoreView(Context context, com.baidu.tieba.channel.data.d dVar, View.OnClickListener onClickListener) {
        super(context);
        this.clU = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelMoreView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChannelMoreView.this.mClickListener.onClick(view);
            }
        };
        this.mClickListener = onClickListener;
        this.eHy = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), R.layout.channel_more_view_layout, this);
        this.bqD = (TextView) findViewById(R.id.channel_more_cancel);
        this.eKo = findViewById(R.id.channel_more_layer);
        this.eKm = (TextView) findViewById(R.id.channel_up_info);
        this.eKn = (TextView) findViewById(R.id.channel_push_switch);
        this.bqD.setOnClickListener(this.mClickListener);
        this.eKo.setOnClickListener(this.mClickListener);
        this.eKm.setOnClickListener(this.mClickListener);
        this.eKn.setOnClickListener(this.mClickListener);
        if (this.eHy != null && this.eHy.baB() != null) {
            ChannelInfo baB = this.eHy.baB();
            if (baB.isSubscribe()) {
                this.eKn.setVisibility(0);
                if (baB.isPushOpen()) {
                    this.eKn.setText(getContext().getResources().getString(R.string.channel_push_switch_close));
                    return;
                } else {
                    this.eKn.setText(getContext().getResources().getString(R.string.channel_push_switch_open));
                    return;
                }
            }
            this.eKn.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.bqD;
    }

    public View getLayerView() {
        return this.eKo;
    }

    public TextView getUpInfoView() {
        return this.eKm;
    }

    public TextView getPushView() {
        return this.eKn;
    }

    public void setBackGround() {
        am.k(this.bqD, R.drawable.pb_more_pop_cancle_selector);
        am.f(this.bqD, R.color.channel_pop_cancel_text_color, 1);
        am.k(this.eKm, R.drawable.pb_more_pop_cancle_selector);
        am.f(this.eKm, R.color.channel_pop_text_color, 1);
        am.k(this.eKn, R.drawable.pb_more_pop_cancle_selector);
        am.f(this.eKn, R.color.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(R.id.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(R.color.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(R.color.channel_pop_devide_line));
        }
    }
}
