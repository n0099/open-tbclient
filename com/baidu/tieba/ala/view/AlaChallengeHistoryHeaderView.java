package com.baidu.tieba.ala.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class AlaChallengeHistoryHeaderView extends LinearLayout {
    private TextView eCN;
    private TextView eCO;

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
        this.eCN = (TextView) inflate.findViewById(a.g.challenge_success_rate);
        this.eCO = (TextView) inflate.findViewById(a.g.challenge_success_num);
    }

    public void setData(com.baidu.tieba.ala.data.d dVar) {
        if (dVar != null) {
            this.eCN.setText(String.format("%s%s", dVar.dGr, "%"));
            this.eCO.setText(dVar.dGq);
        }
    }
}
