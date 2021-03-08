package com.baidu.tieba.ala.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.data.n;
/* loaded from: classes10.dex */
public class AlaChallengeHistoryHeaderView extends LinearLayout {
    private TextView ijU;
    private TextView ijV;

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
        this.ijU = (TextView) inflate.findViewById(a.f.challenge_success_rate);
        this.ijV = (TextView) inflate.findViewById(a.f.challenge_success_num);
    }

    public void setData(n nVar) {
        if (nVar != null) {
            this.ijU.setText(String.format("%s%s", nVar.gUN, "%"));
            this.ijV.setText(nVar.gUM);
        }
    }
}
