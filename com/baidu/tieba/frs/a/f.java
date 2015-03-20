package com.baidu.tieba.frs.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class f extends am {
    TextView aFs;
    LinearLayout aMW;
    TextView aMX;
    TbImageView aMY;
    TextView aMZ;
    TextView aNa;
    TextView ahr;
    HeadImageView azr;

    public f(View view) {
        super(view);
        this.aMW = (LinearLayout) view.findViewById(v.single_replenish_parent);
        this.azr = (HeadImageView) view.findViewById(v.single_replenish_locality_head);
        this.aFs = (TextView) view.findViewById(v.single_replenish_locality_name);
        this.aMX = (TextView) view.findViewById(v.single_replenish_locality_sub);
        this.ahr = (TextView) view.findViewById(v.single_replenish_locality_title);
        this.aMY = (TbImageView) view.findViewById(v.single_replenish_locality_pic);
        this.aMZ = (TextView) view.findViewById(v.single_replenish_locality_brief);
        this.aNa = (TextView) view.findViewById(v.single_replenish_desc);
    }
}
