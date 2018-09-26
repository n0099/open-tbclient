package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public abstract class e extends q.a {
    public View.OnClickListener aKh;
    public int eiT;

    public abstract void a(c cVar);

    public abstract e aw(View view);

    public abstract void onChangeSkinType(int i);

    public e(View view) {
        super(view);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aKh = onClickListener;
    }
}
