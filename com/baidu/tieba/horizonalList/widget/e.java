package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.adp.widget.ListView.y;
/* loaded from: classes.dex */
public abstract class e extends y.a {
    public View.OnClickListener dRF;
    public int hVk;

    public abstract void a(c cVar);

    public abstract e bI(View view);

    public abstract void onChangeSkinType(int i);

    public e(View view) {
        super(view);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dRF = onClickListener;
    }
}
