package com.baidu.tieba.frs.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class f extends x.a {
    TextView aGr;
    HeadImageView aLn;
    TextView ahk;
    TbImageView blA;
    TextView blB;
    TextView blC;
    TextView blD;
    LinearLayout bly;

    public f(View view) {
        super(view);
        this.bly = (LinearLayout) view.findViewById(n.g.single_replenish_parent);
        this.aLn = (HeadImageView) view.findViewById(n.g.single_replenish_locality_head);
        this.aGr = (TextView) view.findViewById(n.g.single_replenish_locality_name);
        this.blB = (TextView) view.findViewById(n.g.single_replenish_locality_sub);
        this.ahk = (TextView) view.findViewById(n.g.single_replenish_locality_title);
        this.blA = (TbImageView) view.findViewById(n.g.single_replenish_locality_pic);
        this.blC = (TextView) view.findViewById(n.g.single_replenish_locality_brief);
        this.blD = (TextView) view.findViewById(n.g.single_replenish_desc);
    }
}
