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
    private View.OnClickListener aKh;
    private com.baidu.tieba.channel.data.d cJv;
    private TextView cMm;
    private TextView cMn;
    private TextView cMo;
    private View cMp;
    private View.OnClickListener mClickListener;

    public ChannelMoreView(Context context, com.baidu.tieba.channel.data.d dVar, View.OnClickListener onClickListener) {
        super(context);
        this.aKh = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelMoreView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChannelMoreView.this.mClickListener.onClick(view);
            }
        };
        this.mClickListener = onClickListener;
        this.cJv = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), e.h.channel_more_view_layout, this);
        this.cMm = (TextView) findViewById(e.g.channel_more_cancel);
        this.cMp = findViewById(e.g.channel_more_layer);
        this.cMn = (TextView) findViewById(e.g.channel_up_info);
        this.cMo = (TextView) findViewById(e.g.channel_push_switch);
        this.cMm.setOnClickListener(this.mClickListener);
        this.cMp.setOnClickListener(this.mClickListener);
        this.cMn.setOnClickListener(this.mClickListener);
        this.cMo.setOnClickListener(this.mClickListener);
        if (this.cJv != null && this.cJv.alx() != null) {
            ChannelInfo alx = this.cJv.alx();
            if (alx.isSubscribe()) {
                this.cMo.setVisibility(0);
                if (alx.isPushOpen()) {
                    this.cMo.setText(getContext().getResources().getString(e.j.channel_push_switch_close));
                    return;
                } else {
                    this.cMo.setText(getContext().getResources().getString(e.j.channel_push_switch_open));
                    return;
                }
            }
            this.cMo.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.cMm;
    }

    public View getLayerView() {
        return this.cMp;
    }

    public TextView getUpInfoView() {
        return this.cMn;
    }

    public TextView getPushView() {
        return this.cMo;
    }

    public void setBackGround() {
        al.i(this.cMm, e.f.pb_more_pop_cancle_selector);
        al.c(this.cMm, e.d.channel_pop_cancel_text_color, 1);
        al.i(this.cMn, e.f.pb_more_pop_cancle_selector);
        al.c(this.cMn, e.d.channel_pop_text_color, 1);
        al.i(this.cMo, e.f.pb_more_pop_cancle_selector);
        al.c(this.cMo, e.d.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(e.g.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(e.d.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(e.d.channel_pop_devide_line));
        }
    }
}
