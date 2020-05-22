package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends aa.a {
    public View dJr;
    public View iqN;
    public TextView izF;
    public View rootView;

    public b(View view, View.OnClickListener onClickListener) {
        super(view);
        this.rootView = view;
        this.iqN = view.findViewById(R.id.divider_top);
        this.izF = (TextView) view.findViewById(R.id.create_item_text);
        this.dJr = view.findViewById(R.id.divider);
        this.rootView.setOnClickListener(onClickListener);
    }
}
