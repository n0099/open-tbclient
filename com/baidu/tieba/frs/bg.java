package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class bg extends y.a {
    TextView aSd;
    LinearLayout bEa;
    TextView bEb;
    HeadImageView bEc;
    TextView bEd;
    TextView bEe;
    public ViewStub bEf;
    public ViewGroup bEg;
    public ViewStub bEh;
    public ViewGroup bEi;

    public bg(View view) {
        super(view);
        this.bEa = (LinearLayout) view.findViewById(u.g.app_parent);
        this.aSd = (TextView) view.findViewById(u.g.app_name);
        this.bEd = (TextView) view.findViewById(u.g.app_desc);
        this.bEc = (HeadImageView) view.findViewById(u.g.app_icon);
        this.bEe = (TextView) view.findViewById(u.g.app_download);
        this.bEb = (TextView) view.findViewById(u.g.recommend_app);
        this.bEf = (ViewStub) view.findViewById(u.g.frs_item_adkiller_tip);
        this.bEh = (ViewStub) view.findViewById(u.g.item_adkiller_close);
    }
}
