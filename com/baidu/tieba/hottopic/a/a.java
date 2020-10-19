package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class a extends af.a {
    public int ajp;
    public TextView jxT;
    public TextView jxU;
    public TextView jxV;
    public TextView jxW;
    public View jxX;
    public View jxY;
    public TbImageView jxZ;
    public LinearLayout jya;

    public a(View view) {
        super(view);
        this.ajp = 3;
        this.jxT = null;
        this.jxU = null;
        this.jxV = null;
        this.jxW = null;
        this.jxX = null;
        this.jxY = null;
        this.jxZ = null;
        this.jya = null;
        this.jxT = (TextView) view.findViewById(R.id.topic_module);
        this.jxV = (TextView) view.findViewById(R.id.topic_desc);
        this.jxU = (TextView) view.findViewById(R.id.topic_title);
        this.jxZ = (TbImageView) view.findViewById(R.id.topic_pic);
        this.jxX = view.findViewById(R.id.devide_line_top);
        this.jxY = view.findViewById(R.id.devide_line_bottom);
        this.jya = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
