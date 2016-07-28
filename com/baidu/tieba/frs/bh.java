package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.AppDownloadView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class bh extends y.a {
    static final /* synthetic */ boolean $assertionsDisabled;
    public int afy;
    public TextView bFA;
    public ViewStub bFp;
    public ViewGroup bFq;
    public ViewStub bFr;
    public ViewGroup bFs;
    public LinearLayout bFt;
    public HeadImageView bFu;
    public TextView bFv;
    public TextView bFw;
    public AppDownloadView bFx;
    public TextView bFy;
    public TbImageView bFz;

    static {
        $assertionsDisabled = !bh.class.desiredAssertionStatus();
    }

    public bh(View view) {
        super(view);
        this.afy = 3;
        if (!$assertionsDisabled && view == null) {
            throw new AssertionError();
        }
        this.bFt = (LinearLayout) view.findViewById(u.g.frs_app_item_parent);
        this.bFu = (HeadImageView) view.findViewById(u.g.frs_app_icon);
        this.bFv = (TextView) view.findViewById(u.g.frs_app_name);
        this.bFw = (TextView) view.findViewById(u.g.frs_app_time);
        this.bFx = (AppDownloadView) view.findViewById(u.g.frs_app_download_view);
        this.bFy = (TextView) view.findViewById(u.g.frs_app_desc);
        this.bFz = (TbImageView) view.findViewById(u.g.frs_app_url);
        this.bFA = (TextView) view.findViewById(u.g.frs_app_download);
        this.bFp = (ViewStub) view.findViewById(u.g.frs_item_adkiller_tip);
        this.bFr = (ViewStub) view.findViewById(u.g.item_adkiller_close);
        this.bFx.uO();
    }
}
