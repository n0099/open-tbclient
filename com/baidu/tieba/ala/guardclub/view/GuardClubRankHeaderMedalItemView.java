package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class GuardClubRankHeaderMedalItemView extends LinearLayout {
    private ImageView fnn;
    private TextView fno;
    private TextView fnp;

    public GuardClubRankHeaderMedalItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setMedalResource(int i) {
        this.fnn.setImageResource(i);
    }

    public void setStyle(int i) {
        switch (i) {
            case 17:
                this.fnp.setTextColor(-2856249);
                return;
            case 18:
                this.fnp.setTextColor(-3970070);
                return;
            default:
                return;
        }
    }

    public void setData(int i, String str, String str2) {
        this.fno.setText(str);
        this.fnp.setText(str2);
        switch (i) {
            case 1:
                this.fno.setTextColor(-838860801);
                return;
            case 2:
                this.fno.setTextColor(-1);
                return;
            default:
                return;
        }
    }

    private void init() {
        setBackgroundColor(0);
        setGravity(1);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_rank_header_medal_item, (ViewGroup) this, true);
        this.fnn = (ImageView) findViewById(a.g.iv_medal);
        this.fno = (TextView) findViewById(a.g.tv_name);
        this.fnp = (TextView) findViewById(a.g.tv_value);
    }
}
