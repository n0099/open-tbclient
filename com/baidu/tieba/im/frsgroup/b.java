package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends y.a {
    public View dvw;
    public View ica;
    public TextView ikX;
    public View rootView;

    public b(View view, View.OnClickListener onClickListener) {
        super(view);
        this.rootView = view;
        this.ica = view.findViewById(R.id.divider_top);
        this.ikX = (TextView) view.findViewById(R.id.create_item_text);
        this.dvw = view.findViewById(R.id.divider);
        this.rootView.setOnClickListener(onClickListener);
    }
}
