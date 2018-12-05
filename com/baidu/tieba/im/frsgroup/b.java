package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b extends q.a {
    public View dEW;
    public View divider;
    public TextView eOS;
    public View rootView;

    public b(View view, View.OnClickListener onClickListener) {
        super(view);
        this.rootView = view;
        this.dEW = view.findViewById(e.g.divider_top);
        this.eOS = (TextView) view.findViewById(e.g.create_item_text);
        this.divider = view.findViewById(e.g.divider);
        this.rootView.setOnClickListener(onClickListener);
    }
}
