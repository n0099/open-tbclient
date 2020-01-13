package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class b extends v.a {
    public View cRQ;
    public View hox;
    public TextView hxq;
    public View rootView;

    public b(View view, View.OnClickListener onClickListener) {
        super(view);
        this.rootView = view;
        this.hox = view.findViewById(R.id.divider_top);
        this.hxq = (TextView) view.findViewById(R.id.create_item_text);
        this.cRQ = view.findViewById(R.id.divider);
        this.rootView.setOnClickListener(onClickListener);
    }
}
