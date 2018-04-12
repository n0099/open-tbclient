package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public abstract class e extends q.a {
    public View.OnClickListener axG;
    public int dHB;

    public abstract void a(c cVar);

    public abstract e ad(View view2);

    public abstract void onChangeSkinType(int i);

    public e(View view2) {
        super(view2);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.axG = onClickListener;
    }
}
