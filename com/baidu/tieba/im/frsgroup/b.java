package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends q.a {
    public View cUm;
    public TextView dXD;
    public View divider;
    public View rootView;

    public b(View view2, View.OnClickListener onClickListener) {
        super(view2);
        this.rootView = view2;
        this.cUm = view2.findViewById(d.g.divider_top);
        this.dXD = (TextView) view2.findViewById(d.g.create_item_text);
        this.divider = view2.findViewById(d.g.divider);
        this.rootView.setOnClickListener(onClickListener);
    }
}
