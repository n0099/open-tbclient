package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class b extends af.a {
    public View euA;
    public View jBv;
    public TextView jMp;
    public View rootView;

    public b(View view, View.OnClickListener onClickListener) {
        super(view);
        this.rootView = view;
        this.jBv = view.findViewById(R.id.divider_top);
        this.jMp = (TextView) view.findViewById(R.id.create_item_text);
        this.euA = view.findViewById(R.id.divider);
        this.rootView.setOnClickListener(onClickListener);
    }
}
