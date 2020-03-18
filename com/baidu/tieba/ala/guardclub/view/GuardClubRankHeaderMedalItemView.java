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
    private ImageView eIW;
    private TextView eIX;
    private TextView eIY;

    public GuardClubRankHeaderMedalItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setMedalResource(int i) {
        this.eIW.setImageResource(i);
    }

    public void setStyle(int i) {
        switch (i) {
            case 17:
                this.eIY.setTextColor(-2856249);
                return;
            case 18:
                this.eIY.setTextColor(-3970070);
                return;
            default:
                return;
        }
    }

    public void setData(int i, String str, String str2) {
        this.eIX.setText(str);
        this.eIY.setText(str2);
        switch (i) {
            case 1:
                this.eIX.setTextColor(-838860801);
                return;
            case 2:
                this.eIX.setTextColor(-1);
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
        this.eIW = (ImageView) findViewById(a.g.iv_medal);
        this.eIX = (TextView) findViewById(a.g.tv_name);
        this.eIY = (TextView) findViewById(a.g.tv_value);
    }
}
