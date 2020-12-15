package com.baidu.tieba.ala.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.data.n;
/* loaded from: classes4.dex */
public class AlaChallengeHistoryHeaderView extends LinearLayout {
    private TextView hVp;
    private TextView hVq;

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
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_list_header_layout, this);
        this.hVp = (TextView) inflate.findViewById(a.f.challenge_success_rate);
        this.hVq = (TextView) inflate.findViewById(a.f.challenge_success_num);
    }

    public void setData(n nVar) {
        if (nVar != null) {
            this.hVp.setText(String.format("%s%s", nVar.gIZ, "%"));
            this.hVq.setText(nVar.gIY);
        }
    }
}
