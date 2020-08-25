package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class b extends af.a {
    public View efZ;
    public View jdL;
    public TextView joJ;
    public View rootView;

    public b(View view, View.OnClickListener onClickListener) {
        super(view);
        this.rootView = view;
        this.jdL = view.findViewById(R.id.divider_top);
        this.joJ = (TextView) view.findViewById(R.id.create_item_text);
        this.efZ = view.findViewById(R.id.divider);
        this.rootView.setOnClickListener(onClickListener);
    }
}
