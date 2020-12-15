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
    public TextView keG;
    public TextView keH;
    public TextView keI;
    public TextView keJ;
    public View keK;
    public View keL;
    public TbImageView keM;
    public LinearLayout keN;

    public a(View view) {
        super(view);
        this.aku = 3;
        this.keG = null;
        this.keH = null;
        this.keI = null;
        this.keJ = null;
        this.keK = null;
        this.keL = null;
        this.keM = null;
        this.keN = null;
        this.keG = (TextView) view.findViewById(R.id.topic_module);
        this.keI = (TextView) view.findViewById(R.id.topic_desc);
        this.keH = (TextView) view.findViewById(R.id.topic_title);
        this.keM = (TbImageView) view.findViewById(R.id.topic_pic);
        this.keK = view.findViewById(R.id.devide_line_top);
        this.keL = view.findViewById(R.id.devide_line_bottom);
        this.keN = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
