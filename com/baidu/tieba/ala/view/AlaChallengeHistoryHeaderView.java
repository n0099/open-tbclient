package com.baidu.tieba.ala.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.data.k;
/* loaded from: classes3.dex */
public class AlaChallengeHistoryHeaderView extends LinearLayout {
    private TextView gHx;
    private TextView gHy;

    public AlaChallengeHistoryHeaderView(Context context) {
        super(context);
        init();
    }

    public AlaChallengeHistoryHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public AlaChallengeHistoryHeaderView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_list_header_layout, this);
        this.gHx = (TextView) inflate.findViewById(a.g.challenge_success_rate);
        this.gHy = (TextView) inflate.findViewById(a.g.challenge_success_num);
    }

    public void setData(k kVar) {
        if (kVar != null) {
            this.gHx.setText(String.format("%s%s", kVar.fEc, "%"));
            this.gHy.setText(kVar.fEb);
        }
    }
}
