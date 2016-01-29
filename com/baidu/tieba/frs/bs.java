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
public class bs extends x.a {
    TextView aPr;
    public ViewStub bhV;
    public ViewGroup bhW;
    public ViewStub bhX;
    public ViewGroup bhY;
    LinearLayout bib;
    TextView bic;
    HeadImageView bie;
    TextView bif;
    TextView bih;

    public bs(View view) {
        super(view);
        this.bib = (LinearLayout) view.findViewById(t.g.app_parent);
        this.aPr = (TextView) view.findViewById(t.g.app_name);
        this.bif = (TextView) view.findViewById(t.g.app_desc);
        this.bie = (HeadImageView) view.findViewById(t.g.app_icon);
        this.bih = (TextView) view.findViewById(t.g.app_download);
        this.bic = (TextView) view.findViewById(t.g.recommend_app);
        this.bhV = (ViewStub) view.findViewById(t.g.frs_item_adkiller_tip);
        this.bhX = (ViewStub) view.findViewById(t.g.item_adkiller_close);
    }
}
