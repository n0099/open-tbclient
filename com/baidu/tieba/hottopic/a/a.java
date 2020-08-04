package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class a extends ad.a {
    public int aho;
    public TextView iLl;
    public TextView iLm;
    public TextView iLn;
    public TextView iLo;
    public View iLp;
    public View iLq;
    public TbImageView iLr;
    public LinearLayout iLs;

    public a(View view) {
        super(view);
        this.aho = 3;
        this.iLl = null;
        this.iLm = null;
        this.iLn = null;
        this.iLo = null;
        this.iLp = null;
        this.iLq = null;
        this.iLr = null;
        this.iLs = null;
        this.iLl = (TextView) view.findViewById(R.id.topic_module);
        this.iLn = (TextView) view.findViewById(R.id.topic_desc);
        this.iLm = (TextView) view.findViewById(R.id.topic_title);
        this.iLr = (TbImageView) view.findViewById(R.id.topic_pic);
        this.iLp = view.findViewById(R.id.devide_line_top);
        this.iLq = view.findViewById(R.id.devide_line_bottom);
        this.iLs = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
