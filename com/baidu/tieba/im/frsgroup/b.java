package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends q.a {
    public View dgw;
    public View divider;
    public TextView enR;
    public View rootView;

    public b(View view, View.OnClickListener onClickListener) {
        super(view);
        this.rootView = view;
        this.dgw = view.findViewById(d.g.divider_top);
        this.enR = (TextView) view.findViewById(d.g.create_item_text);
        this.divider = view.findViewById(d.g.divider);
        this.rootView.setOnClickListener(onClickListener);
    }
}
