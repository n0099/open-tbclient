package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class a extends af.a {
    public int aiX;
    public TextView jiV;
    public TextView jiW;
    public TextView jiX;
    public TextView jiY;
    public View jiZ;
    public View jja;
    public TbImageView jjb;
    public LinearLayout jjc;

    public a(View view) {
        super(view);
        this.aiX = 3;
        this.jiV = null;
        this.jiW = null;
        this.jiX = null;
        this.jiY = null;
        this.jiZ = null;
        this.jja = null;
        this.jjb = null;
        this.jjc = null;
        this.jiV = (TextView) view.findViewById(R.id.topic_module);
        this.jiX = (TextView) view.findViewById(R.id.topic_desc);
        this.jiW = (TextView) view.findViewById(R.id.topic_title);
        this.jjb = (TbImageView) view.findViewById(R.id.topic_pic);
        this.jiZ = view.findViewById(R.id.devide_line_top);
        this.jja = view.findViewById(R.id.devide_line_bottom);
        this.jjc = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
