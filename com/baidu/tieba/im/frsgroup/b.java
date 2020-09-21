package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class b extends af.a {
    public View eis;
    public View jmy;
    public TextView jxs;
    public View rootView;

    public b(View view, View.OnClickListener onClickListener) {
        super(view);
        this.rootView = view;
        this.jmy = view.findViewById(R.id.divider_top);
        this.jxs = (TextView) view.findViewById(R.id.create_item_text);
        this.eis = view.findViewById(R.id.divider);
        this.rootView.setOnClickListener(onClickListener);
    }
}
