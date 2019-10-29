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
    private TextView bJM;
    private View.OnClickListener czV;
    private com.baidu.tieba.channel.data.d eRT;
    private TextView eUI;
    private TextView eUJ;
    private View eUK;
    private View.OnClickListener mClickListener;

    public ChannelMoreView(Context context, com.baidu.tieba.channel.data.d dVar, View.OnClickListener onClickListener) {
        super(context);
        this.czV = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelMoreView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChannelMoreView.this.mClickListener.onClick(view);
            }
        };
        this.mClickListener = onClickListener;
        this.eRT = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), R.layout.channel_more_view_layout, this);
        this.bJM = (TextView) findViewById(R.id.channel_more_cancel);
        this.eUK = findViewById(R.id.channel_more_layer);
        this.eUI = (TextView) findViewById(R.id.channel_up_info);
        this.eUJ = (TextView) findViewById(R.id.channel_push_switch);
        this.bJM.setOnClickListener(this.mClickListener);
        this.eUK.setOnClickListener(this.mClickListener);
        this.eUI.setOnClickListener(this.mClickListener);
        this.eUJ.setOnClickListener(this.mClickListener);
        if (this.eRT != null && this.eRT.bbl() != null) {
            ChannelInfo bbl = this.eRT.bbl();
            if (bbl.isSubscribe()) {
                this.eUJ.setVisibility(0);
                if (bbl.isPushOpen()) {
                    this.eUJ.setText(getContext().getResources().getString(R.string.channel_push_switch_close));
                    return;
                } else {
                    this.eUJ.setText(getContext().getResources().getString(R.string.channel_push_switch_open));
                    return;
                }
            }
            this.eUJ.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.bJM;
    }

    public View getLayerView() {
        return this.eUK;
    }

    public TextView getUpInfoView() {
        return this.eUI;
    }

    public TextView getPushView() {
        return this.eUJ;
    }

    public void setBackGround() {
        am.setBackgroundResource(this.bJM, R.drawable.pb_more_pop_cancle_selector);
        am.setViewTextColor(this.bJM, R.color.channel_pop_cancel_text_color, 1);
        am.setBackgroundResource(this.eUI, R.drawable.pb_more_pop_cancle_selector);
        am.setViewTextColor(this.eUI, R.color.channel_pop_text_color, 1);
        am.setBackgroundResource(this.eUJ, R.drawable.pb_more_pop_cancle_selector);
        am.setViewTextColor(this.eUJ, R.color.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(R.id.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(R.color.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(R.color.channel_pop_devide_line));
        }
    }
}
