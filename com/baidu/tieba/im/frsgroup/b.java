package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends v.a {
    public View cWh;
    public TextView hBd;
    public View hsl;
    public View rootView;

    public b(View view, View.OnClickListener onClickListener) {
        super(view);
        this.rootView = view;
        this.hsl = view.findViewById(R.id.divider_top);
        this.hBd = (TextView) view.findViewById(R.id.create_item_text);
        this.cWh = view.findViewById(R.id.divider);
        this.rootView.setOnClickListener(onClickListener);
    }
}
