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
    public TextView iLj;
    public TextView iLk;
    public TextView iLl;
    public TextView iLm;
    public View iLn;
    public View iLo;
    public TbImageView iLp;
    public LinearLayout iLq;

    public a(View view) {
        super(view);
        this.aho = 3;
        this.iLj = null;
        this.iLk = null;
        this.iLl = null;
        this.iLm = null;
        this.iLn = null;
        this.iLo = null;
        this.iLp = null;
        this.iLq = null;
        this.iLj = (TextView) view.findViewById(R.id.topic_module);
        this.iLl = (TextView) view.findViewById(R.id.topic_desc);
        this.iLk = (TextView) view.findViewById(R.id.topic_title);
        this.iLp = (TbImageView) view.findViewById(R.id.topic_pic);
        this.iLn = view.findViewById(R.id.devide_line_top);
        this.iLo = view.findViewById(R.id.devide_line_bottom);
        this.iLq = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
