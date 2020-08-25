package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
/* loaded from: classes2.dex */
public abstract class e extends af.a {
    public View.OnClickListener eFC;
    public int iWU;

    public abstract void a(c cVar);

    public abstract e bT(View view);

    public abstract void onChangeSkinType(int i);

    public e(View view) {
        super(view);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eFC = onClickListener;
    }
}
