package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class GuardClubRankHeaderMedalItemView extends LinearLayout {
    private ImageView gJh;
    private TextView gJi;
    private TextView gJj;

    public GuardClubRankHeaderMedalItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setMedalResource(int i) {
        this.gJh.setImageResource(i);
    }

    public void setStyle(int i) {
        switch (i) {
            case 17:
                this.gJj.setTextColor(-2856249);
                return;
            case 18:
                this.gJj.setTextColor(-3970070);
                return;
            default:
                return;
        }
    }

    public void setData(int i, String str, String str2) {
        this.gJi.setText(str);
        this.gJj.setText(str2);
        switch (i) {
            case 1:
                this.gJi.setTextColor(-838860801);
                return;
            case 2:
                this.gJi.setTextColor(-1);
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
        this.gJh = (ImageView) findViewById(a.f.iv_medal);
        this.gJi = (TextView) findViewById(a.f.tv_name);
        this.gJj = (TextView) findViewById(a.f.tv_value);
    }
}
