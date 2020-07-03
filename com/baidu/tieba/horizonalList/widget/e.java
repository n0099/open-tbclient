package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.adp.widget.ListView.ad;
/* loaded from: classes.dex */
public abstract class e extends ad.a {
    public View.OnClickListener eoP;
    public int iBQ;

    public abstract void a(c cVar);

    public abstract e bL(View view);

    public abstract void onChangeSkinType(int i);

    public e(View view) {
        super(view);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eoP = onClickListener;
    }
}
