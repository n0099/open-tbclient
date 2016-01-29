package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.adp.widget.ListView.x;
/* loaded from: classes.dex */
public abstract class o extends x.a {
    public int ahU;
    public View.OnClickListener anq;
    public int bIO;

    public abstract o M(View view);

    public abstract void a(m mVar);

    public abstract void onChangeSkinType(int i);

    public o(View view) {
        super(view);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.anq = onClickListener;
    }
}
