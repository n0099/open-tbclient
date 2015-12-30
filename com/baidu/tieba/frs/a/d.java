package com.baidu.tieba.frs.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class d extends x.a {
    TextView aGr;
    HeadImageView aLn;
    TextView ahk;
    TbImageView blA;
    TextView blB;
    TextView blC;
    LinearLayout bly;

    public d(View view) {
        super(view);
        this.bly = (LinearLayout) view.findViewById(n.g.normal_locality_parent);
        this.aLn = (HeadImageView) view.findViewById(n.g.normal_locality_head);
        this.aGr = (TextView) view.findViewById(n.g.normal_locality_name);
        this.blB = (TextView) view.findViewById(n.g.normal_locality_sub);
        this.ahk = (TextView) view.findViewById(n.g.normal_locality_title);
        this.blA = (TbImageView) view.findViewById(n.g.normal_locality_pic);
        this.blC = (TextView) view.findViewById(n.g.normal_locality_brief);
    }
}
