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
    private TextView bIV;
    private View.OnClickListener cze;
    private com.baidu.tieba.channel.data.d eRc;
    private TextView eTR;
    private TextView eTS;
    private View eTT;
    private View.OnClickListener mClickListener;

    public ChannelMoreView(Context context, com.baidu.tieba.channel.data.d dVar, View.OnClickListener onClickListener) {
        super(context);
        this.cze = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelMoreView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChannelMoreView.this.mClickListener.onClick(view);
            }
        };
        this.mClickListener = onClickListener;
        this.eRc = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), R.layout.channel_more_view_layout, this);
        this.bIV = (TextView) findViewById(R.id.channel_more_cancel);
        this.eTT = findViewById(R.id.channel_more_layer);
        this.eTR = (TextView) findViewById(R.id.channel_up_info);
        this.eTS = (TextView) findViewById(R.id.channel_push_switch);
        this.bIV.setOnClickListener(this.mClickListener);
        this.eTT.setOnClickListener(this.mClickListener);
        this.eTR.setOnClickListener(this.mClickListener);
        this.eTS.setOnClickListener(this.mClickListener);
        if (this.eRc != null && this.eRc.bbj() != null) {
            ChannelInfo bbj = this.eRc.bbj();
            if (bbj.isSubscribe()) {
                this.eTS.setVisibility(0);
                if (bbj.isPushOpen()) {
                    this.eTS.setText(getContext().getResources().getString(R.string.channel_push_switch_close));
                    return;
                } else {
                    this.eTS.setText(getContext().getResources().getString(R.string.channel_push_switch_open));
                    return;
                }
            }
            this.eTS.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.bIV;
    }

    public View getLayerView() {
        return this.eTT;
    }

    public TextView getUpInfoView() {
        return this.eTR;
    }

    public TextView getPushView() {
        return this.eTS;
    }

    public void setBackGround() {
        am.setBackgroundResource(this.bIV, R.drawable.pb_more_pop_cancle_selector);
        am.setViewTextColor(this.bIV, R.color.channel_pop_cancel_text_color, 1);
        am.setBackgroundResource(this.eTR, R.drawable.pb_more_pop_cancle_selector);
        am.setViewTextColor(this.eTR, R.color.channel_pop_text_color, 1);
        am.setBackgroundResource(this.eTS, R.drawable.pb_more_pop_cancle_selector);
        am.setViewTextColor(this.eTS, R.color.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(R.id.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(R.color.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(R.color.channel_pop_devide_line));
        }
    }
}
