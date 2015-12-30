package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class b extends x.a {
    public View aHh;
    public int ahf;
    public TbImageView bIn;
    public TextView bIo;
    public TextView bIp;
    public TextView bIq;

    public b(View view) {
        super(view);
        this.ahf = 3;
        this.bIo = null;
        this.bIp = null;
        this.bIq = null;
        this.aHh = null;
        this.bIn = (TbImageView) view.findViewById(n.g.hot_topic_info_picture);
        this.bIo = (TextView) view.findViewById(n.g.hot_topic_info_title);
        this.bIp = (TextView) view.findViewById(n.g.hot_topic_info_threadcount);
        this.bIq = (TextView) view.findViewById(n.g.hot_topic_info_abstract);
        this.aHh = view.findViewById(n.g.divider_line);
    }
}
