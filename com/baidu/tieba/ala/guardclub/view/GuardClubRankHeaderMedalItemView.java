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
/* loaded from: classes11.dex */
public class GuardClubRankHeaderMedalItemView extends LinearLayout {
    private TextView bjI;
    private ImageView hdO;
    private TextView hdP;

    public GuardClubRankHeaderMedalItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setMedalResource(int i) {
        this.hdO.setImageResource(i);
    }

    public void setStyle(int i) {
        switch (i) {
            case 17:
                this.hdP.setTextColor(-2856249);
                return;
            case 18:
                this.hdP.setTextColor(-3970070);
                return;
            default:
                return;
        }
    }

    public void setData(int i, String str, String str2) {
        this.bjI.setText(str);
        this.hdP.setText(str2);
        switch (i) {
            case 1:
                this.bjI.setTextColor(-838860801);
                return;
            case 2:
                this.bjI.setTextColor(-1);
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
        this.hdO = (ImageView) findViewById(a.f.iv_medal);
        this.bjI = (TextView) findViewById(a.f.tv_name);
        this.hdP = (TextView) findViewById(a.f.tv_value);
    }
}
