package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
/* loaded from: classes.dex */
public abstract class e extends af.a {
    public View.OnClickListener foP;
    public int kbr;

    public abstract void a(c cVar);

    public abstract e cA(View view);

    public abstract void onChangeSkinType(int i);

    public e(View view) {
        super(view);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.foP = onClickListener;
    }
}
