package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b extends v.a {
    public View cfh;
    public TextView gFJ;
    public View gwM;
    public View rootView;

    public b(View view, View.OnClickListener onClickListener) {
        super(view);
        this.rootView = view;
        this.gwM = view.findViewById(R.id.divider_top);
        this.gFJ = (TextView) view.findViewById(R.id.create_item_text);
        this.cfh = view.findViewById(R.id.divider);
        this.rootView.setOnClickListener(onClickListener);
    }
}
