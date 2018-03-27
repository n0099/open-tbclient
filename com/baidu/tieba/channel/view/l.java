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
    private View.OnClickListener blT;
    private com.baidu.tieba.channel.data.d dbF;
    private TextView deA;
    private TextView deB;
    private TextView deC;
    private View deD;
    private View.OnClickListener mClickListener;

    public l(Context context, com.baidu.tieba.channel.data.d dVar, View.OnClickListener onClickListener) {
        super(context);
        this.blT = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.this.mClickListener.onClick(view);
            }
        };
        this.mClickListener = onClickListener;
        this.dbF = dVar;
        initView();
    }

    private void initView() {
        View.inflate(getContext(), d.h.channel_more_view_layout, this);
        this.deA = (TextView) findViewById(d.g.channel_more_cancel);
        this.deD = findViewById(d.g.channel_more_layer);
        this.deB = (TextView) findViewById(d.g.channel_up_info);
        this.deC = (TextView) findViewById(d.g.channel_push_switch);
        this.deA.setOnClickListener(this.mClickListener);
        this.deD.setOnClickListener(this.mClickListener);
        this.deB.setOnClickListener(this.mClickListener);
        this.deC.setOnClickListener(this.mClickListener);
        if (this.dbF != null && this.dbF.amj() != null) {
            ChannelInfo amj = this.dbF.amj();
            if (amj.isSubscribe()) {
                this.deC.setVisibility(0);
                if (amj.isPushOpen()) {
                    this.deC.setText(getContext().getResources().getString(d.j.channel_push_switch_close));
                    return;
                } else {
                    this.deC.setText(getContext().getResources().getString(d.j.channel_push_switch_open));
                    return;
                }
            }
            this.deC.setVisibility(8);
        }
    }

    public TextView getCancelView() {
        return this.deA;
    }

    public View getLayerView() {
        return this.deD;
    }

    public TextView getUpInfoView() {
        return this.deB;
    }

    public TextView getPushView() {
        return this.deC;
    }

    public void amI() {
        aj.s(this.deA, d.f.pb_more_pop_cancle_selector);
        aj.e(this.deA, d.C0141d.channel_pop_cancel_text_color, 1);
        aj.s(this.deB, d.f.pb_more_pop_cancle_selector);
        aj.e(this.deB, d.C0141d.channel_pop_text_color, 1);
        aj.s(this.deC, d.f.pb_more_pop_cancle_selector);
        aj.e(this.deC, d.C0141d.channel_pop_text_color, 1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        View findViewById = findViewById(d.g.channel_devide_line);
        if (skinType == 1) {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(d.C0141d.cp_bg_line_c_1));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(d.C0141d.channel_pop_devide_line));
        }
    }
}
