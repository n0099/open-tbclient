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
/* loaded from: classes3.dex */
public class GuardClubRankHeaderMedalItemView extends LinearLayout {
    private ImageView fMt;
    private TextView fMu;
    private TextView fMv;

    public GuardClubRankHeaderMedalItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setMedalResource(int i) {
        this.fMt.setImageResource(i);
    }

    public void setStyle(int i) {
        switch (i) {
            case 17:
                this.fMv.setTextColor(-2856249);
                return;
            case 18:
                this.fMv.setTextColor(-3970070);
                return;
            default:
                return;
        }
    }

    public void setData(int i, String str, String str2) {
        this.fMu.setText(str);
        this.fMv.setText(str2);
        switch (i) {
            case 1:
                this.fMu.setTextColor(-838860801);
                return;
            case 2:
                this.fMu.setTextColor(-1);
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
        this.fMt = (ImageView) findViewById(a.g.iv_medal);
        this.fMu = (TextView) findViewById(a.g.tv_name);
        this.fMv = (TextView) findViewById(a.g.tv_value);
    }
}
