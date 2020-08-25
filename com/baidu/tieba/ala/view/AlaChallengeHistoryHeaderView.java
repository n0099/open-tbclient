package com.baidu.tieba.ala.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.data.l;
/* loaded from: classes7.dex */
public class AlaChallengeHistoryHeaderView extends LinearLayout {
    private TextView gZP;
    private TextView gZQ;

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
        this.gZP = (TextView) inflate.findViewById(a.g.challenge_success_rate);
        this.gZQ = (TextView) inflate.findViewById(a.g.challenge_success_num);
    }

    public void setData(l lVar) {
        if (lVar != null) {
            this.gZP.setText(String.format("%s%s", lVar.fUO, "%"));
            this.gZQ.setText(lVar.fUN);
        }
    }
}
