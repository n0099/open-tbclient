package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
/* loaded from: classes6.dex */
public class b {
    private int arz = 3;
    private a epa;
    private RadioButton epb;
    private RadioButton epc;
    private RadioButton epd;
    private RadioButton epe;
    private RadioGroup epf;
    private Context mContext;
    private View mView;

    /* loaded from: classes6.dex */
    public interface a {
        void nM(int i);
    }

    public b(Context context, int i) {
        this.mContext = context;
        setBeautyLevel(i);
        init();
    }

    private void init() {
        this.mView = View.inflate(this.mContext, a.h.ala_liveroom_host_beauty_layout, null);
        this.epf = (RadioGroup) this.mView.findViewById(a.g.ala_live_beauty_group);
        this.epf.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == a.g.ala_live_beauty_close) {
                    TiebaInitialize.log(new StatisticItem("c11985"));
                    b.this.arz = 0;
                } else if (i == a.g.ala_live_beauty_low) {
                    TiebaInitialize.log(new StatisticItem("c11986"));
                    b.this.arz = 1;
                } else if (i == a.g.ala_live_beauty_mid) {
                    TiebaInitialize.log(new StatisticItem("c11987"));
                    b.this.arz = 3;
                } else if (i == a.g.ala_live_beauty_high) {
                    TiebaInitialize.log(new StatisticItem("c11988"));
                    b.this.arz = 5;
                }
                if (b.this.epa != null) {
                    b.this.epa.nM(b.this.arz);
                }
            }
        });
        this.epb = (RadioButton) this.mView.findViewById(a.g.ala_live_beauty_close);
        this.epc = (RadioButton) this.mView.findViewById(a.g.ala_live_beauty_low);
        this.epd = (RadioButton) this.mView.findViewById(a.g.ala_live_beauty_mid);
        this.epe = (RadioButton) this.mView.findViewById(a.g.ala_live_beauty_high);
        if (this.arz == 0) {
            this.epb.setChecked(true);
        } else if (this.arz == 1) {
            this.epc.setChecked(true);
        } else if (this.arz == 5) {
            this.epe.setChecked(true);
        } else {
            this.epd.setChecked(true);
        }
    }

    public View getView() {
        return this.mView;
    }

    private void setBeautyLevel(int i) {
        if (i < 0) {
            this.arz = 0;
        } else if (i > 5) {
            this.arz = 5;
        } else {
            this.arz = i;
        }
    }

    public void a(a aVar) {
        this.epa = aVar;
    }
}
