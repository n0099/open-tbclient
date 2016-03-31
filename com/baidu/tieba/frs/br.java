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
public class br extends x.a {
    public AppDownloadView blz;
    public TextView bmA;
    public TextView bmB;
    public TextView bmC;
    public TextView bmD;
    public TbImageView bmE;
    public TbImageView bmF;
    public TbImageView bmG;
    public TextView bmH;
    public ViewStub bmI;
    public ViewGroup bmJ;
    public ViewStub bmK;
    public ViewGroup bmL;
    public LinearLayout bmx;
    public View bmy;
    public HeadImageView bmz;

    public br(View view) {
        super(view);
        this.bmx = (LinearLayout) view.findViewById(t.g.frs_app_item_parent);
        this.bmz = (HeadImageView) view.findViewById(t.g.frs_app_multi_pic_icon);
        this.bmA = (TextView) view.findViewById(t.g.frs_app_multi_pic_name);
        this.bmB = (TextView) view.findViewById(t.g.frs_app_multi_pic_time);
        this.blz = (AppDownloadView) view.findViewById(t.g.frs_app_download_view);
        this.bmC = (TextView) view.findViewById(t.g.frs_app_multi_pic_title);
        this.bmD = (TextView) view.findViewById(t.g.frs_app_multi_pic_desc);
        this.bmE = (TbImageView) view.findViewById(t.g.frs_app_multi_pic_left);
        this.bmF = (TbImageView) view.findViewById(t.g.frs_app_multi_pic_center);
        this.bmG = (TbImageView) view.findViewById(t.g.frs_app_multi_pic_right);
        this.bmH = (TextView) view.findViewById(t.g.frs_app_download);
        this.bmy = view.findViewById(t.g.frs_app_multi_pic_container);
        this.bmI = (ViewStub) view.findViewById(t.g.frs_item_adkiller_tip);
        this.bmK = (ViewStub) view.findViewById(t.g.item_adkiller_close);
    }
}
