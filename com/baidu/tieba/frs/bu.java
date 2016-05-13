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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class bu extends y.a {
    static final /* synthetic */ boolean $assertionsDisabled;
    public int aej;
    public LinearLayout bhU;
    public HeadImageView bhW;
    public TextView bhX;
    public TextView bhY;
    public TextView bia;
    public ViewStub bih;
    public ViewGroup bii;
    public ViewStub bij;
    public ViewGroup bik;
    public AppDownloadView bis;
    public TbImageView bit;
    public TextView biu;

    static {
        $assertionsDisabled = !bu.class.desiredAssertionStatus();
    }

    public bu(View view) {
        super(view);
        this.aej = 3;
        if (!$assertionsDisabled && view == null) {
            throw new AssertionError();
        }
        this.bhU = (LinearLayout) view.findViewById(t.g.frs_app_item_parent);
        this.bhW = (HeadImageView) view.findViewById(t.g.frs_app_icon);
        this.bhX = (TextView) view.findViewById(t.g.frs_app_name);
        this.bhY = (TextView) view.findViewById(t.g.frs_app_time);
        this.bis = (AppDownloadView) view.findViewById(t.g.frs_app_download_view);
        this.bia = (TextView) view.findViewById(t.g.frs_app_desc);
        this.bit = (TbImageView) view.findViewById(t.g.frs_app_url);
        this.biu = (TextView) view.findViewById(t.g.frs_app_download);
        this.bih = (ViewStub) view.findViewById(t.g.frs_item_adkiller_tip);
        this.bij = (ViewStub) view.findViewById(t.g.item_adkiller_close);
        this.bis.uP();
    }
}
