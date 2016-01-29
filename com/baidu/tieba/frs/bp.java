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
public class bp extends x.a {
    public AppDownloadView bgO;
    public LinearLayout bhK;
    public View bhL;
    public HeadImageView bhM;
    public TextView bhN;
    public TextView bhO;
    public TextView bhP;
    public TextView bhQ;
    public TbImageView bhR;
    public TbImageView bhS;
    public TbImageView bhT;
    public TextView bhU;
    public ViewStub bhV;
    public ViewGroup bhW;
    public ViewStub bhX;
    public ViewGroup bhY;

    public bp(View view) {
        super(view);
        this.bhK = (LinearLayout) view.findViewById(t.g.frs_app_item_parent);
        this.bhM = (HeadImageView) view.findViewById(t.g.frs_app_multi_pic_icon);
        this.bhN = (TextView) view.findViewById(t.g.frs_app_multi_pic_name);
        this.bhO = (TextView) view.findViewById(t.g.frs_app_multi_pic_time);
        this.bgO = (AppDownloadView) view.findViewById(t.g.frs_app_download_view);
        this.bhP = (TextView) view.findViewById(t.g.frs_app_multi_pic_title);
        this.bhQ = (TextView) view.findViewById(t.g.frs_app_multi_pic_desc);
        this.bhR = (TbImageView) view.findViewById(t.g.frs_app_multi_pic_left);
        this.bhS = (TbImageView) view.findViewById(t.g.frs_app_multi_pic_center);
        this.bhT = (TbImageView) view.findViewById(t.g.frs_app_multi_pic_right);
        this.bhU = (TextView) view.findViewById(t.g.frs_app_download);
        this.bhL = view.findViewById(t.g.frs_app_multi_pic_container);
        this.bhV = (ViewStub) view.findViewById(t.g.frs_item_adkiller_tip);
        this.bhX = (ViewStub) view.findViewById(t.g.item_adkiller_close);
    }
}
