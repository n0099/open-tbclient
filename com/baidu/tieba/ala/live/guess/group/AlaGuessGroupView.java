package com.baidu.tieba.ala.live.guess.group;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class AlaGuessGroupView extends LinearLayout {
    private AlaGuessGroupInfoView hgI;
    private AlaGuessGroupInfoView hgJ;
    private AlaGuessGroupInfoView hgK;

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
        this.hgI = (AlaGuessGroupInfoView) findViewById(a.f.group_first);
        this.hgJ = (AlaGuessGroupInfoView) findViewById(a.f.group_second);
        this.hgK = (AlaGuessGroupInfoView) findViewById(a.f.group_third);
    }

    public AlaGuessGroupInfoView getFirstInfo() {
        return this.hgI;
    }

    public AlaGuessGroupInfoView getSecondInfo() {
        return this.hgJ;
    }

    public AlaGuessGroupInfoView getThirdInfo() {
        return this.hgK;
    }
}
