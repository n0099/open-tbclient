package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class b extends ad.a {
    public View dWz;
    public View iOM;
    public TextView iZH;
    public View rootView;

    public b(View view, View.OnClickListener onClickListener) {
        super(view);
        this.rootView = view;
        this.iOM = view.findViewById(R.id.divider_top);
        this.iZH = (TextView) view.findViewById(R.id.create_item_text);
        this.dWz = view.findViewById(R.id.divider);
        this.rootView.setOnClickListener(onClickListener);
    }
}
