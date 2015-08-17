package com.baidu.tieba.frs.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class d extends x.a {
    HeadImageView aIG;
    TextView aPi;
    TextView anH;
    LinearLayout ban;
    TextView bao;
    TbImageView bap;
    TextView baq;

    public d(View view) {
        super(view);
        this.ban = (LinearLayout) view.findViewById(i.f.normal_locality_parent);
        this.aIG = (HeadImageView) view.findViewById(i.f.normal_locality_head);
        this.aPi = (TextView) view.findViewById(i.f.normal_locality_name);
        this.bao = (TextView) view.findViewById(i.f.normal_locality_sub);
        this.anH = (TextView) view.findViewById(i.f.normal_locality_title);
        this.bap = (TbImageView) view.findViewById(i.f.normal_locality_pic);
        this.baq = (TextView) view.findViewById(i.f.normal_locality_brief);
    }
}
