package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
/* loaded from: classes2.dex */
public class b {
    private int azk = 3;
    private a ffu;
    private RadioButton ffv;
    private RadioButton ffw;
    private RadioButton ffx;
    private RadioButton ffy;
    private RadioGroup ffz;
    private Context mContext;
    private View mView;

    /* loaded from: classes2.dex */
    public interface a {
        void qd(int i);
    }

    public b(Context context, int i) {
        this.mContext = context;
        setBeautyLevel(i);
        init();
    }

    private void init() {
        this.mView = View.inflate(this.mContext, a.h.ala_liveroom_host_beauty_layout, null);
        this.ffz = (RadioGroup) this.mView.findViewById(a.g.ala_live_beauty_group);
        this.ffz.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == a.g.ala_live_beauty_close) {
                    TiebaInitialize.log(new StatisticItem("c11985"));
                    b.this.azk = 0;
                } else if (i == a.g.ala_live_beauty_low) {
                    TiebaInitialize.log(new StatisticItem("c11986"));
                    b.this.azk = 1;
                } else if (i == a.g.ala_live_beauty_mid) {
                    TiebaInitialize.log(new StatisticItem("c11987"));
                    b.this.azk = 3;
                } else if (i == a.g.ala_live_beauty_high) {
                    TiebaInitialize.log(new StatisticItem("c11988"));
                    b.this.azk = 5;
                }
                if (b.this.ffu != null) {
                    b.this.ffu.qd(b.this.azk);
                }
            }
        });
        this.ffv = (RadioButton) this.mView.findViewById(a.g.ala_live_beauty_close);
        this.ffw = (RadioButton) this.mView.findViewById(a.g.ala_live_beauty_low);
        this.ffx = (RadioButton) this.mView.findViewById(a.g.ala_live_beauty_mid);
        this.ffy = (RadioButton) this.mView.findViewById(a.g.ala_live_beauty_high);
        if (this.azk == 0) {
            this.ffv.setChecked(true);
        } else if (this.azk == 1) {
            this.ffw.setChecked(true);
        } else if (this.azk == 5) {
            this.ffy.setChecked(true);
        } else {
            this.ffx.setChecked(true);
        }
    }

    public View getView() {
        return this.mView;
    }

    private void setBeautyLevel(int i) {
        if (i < 0) {
            this.azk = 0;
        } else if (i > 5) {
            this.azk = 5;
        } else {
            this.azk = i;
        }
    }

    public void a(a aVar) {
        this.ffu = aVar;
    }
}
