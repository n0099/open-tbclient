package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class b extends af.a {
    public View eIO;
    public View jTR;
    public TextView keL;
    public View rootView;

    public b(View view, View.OnClickListener onClickListener) {
        super(view);
        this.rootView = view;
        this.jTR = view.findViewById(R.id.divider_top);
        this.keL = (TextView) view.findViewById(R.id.create_item_text);
        this.eIO = view.findViewById(R.id.divider);
        this.rootView.setOnClickListener(onClickListener);
    }
}
