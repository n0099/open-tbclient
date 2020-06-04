package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.adp.widget.ListView.aa;
/* loaded from: classes.dex */
public abstract class e extends aa.a {
    public View.OnClickListener ege;
    public int ikO;

    public abstract void a(c cVar);

    public abstract e bH(View view);

    public abstract void onChangeSkinType(int i);

    public e(View view) {
        super(view);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ege = onClickListener;
    }
}
