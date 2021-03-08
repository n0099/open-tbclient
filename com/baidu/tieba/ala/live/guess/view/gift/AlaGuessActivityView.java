package com.baidu.tieba.ala.live.guess.view.gift;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.live.guess.widget.TimeCountTextView;
/* loaded from: classes10.dex */
public class AlaGuessActivityView extends LinearLayout {
    public TextView bEg;
    public ImageView hkD;
    public TimeCountTextView hkE;

    public AlaGuessActivityView(Context context) {
        super(context);
        init();
    }

    private void init() {
        setId(a.f.ala_liveguess_activity_layout);
        LayoutInflater.from(getContext()).inflate(a.g.ala_guess_activity_view, (ViewGroup) this, true);
        this.bEg = (TextView) findViewById(a.f.tv_countdown_format);
        this.hkD = (ImageView) findViewById(a.f.img_activity);
        this.hkE = (TimeCountTextView) findViewById(a.f.time_countdown);
    }
}
