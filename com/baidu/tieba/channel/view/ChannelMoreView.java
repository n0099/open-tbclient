package com.baidu.tieba.channel.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.channel.data.ChannelInfo;
/* loaded from: classes6.dex */
public class ChannelMoreView extends LinearLayout {
    private TextView bpQ;
    private View.OnClickListener ckI;
    private com.baidu.tieba.channel.data.d eCC;
    private TextView eFq;
    private TextView eFr;
    private View eFs;
    private View.OnClickListener mClickListener;

    public ChannelMoreView(Context context, com.baidu.tieba.channel.data.d dVar, View.OnClickListener onClickListener) {
        super(context);
        this.ckI = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelMoreView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChannelMoreView.this.mClickListener.onClick(view);
            }
        };
        this.mClickListener = onClickListener;
        this.eCC = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), R.layout.channel_more_view_layout, this);
        this.bpQ = (TextView) findViewById(R.id.channel_more_cancel);
        this.eFs = findViewById(R.id.channel_more_layer);
        this.eFq = (TextView) findViewById(R.id.channel_up_info);
        this.eFr = (TextView) findViewById(R.id.channel_push_switch);
        this.bpQ.setOnClickListener(this.mClickListener);
        this.eFs.setOnClickListener(this.mClickListener);
        this.eFq.setOnClickListener(this.mClickListener);
        this.eFr.setOnClickListener(this.mClickListener);
        if (this.eCC != null && this.eCC.aYC() != null) {
            ChannelInfo aYC = this.eCC.aYC();
            if (aYC.isSubscribe()) {
                this.eFr.setVisibility(0);
                if (aYC.isPushOpen()) {
                    this.eFr.setText(getContext().getResources().getString(R.string.channel_push_switch_close));
                    return;
                } else {
                    this.eFr.setText(getContext().getResources().getString(R.string.channel_push_switch_open));
                    return;
                }
            }
            this.eFr.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.bpQ;
    }

    public View getLayerView() {
        return this.eFs;
    }

    public TextView getUpInfoView() {
        return this.eFq;
    }

    public TextView getPushView() {
        return this.eFr;
    }

    public void setBackGround() {
        al.k(this.bpQ, R.drawable.pb_more_pop_cancle_selector);
        al.f(this.bpQ, R.color.channel_pop_cancel_text_color, 1);
        al.k(this.eFq, R.drawable.pb_more_pop_cancle_selector);
        al.f(this.eFq, R.color.channel_pop_text_color, 1);
        al.k(this.eFr, R.drawable.pb_more_pop_cancle_selector);
        al.f(this.eFr, R.color.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(R.id.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(R.color.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(R.color.channel_pop_devide_line));
        }
    }
}
