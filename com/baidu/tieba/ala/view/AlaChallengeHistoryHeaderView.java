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
    private TextView hEP;
    private TextView hEQ;

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
        this.hEP = (TextView) inflate.findViewById(a.g.challenge_success_rate);
        this.hEQ = (TextView) inflate.findViewById(a.g.challenge_success_num);
    }

    public void setData(n nVar) {
        if (nVar != null) {
            this.hEP.setText(String.format("%s%s", nVar.guF, "%"));
            this.hEQ.setText(nVar.guE);
        }
    }
}
