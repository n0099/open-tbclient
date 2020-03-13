package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public abstract class e extends v.a {
    public View.OnClickListener drw;
    public int hkb;

    public abstract void a(c cVar);

    public abstract e bD(View view);

    public abstract void onChangeSkinType(int i);

    public e(View view) {
        super(view);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.drw = onClickListener;
    }
}
