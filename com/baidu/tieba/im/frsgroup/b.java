package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends r.a {
    public View dBM;
    public View divider;
    public TextView eCY;
    public View rootView;

    public b(View view, View.OnClickListener onClickListener) {
        super(view);
        this.rootView = view;
        this.dBM = view.findViewById(d.g.divider_top);
        this.eCY = (TextView) view.findViewById(d.g.create_item_text);
        this.divider = view.findViewById(d.g.divider);
        this.rootView.setOnClickListener(onClickListener);
    }
}
