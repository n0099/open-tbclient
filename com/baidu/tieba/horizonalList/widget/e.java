package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
/* loaded from: classes.dex */
public abstract class e extends af.a {
    public View.OnClickListener fhp;
    public int jNM;

    public abstract void a(c cVar);

    public abstract e ct(View view);

    public abstract void onChangeSkinType(int i);

    public e(View view) {
        super(view);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fhp = onClickListener;
    }
}
