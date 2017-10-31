package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.adp.widget.ListView.j;
/* loaded from: classes.dex */
public abstract class f extends j.a {
    public View.OnClickListener auz;
    public int dlB;

    public abstract void a(d dVar);

    public abstract f ae(View view);

    public abstract void onChangeSkinType(int i);

    public f(View view) {
        super(view);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.auz = onClickListener;
    }
}
