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
    private View.OnClickListener ckH;
    private com.baidu.tieba.channel.data.d eCB;
    private TextView eFp;
    private TextView eFq;
    private View eFr;
    private View.OnClickListener mClickListener;

    public ChannelMoreView(Context context, com.baidu.tieba.channel.data.d dVar, View.OnClickListener onClickListener) {
        super(context);
        this.ckH = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelMoreView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChannelMoreView.this.mClickListener.onClick(view);
            }
        };
        this.mClickListener = onClickListener;
        this.eCB = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), R.layout.channel_more_view_layout, this);
        this.bpQ = (TextView) findViewById(R.id.channel_more_cancel);
        this.eFr = findViewById(R.id.channel_more_layer);
        this.eFp = (TextView) findViewById(R.id.channel_up_info);
        this.eFq = (TextView) findViewById(R.id.channel_push_switch);
        this.bpQ.setOnClickListener(this.mClickListener);
        this.eFr.setOnClickListener(this.mClickListener);
        this.eFp.setOnClickListener(this.mClickListener);
        this.eFq.setOnClickListener(this.mClickListener);
        if (this.eCB != null && this.eCB.aYz() != null) {
            ChannelInfo aYz = this.eCB.aYz();
            if (aYz.isSubscribe()) {
                this.eFq.setVisibility(0);
                if (aYz.isPushOpen()) {
                    this.eFq.setText(getContext().getResources().getString(R.string.channel_push_switch_close));
                    return;
                } else {
                    this.eFq.setText(getContext().getResources().getString(R.string.channel_push_switch_open));
                    return;
                }
            }
            this.eFq.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.bpQ;
    }

    public View getLayerView() {
        return this.eFr;
    }

    public TextView getUpInfoView() {
        return this.eFp;
    }

    public TextView getPushView() {
        return this.eFq;
    }

    public void setBackGround() {
        al.k(this.bpQ, R.drawable.pb_more_pop_cancle_selector);
        al.f(this.bpQ, R.color.channel_pop_cancel_text_color, 1);
        al.k(this.eFp, R.drawable.pb_more_pop_cancle_selector);
        al.f(this.eFp, R.color.channel_pop_text_color, 1);
        al.k(this.eFq, R.drawable.pb_more_pop_cancle_selector);
        al.f(this.eFq, R.color.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(R.id.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(R.color.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(R.color.channel_pop_devide_line));
        }
    }
}
