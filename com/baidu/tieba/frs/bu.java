package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class bu extends x.a {
    TextView aSh;
    public ViewStub bmI;
    public ViewGroup bmJ;
    public ViewStub bmK;
    public ViewGroup bmL;
    LinearLayout bmO;
    TextView bmP;
    HeadImageView bmQ;
    TextView bmR;
    TextView bmS;

    public bu(View view) {
        super(view);
        this.bmO = (LinearLayout) view.findViewById(t.g.app_parent);
        this.aSh = (TextView) view.findViewById(t.g.app_name);
        this.bmR = (TextView) view.findViewById(t.g.app_desc);
        this.bmQ = (HeadImageView) view.findViewById(t.g.app_icon);
        this.bmS = (TextView) view.findViewById(t.g.app_download);
        this.bmP = (TextView) view.findViewById(t.g.recommend_app);
        this.bmI = (ViewStub) view.findViewById(t.g.frs_item_adkiller_tip);
        this.bmK = (ViewStub) view.findViewById(t.g.item_adkiller_close);
    }
}
