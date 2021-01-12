package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class GuardClubRankHeaderMedalItemView extends LinearLayout {
    private TextView beR;
    private ImageView gZi;
    private TextView gZj;

    public GuardClubRankHeaderMedalItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setMedalResource(int i) {
        this.gZi.setImageResource(i);
    }

    public void setStyle(int i) {
        switch (i) {
            case 17:
                this.gZj.setTextColor(-2856249);
                return;
            case 18:
                this.gZj.setTextColor(-3970070);
                return;
            default:
                return;
        }
    }

    public void setData(int i, String str, String str2) {
        this.beR.setText(str);
        this.gZj.setText(str2);
        switch (i) {
            case 1:
                this.beR.setTextColor(-838860801);
                return;
            case 2:
                this.beR.setTextColor(-1);
                return;
            default:
                return;
        }
    }

    private void init() {
        setBackgroundColor(0);
        setGravity(1);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.g.live_guard_club_widget_rank_header_medal_item, (ViewGroup) this, true);
        this.gZi = (ImageView) findViewById(a.f.iv_medal);
        this.beR = (TextView) findViewById(a.f.tv_name);
        this.gZj = (TextView) findViewById(a.f.tv_value);
    }
}
