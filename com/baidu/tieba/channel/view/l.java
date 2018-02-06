package com.baidu.tieba.channel.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class l extends LinearLayout {
    private View.OnClickListener bmd;
    private com.baidu.tieba.channel.data.d dbO;
    private TextView deJ;
    private TextView deK;
    private TextView deL;
    private View deM;
    private View.OnClickListener mClickListener;

    public l(Context context, com.baidu.tieba.channel.data.d dVar, View.OnClickListener onClickListener) {
        super(context);
        this.bmd = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.this.mClickListener.onClick(view);
            }
        };
        this.mClickListener = onClickListener;
        this.dbO = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), d.h.channel_more_view_layout, this);
        this.deJ = (TextView) findViewById(d.g.channel_more_cancel);
        this.deM = findViewById(d.g.channel_more_layer);
        this.deK = (TextView) findViewById(d.g.channel_up_info);
        this.deL = (TextView) findViewById(d.g.channel_push_switch);
        this.deJ.setOnClickListener(this.mClickListener);
        this.deM.setOnClickListener(this.mClickListener);
        this.deK.setOnClickListener(this.mClickListener);
        this.deL.setOnClickListener(this.mClickListener);
        if (this.dbO != null && this.dbO.amj() != null) {
            ChannelInfo amj = this.dbO.amj();
            if (amj.isSubscribe()) {
                this.deL.setVisibility(0);
                if (amj.isPushOpen()) {
                    this.deL.setText(getContext().getResources().getString(d.j.channel_push_switch_close));
                    return;
                } else {
                    this.deL.setText(getContext().getResources().getString(d.j.channel_push_switch_open));
                    return;
                }
            }
            this.deL.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.deJ;
    }

    public View getLayerView() {
        return this.deM;
    }

    public TextView getUpInfoView() {
        return this.deK;
    }

    public TextView getPushView() {
        return this.deL;
    }

    public void amI() {
        aj.s(this.deJ, d.f.pb_more_pop_cancle_selector);
        aj.e(this.deJ, d.C0140d.channel_pop_cancel_text_color, 1);
        aj.s(this.deK, d.f.pb_more_pop_cancle_selector);
        aj.e(this.deK, d.C0140d.channel_pop_text_color, 1);
        aj.s(this.deL, d.f.pb_more_pop_cancle_selector);
        aj.e(this.deL, d.C0140d.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(d.g.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(d.C0140d.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(d.C0140d.channel_pop_devide_line));
        }
    }
}
