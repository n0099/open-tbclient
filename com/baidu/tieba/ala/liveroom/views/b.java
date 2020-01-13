package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
/* loaded from: classes2.dex */
public class b {
    private a fiF;
    private RadioButton fiG;
    private RadioButton fiH;
    private RadioButton fiI;
    private RadioButton fiJ;
    private RadioGroup fiK;
    private Context mContext;
    private int mLevel = 3;
    private View mView;

    /* loaded from: classes2.dex */
    public interface a {
        void qi(int i);
    }

    public b(Context context, int i) {
        this.mContext = context;
        setBeautyLevel(i);
        init();
    }

    private void init() {
        this.mView = View.inflate(this.mContext, a.h.ala_liveroom_host_beauty_layout, null);
        this.fiK = (RadioGroup) this.mView.findViewById(a.g.ala_live_beauty_group);
        this.fiK.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == a.g.ala_live_beauty_close) {
                    TiebaInitialize.log(new StatisticItem("c11985"));
                    b.this.mLevel = 0;
                } else if (i == a.g.ala_live_beauty_low) {
                    TiebaInitialize.log(new StatisticItem("c11986"));
                    b.this.mLevel = 1;
                } else if (i == a.g.ala_live_beauty_mid) {
                    TiebaInitialize.log(new StatisticItem("c11987"));
                    b.this.mLevel = 3;
                } else if (i == a.g.ala_live_beauty_high) {
                    TiebaInitialize.log(new StatisticItem("c11988"));
                    b.this.mLevel = 5;
                }
                if (b.this.fiF != null) {
                    b.this.fiF.qi(b.this.mLevel);
                }
            }
        });
        this.fiG = (RadioButton) this.mView.findViewById(a.g.ala_live_beauty_close);
        this.fiH = (RadioButton) this.mView.findViewById(a.g.ala_live_beauty_low);
        this.fiI = (RadioButton) this.mView.findViewById(a.g.ala_live_beauty_mid);
        this.fiJ = (RadioButton) this.mView.findViewById(a.g.ala_live_beauty_high);
        if (this.mLevel == 0) {
            this.fiG.setChecked(true);
        } else if (this.mLevel == 1) {
            this.fiH.setChecked(true);
        } else if (this.mLevel == 5) {
            this.fiJ.setChecked(true);
        } else {
            this.fiI.setChecked(true);
        }
    }

    public View getView() {
        return this.mView;
    }

    private void setBeautyLevel(int i) {
        if (i < 0) {
            this.mLevel = 0;
        } else if (i > 5) {
            this.mLevel = 5;
        } else {
            this.mLevel = i;
        }
    }

    public void a(a aVar) {
        this.fiF = aVar;
    }
}
