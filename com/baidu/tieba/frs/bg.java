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
    TextView aSZ;
    LinearLayout bFk;
    TextView bFl;
    HeadImageView bFm;
    TextView bFn;
    TextView bFo;
    public ViewStub bFp;
    public ViewGroup bFq;
    public ViewStub bFr;
    public ViewGroup bFs;

    public bg(View view) {
        super(view);
        this.bFk = (LinearLayout) view.findViewById(u.g.app_parent);
        this.aSZ = (TextView) view.findViewById(u.g.app_name);
        this.bFn = (TextView) view.findViewById(u.g.app_desc);
        this.bFm = (HeadImageView) view.findViewById(u.g.app_icon);
        this.bFo = (TextView) view.findViewById(u.g.app_download);
        this.bFl = (TextView) view.findViewById(u.g.recommend_app);
        this.bFp = (ViewStub) view.findViewById(u.g.frs_item_adkiller_tip);
        this.bFr = (ViewStub) view.findViewById(u.g.item_adkiller_close);
    }
}
