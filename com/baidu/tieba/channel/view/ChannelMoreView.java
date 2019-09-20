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
    private TextView brb;
    private View.OnClickListener cmX;
    private com.baidu.tieba.channel.data.d eJo;
    private TextView eMc;
    private TextView eMd;
    private View eMe;
    private View.OnClickListener mClickListener;

    public ChannelMoreView(Context context, com.baidu.tieba.channel.data.d dVar, View.OnClickListener onClickListener) {
        super(context);
        this.cmX = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelMoreView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChannelMoreView.this.mClickListener.onClick(view);
            }
        };
        this.mClickListener = onClickListener;
        this.eJo = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), R.layout.channel_more_view_layout, this);
        this.brb = (TextView) findViewById(R.id.channel_more_cancel);
        this.eMe = findViewById(R.id.channel_more_layer);
        this.eMc = (TextView) findViewById(R.id.channel_up_info);
        this.eMd = (TextView) findViewById(R.id.channel_push_switch);
        this.brb.setOnClickListener(this.mClickListener);
        this.eMe.setOnClickListener(this.mClickListener);
        this.eMc.setOnClickListener(this.mClickListener);
        this.eMd.setOnClickListener(this.mClickListener);
        if (this.eJo != null && this.eJo.bbh() != null) {
            ChannelInfo bbh = this.eJo.bbh();
            if (bbh.isSubscribe()) {
                this.eMd.setVisibility(0);
                if (bbh.isPushOpen()) {
                    this.eMd.setText(getContext().getResources().getString(R.string.channel_push_switch_close));
                    return;
                } else {
                    this.eMd.setText(getContext().getResources().getString(R.string.channel_push_switch_open));
                    return;
                }
            }
            this.eMd.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.brb;
    }

    public View getLayerView() {
        return this.eMe;
    }

    public TextView getUpInfoView() {
        return this.eMc;
    }

    public TextView getPushView() {
        return this.eMd;
    }

    public void setBackGround() {
        am.k(this.brb, R.drawable.pb_more_pop_cancle_selector);
        am.f(this.brb, R.color.channel_pop_cancel_text_color, 1);
        am.k(this.eMc, R.drawable.pb_more_pop_cancle_selector);
        am.f(this.eMc, R.color.channel_pop_text_color, 1);
        am.k(this.eMd, R.drawable.pb_more_pop_cancle_selector);
        am.f(this.eMd, R.color.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(R.id.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(R.color.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(R.color.channel_pop_devide_line));
        }
    }
}
