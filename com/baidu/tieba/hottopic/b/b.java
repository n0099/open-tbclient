package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class b extends x.a {
    public View aFH;
    public int afY;
    public TbImageView bEJ;
    public TextView bEK;
    public TextView bEL;
    public TextView bEM;

    public b(View view) {
        super(view);
        this.afY = 3;
        this.bEK = null;
        this.bEL = null;
        this.bEM = null;
        this.aFH = null;
        this.bEJ = (TbImageView) view.findViewById(n.f.hot_topic_info_picture);
        this.bEK = (TextView) view.findViewById(n.f.hot_topic_info_title);
        this.bEL = (TextView) view.findViewById(n.f.hot_topic_info_threadcount);
        this.bEM = (TextView) view.findViewById(n.f.hot_topic_info_abstract);
        this.aFH = view.findViewById(n.f.divider_line);
    }
}
