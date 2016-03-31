package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.adp.widget.ListView.x;
/* loaded from: classes.dex */
public abstract class n extends x.a {
    public View.OnClickListener anH;
    public int bTk;

    public abstract n Q(View view);

    public abstract void a(l lVar);

    public abstract void onChangeSkinType(int i);

    public n(View view) {
        super(view);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.anH = onClickListener;
    }
}
