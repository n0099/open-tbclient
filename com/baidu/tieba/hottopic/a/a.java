package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class a extends af.a {
    public int aku;
    public TextView keE;
    public TextView keF;
    public TextView keG;
    public TextView keH;
    public View keI;
    public View keJ;
    public TbImageView keK;
    public LinearLayout keL;

    public a(View view) {
        super(view);
        this.aku = 3;
        this.keE = null;
        this.keF = null;
        this.keG = null;
        this.keH = null;
        this.keI = null;
        this.keJ = null;
        this.keK = null;
        this.keL = null;
        this.keE = (TextView) view.findViewById(R.id.topic_module);
        this.keG = (TextView) view.findViewById(R.id.topic_desc);
        this.keF = (TextView) view.findViewById(R.id.topic_title);
        this.keK = (TbImageView) view.findViewById(R.id.topic_pic);
        this.keI = view.findViewById(R.id.devide_line_top);
        this.keJ = view.findViewById(R.id.devide_line_bottom);
        this.keL = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
