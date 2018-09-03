package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class b extends q.a {
    public View divider;
    public View djk;
    public TextView erG;
    public View rootView;

    public b(View view, View.OnClickListener onClickListener) {
        super(view);
        this.rootView = view;
        this.djk = view.findViewById(f.g.divider_top);
        this.erG = (TextView) view.findViewById(f.g.create_item_text);
        this.divider = view.findViewById(f.g.divider);
        this.rootView.setOnClickListener(onClickListener);
    }
}
