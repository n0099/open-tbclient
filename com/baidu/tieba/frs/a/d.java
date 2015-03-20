package com.baidu.tieba.frs.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class d extends am {
    TextView aFs;
    LinearLayout aMW;
    TextView aMX;
    TbImageView aMY;
    TextView aMZ;
    TextView ahr;
    HeadImageView azr;

    public d(View view) {
        super(view);
        this.aMW = (LinearLayout) view.findViewById(v.normal_locality_parent);
        this.azr = (HeadImageView) view.findViewById(v.normal_locality_head);
        this.aFs = (TextView) view.findViewById(v.normal_locality_name);
        this.aMX = (TextView) view.findViewById(v.normal_locality_sub);
        this.ahr = (TextView) view.findViewById(v.normal_locality_title);
        this.aMY = (TbImageView) view.findViewById(v.normal_locality_pic);
        this.aMZ = (TextView) view.findViewById(v.normal_locality_brief);
    }
}
