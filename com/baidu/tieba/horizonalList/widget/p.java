package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.adp.widget.ListView.x;
/* loaded from: classes.dex */
public abstract class p extends x.a {
    public int ahf;
    public View.OnClickListener amx;
    public int bFE;

    public abstract void a(n nVar);

    public abstract void onChangeSkinType(int i);

    public abstract p y(View view);

    public p(View view) {
        super(view);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.amx = onClickListener;
    }
}
