package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.adp.widget.ListView.y;
/* loaded from: classes.dex */
public abstract class n extends y.a {
    public View.OnClickListener aob;
    public int cxu;

    public abstract n T(View view);

    public abstract void a(l lVar);

    public abstract void onChangeSkinType(int i);

    public n(View view) {
        super(view);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aob = onClickListener;
    }
}
