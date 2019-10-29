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
    private int arR = 3;
    private a epR;
    private RadioButton epS;
    private RadioButton epT;
    private RadioButton epU;
    private RadioButton epV;
    private RadioGroup epW;
    private Context mContext;
    private View mView;

    /* loaded from: classes6.dex */
    public interface a {
        void nN(int i);
    }

    public b(Context context, int i) {
        this.mContext = context;
        setBeautyLevel(i);
        init();
    }

    private void init() {
        this.mView = View.inflate(this.mContext, a.h.ala_liveroom_host_beauty_layout, null);
        this.epW = (RadioGroup) this.mView.findViewById(a.g.ala_live_beauty_group);
        this.epW.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == a.g.ala_live_beauty_close) {
                    TiebaInitialize.log(new StatisticItem("c11985"));
                    b.this.arR = 0;
                } else if (i == a.g.ala_live_beauty_low) {
                    TiebaInitialize.log(new StatisticItem("c11986"));
                    b.this.arR = 1;
                } else if (i == a.g.ala_live_beauty_mid) {
                    TiebaInitialize.log(new StatisticItem("c11987"));
                    b.this.arR = 3;
                } else if (i == a.g.ala_live_beauty_high) {
                    TiebaInitialize.log(new StatisticItem("c11988"));
                    b.this.arR = 5;
                }
                if (b.this.epR != null) {
                    b.this.epR.nN(b.this.arR);
                }
            }
        });
        this.epS = (RadioButton) this.mView.findViewById(a.g.ala_live_beauty_close);
        this.epT = (RadioButton) this.mView.findViewById(a.g.ala_live_beauty_low);
        this.epU = (RadioButton) this.mView.findViewById(a.g.ala_live_beauty_mid);
        this.epV = (RadioButton) this.mView.findViewById(a.g.ala_live_beauty_high);
        if (this.arR == 0) {
            this.epS.setChecked(true);
        } else if (this.arR == 1) {
            this.epT.setChecked(true);
        } else if (this.arR == 5) {
            this.epV.setChecked(true);
        } else {
            this.epU.setChecked(true);
        }
    }

    public View getView() {
        return this.mView;
    }

    private void setBeautyLevel(int i) {
        if (i < 0) {
            this.arR = 0;
        } else if (i > 5) {
            this.arR = 5;
        } else {
            this.arR = i;
        }
    }

    public void a(a aVar) {
        this.epR = aVar;
    }
}
