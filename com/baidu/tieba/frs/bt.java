package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class bt extends y.a {
    TextView aOG;
    public ViewStub bih;
    public ViewGroup bii;
    public ViewStub bij;
    public ViewGroup bik;
    LinearLayout bin;
    TextView bio;
    HeadImageView bip;
    TextView biq;
    TextView bir;

    public bt(View view) {
        super(view);
        this.bin = (LinearLayout) view.findViewById(t.g.app_parent);
        this.aOG = (TextView) view.findViewById(t.g.app_name);
        this.biq = (TextView) view.findViewById(t.g.app_desc);
        this.bip = (HeadImageView) view.findViewById(t.g.app_icon);
        this.bir = (TextView) view.findViewById(t.g.app_download);
        this.bio = (TextView) view.findViewById(t.g.recommend_app);
        this.bih = (ViewStub) view.findViewById(t.g.frs_item_adkiller_tip);
        this.bij = (ViewStub) view.findViewById(t.g.item_adkiller_close);
    }
}
