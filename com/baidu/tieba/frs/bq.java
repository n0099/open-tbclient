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
public class bq extends y.a {
    public AppDownloadView ZT;
    public LinearLayout bhU;
    public View bhV;
    public HeadImageView bhW;
    public TextView bhX;
    public TextView bhY;
    public TextView bhZ;
    public TextView bia;
    public TbImageView bib;
    public TbImageView bic;
    public TbImageView bie;
    public TextView bif;
    public ViewStub bih;
    public ViewGroup bii;
    public ViewStub bij;
    public ViewGroup bik;

    public bq(View view) {
        super(view);
        this.bhU = (LinearLayout) view.findViewById(t.g.frs_app_item_parent);
        this.bhW = (HeadImageView) view.findViewById(t.g.frs_app_multi_pic_icon);
        this.bhX = (TextView) view.findViewById(t.g.frs_app_multi_pic_name);
        this.bhY = (TextView) view.findViewById(t.g.frs_app_multi_pic_time);
        this.ZT = (AppDownloadView) view.findViewById(t.g.frs_app_download_view);
        this.bhZ = (TextView) view.findViewById(t.g.frs_app_multi_pic_title);
        this.bia = (TextView) view.findViewById(t.g.frs_app_multi_pic_desc);
        this.bib = (TbImageView) view.findViewById(t.g.frs_app_multi_pic_left);
        this.bic = (TbImageView) view.findViewById(t.g.frs_app_multi_pic_center);
        this.bie = (TbImageView) view.findViewById(t.g.frs_app_multi_pic_right);
        this.bif = (TextView) view.findViewById(t.g.frs_app_download);
        this.bhV = view.findViewById(t.g.frs_app_multi_pic_container);
        this.bih = (ViewStub) view.findViewById(t.g.frs_item_adkiller_tip);
        this.bij = (ViewStub) view.findViewById(t.g.item_adkiller_close);
        this.ZT.uP();
    }
}
