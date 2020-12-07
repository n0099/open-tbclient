package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class b extends af.a {
    public View eOv;
    public View kig;
    public TextView ksT;
    public View rootView;

    public b(View view, View.OnClickListener onClickListener) {
        super(view);
        this.rootView = view;
        this.kig = view.findViewById(R.id.divider_top);
        this.ksT = (TextView) view.findViewById(R.id.create_item_text);
        this.eOv = view.findViewById(R.id.divider);
        this.rootView.setOnClickListener(onClickListener);
    }
}
