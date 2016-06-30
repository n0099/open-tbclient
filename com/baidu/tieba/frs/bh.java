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
    public int aeK;
    public ViewStub bEf;
    public ViewGroup bEg;
    public ViewStub bEh;
    public ViewGroup bEi;
    public LinearLayout bEj;
    public HeadImageView bEk;
    public TextView bEl;
    public TextView bEm;
    public AppDownloadView bEn;
    public TextView bEo;
    public TbImageView bEp;
    public TextView bEq;

    static {
        $assertionsDisabled = !bh.class.desiredAssertionStatus();
    }

    public bh(View view) {
        super(view);
        this.aeK = 3;
        if (!$assertionsDisabled && view == null) {
            throw new AssertionError();
        }
        this.bEj = (LinearLayout) view.findViewById(u.g.frs_app_item_parent);
        this.bEk = (HeadImageView) view.findViewById(u.g.frs_app_icon);
        this.bEl = (TextView) view.findViewById(u.g.frs_app_name);
        this.bEm = (TextView) view.findViewById(u.g.frs_app_time);
        this.bEn = (AppDownloadView) view.findViewById(u.g.frs_app_download_view);
        this.bEo = (TextView) view.findViewById(u.g.frs_app_desc);
        this.bEp = (TbImageView) view.findViewById(u.g.frs_app_url);
        this.bEq = (TextView) view.findViewById(u.g.frs_app_download);
        this.bEf = (ViewStub) view.findViewById(u.g.frs_item_adkiller_tip);
        this.bEh = (ViewStub) view.findViewById(u.g.item_adkiller_close);
        this.bEn.uO();
    }
}
