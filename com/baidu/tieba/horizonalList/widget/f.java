package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.adp.widget.ListView.r;
/* loaded from: classes.dex */
public abstract class f extends r.a {
    public View.OnClickListener bjw;
    public int egV;

    public abstract void a(d dVar);

    public abstract f by(View view);

    public abstract void onChangeSkinType(int i);

    public f(View view) {
        super(view);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bjw = onClickListener;
    }
}
