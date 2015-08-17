package com.baidu.tieba.frs.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class f extends x.a {
    HeadImageView aIG;
    TextView aPi;
    TextView anH;
    LinearLayout ban;
    TextView bao;
    TbImageView bap;
    TextView baq;
    TextView bas;

    public f(View view) {
        super(view);
        this.ban = (LinearLayout) view.findViewById(i.f.single_replenish_parent);
        this.aIG = (HeadImageView) view.findViewById(i.f.single_replenish_locality_head);
        this.aPi = (TextView) view.findViewById(i.f.single_replenish_locality_name);
        this.bao = (TextView) view.findViewById(i.f.single_replenish_locality_sub);
        this.anH = (TextView) view.findViewById(i.f.single_replenish_locality_title);
        this.bap = (TbImageView) view.findViewById(i.f.single_replenish_locality_pic);
        this.baq = (TextView) view.findViewById(i.f.single_replenish_locality_brief);
        this.bas = (TextView) view.findViewById(i.f.single_replenish_desc);
    }
}
