package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class b extends v.a {
    public View divider;
    public View fZG;
    public TextView giE;
    public View rootView;

    public b(View view, View.OnClickListener onClickListener) {
        super(view);
        this.rootView = view;
        this.fZG = view.findViewById(d.g.divider_top);
        this.giE = (TextView) view.findViewById(d.g.create_item_text);
        this.divider = view.findViewById(d.g.divider);
        this.rootView.setOnClickListener(onClickListener);
    }
}
