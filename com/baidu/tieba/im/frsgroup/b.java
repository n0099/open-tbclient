package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class b extends af.a {
    public View egd;
    public View jdR;
    public TextView joP;
    public View rootView;

    public b(View view, View.OnClickListener onClickListener) {
        super(view);
        this.rootView = view;
        this.jdR = view.findViewById(R.id.divider_top);
        this.joP = (TextView) view.findViewById(R.id.create_item_text);
        this.egd = view.findViewById(R.id.divider);
        this.rootView.setOnClickListener(onClickListener);
    }
}
