package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a extends ad.a {
    public int ahx;
    public TextView iFf;
    public TextView iFg;
    public TextView iFh;
    public TextView iFi;
    public View iFj;
    public View iFk;
    public TbImageView iFl;
    public LinearLayout iFm;

    public a(View view) {
        super(view);
        this.ahx = 3;
        this.iFf = null;
        this.iFg = null;
        this.iFh = null;
        this.iFi = null;
        this.iFj = null;
        this.iFk = null;
        this.iFl = null;
        this.iFm = null;
        this.iFf = (TextView) view.findViewById(R.id.topic_module);
        this.iFh = (TextView) view.findViewById(R.id.topic_desc);
        this.iFg = (TextView) view.findViewById(R.id.topic_title);
        this.iFl = (TbImageView) view.findViewById(R.id.topic_pic);
        this.iFj = view.findViewById(R.id.devide_line_top);
        this.iFk = view.findViewById(R.id.devide_line_bottom);
        this.iFm = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
