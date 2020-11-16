package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class b extends af.a {
    public View eHl;
    public View jUB;
    public TextView kfv;
    public View rootView;

    public b(View view, View.OnClickListener onClickListener) {
        super(view);
        this.rootView = view;
        this.jUB = view.findViewById(R.id.divider_top);
        this.kfv = (TextView) view.findViewById(R.id.create_item_text);
        this.eHl = view.findViewById(R.id.divider);
        this.rootView.setOnClickListener(onClickListener);
    }
}
