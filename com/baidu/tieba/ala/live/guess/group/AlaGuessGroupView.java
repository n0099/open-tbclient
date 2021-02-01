package com.baidu.tieba.ala.live.guess.group;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class AlaGuessGroupView extends LinearLayout {
    private AlaGuessGroupInfoView hgu;
    private AlaGuessGroupInfoView hgv;
    private AlaGuessGroupInfoView hgw;

    public AlaGuessGroupView(Context context) {
        super(context);
        init(context);
    }

    public AlaGuessGroupView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AlaGuessGroupView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.ala_guess_group_view, this);
        this.hgu = (AlaGuessGroupInfoView) findViewById(a.f.group_first);
        this.hgv = (AlaGuessGroupInfoView) findViewById(a.f.group_second);
        this.hgw = (AlaGuessGroupInfoView) findViewById(a.f.group_third);
    }

    public AlaGuessGroupInfoView getFirstInfo() {
        return this.hgu;
    }

    public AlaGuessGroupInfoView getSecondInfo() {
        return this.hgv;
    }

    public AlaGuessGroupInfoView getThirdInfo() {
        return this.hgw;
    }
}
