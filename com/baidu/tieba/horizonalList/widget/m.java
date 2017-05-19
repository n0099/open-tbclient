package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.adp.widget.ListView.y;
/* loaded from: classes.dex */
public abstract class m extends y.a {
    public View.OnClickListener asZ;
    public int cAU;

    public abstract m U(View view);

    public abstract void a(k kVar);

    public abstract void onChangeSkinType(int i);

    public m(View view) {
        super(view);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.asZ = onClickListener;
    }
}
