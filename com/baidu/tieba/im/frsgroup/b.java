package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class b extends v.a {
    public View cRG;
    public View hkU;
    public TextView htN;
    public View rootView;

    public b(View view, View.OnClickListener onClickListener) {
        super(view);
        this.rootView = view;
        this.hkU = view.findViewById(R.id.divider_top);
        this.htN = (TextView) view.findViewById(R.id.create_item_text);
        this.cRG = view.findViewById(R.id.divider);
        this.rootView.setOnClickListener(onClickListener);
    }
}
