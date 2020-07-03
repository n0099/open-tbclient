package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends ad.a {
    public View dQh;
    public View iIH;
    public TextView iRx;
    public View rootView;

    public b(View view, View.OnClickListener onClickListener) {
        super(view);
        this.rootView = view;
        this.iIH = view.findViewById(R.id.divider_top);
        this.iRx = (TextView) view.findViewById(R.id.create_item_text);
        this.dQh = view.findViewById(R.id.divider);
        this.rootView.setOnClickListener(onClickListener);
    }
}
