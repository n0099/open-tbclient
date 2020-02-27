package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends v.a {
    public View cVS;
    public View hqx;
    public TextView hzp;
    public View rootView;

    public b(View view, View.OnClickListener onClickListener) {
        super(view);
        this.rootView = view;
        this.hqx = view.findViewById(R.id.divider_top);
        this.hzp = (TextView) view.findViewById(R.id.create_item_text);
        this.cVS = view.findViewById(R.id.divider);
        this.rootView.setOnClickListener(onClickListener);
    }
}
