package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends y.a {
    public View dvs;
    public View ibU;
    public TextView ikR;
    public View rootView;

    public b(View view, View.OnClickListener onClickListener) {
        super(view);
        this.rootView = view;
        this.ibU = view.findViewById(R.id.divider_top);
        this.ikR = (TextView) view.findViewById(R.id.create_item_text);
        this.dvs = view.findViewById(R.id.divider);
        this.rootView.setOnClickListener(onClickListener);
    }
}
