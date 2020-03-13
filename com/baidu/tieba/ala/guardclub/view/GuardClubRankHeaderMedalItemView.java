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
    private ImageView eIA;
    private TextView eIB;
    private TextView eIC;

    public GuardClubRankHeaderMedalItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setMedalResource(int i) {
        this.eIA.setImageResource(i);
    }

    public void setStyle(int i) {
        switch (i) {
            case 17:
                this.eIC.setTextColor(-2856249);
                return;
            case 18:
                this.eIC.setTextColor(-3970070);
                return;
            default:
                return;
        }
    }

    public void setData(int i, String str, String str2) {
        this.eIB.setText(str);
        this.eIC.setText(str2);
        switch (i) {
            case 1:
                this.eIB.setTextColor(-838860801);
                return;
            case 2:
                this.eIB.setTextColor(-1);
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
        this.eIA = (ImageView) findViewById(a.g.iv_medal);
        this.eIB = (TextView) findViewById(a.g.tv_name);
        this.eIC = (TextView) findViewById(a.g.tv_value);
    }
}
