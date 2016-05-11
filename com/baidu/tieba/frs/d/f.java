package com.baidu.tieba.frs.d;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f extends y.a {
    TextView aGp;
    HeadImageView aLx;
    LinearLayout bsc;
    TbImageView bse;
    TextView bsf;
    TextView bsg;
    TextView bsh;
    TextView title;

    public f(View view) {
        super(view);
        this.bsc = (LinearLayout) view.findViewById(t.g.single_replenish_parent);
        this.aLx = (HeadImageView) view.findViewById(t.g.single_replenish_locality_head);
        this.aGp = (TextView) view.findViewById(t.g.single_replenish_locality_name);
        this.bsf = (TextView) view.findViewById(t.g.single_replenish_locality_sub);
        this.title = (TextView) view.findViewById(t.g.single_replenish_locality_title);
        this.bse = (TbImageView) view.findViewById(t.g.single_replenish_locality_pic);
        this.bsg = (TextView) view.findViewById(t.g.single_replenish_locality_brief);
        this.bsh = (TextView) view.findViewById(t.g.single_replenish_desc);
    }
}
