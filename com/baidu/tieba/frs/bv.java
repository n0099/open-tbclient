package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.AppDownloadView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class bv extends x.a {
    static final /* synthetic */ boolean $assertionsDisabled;
    public int aik;
    public TextView bmA;
    public TextView bmB;
    public TextView bmD;
    public ViewStub bmI;
    public ViewGroup bmJ;
    public ViewStub bmK;
    public ViewGroup bmL;
    public AppDownloadView bmT;
    public TbImageView bmU;
    public TextView bmV;
    public LinearLayout bmx;
    public HeadImageView bmz;

    static {
        $assertionsDisabled = !bv.class.desiredAssertionStatus();
    }

    public bv(View view) {
        super(view);
        this.aik = 3;
        if (!$assertionsDisabled && view == null) {
            throw new AssertionError();
        }
        this.bmx = (LinearLayout) view.findViewById(t.g.frs_app_item_parent);
        this.bmz = (HeadImageView) view.findViewById(t.g.frs_app_icon);
        this.bmA = (TextView) view.findViewById(t.g.frs_app_name);
        this.bmB = (TextView) view.findViewById(t.g.frs_app_time);
        this.bmT = (AppDownloadView) view.findViewById(t.g.frs_app_download_view);
        this.bmD = (TextView) view.findViewById(t.g.frs_app_desc);
        this.bmU = (TbImageView) view.findViewById(t.g.frs_app_url);
        this.bmV = (TextView) view.findViewById(t.g.frs_app_download);
        this.bmI = (ViewStub) view.findViewById(t.g.frs_item_adkiller_tip);
        this.bmK = (ViewStub) view.findViewById(t.g.item_adkiller_close);
    }
}
